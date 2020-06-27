package utils;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;



	public ExcelUtils(String excelPath, String sheetName) {


		try {
			projectPath= System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName); 

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		
		String projectPath= System.getProperty("user.dir");

		ExcelUtils excel = new ExcelUtils(projectPath+"/excel/data.xlsx", "Sheet1");
		
		excel.getRowCount();
		excel.getColCount();
		excel.getCellDataString(0, 0);
		//excel.getCellDataNumber(1, 1);
	}

	public  int getRowCount() {
		int rowCount=0;

		try {
			
			rowCount=sheet.getPhysicalNumberOfRows(); 
			System.out.println("No of rows: "+rowCount);
		} 
		catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} 

		return rowCount;
		
	}
	
	
	public  int getColCount() {
		
		int colCount=0;

		try {
			
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of columns: "+colCount);
		} 
		catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} 

		return colCount;
	}
	


	public  String getCellDataString(int rowNum, int colNum) {

		String cellData = null;

		try {
			cellData	= sheet.getRow(rowNum).getCell(colNum).getStringCellValue(); 
			//System.out.println(cellData);

		} 
		catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} 

		return cellData;

	}


	public  void getCellDataNumber(int rowNum, int colNum) {


		try {
			double cellData	= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue(); 

			System.out.println(cellData);

		} 
		catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} 


	}


}
