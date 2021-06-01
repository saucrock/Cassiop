package ihm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

import databases.DataBase;
import databases.DataBaseFiv;
import databases.DataBaseGeri;
import entities.Fiv;
import entities.Geri;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Fenetre extends JFrame implements ActionListener {

	JPanel pan = new JPanel();
	Bouton boutonConsulter = new Bouton("Consulter");
	Bouton boutonAjouter = new Bouton("Ajouter");
	Bouton boutonSupprimer = new Bouton("Supprimer");
	ImageIcon icone = new ImageIcon(getClass().getResource("Logo_HOPITAL_FOCH.png"));
	JLabel image = new JLabel(icone);
	JPanel pan2 = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan4 = new JPanel();
	
	static int nbFiv;
	static int nbGeri;
	static int nbTec;
	static int nbEmb;

	
	static Label labelFiv = new Label("Nombre de Fiv: " + nbFiv);
	static Label labelGeri = new Label("Nombre de Geri: " + nbGeri);
	static Label labelTec = new Label("Nombre de Tec: " + nbTec);
	static Label labelEmb = new Label("Nombre de Emb: " + nbEmb);






	public Fenetre() {
		DataBase.connexion();
		
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	DataBase.closeDataBase();
                System.exit(0);
            }
        });
		
		this.setTitle("BDD Hopital");
		this.setSize(800, 400);
		pan.setLayout(new BorderLayout());
		
		
		boutonConsulter.addActionListener(this);
		boutonAjouter.addActionListener(this);
		boutonSupprimer.addActionListener(this);

		
		
		
		pan2.setLayout(new GridLayout(3,1));
		pan2.add(boutonConsulter);
		pan2.add(boutonAjouter);
		pan2.add(boutonSupprimer);
		
		pan3.setLayout(new BorderLayout());
		pan3.add(image, BorderLayout.SOUTH);
		pan3.add(pan4, BorderLayout.CENTER);
		
		
		
		
		pan4.setLayout(new GridLayout(2,2));
		pan4.add(labelFiv);
		pan4.add(labelGeri);
		pan4.add(labelEmb);
		pan4.add(labelTec);
		updateQuantities();
		


		
		
		pan.add(pan2, BorderLayout.EAST);
		pan.add(pan3, BorderLayout.CENTER);
		this.setContentPane(pan);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == boutonAjouter) {
			System.out.println("Principal: Clic Ajouter");
			FenetreAjout fenetreAjout = new FenetreAjout(this);
			
		} else if (arg0.getSource() == boutonSupprimer) {
			System.out.println("Principal: Clic Supprimer");
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 25));
			int confirmation = JOptionPane.showConfirmDialog(this,"Do you want to proceed ?", "Select an option", JOptionPane.YES_NO_CANCEL_OPTION);
			if (confirmation == 0) {
				int deletedFiv = DataBase.deleteFiv();
				int deletedGeri = DataBase.deleteGeri();
				int deletedTec = DataBase.deleteTec();
				int deletedEmb = DataBase.deleteEmbryons();
				
				JOptionPane.showMessageDialog(this, deletedFiv + " fiv effacés\n" + deletedGeri + " geri effacés\n" + deletedTec + " tec effacés\n" + deletedEmb + " emb effacés");
	
				
				updateQuantities();
			}
			
		} else if (arg0.getSource() == boutonConsulter) {
			boutonConsulter();

		}
	}
	
	public static void updateQuantities() {
		ArrayList<Integer> list = DataBase.getNumbers();
		nbFiv = list.get(0);
		nbGeri = list.get(1);
		nbTec = list.get(2);
		nbEmb = list.get(3);
		labelFiv.setText("Nombre de Fiv: " + nbFiv);
		labelGeri.setText("Nombre de Geri: " + nbGeri);
		labelTec.setText("Nombre de Tec: " + nbTec);
		labelEmb.setText("Nombre de Emb: " + nbEmb);


		
	}
	
	
	  public void boutonConsulter() { 

		  FenetreListFiv affFivs = new FenetreListFiv(this, DataBaseFiv.getFivs("select * from fiv;"));
		  
	  }
	 
	
	
	/*
	 * public void boutonConsulter() {
	 * System.out.println("Principal: Clic Modifier");
	 * UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	 * UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 25));
	 * 
	 * 
	 * JOptionPane d = new JOptionPane(); String retour = d.showInputDialog(this,
	 * "Veuillez entrer un numéro de dossier","Numéro"); if(!isNumber(retour)) {
	 * JOptionPane.showMessageDialog(this, "Format incorrect"); } else { int res =
	 * Integer.parseInt(retour); if (!DataBase.isNumberIn(res)) {
	 * JOptionPane.showMessageDialog(this, "Aucun dossier ne porte ce numéro"); }
	 * else { System.out.println(retour); int a = BoitePropo.showProposition(res);
	 * System.out.println("num "+ res + " stm " + a); Fiv eFiv =
	 * DataBaseFiv.getFiv(res, a); FenetreFiv aFenetreFiv = new FenetreFiv(this,
	 * eFiv); } }
	 * 
	 * 
	 * }
	 */
	
	public boolean isNumber(String s) {
		try {
			int res = Integer.parseInt(s);
			if (res >= 0) {
				return true;
			} else {
				return false;
			}
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

}
