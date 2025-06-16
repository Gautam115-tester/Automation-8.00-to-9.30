package com.DataDrivenFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartItemSearch {
	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		w.get("https://www.flipkart.com/");
		FileInputStream fis = new FileInputStream("C:\\Users\\QST\\Downloads\\filkart search item.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1; i <= sheet.getLastRowNum();i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell search = row.getCell(0);
			w.findElement(By.name("q")).sendKeys(search.toString(),Keys.ENTER);
			Thread.sleep(2000);
			w.findElement(By.name("q")).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		}
	}
}
