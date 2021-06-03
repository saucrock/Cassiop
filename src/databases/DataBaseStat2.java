package databases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Embryons;

public class DataBaseStat2 extends DataBase {
	
	static int nb_cco_insemine;
	static int nb_Stimulation;
	static int mII_24;
	static int pN0_24;
	static int pN1_24;
	static int pN2_24;
	static int pN3_24;
	static int nb_Echec;
	static double taux_echec_fecondation; //nb_Echec /nb_stimulation
	static double taux_0PN; // PN0_24/CCO 
	static double taux_1PN; // PN1_24/CCO AFFIVHAGE
	static double taux_3PN; // PN3_24/CCO AFFICHAGE
	static double taux_fecondation_mmi; // PN2_24/MII_24
	static double taux_fecondation_consensus; //PN2_24/CC0 AFFICHAGE
	static double mII_p100; //MII/CCO
	
	
	public static void display() {
		System.out.println("nb_cco_insemine" + nb_cco_insemine);

		System.out.println("nb_Stimulation: " + nb_Stimulation);
		System.out.println("mII_24: " + mII_24);
		System.out.println("pN0_24: " + pN0_24);
		System.out.println("pN1_24: " + pN1_24);
		System.out.println("pN2_24: " + pN2_24);
		System.out.println("pN3_24: " + pN3_24);
		System.out.println("nb_Echec: " + nb_Echec);
		System.out.println("taux_echec_fecondation: " + taux_echec_fecondation);
		System.out.println("taux_0PN: " + taux_0PN);
		System.out.println("taux_1PN: " + taux_1PN);
		System.out.println("taux_3PN: " + taux_3PN);
		System.out.println("taux_fecondation_mmi: " + taux_fecondation_mmi);
		System.out.println("taux_fecondation_consensus: " + taux_fecondation_consensus);
		System.out.println("mII_p100: " + mII_p100);
		
	}
	

	
	public static void getStat() {
		nb_cco_insemine = computeNBCCOInsemine();
		nb_Stimulation = computeNBStimulation();
		mII_24 = computeMMI24();
		pN0_24 = computePN0_24();
		pN1_24 = computePN1_24();
		pN2_24 = computePN2_24();
		pN3_24 = computePN3_24();
		nb_Echec = computeNBEchec(computeNumStim());
		if (nb_cco_insemine != 0) {
			mII_p100 = arrondi((double) mII_24 / nb_cco_insemine) * 100;
			taux_fecondation_consensus = arrondi((double) pN2_24 / nb_cco_insemine) * 100;
			taux_0PN = arrondi((double) pN0_24 / nb_cco_insemine) * 100;
			taux_1PN = arrondi((double) pN1_24 / nb_cco_insemine) * 100;
			taux_3PN = arrondi((double) pN3_24 / nb_cco_insemine) * 100;
		} else {
			mII_p100 = -1;
			taux_fecondation_consensus = -1;
			taux_0PN = -1;
			taux_1PN = -1;
			taux_3PN = -1;
		}
		
		if (mII_24 != 0) {
			
			taux_fecondation_mmi = 100 * arrondi((double) pN2_24 / mII_24) ;
		} else  {
			taux_fecondation_mmi = -1;
		}
		if (nb_Stimulation != 0) {
			taux_echec_fecondation = arrondi((double) nb_Echec / nb_Stimulation) * 100;
		} else {
			taux_echec_fecondation = -1;
		}
	}
		
		
	
	
	public static double arrondi(double a) {
		return Math.round(a*1000.0)/1000.0;
	}
	
	
	public static int computePN0_24() {
			
			String query = "select count(*) from Embryons where J1_nb_PN = \"0 PN\" and Type_AMP = \"FIV(C)\";";
			int n;
			try {
				Statement statement = connecteur.createStatement();
				java.sql.ResultSet res = statement.executeQuery(query);
				res.next();
				n = res.getInt(1);
				statement.close();
				System.out.println(n);
				
				return n;
				
	
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			
				return -1;
			}
			
			
		}
	
