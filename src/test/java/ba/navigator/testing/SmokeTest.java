package ba.navigator.testing;

import org.testng.annotations.Test;

import ba.navigator.pages.NavigatorCategoryPage;
import ba.navigator.pages.NavigatorCreatePlacePage;
import ba.navigator.pages.NavigatorHomePage;
import ba.navigator.pages.NavigatorSuggestionPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class SmokeTest {
	private WebDriver chromeDriver;
	
	private WebDriver driver;
	
	private NavigatorHomePage homePage;
	private NavigatorCategoryPage categoryPage;
	private NavigatorCreatePlacePage createPage;
	private NavigatorSuggestionPage suggestionPage;
		
  @Test
  public void ChooseCategory()
  {
	  homePage = new NavigatorHomePage(driver);
	  
	  homePage.ChooseCategory("accommodation");
      assertTrue(!homePage.getPlaces().isEmpty());
      assertTrue(!homePage.getLocations().isEmpty());
  }
  
  @Test
  public void ChoosePlaceFromList()
  {	
	  categoryPage = new NavigatorCategoryPage(driver);
	  
	  categoryPage.waitForPlacesToLoad();
	  assertNotEquals(categoryPage.getPlaces().size(), 0);
	  categoryPage.choosePlaceFromList();
	  assertTrue(categoryPage.getImage().isDisplayed());
	  assertTrue(categoryPage.getAddress().isDisplayed());
	  assertTrue(categoryPage.getDescription().isDisplayed());
  }
  
  @Test
  public void CreateNewPlace()
  {
	  createPage = new NavigatorCreatePlacePage(driver);
	  
	  createPage.createNewPlace();
	  assertTrue(createPage.getCategory().isDisplayed());
	  assertTrue(createPage.getSubcategory().isDisplayed());
  }
  
  @Test
  public void Suggestion()
  {
	  suggestionPage = new NavigatorSuggestionPage(driver);
	  
	  suggestionPage.sendSuggestion();
	  assertTrue(suggestionPage.getSuccessMessage().isDisplayed());
  }
  
  @Test
  public void MapTest()
  {
	  if (homePage == null)
		  homePage = new NavigatorHomePage(driver);
	  
	  homePage.performMapTest();
  }
  
  @BeforeTest
  public void beforeTest() {
	  //TODO: Logic to change browser
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.gecko.driver", "/home/atlantbh/geckodriver");
      System.setProperty("webdriver.chrome.driver", "/home/atlantbh/chromedriver");
	  
	  chromeDriver = new ChromeDriver();
	  
	  driver = chromeDriver;
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.get("http://www.navigator.ba");
  }

  @AfterSuite
  public void afterSuite() {
	  chromeDriver.close();
  }

}
