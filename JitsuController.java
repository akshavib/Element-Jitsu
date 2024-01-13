// Author: Akshavi Baskaran				Purpose: The Controller of Jitsu Game 			Date: 01-14-2023
//JitsuController.java

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

// class JitsuController
// this is the Controller class of the Element Jitsu game
public class JitsuController implements ActionListener{
	private JitsuView view; // initializing private view
	private JitsuGame model; // initializing private model

	// Constructor for JitsuController 
	public JitsuController (JitsuGame model, JitsuView view) {
		this.model = model; // model
		this.view = view; // view 
		view.addListener(this); // add listener to JitsuView
		model.getFirstHand(); // call getFirstHand method to attain the starting hand for the player 
		view.setCardColour(model.hand[0].color, model.hand[1].color, model.hand[2].color); // set the player card colours
		view.setCardNumber(model.hand[0].value, model.hand[1].value, model.hand[2].value); // set the player card numbers 
		view.setCardElement(model.hand[0].element, model.hand[1].element, model.hand[2].element); // set the player card elements
	} // end constructor JitsuController

	// actionPerformed method: handling all the buttons that are used 
	public void actionPerformed(ActionEvent e) {
		// if statement: if no one has won yet
		if (model.hasWon() == "none") {	
			// if OK button is clicked, set the cards, hide computer's card, and enable player's cards to be clicked 
			if (e.getSource() == view.OK) {
				view.setCardColour(model.hand[0].color, model.hand[1].color, model.hand[2].color); // set color
				view.setCardNumber(model.hand[0].value, model.hand[1].value, model.hand[2].value); //set num
				view.setCardElement(model.hand[0].element, model.hand[1].element, model.hand[2].element); // set element
				view.setAble(0); // let cards be able to be clicked
				view.hideCompCard(); // hide computer's card
			} // end if statement 
			
			//if info button is clicked, show instructions
			if (e.getSource() == view.info) {
				// Message pop up with instructions 
				JOptionPane.showMessageDialog(view.window, "Get 3 cards in your inventory: \n 1. Of the SAME element \n 2. Of DIFFERENT colours \n"
						+ "Before the computer! The label above the 'OK' button will guide you. \n Snow beats water, water beats fire, and fire beats snow.\n"
						+ "If you both have the same element, your numbers will be compared.\n "
						+ "Once you select the card, the computer's card will be revealed. \n"
						+ "Based on that outcome, choose your next card! Choose wisely.","Instructions", JOptionPane.INFORMATION_MESSAGE);
			} // end if 

			// if cards are clicked, set which card was clicked, and then compare the card to computer's card 
			if (e.getSource() == view.card1 || e.getSource() == view.card2 || e.getSource() == view.card3) {
				view.setAble(1); // disable card ability to be clicked 

				// if card1 was picked, use that card in model pick method 
				if (e.getSource() == view.card1) {
					model.pick(0); // card1 used in model pick method 
				} // end if statement 

				// else if card2 was picked, use that card in model pick method 
				else if (e.getSource() == view.card2) {
					model.pick(1); // card2 used in model pick method 
				} // end else if statement 

				// else if card3 was picked, use that card in model pick method 
				else if (e.getSource() == view.card3) {
					model.pick(2); // card3 used in model pick method 
				} // end else if statement 

				model.newCompCard(); // get a new computer card 
				view.setCompCard(model.compCard.color, model.compCard.value, model.compCard.element); // set computer's card in view 

				// if statement: if 1 is returned, player won the round, and the inventories are updated
				if (model.compare() == 1) {
					model.addPlayerInventory(); // update player's inventory
					view.playerWin(model.winF[0], model.winF[1], model.winF[2], model.winW[0],
							model.winW[1], model.winW[2], model.winS[0], model.winS[1], model.winS[2]); // update player inventory in view (visual aspect)
				} // end if statement 

				// else if: if 2 is returned, computer won the round, and the inventories are updated
				else if (model.compare()==2) {
					model.addCompInventory(); // update computer's inventory 
					view.computerWin(model.winComF[0], model.winComF[1], model.winComF[2], model.winComW[0],
							model.winComW[1], model.winComW[2], model.winComS[0], model.winComS[1], model.winComS[2]); // update computer inventory in view
				} // end else if 

				// else: the round is tie 
				else {
					view.tieRound(); // call tie round method to display that there was a tie 
				} // end else 
			} // end if (cards were clicked)
		} // end if (no one has won)

		// else: display who has finally won 
		else {
			view.finalWin(model.hasWon()); // update who has won in interface

			// pop up information message asking to play again 
			int result = JOptionPane.showConfirmDialog(view.window, "Play Again?", "Element Jitsu", JOptionPane.INFORMATION_MESSAGE); 
			// if statement: if yes, then restart 
			if (result == JOptionPane.YES_OPTION) {
				model.restart(); // restart the model
				view.setCardColour(model.hand[0].color, model.hand[1].color, model.hand[2].color); // reset card colours according to model
				view.setCardNumber(model.hand[0].value, model.hand[1].value, model.hand[2].value); // reset card numbers according to model
				view.setCardElement(model.hand[0].element, model.hand[1].element, model.hand[2].element); // reset card elements according to model
				view.computerWin(model.winComF[0], model.winComF[1], model.winComF[2], model.winComW[0],
						model.winComW[1], model.winComW[2], model.winComS[0], model.winComS[1], model.winComS[2]); // reset comp inventories according to model
				view.playerWin(model.winF[0], model.winF[1], model.winF[2], model.winW[0],
						model.winW[1], model.winW[2], model.winS[0], model.winS[1], model.winS[2]); // reset player inventories according to model
				view.hideCompCard(); // hide computer's card again
				view.setAble(0); // enable cards to be clicked 
			} // end if statement 
			// else exit the system
			else {
				System.exit(0); // exit frame
			} // end else 
		} // end else (someone has won)
	} // end actionPerformed method
} // end JitsuController class 