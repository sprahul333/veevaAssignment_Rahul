package framework;

import com.google.common.io.Files;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Reports {

    WebDriver driver;
    public Reports(WebDriver driver)
    {
        this.driver=driver;
    }

    @SneakyThrows
    public String captureScreenshots(String...imageName)
    {
        String screenshotPath=SuiteUtil.getScreenshotsPath(imageName);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotPath);

        Files.copy(src, dest);

        return screenshotPath;
    }
}
