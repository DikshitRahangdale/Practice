package Courses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Driver.CrmLogin;
import Driver.DriverSetup;

public class NewCourse extends DriverSetup {
	CrmLogin logins;
	String course_Module = "Introduction";
	String courseName = "Dikshit Test";

	@Test(priority = 2, enabled = false)
	public void newcourse() throws InterruptedException {

		logins = new CrmLogin(driver);
		logins.login();

		// 1) click on Courses title

		WebElement coursetitle = driver.findElement(By.xpath(
				"//div[contains(@class,\"sidebar-category-menu seles_accordion\")]//a[contains(@title,\"Courses\")]"));
		js.executeScript("arguments[0].click();", coursetitle);

		driver.findElement(By.partialLinkText("+ New Course")).click();

		// course title
		driver.findElement(By.cssSelector("input[id='course_title'][name='course_title']")).sendKeys(courseName);

		// Description
		driver.findElement(By.cssSelector("[id='course_description'][name='course_description']")).sendKeys("Test Now");

		// Next Button
		driver.findElement(By.cssSelector("button[id='NextCourseStep']")).click();

		// Don't use AI button
		Thread.sleep(3000);

		WebElement dontUse = driver.findElement(By.cssSelector("#dontuse-ai"));
		js.executeScript("arguments[0].click();", dontUse);

		// create course final button
		driver.findElement(By.cssSelector("button#create_course_final_step")).click();

		// Click on curriculum
		WebElement curriculum = driver.findElement(By.xpath(
				"(//span[contains(@class,'menu-title text-sm edit_sidebar_title ml-3')][normalize-space()='Curriculum'])[2]"));
		js.executeScript("arguments[0].click();", curriculum);

		// Add Module
		driver.findElement(By.cssSelector("#content-dropdown")).click();

		// Add Module & Step
		WebElement addModul = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()=\"Module\"]")));
		addModul.click();

		// Module

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#module_create_form")));

		driver.findElement(By.cssSelector("input.form-control.new-focus.darkColor[id='module_title']"))
				.sendKeys(course_Module);
		driver.findElement(By.xpath("//button[@type='button' and text()='+ Add Step']")).click();

		driver.findElement(By.xpath("//input[contains(@placeholder,\"Enter Step Title\")]")).sendKeys("Test");

		// Create Button
		driver.findElement(By.cssSelector("#submitModuleBtn_new")).click();

	}

	@Test(priority = 3, enabled = false)
	public void automation() throws InterruptedException {

		WebElement automation = driver.findElement((By.xpath(
				"(//span[@class='menu-title text-sm edit_sidebar_title ml-4'][normalize-space()='Automations'])[2]")));
//		WebElement automation = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(
//				"(//span[@class='menu-title text-sm edit_sidebar_title ml-4'][normalize-space()='Automations'])[2]"))));
		js.executeScript("arguments[0].click();", automation);

		// New Automation
		driver.findElement(By.cssSelector("a.trigger-slideout.inline-flex.items-center")).click();

//		 String triggerToggle=driver.findElement(By.xpath("//label[@class='switch
//		 dp-toggle-switch switch-green']//span[@class='slider
//		 round']")).isSelected();

		WebElement triggerstatus = driver.findElement(By.cssSelector("input.triggercurrentstatus"));
		if (!triggerstatus.isSelected()) {
			triggerstatus.click();
		}

		// Module Completed Trigger

		driver.findElement(By.xpath("//div[@data-trigger-tag=\"COURSE_MODULE_COMPLETE\"]")).click();

		// Module choose
		driver.findElement(By.xpath("//span[@class='current' and text()='Choose Module']")).click();
		Thread.sleep(3000);

//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@class,'nice-select') and contains(@class,'open')]//ul[@class='list']")));
//

		List<WebElement> allModule = driver.findElements(
				By.xpath("//div[contains(@class,'nice-select') and contains(@class,'open')]//ul[@class='list']/li"));

		for (WebElement mode : allModule) {
			if (mode.getText().equals(course_Module)) {
				mode.click();
				break;
			}
		}

		// New Action
		driver.findElement(By.cssSelector("a#addingAction")).click();

//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[contains(@class,\"dropdown-menu dropdown-add-action show\")]")));

		List<WebElement> triggerActions = driver
				.findElements(By.xpath("//div[contains(@class,\"dropdown-menu dropdown-add-action show\")]/a"));

		for (WebElement actions : triggerActions) {
			if (actions.getText().contains("Add Tags")) {
				actions.click();
				break;
			}
		}

		// Add Tag

//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"selectize-dropdown-content\")]")));

		driver.findElement(By.cssSelector("#js-tags-selector-selectized")).click();

		List<WebElement> tags = driver
				.findElements(By.xpath("//div[contains(@class,\"selectize-dropdown-content\")]/div"));

		for (WebElement addtags : tags) {
			if (addtags.getText().contains("Mobile test")) {
				addtags.click();
				break;
			}
		}

		driver.findElement(By.xpath("//a[contains(@class,'close_trigger_slideout text-sm')]/following-sibling::a[1]"))
				.click();

	}

	@Test(priority = 4, enabled = false)
	public void deleteCourse() {
		Actions mouse = new Actions(driver);

		logins = new CrmLogin(driver);
		logins.login();
		WebElement coursetitle = driver.findElement(By.xpath(
				"//div[contains(@class,\"sidebar-category-menu seles_accordion\")]//a[contains(@title,\"Courses\")]"));
		js.executeScript("arguments[0].click();", coursetitle);

		// Search Courses
//		WebElement searchInput = driver.findElement(By.cssSelector("input.global-filter.dp-search-field"));
//
//		searchInput.sendKeys(courseName, Keys.ENTER);
//		// Delete Courses
//		List<WebElement> allCourses = driver
//				.findElements(By.xpath("//*[@class='responsive view_course_page mt-3']/ul/div"));
//		if(allCourses.size()>0)
//		{
//		for (WebElement crs : allCourses) {
//			
//			mouse.moveToElement(crs).perform();
//             //click on three dots
//			crs.findElement(By.cssSelector("#dropdownMenu2")).click();
//			// click on delete options
//			crs.findElement(By.xpath("(//a[@id='viewlist'])[6]")).click();
//			driver.findElement(By.xpath("//button[normalize-space()=\"Yes, Delete Course\"]")).click();
//			}
//			
//		}

		// Search course
//		    By searchBox = By.cssSelector("input.global-filter.dp-search-field");
//		    wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox))
//		        .sendKeys(Keys.CONTROL + "a", Keys.DELETE, courseName, Keys.ENTER);

		WebElement searchInput = driver.findElement(By.cssSelector("input.global-filter.dp-search-field"));
		searchInput.sendKeys(courseName, Keys.ENTER);

		By courseCard = By.xpath("//*[@class='responsive view_course_page mt-3']/ul/div");
		By threeDots = By.id("dropdownMenu2");
		By deleteBtn = By.xpath("//a[normalize-space()='Delete']");
		By confirmBtn = By.xpath("//button[normalize-space()='Yes, Delete Course']");

		int deletedCount = 0;

		while (true) {

			List<WebElement> courses = driver.findElements(courseCard);

			if (courses.isEmpty()) {
				System.out.println("✅ All matching courses deleted. Total = " + deletedCount);
				break;
			}

			// ALWAYS take fresh element
			WebElement course = courses.get(0);

			// Scroll instead of hover (prevents DOM re-render)
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", course);

			// Click three dots
			js.executeScript("arguments[0].click();", course.findElement(threeDots));

			// Click delete
			wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();

			// Confirm
			wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();

			// 🔑 WAIT until THIS course is removed
			wait.until(ExpectedConditions.invisibilityOf(course));

			deletedCount++;
		}
	}

	@Test(priority = 1)
	public void contactscreate()

	{
		logins = new CrmLogin(driver);
		logins.login();
		
		WebElement contactsElement = driver.findElement(By.xpath(
				"//div[contains(@class,\"sidebar-category-menu seles_accordion\")]//a[contains(@title,\"Contacts\")]"));
		js.executeScript("arguments[0].click();", contactsElement);
		WebElement addContacts = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class,'second-row-nav-wrapper flex')]//a[1]")));
		addContacts.click();

		// First Name
		driver.findElement(By.xpath("//input[@id=\"first_name\"]")).sendKeys("Dev");

		// email
		driver.findElement(By.cssSelector("#email")).sendKeys("dondesev@gmail.com");

		// Save

		driver.findElement(By.cssSelector("input.dp-btn.dp-animated-btn")).click();
	}

	@Test(priority = 2)
	public void inviteCustomer() throws InterruptedException {
		
		WebElement coursetitle = driver.findElement(By.xpath(
				"//div[contains(@class,\"sidebar-category-menu seles_accordion\")]//a[contains(@title,\"Courses\")]"));
		js.executeScript("arguments[0].click();", coursetitle);
 
		// search course
		WebElement searchInput = driver.findElement(By.cssSelector("input.global-filter.dp-search-field"));
		
		Actions mouse = new Actions(driver);

		searchInput.sendKeys(courseName, Keys.ENTER);
		List<WebElement> allCourses = driver
				.findElements(By.xpath("//*[@class='responsive view_course_page mt-3']/ul/div"));
		
		for(WebElement crst:allCourses)
		{
			mouse.moveToElement(crst).perform();
//          //click on three dots
		crst.findElement(By.cssSelector("#dropdownMenu2")).click();
		
		
		driver.findElement(By.xpath("(//a[contains(@class,'dropdown-item dropdown-item')]/following-sibling::a)[2]")).click();
		}

	}

}
