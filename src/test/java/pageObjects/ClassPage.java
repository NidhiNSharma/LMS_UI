package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverFactory.BasePage;

public class ClassPage {
	
	WebDriver driver;
	public ClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
    @FindBy(id = "class")
    public static WebElement classButton;
    @FindBy(id = "logout")
    public static WebElement logoutButton; 
    @FindBy(xpath = "//span[normalize-space()='Class']")
    public static WebElement appHeader;
    @FindBy(className = "p-button-icon pi pi-trash")
    public static WebElement deleteIcon;
    @FindBy(id = "filterGlobal")
    public static WebElement searchBox;
    @FindBy(xpath = "//div[normalize-space()='Manage Class']")
    public static WebElement manageClassText;
    @FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
    public static WebElement paginationMsg;
    @FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
    public static WebElement numberOfRecordsText;
    @FindBy(className = "p-checkbox-box")
    public static WebElement mainCheckBoxStatus;   
    @FindBy(className = "p-checkbox-box p-component")
    public static List<WebElement> rowCheckBox;
    
  //Add New Class  
    @FindBy(xpath = "//button[normalize-space()='Add New Class']")
    public static WebElement addNewClass ;
    @FindBy(id = "pr_id_4-label")
    public static WebElement addPopupBoxHeader ; 
    @FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
    public static WebElement classBatchName;
    @FindBy(id = "//div[@class='p-dialog-header ng-tns-c81-10 ng-star-inserted']")
    public static WebElement addPopupBox;   
    @FindBy(xpath = "//span[@class='p-dropdown-trigger-icon ng-tns-c88-10 pi pi-chevron-down']")
    public static WebElement batchNameDropDown; 
    @FindBy(xpath = "//input[@id='classTopic']")
    public static WebElement classTopic;
    @FindBy(xpath = "//input[@id='classDescription']")
    public static WebElement classDescription ;
    @FindBy(xpath = "//input[@id='icon']")
    public static WebElement selectClassDates;
    @FindBy(id = "classNo")
    public static WebElement numberOfClasses;
    @FindBy( className = "p-dropdown-trigger-icon ng-tns-c88-18 pi pi-chevron-down")
    public static WebElement staffName;
    @FindBy(xpath = "//span[normalize-space()='Cancel']")
    public static WebElement cancelButton;
    @FindBy(xpath = "//span[normalize-space()='Save']")
    public static WebElement saveButton;
    @FindBy(className = "p-dialog-header-close-icon ng-tns-c81-5 pi pi-times")
    public static WebElement closeClassDetails;
    @FindBy(xpath = "//small[normalize-space()='Batch Name is required.']")
    public static WebElement errorMsg;
    @FindBy(id = "classRecordingPath")
    public static WebElement recordingsBox;
    @FindBy(id = "classNotes")
    public static WebElement notesBox;
    @FindBy(id = "classComments")
    public static WebElement commentsBox;
    @FindBy(id = "//lable[@for='online']")
    public static WebElement status;
    @FindBy(id = "/html/body/app-root/app-class/p-dialog/div/div/div[2]/div[1]/small")
    public static WebElement classRequiredMsg;
    @FindBy(id = "")
    public static WebElement prevButton;
    
	
	public void clickClassButton() {
		classButton.click();
	}
    public boolean logoutButtonPresence()  {
    	return logoutButton.isDisplayed();
    } 
   	public boolean validateHeader()	{
    	return appHeader.isDisplayed();
   	}
    public boolean addClassBarValidation() {
    	return addNewClass.isDisplayed();
    }
    public boolean deleteIconValidation() {
    	return deleteIcon.isEnabled();
    }
    public boolean searchBoxValidation() {
    	return searchBox.isEnabled();
    }
    public String searchBoxText() {
    	return searchBox.getText();
    }
    public boolean validateManageClass() {
		return manageClassText.isDisplayed(); 	
    }
    public boolean getPaginationMsg() {
  		return paginationMsg.isDisplayed(); 	
      }
    public boolean numberOfRecordsTextValidate() {
  		return numberOfRecordsText.isDisplayed(); 	
      }
    public boolean checkBoxDefaultStatus() {
  		return mainCheckBoxStatus.isEnabled(); 	
      }  
    public List<WebElement> checkBoxStatusInRows() {
    	return rowCheckBox;
    } 
	public boolean addNewClassValidation()	{
    	return appHeader.isDisplayed();
	}
        
        public void btn_previous()  {
         	 prevButton.isDisplayed();
         } 
   	}
 
    
    //Add New Class
    
    public void addNewClass()  {
      	 addNewClass.click();
      } 
    public void batchNameDropDown()  {
   	 batchNameDropDown.click();
   } 
   public void classTopic()	{
   	 classTopic.click();
   }
   public void classDescription() {
   	classDescription.click();
   }
   public void classDates() {
   	selectClassDates.click();
   }
   public boolean validateAddPopupBox() {
	return addPopupBox.isDisplayed();
}
   public boolean validateAddPopupBoxHeader() {
	 return addPopupBoxHeader.isDisplayed();
    }
   public boolean batchNameValidation() {

		return batchNameDropDown.isDisplayed();
   }
