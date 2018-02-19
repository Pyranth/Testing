package ba.navigator.smoke.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorCreatePlacePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//ul[contains(@class, 'navigation')]/li/a")
	private List<WebElement> navButtons;
	
	@FindBy(xpath = "//input[@id='poi_name']")
	private WebElement name;
	
	@FindBy(xpath = "//div[contains(@class, 'category-selector-container')]/button")
	private WebElement buttonSelectCategory;
	
	@FindBy(xpath = "//div[contains(@class, 'category-selector-row')]/div[contains(@class, 'span3')]/select")
	private WebElement categoryDropDownList;
	
	@FindBy(xpath = "//div[contains(@class, 'category-selector-row')]/div[position() = 3]/select")
	private WebElement subcategoryDropDownList;
	
	@FindBy(xpath = "//button[contains(@class, 'btn-success')]")
	private WebElement buttonSubmit;
	
	@FindBy(xpath = "//div[contains(@class, 'mCSB_draggerContainer')]")
	private WebElement draggablePartOfScrollbar;
	
	public NavigatorCreatePlacePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		
		PageFactory.initElements(driver, this);
	}
	
	public void insertPlaceData(String nameValue, int categoryIndex, int subcategoryIndex)
	{
		navButtons.get(0).click();
	  	name.sendKeys(nameValue);
	  	buttonSelectCategory.click();
	  	
	  	wait.until(ExpectedConditions.visibilityOf(categoryDropDownList));
	  	
	  	Select select = new Select(categoryDropDownList);
	  	select.selectByIndex(categoryIndex);
	  	
	  	wait.until(ExpectedConditions.visibilityOf(subcategoryDropDownList));
	  	
	  	Select select2 = new Select(subcategoryDropDownList);
	  	select2.selectByIndex(subcategoryIndex);
	}
	
	public void submitNewPlace()
	{ 	
	  	Actions dragger = new Actions(driver);

	  	while(!buttonSubmit.isDisplayed())
	  	{
	  	    try {
	  	    	// Kinda hacky but works
	  	    	dragger.moveToElement(draggablePartOfScrollbar, 0, draggablePartOfScrollbar.getSize().getHeight() - 50).click().build().perform();
	  	        Thread.sleep(1000L);
	  	    } catch(Exception e1){}
	  	} 
	  	
	  	// Works now, commented out to not create bunch of test places
	  	// buttonSubmit.click();
	}

	public WebElement getCategoryDropDownList() {
		return categoryDropDownList;
	}

	public WebElement getSubcategoryDropDownList() {
		return subcategoryDropDownList;
	}
}
