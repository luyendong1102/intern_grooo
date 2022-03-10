
import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.util.DERDump;

import java.io.IOException;
import java.util.Base64;

public class ASN {
    public static void main(String[] args) throws IOException {
        byte[] data = Base64.getDecoder().decode("MDkCAQEwMTANBglghkgBZQMEAgEFAAQgzYaPq9AqplbtmXq2KicnWY6IW7V6jqnnv3dyjrG/kKABAf8");
        ASN1InputStream asn1InputStream = new ASN1InputStream(data);
        ASN1Primitive p = asn1InputStream.readObject();
        System.out.println(ASN1Dump.dumpAsString(p));

        // base on schemas
        ASN1Sequence sequence1 = ASN1Sequence.getInstance(p);
        ASN1Integer integer = (ASN1Integer) sequence1.getObjectAt(0);
        System.out.println(integer.getValue());

        ASN1Sequence sequence2 = ASN1Sequence.getInstance(sequence1.getObjectAt(1));
        ASN1Sequence sequence3 = ASN1Sequence.getInstance(sequence2.getObjectAt(0));
        ASN1ObjectIdentifier objectIdentifier = ASN1ObjectIdentifier.getInstance(sequence3.getObjectAt(0));
        System.out.println(objectIdentifier.getId());

        //
        DEROctetString octetString = DEROctetString.getInstance()

    }
}
