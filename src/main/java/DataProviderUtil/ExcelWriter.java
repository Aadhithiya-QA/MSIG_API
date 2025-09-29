package DataProviderUtil;

import FrameWork.FrameWorkPilot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class ExcelWriter {

    static Logger excelDataWriterLog = LogManager.getLogger(ExcelWriter.class);

    public static synchronized void excelWriter(String columnName, String result, String... rowToWrite) {

        // Creating file object of existing Excel file
        File xlsxFile = new File(FrameWorkPilot.getDynamicPath("outputExcel"));

        // Creating input stream
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(xlsxFile))) {

            // Creating workbook from input stream
            try (Workbook workbook = WorkbookFactory.create(inputStream)) {

                // Split For Cognitive Complexity
                excelWriterHelper(workbook, columnName, result, rowToWrite);

                // Crating output stream and writing the updated workbook
                try (FileOutputStream os = new FileOutputStream(xlsxFile)) {
                    workbook.write(os);
                    os.flush();
//                    excelDataWriterLog.info("Excel file has been updated successfully.");

                }

            }

        } catch (IOException e) {
            excelDataWriterLog.info("Exception while updating an existing excel file. ---> {}", e.getMessage());
        }

    }

    private static synchronized void excelWriterHelper(Workbook workbook, String columnName, String result, String... rowToWrite) {

        // Variables For Flagging
        DataFormatter formatter = new DataFormatter();

        // Reading first sheet of Excel file
        Sheet sheet = null;

        sheet= workbook.getSheet("Main");

        assert sheet!= null;
        // Iterating Excel to update
        for (Row row : sheet) {
            for (Cell cell : row) {

                // Get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                String text = formatter.formatCellValue(cell);

                // Is it an exact match?
                if (columnName.equals(text)) {
                    Row row1 = rowToWrite.length > 0 ? sheet.getRow(Integer.parseInt(rowToWrite[0])) : sheet.getRow(Integer.parseInt(Thread.currentThread().getName()));
                    // Check if the cell has existing value
                    if (formatter.formatCellValue(row1.getCell(cell.getColumnIndex())).isEmpty()) {
                        // Enter Values
                        row1.createCell(cell.getColumnIndex()).setCellValue(result);
//                        excelDataWriterLog.info("Updated {} to excel : {}.", columnName, result);
                    } else {
                        // Append Values
                        String existingValue = formatter.formatCellValue(row1.getCell(cell.getColumnIndex()));
                        row1.createCell(cell.getColumnIndex()).setCellValue(existingValue.concat("\n").concat(result));
//                        excelDataWriterLog.info("Appended {} with {} to excel.", existingValue, result);
                    }
                    break;
                }

            }
        }

    }

}
