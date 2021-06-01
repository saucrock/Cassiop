package ihm;

import java.awt.Font;

import javax.swing.JLabel;

public class PetitLabel extends JLabel{
	
	public PetitLabel(String s) {
		super(s);
		this.setFont(new Font("Arial", Font.BOLD, 15));
	}

}
