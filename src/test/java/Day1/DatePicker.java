package Day1;

import org.testng.annotations.Test;

import io.cucumber.java.be.I.Is;

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

public class DatePicker {
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

	@FindBy(css = ".react-calendar__navigation__arrow.react-calendar__navigation__prev-button")
	WebElement leftArrow;

	@FindBy(css = ".react-calendar__navigation__arrow.react-calendar__navigation__next-button")
	WebElement rightArrow;

	@FindBy(css = ".react-calendar__tile.react-calendar__decade-view__years__year")
	List<WebElement> yearsList;

	boolean flag = false;
	boolean yearsFlag = false;

	@Test
	public void selectDatePicker() throws InterruptedException {

		String expectedMonth = "July";
		int year = 2026;
		int date = 30;

		// click on Date Pickr field
		datePickerfield.click();

		// Get Month & years

		String monthsandYear = monthYearlabel.getText();
		String[] monthAndYearStrings = monthsandYear.split(" ");
		String currentMonths = monthAndYearStrings[0].trim();
		int currentYears = Integer.parseInt(monthAndYearStrings[1]); // convert string into years

		if (expectedMonth.equalsIgnoreCase(currentMonths) && year == currentYears) {

			flag = true;

		} else if (!expectedMonth.equalsIgnoreCase(currentMonths) && year == currentYears) {

			monthYearlabel.click();
			for (WebElement montha : allMonths) {

				String month = montha.getText().trim();
				if (month.equalsIgnoreCase(expectedMonth)) {
					montha.click();
					flag = true;
					break;
				}

			}

		} else if (expectedMonth.equalsIgnoreCase(currentMonths) && year != currentYears) {
			monthYearlabel.click();
			monthYearlabel.click();

			while (true) {
				String dateranges = monthYearlabel.getText();
				String[] dateRangeString = dateranges.split("-");
				int yearFirst = Integer.parseInt(dateRangeString[0].trim());
				int yearSecond = Integer.parseInt(dateRangeString[1].trim());

				if (year > yearFirst && year < yearSecond) {
					for (WebElement years : yearsList) {
						String yearString = years.getText().trim(); // retrive years in string formate

						if (!yearsList.isEmpty()) { // check if any years null or not
							int actualYears = Integer.parseInt(yearString); // convert dates in Int
							if (year == actualYears) {
								years.click();
								flag = true;
								break;
							}
						}
					}

				} else if (year > yearSecond) {
					rightArrow.click();
				} else if (year < yearFirst) {

					leftArrow.click();
				}
			}

		}

		// Select All Dates
		if (flag) {

			for (WebElement dates : alldates) {
				String datesText = dates.getText().trim(); // retrive dates in string formate

				if (!datesText.isEmpty()) { // check if any dates null or not
					int actualDatesint = Integer.parseInt(datesText); // convert dates in Int
					if (date == actualDatesint) {
						dates.click();
						break;
					}
				}
			}
		} else {
			System.out.println("Months or Years do not match");
		}
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
