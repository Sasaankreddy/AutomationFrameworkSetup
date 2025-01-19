package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestUtil {
	//why specified long means because The method Duration.ofSeconds() accepts a parameter of type long, not int.
	public static long PAGE_LOAD_TIMEOUT=10;
	public static long IMPLICIT_TIME=5;
	
	@DataProvider(name="testdata")
	public String[][] getData(Method m) throws IOException{
		String path=System.getProperty("user.dir");
		String excelSheetName=m.getName();
		FileInputStream fis=new FileInputStream(path+"\\src\\main\\java\\testdata\\testdata.xlsx"); 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(excelSheetName);
		int totalRows=sheet.getLastRowNum();
		//System.out.println("Total Rows: "+totalRows);
		Row rowCells=sheet.getRow(0);
		int totalColumns=rowCells.getLastCellNum();
		//System.out.println("Total columns: "+totalColumns);
		//In excel data might be boolean, string or any other type so we need to format that data
		DataFormatter format=new DataFormatter();
		String testData[][]=new String[totalRows][totalColumns];
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalColumns;j++) {
				testData[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
				//System.out.println(testData[i-1][j]);
			}
		}
		return testData;
	}
}
