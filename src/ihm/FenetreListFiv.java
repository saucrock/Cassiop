package ihm;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

import org.apache.poi.hslf.util.SystemTimeUtils;

import databases.DataBase;

import java.awt.*;

import entities.Fiv;


public class FenetreListFiv extends JDialog {
	
	static FenetreListFiv fenetre;
	static JPanel panel = new JPanel(new BorderLayout());
	PanelListFiv panelFivs;
	static PanelMME panelMME;
	static PanelCommun panelCommun;
	static PanelResumeDate panelResumeDate;
	static JPanel panelFivDescription = new JPanel(new GridLayout(1,2));
	JPanel panelIdentite = new JPanel((new GridLayout(2,1,100,100)));
	Border identiteBorder = BorderFactory.createLineBorder(Color.red, 2);
	
	
	public FenetreListFiv(JFrame a, ArrayList<Fiv> list) {
		super(a, true);
		fenetre = this;
		this.setTitle("Consultation");
		this.setSize(2000, 1000);
		panelFivDescription.removeAll();
		
		

		
		panelFivs = new PanelListFiv(list, this);
		panelMME = new PanelMME();
		panelCommun = new PanelCommun();
		panelResumeDate = new PanelResumeDate();
		
		
		panel.add(panelFivs, BorderLayout.WEST);
		
		panelIdentite.add(panelMME);
		panelIdentite.add(panelCommun);
		panelIdentite.setBorder(identiteBorder);
		
		
		
		panelFivDescription.add(panelIdentite);
		panelFivDescription.add(panelResumeDate);
		
		panel.add(panelFivDescription,BorderLayout.CENTER);
		
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		
	}
	
	public static void changePanel(PanelListFiv pan) {
		panel.removeAll();
		panel.add(pan, BorderLayout.WEST);
		panel.add(panelFivDescription, BorderLayout.CENTER);
		panel.revalidate();
		
		
	}
	
	public static void changeInfo(Fiv fiv) {
		
		panelMME.changeInfo(fiv);
		panelCommun.changeInfo(fiv);
		
		panelResumeDate.removeAll();
		
		panelResumeDate.changeInfo(fiv);
		panelResumeDate.displayDate();
		panelResumeDate.pack();
		
		
		
		
		
		panelMME.revalidate();
		panelCommun.revalidate();
		panelResumeDate.revalidate();
		panelResumeDate.repaint();
	}
	
	public static void voidAttribut() {
		panelMME.voidAttribut();
		panelCommun.voidAttribut();

		
	}
	public void removeAll() {
		this.dispose();
	}
	
	public static void consultationTentative(Fiv fiv) {
		FenetreIdentiteFiv.display(fenetre, fiv);
	}
	

	


}
