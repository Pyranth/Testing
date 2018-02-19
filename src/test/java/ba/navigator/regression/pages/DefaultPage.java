package ba.navigator.regression.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefaultPage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public DefaultPage(WebDriver driver) {
		this.driver = driver;
		setWebDriverWait();
	}
	
	private void setWebDriverWait()
	{
		this.wait = new WebDriverWait(driver, 10);
	}
}
