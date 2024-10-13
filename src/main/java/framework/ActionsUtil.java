package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ActionsUtil {

    WebDriver driver;
    Reports reports;
    TestUtil testUtil;

    public ActionsUtil(WebDriver driver, Reports reports,TestUtil testUtil)
    {
        this.driver=driver;
        this.reports=reports;
        this.testUtil=testUtil;
    }

    public void launchApplication(int lineNumber,String url)
    {
        try
        {
            if (!url.startsWith("https"))
                throw new FrameworkException("URL should start with https", testUtil, lineNumber);

            driver.get(url);
        }

        catch (WebDriverException e2)
        {
            throw new FrameworkException("Unable to launch the application due to: "+e2.getMessage(), testUtil, lineNumber);
        }
    }

    public boolean waitForElementToBeClickable(int lineNumber, WebElement element)
    {
        try
        {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }

        catch (Exception e2)
        {
            return false;
        }


    }

    public void clickOnElement(int lineNumber, WebElement element,String eleType, String labelName)
    {
        try
        {
            if(waitForElementToBeClickable(lineNumber,element))
            {
                moveToElement(lineNumber,element,labelName);
                element.click();
            }

            else
                throw new FrameworkException("Element is not clickable for: "+labelName, testUtil, lineNumber);
        }

        catch (NoSuchElementException e2)
        {
            throw new FrameworkException("Unable to click on "+eleType+" with label "+labelName+" due to: "+e2.getMessage(), testUtil, lineNumber);
        }

        catch (ElementClickInterceptedException e3)
        {
            throw new FrameworkException("Unable to click on "+eleType+" with label "+labelName+" due to: "+e3.getMessage(), testUtil, lineNumber);
        }

        catch (ElementNotInteractableException e4)
        {
            throw new FrameworkException("Unable to click on "+eleType+" with label "+labelName+" due to: "+e4.getMessage(), testUtil, lineNumber);
        }

        catch (StaleElementReferenceException e5)
        {
            throw new FrameworkException("Unable to click on "+eleType+" with label "+labelName+" due to: "+e5.getMessage(), testUtil, lineNumber);
        }

        catch (WebDriverException e6)
        {
            throw new FrameworkException("Unable to click on "+eleType+" with label "+labelName+" due to: "+e6.getMessage(), testUtil, lineNumber);
        }

    }

    public void enterDataIntoTextBox(int lineNumber, WebElement element, String eleType, String labelName, String data)
    {
        try
        {
            if(element.getAttribute("value").equalsIgnoreCase(data))
                return;
            else if(element.getAttribute("value").isBlank() || element.getAttribute("value").isEmpty())
                element.sendKeys(data);
            else
            {
                element.clear();
                element.sendKeys(data);
            }

            element.sendKeys(data);
        }

        catch (NoSuchElementException e2)
        {
            throw new FrameworkException("Unable to enter data into "+eleType+" with label "+labelName+" due to: "+e2.getMessage(), testUtil, lineNumber);
        }

        catch (ElementNotInteractableException e3)
        {
            throw new FrameworkException("Unable to enter data into "+eleType+" with label "+labelName+" due to: "+e3.getMessage(), testUtil, lineNumber);
        }

        catch (StaleElementReferenceException e4)
        {
            throw new FrameworkException("Unable to enter data into "+eleType+" with label "+labelName+" due to: "+e4.getMessage(), testUtil, lineNumber);
        }

        catch (WebDriverException e5)
        {
            throw new FrameworkException("Unable to enter data into "+eleType+" with label "+labelName+" due to: "+e5.getMessage(), testUtil, lineNumber);
        }
    }

    public void clickAndHoldElement(int lineNumber, WebElement element, String eleType, String labelName)
    {
        try
        {
            if(waitForElementToBeClickable(lineNumber,element))
            {
                Actions actions=new Actions(driver);
                actions.moveToElement(element).clickAndHold(element).build().perform();
            }

            else
                throw new FrameworkException("Element is not clickable for: "+labelName, testUtil, lineNumber);
        }

        catch (NoSuchElementException e2)
        {
            throw new FrameworkException("Unable to click and hold on "+eleType+" with label "+labelName+" due to: "+e2.getMessage(), testUtil, lineNumber);
        }

        catch (ElementClickInterceptedException e3)
        {
            throw new FrameworkException("Unable to click and hold on "+eleType+" with label "+labelName+" due to: "+e3.getMessage(), testUtil, lineNumber);
        }

        catch (ElementNotInteractableException e4)
        {
            throw new FrameworkException("Unable to click and hold on "+eleType+" with label "+labelName+" due to: "+e4.getMessage(), testUtil, lineNumber);
        }

        catch (StaleElementReferenceException e5)
        {
            throw new FrameworkException("Unable to click and hold on "+eleType+" with label "+labelName+" due to: "+e5.getMessage(), testUtil, lineNumber);
        }

        catch (WebDriverException e6)
        {
            throw new FrameworkException("Unable to click and hold on "+eleType+" with label "+labelName+" due to: "+e6.getMessage(), testUtil, lineNumber);
        }
    }

    public void moveToElement(int lineNumber, WebElement element, String labelName)
    {
        try
        {
            Actions actions=new Actions(driver);
            actions.moveToElement(element).build().perform();
        }

        catch (NoSuchElementException e2)
        {
            throw new FrameworkException("Unable to move to label "+labelName+" due to: "+e2.getMessage(), testUtil, lineNumber);
        }

        catch (ElementClickInterceptedException e3)
        {
            throw new FrameworkException("Unable to move to label "+labelName+" due to: "+e3.getMessage(), testUtil, lineNumber);
        }

        catch (ElementNotInteractableException e4)
        {
            throw new FrameworkException("Unable to move to label "+labelName+" due to: "+e4.getMessage(), testUtil, lineNumber);
        }

        catch (StaleElementReferenceException e5)
        {
            throw new FrameworkException("Unable to move to label "+labelName+" due to: "+e5.getMessage(), testUtil, lineNumber);
        }

        catch (WebDriverException e6)
        {
            throw new FrameworkException("Unable to move to label "+labelName+" due to: "+e6.getMessage(), testUtil, lineNumber);
        }
    }

    public String getElementText(int lineNumber, WebElement element,String labelName)
    {
        try
        {
            return element.getText();
        }

        catch (NoSuchElementException e2)
        {
            throw new FrameworkException("Unable to get the text from "+labelName+" due to: "+e2.getMessage(), testUtil, lineNumber);
        }
    }

    public void switchToNewWindow()
    {
        Set<String> handles=driver.getWindowHandles();

        for(String handle:handles) {
            driver.switchTo().window(handle);
        }

    }

    public void scrollPageToTheTop()
    {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public void scrollPageToTheBottom()
    {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollPageDown(int pixels)
    {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+pixels+")");
    }

    public void scrollPageUp(int pixels)
    {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-"+pixels+")");
    }

}
