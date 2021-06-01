package databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entities.Animal;
import entities.Fiv;
import entities.Geri;



public class DataBaseFiv extends DataBase {
	
	static String iniQueryString = "INSERT INTO fiv VALUES(?,?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";


	


	


	
	public static int insertListFiv(ArrayList<Fiv> list) {
		
		System.out.println("Ajout des fiv ...");
		int s = 0;
		for (Fiv e : list) {
			s += insertFiv(e);
		}
		System.out.println("Ajout terminé");
		
		return s;
	}
	

	//----------------------------------------------------------------------------------------------------------------
	//Insertion Fiv 
	//----------------------------------------------------------------------------------------------------------------

	

	
	public static int insertFiv(Fiv fiv) {
		System.out.println("Ajout du Fiv...");
		try {
			PreparedStatement preparedStatement = connecteur.prepareStatement(iniQueryString);
			
			for (int i = 0; i < fiv.getListIntegers().size(); i++) {
				
				preparedStatement.setObject(i+1, fiv.getListIntegers().get(i));
			}
			for (int i = 0; i < fiv.getListDatesStrings().size(); i++) {
				preparedStatement.setObject(i+21, fiv.getListDatesStrings().get(i));
			}
			for (int i = 0; i < fiv.getListDoubles().size(); i++) {
				preparedStatement.setObject(27+i, fiv.getListDoubles().get(i));
			}
			for (int i = 0; i < fiv.getListStrings().size(); i++) {
				preparedStatement.setObject(i+31, fiv.getListStrings().get(i));
			}
			
			
			int status = preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("Insertion réussie !");
			return status;
		} catch(SQLException e) {
			System.out.println("Echec ...");
			e.printStackTrace();
			return 0;			
		}
	}
	
	public static ArrayList<Integer> getNumStim(int dossier) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String query = "select id_stim from fiv where num_dossier = " + dossier;
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			while(res.next()) {
				list.add(res.getInt(1));
			}
			return list;
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static Fiv getFiv(int dossier, int stimu) {
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		ArrayList<String> listString = new ArrayList<String>();
		ArrayList<Double> listDouble = new ArrayList<Double>();
		ArrayList<String> listDate = new ArrayList<String>();
		String query = "select * from fiv where num_dossier = " + dossier + " and id_stim = " + stimu;
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			res.next();
			for (int i = 1; i <= 50; i++) {
				if (i <= 20) {
					listInt.add(res.getInt(i));
				} else if(i > 20 && i <= 26) {
					listDate.add(res.getString(i));
				} else if(i >26 && i <=30) {
					listDouble.add(res.getDouble(i));
				} else {
					listString.add(res.getString(i));
				}
				
				
			}
			return new Fiv(listString, listInt, listDouble, listDate);
			
			
			
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
	}
	
	
	public static ArrayList<Fiv> getFivs(String s) {
		
		ArrayList<Fiv> list = new ArrayList<Fiv> ();
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(s);
			while (res.next()) {
				ArrayList<Integer> listInt = new ArrayList<Integer>();
				ArrayList<String> listString = new ArrayList<String>();
				ArrayList<Double> listDouble = new ArrayList<Double>();
				ArrayList<String> listDate = new ArrayList<String>();
			
				for (int i = 1; i <= 50; i++) {
					if (i <= 20) {
						listInt.add(res.getInt(i));
					} else if(i > 20 && i <= 26) {
						listDate.add(res.getString(i));
					} else if(i >26 && i <=30) {
						listDouble.add(res.getDouble(i));
					} else {
						listString.add(res.getString(i));
					}
				}
				Fiv aFiv = new Fiv(listString, listInt, listDouble, listDate);
				list.add(aFiv);
				
				
			}
			statement.close();
			return list;
			
			
			
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
	}



		
	


// Fin Classe
}
