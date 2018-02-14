package ba.navigator.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class SmokeTest {
	private WebDriver chromeDriver;
	
	private WebDriver driver;
	
	private WebDriverWait wait;
		
  @Test
  public void ChooseCategory()
  {
  	  WebElement category = driver.findElement(By.className("accommodation"));
      category.click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'menu_content_list')]/li")));
    	
      List<WebElement> places = driver.findElements(By.xpath("//ul[contains(@class, 'menu_content_list')]/li"));
      List<WebElement> locations = driver.findElements(By.xpath("//div[contains(@class, 'leaflet-marker-pane')]/div"));
      
      assertTrue(!places.isEmpty());
      assertTrue(!locations.isEmpty());
  }
  
  @Test
  public void ChoosePlaceFromList()
  {	
  	WebElement list = driver.findElement(By.xpath("//div[contains(@class, 'left-menu-pane')]/div/div[contains(@class, 'mCSB_container')]"));
  	
  	WebDriverWait wait = new WebDriverWait(driver, 0);
  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'menu_content_list')]")));
  	
  	List<WebElement> place = list.findElements(By.tagName("li"));
  	
  	assertNotEquals(place.size(), 0);
  	
  	place.get(0).findElement(By.tagName("a")).click();
  	
  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'profile-image-container')]")));
  	
  	WebElement image = driver.findElement(By.xpath("//div[contains(@class, 'profile-image-container')]"));
  	assertTrue(image.isDisplayed());
  	
  	WebElement address = driver.findElement(By.xpath("//div[contains(@class, 'address')]"));
  	assertTrue(address.isDisplayed());
  	
  	WebElement description = driver.findElement(By.xpath("//div[contains(@class, 'description')]"));
  	assertTrue(description.isDisplayed());
  }
  
  @Test
  public void CreateNewPlace()
  {
  	WebElement buttonCreate = driver.findElements(By.xpath("//ul[contains(@class, 'navigation')]/li/a")).get(0);
  	buttonCreate.click();
  	
  	WebElement nameField = driver.findElement(By.xpath("//input[@id='poi_name']"));
  	nameField.sendKeys("Test name");
  	
  	WebElement buttonSelectCategory = driver.findElement(By.xpath("//div[contains(@class, 'category-selector-container')]/button"));
  	buttonSelectCategory.click();
  	
  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'category-selector-row')]/div[contains(@class, 'span3')]/select")));
  	
  	WebElement categoryDropDownList = chromeDriver.findElement(By.xpath("//div[contains(@class, 'category-selector-row')]")).findElement(By.xpath(".//div[contains(@class, 'span3')]")).findElement(By.tagName("select"));
  	assertTrue(categoryDropDownList.isDisplayed());
  	
  	Select select = new Select(categoryDropDownList);
  	select.selectByValue("8");
  	
  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'category-selector-row')]/div[position() = 3]/select")));
  	
  	WebElement subcategoryDropDownList = driver.findElement(By.xpath("//div[contains(@class, 'category-selector-row')]")).findElements(By.tagName("select")).get(1);
  	
  	assertTrue(subcategoryDropDownList.isDisplayed());
  	
  	Select select2 = new Select(subcategoryDropDownList);
  	select2.selectByIndex(2);
  	
  	WebElement buttonSubmit = driver.findElement(By.xpath("//button[contains(@class, 'btn-success')]"));
  	
  	// Element not visible exception???
  	// buttonSubmit.click();
  }
  
  @Test
  public void Suggestion()
  {
  	WebElement buttonCreate = driver.findElements(By.xpath("//ul[contains(@class, 'navigation')]/li/a")).get(1);
  	buttonCreate.click();
  	
  	WebElement commentTextArea = driver.findElement(By.xpath("//textarea[@name='comment']"));
  	commentTextArea.sendKeys("Komentar");
  	
  	WebElement radioButton = driver.findElements(By.xpath("//input[@type='radio']")).get(1);
  	radioButton.click();
  	
  	WebElement sendButton = driver.findElement(By.xpath("//input[@type='submit']"));
  	sendButton.click();
  	
  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert-success')]")));
  	
  	WebElement succesMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
  	assertTrue(succesMessage.isDisplayed());
  }
  
  @Test
  public void MapTest()
  {
  	WebElement zoomInButton = driver.findElement(By.xpath("//a[@title='Zoom in']"));
  	zoomInButton.click();
  	
  	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  	
  	WebElement zoomOutButton = driver.findElement(By.xpath("//a[@title='Zoom out']"));
  	zoomOutButton.click();
  	
  	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  	
  	WebElement mapViewButton = driver.findElement(By.xpath("//a[contains(@class, 'leaflet-control-layers-switch')]"));
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
  
  @BeforeTest
  public void beforeTest() {
	  //TODO: Logic to change browser
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.gecko.driver", "/home/atlantbh/geckodriver");
      System.setProperty("webdriver.chrome.driver", "/home/atlantbh/chromedriver");
	  
	  chromeDriver = new ChromeDriver();
	  
	  driver = chromeDriver;
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  wait = new WebDriverWait(driver, 10);
	  
	  driver.get("http://www.navigator.ba");
  }

  @AfterSuite
  public void afterSuite() {
	  chromeDriver.close();
  }

}
