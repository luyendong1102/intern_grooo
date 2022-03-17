package providers;

import java.security.Provider;

public class mySignatureAlProvider extends Provider {

    public mySignatureAlProvider() {
        super("mySignatureAlProvider", "0.01", "SIgnature Provider");
        put("Signature.SHA256WithRSA", "sun.security.rsa.RSASignature$SHA256withRSA");
    }
}