public boolean classTopicValidation() {
	
	return classTopic.isDisplayed();
}
public boolean classDescriptionValidation() {
	
	return classDescription.isDisplayed();
}

public boolean selectClassDatesValidation() {
	
	return selectClassDates.isDisplayed();
}
public boolean noOfClassesValidation() {
	
	return numberOfClasses.isDisplayed();
}
public boolean staffNameValidation() {
	
	return staffName.isDisplayed();
}

   public boolean validatePopupSaveButton() {
		 return saveButton.isDisplayed();
	    }
   public boolean validatePopupCloseButton() {
		 return closeClassDetails.isDisplayed();
	    }
   public boolean validatePopupCancelButton() {
		 return cancelButton.isDisplayed();
	    }

   public void clickOnPopupSaveButton() {
	   saveButton.click();		
	}
   public void clickOnPopupCancelButton() {
	   cancelButton.click();
   }
   public boolean validateErrorMsg( ) {
	   return errorMsg.isDisplayed();
   }
   public boolean recordingsValidation() {
		
		return recordingsBox.isDisplayed();
	}
   public String classTopicEnter() {
		
 		return classTopic.getText();
   }
  
   //Search Box
   public void clickOnSearchTextBox() {
   	       searchBox.click();
   }
public boolean statusValidation() {
	
	return status.isEnabled();
}
public boolean commentsValidation() {
	
	return commentsBox.isDisplayed();
}
public boolean notesValidation() {
	
	return notesBox.isDisplayed();
}




 

public void clickOnEditIcon(int recordsPerPage) throws InterruptedException {
	Thread.sleep(2000);
	for (int i = 1; i <= recordsPerPage; i++) {
		if (i == 1) {
			WebElement rowEditIcon = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-class/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["+ i +"]/td[5]/div/span/button[1]/span[1]"));
			rowEditIcon.click();
			break;
		}
	}
}
public void clickOnDeleteIcon(int recordsPerPage) throws InterruptedException {
	Thread.sleep(2000);
	for (int i = 1; i <= recordsPerPage; i++) {
		if (i == 1) {
			WebElement rowEditIcon = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-class/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["+ i +"]/td[5]/div/span/button[2]/span[1]"));
			rowEditIcon.click();
			break;
		}
	}
}
public String getProgramRequiredMsg() {
	return classRequiredMsg.getText();
}

public void validateAddProgramSuccess() throws Exception {
	try {
		WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Class Created Successfully')]")));
		
		WebElement successSummary = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-class/p-toast/div/p-toastitem/div/div/div/div[1]"));
		System.out.println("successSummary:" + successSummary.getText());
		Assert.assertEquals(successSummary.getText(), "Successful");
		
		WebElement successDetail = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-class/p-toast/div/p-toastitem/div/div/div/div[2]"));
		System.out.println("successDetail:" + successDetail.getText());
		Assert.assertEquals(successDetail.getText(), "Class Created Successfully");
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception("Error while waiting for the add class success notification to appear: " + e.getMessage());
	}
}

public void validateEditProgramSuccess() throws Exception {
	try {
		WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Program Updated')]")));
		
		WebElement successSummary = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[1]"));
		System.out.println("successSummary:" + successSummary.getText());
		Assert.assertEquals(successSummary.getText(), "Successful");
		
		WebElement successDetail = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[2]"));
		System.out.println("successDetail:" + successDetail.getText());
		Assert.assertEquals(successDetail.getText(), "Class Updated");
		
	} catch (Exception e) {
		throw new Exception("Error while waiting for the edit class success notification to appear: " + e.getMessage());
	}
}

public void validateDeleteClassSuccess() throws Exception {
	try {
		WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Class Deleted')]")));
		
		WebElement successSummary = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-class/p-toast/div/p-toastitem/div/div/div/div[1]"));
		System.out.println("successSummary:" + successSummary.getText());
		Assert.assertEquals(successSummary.getText(), "Successful");
		
		WebElement successDetail = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-class/p-toast/div/p-toastitem/div/div/div/div[2]"));
		System.out.println("successDetail:" + successDetail.getText());
		Assert.assertEquals(successDetail.getText(), "Class Deleted");
		
	} catch (Exception e) {
		throw new Exception("Error while waiting for the delete class success notification to appear: " + e.getMessage());
	}
}

public boolean isNextPageAvailable() {
return btn_Pagination_right.isEnabled() && btn_Pagination_right.isDisplayed();
}
public void clickNextPageIfEnabled() {
if (nextright().isEnabled()) {
    System.out.println("Next button is enabled, clicking...");
    clickNextPage();
} else {
    System.out.println("Next button is disabled");
}
}
public void clickPreviousPageIfEnabled() {
if (btn_previous().isEnabled()) {
    System.out.println("Previous button is enabled, clicking...");
    clickPreviousPage();
} else {
    System.out.println("Previous button is disabled");
}
}
private void clickPreviousPage() {

 ((JavascriptExecutor) driver).executeScript("arguments[0].click()", prevButton);
}
public String getCurrentUrl() {
return driver.getCurrentUrl();
}

}


 












