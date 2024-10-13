package stepDefinitions;

import business.SixersBusiness;
import framework.ReusableLibrary;
import io.cucumber.java.en.Then;

public class SixersStepDefs extends ReusableLibrary {

    SixersBusiness sixersBusiness=new SixersBusiness();

    @Then("I navigate through the slides")
    public void iNavigateThroughTheSlides() {
        sixersBusiness.navigateThroughSlides();
    }

    @Then("I should capture the total of slides along with the title")
    public void iShouldCaptureTheTotalOfSlidesAlongWithTheTitle() {
        sixersBusiness.captureSlideDetails();
    }
}
