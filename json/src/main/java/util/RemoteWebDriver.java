package util;

public class RemoteWebDriver implements WebDriver,JavascriptExecutor
{

	public void findElement() 
	{
		System.out.println("This is for findElement");
	}

	public void findElements() 
	{
		System.out.println("This is for findElements");
	}

	public void get() 
	{
		System.out.println("This is get method");
	}

	public void clickElement() 
	{
		System.out.println("This is click method");
	}

	public void executeScript() 
	{
		System.out.println("This is JavascriptExecutor");
	}
	
	

}
