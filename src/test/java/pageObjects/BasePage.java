package pageObjects;

import framework.ReusableLibrary;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends ReusableLibrary {

    public BasePage () {
        PageFactory.initElements(driver, this);
    }
}
