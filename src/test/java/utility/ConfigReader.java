package utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class ConfigReader 
{
	 public String readConfig(String valueToBeRead) throws IOException
	 {
		  Properties prop=new Properties();
		  String file="Config/config.properties";
		  InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
		  prop.load(inputStream);
		  
		String value = prop.getProperty("browser");
		  return value;
	 }

}
