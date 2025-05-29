package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import driverFactory.BasePage;
import util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import util.PicoDInjection;

public class AddNewBatchdeatilspopup {
	PicoDInjection picoObject;
	Actions act;
	private ExcelReader reader = new ExcelReader();
	public AddNewBatchdeatilspopup(PicoDInjection picoObject) {
		this.picoObject = picoObject;
	}
	
	@Given("Admin is on the Batch Details Pop Up WIndow")
	public void admin_is_on_the_batch_details_pop_up_w_indow() {
		picoObject.batchPage = new BatchPage(BasePage.getDriver());
		picoObject.batchPage.Click_batch_btn();
		picoObject.batchPage.click_AddNewBatch_btn();
		Assert.assertTrue(picoObject.batchPage.BatchDetails_text().isDisplayed());
	}

	@When("Admin checks all the field")
	public void admin_checks_all_the_field() {		
	Assert.assertTrue(picoObject.batchPage.txtbox_programName().isEnabled());
	Assert.assertTrue(picoObject.batchPage.txtbox_batchName().isEnabled());
	Assert.assertTrue(picoObject.batchPage.txtbox_batchProg().isEnabled());
	Assert.assertTrue(picoObject.batchPage.txtbox_batchDesc().isEnabled());
	Assert.assertTrue(picoObject.batchPage.txtbox_noClasses().isEnabled());
	Assert.assertTrue(picoObject.batchPage.radio_active().isEnabled());
	Assert.assertTrue(picoObject.batchPage.radio_inactive().isEnabled());
	Assert.assertTrue(picoObject.batchPage.btn_cancel().isEnabled());
	Assert.assertTrue(picoObject.batchPage.btn_save().isEnabled());
	}

