package lk.estudents.persondata.util;

/**
 * Class to keep application constants.
 * 
 * @author Rangalal
 *
 */
public final class ApplicationConstants {

	public static final String APPLICATION_PROPERTY_FILE_NAME = "person-data-client.properties";

	/**
	 * Hiding the default constructor of the utility class.
	 * prevents calls from subclass.
	 */
	protected ApplicationConstants() {
		throw new UnsupportedOperationException(); 
	}
}
