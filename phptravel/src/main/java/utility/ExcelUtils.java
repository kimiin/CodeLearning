package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFWorkbook book;
	private static XSSFSheet dataSheet;
	private static XSSFCell cell;	 
	private static XSSFRow row;
	private static String path;
		
	public static void openTestData(String pathFile, String sheetName) {
		
		try{
			FileInputStream inputStream = new FileInputStream(new File(pathFile)); 
			book = (XSSFWorkbook) WorkbookFactory.create(inputStream);			
			dataSheet=book.getSheet(sheetName);    
			path=pathFile;
		}
		catch(IOException | EncryptedDocumentException e) {
	         //TestLog.error("The file "+path+" cannot be found.");
		} 
		catch (InvalidFormatException e1) {
			//TestLog.error("The file "+path+" is an invalid format.");
			e1.printStackTrace();
		}
	}
	
	public static String getCelData(int iRow, int iCol) {
		String cellData=dataSheet.getRow(iRow).getCell(iCol).getStringCellValue();
		//System.out.println(cellData);
		return cellData;
	}
	
	public static void setCellData(String result, int iRow, int iCol) {
		try {
			 FileOutputStream out;
							
			 dataSheet=book.getSheet(Constant.SHEETNAME);    
			 
			 row= dataSheet.getRow(iRow);	
			 cell = row.getCell(iCol, dataSheet.getWorkbook().getMissingCellPolicy());
			 if (cell == null) {
				 cell = row.createCell(iCol);
				 cell.setCellValue(result);
			 }		
			 else 
				 cell.setCellValue(result);	
			 
			 out = new FileOutputStream(path);
             book.write(out);
             book.close();
			
	         out.close();  
		}
		catch(IOException | EncryptedDocumentException e) {
			 //TestLog.error("The file "+Constant.PATH_TESTDATA+Constant.FILE_TESTDATA+" cannot be found.");
		} 
	 			
	}
}
