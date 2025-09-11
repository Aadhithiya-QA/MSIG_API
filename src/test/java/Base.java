import DataProviderUtil.ExcelDuplicator;
import DataProviderUtil.ExcelWriter;
import FrameWork.FrameWorkPilot;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class Base {

    @BeforeSuite
    public void prerequisite(){
        try {
            FileUtils.forceMkdir(new File(FrameWorkPilot.getDynamicPath("resultDir")));
        }catch (Exception E){
            E.printStackTrace();
        }

        // Cloning the input sheet
//        ExcelDuplicator.DuplicateWorkbookS("testDataSheet","");

    }

    @AfterMethod
    public synchronized void checkForFail(ITestResult result) {

        // To get the Map which is passed in @Test method
        //Object[] parameters = result.getParameters();

       /* if (result.getStatus() == ITestResult.SUCCESS) {
            ExcelWriter.excelWriter("Execution Status","Pass",Thread.currentThread().getName());
        } else if (result.getStatus() == ITestResult.FAILURE) {
            ExcelWriter.excelWriter("Execution Status","Fail",Thread.currentThread().getName());
        }*/

    }

}
