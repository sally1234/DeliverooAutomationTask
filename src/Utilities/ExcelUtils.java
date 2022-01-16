package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.CellType;

//import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//This class contains the Excel functions that is used in the project
public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell cell;

	private static FormulaEvaluator evaluator;

	public static Object[][] getTableArray(String FilePath, String SheetName, int columnCount) throws Exception {

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();

			int startRow = 1;

			int startCol = 0;

			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();

			// you can write a function as well to get Column count

			int totalCols = columnCount;

			tabArray = new String[totalRows][totalCols];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;

				for (int j = startCol; j < totalCols; j++, cj++) {

					tabArray[ci][cj] = getcellData(i, j);

					System.out.println(tabArray[ci][cj]);

				}

			}

		}

		catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (tabArray);

	}

	public static String getcellData(int RowNum, int ColNum) throws Exception {

		try {

			cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			int dataType = cell.getCellType();

			if (dataType == 3)

				return "";

			else {

				cell.setCellType(CellType.STRING);
				String cellData = cell.getStringCellValue();

				return cellData;
			}

			/*
			 * String cellData; if (cell != null) { switch
			 * (evaluator.evaluateInCell(cell).getCellTypeEnum()) {
			 * 
			 * case STRING: cellData = String.valueOf(cell.getStringCellValue()); return
			 * cellData; case NUMERIC: if (DateUtil.isCellDateFormatted(cell)) { cellData =
			 * String.valueOf(cell.getDateCellValue()); } else { cellData =
			 * String.valueOf(cell.getNumericCellValue()); } return cellData; case BOOLEAN:
			 * cellData = String.valueOf(cell.getBooleanCellValue()); return cellData; /*
			 * case Cell.cell_TYPE_FORMULA: return String.valueOf(cell.getCellFormula());
			 * break;
			 * 
			 * 
			 * default: return ""; } }return"";
			 */

		} catch (

		Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}
}
