package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.extendreport;
import utilities.screenshot;

public class itest implements ITestListener {
	
	ExtentReports extent=extendreport.getIntance();
	ExtentTest Test;
    public void onStart(ITestContext context) {
        System.out.println("Test Started");
    }

	public void onTestStart(ITestResult result) {
		Test = extent.createTest(result.getName());

		   }
	public void onTestSuccess(ITestResult result) {
		Test.log(Status.PASS, result.getName()+"got sucessfully executed");
	}
	public void onTestFailure(ITestResult result) {
		Test.log(Status.FAIL, result.getName()+"got fail");
		Test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String imgpath=new screenshot().Capturescreen(result.getName());
			Test.addScreenCaptureFromPath(imgpath);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	public void onTestSkipped(ITestResult result) {
		Test.log(Status.SKIP, result.getName()+"Test got Skipped");
		
	}
	public void onFinish(ITestContext context) {
        System.out.println("Flushing report...");
        extent.flush();
    }


	
}
