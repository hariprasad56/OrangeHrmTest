package com.OrangeHrm.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {
	public Properties pr;
	public ReadDataFromPropertiesFile()
	{
		try
		{
		File fi=new File("C:\\Users\\bobbi\\KCSA3\\Testing project\\OrangeHrm\\Configuration\\data.properties");
		FileInputStream fis=new FileInputStream(fi);
		pr=new Properties();
		pr.load(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getUserName()
	{
		String urName=pr.getProperty("username");
		return urName;
	}
	public String getPassword()
	{
		String urPass=pr.getProperty("password");
		return urPass;
	}

}
