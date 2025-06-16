package com.KeywordDrivenFramework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.PageObjectModel.RepoOfFrontAccountingWithPageFactory;
public class FrontAccounting {
	public static void main(String[] args) throws Exception {
		WebDriver w = new EdgeDriver();
		RepoOfFrontAccountingWithPageFactory r = new RepoOfFrontAccountingWithPageFactory(w);
		FileInputStream fis = new FileInputStream("C:\\Users\\QST\\Downloads\\FrontAccounting Test Step Data.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1; i <=sheet.getLastRowNum();i++) {
			XSSFRow row = sheet.getRow(i);
			String testStep = row.getCell(0).toString();
			switch (testStep) {
			case "User should navigate to frontAccounting site":
				w.get("https://demo.frontaccounting.eu/");
				break;
			case "User should clear username and password field data.":
				Thread.sleep(2000);
				r.clearUsername();
				Thread.sleep(2000);
				r.clearPassword();
				Thread.sleep(2000);
				break;
			case "User should enter new data in Username and password field.":
				r.enterUsername("demouser");
				Thread.sleep(2000);
				r.enterPassword("password");
				Thread.sleep(2000);
				break;
			case "User click on login button.":
				Thread.sleep(2000);
				r.login();
				break;
			case "User click on Logout Button.":
				Thread.sleep(2000);
				r.logout();
				break;
			default:
				System.out.println("invalid step doesn't match with any case value : "+testStep);
				break;
			}	
		}
	}
}