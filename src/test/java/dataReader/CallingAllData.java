package dataReader;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class CallingAllData {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream  //here i want to read an file 
				("C:\\Users\\QST\\Downloads\\Jmeter DataDriven file.xlsx");  // in here we provide location of the file
		XSSFWorkbook work = new XSSFWorkbook(fis);  // xlsx work ek new copy work (file read) fis 
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1;i<=4;i++) {
			XSSFRow row = sheet.getRow(i); // 1 , 2 , 3 , 4
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			System.out.println(username);
			System.out.println(password);
			System.out.println("-----------------------");		
		}	
	}
}