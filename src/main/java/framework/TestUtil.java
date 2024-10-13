package framework;

import lombok.Data;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

@Data
public class TestUtil {

    private WebDriver driver;
    private ActionsUtil actionsUtil;
    private Reports reports;
    private PropertiesUtil propertiesUtil;

    private HashMap<String, String> testData=new HashMap<String, String>();

    public void setValuesToBeStored(String key, String value)
    {
        testData.put(key, value);
    }

    public String getValuesToBeStored(String key)
    {
        return testData.getOrDefault(key,"");
    }

}
