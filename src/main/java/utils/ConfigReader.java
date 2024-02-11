package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
	
	public  Properties initializeProperties() throws FileNotFoundException {
		
		Properties prop = new Properties();
		File proFile = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\config\\config.properties");
		
		try {
			
		
		FileInputStream file = new FileInputStream(proFile);
		prop.load(file);
		}catch(Throwable e) {
			
			e.printStackTrace();
			
		}
		
		
		return prop;
	}

}
