package com.mobile;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.medicine.Screenshot;
import com.relevantcodes.extentreports.LogStatus;

public class PurchaseHistory {
public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
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
		cap.setCapability("automationName", "PurchaseHistory");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("chromedriverExecutable",".//drivers//chromedriver.exe");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("Application Started"); 
		driver.get("https://www.medplusmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In/Register']"));
		signIn.click();
		Thread.sleep(10000);
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("arora3330@gmail.com");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		passWord.sendKeys("Kanika24");
		WebElement button = driver.findElement(By.xpath("//button[@id='popupLoginButton']"));
		button.click();
		Thread.sleep(10000);
		WebElement accountMgt=driver.findElement(By.xpath("//span[@class='caret']"));
		Actions a=new Actions(driver);
		a.moveToElement(accountMgt).click().build().perform();
		WebElement account = driver.findElement(By.xpath("//span[@class='caret']/following::ul/li/a/img[1]"));
		a.moveToElement(account).click().build().perform();
		driver.findElement(By.xpath("//p[text()='Purchase History']")).click();
	}

}
