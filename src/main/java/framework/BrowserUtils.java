package framework;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Collections;

@UtilityClass
public class BrowserUtils {

    public void killBrowsers()
    {
        try {
            Runtime.getRuntime().exec("taskkill /f /im chrome.exe /t");
            Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe /t");
            Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe /t");
            Runtime.getRuntime().exec("taskkill /f /im msedgedriver.exe /t");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver(String browserName)
    {
        WebDriver driver;
        return switch (browserName.toUpperCase()) {
            case "CHROME" ->
            {
                ChromeOptions chromeOptions=new ChromeOptions();

                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--disable-extensions");

                chromeOptions.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
                chromeOptions.setExperimentalOption("useAutomationExtension",false);

                chromeOptions.setExperimentalOption("prefs", Collections.singletonMap("profile.default_content_setting_values.notifications", 2));

                driver = new ChromeDriver(chromeOptions);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
                driver.manage().window().maximize();
                yield driver;
            }
            case "FIREFOX" -> {
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
                driver.manage().window().maximize();
                yield driver;
            }
            case "EDGE" -> {
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
                driver.manage().window().maximize();
                yield driver;
            }
            default -> throw new IllegalStateException("Unexpected value: " + browserName.toUpperCase());
        };
    }
}
