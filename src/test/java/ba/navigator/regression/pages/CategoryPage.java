package ba.navigator.regression.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoryPage extends DefaultPage {
	
	@FindBy(xpath = "//ul[contains(@class, 'menu_content_list')]")
	private WebElement placesList;
	
	@FindBy(xpath = "//li[contains(@class, 'place accommodation')]")
	private List<WebElement> accommodationPlaces;
	
	@FindBy(xpath = "//li[contains(@class, 'place food')]")
	private List<WebElement> foodPlaces;
	
	@FindBy(xpath = "//li[contains(@class, 'place coffee')]")
	private List<WebElement> coffeePlaces;
	
	public CategoryPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public void selectPlace()
	{
		getAccommodationPlaces().get(0).click();
	}

	public List<WebElement> getAccommodationPlaces() {
		wait.until(ExpectedConditions.visibilityOf(placesList));
		
		return accommodationPlaces;
	}

	public List<WebElement> getFoodPlaces() {
		wait.until(ExpectedConditions.visibilityOf(placesList));
		
		return foodPlaces;
	}

	public List<WebElement> getCoffeePlaces() {
		wait.until(ExpectedConditions.visibilityOf(placesList));
		
		return coffeePlaces;
	}

}
