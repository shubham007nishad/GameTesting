package testcases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GameTesting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://now.gg/apps/perfect-world/7724/perfect-world-mobile.html");
		driver.manage().window().maximize();
		//Using Java Script Executor
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.querySelector('[class*=button]').click();");
		WebElement gamecontrol=driver.findElement(By.xpath("//*[@id='sidebar-wrap']/div[2]/div[2]/div[1]"));
		List<WebElement> gamecontrollist=gamecontrol.findElements(By.tagName("li"));
		
		FileOutputStream fos=new FileOutputStream("D:\\GameControl.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sh=wb.createSheet();
		
		
		int i=0;
		for(WebElement gamecontroldata:gamecontrollist) {
			XSSFRow row=sh.createRow(i++);
			row.createCell(0).setCellValue(gamecontroldata.getText());
		}
		wb.write(fos);
		wb.close();
		driver.quit();
		
		

	}

}
