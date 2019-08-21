package com.effectivetesting.entry;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.effectivetesting.pageobject.EntryPageObject;
import com.effectivetesting.pageobject.HomePageObject;
import com.effectivetesting.pageobject.LoginPageObject;

public class TestCreateEntryValidations {
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	@Test
	public void textRequired() {
		loginPage = new LoginPageObject(driver);
	HomePageObject homePage = loginPage.login("admin1@gmail.com", "admin1");
	
	EntryPageObject entryPage = homePage.goToCreateEntry();
	
	entryPage.createEntry("", "Este es el texto!");
	
	String currentMessage = entryPage.getTextErrorMessage();
	
	assertTrue(currentMessage.contains("This field is required"));
}



@Before
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get("localhost:5000");
}

}
