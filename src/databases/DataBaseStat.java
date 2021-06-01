package databases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseStat extends DataBase {
	
	public static double[] getRapport() {
		String query = "select nb_meta_2_j0, nb_ovo_2pn_j1, type_amp from fiv;";
		ArrayList<Integer> nbOvo_Fiv = new ArrayList<Integer>();
		ArrayList<Integer> meta_Fiv = new ArrayList<Integer>();
		ArrayList<Integer> nbOvo_Icsi = new ArrayList<Integer>();
		ArrayList<Integer> meta_Icsi = new ArrayList<Integer>();

		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			
			while (res.next()) {
				
				
				if (isICSI(res.getString(3))) {
					
					nbOvo_Icsi.add(res.getInt(2));
					meta_Icsi.add(res.getInt(1));
					System.out.println(res.getInt(2));
					System.out.println(res.getInt(1));
				} else {
					nbOvo_Fiv.add(res.getInt(2));
					meta_Fiv.add(res.getInt(1));
				}
			}
			statement.close();
			double SovoFiv = 0;
			double SovoIcsi = 0;
			double SMetaFiv = 0;
			double SMetaIcsi = 0;
			
			for (int i = 0; i < nbOvo_Fiv.size(); i++) {
				SovoFiv += (double) nbOvo_Fiv.get(i);
				SMetaFiv += (double) meta_Fiv.get(i);
				
			}
			
			for (int i = 0; i < nbOvo_Icsi.size(); i++) {
				SovoIcsi += (double) nbOvo_Icsi.get(i);
				SMetaIcsi += (double) meta_Icsi.get(i);
				
			}
			
			System.out.println("Somme SovoFiv" + SovoFiv);
			System.out.println("Somme SovoIcsi" +SovoIcsi);
			System.out.println("Somme SMetaFiv" + SMetaFiv);
			System.out.println("Somme SmetaICSI" + SMetaIcsi);
			double rapportFiv;
			double rapportIcsi;
			double rapportTotal;
			try {
				rapportFiv =Math.round((SMetaFiv / SovoFiv)*100.0)/100.0;
			} catch (java.lang.ArithmeticException e) {
				rapportFiv = 0;
			}
			try {
				rapportIcsi = Math.round((SMetaIcsi / SovoIcsi)*100.0)/100.0;
			} catch (java.lang.ArithmeticException e) {
				rapportIcsi = 0;
			}
			try {
				rapportTotal = Math.round(((SMetaFiv + SMetaIcsi) / (SovoFiv + SovoIcsi))*100.0)/100.0;
			} catch (java.lang.ArithmeticException e) {
				rapportTotal = 0;
			}
			
			
			double[] result = {rapportIcsi, rapportFiv, rapportTotal};
			for (int i = 0 ; i < 3; i++) {
				System.out.println(result[i]);
			}
			return result;
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
	}
	
	public static Boolean isICSI(String s) {
		String[] possibilite = {"ICSI(C)", "ICSI(BT/Cong)", "FIV(C) transformée en ICSI(C)"};
		for (String eString : possibilite) {
			if (s.equals(eString)) {
				return true;
			}
		}
		return false;
	}

}
