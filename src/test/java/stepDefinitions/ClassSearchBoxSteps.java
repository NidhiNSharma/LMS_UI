package stepDefinitions;

	
	import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
	import io.cucumber.java.en.When;
import util.LoggerLoad;
import util.PicoDInjection;
import io.cucumber.java.en.Then;

	public class ClassSearchBoxSteps {
		   PicoDInjection picoObject;
		    
		   public ClassSearchBoxSteps(PicoDInjection picoObject){
		    	this.picoObject=picoObject;	 
		   }
		   Properties properties = new Properties();
			Actions act;
		//	List<WebElement> header_batch;

	    @Given("Admin Is on the Manage Class Page after login")
			public void admin_is_on_home_page_after_login() {
				picoObject.homePage = picoObject.loginPage.getHomePageObject();
				String pageTitle = picoObject.homePage.getHomePageTitle();
				//picoObject.programPage = new ProgramPage(BasePage.getDriver());
				LoggerLoad.info("Admin is on home page after login");
	    }
	    
	    @When ("Admin clicks on the Search Button")
	    public void admin_Clicks_On_The_Search_Button() {
	  	    	
	    	picoObject.classPage.searchBox.click();
	   
	    }   
	    @When("Admin enter the Batch Name in search textbox")
	    public void admin_enter_the_batch_name_in_search_textbox() {
	    }
	 

	    @Then("Admin should see Class details are searched by Batch Name")
	    public void admin_should_see_class_details_are_searched_by_batch_name() {
	    
	    }
	
    @When("Admin enter the Class topic in search textbox")
    public void admin_enter_the_class_topic_in_search_textbox() {
   
    }

    @Then("Admin should see Class details are searched by Class topic")
    public void admin_should_see_class_details_are_searched_by_class_topic() {
    	
    	
    }
   
    @When("Admin enter the Staff Name in search textbox")
    public void admin_enter_the_staff_name_in_search_textbox() {
     
    }	
    
    @Then("Admin should see Staff details are searched by Staff name")
    public void admin_should_see_class_details_are_searched_by_staff_name() {
    
    }	
    	
    	
    	
    	
    	
	}	
    	/*    @When("Admin enter the Batch Name in search textbox")
	    public void admin_enter_the_batch_name_in_search_textbox() {
	        // Code to interact with the search textbox and enter the batch name
	        WebElement searchBox = driver.findElement(By.id("searchTextbox"));  // Assuming the search box has an ID 'searchTextbox'
	        searchBox.sendKeys("BatchNameExample");
	       
	        WebElement searchButton = driver.findElement(By.id("searchButton"));
	        searchButton.click();
	    }

	    @Then("Admin should see Class details are searched by Batch Name")
	    public void admin_should_see_class_details_are_searched_by_batch_name() {
	        // Code to verify that the search results display batch name-related results
	        WebElement result = driver.findElement(By.id("searchResult"));
	        assertTrue(result.getText().contains("BatchNameExample"));
	    }

	    @When("Admin enter the Class topic in search textbox")
	    public void admin_enter_the_class_topic_in_search_textbox() {
	        // Code to interact with the search textbox and enter the class topic
	        WebElement searchBox = driver.findElement(By.id("searchTextbox"));
	        searchBox.sendKeys("ClassTopicExample");
	        
	        // Assuming there is a 'search' button, if needed
	        WebElement searchButton = driver.findElement(By.id("searchButton"));
	        searchButton.click();
	    }

	    @Then("Admin should see Class details are searched by Class topic")
	    public void admin_should_see_class_details_are_searched_by_class_topic() {
	    
	        WebElement result = driver.findElement(By.id("searchResult"));
	        assertTrue(result.getText().contains("ClassTopicExample"));
	    }

	    @When("Admin enter the Staff Name in search textbox")
	    public void admin_enter_the_staff_name_in_search_textbox() {
	     
	        WebElement searchBox = driver.findElement(By.id("searchTextbox"));
	        searchBox.sendKeys("StaffNameExample");
	        
	        WebElement searchButton = driver.findElement(By.id("searchButton"));
	        searchButton.click();
	    }

	    @Then("Admin should see Class details are searched by Staff name")
	    public void admin_should_see_class_details_are_searched_by_staff_name() {
	    
	        WebElement result = driver.findElement(By.id("searchResult"));
	        assertTrue(result.getText().contains("StaffNameExample"));
	    }
	}   */

	



