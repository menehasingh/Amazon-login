package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extendreport {
	public static ExtentReports extent;
	public static ExtentReports getIntance() {
		if(extent==null) {
			String timeSpand=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format (new Date());
			String reponame="Test-Report"+timeSpand+".html";
			String path = System.getProperty("user.dir")+"/reports/" + reponame;
			File dir = new File(System.getProperty("user.dir") + "/reports");
            if (!dir.exists()) {
                dir.mkdirs();
            }System.out.println("Report Path: " + path);

			ExtentSparkReporter Reporter=new ExtentSparkReporter(path);
			Reporter.config().setReportName("Automation Report");
			Reporter.config().setDocumentTitle("Test Result");
			Reporter.config().setTheme(Theme.DARK);
			extent=new ExtentReports();
			extent.attachReporter(Reporter);
			extent.setSystemInfo("Application", "Amazon");
			extent.setSystemInfo("User", "Admin");
			extent.setSystemInfo("Tester", "Neha");
		}
		return extent;
	}

}
