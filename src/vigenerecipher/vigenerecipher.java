/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecipher;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class vigenerecipher {
     
 
  
// This function generates the key in 
// a cyclic manner until it's length isi'nt 
// equal to the length of original text 
public static String generateKey(String str, String key) 
{ 
    int x = str.length(); 
  
    for (int i = 0; ; i++) 
    { 
        if (x == i) 
            i = 0; 
        if (key.length() == str.length()) 
            break; 
        key+=(key.charAt(i)); 
    } 
    return key; 
} 
  
// This function returns the encrypted text 
// generated with the help of the key 
//gives the ciphertext by encrypting the plaintext
 public static String cipherText(String str, String key) 
{ 
    String strtoup = str.toUpperCase();
    String keytoup = key.toUpperCase();
    String cipher_text=""; 
  
    for (int i = 0; i < str.length(); i++) 
    { 
        // converting in range 0-25 
        int x = (strtoup.charAt(i) + keytoup.charAt(i)) %26; 
  
        // convert into alphabets(ASCII) 
        x += 'A'; 
  
        cipher_text+=(char)(x); 
    } 
    return cipher_text; 
} 
 // shows if a given string is number 
   public static boolean isnum(String s){
       char c ;
       boolean boll = true;
       for (int i = 0; i < s.length(); i++) {
           c = s.charAt(i);
           boll = Character.isDigit(c);
           
           
       }
       
       return boll;
     }
  
// This function decrypts the encrypted text 
// and returns the original text 
   // gives the plaintext by decrypting the plaintext
 public static String originalText(String cipher_text, String key) 
        
{ 
    String ciphertoup = cipher_text.toUpperCase();
    String keytoup = key.toUpperCase();
    String orig_text=""; 
    
  
    for (int i = 0 ; i < cipher_text.length() &&  
                            i < key.length(); i++) 
    { 
        // converting in range 0-25
        
        int x = (ciphertoup.charAt(i) - keytoup.charAt(i) + 26) %26 ; 
        
      
  
        // convert into alphabets(ASCII) 
        x += 'A'; 
        orig_text+=(char)(x); 
    } 
    return orig_text; 
} 
  
// Driver code 
public static void main(String[] args)  
{  Scanner input = new Scanner(System.in);
    System.out.println("Enter a text");
    String str = input.nextLine();
    System.out.println("Enter a keyword");
    //String str = "ILOVEUSALUNIVERSITY"; 
    String keyword = input.nextLine();
    //String keyword = "HAKIM"; 
  
    String key = generateKey(str, keyword); 
    String cipher_text = cipherText(str, key); 
  
    System.out.println("Ciphertext : "
        + cipher_text + "\n"); 
  
    System.out.println("Original/Decrypted Text : "
        + originalText(cipher_text, key)); 
    } 
} 
    

