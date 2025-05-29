package stepDefinitions;

import org.testng.Assert;

import driverFactory.BasePage;
import io.cucumber.java.en.*;
import pageObjects.BatchPage;
import util.PicoDInjection;

public class Pagination {
	PicoDInjection picoObject;

	public Pagination(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}
	
	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() {
		picoObject.batchPage = new BatchPage(BasePage.getDriver());
	    int totalPages = picoObject.batchPage.getTotalPages();
	    for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
	        System.out.println("Page: " + currentPage);
	        picoObject.batchPage.clickNextPageIfEnabled();
	    }
	}

	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_next_enabled_link() {
	    Assert.assertTrue(!picoObject.batchPage.nextright().isEnabled());
	}
	
	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() {
	    
		picoObject.batchPage.btn_lastnext();
	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
	    Assert.assertFalse(picoObject.batchPage.nextright().isEnabled());
	}
	@When("Admin clicks previous page link on the data table")
	public void admin_clicks_previous_page_link_on_the_data_table() throws InterruptedException {
		int totalPages = picoObject.batchPage.getTotalPages();
		for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
			picoObject.batchPage.clickNextPage();
		}
		for (int currentPage = totalPages; currentPage >= 1; currentPage--) {
		    System.out.println("Page: " + currentPage);
		    picoObject.batchPage.clickPreviousPageIfEnabled();
		}
	    
	}
	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {
		 Assert.assertTrue(!picoObject.batchPage.btn_previous().isEnabled());
	}
	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {
		int totalPages = picoObject.batchPage.getTotalPages();
		for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
			picoObject.batchPage.clickNextPage();
		}
		picoObject.batchPage.click_First_prev();
	}

	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() {
		String text= picoObject.batchPage.txt_showing().getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Showing 1 to"));

	    
	}


}