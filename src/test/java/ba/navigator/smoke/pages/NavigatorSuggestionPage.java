package ba.navigator.smoke.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorSuggestionPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//ul[contains(@class, 'navigation')]/li/a")
	private List<WebElement> navButtons;
	
	@FindBy(xpath = "//textarea[@name='comment']")
	private WebElement commentTextArea;
	
	@FindBy(xpath = "//input[@type='radio']")
	private List<WebElement> radios;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement sendButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
	private WebElement successMessage;

	public NavigatorSuggestionPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		
		PageFactory.initElements(driver, this);
	}
	
	public void sendSuggestion(String comment)
	{
		navButtons.get(1).click();
		commentTextArea.sendKeys(comment);
		radios.get(1).click();
		sendButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(successMessage));
	}
	
	public WebElement getSuccessMessage()
	{
		return successMessage;
	}
}
