package GreenKart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(css = ".brand.greenLogo")
	WebElement logoElement;

	@FindBy(css = "input.search-keyword")
	WebElement searchInput;

	@FindBy(css = "button.search-button[type='submit']")
	WebElement searchIcon;

	@FindBy(css = "h4.product-name")
	List<WebElement> productNames;

	@FindBy(css = ".increment")
	List<WebElement> productCountIncrease;

	@FindBy(css = "input.quantity[type='number']")
	List<WebElement> productCount;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterTextOnSearch(String search) {
		searchInput.sendKeys(search);
	}

	public void clickOnSearchIcon() {
		if (searchIcon.isEnabled())
			searchIcon.click();
		else
			System.out.println("Search icon is not clickabled");
	}

	public List<String> getProducts() {
		List<String> product = new ArrayList<>();
		for (WebElement prod : productNames) {
			product.add(prod.getText());
		}
		return product;
	}

	public void increaseProductCOunt(int count) {
		for (WebElement product : productCountIncrease) {
			for (int i = 0; i < count - 1; i++) {
				product.click();
			}
		}
	}

	public List<Integer> getProductCount() {
		List<Integer> counts = new ArrayList<>();

		for (WebElement pr : productCount) {
			counts.add(Integer.parseInt(pr.getAttribute("value")));
		}

		return counts;

	}

}
