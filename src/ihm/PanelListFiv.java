package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;

import com.sun.net.httpserver.Authenticator.Result;

import databases.DataBaseFiv;
import entities.Fiv;

public class PanelListFiv extends JPanel implements ActionListener {
	
	
	JPanel panel = new JPanel();
	JScrollPane scrollPane;
	JPanel searchPanel = new JPanel();
	JTextField field = new JTextField("");
	Bouton searBouton  = new Bouton("Search");
	FenetreListFiv frame;
	ArrayList<Fiv> listUnique;
	
	public PanelListFiv(ArrayList<Fiv> list, FenetreListFiv a) {
		super(new BorderLayout());
		searchPanel.setLayout(new FlowLayout());
		field.setFont(new Font("Arial", Font.BOLD, 25));
		field.setPreferredSize(new Dimension(100,50));
		searchPanel.add(field);
		searBouton.addActionListener(this);
		searchPanel.add(searBouton);
		
		this.add(searchPanel, BorderLayout.NORTH);
		
		listUnique = uniqueNumDossier(list);
		
		panel.setLayout(new GridLayout(listUnique.size(),1));
		
		for (int i = 0; i < listUnique.size(); i++) {
			Fiv fiv = listUnique.get(i);
			BoutonFiv bouton = new BoutonFiv(fiv.getListIntegers().get(1).toString(),fiv);
			panel.add(bouton);
		}
		scrollPane = new JScrollPane(panel);
		this.add(scrollPane, BorderLayout.CENTER);
		
		frame = a;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == searBouton) {
			
			
			int n;
			try {
				String buffer = field.getText();
				if (buffer.matches("[+-]?\\d*(\\.\\d+)?")) {
					n = Integer.parseInt(buffer);
					System.out.println(n);
					updateList(n);
				}
			} catch (Exception e) {
				n = -1;
				System.out.println(n);
				updateList(n);
			}
			
		}
		
	}
	

	
	
	public void updateList(int n) { 
		ArrayList<Fiv> list;
		if (n== -1) {
			list = DataBaseFiv.getFivs("select * from fiv;");
			
			
		} else {
			list = DataBaseFiv.getFivs("select * from fiv where num_dossier = " + n + ";");
		}
		
		PanelListFiv nouveau = new PanelListFiv(list, frame);
		
		FenetreListFiv.changePanel(nouveau);
		frame.voidAttribut();
		
		
		
		
		
	}
	
	public ArrayList<Fiv> uniqueNumDossier(ArrayList<Fiv> list) {
		ArrayList<Fiv> restult = new ArrayList<Fiv>();
		ArrayList<Integer> listNum = new ArrayList<Integer>();
		
		for (Fiv fiv : list) {
			int num = fiv.getListIntegers().get(1);
			if (!(isIn(listNum, num))) {
				listNum.add(num);
				restult.add(fiv);
			}
			
		}
		return restult;
	}
	
	public Boolean isIn(ArrayList<Integer> list, int n) {
		for (Integer e : list) {
			if (e == n) {
				return true;
			}
		}
		return false;
	}
	 
	
	

}
