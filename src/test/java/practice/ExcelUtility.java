package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class ExcelUtility {
	 public static Object[][] getExcelData(String filePath, String sheetName) {
	        Object[][] data = null;
	        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
	            Workbook workbook = WorkbookFactory.create(fis);
	            Sheet sheet = workbook.getSheet(sheetName);
	            
	            int rowCount = sheet.getLastRowNum(); // assuming first row is header
	            int cellCount = sheet.getRow(0).getLastCellNum();
	            data = new Object[rowCount][cellCount];
	            
	            // Loop starts from 1 to skip header row
	            for (int i = 1; i <= rowCount; i++) {
	                Row row = sheet.getRow(i);
	                for (int j = 0; j < cellCount; j++) {
	                    Cell cell = row.getCell(j);
	                    // Convert cell value to String (customize based on your data type)
	                    data[i - 1][j] = cell.toString();
	                }
	            }
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return data;
	    }
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
