package stepDefinitions;

import framework.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    TestUtil testUtil=new TestUtil();

    @Before
    public void beforeTestCase(Scenario sc)
    {
        if(ReusableLibrary.testUtilThread.get()==null)
        {
            testUtil.setPropertiesUtil(new PropertiesUtil());
            testUtil.setDriver(BrowserUtils.getDriver("Chrome"));
            testUtil.setReports(new Reports(testUtil.getDriver()));
            testUtil.setActionsUtil(new ActionsUtil(testUtil.getDriver(),testUtil.getReports(),testUtil));
            ReusableLibrary.testUtilThread.set(testUtil);
        }
    }

}
