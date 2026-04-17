package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Baseclass;
import pageobject.Acount_list;
import pageobject.loginpage;
import pageobject.signPage;
import utilities.excel;

public class Signin extends Baseclass{
	@DataProvider(name="sheet1")
	public  Object[][]getdata() throws IOException{
		return excel.getTestData("testlog.xlsx","Sheet1");
		
	}
	
//	@Test(priority=1)
//	public void sign() {
//	signPage sing=new signPage(driver);
//	sing.signbtn();
//    }
	@Test(dataProvider="sheet1", priority=1)

	
	public void login(String username,String password, String expected) {
		signPage sing=new signPage(driver);
		sing.signbtn();
		loginpage obj=new loginpage(driver);
		 
//		if(expected.eq ualsIgnoreCase("Login Success")) {
//	        Assert.assertTrue(driver.getTitle().contains("Amazon"));
//	    } else {
//	        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("incorrect")|| driver.getPageSource().toLowerCase().contains("problem"));
//	    }

		
		obj.emailact(username);
		obj.contiact();	
		 if(obj.isPasswordPresent()) {

	            obj.pass(password);
	            obj.signbtn();

		if(expected.equalsIgnoreCase("Login Success")) {
            Assert.assertTrue(driver.getTitle().contains("Amazon"));
            Acount_list list = new Acount_list(driver);
            list.hoveraccount();
            list.signout();

        } 
		else if(obj.isotp()) {
            System.out.println("OTP Page after email");

            // ✅ FIX HERE
            Assert.assertTrue(expected.toLowerCase().contains("otp")
                    || expected.toLowerCase().contains("access"));
        } 


    } 
        	else {
        		if(obj.isotp()) {
        	

                System.out.println("OTP Page after EMAIL");  // ✅ THIS IS CORRECT PLACE

                Assert.assertTrue(expected.toLowerCase().contains("otp")
                        || expected.toLowerCase().contains("access"));
            }
        		else {

        		
        		String error = obj.getErrorMessage();
                System.out.println("Error Message: " + error);
            Assert.assertTrue(
                driver.getPageSource().toLowerCase().contains("incorrect") ||
                driver.getPageSource().toLowerCase().contains("problem")
            );
        }
		}
	
	}

		
	
}
