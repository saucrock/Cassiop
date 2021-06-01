import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.poi.hwpf.usermodel.TableAutoformatLookSpecifier;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import com.mysql.jdbc.Statement;

import databases.DataBase;
import databases.DataBaseEmbryons;
import databases.DataBaseFiv;
import databases.DataBaseGeri;
import databases.DataBaseStat;
import databases.DataBaseTec;
import entities.Embryons;
import entities.Fiv;
import entities.Geri;
import entities.Tec;
import excels.ExcelEmbryons;
import excels.ExcelFiv;
import excels.ExcelGeri;
import excels.ExcelTec;
import ihm.Fenetre;



public class Main {

	public static void main(String[] args) {
		//Fenetre uFenetre = new Fenetre();  
		
		
		  DataBase.connexion(); 
		  double[] list = DataBaseStat.getRapport();
		  System.out.println("Salut Martin la ptite quequette");
		  System.out.println("Salut Hugo");
		  
		  
		  DataBase.closeDataBase();
		 

		/*
		 * DataBase.connexion(); ArrayList<Embryons> list
		 * =DataBaseEmbryons.getEmbryons("select * from Embryons;");
		 * System.out.println(list.size()); DataBase.closeDataBase();
		 */
		
		/*
		 * DataBaseEmbryons.connexion(); ExcelEmbryons taEmbryons = new
		 * ExcelEmbryons("/home/hugo/Musique/EMB_MF_janv2019.xlsx"); Embryons embryons =
		 * taEmbryons.getEmbryons(1); System.out.println(embryons.getAgeDebut());
		 * DataBaseEmbryons.insertEmbryons(embryons); DataBaseEmbryons.closeDataBase();
		 */
		 

				
		/*
		 * ExcelFiv taExcelFiv = new ExcelFiv("/home/hugo/Musique/PO_MF_janv2019.xlsx");
		 * System.out.println(taExcelFiv.getNumStim(3));
		 */
					/*
					 * Fiv aFiv = taExcelFiv.getFiv(2);
					 * System.out.println(aFiv.getListIntegers().size());
					 * System.out.println(aFiv.getListDatesStrings().size());
					 * System.out.println(aFiv.getListDoubles().size());
					 * System.out.println(aFiv.getListStrings().size()); System.out.println(aFiv);
					 * DataBase.connexion(); DataBaseFiv.insertFiv(aFiv); DataBase.closeDataBase();
					 */
				 





	}

}
