package ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Fiv;


public class PanelMME extends JPanel {
	
	ArrayList<Label> listAttribut = new ArrayList<Label>();	
	static ArrayList<AttributLabel> attributPrincipal = new ArrayList<AttributLabel>();
	static ArrayList<AttributLabel> attributConjoint = new ArrayList<AttributLabel>();
	public PanelMME() {
		super();
		initList();
		
		this.setLayout(new BorderLayout());
		Label titre = new Label("MME VS MR");
		this.add(titre, BorderLayout.NORTH);
		
		JPanel principalConjoint = new JPanel(new GridLayout(5,3,50,50));
		principalConjoint.add(new Label("Identité"));
		principalConjoint.add(new Label("Principal"));
		principalConjoint.add(new Label("Conjoint"));
		for (int i = 0; i < 4; i++) {
			principalConjoint.add(listAttribut.get(i));
			principalConjoint.add(attributPrincipal.get(i));
			principalConjoint.add(attributConjoint.get(i));
		}
		
		this.add(principalConjoint, BorderLayout.CENTER);
		
	
		

		
		
		
	}
	
	public void initList() {
		listAttribut.add(new Label("Age"));
		listAttribut.add(new Label("BMI"));
		listAttribut.add(new Label("Tabac"));
		listAttribut.add(new Label("Infertilité"));
		
		attributPrincipal.add(new AttributLabel(""));
		attributPrincipal.add(new AttributLabel(""));
		attributPrincipal.add(new AttributLabel(""));
		attributPrincipal.add(new AttributLabel(""));
		
		attributConjoint.add(new AttributLabel(""));
		attributConjoint.add(new AttributLabel(""));
		attributConjoint.add(new AttributLabel(""));
		attributConjoint.add(new AttributLabel(""));
	}
	
	public static void voidAttribut() {
		for (int i = 0; i < 4; i ++) {
			System.out.println("Changement");
			attributPrincipal.get(i).setText(null);
			attributConjoint.get(i).setText(null);
		}
	}
	
	public static void changeInfo(Fiv fiv) {
		System.out.println("Changement pannel MMe");
		int age = fiv.getListIntegers().get(2);
		double bmi = fiv.getListDoubles().get(0);
		double bmiConjoint = fiv.getListDoubles().get(1);
		String tabac = fiv.getListStrings().get(8);
		String tabacConjoint = fiv.getListStrings().get(9);
		String infertilite = fiv.getListStrings().get(3);
		String infertiliteConjoint = fiv.getListStrings().get(5);
		
		attributPrincipal.get(0).setText(""+age);
		attributPrincipal.get(1).setText(""+bmi);
		attributPrincipal.get(2).setText(tabac);
		attributPrincipal.get(3).setText(infertilite);
		
		attributConjoint.get(0).setText("Non Renseigné");
		attributConjoint.get(1).setText(""+bmiConjoint);
		attributConjoint.get(2).setText(tabacConjoint);
		attributConjoint.get(3).setText(infertiliteConjoint);
		
		
		
		
		
		
	}

}
