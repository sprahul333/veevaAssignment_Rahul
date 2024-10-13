package stepDefinitions;

import framework.*;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Hook {

    TestUtil testUtil=new TestUtil();

    @Before
    public void beforeTestCase(Scenario sc)
    {
        if(ReusableLibrary.testUtilThread.get()==null)
        {
            testUtil.setPropertiesUtil(new PropertiesUtil());
            testUtil.setDriver(BrowserUtils.getDriver("Chrome"));
            testUtil.setReports(new Reports(testUtil));
            testUtil.setActionsUtil(new ActionsUtil(testUtil.getDriver(),testUtil.getReports(),testUtil));
            ReusableLibrary.testUtilThread.set(testUtil);
        }
    }

    @After
    public void afterTestCase(Scenario sc)
    {
        if(ReusableLibrary.testUtilThread.get()!=null)
        {
            ReusableLibrary.testUtilThread.get().getDriver().quit();
            ReusableLibrary.testUtilThread.set(null);
        }

        System.out.println(sc.getStatus());
    }

    @AfterStep
    public void afterStep(Scenario sc)
    {
        byte[] bytes=((TakesScreenshot)ReusableLibrary.testUtilThread.get().getDriver()).getScreenshotAs(OutputType.BYTES);
        sc.attach(bytes,"image/png","Screenshot");
    }

}
