// Author: Akshavi Baskaran 					Purpose: Jitsu Game Class 				Date: 12-27-2022
// JitsuGame.java 

import java.awt.Color;

// JitsuGame class 
// This is the model of the Element Jitsu game
// Manages rules of the game, comparing cards, card inventory, and who is winning
public class JitsuGame extends Hand{

	Color peach = new Color(255,218,185); // new peach colour 

	private boolean playerWin = false; // boolean for when player has won 

	Color [] winF = {peach, peach, peach}; // inventory array for player's fire cards 
	Color[] winW = {peach, peach, peach}; // inventory array for player's water cards
	Color[] winS = {peach, peach, peach}; // inventory array for player's snow cards 

	boolean compWin = false; // boolean for when computer has won

	Color [] winComF = {peach, peach, peach}; // inventory array for computer's fire cards
	Color[] winComW = {peach, peach, peach}; // inventory array for computer's water cards 
	Color[] winComS = {peach, peach, peach}; // inventory array for computer's snow cards 

	// compare method; returns integer 
	// compare the computer card with the player picked card 
	public Integer compare() {

		// if statement: if temp card is equal to comp card, compare the values of the cards 
		// return (1) means player won, (2) means comp won, (0) means tie
		if (temp.element == compCard.element) {

			// if statement: if temp card is greater than comp card
			if (temp.value > compCard.value) {
				return 1; 
			} // end if 

			// if statement: if temp card is smaller than comp card 
			if (temp.value < compCard.value) {
				return 2;
			} // end if 

			return 0; // if cards are equal, return 0 (tie)
		} // end if statement comparing values 

		// else statement: comparing the elements of the cards 
		else {

			// if: compare element if temp card element is fire 
			if (temp.element == "fire") {

				// if comp card element is snow, player wins 
				if (compCard.element == "snow") {
					return 1;
				} // end if 

				// else computer wins
				else 
					return 2; 		
			} // end if 

			// else if: compare element if temp card element is water 
			else if (temp.element == "water") {

				// if comp card element is fire, player wins
				if (compCard.element == "fire") {
					return 1;
				} // end if 

				// else computer wins 
				else 
					return 2;		
			} // end else if 

			// else if: compare element if temp card element is snow 
			else if (temp.element == "snow") {

				// if comp card element is water, player wins
				if (compCard.element == "water") {
					return 1;
				}

				// else computer wins 
				else 
					return 2;		
			} // end else 
			return 2;
		} // end else statment 
	} // end compare method 

	// addPlayerInventory method: array of UNIQUE colors for each element for the PLAYER 
	// inventory for each element, and change from peach to a different color each time player wins
	public void addPlayerInventory() {
		// if statement: if temp card element is fire, input it into the winning fire array 
		if (temp.element == "fire") {

			// if first colour in array is peach, then add the temp card colour
			if (winF[0] == peach) {
				winF[0] = temp.color;
				playerWin = false; // boolean player has not won 
			} // end if 

			// else if second colour in array is peach, then add the temp card colour
			else if (winF[1] == peach) {

				// if the temp card colour is NOT equal to the first colour in the array, then add the temp card colour
				if (winF[0] != temp.color) {
					winF[1] = temp.color;
					playerWin = false; // boolean player has not won
				} // end if 

				// else keep the colour as peach in the array 
				else {
					winF[1] = peach;
					playerWin = false; // player not won 
				} // end else 
			} // end else if 

			// else if third colour is peach, then add the temp card color 
			else if (winF[2] == peach) {

				// if the temp card color is NOT equal to first AND second colour in the array, then add the temp card color 
				if (winF[0] != temp.color && winF[1] != temp.color) {
					winF[2] = temp.color;
					playerWin = true; // player has won 
				} // end if statement 

				// else keep the colour as peach 
				else {
					winF[2] = peach;
					playerWin = false; // player has not won 
				} // end else 
			} // end else if 
		} // if statement for fire 

		// if statement: if temp card element is water, input it into the winning water array 
		if (temp.element == "water") {

			// if first colour in array is peach, then add the temp card colour
			if (winW[0] == peach) {
				winW[0] = temp.color;
				playerWin = false; // boolean player has not won 
			} // end if 

			// else if second colour in array is peach, then add the temp card colour
			else if (winW[1] == peach) {

				// if the temp card colour is NOT equal to the first colour in the array, then add the temp card colour
				if (winW[0] != temp.color) {
					winW[1] = temp.color;
					playerWin = false; // boolean player has not won
				} // end if 

				// else keep the colour as peach in the array 
				else {
					winW[1] = peach;
					playerWin = false; // player not won 
				} // end else 
			} // end else if 

			// else if third colour is peach, then add the temp card color 
			else if (winW[2] == peach) {

				// if the temp card color is NOT equal to first AND second colour in the array, then add the temp card color 
				if (winW[0] != temp.color && winW[1] != temp.color) {
					winW[2] = temp.color;
					playerWin = true; // player has won 
				} // end if statement 

				// else keep the colour as peach 
				else {
					winW[2] = peach;
					playerWin = false; // player has not won 
				} // end else 
			} // end else if 
		} // if statement for water

		// if statement: if temp card element is snow, input it into the winning snow array 
		if (temp.element == "snow") {

			// if first colour in array is peach, then add the temp card colour
			if (winS[0] == peach) {
				winS[0] = temp.color;
				playerWin = false; // player has not won 
			} // end if 

			// else if second colour in array is peach, then add the temp card colour
			else if (winS[1] == peach) {

				// if the temp card colour is NOT equal to the first colour in the array, then add the temp card colour
				if (winS[0] != temp.color) {
					winS[1] = temp.color;
					playerWin = false; // boolean player has not won
				} // end if 

				// else keep the colour as peach in the array 
				else {
					winS[1] = peach;
					playerWin = false; // player not won 
				} // end else 
			} // end else if 

			// else if third colour is peach, then add the temp card color 
			else if (winS[2] == peach) {

				// if the temp card color is NOT equal to first AND second colour in the array, then add the temp card color 
				if (winS[0] != temp.color && winS[1] != temp.color) {
					winS[2] = temp.color;
					playerWin = true; // player has won 
				} // end if statement 

				// else keep the colour as peach 
				else {
					winS[2] = peach;
					playerWin = false; // player has not won 
				} // end else 
			} // end else if 
		} // if statement for snow
	} // end addPlayerInventory method 

