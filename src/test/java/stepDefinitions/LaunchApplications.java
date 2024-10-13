package stepDefinitions;

import framework.ReusableLibrary;
import io.cucumber.java.en.Given;

public class LaunchApplications extends ReusableLibrary {

    @Given("I am on the chicago bulls site")
    public void i_am_on_the_chicago_bulls_site() {
        actionsUtil.launchApplication(Thread.currentThread().getStackTrace()[1].getLineNumber(),propertiesUtil.getDP2URL());
    }

    @Given("I am on the warriors site")
    public void iAmOnTheWarriorsSite() {
        actionsUtil.launchApplication(Thread.currentThread().getStackTrace()[1].getLineNumber(),propertiesUtil.getCPURL());
    }

    @Given("I am on the philadelphia sixers site")
    public void iAmOnThePhiladelphiaSixersSite() {
        actionsUtil.launchApplication(Thread.currentThread().getStackTrace()[1].getLineNumber(),propertiesUtil.getDP1URL());
    }
}
