package stepDefinitions;

import java.util.List;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import driverFactory.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.BatchPage;
import util.ConfigReader;
import util.PicoDInjection;

public class AddNewBatch {
	PicoDInjection picoObject;

	public AddNewBatch(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}
	
	@Given("Admin is on batch page")
	public void admin_is_on_batch_page() throws Throwable {
		picoObject.batchPage = new BatchPage(BasePage.getDriver());
		picoObject.batchPage.click_batches_btn();
		Assert.assertEquals(picoObject.batchPage.getCurrentUrl(),ConfigReader.getPropObject().getProperty("batchpageurl"));
	}
	@When("Admin clicks Batch on the navigation bar")
	public void admin_clicks_batch_on_the_navigation_bar() {
		picoObject.batchPage.Click_batch_btn();
	}
	@Then("Admin should see sub menu in menu bar as Add New Batch")
	public void admin_should_see_sub_menu_in_menu_bar_as_add_new_batch() {
		Assert.assertTrue(picoObject.batchPage.AddNewBatch_btn().isDisplayed());
	}
	@Given("Admin is on the home page")
	public void admin_is_on_the_home_page() throws Throwable {
		Assert.assertTrue(picoObject.batchPage.homepageValidation().isDisplayed());
		Assert.assertEquals(picoObject.batchPage.getCurrentUrl(),ConfigReader.getPropObject().getProperty("homepageurl"));
	}

	@When("Admin clicks on Add New batch under the batch menu bar")
	public void admin_clicks_on_add_new_batch_under_the_batch_menu_bar() {
		picoObject.batchPage.Click_batch_btn();
		picoObject.batchPage.click_AddNewBatch_btn();
	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		Assert.assertTrue(picoObject.batchPage.BatchDetails_text().isDisplayed());
	}

}
