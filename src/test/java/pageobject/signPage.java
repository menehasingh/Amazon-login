package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signPage extends basePage {

	public signPage(WebDriver driver) {
		super(driver);}
	
		@FindBy (id="nav-link-accountList")
				WebElement button;
		public void signbtn(){
			button.click();
			
		}
		
		
	
	

}
