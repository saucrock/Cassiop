package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import entities.Embryons;

public class Panelemb extends JPanel {
	int numero;
	Color couleur;
	Border identiteBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
	
	public Panelemb(Embryons emb) {
		super(new BorderLayout());
		this.setBorder(identiteBorder);
		numero = emb.getId();
		couleur = obtentionCouleur(emb);
		System.out.println("Couleur: " + couleur);
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(new Label("" + numero));
		panel.setBackground(couleur);
		this.add(panel, BorderLayout.CENTER);
		this.add(new Bouton("Consulter"),BorderLayout.EAST);
		
		
	}
	
	public Color obtentionCouleur(Embryons emb) {
		try {
			String decision = emb.getDecision();
			if (decision.equals("T")) {
				return Color.green;
			} else if (decision.equals("C")) {
				return Color.blue;
			} else if (decision.equals("D")) {
				return Color.orange;
			} else {
				return Color.white;
			}
		}catch(NullPointerException e) {
			return Color.white;
		}
		
		
		
	}

}
