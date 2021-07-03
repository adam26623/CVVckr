/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encrypted;

/**
 *
 * @author DarkOvs77
 */
import java.util.Base64;

public class MyEncrypt {

    public static String Decrypt(String str) {
        byte[] decodeString = Base64.getDecoder().decode(str.getBytes());
        return new String(decodeString);
    }
}
