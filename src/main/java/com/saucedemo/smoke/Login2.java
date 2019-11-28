package com.saucedemo.smoke;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

/**
 * Added this comment
 * @author TMeagher
 *
 */

public class Login2 {
	
	WebDriver driver;
	String url="https://www.saucedemo.com/";
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Landing page title:" + driver.getTitle());
		String title = driver.getTitle();
		Assert.assertEquals("Swag Labs", title);
	}
	
	@Test
	public void Login() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.getTitle());
		String title2 = driver.getTitle();
		Assert.assertEquals("Swag Labs", title2);
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
