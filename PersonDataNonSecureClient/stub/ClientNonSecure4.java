package lk.estudents.schemas.xsd.persondata;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub.PersonDataRequest;
import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub.PersonDataResponse;

public class ClientNonSecure {

	private static final Logger LOG = Logger.getLogger(ClientNonSecure.class);

	public static void main(String[] args) {

		String eprHttp = "http://192.168.1.165:8080/PersionDataNonSecure/services/PersonDataService.PersonDataHandlerServiceHttpSoap11Endpoint/";
		String eprHttps = "https://192.168.1.165:8443/PersionDataNonSecure/services/PersonDataService.PersonDataHandlerServiceHttpSoap11Endpoint/";
		String eprPhp = "http://192.168.1.78/php_webservice/tt_webserver.php";

		
		try {
			PersonDataServiceStub stub = new PersonDataServiceStub(eprHttps);
			
			// 1-way SSL
			System.setProperty("javax.net.ssl.trustStore", "/home/rangalalw/tomcatclienttruststore.jks");
			System.setProperty("javax.net.ssl.trustStorePassword", "password");
			
			// 2-way SSL
			System.setProperty("javax.net.ssl.keyStore", "/home/rangalalw/tomcatclientkeystore.jks");
			System.setProperty("javax.net.ssl.keyStorePassword", "password");

			PersonDataRequest personDataRequest = new PersonDataRequest();

			personDataRequest.setIdentificationNumber("1234567890v");// rangalal-id

			PersonDataResponse personDataResponse = stub
					.getPersonData(personDataRequest);

			if (LOG.isInfoEnabled()) {
				LOG.info("Full Name : " + personDataResponse.getFullName());
				LOG.info("Birth Date : " + personDataResponse.getDateOfBirth());
				LOG.info("Mobile Number : "
						+ personDataResponse.getPhoneNumber());
				LOG.info("Age : " + personDataResponse.getAge());
				LOG.info("Gender : " + personDataResponse.getGender());
			}

		} catch (AxisFault e) {
			if (LOG.isInfoEnabled()) {
				LOG.info("AxisFault Occure : " + e.getMessage());
			}
			else if (LOG.isTraceEnabled()) {
				LOG.trace(e);
			}
		} catch (RemoteException e) {
			if (LOG.isInfoEnabled()) {
				LOG.info("RemoteException Occure : " + e.getMessage());
			}
			if (LOG.isTraceEnabled()) {
				LOG.trace(e);
			}
		} catch (InvalidIdentificationNumberFaultException e) {
			if (LOG.isInfoEnabled()) {
				LOG.info("InvalidIdentificationNumberFaultException Occure : "
						+ e.getFaultMessage()
								.getInvalidIdentificationNumberFault()
								.getFaultCause());
			}
			if (LOG.isTraceEnabled()) {
				LOG.trace(e);
			}
		}

	}
}