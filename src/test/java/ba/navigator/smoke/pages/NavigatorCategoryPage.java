package ba.navigator.smoke.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorCategoryPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By listOfPlaces = By.xpath("//ul[contains(@class, 'menu_content_list')]");
	private By place = By.tagName("li");
	private By placeLink = By.tagName("a");
	
	@FindBy(xpath = "//div[contains(@class, 'left-menu-pane')]/div/div[contains(@class, 'mCSB_container')]")
	private WebElement listContainer;
	
	@FindBy(xpath = "//div[contains(@class, 'profile-image-container')]")
	private WebElement image;
	
	@FindBy(xpath = "//div[contains(@class, 'address')]")
	private WebElement address;
	
	@FindBy(xpath = "//div[contains(@class, 'description')]")
	private WebElement description;
	
	public NavigatorCategoryPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		
		PageFactory.initElements(driver, this);
	}
	
	public void waitForPlacesToLoad()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(listOfPlaces));
	}
	
	public void choosePlaceFromList()
	{ 	
	  	getPlaces().get(0).findElement(placeLink).click();
	  	wait.until(ExpectedConditions.visibilityOf(image));
	}
	
	public List<WebElement> getPlaces()
	{
		List<WebElement> places = listContainer.findElements(place);
		
		return places;
	}
	
	public WebElement getImage()
	{	
		return image;
	}
	
	public WebElement getAddress()
	{
	  	return address;
	}
	
	public WebElement getDescription()
	{
	  	return description;
	}
}
