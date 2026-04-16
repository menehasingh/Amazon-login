//package testcase;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class test {
//	WebDriver driver;
//	@BeforeTest
//	public void setup() {
//		driver=new ChromeDriver();
//		driver.get("https://www.amazon.com");
//        driver.manage().window().maximize();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//	}
//	@Test
//	public void login() {
//		driver.findElement(By.id("nav-link-accountList")).click();
//		driver.findElement(By.id("ap_email_login")).sendKeys("bnehasingh865@gmail.com");
//
//	}
//	
//
//}
