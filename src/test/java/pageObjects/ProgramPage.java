package pageObjects;

import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverFactory.BasePage;
import util.LoggerLoad;

public class ProgramPage {
	
	public static final int DISAPPEAR_MEESAGE_WAIT_TIME_IN_SEC = 1;


	WebDriver driver;
	public ProgramPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="program")
	public static WebElement programButton;
	@FindBy(id="logout")
	public static WebElement logoutButton;
	@FindBy(xpath = "//*[text()=\" LMS - Learning Management System \"]")
	public static WebElement appHeader;
    @FindBy(xpath = "//*[text()=\"Add New Program\"]")	
    public static WebElement addNewProgram;
    @FindBy(xpath = "//*[@class=\"p-button-icon pi pi-trash\"]")
    public static WebElement deleteIcon;
    @FindBy(id="filterGlobal")
    public static WebElement searchBox;
    @FindBy(xpath = "//*[@class=\"box\"][1]")
    public static WebElement manageProgramText;
    @FindBy(xpath = "//*[@class=\"p-datatable-footer ng-star-inserted\"]/div")
    public static WebElement footerMessage;
    @FindBy(xpath = "//*[@class=\"p-paginator-current ng-star-inserted\"]")
    public static WebElement numberOfRecordstext;
    @FindBy(xpath = "//*[@class=\"p-datatable-thead\"]//th[1]")
    public static WebElement checkBoxStatus;
    @FindBy(xpath = "//*[@class=\"p-datatable-tbody\"]//td[1]")
    public static List<WebElement> rowCheckBox;

    
    @FindBy(xpath="/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")
	WebElement programNameHeader;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]")
	WebElement programDescriptionHeader;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[4]")
	WebElement programStatusHeader;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[5]")
	WebElement editDeleteHeader;
	
    
    //Add new program
    @FindBy(xpath = "//button[@class=\"mat-focus-indicator mat-menu-item ng-tns-c230-0\"]")
    WebElement addProgram;
    //sort arrows
    @FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]/p-sorticon/i")
	WebElement programNameArrowIcon;
    
    @FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]/p-sorticon/i")
	WebElement programDescriptionArrowIcon;
	
	@FindBy(xpath="/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]/p-sorticon")
	WebElement programStatusArrowIcon;
	
	@FindBy(xpath="//div[@class='p-checkbox-box']")
	WebElement checkBox;


	
	public void clickProgramButton() {
		programButton.click();
	}
	public boolean logoutButtonPresence() {
		return logoutButton.isDisplayed();
	}
	public boolean validateHeader() {
		return appHeader.isDisplayed();
	}
	public String addProgramButtonValidation() {
		return addNewProgram.getText();
	}
	public boolean deleteIconValidation() {
		return deleteIcon.isEnabled();
	}
	public String searchBoxValidation() {
		return searchBox.getText();
	}
	public String validateManageProgram() {
		return manageProgramText.getText();
	}
	public String getFooterMessage() {
		return footerMessage.getText();
	}
	public String numberOfRecordstextValidate() {
		return numberOfRecordstext.getText();
	}
	public boolean checkBoxDefaultStatus() {
		return checkBoxStatus.isEnabled();
	}
	
	public List<WebElement> checkBoxStatusInRows() {
		return rowCheckBox;
	}

	public String validateManageClass() {
		return manageProgramText.getText();
	
	}


	public Object programNameHeaderValidation() {
		return programNameHeader.getText();
	}
	public Object programDescriptionHeaderValidation() {
		return programDescriptionHeader.getText();
	}
	public Object programStatusHeaderValidation() {
		return programStatusHeader.getText();
	}
	public Object editDeleteHeaderValidation() {
		return editDeleteHeader.getText();
	}
	public CharSequence programNameArrowIconValidation() {
		return programNameArrowIcon.getText();
	}
	public CharSequence programDescriptionArrowIconValidation() {
		return programDescriptionArrowIcon.getText();
	}
	public CharSequence programStatusArrowIconValidation() {
		return programStatusArrowIcon.getText();
	}
	
	//Add Program Objects
		@FindBy(xpath="//*[@id='programName']")
		WebElement nameTextField;
		
		@FindBy (xpath="//*[@id=\"programDescription\"]")
		WebElement programDescriptionTextField;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[2]/div[1]/label")
		WebElement namevalidate;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[2]/div[2]/label")
		WebElement description;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[2]/div[3]/div[2]/p-radiobutton/div/div[2]")
		WebElement activeStatus;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[2]/div[3]/div[3]/p-radiobutton/div/div[2]")
		WebElement inActiveStatus;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[3]/button[1]")
		WebElement  cancel;
		
		@FindBy(xpath="//*[@id=\"saveProgram\"]")
		WebElement save;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[2]/div[1]/small")
		WebElement programRequiredMsg;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[2]/div[2]/small")
		WebElement programDescRequiredMsg;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[2]/small")
		WebElement statusMsg;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[2]/div[1]/small")
		WebElement programRequiredMsgSpecialCharacter;
		
		@FindBy(xpath="/html/body/app-root/app-program/p-dialog/div/div/div[2]/div[2]/small")
		WebElement programDescRequiredMsgSpecialCharacter;
		
		public String getprogramDescRequiredMsgSpecialCharacter() {
			return programDescRequiredMsgSpecialCharacter.getText();
		}
		public String getprogramRequiredMsgSpecialCharacter() {
			return programRequiredMsgSpecialCharacter.getText();
		}
		
		public String getStatusMsg() {
			return statusMsg.getText();
		}
		public String getprogramDescRequiredMsg() {
			return programDescRequiredMsg.getText();
		}
		
		public void clearNameTextField() {
			nameTextField.clear();
		}
		public void enterNameTextField(String giveprogramName) {
			nameTextField.sendKeys(giveprogramName);
			//nameTextField.sendKeys(syJava123);
		}
		
		public void enterSpecialOrNumberNameTextField() {
			//nameTextField.sendKeys(giveprogramName);
			nameTextField.sendKeys("123");
		}
		public void enterSpecialCharecterOrNumberProgramDescriptionTextField() {
			programDescriptionTextField.sendKeys("@#$");
		}
		public void clearProgramDescriptionTextField() {
			programDescriptionTextField.clear();
		}
		public void enterProgramDescriptionTextField(String giveProgramDescription) {
			programDescriptionTextField.sendKeys(giveProgramDescription);
		}
		public String programNameValidate() {
			return namevalidate.getText();
		}
		public boolean programTextFieldIsDisplayed() {
			return nameTextField.isDisplayed();
		}
		public String programTextFieldValidate() {
			return nameTextField.getText();
		}
		public String descriptionValidate() {
			return description.getText();
		}
		public boolean descriptionTextFieldIsDisplayed() {
			return programDescriptionTextField.isDisplayed();
		}
		public String descriptionTextFieldValidate() {
			return programDescriptionTextField.getText();
		}
		public boolean activeStatusIsDisplayed() {
			return activeStatus.isDisplayed();
		}
		public boolean inActiveStatusIsDisplayed() {
			return inActiveStatus.isDisplayed();
		}
		public boolean activeStatusIsSelected() {
			return activeStatus.isSelected();
		}
		public boolean inActiveStatusIsSelected() {
			return inActiveStatus.isSelected();
		}
		public void clearActivel() {
			activeStatus.clear();
		}
		public void clearInactive() {
			inActiveStatus.clear();
		}
		public void clickActivel() {
			activeStatus.click();
		}
		public void clickInactive() {
			inActiveStatus.click();
		}
		public boolean cancelIsDisplayed() {
			return cancel.isDisplayed();
		}
		public boolean saveIsDisplayed() {
			return save.isDisplayed();
		}
		public void clickCancel() {
			cancel.click();
		}
		public void clickSave() {
			save.click();
		}
		
		public void clickOnEditIcon(int recordsPerPage) throws InterruptedException {
			Thread.sleep(2000);
			for (int i = 1; i <= recordsPerPage; i++) {
				if (i == 1) {
					WebElement rowEditIcon = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["+ i +"]/td[5]/div/span/button[1]/span[1]"));
					rowEditIcon.click();
					break;
				}
			}
		}
		public void clickOnDeleteIcon(int recordsPerPage) throws InterruptedException {
			Thread.sleep(2000);
			for (int i = 1; i <= recordsPerPage; i++) {
				if (i == 1) {
					WebElement rowEditIcon = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["+ i +"]/td[5]/div/span/button[2]/span[1]"));
					rowEditIcon.click();
					break;
				}
			}
		}
		public String getProgramRequiredMsg() {
			return programRequiredMsg.getText();
		}
		
		public void validateAddProgramSuccess() throws Exception {
			try {
				WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(DISAPPEAR_MEESAGE_WAIT_TIME_IN_SEC));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Program Created Successfully')]")));
				
				WebElement successSummary = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[1]"));
				System.out.println("successSummary:" + successSummary.getText());
				Assert.assertEquals(successSummary.getText(), "Successful");
				
				WebElement successDetail = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[2]"));
				System.out.println("successDetail:" + successDetail.getText());
				Assert.assertEquals(successDetail.getText(), "Program Created Successfully");
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Error while waiting for the add program success notification to appear: " + e.getMessage());
			}
		}
		
		public void validateEditProgramSuccess() throws Exception {
			try {
				WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(DISAPPEAR_MEESAGE_WAIT_TIME_IN_SEC));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Program Updated')]")));
				
				WebElement successSummary = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[1]"));
				System.out.println("successSummary:" + successSummary.getText());
				Assert.assertEquals(successSummary.getText(), "Successful");
				
				WebElement successDetail = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[2]"));
				System.out.println("successDetail:" + successDetail.getText());
				Assert.assertEquals(successDetail.getText(), "Program Updated");
				
			} catch (Exception e) {
				throw new Exception("Error while waiting for the edit program success notification to appear: " + e.getMessage());
			}
		}
		
		public void validateDeleteProgramSuccess() throws Exception {
			try {
				WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(DISAPPEAR_MEESAGE_WAIT_TIME_IN_SEC));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Program Deleted')]")));
				
				WebElement successSummary = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[1]"));
				System.out.println("successSummary:" + successSummary.getText());
				Assert.assertEquals(successSummary.getText(), "Successful");
				
				WebElement successDetail = BasePage.getDriver().findElement(By.xpath("/html/body/app-root/app-program/p-toast/div/p-toastitem/div/div/div/div[2]"));
				System.out.println("successDetail:" + successDetail.getText());
				Assert.assertEquals(successDetail.getText(), "Program Deleted");
				
			} catch (Exception e) {
				throw new Exception("Error while waiting for the delete program success notification to appear: " + e.getMessage());
			}
		}
		public void manageProgramIsDisplayed() {
			
			
		}

}
