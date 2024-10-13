package framework;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

@UtilityClass
public class Loggers {

    @SneakyThrows
    public void writeDataToTheFile(String filePath,String data) {

        File f1=new File(filePath);

        if(f1.exists())
        {
            @Cleanup FileWriter fr=new FileWriter(filePath,true);
            fr.write("\n");
            fr.write(data);
        }

        else
        {
            @Cleanup FileWriter fr=new FileWriter(filePath);

            fr.write("\n");
            fr.write(data);
        }

    }

    @SneakyThrows
    public void readDataFromTheFile(String filePath)
    {
        @Cleanup  FileReader fr=new FileReader(filePath);

        int a=0;
        while((a=fr.read())!=-1)
        {
            System.out.print((char)a);
        }
    }
}
