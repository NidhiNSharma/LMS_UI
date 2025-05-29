@program
Feature: Add New Program 
	Background: Admin is on program page after reaching home
	
 #ValidateProgramDetailsPopupWindow
 Scenario: Validate Program Details Popup window
 Given Admin is on Manage Program Page
 When Admin clicks <A New Program> button
 Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
 
 #ValidateInputFields
 Scenario: Validate input fields and their text boxes in Program details form 
 Given Admin is on Manage Program Page
 When Admin clicks <A New Program> button
 Then Admin should see two input fields and their respective text boxes in the program details window
 
 #ValidateRadioButton
 Scenario: Validate radio button for Program Status 
 Given Admin is on Manage Program Page
 When Admin clicks <A New Program> button
 Then Admin should see two radio button for Program Status
 
 #Emptyformsubmission
 Scenario: Empty form submission 
 Given Admin is on "Program Details" Popup window
 When Admin clicks <Save>button without entering any data
 Then Admin gets a Error message alertProgram
 
 #EnteronlyProgramName
 Scenario Outline: Enter only Program Name
 Given Admin is on "Program Details" Popup window
 When Admin enter value only in ProgramName using "<SheetName>" and <rowNumber> 
 And Admin clicks Save Button
 Then admin gets a message alert for description

  Examples: 
      | SheetName  | rowNumber |
      | Program |   0 |
 
 #ValidateInvalidValuesOntheTextcolumn
 Scenario Outline: Validate invalid values on the text column
 Given Admin is on "Program Details" Popup window
 When Admin enters only numbers or special char in name and desc column "<SheetName>" and <rowNumber> 
 And Admin clicks Save Button
 Then Admin gets a Error message alert SpecialCharecters 
	
  Examples: 
      | SheetName  | rowNumber |
      | Program |  2 |
	

 #ValidateClose(X)icononProgramDetailsform
 Scenario: Validate Close(X) icon on Program Details form
 Given Admin is on "Program Details" Popup window
 When Admin clicks Close(X) Icon on Program Details form
 Then Program Details popup window should be closed without savings

 #ValidateSaveButton 
 Scenario Outline: Validate Save button on Program Details form
 Given Admin is on "Program Details" Popup window
 When Enter all the required fields with valid values "<SheetName>" and <rowNumber>
 And Admin clicks Save Button
 Then Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table

	Examples: 
      | SheetName  | rowNumber |
      | Program |  3 |

 #ValidateCancelbuttononProgramDetailsform
 Scenario: Validate Cancel button on Program Details form
 Given Admin is on "Program Details" Popup window
 When Admin clicks <Cancel>buttonProgram 
 Then Admin can see the Program details popup disappears without creating any program