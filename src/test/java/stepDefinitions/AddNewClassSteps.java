package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.ExcelReader;
import util.LoggerLoad;
import util.PicoDInjection;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


		public class AddNewClassSteps{
		
			PicoDInjection picoObject;
			Actions act;
			private ExcelReader reader = new ExcelReader();
			public AddNewClassSteps(PicoDInjection picoObject) {
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
				@SuppressWarnings("unused")
				String pageTitle = picoObject.homePage.getHomePageTitle();
				//picoObject.classPage = new ClassPage(BasePage.getDriver());
				LoggerLoad.info("Admin is on home page after login");

			}
			
		    @When("Admin clicks on the {string} navigation bar")
		    public void admin_clicks_on_the_class_navigation_bar(String Class) throws InterruptedException {
		    	picoObject.homePage.clickOnClass();
				Thread.sleep(1000);
				picoObject.classPage = picoObject.homePage.getClasspageObject();
			    //picoObject.classPage.clickClassButton();
				LoggerLoad.info("Admin clicked on " + Class + "from navigation bar");
		    } 
		    
			@When("Admin clicks on add new class under the class menu bar")
			public void admin_clicks_on_add_new_class_under_the_class_menu_bar(String Class) throws InterruptedException {
		    	picoObject.classPage.addNewClass();
				Thread.sleep(1000);
				picoObject.classPage = picoObject.homePage.getClasspageObject();
			    //picoObject.classPage.clickClassButton();
				LoggerLoad.info("Admin clicked on " + Class + "from navigation bar");
		    } 
			
			@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
			public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
				
				// Verify the popup is displayed
				Assert.assertEquals(picoObject.classPage.validateAddPopupBox(), true);
				LoggerLoad.info("Admin should see Popup Box");
	
			    // Verify the presence of the SAVE button
				Assert.assertEquals(picoObject.classPage.validatePopupSaveButton(), true);
				LoggerLoad.info("Admin should see SAVE button");

			    // Verify the presence of the CANCEL button
			   Assert.assertEquals(picoObject.classPage.validatePopupCancelButton(), true);
			   LoggerLoad.info("Admin should see CANCEL button");
	
			    // Verify the presence of the Close(X) icon
				Assert.assertEquals(picoObject.classPage.validatePopupCloseButton(), true);
				LoggerLoad.info("Admin should see Close button");
             }
	
			@Given("Admin is on the Class Popup window")
			public void admin_is_on_the_class_popup_window() {
				Assert.assertEquals(picoObject.classPage.validateAddPopupBoxHeader(), true);
				LoggerLoad.info("Admin should see Popup Box");
			  
			}

			@When("Admin enters mandatory fields in the form and clicks on save button")
			public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button() {
				

			
		
			}

			@Then("Admin gets message Class added Successfully")
			public void admin_gets_message_class_added_successfully() {
			
			 
			}

			@When("Admin selects Class Date in date picker")
			public void admin_selects_class_date_in_date_picker() {
			
			}

			@Then("Admin should see number of Class value is added automatically")
			public void admin_should_see_number_of_class_value_is_added_automatically() {
				
			}
			@Then("Admin clicks date picker")
			public void admin_clicks_date_picker() {
				
			}


			@Then("Admin should see weekends dates are disabled to select")
			public void admin_should_see_weekends_dates_are_disabled_to_select() {
				

			}

			@When("Admin skips to add value in mandatory field and enter only the optional field")
			public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field() {
			

			}

			@Then("Admin should see error message below the test field and the field will be highlighted in red color")
			public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighted_in_red_color() {
				Assert.assertEquals(picoObject.classPage.validateErrorMsg(), true);
				LoggerLoad.info("Admin should see Close button");
		 
			}

			@When("Admin enters invalid data in all of the  fields in the form and clicks on save button")
			public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_save_button() {
				

			}

			@Then("Admin gets error message and class is not created")
			public void admin_gets_error_message_and_class_is_not_created() {
	
			
			}

			@When("Admin clicks on save button without entering data")
			public void admin_clicks_on_save_button_without_entering_data() {
				picoObject.classPage.clickOnPopupSaveButton();
			
			   
			}

			@Then("Class will not  created and Admin gets error message")
			public void class_will_not_created_and_admin_gets_error_message() {
				picoObject.classPage.validateErrorMsg();
				Assert.assertTrue(picoObject.classPage.validateErrorMsg());
				
			
			}

			@When("Admin clicks Cancel Icon on Class Details form")
			public void admin_clicks_cancel_icon_on_class_details_form() {
					picoObject.classPage.clickOnPopupCancelButton();
				  
				}

			@Then("Class Details popup window should be closed without saving")
			public void class_details_popup_window_should_be_closed_without_saving() {
			 
			}

			@When("Admin clicks save button")
			public void admin_clicks_save_button() {
				picoObject.classPage.clickOnPopupSaveButton();
			  
			}

			@Then("Admin can see the class details popup closed and adding new class")
			public void admin_can_see_the_class_details_popup_closed_and_adding_new_class() {
			
			}



		}	
		
		
		
		
	
