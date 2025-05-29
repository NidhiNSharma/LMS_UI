Feature: Edit icon Validation
 
 Background:
 Given Admin is logged in to LMS Portal

  Scenario Outline: Validate Edit icon in batch page
  	Given Admin is on batch page
    When scenario specified in "<SheetName>" and rownumber <RowNumber> Excel
    Then Admin sees the message in sheetname "<SheetName>" and rownumber <RowNumber>
    Examples: 
     | SheetName  | RowNumber|
     | Edit    |         0|
     | Edit    |         1|
     | Edit    |         2|
     | Edit    |         3|
     | Edit    |         4|
     | Edit    |         5|
 	   | Edit    |         6|
 	   | Edit    |         7|