/**
 * PersonDataServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package lk.estudents.schemas.xsd.persondata;

import java.util.Date;

/**
 * PersonDataServiceSkeleton java skeleton for the axisService
 */
public class PersonDataServiceSkeleton {

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

		System.out.println("Request ID Number : " + personDataRequest.getIdentificationNumber());
		
		//if (nic.equals("123456789v")) {
		if (nic.equalsIgnoreCase(("123456789v"))){
		
			PersonDataResponse personDataResponse = new PersonDataResponse();

			personDataResponse.setFullName("Your Full Name");
			personDataResponse.setDateOfBirth(new Date());
			// personDataResponse.setPhoneNumber("Your Mobile Number");
			personDataResponse.setPhoneNumber("");
			personDataResponse.setAge(33); // set your age here.
			personDataResponse.setGender("Your Gender");

			return personDataResponse;

		} else {
			throw new InvalidIdentificationNumberFaultException();
		}
	}

}