	@Then("The pop up should include the fields {string}")
	public void the_pop_up_should_include_the_fields(String field) {
		
		    switch (field) {
		        case "Program Name*":
		            Assert.assertEquals(picoObject.batchPage.txt_programName().getText().trim().replace("\n", ""), field);
		            break;
		        case "Batch Name*":
		            Assert.assertEquals(picoObject.batchPage.txt_batchName().getText().trim().replace("\n", ""), field);
		            break;
		        case "Description*":
		            Assert.assertEquals(picoObject.batchPage.txt_batchDesc().getText().trim().replace("\n", ""), field);
		            break;
		        case "Status : *":
		        	System.out.println(picoObject.batchPage.txt_status().getText().trim().replace("\n", ""));
		            Assert.assertEquals(picoObject.batchPage.txt_status().getText().trim().replace("\n", ""), field);
		            break;
		        case "Number of Classes*":
		            Assert.assertEquals(picoObject.batchPage.txt_noClasses().getText().trim().replace("\n", ""), field);
		            break;
		        default:
		            Assert.fail("Unknown field: " + field);
		    }
		}
	@When("scenario specified is executed in {string} and rownumber {int}")
	public void scenario_specified_is_executed_in_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testData = reader.getData(System.getProperty("user.dir")+"\\src\\test\\resources\\utils\\batch.xlsx", sheetName);
        Map<String, String> data = testData.get(rowNumber);
        String scenario=data.get("Scenarios");
		String ProgramName=data.get("ProgramName");
		String BatchName1=data.get("BatchName1");
		String BatchName2=data.get("BatchName2");
		String Status=data.get("Status");
		String Description=data.get("Description");
		String NumberofClasses=data.get("NumberofClasses");		
		if (scenario.equals("Valid batchname prefix")) {
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.drp_programName().click();
			List<WebElement> option=picoObject.batchPage.drp_addnewbatch();
			act = new Actions(picoObject.batchPage.getDriver());
			act.moveToElement(picoObject.batchPage.drp_programName()).click().sendKeys(option.get(0).getText()).click().build().perform();			
		}else if (scenario.equals("Valid batchname prefix_example2")) {
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.drp_programName().click();
			List<WebElement> option=picoObject.batchPage.drp_addnewbatch();
			act = new Actions(picoObject.batchPage.getDriver());
			act.moveToElement(picoObject.batchPage.drp_programName()).click().sendKeys(option.get(1).getText()).click().build().perform();			
		}else if (scenario.equals("InValid batchname prefix")){
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.drp_programName().click();
			picoObject.batchPage. btn_save().click();			
		}else if (scenario.equals("Valid batchname suffix_new")) {
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.drp_programName().click();
			List<WebElement> option=picoObject.batchPage.drp_addnewbatch();
			act = new Actions(picoObject.batchPage.getDriver());
			act.moveToElement(picoObject.batchPage.drp_programName()).click().sendKeys(option.get(1).getText()).click().build().perform();
			act.moveToElement(picoObject.batchPage.txtbox_batchName()).click().build().perform();
			picoObject.batchPage.txtbox_batchName().sendKeys(BatchName2);			
		}else if (scenario.equals("Valid batchname suffix_already")) {
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.drp_programName().click();
			List<WebElement> option=picoObject.batchPage.drp_addnewbatch();
			act = new Actions(picoObject.batchPage.getDriver());
			act.moveToElement(picoObject.batchPage.drp_programName()).click().sendKeys(option.get(1).getText()).click().build().perform();
			act.moveToElement(picoObject.batchPage.txtbox_batchName()).click().build().perform();
			picoObject.batchPage.txtbox_batchName().sendKeys(BatchName2);
		}else if(scenario.equals("InValid batchname suffix")) {
			System.out.println(scenario + " scenario is tested");
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.drp_programName().click();
			List<WebElement> option=picoObject.batchPage.drp_addnewbatch();
			act = new Actions(picoObject.batchPage.getDriver());
			act.moveToElement(picoObject.batchPage.drp_programName()).click().sendKeys(option.get(1).getText()).click().build().perform();
			act.moveToElement(picoObject.batchPage.txtbox_batchName()).click().build().perform();
			picoObject.batchPage.txtbox_batchName().sendKeys(BatchName2);	
		}else if (scenario.equals("Validate batch name prefix box is not editable")) {
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.txtbox_batchProg().click();
			picoObject.batchPage.txtbox_batchProg().sendKeys(BatchName1);
			picoObject.batchPage. btn_save().click();			
		}else if (scenario.equals("Validate input data only for mandatory fields")||
				scenario.equals("validate input data missing for mandatory fields_Description")||
				scenario.equals("validate input data missing for mandatory fields_NumberofClasses")||
				scenario.equals("validate save button in Batch details pop up")) {
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.drp_programName().click();
			List<WebElement> option=picoObject.batchPage.drp_addnewbatch();
			act = new Actions(picoObject.batchPage.getDriver());
			act.moveToElement(picoObject.batchPage.drp_programName()).click().sendKeys(option.get(1).getText()).click().build().perform();
			act.moveToElement(picoObject.batchPage.txtbox_batchName()).click().build().perform();
			picoObject.batchPage.txtbox_batchName().sendKeys(BatchName2);
			act.moveToElement(picoObject.batchPage.txtbox_batchDesc()).click().build().perform();
			picoObject.batchPage.txtbox_batchDesc().sendKeys(Description);
			act.moveToElement(picoObject.batchPage.txtbox_noClasses()).click().build().perform();
			picoObject.batchPage.txtbox_noClasses().sendKeys(NumberofClasses);
			picoObject.batchPage.radio_active().click();
			picoObject.batchPage.btn_save().click();
		}else if(scenario.equals("validate input data missing for mandatory fields_Status")){
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.drp_programName().click();
			List<WebElement> option=picoObject.batchPage.drp_addnewbatch();
			act = new Actions(picoObject.batchPage.getDriver());
			act.moveToElement(picoObject.batchPage.drp_programName()).click().sendKeys(option.get(1).getText()).click().build().perform();
			act.moveToElement(picoObject.batchPage.txtbox_batchName()).click().build().perform();
			picoObject.batchPage.txtbox_batchName().sendKeys(BatchName2);
			act.moveToElement(picoObject.batchPage.txtbox_batchDesc()).click().build().perform();
			picoObject.batchPage.txtbox_batchDesc().sendKeys(Description);
			act.moveToElement(picoObject.batchPage.txtbox_noClasses()).click().build().perform();
			picoObject.batchPage.txtbox_noClasses().sendKeys(NumberofClasses);
			picoObject.batchPage.btn_save().click();
		}else if (scenario.equals("validate cancel button in Batch details pop up")) {
			System.out.println(scenario + " scenario is tested");
			picoObject.batchPage.drp_programName().click();
			List<WebElement> option=picoObject.batchPage.drp_addnewbatch();
			act = new Actions(picoObject.batchPage.getDriver());
			act.moveToElement(picoObject.batchPage.drp_programName()).click().sendKeys(option.get(1).getText()).click().build().perform();
			act.moveToElement(picoObject.batchPage.txtbox_batchName()).click().build().perform();
			picoObject.batchPage.txtbox_batchName().sendKeys(BatchName2);
			act.moveToElement(picoObject.batchPage.txtbox_batchDesc()).click().build().perform();
			picoObject.batchPage.txtbox_batchDesc().sendKeys(Description);
			act.moveToElement(picoObject.batchPage.txtbox_noClasses()).click().build().perform();
			picoObject.batchPage.txtbox_noClasses().sendKeys(NumberofClasses);
			picoObject.batchPage.radio_active().click();
			picoObject.batchPage.btn_cancel().click();
		}
		
	}
	

	@Then("Admin is able to see the message in sheetname {string} and rownumber {int}")
	public void admin_is_able_to_see_the_message_in_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = reader.getData(System.getProperty("user.dir")+"\\src\\test\\resources\\utils\\batch.xlsx", sheetName);
        Map<String, String> data = testData.get(rowNumber);
        String scenario=data.get("Scenarios");
        String ExpectedMessage=data.get("ExpectedMessage");  	
        if (scenario.equals("Valid batchname prefix")) {
        	Assert.assertEquals(picoObject.batchPage.txtbox_batchProg().getText(),picoObject.batchPage.txtbox_programName().getText());
        }else if(scenario.equals("Valid batchname prefix_example2")){
        	Assert.assertEquals(picoObject.batchPage.txtbox_batchProg().getText(),picoObject.batchPage.txtbox_programName().getText());
        }else if(scenario.equals("InValid batchname prefix")){
        	Assert.assertEquals(picoObject.batchPage.error_msg_programname(),ExpectedMessage);
        }else if (scenario.equals("Valid batchname suffix_already")) {       	
        	Assert.assertEquals(picoObject.batchPage.error_msg_Batchname(), ExpectedMessage);
        }else if (scenario.equals("Valid batchname suffix_new")) {
        	Assert.assertEquals("", ExpectedMessage);
        }else if(scenario.equals("InValid batchname suffix")) {
        	Assert.assertEquals(picoObject.batchPage.error_msg_Batchname(), ExpectedMessage);
        }else if (scenario.equals("Validate batch name prefix box is not editable")) {
        	Assert.assertEquals(picoObject.batchPage.error_msg_Batchname(), ExpectedMessage);
        }else if (scenario.equals("Validate input data only for mandatory fields")||scenario.equals("validate save button in Batch details pop up")) {
        	Assert.assertEquals(picoObject.batchPage.success_msg(), ExpectedMessage);
        }else if (scenario.equals("validate input data missing for mandatory fields_Description")) {
        	Assert.assertEquals(picoObject.batchPage.error_msg_desc(), ExpectedMessage);
        }else if (scenario.equals("validate input data missing for mandatory fields_Status")) {
        	Assert.assertEquals(picoObject.batchPage.error_msg_status(), ExpectedMessage);
        }else if (scenario.equals("validate input data missing for mandatory fields_NumberofClasses")) {
        	Assert.assertEquals(picoObject.batchPage.error_msg_noofclasses(), ExpectedMessage);
        }
        
 
	}

@When("Admin clicks on the close icon")
public void admin_clicks_on_the_close_icon() throws InterruptedException {
	picoObject.batchPage.popup_close().click();
   Thread.sleep(100);
}

@Then("batch details pop up closes")
public void batch_details_pop_up_closes() {
	Assert.assertTrue(picoObject.batchPage.txt_search_entry.isDisplayed());
	
}


}
