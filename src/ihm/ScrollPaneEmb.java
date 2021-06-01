package ihm;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;


import databases.DataBaseEmbryons;
import entities.Embryons;

public class ScrollPaneEmb extends JPanel {
	ArrayList<Embryons> listEmbryons;
	
	
	public ScrollPaneEmb(int numDossier, String ponction) {
		super();
		String query = "select * from Embryons where Num_dossier = " + numDossier + " and Date_ponction = '" + ponction + "';";
		listEmbryons = DataBaseEmbryons.getEmbryons(query);
		System.out.println(query);
		System.out.println("taille " + listEmbryons.size());
		this.setLayout(new GridLayout(listEmbryons.size(),1));
		System.out.println("hello");
		for (int i = 0; i < listEmbryons.size(); i++) {
			Panelemb panelemb = new Panelemb(listEmbryons.get(i));
			System.out.println("coucou" +listEmbryons.get(i).getNumDossier());
			this.add(panelemb);
			
		}
		
		
		
	}

}
