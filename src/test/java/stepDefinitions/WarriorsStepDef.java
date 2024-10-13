package stepDefinitions;

import business.WarriorsBusiness;
import framework.ReusableLibrary;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageActions.WarriorsPageActions;

public class WarriorsStepDef extends ReusableLibrary {

    WarriorsBusiness warriorsBusiness=new WarriorsBusiness();

    @When("I click on the video feed link")
    public void iClickOnTheVideoFeedLink() {
        warriorsBusiness.clickOnVideoFeedLink();
    }

    @When("I should see the video feed page")
    public void iShouldSeeTheVideoFeedPage() {
        warriorsBusiness.verifyVideoFeedPage();
    }

    @When("I click on the jackets link")
    public void iClickOnTheJacketsLink() {
        warriorsBusiness.navigateToJacketsLink();
    }

    @And("I should see the jackets details")
    public void iShouldSeeTheJacketsDetails()
    {
        warriorsBusiness.captureJacketDetails();
    }
}
