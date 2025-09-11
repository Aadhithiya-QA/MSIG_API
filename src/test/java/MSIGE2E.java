import CommonFunctions.ParamGetter;
import DataProviderUtil.ExcelDataFeeder;
import FrameWork.FrameWorkPilot;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

public class MSIGE2E extends Base {

    private static final Logger log = LogManager.getLogger(MSIGE2E.class);

    @Test(dataProvider = "MSIGFlow",dataProviderClass = ExcelDataFeeder.class)
    public void MSIGSanity(Map<String,String>map) throws InterruptedException{

        Thread.currentThread().setName(map.get("Iteration"));

        try {
            FileUtils.forceMkdir(new File(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + map.get("Iteration") + "\\Request\\"));
            FileUtils.forceMkdir(new File(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + map.get("Iteration") + "\\Response\\"));
            FileUtils.forceMkdir(new File(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + map.get("Iteration") + "\\PDF\\"));
        } catch (Exception E) {
            E.printStackTrace();
        }

        //Save Submission
        SaveSubmissionExec saveSubmissionExec = new SaveSubmissionExec();
        saveSubmissionExec.ExecSaveSubmission(map);
        String SubID = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + map.get("Iteration") + "\\Response\\SaveSubmission Response.txt", "ID");
        String SubNumber = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir") + "\\" + map.get("Iteration") + "\\Response\\SaveSubmission Response.txt", "SubmissionNumber");
        log.info("Submission ID ==== {}",SubID);
        //Get Available Market
        GetAvailablemarketExec getAvailablemarketExec = new GetAvailablemarketExec();
        getAvailablemarketExec.ExecGetAvailableMarket(map,SubID);
        //Invoke Rate and Form
        InvokeRateandFormsExec invokeRateandFormsExec = new InvokeRateandFormsExec();
        invokeRateandFormsExec.ExecInvokeRateandForms(map,SubID);
        //Get Submission
        GetSubmissionExec getSubmissionExec = new GetSubmissionExec();
        getSubmissionExec.ExecGetSubmission(SubID,map);
        String AccountID = ParamGetter.getPropertyUsingPath(FrameWorkPilot.getDynamicPath("resultDir")+"\\"+map.get("Iteration") + "\\Response\\GetSubmission Response.txt", "Account.ID");
        log.info("Account ID ==== {}",AccountID);
        //Find Submission
        FindSubmissionExec findSubmissionExec = new FindSubmissionExec();
        findSubmissionExec.ExecFindSubmission(SubNumber,map);
        //Find Account
        FindAccountExec findAccountExec = new FindAccountExec();
        findAccountExec.ExecFindAccount(map,AccountID);
        //Lapse Submission
        LapseandDeclineSubmissionExec lapseandDeclineSubmissionExec = new LapseandDeclineSubmissionExec();
        lapseandDeclineSubmissionExec.ExecLapseSubmission(map,SubID);
        //Reactivate Submission
        ReactivateSubmissionExec reactivateSubmissionExec = new ReactivateSubmissionExec();
        reactivateSubmissionExec.ExecReactivateSubmission(map,SubID);
        //Refer Submission
        ReferSubmissionExec referSubmissionExec = new ReferSubmissionExec();
        referSubmissionExec.ExecReferSubmission(map,SubID);
        //Decline Submission
        lapseandDeclineSubmissionExec.ExecDeclineSubmission(map,SubID);
        //Copy Submission
        CopySubmissionExec copySubmissionExec = new CopySubmissionExec();
        copySubmissionExec.ExecCopySubmission(map,SubID);

    }

}