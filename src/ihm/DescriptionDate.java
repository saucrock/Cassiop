package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import entities.Fiv;

public class DescriptionDate extends JPanel{
	BoutonTentative consulter;
	JPanel grille = new JPanel(new GridLayout(4,2));
	static ArrayList<Label> listAttribut;
	static ArrayList<AttributLabel> attributs;
	Border identiteBorder = BorderFactory.createLineBorder(Color.green, 2);
	
	public DescriptionDate(Fiv fiv) {
		super(new BorderLayout());
		this.setBorder(identiteBorder);
		consulter = new BoutonTentative("Consulter", fiv);
		this.add(consulter, BorderLayout.EAST);
		initAttribut(fiv);
		for (int i = 0; i < 4; i++) {
			grille.add(listAttribut.get(i));
			grille.add(attributs.get(i));
			
		}
		
		this.add(grille,BorderLayout.CENTER);
		
		
	}
	
	public static void initAttribut(Fiv a) {
		listAttribut = new ArrayList<Label>();
		attributs = new ArrayList<AttributLabel>();
		String[] attribut = {"Date Ponction", "Dose totale Gonado", "Durée traitement Gonado", "Type AMP"};
		String[] valeur = getAttributsFromFiv(a);
		for(int i = 0; i < 4; i++) {
			listAttribut.add(new Label(attribut[i]));
			attributs.add(new AttributLabel(valeur[i]));
		}
	}
	
	public static String[] getAttributsFromFiv(Fiv a) {
		String date = a.getListDatesStrings().get(3);
		String doseString = a.getListIntegers().get(5)+"";
		String duree = a.getListStrings().get(10);
		String type = a.getListStrings().get(2);
		
		String[] attribu = {date, doseString, duree, type};
		return attribu;		
	}

}
