package databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Fiv;
import entities.Geri;

public class DataBaseGeri extends DataBase {
	
	
	public static int insertListGeri(ArrayList<Geri> list) {
		System.out.println("Ajout des geris ...");
		int s = 0;
		for (Geri e : list) {
			s+= insertGeri(e);
		}
		System.out.println("Ajout réussi");
		return s;
	}

	public static int insertGeri(Geri g) {

		System.out.println("Ajout du geri ...");

		try {
			
			PreparedStatement preparedStatement = connecteur.prepareStatement("INSERT INTO geri VALUES(NULL, ?, ?, ?, ?, ?, ?);");
			preparedStatement.setInt(1, g.getPatientId());
			preparedStatement.setString(2, g.getBirthDate());
			preparedStatement.setString(3, g.getEstimatedDate());
			preparedStatement.setInt(4, g.getWellNumber());
			preparedStatement.setInt(5, g.getTimeFromInsemination());
			preparedStatement.setString(6, g.getName());

			int statut = preparedStatement.executeUpdate();

			System.out.println("Insersion réussie :");



			preparedStatement.close();

			return statut;

		} catch (SQLException e) { 
			System.out.println("Echec ...");
			e.printStackTrace();
			return 0;
		}
	}
	
	
public static ArrayList<Geri> getGeris(String s) {
		
		ArrayList<Geri> list = new ArrayList<Geri>();
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(s);
			while (res.next()) {
				int patientId = res.getInt(2); 
				String birthDate = res.getString(3);
				String estimatedDate = res.getString(4);
				int wellNumber = res.getInt(5); 
				int timeFromInsemination = res.getInt(6);
				String name = res.getString(7);
			
		
				
				Geri aGeri = new Geri(patientId, birthDate, estimatedDate, wellNumber, timeFromInsemination, name);
				list.add(aGeri);
				
				
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
