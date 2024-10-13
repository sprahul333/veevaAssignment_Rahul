package stepDefinitions;

import business.BullsBusiness;
import framework.ReusableLibrary;
import io.cucumber.java.en.Then;

public class BullsStepDefs extends ReusableLibrary {

    BullsBusiness bullsBusiness = new BullsBusiness();

    @Then("Capture all the hyperlinks in the footer section and store it in a CSV File")
    public void captureAllTheHyperlinksInTheFooterSectionAndStoreItInACSVFile()
    {
        bullsBusiness.captureFooterLinks();
    }

}
