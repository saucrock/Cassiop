package entities;

import java.util.Date;
import java.text.SimpleDateFormat;




public class Embryons {
	
	
	
	
	 int id;
	 int numDossier;
	 int numStimulation;
	 
	 Date dateNaissancePatiente;
	 String dateNaissancePatienteString;
	 
	 String typeAmp;
	 int nbrEmbryons;
	 
	 Date datePonction;
	 String datePonctionString;
	 
	 int ageDebut;
	 String decision;
	 Integer decisionNbJourObservation;
	 String J0StdMaturInjection;
	 String J1NbGp;
	 String J1NbPn;
	 String J2TypiqueAtypique;
	 Integer J2Blastomere;
	 String J2Fragmentation;
	 String J5Blastomere;
	 String J5Blastocyste;
	 String J5Icm;
	 String J5Tropho;
	 String J6Blastomere;
	 String J6Blastocyste;
	 String J6Icm;
	 String J6Tropho;
	 Integer numStimGrossesse;
	 String typeAmpGrossesse;
	 String Grossesse;
	 Integer nbrEmbryonsGrossesse;
	 Integer nbrEnfantsNes;
	 String technicien1Decoronisation;
	 String J0TypeMicroInjection;
	 String JOTechnicien1;
	 String techCongTechnicien;
	
	public Embryons(int id, int numDossier, int numStimulation, Date dateNaissancePatiente, String typeAmp, int nbrEmbryons, 
			Date datePonction, int ageDebut, String decision, Integer decisionNbJourObservation,  String J0StdMaturInjection, String J1NbGp, 
			String J1NbPn, String J2TypiqueAtypique, Integer J2Blastomere, String J2Fragmentation, String J5Blastomere, String J5Blastocyste, 
			String J5Icm, String J5Tropho, String J6Blastomere, String J6Blastocyste, String J6Icm, String J6Tropho, Integer numStimGrossesse, 
			String typeAmpGrossesse, String Grossesse, Integer nbrEmbryonsGrossesse, Integer nbrEnfantsNes, String technicien1Decoronisation,
			String J0TypeMicroInjection, String JOTechnicien1,String techCongTechnicien) {
		
		
		this.id = id;
		this.numDossier = numDossier;
		this.numStimulation = numStimulation;
		this.dateNaissancePatiente = dateNaissancePatiente ;
		this.dateNaissancePatienteString = new SimpleDateFormat("yyyy-MM-dd").format(dateNaissancePatiente);
		this.typeAmp = typeAmp;
		this.nbrEmbryons = nbrEmbryons;
		this.datePonction = datePonction;
		this.datePonctionString = new SimpleDateFormat("yyyy-MM-dd").format(datePonction);
		this.ageDebut = ageDebut;
		this.decision = decision;
		this.decisionNbJourObservation = decisionNbJourObservation;
		this.J0StdMaturInjection = J0StdMaturInjection;
		this.J1NbGp =J1NbGp;
		this.J1NbPn = J1NbPn;
		this.J2TypiqueAtypique =J2TypiqueAtypique;
		this.J2Blastomere =J2Blastomere;
		this.J2Fragmentation =J2Fragmentation;
		this.J5Blastomere =J5Blastomere;
		this.J5Blastocyste =J5Blastocyste;
		this.J5Icm =J5Icm;
		this.J5Tropho = J5Tropho;
		this.J6Blastomere = J6Blastomere;
		this.J6Blastocyste = J6Blastocyste;
		this.J6Icm =J6Icm;
		this.J6Tropho=J6Tropho;
		this.numStimGrossesse=numStimGrossesse;
		this.typeAmpGrossesse =typeAmpGrossesse;
		this.Grossesse=Grossesse;
		this.nbrEmbryonsGrossesse=nbrEmbryonsGrossesse;
		this.nbrEnfantsNes=nbrEnfantsNes;
		this.technicien1Decoronisation = technicien1Decoronisation;
		this.J0TypeMicroInjection = J0TypeMicroInjection;
		this.JOTechnicien1 = JOTechnicien1;
		this.techCongTechnicien = techCongTechnicien;
	}
	
	
	public Embryons(int id, int numDossier, int numStimulation, String dateNaissancePatiente, String typeAmp, int nbrEmbryons, 
			String datePonction, int ageDebut, String decision, Integer decisionNbJourObservation,  String J0StdMaturInjection, String J1NbGp, 
			String J1NbPn, String J2TypiqueAtypique, Integer J2Blastomere, String J2Fragmentation, String J5Blastomere, String J5Blastocyste, 
			String J5Icm, String J5Tropho, String J6Blastomere, String J6Blastocyste, String J6Icm, String J6Tropho, Integer numStimGrossesse, 
			String typeAmpGrossesse, String Grossesse, Integer nbrEmbryonsGrossesse, Integer nbrEnfantsNes, String technicien1Decoronisation,
			String J0TypeMicroInjection, String JOTechnicien1,String techCongTechnicien) {
		
		
		this.id = id;
		this.numDossier = numDossier;
		this.numStimulation = numStimulation;
		
		this.dateNaissancePatienteString = dateNaissancePatiente;
		this.typeAmp = typeAmp;
		this.nbrEmbryons = nbrEmbryons;
		this.datePonctionString = datePonction;
		this.ageDebut = ageDebut;
		this.decision = decision;
		this.decisionNbJourObservation = decisionNbJourObservation;
		this.J0StdMaturInjection = J0StdMaturInjection;
		this.J1NbGp =J1NbGp;
		this.J1NbPn = J1NbPn;
		this.J2TypiqueAtypique =J2TypiqueAtypique;
		this.J2Blastomere =J2Blastomere;
		this.J2Fragmentation =J2Fragmentation;
		this.J5Blastomere =J5Blastomere;
		this.J5Blastocyste =J5Blastocyste;
		this.J5Icm =J5Icm;
		this.J5Tropho = J5Tropho;
		this.J6Blastomere = J6Blastomere;
		this.J6Blastocyste = J6Blastocyste;
		this.J6Icm =J6Icm;
		this.J6Tropho=J6Tropho;
		this.numStimGrossesse=numStimGrossesse;
		this.typeAmpGrossesse =typeAmpGrossesse;
		this.Grossesse=Grossesse;
		this.nbrEmbryonsGrossesse=nbrEmbryonsGrossesse;
		this.nbrEnfantsNes=nbrEnfantsNes;
		this.technicien1Decoronisation = technicien1Decoronisation;
		this.J0TypeMicroInjection = J0TypeMicroInjection;
		this.JOTechnicien1 = JOTechnicien1;
		this.techCongTechnicien = techCongTechnicien;
	}

	
	public String getDateNaissancePatienteString() {
		return dateNaissancePatienteString;
	}


