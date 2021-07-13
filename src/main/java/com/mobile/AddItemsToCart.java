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

public class AddItemsToCart {
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
		cap.setCapability("automationName", "AddItemToCart");
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
		WebElement store = driver.findElement(By.xpath("(//a[text()='Health Store'])[2]"));
		WebElement otcHealth=driver.findElement(By.xpath("//a[@title='OTC & Health Needs']"));
		WebElement bpWeight = driver.findElement(By.xpath("//a[@title='BP & Weight Monitoring']"));
		Actions a=new Actions(driver);
		a.moveToElement(store).moveToElement(otcHealth).moveToElement(bpWeight).click().perform();
		WebElement item1 = driver.findElement(By.xpath("//div[@id='addMoreProducts']/div[1]"));
		a.moveToElement(item1).build().perform();
		WebElement addToCart = driver.findElement(By.xpath("(//button[text()='Add to Cart'])[2]"));
		a.moveToElement(addToCart).click().build().perform();
		
	}

}
