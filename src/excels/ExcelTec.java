package excels;

import java.util.ArrayList;
import entities.Fiv;
import entities.Tec;


public class ExcelTec extends Excel {
	
	int[] indiceEntier = {23, 52, 102, 104}; 
	int[] indiceString = {9, 24, 66, 68, 69, 70, 85, 87, 95, 96};
	int[] indiceDouble = {51, 53};
	int[] indiceDate = {41, 50, 67, 89}; 
	
	
	public ExcelTec (String s){
		
		super(s);
	}
	
	public ArrayList<Tec> getListTec() {
		ArrayList<Tec> list = new ArrayList<Tec>();
		for (int i = 1; i < this.nb_ligne; i ++) {
			list.add(this.getTec(i));
		}
		return list;
	}
	
	public Integer getNumDossier(int index) {
		try {
			String contenuCellule = this.dataSheet.getRow(index).getCell(0).getStringCellValue();
			contenuCellule = contenuCellule.substring(0, 4);
			int resultat = Integer.parseInt(contenuCellule);
			return resultat;
		} catch(NullPointerException f) {
			return null;
		}
	}
	
	public Integer getNumStim(int index) {
		try {
			String contenuCellule = this.dataSheet.getRow(index).getCell(11).getStringCellValue();
			contenuCellule = contenuCellule.substring(0, 5);
			int resultat = Integer.parseInt(contenuCellule);
			return resultat;
		} catch(NullPointerException f) {
			return null;
		}
	}
	
	public ArrayList<Integer> getIntElement(int index) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(this.getNumDossier(index));
		list.add(this.getNumStim(index));
		for (int e : indiceEntier) {
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
				list.add(this.dataSheet.getRow(index).getCell(e).getStringCellValue());
			}
			catch (NullPointerException f) {
				list.add(null);
			}
		}
		
		return list;
		
	}
	
	public ArrayList<Double> getDoubleElement(int index) {
		ArrayList<Double> list = new ArrayList<Double>();
		
		for (int e : indiceDouble) {
			try {
				String s = this.dataSheet.getRow(index).getCell(e).getStringCellValue();
				list.add(Double.parseDouble(s));
			}
			catch (java.lang.IllegalStateException f) {
				list.add((double) 0);
			}
			catch (NullPointerException f) {
				list.add(null);
			}
			catch (java.lang.NumberFormatException f) {
				list.add(null);

			}
		}
		
		return list;
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
	
	public Tec getTec(int index) {
		ArrayList<Integer> listInt = this.getIntElement(index);
		ArrayList<String> listString = this.getStringElement(index);
		ArrayList<Double> listDouble = this.getDoubleElement(index);
		ArrayList<Integer> listDateInt = this.getDateIntElement(index);
		
		
		Tec result = new Tec(listString, listInt, listDouble.get(0), listDouble.get(1), listDateInt);
		return result;
	}


}
