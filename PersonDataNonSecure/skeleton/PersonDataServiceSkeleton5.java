/**
 * PersonDataServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package lk.estudents.schemas.xsd.persondata;

import java.util.Date;
import java.util.List;

import lk.estudents.hibernate.PersonMaster;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		List list = null;

		System.out.println("Request ID Number : "
				+ personDataRequest.getIdentificationNumber());
		try {
			Query query = session
					.createQuery("FROM PersonMaster pm WHERE pm.identificationNumber=:idParam");
			query.setParameter("idParam", nic);
			query.setMaxResults(1);
			list = query.list();

			if (list.size() > 0) {
				PersonMaster pmo = (PersonMaster) list.get(0);

				PersonDataResponse personDataResponse = new PersonDataResponse();

				personDataResponse.setFullName(pmo.getFullName());
				personDataResponse.setDateOfBirth(pmo.getDateOfBirth());
				// personDataResponse.setPhoneNumber("Your Mobile Number");
				personDataResponse.setPhoneNumber(pmo.getPhoneNumber());
				personDataResponse.setAge(30); // set your age here.
				personDataResponse.setGender(pmo.getGender().toString());

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

			/*
			 * if (nic.equals("123456789V")) { // if
			 * (nic.equalsIgnoreCase(("123456789v"))){
			 * 
			 * PersonDataResponse personDataResponse = new PersonDataResponse();
			 * 
			 * personDataResponse.setFullName("Ajith");
			 * personDataResponse.setDateOfBirth(new Date()); //
			 * personDataResponse.setPhoneNumber("Your Mobile Number");
			 * personDataResponse.setPhoneNumber("");
			 * personDataResponse.setAge(27); // set your age here.
			 * personDataResponse.setGender("M");
			 * 
			 * return personDataResponse;
			 * 
			 * } else {
			 * 
			 * // Update Fault - Exception
			 * 
			 * 
			 * }
			 */
		} catch (Exception ex) {
			InvalidIdentificationNumberFault fault = new InvalidIdentificationNumberFault();
			InvalidIdentificationNumberFaultException faultException = new InvalidIdentificationNumberFaultException();
			InvalidIdentificationNumberFaultType faulttype = new InvalidIdentificationNumberFaultType();

			faulttype.setFaultCause(ex.getMessage());
			fault.setInvalidIdentificationNumberFault(faulttype);
			faultException.setFaultMessage(fault);

			throw faultException;
		}
	}

}