	public void setDateNaissancePatienteString(String dateNaissancePatienteString) {
		this.dateNaissancePatienteString = dateNaissancePatienteString;
	}


	public String getDatePonctionString() {
		return datePonctionString;
	}


	public void setDatePonctionString(String datePonctionString) {
		this.datePonctionString = datePonctionString;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDateNaissancePatiente() {
		return dateNaissancePatiente;
	}

	public void setDateNaissancePatiente(Date dateNaissancePatiente) {
		this.dateNaissancePatiente = dateNaissancePatiente;
	}

	public String getTypeAmp() {
		return typeAmp;
	}

	public void setTypeAmp(String typeAmp) {
		this.typeAmp = typeAmp;
	}

	public int getNbrEmbryons() {
		return nbrEmbryons;
	}

	public void setNbrEmbryons(int nbrEmbryons) {
		this.nbrEmbryons = nbrEmbryons;
	}

	public Date getDatePonction() {
		return datePonction;
	}

	public void setDatePonction(Date datePonction) {
		this.datePonction = datePonction;
	}

	public int getAgeDebut() {
		return ageDebut;
	}

	public void setAgeDebut(int ageDebut) {
		this.ageDebut = ageDebut;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public Integer getDecisionNbJourObservation() {
		return decisionNbJourObservation;
	}

	public void setDecisionNbJourObservation(Integer decisionNbJourObservation) {
		this.decisionNbJourObservation = decisionNbJourObservation;
	}

	public String getJ0StdMaturInjection() {
		return J0StdMaturInjection;
	}

	public void setJ0StdMaturInjection(String j0StdMaturInjection) {
		J0StdMaturInjection = j0StdMaturInjection;
	}

	public String getJ1NbGp() {
		return J1NbGp;
	}

	public void setJ1NbGp(String j1NbGp) {
		J1NbGp = j1NbGp;
	}

	public String getJ1NbPn() {
		return J1NbPn;
	}

	public void setJ1NbPn(String j1NbPn) {
		J1NbPn = j1NbPn;
	}

	public String getJ2TypiqueAtypique() {
		return J2TypiqueAtypique;
	}

	public void setJ2TypiqueAtypique(String j2TypiqueAtypique) {
		J2TypiqueAtypique = j2TypiqueAtypique;
	}

	public Integer getJ2Blastomere() {
		return J2Blastomere;
	}

	public void setJ2Blastomere(int j2Blastomere) {
		J2Blastomere = j2Blastomere;
	}

	public String getJ2Fragmentation() {
		return J2Fragmentation;
	}

	public void setJ2Fragmentation(String j2Fragmentation) {
		J2Fragmentation = j2Fragmentation;
	}

	public String getJ5Blastomere() {
		return J5Blastomere;
	}

	public void setJ5Blastomere(String j5Blastomere) {
		J5Blastomere = j5Blastomere;
	}

	public String getJ5Blastocyste() {
		return J5Blastocyste;
	}

	public void setJ5Blastocyste(String j5Blastocyste) {
		J5Blastocyste = j5Blastocyste;
	}

	public String getJ5Icm() {
		return J5Icm;
	}

	public void setJ5Icm(String j5Icm) {
		J5Icm = j5Icm;
	}

	public String getJ5Tropho() {
		return J5Tropho;
	}

	public void setJ5Tropho(String j5Tropho) {
		J5Tropho = j5Tropho;
	}

	public String getJ6Blastomere() {
		return J6Blastomere;
	}

	public void setJ6Blastomere(String j6Blastomere) {
		J6Blastomere = j6Blastomere;
	}

	public String getJ6Blastocyste() {
		return J6Blastocyste;
	}

	public void setJ6Blastocyste(String j6Blastocyste) {
		J6Blastocyste = j6Blastocyste;
	}

	public String getJ6Icm() {
		return J6Icm;
	}

	public void setJ6Icm(String j6Icm) {
		J6Icm = j6Icm;
	}

	public String getJ6Tropho() {
		return J6Tropho;
	}

	public void setJ6Tropho(String j6Tropho) {
		J6Tropho = j6Tropho;
	}

	public Integer getNumStimGrossesse() {
		return numStimGrossesse;
	}

	public void setNumStimGrossesse(Integer numStimGrossesse) {
		this.numStimGrossesse = numStimGrossesse;
	}

	public String getTypeAmpGrossesse() {
		return typeAmpGrossesse;
	}

	public void setTypeAmpGrossesse(String typeAmpGrossesse) {
		this.typeAmpGrossesse = typeAmpGrossesse;
	}

	public String getGrossesse() {
		return Grossesse;
	}

	public void setGrossesse(String grossesse) {
		Grossesse = grossesse;
	}

	public Integer getNbrEmbryonsGrossesse() {
		return nbrEmbryonsGrossesse;
	}

	public void setNbrEmbryonsGrossesse(Integer nbrEmbryonsGrossesse) {
		this.nbrEmbryonsGrossesse = nbrEmbryonsGrossesse;
	}

	public Integer getNbrEnfantsNes() {
		return nbrEnfantsNes;
	}

	public void setNbrEnfantsNes(Integer nbrEnfantsNes) {
		this.nbrEnfantsNes = nbrEnfantsNes;
	}
	
	public void setTechnicien1Decoronisation(String technicien1Decoronisation) {
		this.technicien1Decoronisation = technicien1Decoronisation;
	}


	public String getJ0TypeMicroInjection() {
		return J0TypeMicroInjection;
	}


	public void setJ0TypeMicroInjection(String j0TypeMicroInjection) {
		J0TypeMicroInjection = j0TypeMicroInjection;
	}


	public String getJOTechnicien1() {
		return JOTechnicien1;
	}


	public void setJOTechnicien1(String jOTechnicien1) {
		JOTechnicien1 = jOTechnicien1;
	}


	public String getTechCongTechnicien() {
		return techCongTechnicien;
	}


	public void setTechCongTechnicien(String techCongTechnicien) {
		this.techCongTechnicien = techCongTechnicien;
	}

	public String getTechnicien1Decoronisation() {
		return technicien1Decoronisation;
	}

}
