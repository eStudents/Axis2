package lk.estudents.mls.rampart.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

public class ClientPWCBHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {

			// To use the private key to sign messages, we need to provide
			// the private key password
			WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];

			if (pwcb.getIdentifer().equals("client")) {
				pwcb.setPassword("clientpassword");
				return;
			}

		}

	}

}
