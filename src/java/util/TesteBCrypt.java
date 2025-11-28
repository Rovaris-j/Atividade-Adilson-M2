/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author PICHAU
 */
public class TesteBCrypt {
    public static void main(String[] args) {
        String hash = BCryptUtil.hash("123456");
        System.out.println("Hash gerado: " + hash);
    }
}
