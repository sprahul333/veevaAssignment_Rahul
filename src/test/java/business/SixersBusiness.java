package business;

import framework.ReusableLibrary;
import org.openqa.selenium.By;
import pageActions.SixersPageActions;
import pageObjects.SixersPages;

public class SixersBusiness extends ReusableLibrary {

    SixersPageActions sixersPageActions=new SixersPageActions();

    public void navigateThroughSlides()
    {
        while(!sixersPageActions.navigateToLeftCompletly())
        {
            sixersPageActions.clickOnMoveLeft(Thread.currentThread().getStackTrace()[1].getLineNumber());
        }
    }

    public void captureSlideDetails()
    {
        for(int i=0;i<driver.findElements(new SixersPages().lnk_GameSliders).size();i++)
        {
            System.out.println("Slide Title: "+driver.findElements(new SixersPages().lnk_GameSliders).get(i).getText());
            sixersPageActions.clickOnMoveRight(Thread.currentThread().getStackTrace()[1].getLineNumber());
        }
    }

}