	public static int computePN1_24() {
		
		String query = "select count(*) from Embryons where J1_nb_PN = \"1 PN\" and Type_AMP = \"FIV(C)\";";
		int n;
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			res.next();
			n = res.getInt(1);
			statement.close();
			System.out.println(n);
			
			return n;
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		
			return -1;
		}
		
		
	}
	
	
	public static int computePN3_24() {
			
			String query = "select count(*) from Embryons where J1_nb_PN = \"3 PN\" and Type_AMP = \"FIV(C)\";";
			int n;
			try {
				Statement statement = connecteur.createStatement();
				java.sql.ResultSet res = statement.executeQuery(query);
				res.next();
				n = res.getInt(1);
				statement.close();
				System.out.println(n);
				
				return n;
				
	
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			
				return -1;
			}
			
			
		}
	
	public static int computePN2_24() {
		
		String query = "select count(*) from Embryons where J1_nb_PN = \"2 PN\" and Type_AMP = \"FIV(C)\";";
		int n;
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			res.next();
			n = res.getInt(1);
			statement.close();
			System.out.println(n);
			
			return n;
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		
			return -1;
		}
		
		
	}
	
	public static int computeMMI24() {
		String query = "select count(*) from Embryons where Type_AMP = \"FIV(C)\" and (J1_nb_GP = \"1 GP\" or J1_nb_GP = \"2 GP\" or J1_nb_GP = \"GP fragmenté\");";
		int n;
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			res.next();
			n = res.getInt(1);
			statement.close();
			System.out.println(n);
			
			return n;
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		
			return -1;
		}
		
	}
	
	
	public static int computeNBStimulation() {
		String query = "select count(distinct Num_stimulation) from Embryons where Type_AMP = \"FIV(C)\";";
	
		int n;
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			res.next();
			n = res.getInt(1);
			statement.close();
			System.out.println(n);
			
			return n;
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		
			return -1;
		}
	}
	
	public static int computeNBCCOInsemine() {
		
		String query = "select count(*) from Embryons where Type_AMP = \"FIV(C)\";";
		
		int n;
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			res.next();
			n = res.getInt(1);
			statement.close();
			
			return n;
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		
			return -1;
		}

	}
	
	public static int computeNBEchec(ArrayList<Integer> lisNum) {
		int s = 0;
		for (Integer numInteger : lisNum) {
			
			String query = "select * from Embryons where Type_AMP = \"FIV(C)\" and Num_stimulation = " + numInteger ;
			ArrayList<Embryons> list = DataBaseEmbryons.getEmbryons(query);
			if (isAnEchec(list)) {
				s++;
			}
			
		}
		
		return s;
	}
	
	public static Boolean isAnEchec(ArrayList<Embryons> list) {
		for (Embryons e : list) {
			try {
				if (!e.getJ1NbPn().equals("0 PN")) {
					return false;
				}
				
			} catch (NullPointerException f) {
				return false;
			}
		}
		return true;
		
	}
	
	public static ArrayList<Integer> computeNumStim() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String query = "select distinct Num_stimulation from Embryons where Type_AMP = \"FIV(C)\";";
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			while(res.next()) {
				list.add(res.getInt(1));
			}
			statement.close();
			return list;
			
			
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		
			
		}
		
	}

	public static int getNb_cco_insemine() {
		return nb_cco_insemine;
	}

	public static int getNb_Stimulation() {
		return nb_Stimulation;
	}

	public static int getmII_24() {
		return mII_24;
	}

	public static int getpN0_24() {
		return pN0_24;
	}

	public static int getpN1_24() {
		return pN1_24;
	}

	public static int getpN2_24() {
		return pN2_24;
	}

	public static int getpN3_24() {
		return pN3_24;
	}

	public static int getNb_Echec() {
		return nb_Echec;
	}

	public static double getTaux_echec_fecondation() {
		return taux_echec_fecondation;
	}

	public static double getTaux_0PN() {
		return taux_0PN;
	}

	public static double getTaux_1PN() {
		return taux_1PN;
	}

	public static double getTaux_3PN() {
		return taux_3PN;
	}

	public static double getTaux_fecondation_mmi() {
		return taux_fecondation_mmi;
	}

	public static double getTaux_fecondation_consensus() {
		return taux_fecondation_consensus;
	}

	public static double getmII_p100() {
		return mII_p100;
	}
	
	
	
	
	
	
	
	

}
