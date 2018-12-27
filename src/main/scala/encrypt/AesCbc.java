package encrypt;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AesCbc {
    public static void main(String[] args) {
        System.out.println("CBC");
        try {
            String abc = encAES("ABC");
            System.out.println(abc);
            String de = decAES2("a75398ab729da831eaf1dc47b49c218d27ac613cded24737fb274f50f72297f64816d9267db067eb576c3819de6885c304576963d496eb508bc492e26f02ad20d7bbcc9c4dab448d6416eae199a2823a0a5053610c9f7421dd9f44ae2d4c7d795e8de2982724f39e823c93b9efb0df3eb5aa859628170cea707a24431f69b900c71cd93dbf22e136d022864cb8d1b0723c4ba200bba26fff6931b27bfb38d51910d511ef49aa259d4fd8bfa55e9751b88498fc3322fa65c7e138ea53d39419c864f52063e709522782c6a5cddf8e681d4a6a8b7dbc92294d4fdb5aa5ed153f31");
            System.out.println(de);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Key getAESKey() throws Exception {
        String iv;
        Key keySpec;

        String key = "HKKJ6878!@#12QWE";
        iv = key.substring(0, 16);
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");

        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }

        System.arraycopy(b, 0, keyBytes, 0, len);
        keySpec = new SecretKeySpec(keyBytes, "AES");

        return keySpec;
    }

    // 암호화
    public static String encAES(String str) throws Exception {
        Key keySpec = getAESKey();
        String iv = "1234567890123456";
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.encode(encrypted));

        return enStr;
    }

    // 복호화
    public static String decAES(String enStr) throws Exception {
        Key keySpec = getAESKey();
        String iv = "1234567890123456";
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));
        byte[] byteStr = Base64.decode(enStr);
        String decStr = new String(c.doFinal(byteStr), "UTF-8");

        return decStr;
    }

    // 복호화
    public static String decAES2(String enStr) throws Exception {
        byte[] bytes = Hex.decodeHex(enStr.toCharArray());
//        System.out.println(new String(bytes, "UTF-8"));

//        byte[] bytes = DatatypeConverter.parseHexBinary(enStr);
        Key keySpec = getAESKey();
        String iv = "1234567890123456";
        Cipher c = Cipher.getInstance("AES/CBC/PKCS7Padding");
        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));
        String decStr = new String(c.doFinal(bytes), "UTF-8");

        return decStr;
    }
}
