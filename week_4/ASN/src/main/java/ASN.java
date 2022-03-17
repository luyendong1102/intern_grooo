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

        String msg1 = "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";
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
