package lk.estudents.persondata.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

import lk.estudents.persondata.util.ApplicationProperties;
import lk.estudents.schemas.xsd.persondata.InvalidIdentificationNumberFaultException0;
import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub;
import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub.PersonDataRequest;
import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub.PersonDataResponse;

public class ClientNonSecure {

	private static final Logger logger = Logger.getLogger(ClientNonSecure.class);

	public static void main(String[] args) {
		
		String endPoint = ApplicationProperties.getValue("person.data.ws.endpoint");
		
		try {
			PersonDataServiceStub stub = new PersonDataServiceStub(endPoint);

			PersonDataRequest personDataRequest = new PersonDataRequest();

			personDataRequest.setIdentificationNumber("123456789v");

			PersonDataResponse personDataResponse = stub.getPersonData(personDataRequest);

			if (logger.isInfoEnabled()) {
				logger.info("Full Name: " + personDataResponse.getFullName());
				logger.info("Birth Date: " + personDataResponse.getDateOfBirth());
				logger.info("Mobile Number: " + personDataResponse.getPhoneNumber());
				logger.info("Age: " + personDataResponse.getAge());
				logger.info("Gender: " + personDataResponse.getGender());
			}

		} catch (AxisFault e) {
			
			if (logger.isInfoEnabled()) {
				logger.info("AxisFault Occure : " + e.getMessage());
			}
			if (logger.isTraceEnabled()) {
				logger.trace(e);
			}
			
		} catch (RemoteException e) {
			if (logger.isInfoEnabled()) {
				logger.info("RemoteException Occure : " + e.getMessage());
			}
			if (logger.isTraceEnabled()) {
				logger.trace(e);
			}
		} catch (InvalidIdentificationNumberFaultException0 e) {
			if (logger.isInfoEnabled()) {
				logger.info("InvalidIdentificationNumberFaultException Occure : " + e.getMessage());
			}
			if (logger.isTraceEnabled()) {
				logger.trace(e);
			}
		}

	}

}
