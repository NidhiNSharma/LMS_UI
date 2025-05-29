package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverFactory.BasePage;
import io.cucumber.java.en.*;
import pageObjects.BatchPage;
import util.PicoDInjection;

public class SearchTextboxvalidation {
	PicoDInjection picoObject;

	public SearchTextboxvalidation(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}
	Properties properties = new Properties();
	Actions act;
	List<WebElement> header_batch;
	
	@When("Admin enters the batch name in the search text box {string}")
	public void admin_enters_the_batch_name_in_the_search_text_box(String text) throws InterruptedException {
		picoObject.batchPage = new BatchPage(BasePage.getDriver());
		act = new Actions(picoObject.batchPage.getDriver());
		act.moveToElement(picoObject.batchPage.txt_searchbox())
		        .click()
		        .sendKeys(text);
		act.click().pause(Duration.ofSeconds(2)).perform();
	}

	@Then("Admin should see the filtered batches in the data table {string}")
	public void admin_should_see_the_filtered_batches_in_the_data_table(String text) throws InterruptedException {
		
		Assert.assertEquals(picoObject.batchPage.search().getText(),text);
		
		
	}
}
