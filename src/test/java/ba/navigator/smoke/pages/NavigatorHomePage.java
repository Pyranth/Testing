package ba.navigator.smoke.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorHomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//a[contains(@class, 'logo')]")
	private WebElement homePageLink;
	
	@FindBy(xpath = "//div[contains(@class, 'mCSB_container')]/ul[contains(@class, 'menu_content_list')]/li")
	private List<WebElement> places;
	
	@FindBy(xpath = "//div[contains(@class, 'leaflet-marker-pane')]/div")
	private List<WebElement> locations;
	
	@FindBy(xpath = "//div[contains(@class, 'leaflet-control-zoom')]/a")
	private List<WebElement> zoomButtons;
	
	@FindBy(xpath = "//div[contains(@class, 'leaflet-control-layers')]/a")
	private WebElement mapView;

	public NavigatorHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		
		PageFactory.initElements(driver, this);
	}
	
	// Choose category Test scenario
	
	public void ChooseCategory(String categoryValue)
	{
		WebElement category = driver.findElement(By.className(categoryValue));
	    category.click();
	      
	    wait.until(ExpectedConditions.visibilityOf(places.get(0)));
	}
	
	public List<WebElement> getPlaces()
	{	
		return places;
	}
	
	public List<WebElement> getLocations()
	{
		return locations;
	}
	
	// Map Test scenario
	
	public void performMapTest()
	{
		homePageLink.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement zoomInButton = zoomButtons.get(0);
	  	zoomInButton.click();
	  	
	  	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  	
	  	WebElement zoomOutButton = zoomButtons.get(1);
	  	zoomOutButton.click();
	  	
	  	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  	
	  	mapView.click();
	  	
	  	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  	
	  	mapView.click();
	  	
	  	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
