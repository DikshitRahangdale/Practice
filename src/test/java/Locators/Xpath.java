package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Xpath {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement dropdowns = driver.findElement(By.xpath("//select[@id='country']"));

		Select country = new Select(dropdowns);
		country.selectByValue("india");

		WebElement colourdropropdowns = driver.findElement(By.xpath("//*[@id='colors']"));

		Select color = new Select(colourdropropdowns);
		color.selectByIndex(0);

		WebElement animaldropdowns = driver.findElement(By.xpath("//*[@id='animals'][@name='animals']"));

		Select animals = new Select(animaldropdowns);
		animals.selectByIndex(1);
		System.out.println(animals.getFirstSelectedOption().getText());

		// and operator

		driver.findElement(By.xpath("//input[@id='datepicker' and  @class='hasDatepicker']")).sendKeys("12/05/2026");

		// or Operator

		driver.findElement(By.xpath("//input[@id='txtDate' or @name='SelectedDate']")).click();

		// text() method

		driver.findElement(By.xpath("//*[text()='Name:']")).click();

		driver.close();

	}

}
