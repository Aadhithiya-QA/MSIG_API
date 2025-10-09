import CommonFunctions.CarrierExtractor;

import CommonFunctions.ParamGetter;
import DataProviderUtil.ExcelDataFeeder;
import DataProviderUtil.ExcelWriter;
import FrameWork.FrameWorkPilot;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;


public class MSIGE2E extends Base {

    private static final Logger log = LogManager.getLogger(MSIGE2E.class);

    @Test(dataProvider = "MSIGFlow", dataProviderClass = ExcelDataFeeder.class)
    public void MSIGSanity(Map<String, Object> data) throws InterruptedException {
        Map<String, String> main = (Map<String, String>) data.get("Main");

        Thread.currentThread().setName(String.valueOf(main.get("Iteration")));

        try {
            FileUtils.forceMkdir(new File(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + main.get("Iteration") + "\\Request\\"));
            FileUtils.forceMkdir(new File(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + main.get("Iteration") + "\\Response\\"));
            FileUtils.forceMkdir(new File(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + main.get("Iteration") + "\\PDF\\"));
        } catch (Exception E) {
            E.printStackTrace();
        }

        //Save Submission
        SaveSubmissionExec saveSubmissionExec = new SaveSubmissionExec();
        saveSubmissionExec.ExecSaveSubmission(data);
        String SubID = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + main.get("Iteration") + "\\Response\\SaveSubmission Response.txt", "ID");
        String SubNumber = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + main.get("Iteration") + "\\Response\\SaveSubmission Response.txt", "SubmissionNumber");
        log.info("Submission ID ==== {}", SubID);
        //Get Submission
        GetSubmissionExec getSubmissionExec = new GetSubmissionExec();
        getSubmissionExec.ExecGetSubmission(SubID, main);
        String AccountID = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + main.get("Iteration") + "\\Response\\GetSubmission Response.txt", "Account.ID");
        log.info("Account ID ==== {}", AccountID);
        //Get Available Market
        GetAvailablemarketExec getAvailablemarketExec = new GetAvailablemarketExec();
        getAvailablemarketExec.ExecGetAvailableMarket(main, SubID);
        // Build Preferred Carrier
        String carrierBlock = CarrierExtractor.buildPreferredCarrierBlock(main.get("Carrier"), main.get("Iteration"));
