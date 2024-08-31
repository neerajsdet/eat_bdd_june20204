package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getDriver(String browserName){
        WebDriver driver=null;
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver();
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver();
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser Name");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }



}
