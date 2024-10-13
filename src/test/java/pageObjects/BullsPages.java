package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BullsPages extends BasePage {

    public BullsPages()
    {
        super();
    }

    @FindBy(xpath = "//footer/descendant::a")
    public List<WebElement> lnk_FooterLinks;
}
