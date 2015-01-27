package lk.estudents.mls.pwcb.server;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

public class ServerPWCBHandler implements CallbackHandler {

	@SuppressWarnings("deprecation")
	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length; i++) {

			/* To use the private key to sign the SOAP messages, we need to provide the associated private key password */
			WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];

			if (pwcb.getIdentifer().equals("server")) {
				/* you can load password from property file, database or LDAP without heard coding */
				pwcb.setPassword("serverpassword");
				return;
			}else{
				throw new UnsupportedCallbackException(callbacks[i], "check failed.");
			}
		}

	}

}
