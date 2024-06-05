package com.salesforce.qa.utilty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtliyClass {
private Properties proFile=null;
String properFilePath=null;
FileInputStream fis=null;



public String getPropertyValue(String key) {
	String value=proFile.getProperty(key);
	return value;
}





// read the file
public Properties loadFile(String fileName) {
	proFile=new Properties();
	fileName=fileName.toLowerCase();
	switch(fileName) {
	case "data.properties":
	      properFilePath=Constant4.DATA_PROPERTIES_FILE_PATH;
	      break;
	case"accounttestdata.properties":
		properFilePath=Constant4.ACCOUNT_DATA_PROPERTIES_FILE_PATH;
		break;
		
	case"opportunitiestestdata.properties":
		properFilePath=Constant4.OPPORTUNITIES_DATA_PROPERTIES_FILE_PATH;
		break;
	case"leadtestdata.properties":
		properFilePath=Constant4.LEAD_DATA_PROPERTIES_FILE_PATH;
		break;
	case"contacttestdata.properties":
		properFilePath=Constant4.CONTACT_DATA_PROPERTIES_FILE_PATH;
		break;
	  default:
          throw new IllegalArgumentException("Unknown properties file: " + fileName);	
	}

		
	 try {
		 fis=new FileInputStream(properFilePath);
		 proFile.load(fis);
	 }
	 catch(FileNotFoundException e) {
		 throw new RuntimeException("Properties file not found: " + properFilePath, e);
		}
		catch(IOException e) {
			  throw new RuntimeException("Error reading properties file: " +properFilePath, e);
		}
		// return the property file and return type is Properties.
		return proFile;
	}
public void writeDataToPropertyFile(File path,String key,String value) {
	proFile=new Properties();
	proFile.setProperty(key, value);
	try {
		proFile.store(new FileOutputStream(path), "updating data");
		
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}


}



