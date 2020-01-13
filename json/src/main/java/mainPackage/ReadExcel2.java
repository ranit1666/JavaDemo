package mainPackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Registration;
import util.BaseClass;

public class ReadExcel2 extends BaseClass
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
		
		List<String>a=readExcel(filename,filepath,sheetName,2,3);
		Iterator<String>allvalues=a.iterator();
		while(allvalues.hasNext())
		{
			System.out.println(allvalues.next());
			method1(a.get(1));
			method2(a.get(2));
		}
		System.out.println("----------");
	
	for(int i=0;i<=a.size();i++)
	{
		method1(a.get(1));
		method2(a.get(2));
	}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
