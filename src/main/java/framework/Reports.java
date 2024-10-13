package framework;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.io.Files;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Reports {

    TestUtil testUtil;
    public Reports(TestUtil testUtil)
    {
        this.testUtil=testUtil;
    }

    @SneakyThrows
    public String captureScreenshots(String...imageName)
    {
        String screenshotPath=SuiteUtil.getScreenshotsPath(imageName);

        File src = ((TakesScreenshot) testUtil.getDriver()).getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotPath);

        Files.copy(src, dest);

        return screenshotPath;
    }

    public static String getColoredLog(String Log, boolean bold) {

        if (bold)
            return "<font color='#FF5733'><b>" + Log + "</b></font>";
        else
            return "<font color='#FF5733'>" + Log + "</font>";
    }

    public static String getPassLog(String Log, boolean bold) {

        if (bold)
            return "<font color='#6AA84F'><b>" + Log + "</b></font>";
        else
            return "<font color='#6AA84F'>" + Log + "</font>";
    }

    public static String getSkipColoredLog(String Log, boolean bold) {
        if (bold)
            return "<font color='#FFFF00'><b>" + Log + "</b></font>";
        else
            return "<font color='#FFFF00'>" + Log + "</font>";
    }

    public static String getHigligthedColoredLog(String Log, boolean bold) {
        if (bold)
            return "<p style='background-color:#FFFFFF; color:blue;'><b>" + Log + "</b></font>";
        else
            return "<p style='background-color:#FFFFFF; color:blue;'>" + Log + "</font>";
    }


    }
