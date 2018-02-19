package ba.navigator.smoke.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorCategoryPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By listContainer = By.xpath("//div[contains(@class, 'left-menu-pane')]/div/div[contains(@class, 'mCSB_container')]");
	private By listOfPlaces = By.xpath("//ul[contains(@class, 'menu_content_list')]");
	private By place = By.tagName("li");
	private By placeLink = By.tagName("a");
	private By imageContainer = By.xpath("//div[contains(@class, 'profile-image-container')]");
	
	public NavigatorCategoryPage(WebDriver driver) {
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 10);
	}
	
	public void waitForPlacesToLoad()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfPlaces));
	}
	
	public void choosePlaceFromList()
	{ 	
	  	List<WebElement> places = getPlaces();
	  	
	  	places.get(0).findElement(placeLink).click();
	  	
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'profile-image-container')]")));
	}
	
	public List<WebElement> getPlaces()
	{
		WebElement list = driver.findElement(listContainer);
		List<WebElement> places = list.findElements(place);
		
		return places;
	}
	
	public WebElement getImage()
	{
		WebElement image = driver.findElement(imageContainer);
		
		return image;
	}
	
	public WebElement getAddress()
	{
	  	WebElement address = driver.findElement(By.xpath("//div[contains(@class, 'address')]"));
	  	
	  	return address;
	}
	
	public WebElement getDescription()
	{
	  	WebElement description = driver.findElement(By.xpath("//div[contains(@class, 'description')]"));
	  	
	  	return description;
	}
}
