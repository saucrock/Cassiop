package ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import entities.Fiv;



public class PanelCommun extends JPanel{
	
	static ArrayList<Label> listAttributCommun = new ArrayList<Label>();
	static ArrayList<AttributLabel> attributCommun = new ArrayList<AttributLabel>();
	public PanelCommun() {
		super(new BorderLayout());
		initAttribut();
		this.add(new Label("En Commun"), BorderLayout.NORTH);
		
		JPanel gridCommun = new JPanel(new GridLayout(4,2, 50, 50));
		
		for (int i = 0; i < 4; i++) {
			gridCommun.add(listAttributCommun.get(i));
			gridCommun.add(attributCommun.get(i));
		}
		
		this.add(gridCommun,BorderLayout.CENTER);
		
		
		
	}
	
	public static void initAttribut() {
		listAttributCommun.add(new Label("AMH"));
		listAttributCommun.add(new Label("Indic Dossier"));
		listAttributCommun.add(new Label("Infertilité dossier"));
		listAttributCommun.add(new Label("Début stérilité"));
		
		attributCommun.add(new AttributLabel(""));
		attributCommun.add(new AttributLabel(""));
		attributCommun.add(new AttributLabel(""));
		attributCommun.add(new AttributLabel(""));

		
	}
	
	public static void voidAttribut() {
		for (int i = 0; i < 4; i ++) {
			System.out.println("Changement");
			attributCommun.get(i).setText(null);			
		}
	}
	
	public static void changeInfo(Fiv fiv) {
		System.out.println("Changement pannel commun");
		
		double amh = fiv.getListDoubles().get(2);
		String indic = fiv.getListStrings().get(7);
		String infert = fiv.getListStrings().get(4);
		String debut = fiv.getListDatesStrings().get(2);
		
		attributCommun.get(0).setText(amh+"");
		attributCommun.get(1).setText(indic);
		attributCommun.get(2).setText(infert);
		attributCommun.get(3).setText(debut);
		

	}

}
