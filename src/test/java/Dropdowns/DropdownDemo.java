package Dropdowns;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DropdownDemo {
	WebDriver driver;

	@Test
	public void demo() {

		WebElement dropdownfield = driver.findElement(By.id("fruits"));

		Select fruits = new Select(dropdownfield);

		List<WebElement> allfruitsElements = fruits.getOptions();

		System.out.println("Total Fruits Options: " + allfruitsElements.size());

		for (WebElement fr : allfruitsElements) {
			System.out.println(fr.getText());
		}

		fruits.selectByIndex(1);
		System.out.println("First Selected options: " + fruits.getFirstSelectedOption().getText());

		// Second Dropdowns

		WebElement seconddropdowns = driver.findElement(By.id("superheros"));

		Select heroeSelect = new Select(seconddropdowns);

		List<WebElement> allheroes = heroeSelect.getOptions();
		System.out.println("All heroes: " + allheroes.size());

		for (WebElement hero : allheroes) {
			System.out.println(hero.getText());
		}

		// Check is itmulti select dropdowns
         System.out.println("Multiselect: " + heroeSelect.isMultiple());
		
		// select by value

		heroeSelect.selectByValue("im");

		// Select By index
		heroeSelect.selectByIndex(3);

		// Select By visible text
		heroeSelect.selectByVisibleText("Superman");
		
		//get All selected options
		
		List<WebElement> allselected=heroeSelect.getAllSelectedOptions();
		
		for(WebElement all:allheroes)
		{
			System.out.println(all.getText());
		}

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/dropdowns");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
