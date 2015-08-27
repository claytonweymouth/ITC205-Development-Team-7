package datamanagement;
//importing necessary java utilities
import java.util.*;
import java.io.*;
//declaring variables
public class AppProperties {
private static AppProperties self = null;
private Properties properties;

//method to get instance
public static AppProperties getInstance() {
	if (self == null ) { self = new AppProperties(); } return self;
	}
	private AppProperties() {properties = new Properties();
		//try to load in file Properties.prop, if unable, display error message
		try {properties.load(new FileInputStream("Properties.prop"));} 
		catch (IOException e) {throw new RuntimeException("Could not read property file");}
	}
	//return the results
	public Properties getProperties() {return properties;}
}
