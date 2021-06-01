package entities;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;



public class Tec {
	String[] DATELIST = {"id_stim", "num_dossier", "date_debut_stim", "date_fin_stim", "date_ponction_se", "date_transfert", "date_congelation"};
	String[] DOUBLELIST = {"id_stim", "num_dossier", "bmi", "amh_ng_ml", "amh_j2j4"};
	String[] STRINGLIST = {"id_stim", "num_dossier", "grossesse", "type_amp", "infertilite_principale", "infertilite_dossier", "infertilite_conjoint",
						"indication_principale", "indication_dossier", "tabac_principal", "tabac_conjoint", "duree_trait_gona", "clinicien_transfert", 
						"biologiste_transfert", "clinicien_ponctionneur", "biologiste_ponctionneur", "injecteur", "nom_decoronisateur", "technicien_congelation",
						"jours_cong_emb", "condition_transfert", "mode_transfert"};
	String[] INTLIST = {"id_stim", "num_dossier", "rang_secu", "rang_cycle", "rang_ponction", "dose_i_gona", "dose_t_gona", "nb_ovo_recueillis", "nb_meta_2_j0", 
						"nb_emb_total", "nb_ovoc_lyses", "nb_pellu_vide_fiv", "nb_pellu_vide_ics", "nb_ovo_2pn_j1", "nb_ovo_3pn_plus_j1", "nb_embr_tansfere",
						"nb_embr_congele", "gross_nb_embry", "enfant_ne"};
	
	
	

	ArrayList<String> listStrings;
	ArrayList<Integer> listIntegers;
	ArrayList<String> listDatesStrings;
	Double proge;
	Double lh;
	
	
	public Tec(ArrayList<String> listStrings, ArrayList<Integer> listIntegers,
			Double proge, Double lh, ArrayList<Integer> listDatesIntegers) {
		
		
		this.listStrings = listStrings;
		this.listIntegers = listIntegers;
		this.proge = proge;
		this.lh = lh;
		
		
		
		this.listDatesStrings = new ArrayList<String>();
		
		for (int i = 0; i < listDatesIntegers.size(); i ++) {
			try {
				Date t = DateUtil.getJavaDate((double) listDatesIntegers.get(i));
				
				this.listDatesStrings.add(new SimpleDateFormat("yyyy-MM-dd").format(t));
			}
			catch (NullPointerException e) {
				
				this.listDatesStrings.add(null);
			}
			
		}
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











	public Double getProge() {
		return proge;
	}





	public void setProge(Double proge) {
		this.proge = proge;
	}





	public Double getLh() {
		return lh;
	}





	public void setLh(Double lh) {
		this.lh = lh;
	}





	public ArrayList<String> getListDatesStrings() {
		return listDatesStrings;
	}


	public void setListDatesStrings(ArrayList<String> listDatesStrings) {
		this.listDatesStrings = listDatesStrings;
	}


	@Override
	public String toString() {
		return "Tec [listStrings=" + listStrings
				+ ", listIntegers=" + listIntegers + ", listDatesStrings=" + listDatesStrings + ", progesterone= " + proge + ", lh=" + lh+ "]";
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
