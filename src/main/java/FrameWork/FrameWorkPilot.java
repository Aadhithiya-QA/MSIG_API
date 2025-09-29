package FrameWork;

import Utilities.PropertyUtils;

import java.text.SimpleDateFormat;

public class FrameWorkPilot {

    private FrameWorkPilot(){
    }

    static String userDir = System.getProperty("user.dir");
    static String configPath = userDir + "//src//main//resources//configuration.properties";
    static String timeStamp = new SimpleDateFormat("E,dd_MM_yyyy.HH.mm").format(new java.util.Date());
    static String resultDir = userDir + "\\test-output\\" + timeStamp;
    static String testDataSheet = userDir + PropertyUtils.getValue("ExcelLocation");
    static String outputExcel = userDir + "\\test-output\\" + timeStamp+"\\MSIGSanityOutput.xlsx";

    public static synchronized String getDynamicPath(String literal) {
        switch (literal) {
            case "Config" -> {
                return configPath;
            }
            case "resultDir" -> {
                return resultDir;
            }
            case "testDataSheet" -> {
                return testDataSheet;
            }
            case "outputExcel" -> {
                return outputExcel;
            }
            default -> {
                return "Not Valid call to get Path Method";
            }
        }
    }
}
