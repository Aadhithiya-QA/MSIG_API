package FrameWork;

import java.text.SimpleDateFormat;

public class FrameWorkPilot {

    private FrameWorkPilot(){
    }

    static String userDir = System.getProperty("user.dir");
    static String configPath = userDir + "//src//main//resources//configuration.properties";
    static String timeStamp = new SimpleDateFormat("E,dd_MM_yyyy.HH.mm").format(new java.util.Date());
    static String resultDir = userDir + "\\test-output\\" + timeStamp;
    static String testDataSheet = userDir + "\\src\\main\\resources\\MSIGInputExcel.xlsx";
    static String outputExcel = userDir + "\\test-output\\" + timeStamp+"\\MSIGSanityOutput.xlsx";
//    static String mtc_tgl_ntl_rw= userDir + "\\src\\main\\resources\\MTC TGL NTL Rating Workbook.xlsx";
//    static String apd_rw=userDir + "\\src\\main\\resources\\APD Rating Rating Workbook.xlsx";
//    static String multiSublineRater=userDir+"\\src\\main\\resources\\CoverWhaleMultiSublineRater1.16.xlsx";
//    static String al_cw_rw=userDir+"\\src\\main\\resources\\AL Rating - Countrywide Plan.xlsx";
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
//            case "mtc_tgl_ntl_rw"->{return mtc_tgl_ntl_rw;}
//            case "apd_rw"->{return apd_rw;}
//            case "al_cw_rw"->{return al_cw_rw;}
//            case"multiSublineRater"->{return multiSublineRater;}
            default -> {
                return "Not Valid call to get Path Method";
            }
        }
    }
}
