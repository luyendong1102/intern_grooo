import providers.myRSAKeyGenProvider;
import providers.mySignatureAlProvider;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Enumeration;

public class JCA {
    public static void main(String[] args) {

        try {

            String plainMsg = "AAAAAAAAAAAASSSSSSSSSSSSVVVVVVVVVVVVV";

            Security.addProvider(new myRSAKeyGenProvider());
            Security.addProvider(new mySignatureAlProvider());
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "myRSAKeyGenProvider");

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            Signature signature = Signature.getInstance("SHA256WithRSA", "mySignatureAlProvider");

            signature.initSign(keyPair.getPrivate());
            byte[] data = plainMsg.getBytes(StandardCharsets.UTF_8);
            signature.update(data);

            byte[] digitalSignature = signature.sign();

            Signature sig2 = Signature.getInstance("SHA256WithRSA");
            sig2.initVerify(keyPair.getPublic());
            byte[] data2 = plainMsg.getBytes(StandardCharsets.UTF_8);

            sig2.initVerify(keyPair.getPublic());
            sig2.update(data2);

            boolean verified = sig2.verify(digitalSignature);

            System.out.println(verified);

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
