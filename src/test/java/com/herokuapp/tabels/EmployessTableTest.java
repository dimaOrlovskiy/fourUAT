package com.herokuapp.tabels;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilies.ConfigurationReader;
import com.fourstay.utilies.Driver;

public class EmployessTableTest {
static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		driver=Driver.getInstance();
		driver.get(ConfigurationReader.getProperty("herokuUrl"));
	}


	@Test
	public void test() {
	WebElement webTable1=driver.findElement(By.id("table1"));
	List<WebElement> rows= webTable1.findElements(By.tagName("tr"));
	
	System.out.println("WebTable 1 rows count:"+rows.size());
	
	WebElement webTable2=driver.findElement(By.id("table2"));
	List<WebElement> rows2=webTable2.findElements(By.tagName("tr"));
	
	System.out.println("WebTable 1 rows count:"+rows.size());
	
	List<WebElement> cells=rows.get(0).findElements(By.name("th"));
	System.out.println(cells.get(0).getText());
	WebElement firstCell=driver.findElement(By.xpath("//table[@id='table1']//tr[1]/th[1]"));
	System.out.println(firstCell.getText());
	
	}
	@Test
	public void loopWebTables(){
		WebElement table1=driver.findElement(By.id("table1"));
		List<WebElement> rows=table1.findElements(By.tagName("tr"));
		System.out.println("Number of rows in table 1 "+rows.size());
		
		for(WebElement row : rows){
			//System.out.println(row.getText());
			List<WebElement> cells=row.findElements(By.tagName("td"));
			
			for(WebElement cell : cells){
				System.out.println(cell.getText()+ "|");
			}
			System.out.println();
		}
	}
	@Test
	public void loopTablesXpath(){
		List<WebElement> rowsInTable2=
				driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		System.out.println("Number of rows in Table2:"+ rowsInTable2.size());
		
		for(int rowNum=0; rowNum < rowsInTable2.size(); rowNum++){
			System.out.println(driver.findElement(By.xpath("//table[@id='table2']/tbody/tr["+rowNum+"]")));
			
		}
	}
}
