package ihm;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import databases.DataBaseFiv;
import entities.Fiv;



public class PanelResumeDate extends JPanel {
	
	static ArrayList<DescriptionDate> dates = new ArrayList<DescriptionDate>();
	Border identiteBorder = BorderFactory.createLineBorder(Color.green, 2);
	public PanelResumeDate() {
		super(new GridLayout(10,1));
		this.setBorder(identiteBorder);
		if (dates.size() == 0) {
			System.out.println("coucou");
			Label label = new Label("Select a Fiv");
			this.add(label);
		}

		
	}
	
	public void changeInfo(Fiv fiv) {
		System.out.println("Changement pannel dates");
		dates = new ArrayList<DescriptionDate>();
		int numDossier = fiv.getListIntegers().get(1);
		System.out.println(numDossier);
		ArrayList<Fiv> list = DataBaseFiv.getFivs("select * from fiv where num_dossier = " + numDossier);
		for (Fiv aFiv : list) {
			dates.add(new DescriptionDate(aFiv));
			System.out.println(dates.size());
			
		}
		
		
	}
	

	
	public void pack() {
		for (DescriptionDate e: dates) {
			this.add(e);
		}
	}
	
	public static void displayDate() {
		for (DescriptionDate aDate : dates) {
			System.out.println(aDate.attributs.get(1).getText());
		}
	}

}
