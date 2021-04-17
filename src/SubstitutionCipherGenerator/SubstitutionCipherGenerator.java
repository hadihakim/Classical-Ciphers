/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubstitutionCipherGenerator;

import java.util.Arrays;
import java.util.Random;

public class SubstitutionCipherGenerator {

	public static void main(String[] args) {
		
		char[] alphabet = new char[27];
		char[] Substitution = new char[27]; 
		Random rand = new Random();

		// Initialize the alphabet 
		for (int i = 0; i < 26; i++)
		{
			alphabet[i] = (char) ((int)'A'+ i) ; 
			Substitution[i] = alphabet[i]; 
		}
		alphabet[26] = ' ';
		Substitution[26] = alphabet[26]; 

		
		// Create the substitution Cipher by shuffling the Substitution Array three times
		for (int j = 0; j < 3 ; j++)
		{
			for (int i = 0; i < alphabet.length; i++) {
			int randomIndexToSwap = rand.nextInt(Substitution.length);
                            //System.out.print(randomIndexToSwap+" ");
			char temp = Substitution[randomIndexToSwap];
			Substitution[randomIndexToSwap] = Substitution[i];
			Substitution[i] = temp;
		}
                        //System.out.println(" ");
		} 
		
		System.out.println(Arrays.toString(alphabet));
		System.out.println(Arrays.toString(Substitution));

	}
}
