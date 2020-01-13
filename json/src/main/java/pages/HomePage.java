package pages;

import org.openqa.selenium.By;

import util.BaseClass;

public class HomePage extends BaseClass
{
	By registerlink=By.xpath("//a[text()='REGISTER']");
	
	
	public Registration clickRegisterButton()
	{
		waitForElementToBeClickable(registerlink);
		driver.findElement(registerlink).click();
		return new Registration();
	}
	
	
}
