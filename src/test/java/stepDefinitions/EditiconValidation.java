package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import driverFactory.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import util.ExcelReader;
import util.PicoDInjection;


public class EditiconValidation {
	private ExcelReader reader = new ExcelReader();
	Actions act;
	PicoDInjection picoObject;

	public EditiconValidation(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}
	
@When("scenario specified in {string} and rownumber {int} Excel")
public void scenario_specified_in_and_rownumber_excel(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
	List<Map<String, String>> testData = reader.getData(System.getProperty("user.dir")+"\\src\\test\\resources\\utils\\batch.xlsx", sheetName);
    Map<String, String> data = testData.get(rowNumber);
    String scenario=data.get("Scenarios");
	String ProgramName=data.get("ProgramName");
	String BatchName1=data.get("BatchName1");
	String BatchName2=data.get("BatchName2");
	String Status=data.get("Status");
	String Description=data.get("Description");
	String NumberofClasses=data.get("NumberofClasses");	
	picoObject.batchPage = new BatchPage(BasePage.getDriver());
	act=new Actions(picoObject.batchPage.getDriver());
		if (scenario.equals("Validate Edit icon feature in any row")||
				scenario.equals("Validate program name value is disabled to edit")||
				scenario.equals("Validate batch name value is disabled to edit"))
				{
		    System.out.println(scenario + " scenario is tested");
		    int totalPages = picoObject.batchPage.getTotalPages();
		    System.out.println("Total pages: " + totalPages);	
		    boolean elementFound = false;
		    for (int currentPage = 1; currentPage <= totalPages && !elementFound; currentPage++) {
		        List<WebElement> dataTableElements = picoObject.batchPage.all_data();
		        for (WebElement element : dataTableElements) {
		            try {
		                WebElement editBatchElement = picoObject.batchPage.edit_element();
		                System.out.println("Edit batch text: " + editBatchElement.getText());
		                elementFound = true;
	                    WebElement editBatchIcon = picoObject.batchPage.edit_batch_icon();
	                    editBatchIcon.click();
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
	else if (scenario.equals("Validate editing description with invalid data in the pop up")) {
		 System.out.println(scenario + " scenario is tested");
		    int totalPages = picoObject.batchPage.getTotalPages();
		    System.out.println("Total pages: " + totalPages);	
		    boolean elementFound = false;
		    for (int currentPage = 1; currentPage <= totalPages && !elementFound; currentPage++) {
		        List<WebElement> dataTableElements = picoObject.batchPage.all_data();
		        for (WebElement element : dataTableElements) {
		            try {
		                WebElement editBatchElement = picoObject.batchPage.edit_element();
		                System.out.println("Edit batch text: " + editBatchElement.getText());
		                elementFound = true;
	                    WebElement editBatchIcon = picoObject.batchPage.edit_batch_icon();
	                    editBatchIcon.click();
	                    picoObject.batchPage.txtbox_batchDesc().clear();
	                    act.moveToElement(picoObject.batchPage.txtbox_batchDesc()).click().perform();
	                    picoObject.batchPage.txtbox_batchDesc().sendKeys(Description);
		                break;
		            } catch (NoSuchElementException e) {
		                System.out.println("Edit batch element not found");
		            }
		        }
		        if (!elementFound) {
		        	picoObject.batchPage.clickNextPage();
		        }
		    }		
	}else if(scenario.equals("Validate editing  No. of classes fields with invalid data in the pop up")) {
		 System.out.println(scenario + " scenario is tested");
		    int totalPages = picoObject.batchPage.getTotalPages();	
		    boolean elementFound = false;
		    for (int currentPage = 1; currentPage <= totalPages && !elementFound; currentPage++) {
		        List<WebElement> dataTableElements = picoObject.batchPage.all_data();
		        for (WebElement element : dataTableElements) {
		            try {
		                WebElement editBatchElement = picoObject.batchPage.edit_element();
		                int length=picoObject.batchPage.edit_class_total().getText().length();
		                elementFound = true;
		                System.out.println("total numbers:"+picoObject.batchPage.edit_class_total().getText());
	                    WebElement editBatchIcon = picoObject.batchPage.edit_batch_icon();
	                    editBatchIcon.click();	
	                    act.moveToElement(picoObject.batchPage.txtbox_noClasses()).click().perform();  
	                    for(int i=0;i<length;i++)
	                    {
	                    	act.sendKeys(Keys.BACK_SPACE).perform();
	                    }	                    
	                    picoObject.batchPage.btn_save().click();
	                    
		                break;
		            } catch (NoSuchElementException e) {
		                System.out.println("Edit batch element not found");
		            }
		        }
		        if (!elementFound) {
		        	picoObject.batchPage.clickNextPage();
		        }
		    }		
	}else if(scenario.equals("validate save button in Batch details pop up")) {
		int totalPages = picoObject.batchPage.getTotalPages();
		outerLoop:		
		for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
		    List<WebElement> dataTableElements = picoObject.batchPage.all_data();
		    
		    for (WebElement element : dataTableElements) {
		        try {
		            WebElement editBatchElement = picoObject.batchPage.edit_element();
		            WebElement editBatchIcon = picoObject.batchPage.edit_batch_icon();
		            editBatchIcon.click();
		            picoObject.batchPage.txtbox_noClasses().clear();
		            act.moveToElement(picoObject.batchPage.txtbox_noClasses()).click().perform();
		            picoObject.batchPage.txtbox_noClasses().sendKeys(NumberofClasses);
		            Thread.sleep(1000);
		            picoObject.batchPage.btn_save().click();
		            break outerLoop;
		        } catch (NoSuchElementException e) {
		            System.out.println("Edit batch element not found");
		        }
		    }
		    
		    picoObject.batchPage.clickNextPage();
		}
	}else if(scenario.equals("validate cancel button in Batch details pop up")) {
		int totalPages = picoObject.batchPage.getTotalPages();
		outerLoop:		
		for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
		    List<WebElement> dataTableElements = picoObject.batchPage.all_data();
		    
		    for (WebElement element : dataTableElements) {
		        try {
		            WebElement editBatchElement = picoObject.batchPage.edit_element();
		            WebElement editBatchIcon = picoObject.batchPage.edit_batch_icon();
		            editBatchIcon.click();
		            picoObject.batchPage.txtbox_noClasses().clear();
		            act.moveToElement(picoObject.batchPage.txtbox_noClasses()).click().perform();
		            picoObject.batchPage.txtbox_noClasses().sendKeys(NumberofClasses);
		            Thread.sleep(1000);
		            picoObject.batchPage.btn_cancel().click();
		            break outerLoop;
		        } catch (NoSuchElementException e) {
		            System.out.println("Edit batch element not found");
		        }
		    }
		    
		    picoObject.batchPage.clickNextPage();
		}
	}
}
	        
	  

@Then("Admin sees the message in sheetname {string} and rownumber {int}")
public void admin_sees_the_message_in_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	List<Map<String, String>> testData = reader.getData(System.getProperty("user.dir")+"\\src\\test\\resources\\utils\\batch.xlsx", sheetName);
    Map<String, String> data = testData.get(rowNumber);
    String scenario=data.get("Scenarios");
    String ExpectedMessage=data.get("ExpectedMessage");  	
    if (scenario.equals("Validate Edit icon feature in any row")) {
    	Assert.assertEquals(picoObject.batchPage.BatchDetails_text().getText(),ExpectedMessage);
    }else  if (scenario.equals("Validate program name value is disabled to edit")) {
    	Assert.assertFalse(picoObject.batchPage.txtbox_programName().isEnabled());
    }else  if (scenario.equals("Validate program name value is disabled to edit")) {
    	Assert.assertFalse(picoObject.batchPage.txt_batchName().isEnabled());
    }else if(scenario.equals("Validate editing description with invalid data in the pop up"))
    {
    	Assert.assertEquals(picoObject.batchPage.error_msg_desc(),ExpectedMessage);
    }else if(scenario.equals("Validate editing  No. of classes fields with invalid data in the pop up")) {
    	Assert.assertEquals(picoObject.batchPage.error_msg_noofclasses(), ExpectedMessage);
    }else if(scenario.equals("validate save button in Batch details pop up")) {
    	Assert.assertEquals(picoObject.batchPage.success_msg(), ExpectedMessage);
    }else if(scenario.equals("validate cancel button in Batch details pop up")){
    	Assert.assertTrue(picoObject.batchPage.txt_search_entry.isDisplayed());
    }
}

}
