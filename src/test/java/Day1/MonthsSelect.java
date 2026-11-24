package Day1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonthsSelect {
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

	public WebDriver driver;
	boolean monthFlag = false;
	boolean yearFlag = false;
	boolean dateFlag = false;

	public MonthsSelect(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 
	public void selectMonth(String expectedMonth) {

		if (!expectedMonth.isEmpty()) {
			for (WebElement montha : allMonths) {

				String month = montha.getText().trim();
				if (month.equalsIgnoreCase(expectedMonth)) {
					montha.click();
					
					monthFlag = true;
					break;
				}

			}
		} else {
			System.out.println("Enter Correct Month");
		}

		if (!monthFlag) {
			System.out.println("Your Month is Incorrect");
		}
	}

	public void selectDates(int date) {
		if (date >= 1 && date <= 31) {
			for (WebElement dates : alldates) {
				String datesText = dates.getText().trim(); // retrive dates in string formate

				if (!datesText.isEmpty()) { // check if any dates null or not
					int actualDatesint = Integer.parseInt(datesText); // convert dates in Int
					if (date == actualDatesint) {
						dates.click();
						dateFlag = true;
						break;
					}
				}
			}
		} else {
			System.out.println("Enter correct Date");
		}
		if (!dateFlag) {
			System.out.println("Dates not found or Incorrect dates");
		}
	}

	public void selectYears(int year) {
		monthYearlabel.click(); // Month view → Year view
		monthYearlabel.click(); // Year view → Decade view

		if (year > 0) {
			while (true) {

				String dateRange = monthYearlabel.getText().trim();

				//String[] range = dateRange.split("-");
				String[] range = dateRange.split(" – ");

				int firstYear = Integer.parseInt(range[0].trim());
				int secondYear = Integer.parseInt(range[1].trim());

				if (year >= firstYear && year <= secondYear) {

					for (WebElement yearElement : yearsList) {

						int actualYear = Integer.parseInt(yearElement.getText().trim());

						if (actualYear == year) {
							yearElement.click();
							yearFlag = true;
							break;
						}
					}

					break;

				} else if (year > secondYear) {

					rightArrow.click();

				} else {

					leftArrow.click();
				}
			}
		} else {
			System.out.println("Enter Correct Years");
		}
		if (!yearFlag) {
			System.out.println("Required year not found in the displayed years.");
		}
	}

}
