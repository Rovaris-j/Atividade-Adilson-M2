/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import util.BCryptUtil;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author PICHAU
 */
public class BCryptUtil {
    
    public static String hash(String senha) {
            return BCrypt.hashpw(senha, BCrypt.gensalt());
        }
        public static boolean check(String senha, String hash) {
            return BCrypt.checkpw(senha, hash);
        }
        public static void main(String[] args) {
        String hash = BCryptUtil.hash("123456");
        System.out.println("Hash gerado: " + hash);
    }
}