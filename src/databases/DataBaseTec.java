package databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


import entities.Tec;

public class DataBaseTec extends DataBase {
	static String iniQueryString = "INSERT INTO tec VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	
	public static int insertListTec(ArrayList<Tec> list) {
		int s = 0;
		for (Tec e : list) {
			s += insertTec(e);
		}
		return s;
	}

	public static int insertTec(Tec tec) {

		System.out.println("Ajout du Tec ...");

		try {
			
			PreparedStatement preparedStatement = connecteur.prepareStatement(iniQueryString);
			for (int i = 0; i < tec.getListIntegers().size(); i++ ) {
				preparedStatement.setInt(i+1, tec.getListIntegers().get(i));
			}
			
			for (int i = 0; i < tec.getListStrings().size(); i++ ) {
				preparedStatement.setString(7+i, tec.getListStrings().get(i));
			}
			
			for (int i = 0; i < tec.getListDatesStrings().size(); i++ ) {
				preparedStatement.setString(i+17, tec.getListDatesStrings().get(i));
			}
			
			preparedStatement.setDouble(21, tec.getProge());
			preparedStatement.setDouble(22, tec.getLh());

			int statut = preparedStatement.executeUpdate();

			System.out.println("Insersion réussie :");



			preparedStatement.close();

			return statut;

		} catch (SQLException e) { 
			System.out.println("Echec ...");
			e.printStackTrace();
			return -1;
		}
	}
	

	
	
	


// Fin Classe
}
