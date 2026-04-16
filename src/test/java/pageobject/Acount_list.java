package pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Acount_list extends basePage {

	public Acount_list(WebDriver driver) {
		super(driver);
		
	}
	

	@FindBy(xpath="//span[contains(text(),'Account &')]")
	WebElement account;
	@FindBy(id="nav-item-signout")
	WebElement signbutton;
	public void hoveraccount() {
		Actions act=new Actions(driver);
		act.moveToElement(account).perform();
	}
	public void signout() {
		signbutton.click();
	}

}
