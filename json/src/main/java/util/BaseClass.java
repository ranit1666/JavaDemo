package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	
	Workbook wb=null;
	Sheet sheet=null;
	Row row=null;
	List<String>b=new ArrayList<String>();
	
	public BaseClass()
	{
		prop=new Properties();
		File file =new File(System.getProperty("user.dir")+"\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(file);
		    prop.load(fis);
		    } 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void openbrowser(String url)
	{
		String BrowserName=prop.getProperty("browser");
		
	 if(BrowserName.equalsIgnoreCase("chrome"))
	   {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
           driver=new ChromeDriver();		
	   }
		
	else if(BrowserName.equalsIgnoreCase("firefox"))
	   {
		/*System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
           driver=new FirefoxDriver();	*/	
	   }
		
	else if(BrowserName.equalsIgnoreCase("IE"))
	   {
		/*System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
           driver=new InternetExplorerDriver();		*/
	   }
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}
	
	public void waitForElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeClickable(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
	}
	
	public void waitForVisibilityOfElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForVisibilityOfElement(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	}
	
	public String testDate()
	 {
		 Date date=new Date(); 
		// System.out.println(date);
		 Timestamp ts=new Timestamp(date.getTime());
		 SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
		 String strDate = formatter.format(ts);  
		 System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate); 
		 return strDate;
	 }
	
	/*
	public Sheet readExcel(String fileName,String filePath,String sheetName,int startrow,int flag) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File(filePath+fileName));
		String fileExtension=fileName.substring(fileName.indexOf("."));
		if(fileExtension.equalsIgnoreCase(".xlsx"))
		{
			wb=new XSSFWorkbook(fis);
		}
		else if(fileExtension.equalsIgnoreCase(".xls"))
		{
			wb=new HSSFWorkbook(fis);
		}
		
		sheet=wb.getSheet(sheetName);
		//row=sheet.getRow(startrow);
	
			return sheet;
	}
	
	*/
	
	public List<String> readExcel(String fileName,String filePath,String sheetName,int startrow,int endrow) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File(filePath+fileName));
		String fileExtension=fileName.substring(fileName.indexOf("."));
		if(fileExtension.equalsIgnoreCase(".xlsx"))
		{
			wb=new XSSFWorkbook(fis);
		}
		else if(fileExtension.equalsIgnoreCase(".xls"))
		{
			wb=new HSSFWorkbook(fis);
		}
		
		sheet=wb.getSheet(sheetName);
		//
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			row=sheet.getRow(i);
		  for(int cell=0;cell<row.getLastCellNum()-1;cell++)
		  {
			  if(row.getCell(12).toString().equalsIgnoreCase("yes"))
			  {
				 // System.out.println(row.getCell(cell).toString());
				  String a=row.getCell(cell).toString();
				  b.add(a);
			  }
			  
			  else if(row.getCell(12).toString().equalsIgnoreCase("no"))
				{
					break;
				}
		  }
		}
			
		return b;
	
	}
	
	public void method1(String a)
	{
		System.out.println(a);
	}
	
	public void method2(String b)
	{
		System.out.println(b);
	}
	
}
