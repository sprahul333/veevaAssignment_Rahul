package framework;

import lombok.Cleanup;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.PropertiesConfigurationLayout;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PropertiesUtil {

    private InputStreamReader isr;
    private PropertiesConfiguration propertiesConfiguration;
    private PropertiesConfigurationLayout propertiesConfigurationLayout;

    public PropertiesUtil()
    {
        try {
            isr = new InputStreamReader(new FileInputStream("Config.properties"));
            propertiesConfiguration = new PropertiesConfiguration();
            propertiesConfigurationLayout = new PropertiesConfigurationLayout();

            propertiesConfigurationLayout.load(propertiesConfiguration, isr);
        }

        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    }

    private String getProperty(String key)
    {
        return propertiesConfiguration.getString(key);
    }

    public String getCPURL()
    {
        return getProperty("CPURL");
    }

    public String getBrowser()
    {
        return getProperty("Browser");
    }

    public String getDP1URL()
    {
        return getProperty("DP1URL");
    }

    public String getDP2URL()
    {
        return getProperty("DP2URL");
    }

    public String getKillBrowsers()
    {
        return getProperty("KillBrowsers");
    }

    public String getBrowserClose()
    {
        return getProperty("BrowserClose");
    }

    public String getHeadlessTest()
    {
        return getProperty("HeadlessTest");
    }

}
