package framework;

import lombok.Data;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Hashtable;

@Data
public class TestUtil {

    private WebDriver driver;
    private ActionsUtil actionsUtil;
    private Reports reports;
    private PropertiesUtil propertiesUtil;

    private HashMap<String, String> testData=new HashMap<String, String>();
    private Hashtable<String, Integer> moduleWiseExecution = new Hashtable<String, Integer>();

    public int getModuleWiseExecution(String key)
    {
        return moduleWiseExecution.getOrDefault(key.trim(),0);
    }

    public void setModuleWiseExecution(String key, int value) {
        moduleWiseExecution.put(key.trim(), value);
    }


    public void setValuesToBeStored(String key, String value)
    {
        testData.put(key, value);
    }

    public String getValuesToBeStored(String key)
    {
        return testData.getOrDefault(key,"");
    }

}
