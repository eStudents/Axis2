package lk.estudents.schemas.xsd.persondata;

import java.rmi.RemoteException;

import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub.PersonDataRequest;
import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub.PersonDataResponse;

import org.apache.axis2.AxisFault;


public class ClientNonSecure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String epr = "http://localhost:8080/PersionDataNonSecure/services/PersonDataService.PersonDataHandlerServiceHttpSoap11Endpoint/";
		
		try {
			PersonDataServiceStub stub = new PersonDataServiceStub(epr);
			
			PersonDataRequest personDataRequest = new PersonDataRequest();
			
			personDataRequest.setIdentificationNumber("123456789v");
			
			PersonDataResponse rersonDataResponse = stub.getPersonData(personDataRequest);
			
			System.out.println("Full Name : " + rersonDataResponse.getFullName());
			System.out.println("Birth Date : " + rersonDataResponse.getDateOfBirth());
			System.out.println("Mobile Number : " + rersonDataResponse.getPhoneNumber());
			System.out.println("Age : " + rersonDataResponse.getAge());
			System.out.println("Gender : " + rersonDataResponse.getGender());
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			System.out.println("AxisFault Occure : " + e.getMessage());
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("RemoteException Occure : " + e.getMessage());
			e.printStackTrace();
		} catch (InvalidIdentificationNumberFaultException e) {
			// TODO Auto-generated catch block
			System.out.println("InvalidIdentificationNumberFaultException Occure : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
