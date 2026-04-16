package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {

	   public static Object[][] getTestData(String fileName,String sheetName)
 throws IOException {
		// TODO Auto-generated method stub
		   String path = System.getProperty("user.dir")
	                + "/src/test/resources/testdata/testlog.xlsx";

		FileInputStream file=new FileInputStream(path);
		  XSSFWorkbook workbook=new XSSFWorkbook(file);
		  XSSFSheet sheet= workbook.getSheet("Sheet1");
		 int lastrow= sheet.getLastRowNum();
		 int lastcol=sheet.getRow(0).getLastCellNum();
		    Object[][] data = new Object[lastrow][lastcol];
	        DataFormatter formatter = new DataFormatter();


		 for(int i=1; i<=lastrow;i++) {
			 for(int j=0; j<lastcol;j++) {
	         data[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));

			 }
		 }
	        workbook.close();

		return data;
	}

}
