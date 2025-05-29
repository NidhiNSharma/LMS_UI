package stepDefinitions;

import org.testng.Assert;
import driverFactory.BasePage;
import pageObjects.LoginPage;
import util.LoggerLoad;
import util.PicoDInjection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import hooks.applicationHooks;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

	public class ClassPageValidationSteps{
	
	   PicoDInjection picoObject;
	    
	   public ClassPageValidationSteps(PicoDInjection picoObject){
	    	this.picoObject=picoObject;	 
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
			//picoObject.classPage = new ClassPage(BasePage.getDriver());
			LoggerLoad.info("Admin is on home page after login");

		}
		

	    @When("Admin clicks on the {string} navigation bar")
	    public void admin_clicks_on_the_navigation_bar(String Class) throws InterruptedException {
	    	picoObject.homePage.clickOnClass();
			Thread.sleep(1000);
			picoObject.classPage = picoObject.homePage.getClasspageObject();
		    //picoObject.classPage.clickClassButton();
			LoggerLoad.info("Admin clicked on " + Class + "from navigation bar");
	    } 	    
	
	  @Then("Admin should see {string} as the title")
	    public void admin_should_see_as_the_title(String title) {
			Assert.assertEquals(picoObject.programPage.validateHeader(), " LMS - Learning Management System ");
			LoggerLoad.info("Admin see a heading with text " + picoObject.classPage.validateHeader() + " on the page");	 	
	  }
	  
	  @Then("Admin should see {string} as the page header")
	    public void admin_should_see_as_the_page_header(String header) {
			Assert.assertEquals(picoObject.programPage.validateManageClass(), " Manage Class");
			LoggerLoad.info("Admin should see the heading as " + picoObject.classPage.validateManageClass());
	
	  }
	    @Then("Admin should see the search bar")
	    public void admin_should_see_the_search_bar() { 
	    	Assert.assertEquals(picoObject.programPage.searchBoxValidation(), "Search...");
			LoggerLoad
					.info("Admin should see Search bar with text as " + picoObject.classPage.searchBoxValidation() + ".");	
	   
	    }

	    @SuppressWarnings("unlikely-arg-type")
		@Then("Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit\\/Delete")
	    public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() { 
	    	Assert.assertTrue("Batch Name".equals(picoObject.classPage.batchNameValidation()));
			Assert.assertTrue("Class Topic".equals(picoObject.classPage.classTopicValidation()));
			Assert.assertTrue("Class Description".equals(picoObject.classPage.classDescriptionValidation()));
			Assert.assertTrue("Select Class Dates".equals(picoObject.classPage.selectClassDatesValidation()));
			Assert.assertTrue("No of Classes".equals(picoObject.classPage.noOfClassesValidation()));
			Assert.assertTrue("Staff Name".equals(picoObject.classPage.staffNameValidation()));
			Assert.assertTrue("Status".equals(picoObject.classPage.statusValidation()));
			Assert.assertTrue("Comments".equals(picoObject.classPage.commentsValidation()));
			Assert.assertTrue("Notes".equals(picoObject.classPage.notesValidation()));
			Assert.assertTrue("Recordings".equals(picoObject.classPage.recordingsValidation()));
			LoggerLoad.info("Admin should see data table on the Manage Program Page with column headers");
	
	}   
	    			    
	    @Then("Admin should see the Sort icon of all the field in the datatable.")
	    public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {

			picoObject.pageUtils = picoObject.getCurrentPageUtils(picoObject.programPage.numberOfRecordstextValidate());
			for (int i = 1; i <= picoObject.pageUtils.getRecordsPerPage(); i++) {
				WebElement rowCheckBox = BasePage.getDriver().findElement(By.xpath(
						"/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["
								+ i + "]/td[1]/p-tablecheckbox/div/div[2]"));
				Assert.assertTrue(rowCheckBox.isDisplayed());
				LoggerLoad.info("Admin should see check box on the left side in all rows of the data table");
			}
		
			}

	    @Then("Admin should see Checkbox default state as unchecked beside Batch Name column header")
	    public void admin_should_see_checkbox_default_state_as_unchecked_beside_batch_name_column_header(String columnName) {
	    	Assert.assertFalse(picoObject.programPage.checkBoxDefaultStatus());
			LoggerLoad.info("Admin should see checkbox default state as unchecked beside Program Name column header");
	    
	    }
	    

	    @Then("Admin should see Checkboxs default state as unchecked on the left side in all rows against Batch Name")
	    public void admin_should_see_checkboxs_default_state_as_unchecked_on_the_left_side_in_all_rows_against_batch_name(String columnName) {
	    }
	    
	    @Then("Admin should see pagination controls \\(Previous, Next, Page Numbers)")
	    public void admin_should_see_pagination_controls_previous_next_page_numbers() {
	
	    }
	    @Then("Admin should see the text {string}")
	    public void admin_should_see_the_text(String text) {
	
	    }
	    
	    @Then("enabled pagination controls under the data table")
	    public void enabled_pagination_controls_under_the_data_table() {
	}

	    @Then("Admin should see {string} text at the bottom of the page")
	    public void admin_should_see_text_at_the_bottom_of_the_page(String text) {
	       	LoggerLoad.info("Footer Message ------>" + picoObject.classPage.getPaginationMsg());
			Assert.assertTrue(picoObject.classPage.getPaginationMsg().startsWith("In total there are ")
					&& picoObject.classPage.getPaginationMsg().endsWith(" classes."));
	 
	    }
	    
	    @Then("Admin should see a DELETE button under the Manage Class page header")
	    public void admin_should_see_a_delete_button_undar_the_manage_class_page_header() {	
	    	Assert.assertFalse(picoObject.classPage.deleteIconValidation());
			LoggerLoad.info("Admin should see Delete button in left top is disabled");
	
	    }
	 
	    }
	
