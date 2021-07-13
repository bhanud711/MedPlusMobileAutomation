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

public class ProceedPayment {
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
		cap.setCapability("automationName", "ProceedPayment");
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
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[@id='microCartQty']")).click();
		Thread.sleep(20000);
		driver.findElement(By.id("pharmaCheckOutBtn")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[text()='Proceed with current Locality']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//p[text()='MEDPLUS BALANAGAR HYDERABAD']/parent::address")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[text()=' Proceed ']")).click();
		Thread.sleep(10000);
		WebElement creditcared = driver.findElement(By.xpath("//div[@class='selected-payment']"));
		WebElement pay = driver.findElement(By.xpath("//button[text()='Pay']"));
		Actions a=new Actions(driver);
		a.moveToElement(creditcared).moveToElement(pay).click().build().perform();
		Thread.sleep(20000);
		driver.findElement(By.name("paymode")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//input[@type='tel'])[1]")).sendKeys("4111 1111 1111 1111");
		driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("678");
		driver.findElement(By.xpath("//span[text()='PAY ']")).click();
		
	}

}
