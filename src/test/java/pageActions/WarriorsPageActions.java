package pageActions;

import framework.ReusableLibrary;
import pageObjects.WarriorsPages;

public class WarriorsPageActions extends ReusableLibrary {

    WarriorsPages warriorsPageObjects = new WarriorsPages();

    public void closePopUp(int lineNumber) {
        actionsUtil.clickOnElement(lineNumber, warriorsPageObjects.btn_ClosePopUp,"Button","Close");
    }

    public void clickOnShop(int lineNumber) {
        actionsUtil.moveToElement(lineNumber, warriorsPageObjects.lnk_Shop,"Shop");
    }

    public void clickOnMen(int lineNumber) {
        actionsUtil.clickOnElement(lineNumber, warriorsPageObjects.lnk_Men,"Link Text","Men");
    }

    public void clickOnJackets(int lineNumber) {
        actionsUtil.clickOnElement(lineNumber, warriorsPageObjects.lnk_Jackets,"Link Text","Jackets");
    }

    public void clickOnClose(int lineNumber) {
        actionsUtil.clickOnElement(lineNumber, warriorsPageObjects.btn_ClosePopUp,"Button","Close");
    }

    public void clickOnMoreMenus(int lineNumber) {
        actionsUtil.clickOnElement(lineNumber, warriorsPageObjects.lnk_MoreMenus,"Link Text","More Menus");
    }


    public void hoverOnMoreMenus(int lineNumber) {
        actionsUtil.moveToElement(lineNumber, warriorsPageObjects.lnk_MoreMenus,"More Menus");
    }

    public void clickOnNewsAndFeatures(int lineNumber) {
        actionsUtil.clickOnElement(lineNumber, warriorsPageObjects.lnk_NewsAndFeatures,"Link Text","News And Features");
    }

    public boolean getVideosGreaterThanThreeDays()
    {
        return warriorsPageObjects.lnk_VideosOlderThanThreeDays.size()>0;
    }

    public void navigateToVideosSection(int lineNumber)
    {
        actionsUtil.moveToElement(lineNumber, warriorsPageObjects.fld_Videos,"Videos");
    }
}
