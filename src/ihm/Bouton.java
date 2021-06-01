package ihm;

import java.awt.Font;

import javax.swing.JButton;

public class Bouton extends JButton {
	
	public Bouton(String s) {
		super(s);
		this.setFont(new Font("Arial", Font.BOLD, 25));
	}

}
