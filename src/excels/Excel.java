package excels;


import java.io.FileNotFoundException;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	 
	public File file; 
	public FileInputStream excelFile;
	public XSSFWorkbook workbook;
	public Sheet dataSheet;
	public int nb_ligne;

	public Excel (String s){
		
		try {
			file = new File(s);
			excelFile = new FileInputStream(file);
			workbook = new XSSFWorkbook(excelFile);
			dataSheet = workbook.getSheetAt(0);
			nb_ligne = dataSheet.getPhysicalNumberOfRows();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}
	
	public static int checkIdentity(String s) {
		Excel tableau = new Excel(s);
		try {
		String e = tableau.dataSheet.getRow(0).getCell(6).getStringCellValue();
		System.out.println(e);
		if (e.equals("Name")) {
			return 1;
		} else if (e.equals("BMI")) {
			return 2;
		} else if (e.equals("Lieu_de_naissance_de_conjoint")) {
			return 3;
		}else if (e.contentEquals("Heure HCG")) {
			return 4;
		} else {
			return 0;
		}
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	
	
}
