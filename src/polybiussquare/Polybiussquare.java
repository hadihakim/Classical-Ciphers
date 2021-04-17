/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package polybiussquare;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class Polybiussquare {

    /**
     * @param args the command line arguments
     */
    final static String[][] polybius = {
            {"A", "B", "C", "D", "E"},
            {"F", "G", "H", "I", "K"},
            {"L", "M", "N", "O", "P"},
            {"Q", "R", "S", "T", "U"},
            {"V", "W", "X", "Y", "Z"}
            
        };
   // String s;
   // static String cipher = "";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the plain: ");
        String plain = input.nextLine();
        plain = plain.toUpperCase().replace('J', 'I');
        System.out.print("Cipher is: ");
        //findpolybiuscipher(plain);
        //String s = findpolybiuscipher(plain);
        System.out.println(polybiusencrypt(plain));
        System.out.println("plain is: "+polybiusdecrypt("2  3 1 11424"));
        }

    

    public Polybiussquare() {
       
    }
    //gives the ciphertext by decrypting the plaintext
    public static String polybiusencrypt(String plain){
       String upperplain= plain.toUpperCase().replace('J', 'I');
       
        int num ; 
        int num1;
        String cipher = "";
        //char c = (char) num;
        for (int k = 0; k < upperplain.length() ; k++) {
            char character = upperplain.charAt(k);
            for (int i = 0; i < polybius.length; i++) {
                for (int j = 0; j < polybius.length; j++) {
                    if(character==polybius[i][j].charAt(0))
                    {num = (i+1); num1=(j+1);
                        
                       // System.out.print((i+1)+""+(j+1)+", ");
                        cipher+= Integer.toString(num)+""+Integer.toString(num1)+" ";}
                    
                }
            }
         }
        return cipher;
        
       }
    //gives the plaintext by decrypting ciphertext
    public static String polybiusdecrypt(String cipher){
        String plaintext = "";
        cipher = cipher.replace(" ", "");
        String temp ;
        String indexstring;
        int i = 0;
         while(i < cipher.length()){
            indexstring = ""+cipher.charAt(i);
            temp = ""+cipher.charAt(i+1);
            
            plaintext+= polybius[Integer.parseInt(indexstring)-1][Integer.parseInt(temp)-1];
            indexstring = "";
            temp = "";
            i+=2;
        }
        return plaintext;
       
     }
    }
    

