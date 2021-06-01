package ihm;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

import org.apache.poi.hslf.util.SystemTimeUtils;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;

import databases.DataBase;

import java.awt.*;

import entities.Fiv;


public class FenetreIdentiteFiv extends JDialog {
	
	String ponction;
	JPanel panel = new JPanel(new GridLayout(1,2));
	JPanel ficheIdentiteJPanel = new JPanel(new BorderLayout());
	Label label = new Label("Fiche Identité");
	JPanel grilleIdentité = new JPanel(new GridLayout(5,2));
	ArrayList<Label> listLabels = new ArrayList<Label>();
	ArrayList<AttributLabel> listValeur = new ArrayList<AttributLabel>();
	JScrollPane scrollPane;
	
	public FenetreIdentiteFiv(JDialog a, Fiv fiv) {
		super(a, true);
		int numDossier = fiv.getListIntegers().get(1);
		ponction = fiv.getListDatesStrings().get(3);
		this.setTitle("Consultation Fiv " + numDossier + " / " + ponction);
		this.setSize(2000, 1000);
		
		ficheIdentiteJPanel.add(label, BorderLayout.NORTH);
		this.initAttribut(fiv);
		for (int i = 0; i < 5; i++) {
			grilleIdentité.add(listLabels.get(i));
			grilleIdentité.add(listValeur.get(i));
		}
		ficheIdentiteJPanel.add(grilleIdentité, BorderLayout.CENTER);
		panel.add(ficheIdentiteJPanel);
		
		scrollPane = new JScrollPane(new ScrollPaneEmb(numDossier, ponction));
		panel.add(scrollPane);
		
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
		
		
		
	}
	
	public void initAttribut(Fiv fiv) {
		String[] nomAttribut = {"Jour Transfert", "Nb Ovocytes", "Nb Métaphases", "Nb Ovocytes 2PN-J1", "Nb Emb Congelés"};
		ArrayList<String> valeurs = getValeur(fiv);
		for (int i = 0; i < 5; i++) {
			listLabels.add(new Label(nomAttribut[i]));
			listValeur.add(new AttributLabel(valeurs.get(i)));
			
			
		}
	}
	
	public ArrayList<String> getValeur(Fiv fiv) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> listInteger = fiv.getListIntegers();
		list.add("J" + getJTransfert(fiv));
		list.add("" + listInteger.get(6));
		list.add("" + listInteger.get(7));
		list.add("" + listInteger.get(12));
		list.add("" + listInteger.get(15));
		
		return list;
		
		
		
	}
	
	public Integer getJTransfert(Fiv fiv) {
		try {
			

			String dateTransfertString = fiv.getListDatesStrings().get(4);
			String jourTransfert = dateTransfertString.split("-")[2];
			String jourPonction = ponction.split("-")[2];
			
			int res = Integer.parseInt(jourTransfert) - Integer.parseInt(jourPonction);
			return res;
		} catch (Exception exception) {
			return null;
		}
	}
	
	public static void display(JDialog a, Fiv fiv) {
		FenetreIdentiteFiv b = new FenetreIdentiteFiv(a, fiv);
		b.setVisible(true);
	}
	
	
	


}
