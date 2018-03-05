package ba.navigator.regression.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends DefaultPage{
	
	@FindBy(xpath = "//div[@id = 'header_container']/a[contains(@class, 'logo')]")
	private WebElement homeLink;
	
	@FindBy(xpath= "//div[@id='header_search']/div/span/input[position()=2]")
	private WebElement searchBar;
	
	@FindBy(xpath= "//ul[contains(@class, 'navigation')]/li/a")
	private List<WebElement> navigationButtons;

	@FindBy(xpath = "//div[@id = 'header_container']/ul[contains(@class, 'social')]/li/a")
	private List<WebElement> socialMediaIcons;
	
	@FindBy(xpath= "//ul[contains(@class, 'navigation languages')]/li/a")
	private List<WebElement> languageLinks;
	
	@FindBy(xpath= "//div[contains(@class, 'left-menu-pane')]")
	private WebElement leftMenuPane;
	
	@FindBy(xpath= "//ul[contains(@class, 'categories')]/li/a")
	private List<WebElement> categories;
	
	@FindBy(xpath= "//ul[contains(@class, 'categories')]/li")
	private List<WebElement> categoriesLi;
	
	@FindBy(xpath = "//div[contains(@class, 'leaflet-control-zoom')]/a")
	private List<WebElement> zoomButtons;
	
	@FindBy(xpath = "//div[contains(@class, 'leaflet-control-layers')]/a")
	private WebElement mapView;
	
	@FindBy(xpath = "//div[@id = 'footer']/span/a")
	private WebElement about;
	
	private By panelPath = By.xpath("//div[@id = 'social-content-container']");
	
	@FindBy(xpath = "//span[contains(@class, 'tt-dropdown-menu')]")
	private WebElement searchBarDropdown;
	
	private By searchBarDropdownPlacesPath = By.xpath("//div[contains(@class, 'tt-suggestion')]");
	
	private By facebookLikePath = By.xpath("");
	
	public HomePage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	private void hoverOverSocialMediaIcons()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(socialMediaIcons.get(0)).build().perform();
	}
	
	public WebElement getSocialMediaPanel()
	{
		hoverOverSocialMediaIcons();
		WebElement panel = driver.findElement(panelPath);
		
		return panel;
	}
	
	public void inputSearchBarData(String data)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(searchBar).build().perform();
		
		searchBar.sendKeys(data);
		
		wait.until(ExpectedConditions.visibilityOf(searchBarDropdown));
	}
	
	public void selectSearchBarDropdownPlace()
	{
		driver.findElements(searchBarDropdownPlacesPath).get(0).click();
	}
	
	public void selectFacebookLike()
	{
		hoverOverSocialMediaIcons();
	}
	
	public void clickCategory(int category)
	{
		wait.until(ExpectedConditions.visibilityOf(leftMenuPane));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch (category) {
		case 0:
			categories.get(1).click();
			break;
		
		case 1:
			categories.get(2).click();
			break;
			
		case 2:
			categories.get(3).click();
			break;
		default:
			break;
		}
	}
	
	public void goToHomePage()
	{
		driver.get("http://www.navigator.ba");
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getButtonCreateNewPlace() {
		return navigationButtons.get(0);
	}
	
	public WebElement getButtonSendSuggestion() {
		return navigationButtons.get(1);
	}
	
	public List<WebElement> getSocialMediaIcons() {
		return socialMediaIcons;
	}

	public List<WebElement> getLanguageLinks() {
		return languageLinks;
	}

	public WebElement getLeftMenuPane() {
		return leftMenuPane;
	}

	public List<WebElement> getCategories() {
		return categories;
	}

	public List<WebElement> getZoomButtons() {
		return zoomButtons;
	}

	public WebElement getMapView() {
		return mapView;
	}

	public WebElement getAbout() {
		return about;
	}

	public WebElement getSearchBarDropdown() {
		return searchBarDropdown;
	}
}
