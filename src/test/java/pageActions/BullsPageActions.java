package pageActions;

import framework.ReusableLibrary;
import org.openqa.selenium.WebElement;
import pageObjects.BullsPages;

import java.util.List;

public class BullsPageActions extends ReusableLibrary {

    BullsPages bullsPageObjects = new BullsPages();

    public List<WebElement> clickOnFooterLink() {
        return bullsPageObjects.lnk_FooterLinks;
    }
}
