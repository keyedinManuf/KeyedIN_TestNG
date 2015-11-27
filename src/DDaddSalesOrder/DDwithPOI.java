package DDaddSalesOrder;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.*;

public class DDwithPOI {
	private static XSSFRow Row;
	private static XSSFCell Cell;
	private static XSSFSheet gsheet;
	private static XSSFWorkbook ExcelWbook;
	
	public static void SetExcelPath(String path, String Sheetname) throws Exception{
		try{
			FileInputStream input = new FileInputStream(path);
			ExcelWbook = new XSSFWorkbook(input);
			gsheet= ExcelWbook.getSheet(Sheetname);
			
		} catch(Exception e){
			throw e;
		}
	}
	public static String GetExcelData(int Rownum, int Colnum) throws Exception{
		try{
			Cell=gsheet.getRow(Rownum).getCell(Colnum);
			String Cellvalue = Cell.getStringCellValue();
			return Cellvalue;
		}catch(Exception e){
			return "";
		}
	}
	
	public static void WriteExceldata(String result, int Rownum, int Colnum) throws Exception{
		try{
			Row= gsheet.getRow(Rownum);
			Cell=Row.getCell(Colnum,Row.RETURN_BLANK_AS_NULL);
			if(Cell==null){
				Cell=Row.createCell(Colnum);
				Cell.setCellValue(result);
			} else {
				Cell.setCellValue(result);
			}
		FileOutputStream out = new FileOutputStream("C:\\Users\\sakthivel\\Documents\\testdata\\Datadriven.xlsx");
		ExcelWbook.write(out);
		out.flush();
		out.close();
			
		}catch(Exception e){
			throw e;
		}
	}
	
}
