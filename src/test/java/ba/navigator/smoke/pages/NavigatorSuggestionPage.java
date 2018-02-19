package ba.navigator.smoke.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorSuggestionPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By navButtons = By.xpath("//ul[contains(@class, 'navigation')]/li/a");
	private By comment = By.xpath("//textarea[@name='comment']");
	private By radios = By.xpath("//input[@type='radio']");
	private By submit = By.xpath("//input[@type='submit']");
	private By successMessage = By.xpath("//div[contains(@class, 'alert-success')]");

	public NavigatorSuggestionPage(WebDriver driver) {
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 10);
	}
	
	public void sendSuggestion()
	{
		WebElement buttonCreate = driver.findElements(navButtons).get(1);
		buttonCreate.click();
		
		WebElement commentTextArea = driver.findElement(comment);
		commentTextArea.sendKeys("Komentar");
		
		WebElement radioButton = driver.findElements(radios).get(1);
		radioButton.click();
		
		WebElement sendButton = driver.findElement(submit);
		sendButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
	}
	
	public WebElement getSuccessMessage()
	{
		WebElement succesMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
		
		return succesMessage;
	}
}
