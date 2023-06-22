package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public String readConfig(String valuetoread) throws IOException
	{
String path = System.getProperty("user.dir")+"//src//test//resources//Config.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String value = prop.getProperty(valuetoread);
		
		System.out.println(value);
		
		return value;
	}
	
	public static void main(String[] args) throws IOException {
		
		String path = System.getProperty("user.dir")+"//src//test//resources//Config.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String value = prop.getProperty("testsiteurl");
		
		System.out.println(value);
		
		
		
	}

}
