/**
 * PersonDataServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package lk.estudents.schemas.xsd.persondata;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * PersonDataServiceSkeleton java skeleton for the axisService
 */
public class PersonDataServiceSkeleton {

	private static final Logger LOGGER = Logger.getLogger(PersonDataServiceSkeleton.class);

	/**
	 * Auto generated method signature
	 * 
	 * @param personDataRequest
	 * @return personDataResponse
	 * @throws InvalidIdentificationNumberFaultException
	 */

	public PersonDataResponse getPersonData(PersonDataRequest personDataRequest)
			throws InvalidIdentificationNumberFaultException {

		String nic = personDataRequest.getIdentificationNumber();

		
		if (nic.equalsIgnoreCase(("1234567890v"))) {

			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Request ID Number : "
						+ personDataRequest.getIdentificationNumber());
			}
			PersonDataResponse personDataResponse = new PersonDataResponse();

			personDataResponse.setFullName("Rangalal Gamage");
			personDataResponse.setDateOfBirth(new Date());
			personDataResponse.setPhoneNumber("");
			personDataResponse.setGender("Male");
			// personDataResponse.setPhoneNumber("");
			personDataResponse.setAge(33); // set your age here

			return personDataResponse;
		} else {

			InvalidIdentificationNumberFault fault = new InvalidIdentificationNumberFault();
			InvalidIdentificationNumberFaultException faultException = new InvalidIdentificationNumberFaultException();
			InvalidIdentificationNumberFaultType faulttype = new InvalidIdentificationNumberFaultType();

			faulttype.setFaultCause("Invalid Identification Number");
			fault.setInvalidIdentificationNumberFault(faulttype);
			faultException.setFaultMessage(fault);

			throw faultException;
		}
	}
}
