package com.viji;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practise02 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption3")).click();
		String checkedBoxButton = driver.findElement(By.id("checkBoxOption3")).getAttribute("value");
		System.out.println(checkedBoxButton);

		WebElement dropDownLocation = driver.findElement(By.id("dropdown-class-example"));
		dropDownLocation.click();

		Select s = new Select(dropDownLocation);
		s.selectByValue(checkedBoxButton);

		driver.findElement(By.id("name")).sendKeys(checkedBoxButton);
		driver.findElement(By.id("alertbtn")).click();
		String alertText =driver.switchTo().alert().getText();
		if(alertText.contains(checkedBoxButton)) {
			System.out.println("Alert Message success");
			
		}
		else
		{
			System.out.println("Something went wrong");
		}
		

	}

}
