package ba.navigator.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	WebDriver chromeDriver = new ChromeDriver();
	
	public App() {
		
		InitializeTests();
	}
	
    public static void main( String[] args )
    {
        System.setProperty("webdriver.gecko.driver", "/home/atlantbh/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/atlantbh/chromedriver");
        
        new App();
    }
    
    private void InitializeTests()
    {
    	chromeDriver.get("http://www.navigator.ba");
    	
    	// Test scenario 1
    	try {
	    	ChooseCategory(chromeDriver);
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	// Test scenario 2
    	try {
    		ChoosePlaceFromList(chromeDriver);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    	// Test scenario 3
    	try {
    		CreateNewPlace(chromeDriver);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    	// Test scenario 4
    	try {
    		Suggestion(chromeDriver);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    	// Test scenario 5
    	try {
    		MapTest(chromeDriver);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    }
    
    private void ChooseCategory(WebDriver driver)
    {
    	WebElement category = driver.findElement(By.className("accommodation"));
        category.click();
        
        // TODO: Check if locations are displayed, and if places are displayed in left pane.
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        List<WebElement> places = driver.findElements(By.xpath("//div[contains(@class, 'map-marker-icon')]"));
        System.out.println(places.size());
    }
    
    private void ChoosePlaceFromList(WebDriver driver)
    {	
    	// Ovde pronalazim div element koji sadrzi listu (ul) objekata. Ucita samo script elemente, ne vidi ul.
    	// Pretpostavljam da je potrebno sacekati da se lista ucita, ali ne znam kako?
    	WebElement list = driver.findElement(By.xpath("//div[contains(@class, 'left-menu-pane')]/div/div[contains(@class, 'mCSB_container')]"));
    }
    
    private void CreateNewPlace(WebDriver driver)
    {
    	WebElement buttonCreate = driver.findElement(By.xpath("//li[@title='Kreiraj objekat' or @title='Create place']/a"));
    	buttonCreate.click();
    	
    	WebElement nameField = driver.findElement(By.xpath("//input[@id='poi_name']"));
    	nameField.sendKeys("Test name");
    	
    	WebElement buttonSelectCategory = driver.findElement(By.xpath("//div[contains(@class, 'category-selector-container')]/button"));
    	buttonSelectCategory.click();
    	
    	// Ponovo isti problem sa ucitavanjem.
    	WebElement categoryDropDownList = driver.findElement(By.xpath("//div[contains(@class, 'category-selector-row')]"));
    	
    	WebElement buttonSubmit = driver.findElement(By.xpath("//button[contains(@class, 'btn-success')]"));
    	// Element not visible exception???
    	buttonSubmit.click();
    }
    
    private void Suggestion(WebDriver driver)
    {
    	WebElement buttonCreate = driver.findElement(By.xpath("//li[@title='Predloži ideju - Pošalji komentar' or @title='Suggest features - Report a problem']/a"));
    	buttonCreate.click();
    	
    	WebElement commentTextArea = driver.findElement(By.xpath("//textarea[@title='Komentar']"));
    	commentTextArea.sendKeys("Komentar");
    	
    	WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio' and @value='Kritika']"));
    	radioButton.click();
    	
    	WebElement sendButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Pošalji']"));
    	sendButton.click();
    }
    
    private void MapTest(WebDriver driver)
    {
    	WebElement zoomInButton = driver.findElement(By.xpath("//a[@title='Zoom in']"));
    	zoomInButton.click();
    	
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	WebElement zoomOutButton = driver.findElement(By.xpath("//a[@title='Zoom out']"));
    	zoomOutButton.click();
    	
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	WebElement mapViewButton = driver.findElement(By.xpath("//a[contains(@class, 'leaflet-control-layers-switch')]"));
    	mapViewButton.click();
    	
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	mapViewButton.click();
    }
}
