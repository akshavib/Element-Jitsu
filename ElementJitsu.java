// Author: Akshavi Baskaran 			Purpose: Element Jitsu View, Game, Controller			Date: 01-09-2023
// ElementJitsu.java

import javax.swing.JFrame;

// class Element Jitsu
public class ElementJitsu {
	public static void main(String[] args) {
		JitsuView view = new JitsuView(); // new Jitsu view
		JitsuGame model = new JitsuGame(); // new Jitsu model
		JitsuController controller = new JitsuController(model, view); // new controller, with model and view
	} // end main method 
} // end class ElementJitsu
