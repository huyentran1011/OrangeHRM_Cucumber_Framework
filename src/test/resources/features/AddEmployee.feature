@AddEmployee
Feature: Verify functions at Add Employee page

  @AddNewEmployeeSuccess
  Scenario Outline: Successful add new employee without creating login details
    When I enter "automationfc" into "Username" textbox
    And I enter "orangehrm5@X" into "Password" textbox
    And I click on the "Login" button
    And I click on the "PIM" menu
    And I click on the "Add" button
    Then I see "Add Employee" page is displayed
    When I enter "<FirstName>" into a textbox which has placeholder is "First Name"
    And I enter "<LastName>" into a textbox which has placeholder is "Last Name"
    And I get value of "Employee Id" textbox
    And I click on the "Save" button
    Then I see the toast message with title is "Success" and content is "Successfully Saved"
    Then I see "Personal Details" page is displayed

    Examples:
      |FirstName  |LastName|
      |John       |Morgan   |

  Scenario Outline: Input Personal Details
    When I enter "<DriverLicenseNum>" into "Driver's License Number" textbox
    And I enter "<LicenseExDate>" into "License Expiry Date" textbox
    And I select "Nationality" dropdown menu by value is "<Nationality>"
    And I select "Marital Status" dropdown menu by value is "<MaritalStatus>"
    And I enter "<DateOfBirth>" into "Date of Birth" textbox
    And I select "Male" radio button
    And I click on the "Save" button at "Personal Details" container
    Then I see the toast message with title is "Success" and content is "Successfully Updated"

    Examples:
      |DriverLicenseNum|LicenseExDate|Nationality|MaritalStatus|DateOfBirth|
      |FL4683422222234 |2026-12-20   |Canadian  |Married       |1998-08-09 |

  Scenario Outline: Input Contact Details
    When I click on the "Contact Details" sub menu
    Then I see "Contact Details" page is displayed
    When I enter "<Street1>" into "Street 1" textbox
    And I enter "<City>" into "City" textbox
    And I enter "<State>" into "State/Province" textbox
    And I enter "<ZipCode>" into "Zip/Postal Code" textbox
    And I select "Country" dropdown menu by value is "<Country>"
    And I enter "<HomePhone>" into "Home" textbox
    And I enter "<Email>" into "Work Email" textbox
    And I click on the "Save" button at "Contact Details" container
    Then I see the toast message with title is "Success" and content is "Successfully Updated"
    When I click on the "Add" button
    And I upload "<UploadFile>" file
    And I click on the "Save" button at "Add Attachment" container
    Then I see the toast message with title is "Success" and content is "Successfully Saved"
    Then I see the "<UploadFile>" file is displayed


    Examples:
      |Street1  |City     |State  |ZipCode|Country       |HomePhone    |Email                |UploadFile                 |
      |150 C|Pensacola|Florida|32502  |American Samoa|(885) 2222 2911|John@gmail.com|EmployeeContactDetails.docx|
