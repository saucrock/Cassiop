package entities;

import java.text.SimpleDateFormat;


import org.apache.poi.ss.usermodel.DateUtil;

public class Geri {
	
	int patientId; 
	String birthDate;
	String estimatedDate;
	int wellNumber; 
	int timeFromInsemination;
	String name;
	
	
	public Geri(int patientId, double birthday, double estimated, int wellNumber, int timeFromInsemination, String name) {
		
		this.patientId = patientId;
		this.wellNumber = wellNumber;
		this.timeFromInsemination = timeFromInsemination;
		this.name = name;
		
		this.birthDate = new SimpleDateFormat("yyyy-MM-dd").format(DateUtil.getJavaDate(birthday));
		this.estimatedDate = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(DateUtil.getJavaDate(estimated));
	}
	
	public Geri(int patientId, String birthday, String estimated, int wellNumber, int timeFromInsemination, String name) {
		
		this.patientId = patientId;
		this.wellNumber = wellNumber;
		this.timeFromInsemination = timeFromInsemination;
		this.name = name;
		
		this.birthDate = birthday;
		this.estimatedDate = estimated;
	}
	


	@Override
	public String toString() {
		return "Geri [patientId=" + patientId + ", birthDate=" + birthDate + ", estimatedDate=" + estimatedDate
				+ ", wellNumber=" + wellNumber + ", timeFromInsemination=" + timeFromInsemination + ", name=" + name
				+ "]";
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getEstimatedDate() {
		return estimatedDate;
	}


	public void setEstimatedDate(String estimatedDate) {
		this.estimatedDate = estimatedDate;
	}


	public int getWellNumber() {
		return wellNumber;
	}


	public void setWellNumber(int wellNumber) {
		this.wellNumber = wellNumber;
	}


	public int getTimeFromInsemination() {
		return timeFromInsemination;
	}


	public void setTimeFromInsemination(int timeFromInsemination) {
		this.timeFromInsemination = timeFromInsemination;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	





	
	
	
	
	
	
	
	

}
