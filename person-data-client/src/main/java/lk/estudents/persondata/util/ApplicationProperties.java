package lk.estudents.persondata.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Class to load application properties.
 * 
 * @author Rangalal
 *
 */
public class ApplicationProperties {

	private static ApplicationProperties applicationProperties = null;

	private static Logger logger = Logger.getLogger(ApplicationProperties.class);

	private Properties properties = null;

	public static String getValue(String key) {
		if (applicationProperties == null) {
			applicationProperties = new ApplicationProperties();
			applicationProperties.loadProperties(ApplicationConstants.APPLICATION_PROPERTY_FILE_NAME, null);
		}
		return applicationProperties.getPropertyValue(key);
	}

	private ApplicationProperties() {

	}

	private String getPropertyValue(String key) {
		return this.properties.getProperty(key);
	}

	/**
	 * 
	 * @param name
	 *            Resource Bundle name
	 * @param loader
	 *            class loader
	 * @return properties
	 */
	private void loadProperties(String name, ClassLoader loader) {

		if (loader == null) {
			loader = this.getClass().getClassLoader();
		}

		Properties properties = new Properties();

		InputStream in = null;
		try {
			in = loader.getResourceAsStream(name);

			properties.load(in);
		} catch (FileNotFoundException e) {
			if (logger.isInfoEnabled()) {
				logger.info("FileNotFoundException is occured : "
						+ e.getMessage());
			}
			if (logger.isTraceEnabled()) {
				logger.trace(e);
			}
		} catch (IOException e) {
			if (logger.isInfoEnabled()) {
				logger.info("IOException is occured : " + e.getMessage());
			}
			if (logger.isTraceEnabled()) {
				logger.trace(e);
			}
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				if (logger.isInfoEnabled()) {
					logger.info("IOException is occured : " + e.getMessage());
				}
				if (logger.isTraceEnabled()) {
					logger.trace(e);
				}
			}
		}
		this.properties = properties;
	}

}
