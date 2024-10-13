package testCases;

import framework.BrowserUtils;
import framework.Loggers;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestCases {

    @Test(description = "First Test Case",priority = 1)
    public void firstTestCase() throws InterruptedException {
        WebDriver driver=BrowserUtils.getDriver("Chrome");
        driver.get("https://www.nba.com/warriors/");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[text()='x']")).click();

        Thread.sleep(3000);
        Actions a1=new Actions(driver);
        a1.moveToElement(driver.findElement(By.xpath("//span[text()='Shop']"))).build().perform();

        driver.findElement(By.xpath("//li[@class='menu-item']/descendant::a[contains(@title,'Men')]")).click();

        Set<String> handles=driver.getWindowHandles();

        for(String handle:handles) {
            driver.switchTo().window(handle);
        }

        Thread.sleep(10000);

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");

        a1.moveToElement(driver.findElement(By.xpath("//span[text()='Jackets']")))
                .click(driver.findElement(By.xpath("//span[text()='Jackets']"))).build().perform();

        while(driver.findElements(By.xpath("//li[@class='filter-selector-item']/descendant::span[text()='Jackets']")).size()==0)
        {
            Long scrollPosition = (Long)  ((JavascriptExecutor)driver).executeScript("return window.pageYOffset;");

            if(scrollPosition!=1000)
            {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
            }

            a1.moveToElement(driver.findElement(By.xpath("//span[text()='Jackets']")))
                    .click(driver.findElement(By.xpath("//span[text()='Jackets']"))).build().perform();
        }

        System.out.println(driver.findElements(By.xpath("(//div[@class='page-list'])[1]/descendant::a[@data-talos='linkSearchResultsPage']")).size());

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");

        for(int i=0;i<driver.findElements(By.xpath("(//div[@class='page-list'])[1]/descendant::a[@data-talos='linkSearchResultsPage']")).size();i++)
        {
            driver.findElements(By.xpath("(//div[@class='page-list'])[1]/descendant::a[@data-talos='linkSearchResultsPage']")).get(i).click();

            Thread.sleep(1000);

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

    @SneakyThrows
    @Test(description = "Second Test Case")
    public void performSecondTestCase()
    {

        WebDriver driver=BrowserUtils.getDriver("Chrome");
        driver.get("https://www.nba.com/warriors/");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[text()='x']")).click();

        Thread.sleep(5000);
        Actions a1=new Actions(driver);

        a1.moveToElement(
        driver.findElement(By.xpath("//a[@rel='noreferrer']/span[text()='...']"))).build().perform();

        driver.findElement(By.xpath("//nav[contains(@class,'_headerPrimaryMenu')]/following-sibling::nav/descendant::a[@title='News & Features']")).click();

        System.out.println(driver.findElements(By.xpath("//h3[text()='VIDEOS']/../following-sibling::div/descendant::span[text()='3d']")).size());
    }

    @Test(description = "Third Test Case")
    public void performThirdTestCase()
    {
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.nba.com/sixers/");

        driver.manage().window().maximize();

        List<WebElement> elements=driver.findElements(By.xpath("//div[@class='swiper-wrapper']/descendant::div[contains(@class,'slide')]/descendant::div[contains(@class,'gameHeader')]"));

        System.out.println("Total Number Of Slides: "+elements.size());

        while(driver.findElements(By.xpath("//button[@aria-label='Move left' and contains(@class,'events-none')]")).size()==0)
        {
            driver.findElement(By.xpath("//button[@aria-label='Move left']")).click();
        }

        for(int i=0;i<elements.size();i++)
        {
            System.out.println(driver.findElements(By.xpath("//div[contains(@class,'gameHeader')]")).get(i).getText());

            driver.findElement(By.xpath("//button[@aria-label='Move right']")).click();
        }

    }

    @Test(description = "Fourth Test Case")
    public void fourthTestCase()
    {
        WebDriver driver= BrowserUtils.getDriver("Chrome");

        driver.get("https://www.nba.com/bulls/");

        driver.manage().window().maximize();

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");

        List<WebElement> elements=driver.findElements(By.xpath("//footer/descendant::a"));

        List<String> listOfHyperLinks=new ArrayList<String>();

        for(WebElement element:elements)
        {
            listOfHyperLinks.add(element.getAttribute("href"));
        }

        Set<String> listOfDuplicates=listOfHyperLinks.stream().filter(e -> Collections.frequency(listOfHyperLinks,e)>1)
                .collect(Collectors.toSet());

        System.out.println("List Of Duplicates: "+listOfDuplicates);

        Loggers.writeDataToTheFile(System.getProperty("user.dir")+"/CSVFiles//ListOfLinks.csv",listOfHyperLinks.toString());
    }

}
