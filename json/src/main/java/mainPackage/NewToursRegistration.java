package mainPackage;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import pages.HomePage;
import pages.Registration;
import util.BaseClass;

public class NewToursRegistration extends BaseClass
{
	HomePage home;
	Registration regobj;
	
     @Test
	public void OpenWeb() throws FilloException
	{
    	 home=new HomePage();
    	 openbrowser(prop.getProperty("url"));	
    	 Fillo fillo=new Fillo();
    	 Connection connection=fillo.getConnection(System.getProperty("user.dir")+"\\fillo.xlsx");
    	 String strQuery="Select * from Sheet1";
    	 //String strQuery="Select * from Sheet1 where fname='george'";
    	 Recordset recordset=connection.executeQuery(strQuery);
    	 while(recordset.next()){
    		 System.out.println(recordset.getField("fname"));
    		 regobj=home.clickRegisterButton();
    		 regobj.fillContactInfo(recordset.getField("fname"), recordset.getField("lname"),recordset.getField("phone") ,recordset.getField("email"));
    	     regobj.mailingInfo(recordset.getField("address"), recordset.getField("city"),recordset.getField("state") ,recordset.getField("postal"),recordset.getField("country"));
    	     regobj.userInfo(recordset.getField("username"), recordset.getField("password"),recordset.getField("confirmpassword"));
    	     String actualtext=regobj.successfulRegistration();	 
    	 if (actualtext.contains(recordset.getField("username")))
    	   {
    		 Assert.assertTrue(true);
    	   }
    	 
    	 else
    	 {
    		 Assert.assertTrue(false); 
    	 }
    	 
    	                         }
    	 /*regobj=home.clickRegisterButton();
    	 regobj.fillContactInfo(prop.getProperty("fname"), prop.getProperty("lname"),prop.getProperty("phone") ,prop.getProperty("email"));
	     regobj.mailingInfo(prop.getProperty("address"), prop.getProperty("city"),prop.getProperty("state") ,prop.getProperty("postal"),prop.getProperty("country"));
	     regobj.userInfo(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("confirmpassword"));
	*/
	
    	 recordset.close();
    	 connection.close();
	
	
	}
	
	
	
	
	
	
	
}
