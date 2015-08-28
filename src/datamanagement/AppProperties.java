package datamanagement;
/**
 * importing necessary java utilities
 */
import java.util.Properties;
import java.io.FileInputStream;

public class AppProperties {
private static AppProperties self_ = null;
private Properties properties_;



/**
 * method to get instance
 * @return  properties_
 * @throws RuntimeException
 */
public static AppProperties getInstance() {
	if (self_ == null ) { self_ = new AppProperties(); } return self_;
	}
	/**
         * properties_ variable populated by result of Properties()
         */
        private AppProperties() {properties_ = new Properties();
		/**
                 * try to load in file Properties.prop, if unable, display error message
                 * 
                 * @param properties_
                 */
		try {properties_.load(new FileInputStream("Properties.prop"));} 
		catch (IOException e) {throw new RuntimeException("Could not read property file");}
	}
        
        
        
	/**
         * return the results
         * @return properties_
         */
         
	public Properties getProperties() {return properties_;}
}
