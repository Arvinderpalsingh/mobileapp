package Naukri_mav.Naukri_Mav_Testng;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class naukri_test {
	
	WebDriver d = new ChromeDriver();
	
	@Test (priority =1)
  public void open() {
	  
	  	d.get("https://www.google.com/");
		
		d.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("Naukri.com");
		d.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys(Keys.ENTER);
		
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		d.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3")).click();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  
  }
  
  
	@Test (priority =2)
  public void loginnaukri() {
	  
		d.findElement(By.xpath("//*[@id=\"block\"]")).click(); //to click location pop up setting to later
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		Set<String> wins=	d.getWindowHandles();  //return list of windows
		System.out.println(wins.size());
		String basewind="";
		for(String win : wins ) //: iterator 
		{
		  	d.switchTo().window(win);
		  	String title  = d.getTitle();
		  	System.out.println(title);
		  	
		 	if (title.startsWith("Job"))
		  	{
		 		basewind = win;
		  	}
		  	else 
		  		d.close();
		}
		d.switchTo().window(basewind);
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	  d.findElement(By.linkText("LOGIN")).click();
	  
		//d.findElement(By.xpath("//*[@id=\"login_Layer\"]/div")).click();
		//d.findElement(By.cssSelector("#login_Layer > div")).click();
		
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.findElement(By.xpath("//*[@id=\"eLoginNew\"]")).sendKeys("sethi.arvinderpal@gmail.com");
		d.findElement(By.xpath("//*[@id=\"pLogin\"]")).sendKeys("Welcome@987");
		d.findElement(By.xpath("//*[@id=\"lgnFrmNew\"]/div[9]/button")).click();
				
  }
  
		
	@Test (priority =3) 
		public void editpref() {
		
			WebElement el = d.findElement(By.xpath("/html/body/div[1]/div/div/ul[2]/li[2]/a/div[2]"));
		
		    Actions act =new Actions(d);
		    act.moveToElement(el).build().perform();
		    
		    d.findElement(By.linkText("Recommended Jobs")).click();
		    d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		    //d.findElement(By.xpath("/html/body/div[2]/div/ul[2]/li[2]/div/ul[1]/li[2]/a")).click();
		    //d.findElement(By.cssSelector("#root > div > div > span > div > div > div > div > div.wrapper > div > div.row > div.col.s4.pr0 > div:nth-child(1) > div > div")).click();
		
			}
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
