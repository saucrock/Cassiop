package ihm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entities.Fiv;

public class BoutonTentative extends JButton implements ActionListener {
	Fiv fiv;
	
	
	public BoutonTentative(String s, Fiv fiv) {
		super(s);
		this.setFont(new Font("Arial", Font.BOLD, 25));
		this.fiv = fiv;
		
		this.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FenetreListFiv.consultationTentative(fiv);
	}

}
