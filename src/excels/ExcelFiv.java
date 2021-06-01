package excels;

import java.util.ArrayList;
import entities.Fiv;



public class ExcelFiv extends Excel {
	
	int[] indiceEntier = {3, 15, 16, 17, 93, 94, 212, 214, 217, 231, 233, 234, 238, 239, 240, 243, 268, 270}; 
	int[] indiceString = {11,12, 14, 82, 83, 84, 85, 86, 88, 89, 95, 201, 202, 208, 209, 211, 235, 246, 249, 261, 265};
	int[] indiceDouble = {6,9 ,190, 195};
	int[] indiceDate = {77, 78, 81, 134, 199, 250}; 
	
	
	public ExcelFiv (String s){
		
		super(s);
	}
	
	public ArrayList<Fiv> getListFiv() {
		ArrayList<Fiv> list = new ArrayList<Fiv>();
		for (int i = 1; i < this.nb_ligne; i ++) {
			list.add(this.getFiv(i));
		}
		return list;
	}
	
	public int getNumDossier(int index) {
		String contenuCellule = this.dataSheet.getRow(index).getCell(0).getStringCellValue();
		String res = contenuCellule.split("-")[0];
		int resultat = Integer.parseInt(res);
		return resultat;
	}
	
	public int getNumStim(int index) {
		System.out.println(nb_ligne);
		String contenuCellule = this.dataSheet.getRow(index).getCell(13).getStringCellValue();
		String res = contenuCellule.split("-")[0];
		
		int resultat = Integer.parseInt(res);
		return resultat;
	}
	
	public ArrayList<Integer> getIntElement(int index) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(this.getNumStim(index));
		list.add(this.getNumDossier(index));
		
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
	
	public Fiv getFiv(int index) {
		ArrayList<Integer> listInt = this.getIntElement(index);
		ArrayList<String> listString = this.getStringElement(index);
		ArrayList<Double> listDouble = this.getDoubleElement(index);
		ArrayList<Integer> listDateInt = this.getDateIntElement(index);
		int numDossier = listInt.get(0);
		int numStim = listInt.get(1);
		
		Fiv result = new Fiv(numDossier, numStim, listString, listInt, listDouble, listDateInt);
		return result;
	}


}
