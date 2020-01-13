package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import util.BaseClass;

public class Registration extends BaseClass
{

	By fname=By.xpath("//input[@name='firstName']");
	By lname=By.xpath("//input[@name='lastName']");
	By phone=By.xpath("//input[@name='phone']");
	By email=By.xpath("//input[@name='userName']");
	By address=By.xpath("//input[@name='address1']");
	By city=By.xpath("//input[@name='city']");
	By state=By.xpath("//input[@name='state']");
	By postal=By.xpath("//input[@name='postalCode']");
	By country=By.xpath("//select[@name='country']");
	By username=By.xpath("//input[@name='email']");
	By password=By.xpath("//input[@name='password']");
	By confirmpassword=By.xpath("//input[@name='confirmPassword']");
	By submit=By.xpath("//input[@name='register']");
	By verifyusername=By.xpath("//b[contains(text(),'Your user name is')]");
	
	public void fillContactInfo(String fname1,String lname1,String phone1,String email1)
	{
		waitForElementToBeClickable(driver.findElement(fname));
		driver.findElement(fname).sendKeys(fname1);
		driver.findElement(lname).sendKeys(lname1);
		driver.findElement(phone).sendKeys(phone1);
		//String emails=testDate();
		driver.findElement(email).sendKeys(fname1+testDate()+"@yopmail.com");
		System.out.println(fname1+testDate()+"@yopmail.com");
	}
	
	public void mailingInfo(String address1,String city1,String state1,String postal1,String country1)
	{
		waitForElementToBeClickable(driver.findElement(address));
		driver.findElement(address).sendKeys(address1);
		driver.findElement(city).sendKeys(city1);
		driver.findElement(state).sendKeys(state1);
		driver.findElement(postal).sendKeys(postal1);
		Select slct=new Select(driver.findElement(country));
		slct.selectByVisibleText(country1);
	}
	
	public void userInfo(String username1,String password1,String confirmpassword1)
	{
		driver.findElement(username).sendKeys(username1);
		driver.findElement(password).sendKeys(password1);
		driver.findElement(confirmpassword).sendKeys(confirmpassword1);
		driver.findElement(submit).click();
	}
	
	public String successfulRegistration()
	{
		String actualText=driver.findElement(verifyusername).getText();
		return actualText;
	}
	
	
	
}
