package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import driverFactory.BasePage;
import io.cucumber.java.en.*;
import pageObjects.BatchPage;
import util.PicoDInjection;

public class Deletemultiplebatcheswithcheckbox {
	
	WebDriver driver;
	Actions act;
	PicoDInjection picoObject;

	public Deletemultiplebatcheswithcheckbox(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}
	
@When("Admin clicks on the delete icon under the Manage batch header")
public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() throws InterruptedException {
	picoObject.batchPage = new BatchPage(BasePage.getDriver());
	 int totalPages = picoObject.batchPage.getTotalPages();
	    System.out.println("Total pages: " + totalPages);	
	    boolean elementFound = false;
	    for (int currentPage = 1; currentPage <= totalPages && !elementFound; currentPage++) {
	        List<WebElement> dataTableElements = picoObject.batchPage.all_data();
	        for (WebElement element : dataTableElements) {
	            try {
	                WebElement editBatchElement = picoObject.batchPage.edit_element();
	                System.out.println("delete batch text: " + editBatchElement.getText());
	                elementFound = true;
	                act.moveToElement(picoObject.batchPage.single_check_delete()).click().perform();
	                picoObject.batchPage.all_delete().click();
	                picoObject.batchPage.delete_confirm_popup_yes().click();;
                 
	                break;
	            } catch (NoSuchElementException e) {
	                System.out.println("Edit batch element not found");
	            }
	        }
	        if (!elementFound) {
	        	picoObject.batchPage.clickNextPage();
	        }
	    }
}

@When("Admin clicks multiple checkbox and clicks on the delete icon under the Manage batch header")
public void admin_clicks_multiple_checkbox_and_clicks_on_the_delete_icon_under_the_manage_batch_header() {
	int paginationPageCount = picoObject.batchPage.getTotalPages();
    System.out.println("Total pages: " + paginationPageCount);

    List<WebElement> allElements = new ArrayList<>();

    for (int currentPage = 1; currentPage <= paginationPageCount; currentPage++) {
        List<WebElement> dataTableElements = picoObject.batchPage.all_data();
        for (WebElement element : dataTableElements) {
            try {
                WebElement editBatchElement = picoObject.batchPage.edit_element_all();
                System.out.println("delete batch text: " + editBatchElement.getText());
                act.moveToElement(picoObject.batchPage.multiple_check_delete()).click().perform();
                allElements.add(element);
            } catch (NoSuchElementException e) {
                // Log the error or throw a custom exception
                System.err.println("Edit batch element not found on page " + currentPage);
            }
        }
        if (currentPage < paginationPageCount) {
        	picoObject.batchPage.clickNextPage();
        }
    }

    // Delete all elements
    deleteElements();


}

private void deleteElements() {
    
	picoObject.batchPage.all_delete().click();
	picoObject.batchPage.delete_confirm_popup_yes().click();
}

@Then("The respective row in the table should be deleted successfully with message {string}")
public void the_respective_row_in_the_table_should_be_deleted_successfully_with_message(String ExpectedMessage) {
	Assert.assertEquals(picoObject.batchPage.msg_deleted().getText(), ExpectedMessage);
}


}
