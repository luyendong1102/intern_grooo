import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.util.DERDump;

import java.io.*;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;

public class ASN {
    public static void main(String[] args) throws IOException {

        String msg1 = "MDkCAQEwMTANBglghkgBZQMEAgEFAAQgzYaPq9AqplbtmXq2KicnWY6IW7V6jqnnv3dyjrG/kKABAf8";
        String msg2 = "MEswSTBHMEUwQzAJBgUrDgMCGgUABBRByzhJp/jBLKd5gXJ8ubH8y/g7bAQULi79SBT66JEoTAbPVnkXJMbbL/UCCiIUEZFkUoFwE4k";
        String msg3 = "MIIBxzCCATCgAwIBAgIKIhQRkWRIMTgxeDANBgkqhkiG9w0BAQsFADALMQkwBwYDVQQDDAAwHhcNMjIwMjE0MDkzNjIzWhcNMjIwMjE4MDExMjIzWjALMQkwBwYDVQQDDAAwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBALOHZeXbc9umSQgkIABr9vH1sKfPy4tPeohZB4BOlyMFmIX3t6zFRtlTR4DD7m3m8yCIv7fzkwWErxHvD/1wA1ztZ8vv6y9ARIILBnFIU6cnC3kyrzHVAHVKrS5Fj/yi261r9vdkx9d4Z/Sg2rgv5Gj5dKqYDd7QFWH4Rfumd0+BAgMBAAGjMjAwMAsGA1UdDwQEAwIHgDAWBgNVHSUBAf8EDDAKBggrBgEFBQcDCDAJBgNVHRMEAjAAMA0GCSqGSIb3DQEBCwUAA4GBAIsoSXcEddzpye8Uy4v9Py6k8sCeg6RxAd+rDvSOpDzSisAYW8J9YWElcmRfBRPS1rLGqQcS6FzVnF6zfoejYzr6wop/zf4zz3mnxx4Asz2f1ymb7wwXS9VIMknCF4qpWyCbBPS+fNm/DgxI3PurjPrQBdkzexiZpo582HMF+Hkh";

        // write out put to file result.txt
        System.out.println("output is in result.txt");
        File rsFile = new File("result.txt");
        if (!rsFile.exists()) {
            if (rsFile.createNewFile()) {
                System.out.println("FILE CREATED");
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(rsFile));
        StringBuffer str = new StringBuffer();
        String result;

        // msg 1
        byte[] data1 = Base64.getDecoder().decode(msg1);
        ASN1InputStream inputStream = new ASN1InputStream(data1);
        ASN1Encodable primitive = inputStream.readObject();
        String schemas = "MSG1 \n" + ASN1Dump.dumpAsString(primitive) + "\n";
        writer.append(schemas);

        // parse ASN1 msg
        sequenceLoop(primitive, str);
        writer.append(str);
        writer.append("\n");

        // msg2
        str = new StringBuffer();
        byte[] data2 = Base64.getDecoder().decode(msg2);
        inputStream = new ASN1InputStream(data2);
        primitive = inputStream.readObject();
        schemas = "MSG2 \n" + ASN1Dump.dumpAsString(primitive) + "\n";
        writer.append(schemas);

        sequenceLoop(primitive, str);
        writer.append(str);
        writer.append("\n");

        // msg 3
        str = new StringBuffer();
        byte[] data3 = Base64.getDecoder().decode(msg3);
        inputStream = new ASN1InputStream(data3);
        primitive = inputStream.readObject();
        schemas = "MSG3 \n" + ASN1Dump.dumpAsString(primitive) + "\n";
        writer.append(schemas);

        sequenceLoop(primitive, str);
        writer.append(str);
        writer.append("\n");

        writer.close();
    }

    private static void sequenceLoop (ASN1Encodable obj, StringBuffer str) {
        // recursion ultil reach the child
        if (obj instanceof ASN1Integer) {
            str.append("INTERGER : " + obj.toASN1Primitive() + "\n");
        }
        else if (obj instanceof ASN1Null) {
            str.append("NULL : " + obj.toASN1Primitive() + "\n");
        }
        else if (obj instanceof ASN1UTCTime) {
            str.append("UTC TIME : " + obj.toASN1Primitive() + "\n");
        }
        else if (obj instanceof DEROctetString) {
            str.append("DER OCTETSTRING : " + obj.toASN1Primitive() + "\n");
        }
        else if (obj instanceof ASN1Boolean) {
            str.append("BOOLEAN : " + obj.toASN1Primitive() + "\n");
        }
        else if (obj instanceof ASN1ObjectIdentifier) {
            str.append("OID : " + obj.toASN1Primitive() + "\n");
        }
        else if (obj instanceof DERBitString) {
            str.append("DER BITSTRING : " + obj.toASN1Primitive() + "\n");
        }
        else if (obj instanceof ASN1UTF8String) {
            str.append("UTF8 : " + obj.toASN1Primitive() + "\n");
        }
        else if (obj instanceof ASN1TaggedObject) {
            str.append( "TAGGED : #no " + ((ASN1TaggedObject) obj).getTagNo() + "\n");
            sequenceLoop(((ASN1TaggedObject) obj).getBaseObject().toASN1Primitive(), str);
        }
        else if (obj instanceof ASN1Sequence) {
            str.append("SEQUENCE : \n");
            for (int i = 0; i < ((ASN1Sequence) obj).size(); i ++) {
                sequenceLoop((ASN1Encodable) ((ASN1Sequence) obj).getObjectAt(i), str);
            }
        }
        else if (obj instanceof ASN1Set) {
            str.append("SET : \n");
            for (int i = 0; i < ((ASN1Set) obj).size(); i ++) {
                sequenceLoop((ASN1Encodable) ((ASN1Set) obj).getObjectAt(i), str);
            }
        }
    }
}
