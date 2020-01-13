package mainPackage;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Registration;
import util.BaseClass;

public class ReadExcel extends BaseClass
{
	String filename="fillo.xlsx";
	String filepath="E:\\Workspace\\json\\";
	String sheetName="Sheet1";
	Row row=null;
	Sheet sheet=null;
	HomePage home;
	Registration regobj;
	
	@Test
	public void read() throws IOException
	{
		home=new HomePage();
   	    openbrowser(prop.getProperty("url"));
   	    sheet=readExcel(filename,filepath,sheetName,1,4);
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			row=sheet.getRow(i);
			System.out.println(row.getCell(i).toString());
			regobj=home.clickRegisterButton();
			regobj.fillContactInfo(row.getCell(0).toString(), row.getCell(1).toString(),row.getCell(2).toString() ,row.getCell(3).toString());
   	     regobj.mailingInfo(row.getCell(4).toString(), row.getCell(5).toString(),row.getCell(6).toString() ,row.getCell(7).toString(),row.getCell(8).toString());
   	     regobj.userInfo(row.getCell(9).toString(), row.getCell(10).toString(),row.getCell(11).toString());
   	     String actualtext=regobj.successfulRegistration();	 
   	 if (actualtext.contains(row.getCell(9).toString()))
   	   {
   		 Assert.assertTrue(true);
   	   }
   	 
   	 else
   	 {
   		 Assert.assertTrue(false); 
   	 }
		}
		
	}
     
	
}
