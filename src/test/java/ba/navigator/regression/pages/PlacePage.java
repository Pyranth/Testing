package ba.navigator.regression.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlacePage extends DefaultPage {
	@FindBy(xpath = "//div[contains(@class, 'profile-image-container')]")
	private WebElement image;
	
	@FindBy(xpath = "//div[contains(@class, 'address')]")
	private WebElement address;
	
	@FindBy(xpath = "//div[contains(@class, 'description')]")
	private WebElement description;
	
	@FindBy(xpath = "//button[contains(@class, 'btn-claim')]")
	private WebElement claimButton;

	@FindBy(xpath = "//button[contains(@class, 'btn-suggest-edit')]")
	private WebElement suggestButton;
	
	@FindBy(xpath = "//div[contains(@class, 'mCSB_draggerContainer')]")
	private WebElement draggablePartOfScrollbar;
	
	@FindBy(xpath = "//form[@id = 'place-form']")
	private WebElement editForm;
	
	@FindBy(xpath = "//form[@id = 'claim-place']")
	private WebElement claimForm;

	public PlacePage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public void waitForLoading()
	{
		wait.until(ExpectedConditions.visibilityOf(image));
	}
	
	public void scrollDown()
	{
		Actions dragger = new Actions(driver);

	  	while(!claimButton.isDisplayed())
	  	{
	  	    try {
	  	    	// Kinda hacky but works
	  	    	dragger.moveToElement(draggablePartOfScrollbar, 0, draggablePartOfScrollbar.getSize().getHeight() - 50).click().build().perform();
	  	        Thread.sleep(1000L);
	  	    } catch(Exception e1){}
	  	} 
	}
	
	public WebElement getImage() {
		return image;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getClaimButton() {
		return claimButton;
	}

	public WebElement getSuggestButton() {
		return suggestButton;
	}

	public WebElement getEditForm() {
		return editForm;
	}

	public WebElement getClaimForm() {
		return claimForm;
	}

}
