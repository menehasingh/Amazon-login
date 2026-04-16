package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Base.Baseclass;

public class screenshot  extends Baseclass{
	public String Capturescreen(String name) throws IOException {
	TakesScreenshot screenshorts= (TakesScreenshot) driver; 
	File soucefile=screenshorts.getScreenshotAs(OutputType.FILE);
	String Targetpath=System.getProperty("user.dir")+"/screenshots/"+name+".png";
	File dir = new File(System.getProperty("user.dir") + "/screenshots");
    if (!dir.exists()) {
        dir.mkdirs();
    }
	File targetfile=new File(Targetpath);
//	soucefile.renameTo(targetfile);
	FileHandler.copy(soucefile, targetfile);  
	return Targetpath;
	
	}

}
