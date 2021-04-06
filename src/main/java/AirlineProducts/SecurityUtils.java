/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineProducts;

/**
 *
 * @author alexa
 */
public class SecurityUtils {
    
    public static String encryptPassword(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i] += 10;
        }
        return String.copyValueOf(chars);
    } 
    
    public static String decryptPassword(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i] -= 10;
        }
        return String.copyValueOf(chars);
    }
    
    
}
