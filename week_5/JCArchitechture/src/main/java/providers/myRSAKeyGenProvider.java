package providers;

import java.security.Provider;

public class myRSAKeyGenProvider extends Provider {
    public myRSAKeyGenProvider() {
        super("myRSAKeyGenProvider", "0.01", "custom provider");
        put("KeyPairGenerator.RSA", "sun.security.rsa.RSAKeyPairGenerator$Legacy");
    }
}
