package ba.navigator.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.setProperty("webdriver.gecko.driver", "/home/atlantbh/geckodriver");
        
        TestNG ng = new TestNG();
        
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.navigator.ba");
        driver.close();
    }
}
