package ihm;

import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel{
	
	public Label(String s) {
		super(s);
		this.setFont(new Font("Arial", Font.BOLD, 25));
	}

}
