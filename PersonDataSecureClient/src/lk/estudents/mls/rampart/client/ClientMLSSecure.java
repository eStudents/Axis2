package lk.estudents.mls.rampart.client;

import java.rmi.RemoteException;
import java.util.Properties;
import lk.estudents.schemas.xsd.persondata.InvalidIdentificationNumberFaultException;
import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub;
import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub.PersonDataRequest;
import lk.estudents.schemas.xsd.persondata.PersonDataServiceStub.PersonDataResponse;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.description.PolicyInclude;
import org.apache.neethi.Policy;
import org.apache.rampart.policy.model.CryptoConfig;
import org.apache.rampart.policy.model.RampartConfig;

public class ClientMLSSecure {

	public static void main(String[] args) {
		
		String epr = "http://localhost:8080/PersonDataSecure/services/PersonDataService.PersonDataServiceHttpSoap11Endpoint/";

		try {
			
			/* rampart module should be in the repository */
			ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem("D:\\software\\axis2\\axis2-1.5.1\\repository", null);

			PersonDataServiceStub stub = new PersonDataServiceStub(ctx, epr);
			
			ServiceClient sc = stub._getServiceClient();
			/* engage rampart module at client side. */
			sc.engageModule("rampart");
			
			Policy rampartConfig = getRampartConfig();
			sc.getAxisService().getPolicyInclude().addPolicyElement(PolicyInclude.AXIS_SERVICE_POLICY, rampartConfig);
			
			PersonDataRequest personDataRequest = new PersonDataRequest();

			personDataRequest.setIdentificationNumber("1234567890v");

			PersonDataResponse rersonDataResponse = stub.getPersonData(personDataRequest);

			System.out.println("Full Name : "
					+ rersonDataResponse.getFullName());
			System.out.println("Birth Date : "
					+ rersonDataResponse.getDateOfBirth());
			System.out.println("Mobile Number : "
					+ rersonDataResponse.getPhoneNumber());
			System.out.println("Age : " + rersonDataResponse.getAge());
			System.out.println("Gender : " + rersonDataResponse.getGender());

		} catch (AxisFault e) {
			System.out.println("AxisFault Occure : " + e.getMessage());
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("RemoteException Occure : " + e.getMessage());
			e.printStackTrace();
		} catch (InvalidIdentificationNumberFaultException e) {
			System.out.println("InvalidIdentificationNumberFaultException Occure : " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	private static Policy getRampartConfig() {

		/* add rampart-core, rampart-policy, rampart-trust, xalan jars to classpath. */
		/* you can load these properties from configuration file, instead heard coding. */
		RampartConfig rampartConfig = new RampartConfig();
		/* client private key alias. */
		rampartConfig.setUser("client");
		rampartConfig.setPwCbClass("lk.estudents.mls.rampart.client.ClientPWCBHandler");

		CryptoConfig sigCrypto = new CryptoConfig();
		sigCrypto.setProvider("org.apache.ws.security.components.crypto.Merlin");

		Properties props = new Properties();
		
		props.setProperty("org.apache.ws.security.crypto.merlin.keystore.type", "JKS");
		props.setProperty("org.apache.ws.security.crypto.merlin.file", "C:/Users/rangalal.g/tomcat-mls/clientkeystore.jks");
		props.setProperty("org.apache.ws.security.crypto.merlin.keystore.password",	"clientpassword");

		sigCrypto.setProp(props);

		rampartConfig.setSigCryptoConfig(sigCrypto);
		rampartConfig.setEncrCryptoConfig(sigCrypto);

		Policy policy = new Policy();
		policy.addAssertion(rampartConfig);

		return policy;
	}

}
