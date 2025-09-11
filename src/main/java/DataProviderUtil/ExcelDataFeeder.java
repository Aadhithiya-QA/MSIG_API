package DataProviderUtil;

import FrameWork.FrameWorkPilot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataFeeder {

    static Logger excelDataFeederLog = LogManager.getLogger(ExcelDataFeeder.class);

    @DataProvider(name = "MSIGFlow", parallel = true, indices = {0})
    public static Object[][] mainDataFromExcel() {

        Object[][] objData = new Object[0][];

        try (FileInputStream fileInputStream =
                     new FileInputStream(FrameWorkPilot.getDynamicPath("testDataSheet"))) {

            Workbook workbook = new XSSFWorkbook(fileInputStream);

            // ✅ Pick the first sheet (or change to workbook.getSheet("Sheet1"))
            Sheet sheet = workbook.getSheetAt(0);

            if (sheet == null) {
                throw new RuntimeException("❌ No sheet found in Excel file: " +
                        FrameWorkPilot.getDynamicPath("testDataSheet"));
            }

            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();

            objData = new Object[rowCount][1];

            DataFormatter dft = new DataFormatter();
            dft.setUseCachedValuesForFormulaCells(true);

            for (int i = 0; i < rowCount; i++) {
                Map<Object, Object> mapData = new HashMap<>();

                for (int j = 0; j < columnCount; j++) {
                    Cell keyCell = sheet.getRow(0).getCell(j);
                    String tempKey = dft.formatCellValue(keyCell);

                    Cell valueCell = sheet.getRow(i + 1).getCell(j);
                    String tempValue = dft.formatCellValue(valueCell);

                    mapData.put(tempKey, tempValue);
                }
                objData[i][0] = mapData;
            }

            workbook.close();

        } catch (IOException e) {
            excelDataFeederLog.error("❌ Exception while accessing Excel file: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }

        return objData;
    }
}
