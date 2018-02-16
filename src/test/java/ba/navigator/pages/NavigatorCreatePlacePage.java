package ba.navigator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	public NavigatorCreatePlacePage(WebDriver driver) {
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 10);
	}
	
	public void createNewPlace()
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
	  	
	  	// WebElement buttonSubmit = driver.findElement(By.xpath("//button[contains(@class, 'btn-success')]"));
	  	
	  	// Element not visible exception???
	  	// buttonSubmit.click();
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
}
