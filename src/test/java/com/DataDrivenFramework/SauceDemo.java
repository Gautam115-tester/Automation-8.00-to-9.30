package com.DataDrivenFramework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class SauceDemo {
	public static void main(String[] args) throws Exception {
		WebDriver w = new EdgeDriver();
		w.get("https://www.saucedemo.com/");
		FileInputStream fis = new FileInputStream("C:\\Users\\QST\\Downloads\\saucerDemo.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1; i <= sheet.getLastRowNum();i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			w.findElement(By.id("user-name")).sendKeys(username.toString());
			Thread.sleep(2000);
			w.findElement(By.id("password")).sendKeys(password.toString());
			Thread.sleep(2000);
			w.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			Thread.sleep(2000);
			try {
				w.findElement(By.id("react-burger-menu-btn")).click();
				Thread.sleep(2000);
				w.findElement(By.linkText("Logout")).click();
			} catch (Exception e) {
				w.navigate().refresh();
			}
			
		}
	}
}
