package ihm;
import java.util.ArrayList;

import javax.swing.JOptionPane;



import databases.DataBaseFiv;

public class BoitePropo {
	

	  public static int showProposition(int num) {
	    ArrayList<Integer> list = DataBaseFiv.getNumStim(num);
	    String[] listStim = new String[list.size()];
	    for (int i = 0; i < list.size(); i++) {
	    	listStim[i] = list.get(i).toString();
	    }
	    JOptionPane jop = new JOptionPane();
	    String choix = (String)jop.showInputDialog(null, 
	      "Veuillez choisir la stim",
	      "Choix stim",
	      JOptionPane.QUESTION_MESSAGE,
	      null,
	      listStim,
	      listStim[0]);
	    return Integer.parseInt(choix);
	    
	  }
	}