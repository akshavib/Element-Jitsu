// Author: Akshavi 

import java.util.Scanner;

public class JitsuTest{
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		JitsuGame game = new JitsuGame();
		
		game.getFirstHand();
		int i = 1;
		
		do {
		System.out.println("");
		System.out.println("*** ROUND " + i + " ***");
		System.out.println("");
		game.string();
		System.out.print("please choose a card:");
		int chosen = input.nextInt();
		System.out.println("you chose " + game.pick(chosen));
		
		System.out.println("computer's card was " + game.newCompCard());
		
		if (game.compare() == 1) {
			System.out.println("you won this round.");
			System.out.println(game.addPlayerInventory());
		}
		else if (game.compare() == 2) {
			System.out.println("computer won this round.");
			System.out.println(game.addCompInventory());
		}
		else {
			System.out.println("tie!");
		}
		i++;
		}
		//while(!game.hasWon());		
	}
}