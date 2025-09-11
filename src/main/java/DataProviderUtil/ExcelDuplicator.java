package DataProviderUtil;

import FrameWork.FrameWorkPilot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelDuplicator {

    private ExcelDuplicator() {
    }

    static Logger cpyLog = LogManager.getLogger(ExcelDuplicator.class);

    public static void DuplicateWorkbookS(String sourceExcelLocation,String destinationExcelLocation){

        String targetStreamLine;

        if(sourceExcelLocation.equalsIgnoreCase("testDataSheet")){
            targetStreamLine= FrameWorkPilot.getDynamicPath("outputExcel");
        } else {
            targetStreamLine=destinationExcelLocation;
        }
        //  IOUtils.setByteArrayMaxOverride(200000000);

        try (FileInputStream sourceStream = new FileInputStream(FrameWorkPilot.getDynamicPath(sourceExcelLocation));
             FileOutputStream targetStream = new FileOutputStream(targetStreamLine);
             Workbook workbook = WorkbookFactory.create(sourceStream)) {

            workbook.write(targetStream);
            if(sourceExcelLocation.equalsIgnoreCase("testDataSheet")){
                cpyLog.info("Output Excel Duplication Done Successfully");
            }else {
                cpyLog.info("Error !!!!!");
            }


        } catch (Exception e) {
            if(sourceExcelLocation.equalsIgnoreCase("testDataSheet")){
                cpyLog.error("Error in duplicating the Output Excel file");
            }else {
                cpyLog.error("Error !!!!!");
            }

        }

    }

}
