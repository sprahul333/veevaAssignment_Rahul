package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WarriorsPages extends BasePage {

    public WarriorsPages()
    {
        super();
    }

    @FindBy(xpath = "//div[text()='x']")
    public WebElement btn_ClosePopUp;

    @FindBy(xpath = "//span[text()='Shop']")
    public WebElement lnk_Shop;

    @FindBy(xpath = "//li[@class='menu-item']/descendant::a[contains(@title,'Men')]")
    public WebElement lnk_Men;

    @FindBy(xpath = "//span[text()='Jackets']")
    public WebElement lnk_Jackets;

    @FindBy(xpath = "//li[@class='filter-selector-item']/descendant::span[text()='Jackets']")
    public List<WebElement> li_JacketsPages;

    @FindBy(xpath = "(//div[@class='page-list'])[1]/descendant::a[@data-talos='linkSearchResultsPage']")
    public List<WebElement> lnk_JacketsResults;

    public By fld_DiscountedPrices=By.xpath("//div[@class='column']/descendant::span[contains(@class,'primary')]");
    public By fld_ProductTitles=By.xpath("//div[@class='column']/descendant::span[contains(@class,'primary')]/ancestor::div[@class='spacing']/following-sibling::div[contains(@class,'title')] | //div[@class='column']/descendant::span[contains(@class,'nodiscountpricetext')]/../span/span[@class='sr-only']/ancestor::div[@class='spacing']/following-sibling::div[contains(@class,'title')]");

    public By fld_NonDiscountedPrices=By.xpath("//div[@class='column']/descendant::span[contains(@class,'nodiscountpricetext')]/../span/span[@class='sr-only']");

    @FindBy(xpath = "//a[@rel='noreferrer']/span[text()='...']")
    public WebElement lnk_MoreMenus;

    @FindBy(xpath = "//nav[contains(@class,'_headerPrimaryMenu')]/following-sibling::nav/descendant::a[@title='News & Features']")
    public WebElement lnk_NewsAndFeatures;

    @FindBy(xpath = "//h3[text()='VIDEOS']/../following-sibling::div/descendant::span[text()='3d']")
    public List<WebElement> lnk_VideosOlderThanThreeDays;

    @FindBy(xpath = "//h3[text()='VIDEOS']")
    public WebElement fld_Videos;
}
