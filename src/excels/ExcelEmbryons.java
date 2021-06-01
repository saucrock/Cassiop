package excels;

import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

import org.apache.poi.ss.usermodel.DateUtil;

import entities.Embryons;
import entities.Fiv;


public class ExcelEmbryons extends Excel {
	
	int [] indiceDate = {2, 7};
	int [] indiceInt = {4, 14, 17, 64, 257, 264, 273};
	int [] indiceString = {3, 16, 20, 23, 26, 27, 44, 45, 63, 68, 179, 185, 186, 187, 217, 223, 224, 225, 256, 258, 263};
	
	
	public ExcelEmbryons (String s){
		
		super(s);
	}
	
	
	public ArrayList<Embryons> getListEmbryons() {
		ArrayList<Embryons> list = new ArrayList<Embryons>();
		for (int i = 1; i < this.nb_ligne; i ++) {
			list.add(this.getEmbryons(i));
		}
		return list;
	}
	
	public int getId(int index) {
		System.out.println("ligne : " + index);
		String contenuCellule = this.dataSheet.getRow(index).getCell(12).getStringCellValue();
		System.out.println(contenuCellule);
		System.out.println("Réduction + " + reduction(contenuCellule));
		int resultat = Integer.parseInt(reduction(contenuCellule));
		System.out.println( "r: " +resultat);
		return resultat;
	}
	
	public static String reduction(String cellule) {
		String [] parts = cellule.split( "-" );
		String res = parts[0] + parts[1];
		char []a = parts[2].toCharArray();
		int i = 0;
		while(Character.compare(a[i], '0') == 0) {
			i++;
		}
		res = res + parts[2].substring(i);
		return res;
	}
	

	
	public int getNumDossier(int index) {
		String contenuCellule = this.dataSheet.getRow(index).getCell(0).getStringCellValue();
		String res = contenuCellule.split("-")[0];
		int resultat = Integer.parseInt(res);
		return resultat;
	}
	
	public int getNumStim(int index) {
		
		String contenuCellule = this.dataSheet.getRow(index).getCell(1).getStringCellValue();
		String res = contenuCellule.split("-")[0];
		
		int resultat = Integer.parseInt(res);
		return resultat;
	}
	
	public ArrayList<Integer> getDateIntElement(int index) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int e : indiceDate) {
			try {
				list.add((int) this.dataSheet.getRow(index).getCell(e).getNumericCellValue());
			}
			
			catch (java.lang.IllegalStateException f) {
				list.add(0);
			}
			catch (NullPointerException f) {
				
				list.add(null);
			}
		}
		return list;
	}
	
	public ArrayList<Date> transfoDatesType(ArrayList<Integer> list){
		ArrayList<Date> listDates = new ArrayList<Date>();
		for (int i = 0; i < list.size(); i ++) {
			try {
				Date t = DateUtil.getJavaDate((double) list.get(i));
				listDates.add(t);	
			}
			catch (NullPointerException e) {
				listDates.add(null);
			}
		}
		return listDates;
	}
	
	public ArrayList<Integer> getIntElement(int index) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int e : indiceInt) {
			try {
				list.add((int) this.dataSheet.getRow(index).getCell(e).getNumericCellValue());
			}
			catch (NullPointerException f) {
				list.add(null);
			}
		}	
		return list;
	}
	
	public ArrayList<String> getStringElement(int index) {
		ArrayList<String> list = new ArrayList<String>();
		
		for (int e : indiceString) {
			try {
				Cell cell = this.dataSheet.getRow(index).getCell(e);
				if (cell.getCellType() == CellType.STRING)
					list.add(cell.getStringCellValue());
				if (cell.getCellType() == CellType.NUMERIC) {
					int vall = (int) cell.getNumericCellValue();
					
					list.add(Integer.toString(vall));
				}
			}
			catch (NullPointerException f) {
				list.add(null);
			}
		}
		return list;
		
	}
	


	public Embryons getEmbryons(int index) {
		
		ArrayList<Integer> listInt = this.getIntElement(index);
		ArrayList<String> listString = this.getStringElement(index);
		ArrayList<Integer> listDateInt = this.getDateIntElement(index);
		ArrayList<Date> listDates = transfoDatesType(listDateInt);
		
		int id = this.getId(index);
		int numDossier = this.getNumDossier(index);
		int numStim = this.getNumStim(index);
		
		
		Integer nbrEmbryons = listInt.get(0);
		Integer ageDebut = listInt.get(1);
		Integer decisionNbJourObservation = listInt.get(2);
		Integer J2Blastomere = listInt.get(3);
		Integer numStimGrossesse = listInt.get(4);
		Integer nbrEmbryonsGrossesse = listInt.get(5);
		Integer nbrEnfantsNes = listInt.get(6);
		
		Date dateNaissancePatiente = listDates.get(0);
		Date datePonction = listDates.get(1);
		
		String typeAmp = listString.get(0);
		String decision = listString.get(1);
		String J0StdMaturInjection = listString.get(2);
		String J1NbGp = listString.get(3);
		String J1NbPn = listString.get(4);
		String J2TypiqueAtypique = listString.get(5);
		String J2Fragmentation = listString.get(6);
		String J5Blastomere = listString.get(7);
		String J5Blastocyste = listString.get(8);
		String J5Icm = listString.get(9);
		String J5Tropho = listString.get(10);
		String J6Blastomere = listString.get(11);
		String J6Blastocyste = listString.get(12);
		String J6Icm = listString.get(13);
		String J6Tropho = listString.get(14);
		String typeAmpGrossesse = listString.get(15);
		String Grossesse = listString.get(16);
		String technicien1Decoronisation = listString.get(17);
		String J0TypeMicroInjection = listString.get(18);
		String JOTechnicien1 = listString.get(19);
		String techCongTechnicien = listString.get(20);
		
		Embryons result = new Embryons( id,  numDossier,  numStim,  dateNaissancePatiente,  typeAmp, nbrEmbryons, 
				 datePonction,  ageDebut,  decision,  decisionNbJourObservation,  J0StdMaturInjection,  J1NbGp, 
				 J1NbPn,  J2TypiqueAtypique,  J2Blastomere,  J2Fragmentation,  J5Blastomere,  J5Blastocyste, J5Icm,  J5Tropho,  J6Blastomere, 
				 J6Blastocyste,  J6Icm,  J6Tropho, numStimGrossesse,  typeAmpGrossesse,  Grossesse,  nbrEmbryonsGrossesse,  nbrEnfantsNes,
				 technicien1Decoronisation, J0TypeMicroInjection, JOTechnicien1, techCongTechnicien);
		return result;
	}
	
	
}