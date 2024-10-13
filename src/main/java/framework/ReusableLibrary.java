package framework;


import org.openqa.selenium.WebDriver;

public class ReusableLibrary {

    public static ThreadLocal<TestUtil> testUtilThread=new ThreadLocal<TestUtil>();

    protected TestUtil testUtil=testUtilThread.get();

    protected WebDriver driver=testUtil.getDriver();
    protected PropertiesUtil propertiesUtil= testUtil.getPropertiesUtil();
    protected Reports reports=testUtil.getReports();
    protected ActionsUtil actionsUtil=testUtil.getActionsUtil();

}
