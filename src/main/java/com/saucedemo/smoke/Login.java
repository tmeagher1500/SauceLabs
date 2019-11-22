package com.saucedemo.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	String url="https://www.saucedemo.com/";
	
	@Test
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.get(url);
	}

}
