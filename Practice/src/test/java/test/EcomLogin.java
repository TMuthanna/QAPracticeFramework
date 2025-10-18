package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcomLogin {
	@Test
	public void Login() {
		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
		driver.get("https://qa-practice.razvanvancea.ro/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#auth-shop")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("admin@admin.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("#submitLoginBtn")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-primary shop-item-button'])[1]")).click();
		driver.findElement(By.xpath("//button[@onclick='displayCartMessage()']")).click();
		driver.findElement(By.cssSelector("#phone")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@name='street']")).sendKeys("Curchorem Goa");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Sanvordem");
		Select SelectACountry = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		SelectACountry.selectByValue("India");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@id='message']")).getText();

	}

}
