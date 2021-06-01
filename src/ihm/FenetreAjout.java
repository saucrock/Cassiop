package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import databases.DataBaseEmbryons;
import databases.DataBaseFiv;
import databases.DataBaseGeri;
import databases.DataBaseTec;
import entities.Geri;
import excels.Excel;
import excels.ExcelEmbryons;
import excels.ExcelFiv;
import excels.ExcelGeri;
import excels.ExcelTec;

import javax.imageio.ImageIO;

public class FenetreAjout extends JDialog implements ActionListener {

	JPanel pan = new JPanel();
	Bouton boutonParcourir = new Bouton("Parcourir");
	Bouton boutonAjouter = new Bouton("Ajouter");
	Label chemin = new Label("Fichier: ");
	JTextArea identite = new JTextArea("Identité: ");
	
	int identiteType;
	boolean isSelected = false;
	String cheminPath;
	



	public FenetreAjout(JFrame a) {
		super(a, true);
		this.setTitle("Ajouter à la BDD");
		this.setSize(500, 300);
		pan.setLayout(new BorderLayout());
		
		pan.add(chemin,BorderLayout.SOUTH);
		
		boutonParcourir.addActionListener(this);
		
		boutonAjouter.addActionListener(this);
		boutonAjouter.setEnabled(false);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1,3));
		pan2.add(boutonParcourir);
		identite.setEditable(false);
		identite.setOpaque(false);
		identite.setFont(new Font("Arial", Font.BOLD, 25));
		
		pan2.add(identite);
		pan2.add(boutonAjouter);
		

		
		
		pan.add(pan2, BorderLayout.CENTER);
		this.setContentPane(pan);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == boutonParcourir) {
			System.out.println("Ajout: clic Parcourir");
			
			
			
		    JFileChooser jFileChooser = new JFileChooser();
		    
			
	         
	        int result = jFileChooser.showOpenDialog(new JFrame());
	     
	     
	        if (result == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = jFileChooser.getSelectedFile();
	            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
	            cheminPath = selectedFile.getAbsolutePath();
	            chemin.setText("Fichier: " + selectedFile.getAbsolutePath());
		        isSelected = updateIdentite(selectedFile.getAbsolutePath());
		        if (isSelected) {
		        	boutonAjouter.setEnabled(true);
		        } else {
		        	boutonAjouter.setEnabled(false);
		        }

	        }
		} else if (arg0.getSource() == boutonAjouter) {
			int succes = 0;
			int initial = 0;
			if (identiteType == 1) {
				
				ExcelGeri tableau = new ExcelGeri(cheminPath);
				initial = tableau.nb_ligne - 1;
				succes = DataBaseGeri.insertListGeri(tableau.getListGeri());
				
			} else if (identiteType == 2) {
				
				ExcelFiv tableau = new ExcelFiv(cheminPath);
				initial = tableau.nb_ligne -1;
				succes = DataBaseFiv.insertListFiv(tableau.getListFiv());
			} else if (identiteType == 3) {
				ExcelTec tableau = new ExcelTec(cheminPath);
				initial = tableau.nb_ligne -1;
				succes = DataBaseTec.insertListTec(tableau.getListTec());				
			}else if (identiteType == 4) {
				ExcelEmbryons tableau = new ExcelEmbryons(cheminPath);
				initial = tableau.nb_ligne -1;
				succes = DataBaseEmbryons.insertListEmbryons(tableau.getListEmbryons());				
			}
			JOptionPane.showMessageDialog(this, succes + "/" + initial + " ont été insérés avec succès");
			Fenetre.updateQuantities();
			this.dispose();
			
		}
	}
	
	public boolean updateIdentite(String s) {
		identiteType = Excel.checkIdentity(s);
		if (identiteType == 1) {
			identite.setText("Identité: \n\n\n     Geri");
			identite.setForeground(Color.green);

			System.out.println(identite.getText());
			return true;
		} else if (identiteType == 2) {
			identite.setText("Identité: \n\n\n     Fiv");
			identite.setForeground(Color.green);

			System.out.println(identite.getText());
			return true;
		} else if (identiteType == 3) {
			identite.setText("Identité: \n\n\n     Tec");
			identite.setForeground(Color.green);
			System.out.println(identite.getText());
			return true;
		}else if (identiteType == 4) {
			identite.setText("Identité: \n\n\n     Embryons");
			identite.setForeground(Color.green);
			System.out.println(identite.getText());
			return true;
		}
		System.out.println(identiteType);
		identite.setText("     Non \n identifié");
		identite.setForeground(Color.red);

		return false;
		
	}
	
	

}
