package ba.navigator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorCreatePlacePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By navButtons = By.xpath("//ul[contains(@class, 'navigation')]/li/a");
	private By nameTextField = By.xpath("//input[@id='poi_name']");
	private By buttonCategory = By.xpath("//div[contains(@class, 'category-selector-container')]/button");
	private By categoryDropDown = By.xpath("//div[contains(@class, 'category-selector-row')]/div[contains(@class, 'span3')]/select");
	private By submit = By.xpath("//button[contains(@class, 'btn-success')]");
	private By scrollContainer = By.xpath("//div[contains(@class, 'mCSB_draggerContainer')]");
	
	public NavigatorCreatePlacePage(WebDriver driver) {
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 10);
	}
	
	public void insertPlaceData()
	{
		WebElement buttonCreate = driver.findElements(navButtons).get(0);
	  	buttonCreate.click();
	  	
	  	WebElement name = driver.findElement(nameTextField);
	  	name.sendKeys("Test name");
	  	
	  	WebElement buttonSelectCategory = driver.findElement(buttonCategory);
	  	buttonSelectCategory.click();
	  	
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(categoryDropDown));
	  	
	  	WebElement categoryDropDownList = getCategory();
	  	
	  	Select select = new Select(categoryDropDownList);
	  	select.selectByValue("8");
	  	
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'category-selector-row')]/div[position() = 3]/select")));
	  	
	  	WebElement subcategoryDropDownList = driver.findElements(categoryDropDown).get(1);
	  	
	  	Select select2 = new Select(subcategoryDropDownList);
	  	select2.selectByIndex(2);
	}
	
	public WebElement getCategory()
	{
		WebElement categoryDropDownList = driver.findElement(categoryDropDown);
		
		return categoryDropDownList;
	}
	
	public WebElement getSubcategory()
	{
		WebElement subcategoryDropDownList = driver.findElements(categoryDropDown).get(1);
		
		return subcategoryDropDownList;
	}
	
	public void submitNewPlace()
	{
		WebElement buttonSubmit = driver.findElement(submit);
	  	
	  	Actions dragger = new Actions(driver);

	  	WebElement draggablePartOfScrollbar = driver.findElement(scrollContainer);

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
}
