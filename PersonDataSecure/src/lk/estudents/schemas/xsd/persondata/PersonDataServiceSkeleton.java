/**
 * PersonDataServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package lk.estudents.schemas.xsd.persondata;

import java.util.Date;

/**
 * PersonDataServiceSkeleton java skeleton for the axisService
 */
public class PersonDataServiceSkeleton implements
		PersonDataServiceSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param personDataRequest0
	 * @throws InvalidIdentificationNumberFaultException
	 *             :
	 */

	public PersonDataResponse getPersonData(PersonDataRequest personDataRequest)
			throws InvalidIdentificationNumberFaultException {
		String nic = personDataRequest.getIdentificationNumber();

		if (nic.equalsIgnoreCase(("1234567890v"))) {

			System.out.println("Request ID Number : "
					+ personDataRequest.getIdentificationNumber());

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
