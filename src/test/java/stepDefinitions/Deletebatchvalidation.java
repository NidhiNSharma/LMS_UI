package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import driverFactory.BasePage;
import io.cucumber.java.en.*;
import pageObjects.BatchPage;
import util.PicoDInjection;

public class Deletebatchvalidation {
	PicoDInjection picoObject;

	public Deletebatchvalidation(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}
	Actions act;
	
	@When("Admin clicks the delete Icon on any row")
	public void admin_clicks_the_delete_icon_on_any_row() {
		picoObject.batchPage = new BatchPage(BasePage.getDriver());
		List<WebElement> all_delete_btn= new ArrayList<>(picoObject.batchPage.pagiantion_delete_btn());;
		all_delete_btn.get(0).click();

	}

	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
		Assert.assertTrue(picoObject.batchPage.delete_confirm_popup_yes().isEnabled());
		Assert.assertTrue(picoObject.batchPage.delete_confirm_popup_no().isEnabled());
	}

	@Given("Admin is on the batch confirm popup page")
	public void admin_is_on_the_batch_confirm_popup_page() {
		picoObject.batchPage.click_batches_btn();
		List<WebElement> all_delete_btn= new ArrayList<>(picoObject.batchPage.pagiantion_delete_btn());;
		all_delete_btn.get(0).click();
		Assert.assertTrue(picoObject.batchPage.delete_confirm_popup_yes().isEnabled());
	}

	@When("Admin clicks on the delete icon and click yes button")
	public void admin_clicks_on_the_delete_icon_and_click_yes_button() {
		picoObject.batchPage.delete_confirm_popup_yes().click();
	}


@Then("Admin should see the successful message {string} and the batch should be deleted")
public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted(String ExpectedMessage) {
	Assert.assertEquals(picoObject.batchPage.msg_deleted_single().getText(), ExpectedMessage);
}

	@When("Admin clicks on the delete icon and click no button")
	public void admin_clicks_on_the_delete_icon_and_click_no_button() {
		picoObject.batchPage.delete_confirm_popup_no().click();
	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
		Assert.assertTrue(picoObject.batchPage.batch_Managebatch_header().isEnabled());
	}

	@When("Admin click on the close icon")
	public void admin_click_on_the_close_icon() {
		picoObject.batchPage.delete_confirm_popup_cancel().click();
	}

	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed() {
		Assert.assertTrue(picoObject.batchPage.batch_Managebatch_header().isEnabled());
	}
}