//        log.info("Carrier{}",carrierBlock);
        //Invoke Rate and Form
        InvokeRateandFormsExec invokeRateandFormsExec = new InvokeRateandFormsExec();
        invokeRateandFormsExec.ExecInvokeRateandForms(main, SubID, carrierBlock);

        //Find Submission
       /* FindSubmissionExec findSubmissionExec = new FindSubmissionExec();
        findSubmissionExec.ExecFindSubmission(SubNumber, main);
        //Find Account
        FindAccountExec findAccountExec = new FindAccountExec();
        findAccountExec.ExecFindAccount(main, AccountID);
        //Lapse Submission
        LapseandDeclineSubmissionExec lapseandDeclineSubmissionExec = new LapseandDeclineSubmissionExec();
        //Decline Submission
        lapseandDeclineSubmissionExec.ExecDeclineSubmission(main, SubID);
        //Reactivate Submission
        ReactivateSubmissionExec reactivateSubmissionExec = new ReactivateSubmissionExec();
        reactivateSubmissionExec.ExecReactivateSubmission(main, SubID);
        //Refer Submission
        ReferSubmissionExec referSubmissionExec = new ReferSubmissionExec();
        referSubmissionExec.ExecReferSubmission(main, SubID);
        //Laspe Submission
        lapseandDeclineSubmissionExec.ExecLapseSubmission(main,SubID);
        //Copy Submission
        CopySubmissionExec copySubmissionExec = new CopySubmissionExec();
        copySubmissionExec.ExecCopySubmission(main, SubID);*/

        // Create Quote
        CreateQuoteExec createQuoteExec = new CreateQuoteExec();
        createQuoteExec.ExeCreateQuote(main, SubID, carrierBlock);

        String QuoteID = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + main.get("Iteration") + "\\Response\\CreateQuote Response.txt", "ID");

        log.info("Quote ID ==== {}",QuoteID);

        /*// Decline Quote
        LapseOrDeclineQuoteExec lapseOrDeclineQuoteExec = new LapseOrDeclineQuoteExec();
        lapseOrDeclineQuoteExec.ExeDeclineQuote(QuoteID, main);
        // Reactivate Quote
        ReactivateQuoteExec reactivateQuoteExec = new ReactivateQuoteExec();
        reactivateQuoteExec.ExeReactivateQuote(QuoteID, main);*/

        //Bind Request
        BindRequestExec bindRequestExec = new BindRequestExec();
        bindRequestExec.ExeBindRequest(QuoteID, main);
        //Get Quote
        GetQuoteExec getQuoteExec = new GetQuoteExec();
        getQuoteExec.ExeGetQuote(QuoteID, main);

        ExcelUpdater(main);
        Thread.sleep(1000);
        compareValues(main);

        /*String QuoteNumber = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + main.get("Iteration") + "\\Response\\GetQuote Response.txt", "QuoteNumber");

        log.info("Quote Number ==== ",QuoteNumber);
        //Find Quote
        FindQuoteExec findQuoteExec = new FindQuoteExec();
        findQuoteExec.ExeFindQuote(QuoteNumber, main);*/

    }

    private void ExcelUpdater(Map<String,String>main){

        String ExpectedLossRatio = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","Account.Insured[0].GeneralLiability.Policy[0].ERPExpectedLossRatio");
        ExcelWriter.excelWriter("Expected Loss Ratio",ExpectedLossRatio,Thread.currentThread().getName());

        String LCM = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","Account.Insured[0].GeneralLiability.Policy[0].GeneralLiabilityProductWithdrawalCoverageForm[0].LCM");
        ExcelWriter.excelWriter("LCM",LCM,Thread.currentThread().getName());

        String ExperienceRatingModificationFactor = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","Account.Insured[0].GeneralLiability.Policy[0].ExperienceRatingModificationFactor");
        ExcelWriter.excelWriter("ExperienceRatingModificationFactor",ExperienceRatingModificationFactor,Thread.currentThread().getName());

        String ScheduleRatingModificationFactor = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","Account.Insured[0].GeneralLiability.Policy[0].ScheduleRatingModificationFactor");
        ExcelWriter.excelWriter("ScheduleRatingModificationFactor",ScheduleRatingModificationFactor,Thread.currentThread().getName());

        String FinalDeductible = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","Account.Insured[0].GeneralLiability.Policy[0].GeneralLiabilityLocation[0].GeneralLiabilityClassification[0].GeneralLiabilityClassificationPremOpsCoverage.FinalDeductibleFactor");
        ExcelWriter.excelWriter("FinalDeductible",FinalDeductible,Thread.currentThread().getName());

        String PremOpsPremium = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","Account.Insured[0].GeneralLiability.Policy[0].GeneralLiabilityLocation[0].GeneralLiabilityClassification[0].GeneralLiabilityClassificationPremOpsCoverage.Premium");
        ExcelWriter.excelWriter("PremOps Premium",PremOpsPremium,Thread.currentThread().getName());

        String TerrorisumPremOpsPremium = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","Account.Insured[0].GeneralLiability.Policy[0].GeneralLiabilityLocation[0].GeneralLiabilityClassification[0].GeneralLiabilityTerrorism[0].GeneralLiabilityTerrorismPremOpsCoverage.Premium");
        ExcelWriter.excelWriter("TerrorismPremOps Premium",TerrorisumPremOpsPremium,Thread.currentThread().getName());

        String TerrorisumProdCompldPremium = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","Account.Insured[0].GeneralLiability.Policy[0].GeneralLiabilityLocation[0].GeneralLiabilityClassification[0].GeneralLiabilityTerrorism[0].GeneralLiabilityTerrorismProdsCompldOpsCoverage.Premiumd");
        ExcelWriter.excelWriter("TerrorismProdCompld Premium",TerrorisumProdCompldPremium,Thread.currentThread().getName());

        String ProdCompldPremium = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","Account.Insured[0].GeneralLiability.Policy[0].GeneralLiabilityLocation[0].GeneralLiabilityClassification[0].GeneralLiabilityClassificationProdsCompldOpsCoverage.Premium");
        ExcelWriter.excelWriter("ProdCompld Premium",ProdCompldPremium,Thread.currentThread().getName());

        String TotalPremium = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+main.get("Iteration")+"\\Response\\GetQuote Response.txt","TotalPremium");
        ExcelWriter.excelWriter("Total Premium",TotalPremium,Thread.currentThread().getName());

    }

    private void compareValues(Map<String, String> main) {

        try {
            String iteration = main.get("Iteration");

            // --- 1. Get Actual TotalPremium from JSON ---
            String jsonPath = FrameWorkPilot.getDynamicPath("resultDir") + "\\" + iteration + "\\Response\\GetQuote Response.txt";
            String totalPremiumActualStr = ParamGetter.getPropertyUsingPath(jsonPath, "TotalPremium");
            double totalPremiumActual = Double.parseDouble(totalPremiumActualStr);

            // --- 2. Get Expected TotalPremium from Excel ---
            String excelPath = FrameWorkPilot.getDynamicPath("outputExcel");
            String sheetName = "Main";
            String headerName = "Expected Total Premium";

            FileInputStream fis = new FileInputStream(excelPath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            // Find header column index
            Row headerRow = sheet.getRow(0);
            int columnIndex = -1;
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().trim().equalsIgnoreCase(headerName)) {
                    columnIndex = cell.getColumnIndex();
                    break;
                }
            }
            if (columnIndex == -1) {
                workbook.close();
                throw new RuntimeException("Header not found: " + headerName);
            }

            // Find row index based on iteration (assuming iteration corresponds to row number starting from 1)
            int rowIndex = Integer.parseInt(iteration);
            Row row = sheet.getRow(rowIndex);
            if (row == null) {
                workbook.close();
                throw new RuntimeException("Row not found for iteration: " + iteration);
            }

            Cell expectedCell = row.getCell(columnIndex);
            double totalPremiumExpected;

            // Safely read numeric or string cell
            if (expectedCell.getCellType() == CellType.NUMERIC) {
                totalPremiumExpected = expectedCell.getNumericCellValue();
            } else if (expectedCell.getCellType() == CellType.STRING) {
                String val = expectedCell.getStringCellValue().replaceAll(",", "").trim();
                totalPremiumExpected = Double.parseDouble(val);
            } else {
                workbook.close();
                throw new RuntimeException("Unexpected cell type at iteration " + iteration);
            }

            workbook.close();
            String result;
            // --- 3. Compare actual vs expected ---
            if (Double.compare(totalPremiumActual, totalPremiumExpected) == 0) {
                result = "Pass";
                System.out.println("PASS: Iteration " + iteration + " -> Total Premium matches: " + totalPremiumActual);
            } else {
                result = "Fail";
                System.out.println("FAIL: Iteration " + iteration + " -> Expected: " + totalPremiumExpected + ", Actual: " + totalPremiumActual);
            }
            ExcelWriter.excelWriter("Premium Status",result,Thread.currentThread().getName());

        } catch (Exception e) {
            System.err.println("Error comparing values for iteration " + main.get("Iteration"));
            e.printStackTrace();
        }

    }


}