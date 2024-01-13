// Author: Akshavi Baskaran 			Purpose: SUMMATIVE ELEMENT JITSU			Date: 12-28-2022
// Hand.java 

import java.awt.Color;
import java.util.Random; 
  
// Hand class
// Manages creating cards and setting the picked and comparable cards 
public class Hand {
	int [] value = {1, 2, 3, 4, 5, 6, 7}; // array of values 1-7 for generating cards 
	String [] element = {"fire", "water", "snow"}; // array of elements for generating cards
	Color [] colour = {Color.red, Color.blue, Color.green, Color.orange, Color.magenta}; // array of colours for generating cards
	Card[] hand = new Card[3]; // a hand array, for the player's hand of three cards 
	
	Card temp, compCard; // creating a temporary card (to be compared to with the computer's card), and computer's card 

	Random rand = new Random(); // random class used 
	
	// getFirstHand method
	// this creates three cards for the player's very first beginning hand. 
	public void getFirstHand() {
		
		// for loop to create three cards 
		for (int i = 0; i<3; i++) {
			hand[i] = new Card((element[rand.nextInt(3)]), value[rand.nextInt(6)], colour[rand.nextInt(5)]); // add card to hand array 
		} // end for 
	} // end getFirstHand 
	
	// pick method; returns a Card 
	// sets temporary card as the card that was picked by the player to compare
	public Card pick(int index) {
		temp = hand[index]; // setting temporary card as selected card
		hand[index] = new Card ((element[rand.nextInt(3)]), value[rand.nextInt(6)], colour[rand.nextInt(5)]); // create new card to replace that selected card 
		return temp; // return temporary card 
	} // end pick method 
	
	// newCompCard method; returns a Card 
	// generates a new card for the computer 
	public Card newCompCard() {
		compCard = new Card((element[rand.nextInt(3)]), value[rand.nextInt(6)], colour[rand.nextInt(5)]);  // create new card 
		return compCard; // return computer's generated card 
	} // end newCompCard class
	
} // end Hand class