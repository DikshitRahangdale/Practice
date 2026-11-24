package Day1;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class DatePicker2 {
	WebDriverWait wait;
	WebDriver driver;

	@FindBy(css = "div.react-date-picker__inputGroup")
	WebElement datePickerfield;

	@FindBy(css = ".react-calendar__navigation__label")
	WebElement monthYearlabel;

	@FindBy(xpath = "//*[contains(@class,'react-calendar__tile')     and contains(@class,'react-calendar__month-view__days__day')     and not(contains(@class,'neighboringMonth'))]")
	List<WebElement> alldates;

	@FindBy(css = ".react-calendar__year-view__months button")
	List<WebElement> allMonths;

	@FindBy(xpath = "//*[@name='month']")
	WebElement realMonth;

	@FindBy(css = "input[name='day']")
	WebElement realDate;

	@FindBy(css = "input[name='year']")
	WebElement realYears;

	@Test
	public void selectDatePicker() throws InterruptedException {

		String expectedMonth = "November";
		int year = 2025;
		int date = 30;

		MonthsSelect monthss = new MonthsSelect(driver);

		// click on Date Pickr field
		datePickerfield.click();

		// Get Month & years

		String monthsandYear = monthYearlabel.getText();
		String[] monthAndYearStrings = monthsandYear.split(" ");
		String currentMonths = monthAndYearStrings[0].trim();
		int currentYears = Integer.parseInt(monthAndYearStrings[1]); // convert string into years

		if (expectedMonth.equalsIgnoreCase(currentMonths) && year == currentYears) {

			monthss.selectDates(date);
		} else if (!expectedMonth.equalsIgnoreCase(currentMonths) && year == currentYears) {
			monthYearlabel.click();
			monthss.selectMonth(expectedMonth);
			monthss.selectDates(date);

		} else if (expectedMonth.equalsIgnoreCase(currentMonths) && year != currentYears
				|| !expectedMonth.equalsIgnoreCase(currentMonths) && year != currentYears) {
			monthss.selectYears(year);
			monthss.selectMonth(expectedMonth);
			monthss.selectDates(date);

		} else {
			System.out.println("Your Month & Year is Incorrect");
		}
		
		System.out.println("Selected Dates:->");

		System.out.println("Dates:->" + realDate.getAttribute("value") + "/" + realMonth.getAttribute("value") + "/"
				+ realYears.getAttribute("value"));

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
