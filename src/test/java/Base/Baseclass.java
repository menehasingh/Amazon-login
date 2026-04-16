package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Baseclass {
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	 public void setup(String br) {
	switch(br.toLowerCase()){
	case "chrome":driver=new ChromeDriver(); break;	
	
	case "firefox":driver=new FirefoxDriver(); break;
	case "edge":driver=new EdgeDriver(); break;
    default:
        throw new RuntimeException("Invalid browser name"+br);

	}
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	public void setup() {
//        driver=new ChromeDriver();
//	
//		driver.get("https://www.amazon.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
	}
	@AfterMethod
	public void teardown() {
	    driver.quit();
	}

}