	// addCompInventory method: array of UNIQUE colors for each element for the COMPUTER
	// inventory for each element, and change from peach to a different color each time computer wins
	public void addCompInventory() {

		// if statement: if temp card element is fire, input it into the winning fire array 
		if (compCard.element == "fire") {

			// if first colour in array is peach, then add the comp card colour
			if (winComF[0] == peach) {
				winComF[0] = compCard.color;
				compWin = false; // boolean computer has not won 
			} // end if 

			// else if second colour in array is peach, then add the comp card colour
			else if (winComF[1] == peach) {

				// if the comp card colour is NOT equal to the first colour in the array, then add the comp card colour
				if (winComF[0] != compCard.color) {
					winComF[1] = compCard.color;
					compWin = false; // boolean computer has not won
				} // end if 

				// else keep the colour as peach in the array 
				else {
					winComF[1] = peach;
					compWin = false; // computer not won 
				} // end else 
			} // end else if 

			// else if third colour is peach, then add the comp card color 
			else if (winComF[2] == peach) {

				// if the comp card color is NOT equal to first AND second colour in the array, then add the comp card color 
				if (winComF[0] != compCard.color && winComF[1] != compCard.color) {
					winComF[2] = compCard.color;
					compWin = true; // computer has won 
				} // end if statement 

				// else keep the colour as peach 
				else {
					winComF[2] = peach;
					compWin = false; // computer has not won 
				} // end else 
			} // end else if 
		} // if statement for fire 

		// if statement: if comp card element is water, input it into the winning water array 
		if (compCard.element == "water") {

			// if first colour in array is peach, then add the comp card colour
			if (winComW[0] == peach) {
				winComW[0] = compCard.color;
				compWin = false; // boolean computer has not won 
			} // end if 

			// else if second colour in array is peach, then add the comp card colour
			else if (winComW[1] == peach) {

				// if the comp card colour is NOT equal to the first colour in the array, then add the comp card colour
				if (winComW[0] != compCard.color) {
					winComW[1] = compCard.color;
					compWin = false; // boolean player has not won
				} // end if 

				// else keep the colour as peach in the array 
				else {
					winComW[1] = peach;
					compWin = false; // computer not won 
				} // end else 
			} // end else if 

			// else if third colour is peach, then add the comp card color 
			else if (winComW[2] == peach) {

				// if the comp card color is NOT equal to first AND second colour in the array, then add the comp card color 
				if (winComW[0] != compCard.color && winComW[1] != compCard.color) {
					winComW[2] = compCard.color;
					compWin = true; // computer has won 
				} // end if statement 

				// else keep the colour as peach 
				else {
					winComW[2] = peach;
					compWin = false; // computer has not won 
				} // end else 
			} // end else if 
		} // if statement for water

		// if statement: if comp card element is snow, input it into the winning snow array 
		if (compCard.element == "snow") {

			// if first colour in array is peach, then add the comp card colour
			if (winComS[0] == peach) {
				winComS[0] = compCard.color;
				compWin = false; // computer has not won 
			} // end if 

			// else if second colour in array is peach, then add the comp card colour
			else if (winComS[1] == peach) {

				// if the comp card colour is NOT equal to the first colour in the array, then add the comp card colour
				if (winComS[0] != compCard.color) {
					winComS[1] = compCard.color;
					compWin = false; // boolean computer has not won
				} // end if 

				// else keep the colour as peach in the array 
				else {
					winComS[1] = peach;
					compWin = false; // computer not won 
				} // end else 
			} // end else if 

			// else if third colour is peach, then add the comp card color 
			else if (winComS[2] == peach) {

				// if the compcard color is NOT equal to first AND second colour in the array, then add the comp card color 
				if (winComS[0] != compCard.color && winComS[1] != compCard.color) {
					winComS[2] = compCard.color;
					compWin = true; // player has won 
				} // end if statement 

				// else keep the colour as peach 
				else {
					winComS[2] = peach;
					compWin = false; // computerhas not won 
				} // end else 
			} // end else if 
		} // if statement for snow
	}

	// hasWon method; return who won, player or computer, or none.
	// check if won
	public String hasWon() {
		String status = ""; // string to identify who has won

		// if player win is true, string status is you
		if (playerWin == true) {
			status = "You";
		} // end if 
		
		// else if comp win is true, string status is computer
		else if (compWin == true) {
			status = "Computer";
		} // end else if 
		
		// else string status is none
		else {
			status = "none"; 
		} // end else 

		return status; // return status string 
	} // end hasWon method 

	// restart method 
	// method for when player wants to play again 
	public void restart() {
		
		// set all inventory arrays as PEACH colour 
		for(int i = 0; i<3 ; i++){
			winF[i] = peach;
			winW[i] = peach;
			winS[i] = peach;
			winComF[i] = peach;
			winComW[i] = peach;
			winComS[i] = peach;
		} // end for loop 
		playerWin = false; // player has not won 
		compWin = false; // computer has not won 
		getFirstHand(); // get a new first hand
	} // end restart method 
} // end class JitsuGame 