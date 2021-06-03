package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;



import databases.DataBaseStat2;

public class FenetreStat extends JDialog {
	static ArrayList<Label> listAttribut = new ArrayList<Label>();
	static ArrayList<AttributLabel> listValeur = new ArrayList<AttributLabel>();
	
	
	public FenetreStat(JFrame a) {
		super (a, true);
		this.setTitle("STATISTIQUES");
		this.setSize(1500, 1000);
		initList();
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new Label("STATISTIQUES"), BorderLayout.NORTH);
		JPanel grilleJPanel = new JPanel(new GridLayout(15,2));
		
		for (int i = 0; i < 15; i++) {
			
			grilleJPanel.add(listAttribut.get(i));
			JPanel bJPanel = new JPanel();
			if (i == 5) {
				
				bJPanel.setBackground(colorConsensus(DataBaseStat2.getTaux_fecondation_consensus()));
				bJPanel.add(listValeur.get(i));
				grilleJPanel.add(bJPanel);
			} else if (i== 8) {
				
				bJPanel.setBackground(colorTaux3PN(DataBaseStat2.getTaux_3PN()));
				bJPanel.add(listValeur.get(i));
				grilleJPanel.add(bJPanel);
				
			} else if (i== 10) {
				if (DataBaseStat2.getTaux_1PN() <= 5) {
					bJPanel.setBackground(Color.green);
				}
				bJPanel.add(listValeur.get(i));
				grilleJPanel.add(bJPanel);
				
			} else {
				bJPanel.add(listValeur.get(i));
				grilleJPanel.add(bJPanel);
			}
		}
		panel.add(grilleJPanel, BorderLayout.CENTER);
		
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
		
		
	}
	
	public static void initList() {
		DataBaseStat2.getStat();
		String[] listAttributName = {"Nb de tentatives", "Nb CCO inséminés", "MII 24h", "% MII", "2PN 24h",
				"Taux de fécondation Consensus", "Taux de fécondation MII", "3PN 24h", "Taux 3PN", "1PN 24h", 
				"Taux 1PN", "0PN 24h", "Taux 0PN", "Echecs de fécondation", "Taux échecs fécondation"};
		for (String e: listAttributName) {
			listAttribut.add(new Label(e));
		}
	
		listValeur.add(new AttributLabel("" +DataBaseStat2.getNb_Stimulation()));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getNb_cco_insemine()));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getmII_24()));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getmII_p100()  + " %"));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getpN2_24()));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getTaux_fecondation_consensus() + " %"));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getTaux_fecondation_mmi()  + " %"));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getpN3_24()));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getTaux_3PN()  + " %"));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getpN1_24()));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getTaux_1PN()  + " %"));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getpN0_24()));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getTaux_0PN()  + " %"));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getNb_Echec()));
		listValeur.add(new AttributLabel("" +DataBaseStat2.getTaux_echec_fecondation()  + " %"));
	}
	
	public Color colorConsensus(double a) {
		if (a >= 75) {
			return Color.green;
			
		} else if (a >= 60 && a < 75) {
			return Color.blue;
		} else {
			return Color.red;
		}
		
	}
	
	public Color colorTaux3PN(double a) {
		if (a < 4.5) {
			return Color.green;
			
		} else if (a >= 4.5 && a < 9) {
			return Color.blue;
		} else {
			return Color.red;
		}
		
	}
	
	public Color colorTaux1PN(double a) {
		if (a <= 5) {
			return Color.green;
		} else {
			return Color.white;
		}
			
	
		
	}





		

		








	public static void seeStat(JFrame a) {
		FenetreStat fenetreStat = new FenetreStat(a);
		fenetreStat.setVisible(true);
		
	}

}
