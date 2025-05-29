package stepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import driverFactory.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProgramPage;
import util.LoggerLoad;
import util.PicoDInjection;
import util.ElementUtil;


public class ProgramSteps {

	PicoDInjection picoObject;

	public ProgramSteps(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}

	@Given("Admin is logged in to LMS Portal")
	public void admin_is_logged_in_to_lms_portal() {
		LoggerLoad.info("Admin logged in to LMS Portal");
	}

	// -----#Navigation--------
	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {
		picoObject.homePage = picoObject.loginPage.getHomePageObject();
		String pageTitle = picoObject.homePage.getHomePageTitle();
		LoggerLoad.info("Admin is on home page after login");

	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String Program) throws InterruptedException {
		picoObject.homePage.clickOnProgram();
		Thread.sleep(10);
		picoObject.programPage	=picoObject.homePage.getProgrampageObject();
	    //picoObject.programPage.clickProgramButton();
		LoggerLoad.info("Admin clicked on " + Program + "from navigation bar");
	}

	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() {
		LoggerLoad.info("Admin got navigated to Program page");
	}

	// -----@Menubar------------
	// #1 logout
	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
		Assert.assertTrue(picoObject.programPage.logoutButtonPresence());
	}

	// #2 header
	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String string) {
		Assert.assertEquals(picoObject.programPage.validateHeader(), " LMS - Learning Management System ");
		LoggerLoad.info("Admin see a heading with text " + picoObject.programPage.validateHeader() + " on the page");
	}

	// #3
	@Then("Admin should see the page names as in order {string}")
	public void admin_should_see_the_page_names_as_in_order(String string) {

	}

	// #4 Add New Program
	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
		Assert.assertEquals(picoObject.programPage.addProgramButtonValidation(), "A New Program");
		LoggerLoad.info("Admin should see sub menu " + picoObject.programPage.addProgramButtonValidation()
				+ " on the program page under Program tab");
	}

	// #5 Manage program string
	@Then("Admin should see the heading as {string}")
	public void admin_should_see_the_heading_as(String string) {
		Assert.assertEquals(picoObject.programPage.validateManageProgram(), " Manage Program");
		LoggerLoad.info("Admin should see the heading as " + picoObject.programPage.validateManageProgram());
	}

	// #6 see Program name, description, and status
	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {

	}

	// #7 delete icon
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		Assert.assertFalse(picoObject.programPage.deleteIconValidation());
		LoggerLoad.info("Admin should see Delete button in left top is disabled");
	}

	// #8 search bar
	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {
		Assert.assertEquals(picoObject.programPage.searchBoxValidation(), "Search...");
		LoggerLoad
				.info("Admin should see Search bar with text as " + picoObject.programPage.searchBoxValidation() + ".");
	}

	// #9

	@Then("Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit\\/Delete")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
	}
	@Then("Admin should see data table on the Manage Program Page with column headers")
	public void dmin_should_see_data_table_on_the_manage_program_page_with_column_headers() {

		Assert.assertTrue("Program Name".equals(picoObject.programPage.programNameHeaderValidation()));
		Assert.assertTrue("Program Description".equals(picoObject.programPage.programDescriptionHeaderValidation()));
		Assert.assertTrue("Program Status".equals(picoObject.programPage.programStatusHeaderValidation()));
		Assert.assertTrue("Edit / Delete".equals(picoObject.programPage.editDeleteHeaderValidation()));
		LoggerLoad.info("Admin should see data table on the Manage Program Page with column headers");

	}

	// #10
	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
		Assert.assertFalse(picoObject.programPage.checkBoxDefaultStatus());
		LoggerLoad.info("Admin should see checkbox default state as unchecked beside Program Name column header");
	}

	// #11
	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {


	}

	// #12
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {


		picoObject.pageUtils = picoObject.getCurrentPageUtils(picoObject.programPage.numberOfRecordstextValidate());
		for (int i = 1; i <= picoObject.pageUtils.getRecordsPerPage(); i++) {
			WebElement rowCheckBox = BasePage.getDriver().findElement(By.xpath(
					"/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["
							+ i + "]/td[1]/p-tablecheckbox/div/div[2]"));
			Assert.assertTrue(rowCheckBox.isDisplayed());
			LoggerLoad.info("Admin should see check box on the left side in all rows of the data table");
		}
	}

	

	// #13
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {

		picoObject.pageUtils = picoObject.getCurrentPageUtils(picoObject.programPage.numberOfRecordstextValidate());

		for (int i = 1; i <= picoObject.pageUtils.getRecordsPerPage(); i++) {
			WebElement rowEditIcon = BasePage.getDriver().findElement(By.xpath(
					"/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["
							+ i + "]/td[5]/div/span/button[1]/span[1]"));
			Assert.assertTrue(rowEditIcon.isDisplayed());
		}

		for (int i = 1; i <= picoObject.pageUtils.getRecordsPerPage(); i++) {
			WebElement rowdeleteicon = BasePage.getDriver().findElement(By.xpath(
					"/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["
							+ i + "]/td[5]/div/span/button[2]/span[1]"));
			Assert.assertTrue(rowdeleteicon.isDisplayed());
			LoggerLoad.info("Admin should see the Edit and Delete buttons on each row of the data table");
		}


	}

	// #14 Showing x to x of y entries
	@Then("{string}{string}\" along with Pagination icon below the table.")
	public void along_with_pagination_icon_below_the_table(String string, String string2) {
		String rowsInfo = picoObject.programPage.numberOfRecordstextValidate();
		String[] items = rowsInfo.split(" "); // e.g. Showing 1 to 5 of 7 entries
		Assert.assertTrue(items.length == 10 && items[0].equals("Showing") && items[2].equals("to")
				&& items[4].equals("of") && items[6].equals("entries"));
		LoggerLoad.info("Admin should see the text as " + picoObject.programPage.numberOfRecordstextValidate()
				+ " along with Pagination icon below the table");
	}

	// #15 footer
	@Then("Admin should see the footer as \"\"In total there are z programs\"\".")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs() {
		LoggerLoad.info("Footer Message ------>" + picoObject.programPage.getFooterMessage());
		Assert.assertTrue(picoObject.programPage.getFooterMessage().startsWith("In total there are ")
				&& picoObject.programPage.getFooterMessage().endsWith(" programs."));
	}

	// -------------------------Add New program -----------------------//

	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks <A New Program> button")
	public void admin_clicks_a_new_program_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks <Save>button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin gets a Error message alertProgram")
	public void admin_gets_a_error_message_alert_program() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin enter value only in ProgramName using {string} and {int}")
	public void admin_enter_value_only_in_program_name_using_and(String string, Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks Save Button")
	public void admin_clicks_save_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("admin gets a message alert for description")
	public void admin_gets_a_message_alert_for_description() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin enters only numbers or special char in name and desc column {string} and {int}")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_and(String string, Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin gets a Error message alert SpecialCharecters")
	public void admin_gets_a_error_message_alert_special_charecters() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks Close\\(X) Icon on Program Details form")
	public void admin_clicks_close_x_icon_on_program_details_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Program Details popup window should be closed without savings")
	public void program_details_popup_window_should_be_closed_without_savings() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Enter all the required fields with valid values {string} and {int}")
	public void enter_all_the_required_fields_with_valid_values_and(String string, Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks <Cancel>buttonProgram")
	public void admin_clicks_cancel_button_program() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}


}
