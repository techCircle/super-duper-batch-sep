package RatthanonUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtilitys {
	
	private static Workbook book;
	private static Sheet sheet;
	private static String filepath;
	
	
	private static void openExcel() {
		try {
			FileInputStream file = new FileInputStream(filepath);
			book = new XSSFWorkbook(file);
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
      private static void loadSheet(String sheetname) {
    	  sheet = book.getSheet(sheetname);
		
	}
      
      private static int rowCount(String sheetname) {
    	  return sheet.getPhysicalNumberOfRows();
  		
  	}
      private static void colsCount(int RowIndex) {
    	
  		
  	}
      private static void cellData(int rowindex, int colindex) {
  		
  	}

}
