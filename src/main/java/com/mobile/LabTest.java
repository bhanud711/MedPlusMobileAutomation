package com.mobile;

import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LabTest {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver=new ChromeDriver(options);	
	    DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","Pixel_4a_API_29");
		cap.setCapability("udid", "emulator-5552");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10.0(Q)");
		cap.setCapability("automationName", "LabTest");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("chromedriverExecutable",".//drivers//chromedriver.exe");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("Application Started");
	    driver.get("https://www.medplusmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@title='Lab Tests']")).click();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> i=all.iterator();
		while(i.hasNext())
		{
			String child=i.next();
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
			}
		}
		driver.findElement(By.xpath("//input[@id='testSearchInput']")).sendKeys("Total Thyroxine (TT4)",Keys.ENTER);
		
	}

}
