package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SixersPages extends BasePage {

    public SixersPages()
    {
        super();
    }

    public By lnk_GameSliders=By.xpath("//div[@class='swiper-wrapper']/descendant::div[contains(@class,'slide')]/descendant::div[contains(@class,'gameHeader')]");

    @FindBy(xpath = "//button[@aria-label='Move left']")
    public WebElement lnk_MoveLeft;

    @FindBy(xpath = "//button[@aria-label='Move right']")
    public WebElement lnk_MoveRight;

    @FindBy(xpath = "//button[@aria-label='Move left' and contains(@class,'events-none')]")
    public List<WebElement> lnk_NavigateToLeftCompletly;

}
