package ba.navigator.regression;

import org.testng.annotations.Test;

import ba.navigator.regression.pages.HomePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class RegressionTest {
	private WebDriver driver;
	private HomePage homePage;
	
	/**
	 * Test if everything is displayed correctly on home page.
	 */
	@Test
	public void homePageDisplay() {
		if (homePage == null)
			homePage = new HomePage(driver);
		
		assertTrue(homePage.getSearchBar().isDisplayed());
		assertTrue(homePage.getButtonCreateNewPlace().isDisplayed());
		assertTrue(homePage.getButtonSendSuggestion().isDisplayed());
		
		for(WebElement icon : homePage.getSocialMediaIcons())
		{
			assertTrue(icon.isDisplayed());
		}
		
		assertTrue(homePage.getSocialMediaPanel().isDisplayed());
		
		for (WebElement link : homePage.getLanguageLinks())
		{
			assertTrue(link.isDisplayed());
		}
		
		assertTrue(homePage.getLeftMenuPane().isDisplayed());
		
		assertTrue(!homePage.getCategories().isEmpty());
		
		for (WebElement category : homePage.getCategories())
		{
			assertTrue(category.isEnabled());
		}
		
		assertTrue(!homePage.getZoomButtons().isEmpty());
		
		for (WebElement zoomButton : homePage.getZoomButtons())
		{
			assertTrue(zoomButton.isDisplayed());
		}
		
		assertTrue(homePage.getMapView().isDisplayed());
		assertTrue(homePage.getAbout().isDisplayed());
	}
  
	@BeforeTest
	public void beforeTest() {
	}
	
	@AfterTest
	public void afterTest() {
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.gecko.driver", "/home/atlantbh/geckodriver");
	    System.setProperty("webdriver.chrome.driver", "/home/atlantbh/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("http://www.navigator.ba");
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}
