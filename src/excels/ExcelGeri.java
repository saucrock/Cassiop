package excels;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;

import entities.Fiv;
import entities.Geri;







public class ExcelGeri extends Excel {
	
	 

	public ExcelGeri (String s){
		
		super(s);
		

	}
	
	public ArrayList<Geri> getListGeri() {
		ArrayList<Geri> list = new ArrayList<Geri>();
		for (int i = 1; i < this.nb_ligne; i ++) {
			list.add(this.getGeri(i));
		}
		return list;
	}
	
	
	public Geri getGeri(int index) {
		Row ligne = this.dataSheet.getRow(index);
		Integer id;
		Double birthdate;
		Double estimatedDate;
		Integer well;
		Integer timeEstimatedInteger;
		String name;
		
		try {
			id = (int) ligne.getCell(0).getNumericCellValue();
		}
		catch (NullPointerException e) {
			id = null;
		}
		try {
			birthdate = ligne.getCell(1).getNumericCellValue();
		}
		catch (NullPointerException e) {
			birthdate = null;
		}
		try {
			estimatedDate = ligne.getCell(2).getNumericCellValue();
		}
		catch (NullPointerException e) {
			estimatedDate = null;
		}
		try {
			well = (int) ligne.getCell(4).getNumericCellValue();
		}
		catch (NullPointerException e) {
			well = null;
		}
		try {
			timeEstimatedInteger = (int) ligne.getCell(5).getNumericCellValue();
		}
		catch (NullPointerException e) {
			timeEstimatedInteger= null;
		}
		try {
			name = ligne.getCell(6).getStringCellValue();
		}
		catch (NullPointerException e) {
			name = null;
		}
		
		return new Geri(id, birthdate, estimatedDate, well, timeEstimatedInteger, name);		
	}

	
	
	
	

	
	
}
