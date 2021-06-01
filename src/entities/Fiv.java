package entities;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;



public class Fiv {
	String[] DATELIST = {"id_stim", "num_dossier", "date_debut_stim", "date_fin_stim", "Annee_de_debut_de_Sterilite","date_ponction_se", "date_transfert", "date_congelation"};
	String[] DOUBLELIST = {"id_stim", "num_dossier", "bmi","bmi_conjoint", "amh_ng_ml", "amh_j2j4"};
	String[] STRINGLIST = {"id_stim", "num_dossier", "grossesse", "Grossesse_ABM", "type_amp", "infertilite_principale", "infertilite_dossier", "infertilite_conjoint",
						"indication_principale", "indication_dossier", "tabac_principal", "tabac_conjoint", "duree_trait_gona", "clinicien_transfert", 
						"biologiste_transfert", "clinicien_ponctionneur", "biologiste_ponctionneur", "injecteur", "nom_decoronisateur", "technicien_congelation",
						"jours_cong_emb", "condition_transfert", "mode_transfert"};
	String[] INTLIST = {"id_stim", "num_dossier", "age_debut_stim", "rang_secu", "rang_cycle", "rang_ponction", "dose_i_gona", "dose_t_gona", "nb_ovo_recueillis", "nb_meta_2_j0", 
						"nb_emb_total", "nb_ovoc_lyses", "nb_pellu_vide_fiv", "nb_pellu_vide_ics", "nb_ovo_2pn_j1", "nb_ovo_3pn_plus_j1", "nb_embr_tansfere",
						"nb_embr_congele", "gross_nb_embry", "enfant_ne"};
	
	
	
	int numDossier; 
	int numStimulation;
	ArrayList<String> listStrings;
	ArrayList<Integer> listIntegers;
	ArrayList<Double> listDoubles; 
	ArrayList<Integer> listDatesIntegers;
	ArrayList<Date> listDates;
	ArrayList<String> listDatesStrings;
	
	
	public Fiv(int numDossier, int numStimulation, ArrayList<String> listStrings, ArrayList<Integer> listIntegers,
			ArrayList<Double> listDoubles, ArrayList<Integer> listDatesIntegers) {
		
		this.numDossier = numDossier;
		this.numStimulation = numStimulation;
		this.listStrings = listStrings;
		this.listIntegers = listIntegers;
		this.listDoubles = listDoubles;
		this.listDatesIntegers = listDatesIntegers;
		this.listDates = new ArrayList<Date>();
		this.listDatesStrings = new ArrayList<String>();
		
		for (int i = 0; i < listDatesIntegers.size(); i ++) {
			try {
				Date t = DateUtil.getJavaDate((double) this.listDatesIntegers.get(i));
				this.listDates.add(t);
				this.listDatesStrings.add(new SimpleDateFormat("yyyy-MM-dd").format(t));
			}
			catch (NullPointerException e) {
				this.listDates.add(null);
				this.listDatesStrings.add(null);
			}
			
		}
	}
	
	public Fiv(ArrayList<String> listStrings, ArrayList<Integer> listIntegers,
			ArrayList<Double> listDoubles, ArrayList<String> listDates) {
		this.listStrings = listStrings;
		this.listIntegers = listIntegers;
		this.listDoubles = listDoubles;
		this.listDatesStrings = listDates;
	}


	public int getNumDossier() {
		return numDossier;
	}


	public void setNumDossier(int numDossier) {
		this.numDossier = numDossier;
	}


	public int getNumStimulation() {
		return numStimulation;
	}


	public void setNumStimulation(int numStimulation) {
		this.numStimulation = numStimulation;
	}


	public ArrayList<String> getListStrings() {
		return listStrings;
	}


	public void setListStrings(ArrayList<String> listStrings) {
		this.listStrings = listStrings;
	}


	public ArrayList<Integer> getListIntegers() {
		return listIntegers;
	}


	public void setListIntegers(ArrayList<Integer> listIntegers) {
		this.listIntegers = listIntegers;
	}


	public ArrayList<Double> getListDoubles() {
		return listDoubles;
	}


	public void setListDoubles(ArrayList<Double> listDoubles) {
		this.listDoubles = listDoubles;
	}


	public ArrayList<Integer> getListDatesIntegers() {
		return listDatesIntegers;
	}


	public void setListDatesIntegers(ArrayList<Integer> listDatesIntegers) {
		this.listDatesIntegers = listDatesIntegers;
	}


	public ArrayList<Date> getListDates() {
		return listDates;
	}


	public void setListDates(ArrayList<Date> listDates) {
		this.listDates = listDates;
	}


	public ArrayList<String> getListDatesStrings() {
		return listDatesStrings;
	}


	public void setListDatesStrings(ArrayList<String> listDatesStrings) {
		this.listDatesStrings = listDatesStrings;
	}


	@Override
	public String toString() {
		return "Fiv [numDossier=" + numDossier + ", numStimulation=" + numStimulation + ", listStrings=" + listStrings
				+ ", listIntegers=" + listIntegers + ", listDoubles=" + listDoubles + ", listDatesIntegers="
				+ listDatesIntegers + ", listDates=" + listDates + ", listDatesStrings=" + listDatesStrings + "]";
	}
	
	public String  getInsertDatesRequete() {
		String s = "INSERT INTO fiv_date VALUES (";
    	
    	for (int i = 0; i < DATELIST.length - 1; i++) {
    		s = s + "?, ";
    	}
    	s = s + "?);";
    	
    	return s;
	}
	
	public String getInsertDoubleRequete() {
		String s = "INSERT INTO fiv_double VALUES (";
    	
    	for (int i = 0; i < DOUBLELIST.length - 1; i++) {
    		s = s + "?, ";
    	}
    	s = s + "?);";
    	
    	return s;
	}
	
	public String getInsertStringRequete() {
		String s = "INSERT INTO fiv_string VALUES (";
    	
    	for (int i = 0; i < STRINGLIST.length - 1; i++) {
    		s = s + "?, ";
    	}
    	s = s + "?);";
    	
    	return s;
	}
	
	public String  getInsertIntRequete() {
		String s = "INSERT INTO fiv_int VALUES (";
    	
    	for (int i = 0; i < INTLIST.length - 1; i++) {
    		s = s + "?, ";
    	}
    	s = s + "?);";
    	
    	return s;
	}
	
	
	
	
	
	

}
