package ExcelLessons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.Constants;

public class readExcelTest {

	public static void main(String[] args) throws IOException {

		DataFormatter objectFormat = new DataFormatter();

		FileInputStream fs = new FileInputStream(Constants.excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

//		Row row = sheet.getRow(2);
//		Cell cell = row.getCell(0);
//		
//		System.out.println(sheet.getRow(2).getCell(0));
//		System.out.println(cell);

		//// automate read all

		for (Row row : sheet) {

			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.println(cell.getRichStringCellValue());
					break;
				case FORMULA:
		        	System.out.println(cell.getNumericCellValue());
		        	break;

				}
				System.out.println(" ");

			}

			workbook.close();

		}

	}
}
