package DataProviderUtil;

import FrameWork.FrameWorkPilot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelDataFeeder {

    static Logger excelDataFeederLog = LogManager.getLogger(ExcelDataFeeder.class);
//,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
    @DataProvider(name = "MSIGFlow", parallel = true)
    public static Object[][] mainDataFromExcel() {

        List<Map<String, Object>> allIterations = new ArrayList<>();

        try (FileInputStream fileInputStream =
                     new FileInputStream(FrameWorkPilot.getDynamicPath("testDataSheet"));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet mainSheet = workbook.getSheet("Main");
            if (mainSheet == null) {
                throw new RuntimeException("❌ 'Main' sheet missing in Excel!");
            }

            int mainRowCount = mainSheet.getLastRowNum();
            int mainColumnCount = mainSheet.getRow(0).getLastCellNum();

            // Loop through all data rows (start from 1 to skip header)
            for (int i = 1; i <= mainRowCount; i++) {
                Row row = mainSheet.getRow(i);
                if (row == null) continue;

                Map<String, Object> rawMainRow = new HashMap<>();
                for (int j = 0; j < mainColumnCount; j++) {
                    String key = getCellStringValue(mainSheet.getRow(0).getCell(j));
                    String value = getCellStringValue(row.getCell(j));
                    rawMainRow.put(key, value);

                    // Log for debugging empty Yes/No cells
//                    excelDataFeederLog.info("Row {} Column {} → Key: '{}' Value: '{}'", i, j, key, value.isEmpty() ? "<EMPTY>" : value);
                }

                String iteration = String.valueOf(
                        rawMainRow.getOrDefault("Iteration", String.valueOf(i))
                );

                Map<String, Object> iterationData = new HashMap<>();
                iterationData.put("Iteration", iteration);
                iterationData.put("Main", MapUtils.toStringMap(rawMainRow));

                // Related sheets
                iterationData.put("Policy lvl", extractRowsForIteration(workbook.getSheet("Policy lvl"), iteration));
                iterationData.put("Location lvl", extractRowsForIteration(workbook.getSheet("Location lvl"), iteration));
                iterationData.put("Classification lvl", extractRowsForIteration(workbook.getSheet("Classification lvl"), iteration));

                allIterations.add(iterationData);
            }

        } catch (IOException e) {
            excelDataFeederLog.error("❌ Exception while accessing Excel file: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }

        // Convert to Object[][] for TestNG
        Object[][] objData = new Object[allIterations.size()][1];
        for (int i = 0; i < allIterations.size(); i++) {
            objData[i][0] = allIterations.get(i);
        }
        return objData;
    }

    // --- Utility to extract rows for a given iteration ---
    private static List<Map<String, String>> extractRowsForIteration(Sheet sheet, String iteration) {
        List<Map<String, String>> rows = new ArrayList<>();
        if (sheet == null) return rows;

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        for (int i = 1; i <= rowCount; i++) { // start from 1 to skip header
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Map<String, String> rowMap = new HashMap<>();
            for (int j = 0; j < colCount; j++) {
                String key = getCellStringValue(sheet.getRow(0).getCell(j));
                String value = getCellStringValue(row.getCell(j));
                rowMap.put(key, value);
            }

            // Only keep rows with matching Iteration
            String iterValue = rowMap.getOrDefault("Iteration", "").trim();
            if (iteration.trim().equals(iterValue)) {
                rows.add(rowMap);
            }
        }
        return rows;
    }

    // --- Utility: Get cell value as string safely ---
    private static String getCellStringValue(Cell cell) {
        if (cell == null) return "";
        DataFormatter formatter = new DataFormatter();
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case BOOLEAN:
                return cell.getBooleanCellValue() ? "Yes" : "No";
            case NUMERIC:
                // Always use DataFormatter for numeric (handles %, decimals, dates etc.)
                return formatter.formatCellValue(cell).trim();
            case FORMULA:
                // Evaluate & format
                return formatter.formatCellValue(cell).trim();
            case BLANK:
            default:
                return "";
        }
    }
}
