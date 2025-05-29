package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driverFactory.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import util.ConfigReader;
import util.PicoDInjection;

public class BatchPageValidation_Navigation {
	
	Properties properties = new Properties();
	static List<WebElement> header_batch;
	PicoDInjection picoObject;

	public BatchPageValidation_Navigation(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}
	@Given("Admin is logged in to LMS Portal")
	public void admin_is_logged_in_to_lms_portal() throws InterruptedException {
		picoObject.loginPage= new LoginPage( BasePage.getDriver());	
		picoObject.loginPage.navigateToAppUrl();
		picoObject.loginPage.sendUserName("sdetnumpyninja@gmail.com");
		picoObject.loginPage.sendPwdName("Feb@2025");;
		picoObject.loginPage.sendRoleAsAdmin();
		picoObject.loginPage.clickLogin();
		
	}
	@Given("Admin is on the home Page")
	public void admin_is_on_the_home_page() throws Throwable {
		picoObject.homePage = new HomePage(picoObject.loginPage.getDriver());

	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {

		picoObject.batchPage = new BatchPage(BasePage.getDriver());
		picoObject.batchPage.click_batches_btn();
	}
	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() throws Throwable {
		Assert.assertEquals(picoObject.batchPage.getCurrentUrl(),ConfigReader.getPropObject().getProperty("batchpageurl"));

	}
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String lms_header) {
		Assert.assertEquals(lms_header, picoObject.batchPage.LMS_header().getText());
	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String managebatch_header) {
		Assert.assertEquals(managebatch_header, picoObject.batchPage.batch_Managebatch_header().getText());
	}

	@Then("Admin should see the disabled Delete Icon under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() {
		
		boolean isEnabled = picoObject.batchPage.batch_deleteall().isEnabled();
		Assert.assertFalse(isEnabled);
	}
	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		Assert.assertTrue(picoObject.batchPage.Pagination_right().isEnabled());
	}
	@Then("Admin should see the checkbox in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		Assert.assertTrue(picoObject.batchPage.checkbox_header().isEnabled());
	}

	@Then("Admin should see the datatable headers {string}")
	public void admin_should_see_the_datatable_headers(String header) {
		header_batch=picoObject.batchPage.header();
		for(WebElement table_header:header_batch)
		{
			Assert.assertTrue(table_header.isDisplayed());
		}
		List<String> header_text=picoObject.batchPage.header_string();
		Assert.assertTrue(header_text.contains(header));
		
	}
	
	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		header_batch=picoObject.batchPage.header_sorticon();
		for(WebElement table_header_sort:header_batch)
		{
			Assert.assertTrue(table_header_sort.isDisplayed());
		}
	}
	@Then("Admin should see the checkbox in each row")
	public void admin_should_see_the_checkbox_in_each_row()
	{
		List<WebElement> all_checkbox;
		int totalPages = picoObject.batchPage.getTotalPages();
		for (int i = 0; i <totalPages; i++) {
		    all_checkbox = new ArrayList<>(picoObject.batchPage.pagiantion_checkbox());
		    for(WebElement checkbox:all_checkbox)
		    {
		    	Assert.assertTrue(checkbox.isEnabled());
		    }
		    picoObject.batchPage.clickNextPage();
		}
	}
	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		List<WebElement> all_delete_btn;
		int totalPages = picoObject.batchPage.getTotalPages();
		for (int i = 0; i <totalPages; i++) {
		   all_delete_btn = new ArrayList<>(picoObject.batchPage.pagiantion_delete_btn());
		    for(WebElement btn:all_delete_btn)
		    {
		    	Assert.assertTrue(btn.isEnabled());
		    }
		    picoObject.batchPage.clickNextPage();
		}
	}
	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		List<WebElement> all_edit_btn;
		int totalPages = picoObject.batchPage.getTotalPages();
		System.out.println("Total pages: " + totalPages);
		for (int i = 0; i <totalPages; i++) {
//		    System.out.println("Iteration " + (i + 1));
		    // Collect and print checkboxes on the current page
		   all_edit_btn = new ArrayList<>(picoObject.batchPage.pagiantion_edit_btn());
		    for(WebElement btn:all_edit_btn)
		    {
//		    	System.out.println(btn);
		    	Assert.assertTrue(btn.isEnabled());
		    }

		    // Click the right pagination button using JavaScript
		    picoObject.batchPage.clickNextPage();
		}
	}
	
}

