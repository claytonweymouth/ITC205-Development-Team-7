package datamanagement;
/**
 * importing necessary java utilities
 */
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class AppProperties {
private static AppProperties self_ = null;
private Properties properties_;



/**
 * method to get instance
 * * try to load in file Properties.prop, if unable, display error message
 * @param properties_
 * @return  properties_
 * @throws RuntimeException
 */
public static AppProperties getInstance() {
	if (self_ == null ) { self_ = new AppProperties(); } return self_;
	}
        //properties_ variable populated by result of Properties()
        private AppProperties() {
          properties_ = new Properties();
		try {properties_.load(new FileInputStream("Properties.prop"));} 
		catch (IOException e) {throw new RuntimeException("Could not read property file");}
	}
        
        
        
	/**
	 * return the results
	 * @return properties_
	 */
         
	public Properties getProperties() {return properties_;}
}
