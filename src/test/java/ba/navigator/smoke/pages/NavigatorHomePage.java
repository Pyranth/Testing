package ba.navigator.smoke.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorHomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By categoryName;
	private By placeList = By.xpath("//ul[contains(@class, 'menu_content_list')]/li");
	private By locationMarkers = By.xpath("//div[contains(@class, 'leaflet-marker-pane')]/div");
	
	private By zoomInLink = By.xpath("//a[@title='Zoom in']");
	private By zoomOutLink = By.xpath("//a[@title='Zoom out']");
	private By mapView = By.xpath("//a[contains(@class, 'leaflet-control-layers-switch')]");

	public NavigatorHomePage(WebDriver driver) {
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 10);
	}
	
	// Choose category Test scenario
	
	public void ChooseCategory(String categoryValue)
	{
		categoryName = By.className(categoryValue);
		
		WebElement category = driver.findElement(categoryName);
	    category.click();
	      
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'menu_content_list')]/li")));
	}
	
	public List<WebElement> getPlaces()
	{
		List<WebElement> places = driver.findElements(placeList);
		
		return places;
	}
	
	public List<WebElement> getLocations()
	{
		List<WebElement> locations = driver.findElements(locationMarkers);
	    
		return locations;
	}
	
	// Map Test scenario
	
	public void performMapTest()
	{
		WebElement zoomInButton = driver.findElement(zoomInLink);
	  	zoomInButton.click();
	  	
	  	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  	
	  	WebElement zoomOutButton = driver.findElement(zoomOutLink);
	  	zoomOutButton.click();
	  	
	  	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  	
	  	WebElement mapViewButton = driver.findElement(mapView);
	  	mapViewButton.click();
	  	
	  	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  	
	  	mapViewButton.click();
	  	
	  	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
