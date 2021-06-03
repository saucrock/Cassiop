package databases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;







public class DataBase {

	static String BDD = "hopital";
	static String url = "jdbc:mysql://localhost/" + BDD + "?characterEncoding=utf8&useSSL=false&useUnicode=true";
	static String user = "saucrock";
	static String passwd = "carnot75016";
	

	static Connection connecteur;
	static Boolean connected;


	//----------------------------------------------------------------------------------------------------------------
	//Constructeur
	//----------------------------------------------------------------------------------------------------------------


	public static void connexion() {
		System.out.println("Connection à la base de données !");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connecteur = DriverManager.getConnection(url, user, passwd);
			connected = true;
			System.out.println("Connexion réussie !");

		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("Erreur pas de connection");
			connected = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erreur pas de connection");
			connected = false;
		}

	}

	//----------------------------------------------------------------------------------------------------------------
	//Fermeture
	//----------------------------------------------------------------------------------------------------------------

	public static void closeDataBase() {
		if (connected) {
			try {
				System.out.println("Fermeture BDD");
				connecteur.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	public static int deleteFiv() {
		System.out.println("Effacement des fiv...");
		String query = "delete from fiv";
		try {
			Statement statement = connecteur.createStatement();
			int res = statement.executeUpdate(query);
			
			statement.close();
			System.out.println("Fiv effacés !");
			return res;
		} catch (SQLException e) {
			System.err.println("Error executing query: " +e.getMessage());
			return 0;
		}
		
	}
	
	public static int deleteGeri() {
		System.out.println("Effacement des Geri...");
		try {
			Statement statement = connecteur.createStatement();
			String query = "delete from geri";
			int res = statement.executeUpdate(query);
			
			statement.close();
			System.out.println("Geri effacés !");
			return res;
		} catch (SQLException e) {
			System.err.println("Error executing query: " +e.getMessage());
			return 0;
		}
		
	}
	
	public static int deleteTec() {
		System.out.println("Effacement des Tec...");
		try {
			Statement statement = connecteur.createStatement();
			String query = "delete from tec";
			int res = statement.executeUpdate(query);
			
			statement.close();
			System.out.println("Tec effacés !");
			return res;
		} catch (SQLException e) {
			System.err.println("Error executing query: " +e.getMessage());
			return 0;
		}
		
	}
	
	public static int deleteEmbryons() {
		System.out.println("Effacement des Embryons...");
		try {
			Statement statement = connecteur.createStatement();
			String query = "delete from Embryons";
			int res = statement.executeUpdate(query);
			
			statement.close();
			System.out.println("Embryons effacés !");
			return res;
		} catch (SQLException e) {
			System.err.println("Error executing query: " +e.getMessage());
			return 0;
		}
		
	}
	
	
	
	public static ArrayList<Integer> getNumbers() {
		String[] entitie = {"fiv", "geri", "tec", "Embryons"};
		ArrayList<Integer> quantities = new ArrayList<Integer>();
		
		for (int i = 0; i < 4; i++) {
			String query = "select count(*) from " + entitie[i];
			try {
				Statement statement = connecteur.createStatement();
				java.sql.ResultSet res = statement.executeQuery(query);
				res.next();
				quantities.add(res.getInt(1));
				statement.close();
				

			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		return quantities;
	}
	
	public static boolean isNumberIn(int e) {
		String query = "select count(*) from fiv where num_dossier = " + e;
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(query);
			res.next();
			int alors = res.getInt(1);
			statement.close();
			if (alors == 0) {
				return false;
			} else {
				return true;
			}
			
		}catch (SQLException f) {
			return false;
		}
	}
}





	
