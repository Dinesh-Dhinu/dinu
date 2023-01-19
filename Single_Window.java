package com.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Single_Window {
public static void main(String[] args) throws AWTException {
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	
	WebElement mobile = driver.findElement(By.xpath("//a[text()=\"Mobiles\"]"));
	
	Actions a=new Actions(driver);
	a.contextClick(mobile).build().perform();
	
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	String tab = driver.getWindowHandle(); //online
	
	Set<String> alltab = driver.getWindowHandles();  //online/mobiles.
	
	for (String id : alltab) {
		
		if (id.equals(tab)) {
			
			continue;
			
		} else {
			driver.switchTo().window(id);
		}
	}
		
}
}
