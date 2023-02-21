/*SUSHILKUMAR K. VHANKALI
  Task:NUMBER GUESSING GAME
  Language:JAVA
  OASIS INFOBYTE */


import java.util.*;
import java.util.Random;
public class GuessANumber {
	public static void main(String[] args) {
		// Generates a random number between 0 to 100
		int randomNumber = (int)(Math.random()*100);
		System.out.println("************NUMBER GUESSING GAME****************");
		System.out.println("\nHello EveryOne! \n Welcome  to  Number Guessing Game\n");
		
		System.out.println("Here are some rules:\n1.The Number you have to guess lies between 0 to 100");
		
		System.out.println("2.If your guess is wrong It will tell you that your guessed Number is greater or smaller than random number");
		
		System.out.println("3.Each one gets five chances to guess the Number,Person who guesses in minimum chances is the Winner");
		
		System.out.println("                  All the best :) ");
        System.out.println("Enter any number:");
		Scanner in = new Scanner(System.in);
		int maxChoices=5;
		int i=0;	// to count number of times guessed
		while(i<maxChoices) {
			int guessedNumber=in.nextInt();
			if(guessedNumber==randomNumber) {
				System.out.println("Congratulations,Your guess was correct,You guessed the number in just "+(i+1)+" tries");
				break;
			}
			else if(guessedNumber<randomNumber && i!=maxChoices-1) {
				System.out.println("Your guessed Number is smaller than random number");
			}
			else if(guessedNumber>randomNumber && i!=maxChoices-1) {
				System.out.println("Your guessed Number is greater than random number");
			}
			i++;
		}
		if(i==maxChoices) {
			System.out.println("OOPS! You have exceeded number of tries.\nBETTER LUCK NEXT TIME!\nThe number was:"+randomNumber);
			System.out.println("Don't worry! Please play again  ");
            System.out.println("THANK YOU!");
		}
	}
}
	
