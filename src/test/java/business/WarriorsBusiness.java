package business;

import framework.ReusableLibrary;
import framework.SuiteUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pageActions.WarriorsPageActions;

public class WarriorsBusiness extends ReusableLibrary {

    WarriorsPageActions warriorsPageActions=new WarriorsPageActions();

    public void clickOnVideoFeedLink()
    {
        warriorsPageActions.clickOnClose(Thread.currentThread().getStackTrace()[1].getLineNumber());
        warriorsPageActions.hoverOnMoreMenus(Thread.currentThread().getStackTrace()[1].getLineNumber());
        warriorsPageActions.clickOnNewsAndFeatures(Thread.currentThread().getStackTrace()[1].getLineNumber());
    }

    public void verifyVideoFeedPage()
    {
        warriorsPageActions.navigateToVideosSection(Thread.currentThread().getStackTrace()[1].getLineNumber());
        warriorsPageActions.getVideosGreaterThanThreeDays();
    }

    public void navigateToJacketsLink()
    {
        warriorsPageActions.clickOnClose(Thread.currentThread().getStackTrace()[1].getLineNumber());
        warriorsPageActions.clickOnShop(Thread.currentThread().getStackTrace()[1].getLineNumber());
        warriorsPageActions.clickOnMen(Thread.currentThread().getStackTrace()[1].getLineNumber());

        actionsUtil.scrollPageDown(1000);

        warriorsPageActions.clickOnJackets(Thread.currentThread().getStackTrace()[1].getLineNumber());

        SuiteUtil.applySleep(10000);

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");

        while(!warriorsPageActions.getJacketsPages())
        {
            Long scrollPosition = (Long)  ((JavascriptExecutor)driver).executeScript("return window.pageYOffset;");

            if(scrollPosition!=1000)
            {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
            }

            warriorsPageActions.clickOnJackets(Thread.currentThread().getStackTrace()[1].getLineNumber());
        }
    }

    public void captureJacketDetails()
    {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");

        for(int i=0;i<driver.findElements(By.xpath("(//div[@class='page-list'])[1]/descendant::a[@data-talos='linkSearchResultsPage']")).size();i++)
        {
            driver.findElements(By.xpath("(//div[@class='page-list'])[1]/descendant::a[@data-talos='linkSearchResultsPage']")).get(i).click();

            SuiteUtil.applySleep(1000);

            for(int j=0;j<driver.findElements(By.xpath("//div[@class='column']/descendant::span[contains(@class,'primary')]")).size();j++)
            {
                System.out.println(driver.findElements(By.xpath("//div[@class='column']/descendant::span[contains(@class,'primary')]")).get(j).getText());
                System.out.println(driver.findElements(By.xpath("//div[@class='column']/descendant::span[contains(@class,'primary')]/ancestor::div[@class='spacing']/following-sibling::div[contains(@class,'title')]")).get(j).getText());
            }

            for(int k=0;k<driver.findElements(By.xpath("//div[@class='column']/descendant::span[contains(@class,'nodiscountpricetext')]/../span/span[@class='sr-only']")).size();k++)
            {
                System.out.println(driver.findElements(By.xpath("//div[@class='column']/descendant::span[contains(@class,'nodiscountpricetext')]/../span/span[@class='sr-only']")).get(k).getText());
                System.out.println(driver.findElements(By.xpath("//div[@class='column']/descendant::span[contains(@class,'nodiscountpricetext')]/../span/span[@class='sr-only']/ancestor::div[@class='spacing']/following-sibling::div[contains(@class,'title')]")).get(k).getText());
            }

        }

    }
}
