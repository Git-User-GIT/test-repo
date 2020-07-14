package test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

class sample {
	WebDriver driver;
	
	 @BeforeTest()
	 public void launchchrome() {
			System.out.print(System.setProperty("webdriver.chrome.driver", "/home/shiksha/chromedriver"));

			driver = new ChromeDriver();
			System.out.println ("Before Method ---");
	 }


	@Test(dataProvider="getd")
	void launchbrowser(String s) {
	
		driver.get("https://www.google.com/");
		WebElement e=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
			//	Actions action = new Actions(driver);
		//action.moveToElement(e);
		//e.click();
		//e.clear();
		e.sendKeys(s);
		System.out.println ("Test2 Method ---");
	}
	@Test(invocationCount=2)
	public void youtubeOpen() throws IOException {
		driver.get("https://www.youtube.com/");
		takesnapShot("youtube_test");
		//driver.findElement(By.id("search")).sendKeys("Welcome");
		System.out.println ("Test2 Method ---");	
	}
	
	@AfterTest()
		public void quitDriver() {
			driver.quit();
			System.out.println ("After Method ---");
			
		}
	
	
	@DataProvider(name="getd")
	
	 public static Object[] getDataFromDataprovider(){
	 Object [] data= new Object[1];
	 data [0]="guru99";
	//data [1]="Krishna";
	//data [2]="Lord";
	 return data;
	}
	 public void takesnapShot(String filename) throws IOException {
		//convert driver into takescreenshot interface  type cast webdrive
	 	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 	System.out.println (file);
	 	
	 	//copy screenshot to desire location using copy file method
	 FileUtils.copyFile(file ,new File("/home/shiksha/eclipse-workspace/test/"+filename+".png"));
	 
	 
	 
	 }}