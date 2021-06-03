package databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Embryons;
import entities.Fiv;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DataBaseEmbryons extends DataBase {
	
    public static int insertEmbryons (Embryons embryon) {
    	
    	System.out.println("Ajout de l'embryon :" + embryon);
    	
    	try {
    		System.out.println("Ouverture Statement");
			PreparedStatement preparedStatement = connecteur.prepareStatement("INSERT INTO Embryons VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
					/*+ " (id,  Num_dossier,  Num_stimulation,  Date_naissance_patiente,  Type_AMP, Nbr_embryons," + 
					"Date_ponction,  Age_Debut, Decision,  Decision_nb_jour_observation, "
					+ "J0_std_matur_injection,  J1_nb_GP," + 
					"J1_nb_PN,  J2_typique_atypique,  J2_blastomere,  J2_fragmentation,  J5_blastomere,  J5_blastocyste," + 
					"J5_ICM,  J5_tropho,  J6_blastomere,  J6_blastocyste,  J6_ICM,  J6_tropho," + 
					"Num_stim_grossesse,  Type_AMP_grossesse,  Grossesse,  Nbr_embryons_grossesse,  Nbr_enfants_nes, technicien1Decoronisation," + 
					"J0TypeMicroInjection, JOTechnicien1, techCongTechnicien)"
					+ "*/ 
			preparedStatement.setObject(1, embryon.getId());
			preparedStatement.setObject(2, embryon.getNumDossier());
			preparedStatement.setObject(3, embryon.getNumStimulation());
			
			try {
				
			
				String t = new SimpleDateFormat("yyyy-MM-dd").format(embryon.getDateNaissancePatiente());
				preparedStatement.setObject(4, t);
				
			} catch (NullPointerException e) {
				preparedStatement.setObject(4, null);
			}
			
			preparedStatement.setObject(5, embryon.getTypeAmp());
			preparedStatement.setObject(6, embryon.getNbrEmbryons());
			try {
				String t2 = new SimpleDateFormat("yyyy-MM-dd").format(embryon.getDatePonction());
				preparedStatement.setObject(7, t2);
			} catch (NullPointerException e) {
				preparedStatement.setObject(7, null);
			}
			
			preparedStatement.setObject(8, embryon.getAgeDebut());
			preparedStatement.setObject(9, embryon.getDecision());
			preparedStatement.setObject(10, embryon.getDecisionNbJourObservation());
			preparedStatement.setObject(11, embryon.getJ0StdMaturInjection());
			preparedStatement.setObject(12, embryon.getJ1NbGp());
			preparedStatement.setObject(13, embryon.getJ1NbPn());
			preparedStatement.setObject(14, embryon.getJ2TypiqueAtypique());
			preparedStatement.setObject(15, embryon.getJ2Blastomere());
			preparedStatement.setObject(16, embryon.getJ2Fragmentation());
			preparedStatement.setObject(17, embryon.getJ5Blastomere());
			preparedStatement.setObject(18, embryon.getJ5Blastocyste());
			preparedStatement.setObject(19, embryon.getJ5Icm());
			preparedStatement.setObject(20, embryon.getJ5Tropho());
			preparedStatement.setObject(21, embryon.getJ6Blastomere());
			preparedStatement.setObject(22, embryon.getJ6Blastocyste());
			preparedStatement.setObject(23, embryon.getJ6Icm());
			preparedStatement.setObject(24, embryon.getJ6Tropho());
			preparedStatement.setObject(25, embryon.getNumStimGrossesse());
			preparedStatement.setObject(26, embryon.getTypeAmpGrossesse());
			preparedStatement.setObject(27, embryon.getGrossesse());
			preparedStatement.setObject(28, embryon.getNbrEmbryonsGrossesse());
			preparedStatement.setObject(29, embryon.getNbrEnfantsNes());
			preparedStatement.setObject(30, embryon.getTechnicien1Decoronisation());
			preparedStatement.setObject(31, embryon.getJ0TypeMicroInjection());
			preparedStatement.setObject(32, embryon.getJOTechnicien1());
			preparedStatement.setObject(33, embryon.getTechCongTechnicien());

			
			System.out.println("Execution ...");
			
			int statut = preparedStatement.executeUpdate();
			
			System.out.println("Insersion réussie :");
			
			System.out.println(statut + " : " + embryon + " a été ajouté");
			
			System.out.println("Fermeture statement");
			
			preparedStatement.close();
			
			return statut;

			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Echec ...");
			e.printStackTrace();
			return -1;
		}
   
    }
    
    public static int insertListEmbryons(ArrayList<Embryons> list) {
		
		System.out.println("Ajout des embryons ...");
		int s = 0;
		for (Embryons e : list) {
			s += insertEmbryons(e);
		}
		System.out.println("Ajout terminé");
		
		return s;
	}
    
    
public static ArrayList<Embryons> getEmbryons(String s) {
		
		ArrayList<Embryons> list = new ArrayList<Embryons> ();
		try {
			Statement statement = connecteur.createStatement();
			java.sql.ResultSet res = statement.executeQuery(s);
			
			
			while (res.next()) {
				int[] indiceInteger = {1, 2, 3, 6, 8, 10, 15, 25, 28, 29};
				int[] indiceString = {4, 5, 7, 9, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22, 23, 24, 26, 27, 30, 31, 32, 33};
				ArrayList<Integer> a = new ArrayList<Integer>();
				ArrayList<String> b = new ArrayList<String>();
				
				for (int e : indiceInteger) {
					a.add(res.getInt(e));
					
				}
				for (int e : indiceString) {
					b.add(res.getString(e));
					
				}
				

				Embryons anEmb = new Embryons(a.get(0), a.get(1), a.get(2), b.get(0), b.get(1), a.get(3), b.get(2),
						a.get(4), b.get(3), a.get(5), b.get(4), b.get(5), b.get(6), b.get(7), a.get(6), b.get(8), b.get(9), b.get(10), b.get(11),
						b.get(12), b.get(13), b.get(14), b.get(15), b.get(16), a.get(7), b.get(17), b.get(18), a.get(8), a.get(9), b.get(19), b.get(20), b.get(21), b.get(22));
				list.add(anEmb);
				
				
			}
			statement.close();
			return list;
			
			
			
			

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
	}
    
    
    
}