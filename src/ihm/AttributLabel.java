package ihm;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class AttributLabel extends JLabel{
	
	public AttributLabel(String s) {
		super(s);
		this.setFont(new Font("Arial", Font.BOLD, 25));
		this.setForeground(Color.PINK);
	}

}
