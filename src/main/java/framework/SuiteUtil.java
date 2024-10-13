package framework;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class SuiteUtil {

    String resultsPath=null;

    public String getCurrentDateTime(String format)
    {
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

        return localDateTime.format(dateTimeFormatter);
    }

    public String getScreenshotsPath(String... imageName)
    {
        new File(System.getProperty("user.dir")+"//Screenshots").mkdirs();

        if(imageName.length==0)
            return System.getProperty("user.dir")+"//Screenshots//"+getCurrentDateTime("dd-MM-yyyy_HH-mm-ss")+".png";
        else
            return System.getProperty("user.dir")+"//Screenshots//"+imageName[0]+".png";
    }

    public String getReportsPath()
    {
        new File(System.getProperty("user.dir")+"//Reports").mkdirs();

        return System.getProperty("user.dir")+"//Reports//"+getCurrentDateTime("dd-MM-yyyy_HH-mm-ss")+".html";
    }

    public String getResultsPath()
    {
        if(resultsPath==null)
        {
            new File(System.getProperty("user.dir")+"//Results").mkdirs();

            resultsPath=System.getProperty("user.dir")+"//Results//NBA_"+getCurrentDateTime("dd-MM-yyyy_HH-mm-ss");

            new File(resultsPath).mkdirs();
        }

        return resultsPath;
    }

    public String getCurrentResultsPath()
    {
        return resultsPath;
    }

    public String getCSVFilePath()
    {
        new File(System.getProperty("user.dir")+"//CSVFiles").mkdirs();

        return System.getProperty("user.dir")+"//CSVFiles//ListOfLinks.csv";
    }

    public String convertExceptionToString(Exception e) {

        StringWriter sw=new StringWriter();

        PrintWriter pw=new PrintWriter(sw);
        e.printStackTrace(pw);

        return sw.toString();
    }

}
