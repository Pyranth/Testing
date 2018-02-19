package ba.navigator.regression.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DefaultPage{
	
	@FindBy(xpath= "//div[@id='header_search']/div/span/input[position()=1]")
	private WebElement searchBar;
	
	@FindBy(xpath= "//ul[contains(@class, 'navigation')]/li/a")
	private List<WebElement> navigationButtons;

	@FindBy(xpath = "//div[@id = 'header_container']/ul[contains(@class, 'social')]/li/a")
	private List<WebElement> socialMediaIcons;
	
	@FindBy(xpath= "//div[@id = 'header_container']/ul[contains(@class, 'language')/li/a]")
	private List<WebElement> languageLinks;
	
	@FindBy(xpath= "//div[contains(@class, 'left-menu-pane')]")
	private WebElement leftMenuPane;
	
	@FindBy(xpath= "//div[contains(@class, 'left-menu-pane')]/div/div[contains(@class, 'mCSB_container')]/ul/li/a")
	private List<WebElement> categories;
	
	@FindBy(xpath = "//div[contains(@class, 'leaflet-control-zoom')]/a")
	private List<WebElement> zoomButtons;
	
	@FindBy(xpath = "//div[contains(@class, 'leaflet-control-layers')]/a")
	private WebElement mapView;
	
	@FindBy(xpath = "//div[@id = 'footer']/span/a")
	private WebElement about;
	
	private By panelPath = By.xpath("//div[@id = 'social-content-container']");
	
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
}
