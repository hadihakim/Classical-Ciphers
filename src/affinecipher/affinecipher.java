/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affinecipher;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class affinecipher {
    static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the plaintext: ");
        String  plain = input.nextLine();
        System.out.println("Enter first key such that the key and 26 are coprime: ");
        int a = input.nextInt();
        System.out.println("Enter second key: ");
        int b = input.nextInt();
        
        System.out.println(encrypttext(plain,a,b));
        System.out.println(decrypttext("LEZYKVXEFYAZ", 3, 5));
    }
    //find the ciphertext from  plaintext
    public static String encrypttext (String plain, int a, int b){
        String ciphertext = "";
        plain = plain.replace(" ", "");
        plain = plain.toUpperCase();
       //String enc = "ddshhs";
       //return enc;
       // System.out.println("you entered encrypttext method oecipher class\");f affin
        for (int i = 0; i < plain.length(); i++) {
            ciphertext+= letters.charAt((((letters.indexOf(plain.charAt(i))*a) + b) % 26));
            
        }
        return ciphertext;
    }
    //find the inverse of a number
    public static int findinverse(int a, int m){
        int invofa;
        for (int i = 0; i < m; i++){
            invofa = (i * a) % m;
            if(invofa==1)
                return i;
            
        }
        return 5;
    }
    //shows if two numbers are coprime
    public static boolean iscoprime(int a, int m){
        int invofa;
        for (int i = 0; i < m; i++) {
            invofa = (i*a) % m;
            if(invofa==1)
                return true;
            
            }
        return false;
        
    }
    //decrypt ciphertext and gives the plaintext
    public static String decrypttext(String cipher, int a, int b){
        cipher = cipher.toUpperCase();
        int num;
        String plaintext = "";
        for (int i = 0; i < cipher.length(); i++) {
            num = (findinverse(a,26))*(letters.indexOf(cipher.charAt(i)) - b);
            if (num>=0) {
                plaintext+= letters.charAt((num % 26));
            }
            else 
                while(num<0){
                    num+= 26;
                    if(num>0){
                        plaintext+= letters.charAt(((num) % 26));
                    }
                }
            
           } 
        return plaintext;
       }
}
