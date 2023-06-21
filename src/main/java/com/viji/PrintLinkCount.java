package com.viji;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintLinkCount {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//      Give me the link of the number of links in the page
		System.out.println(driver.findElements(By.tagName("a")).size());

//		Get the number of links in the grey section[Using General Method]
//		System.out.println(driver.findElements(By.cssSelector("div[class='footer_top_agile_w3ls gffoot footer_style'] table tr td ul li a")).size());

//		Creating scope for the driver - Grey Region
		WebElement greyRegion = driver.findElement(By.id("gf-BIG"));
		System.out.println(greyRegion.findElements(By.tagName("a")).size());

//		Getting the <a> tags from the column 1 in the grey region
		WebElement column01Scope = greyRegion.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(column01Scope.findElements(By.tagName("a")).size());
		List<WebElement> column01Links = column01Scope.findElements(By.tagName("a"));
//		Click each link and check if the pages are opening
//		column01Scope.click();

		for (int i = 0; i < column01Links.size(); i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			column01Links.get(i).sendKeys(clickOnLink);
			Thread.sleep(5000L);
		} // opens all the tabs
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());

		Iterator<String> it = allWindows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}
}
