package pageActions;

import framework.ReusableLibrary;
import pageObjects.SixersPages;

public class SixersPageActions extends ReusableLibrary {

    SixersPages sixersPageObjects = new SixersPages();

    public void clickOnMoveLeft(int lineNumber) {
        actionsUtil.clickOnElement(lineNumber, sixersPageObjects.lnk_MoveLeft,"Button","Move Left");
    }

    public void clickOnMoveRight(int lineNumber) {
        actionsUtil.clickOnElement(lineNumber, sixersPageObjects.lnk_MoveRight,"Button","Move Right");
    }

    public boolean navigateToLeftCompletly() {
        return sixersPageObjects.lnk_NavigateToLeftCompletly.size()>0;
    }
}
