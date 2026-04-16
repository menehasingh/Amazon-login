package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;

public class loginpage extends basePage{

	public loginpage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath="//input[contains(@id,'email')]")
	WebElement email;
	  
	  @FindBy(id="continue")
	  WebElement conti;
	  @FindBy(xpath="//input[@id='ap_password']")
	  WebElement password;
	  @FindBy(id="signInSubmit")
	  WebElement sign;
	  @FindBy(xpath="//div[contains(@class,'a-alert-content')]")
	  WebElement errorMsg;
	  @FindBy(xpath="//h2[contains(text(),'Password') or contains(text(),'OTP')]")
	  WebElement otpHeader;

	  public void emailact(String em) {
		  email.clear();

//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        wait.until(ExpectedConditions.visibilityOf(email));

		  email.sendKeys(em);
	  }
	  public void contiact() {
		  conti.click();
	  }
	  public void pass(String text) {
		  password.clear();

		  password.sendKeys(text); 
	  }
	  public void signbtn() {
		  sign.click();
	  }
//	  public void clickEmailUsingJS() {
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("arguments[0].click();", email);
//	    }
	  public boolean isPasswordPresent() {
	        try {
	            return password.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    // 🔥 Get error message
	    public String getErrorMessage() {
	        try {
	            return errorMsg.getText();
	        } catch (Exception e) {
	            return "No error message";
	        }}
	        public boolean isotp() {
	        	try {
	        		return otpHeader.isDisplayed();
	        	}catch(Exception e) {
	        		return false;
	        	}
	        }

	    

}
