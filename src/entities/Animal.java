package entities;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.DateUtil;
public class Animal {
	
	private String espece;
	private String sexe;
	private Date dateNaissance;
	private String commentaire;
	private String nomString;
	private String date;
	
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getEspece() {
		return espece;
	}


	public void setEspece(String espece) {
		this.espece = espece;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public String getNomString() {
		return nomString;
	}


	public void setNomString(String nomString) {
		this.nomString = nomString;
	}


	public Animal(String espece, String sexe, int date, String commentaire, String nomString) {
		
		this.espece = espece;
		this.sexe = sexe;
		this.dateNaissance = DateUtil.getJavaDate((double) date);
		this.commentaire = commentaire;
		this.nomString = nomString;
		this.date = new SimpleDateFormat("yyyy-MM-dd").format(dateNaissance);
	}


	@Override
	public String toString() {
		return "Animal [espece=" + espece + ", sexe=" + sexe + ", dateNaissance=" + date + ", commentaire="
				+ commentaire + ", nomString=" + nomString + "]";
	}
	
	
	
	

	
	
	
	

}
