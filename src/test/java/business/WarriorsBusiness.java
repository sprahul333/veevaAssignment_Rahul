package business;

import framework.ReusableLibrary;
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
    }
}
