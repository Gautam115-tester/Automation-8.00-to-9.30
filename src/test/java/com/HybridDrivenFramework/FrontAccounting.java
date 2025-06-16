package com.HybridDrivenFramework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.PageObjectModel.RepoOfFrontAccounting;
public class FrontAccounting {
	public static void main(String[] args) throws Exception {
		WebDriver w = null;
		RepoOfFrontAccounting r = null;
		FileInputStream fis = new FileInputStream("C:\\Users\\QST\\Downloads\\HDF.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1; i<=2;i++ ){// test data
			XSSFRow row = sheet.getRow(i);
            XSSFCell rawData = row.getCell(0);
            String arr[] = rawData.toString().split(",");
            String username = arr[0];
            String password = arr[1];
            for(int j = 1; j<=6;j++) { // test Steps 
            	XSSFRow row1 = sheet.getRow(j);
            	XSSFCell testStep = row1.getCell(1);
            	switch (testStep.toString()) {
				case "user launch browser.":
					w = new EdgeDriver();
					Thread.sleep(2000);
					r = new RepoOfFrontAccounting(w);
					break;
				case "user navigate browser to open frontAccounting site.":
					Thread.sleep(2000);
					w.get("https://demo.frontaccounting.eu/");
					break;
				case "user clear username and password field data.":
					Thread.sleep(2000);
					r.clearUsername();
					Thread.sleep(2000);
					r.clearPassword();
					break;
				case "user enter username and password in provided field.":
					Thread.sleep(2000);
					r.enterUsername(username);
					Thread.sleep(2000);
					r.enterPassword(password);
					break;
				case "user click on login button.":
					Thread.sleep(2000);
				r.login();
				break;
				case "validate user has been login or not by check page title.":
					if (w.getTitle().equals("Main Menu")) {
						System.out.println("Test pass for this user "+username);
					} else {
						System.out.println("Test fail for this user "+username);
					}
					Thread.sleep(2000);
					w.quit();
					break;
				default:
					System.out.println("invalid test steps "+testStep);
					break;
				}	
            }
		}
	}

}
