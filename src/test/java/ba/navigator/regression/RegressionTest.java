package ba.navigator.regression;

import org.testng.annotations.Test;

import ba.navigator.regression.pages.CategoryPage;
import ba.navigator.regression.pages.HomePage;
import ba.navigator.regression.pages.PlacePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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
	private PlacePage placePage;
	private CategoryPage categoryPage;
	
	private String url;
	
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
		
		assertTrue(!homePage.getLanguageLinks().isEmpty());
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
	
	/**
	 * Test for Search Bar functionalities.
	 */
	@Test
	public void searchBarFunctionality()
	{
		if (homePage == null)
			homePage = new HomePage(driver);
		
		homePage.inputSearchBarData("Bristol");
		assertTrue(homePage.getSearchBarDropdown().isDisplayed());
		
		homePage.selectSearchBarDropdownPlace();
		
		if (placePage == null)
			placePage = new PlacePage(driver);
		
		placePage.waitForLoading();
		
		assertTrue(placePage.getImage().isDisplayed());
		assertTrue(placePage.getAddress().isDisplayed());
		assertTrue(placePage.getDescription().isDisplayed());
	}
	
	/**
	 * Test if changing language works.
	 */
	@Test
	public void languageFunctionality()
	{
		if (homePage == null)
			homePage = new HomePage(driver);
		
		homePage.getLanguageLinks().get(0).click();
	}
	
	/**
	 * Test social media options.
	 */
	@Test
	public void socialMediaFunctionality()
	{
		if (homePage == null)
			homePage = new HomePage(driver);
	}
	
	/**
	 * Validate category links
	 */
    @Test
    public void validateCategoryLinks()
    {
    	if (homePage == null)
			homePage = new HomePage(driver);
    	
    	homePage.goToHomePage();
    	homePage.clickCategory(0);
    	
    	if (categoryPage == null)
    		categoryPage = new CategoryPage(driver);
    	
    	assertTrue(!categoryPage.getAccommodationPlaces().isEmpty());
    	
    	homePage.goToHomePage();
    	homePage.clickCategory(1);
    	
    	assertTrue(!categoryPage.getFoodPlaces().isEmpty());
    	
    	homePage.goToHomePage();
    	homePage.clickCategory(2);

    	assertTrue(!categoryPage.getCoffeePlaces().isEmpty());
    }
    
    /**
     * Validate information shown about place in left menu pane.
     */
    @Test
    public void validateInfoAboutPlace()
    {
    	if (homePage == null)
			homePage = new HomePage(driver);
    	
    	homePage.goToHomePage();
    	homePage.clickCategory(0);
    	
    	if (categoryPage == null)
    		categoryPage = new CategoryPage(driver);
    	
    	categoryPage.selectPlace();
    	
    	if (placePage == null)
    		placePage = new PlacePage(driver);
    	
    	placePage.waitForLoading();
    	
    	assertTrue(placePage.getImage().isDisplayed());
    	assertTrue(placePage.getDescription().isDisplayed());
    	assertTrue(placePage.getAddress().isDisplayed());
    	
    	placePage.scrollDown();
    	
    	assertTrue(placePage.getClaimButton().isDisplayed());
    	assertTrue(placePage.getSuggestButton().isDisplayed());
    }
    
    /**
     * Check 'Suggest Changes' option for place.
     */
    @Test
    public void suggestChangesFunctionality()
    {
    	validateInfoAboutPlace();
    	
    	if (placePage == null)
    		placePage = new PlacePage(driver);
    	
    	placePage.getSuggestButton().click();
    	
    	assertTrue(placePage.getEditForm().isDisplayed());
    }
    
    /**
     * Check 'Claim' option for place.
     */
    @Test
    public void claimFunctionality()
    {
    	validateInfoAboutPlace();
    	
    	if (placePage == null)
    		placePage = new PlacePage(driver);
    	
    	placePage.getClaimButton().click();
    	
    	assertTrue(placePage.getClaimForm().isDisplayed());
    }
    
    /**
     * Test option for creating new place.
     */
    @Test
    public void createNewPlace()
    {
    	
    }
    
    /**
     * Test canceling option for creating new place.
     */
    @Test
    public void cancelCreatingNewPlace()
    {
    	
    }
    
    /**
     * Test option for sending suggestions.
     */
    @Test
    public void sendSuggestion()
    {
    	
    }
    
    /**
     * Test canceling option for sending suggestions.
     */
    @Test
    public void cancelSendingSuggestion()
    {
    	
    }
    
    /**
     * Test About link.
     */
    @Test
    public void checkAbout()
    {
    	
    }
    
	@BeforeTest
	public void beforeTest() {
		
	}
	
	@AfterTest
	public void afterTest() {
	}
	
	@BeforeSuite
	@Parameters("url")
	public void beforeSuite(String url) {
		System.setProperty("webdriver.gecko.driver", "/home/atlantbh/geckodriver");
	    System.setProperty("webdriver.chrome.driver", "/home/atlantbh/chromedriver");
		
	    this.url = url;
	    
		driver = new ChromeDriver();
		driver.get(this.url);
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}
