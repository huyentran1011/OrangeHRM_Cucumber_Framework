@AndNewEmployee
Feature: Verify functions at Add Employee page

  @AddNewEmployeeAndSearch
  Scenario Outline: Successful add new employee without creating login details then search
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
    When I click on "Employee List" top bar menu
    And I enter EmployeeID into textbox
    And I click on the "Search" button
    Then I see "1" Record Found
    When I logout

    Examples:
      |FirstName  |LastName|
      |Miles     |Musk  |

    @AddNEwEmployeeWithLoginDetails
    Scenario Outline:  Successful add new employee with creating login details then login by new user
      When I enter "automationfc" into "Username" textbox
      And I enter "orangehrm5@X" into "Password" textbox
      And I click on the "Login" button
      And I click on the "PIM" menu
      And I click on the "Add" button
      Then I see "Add Employee" page is displayed
      When I enter "<FirstName>" into a textbox which has placeholder is "First Name"
      And I enter "<LastName>" into a textbox which has placeholder is "Last Name"
      And I click on "Create Login Details" toggle button
      And I enter "<Username>" into "Username" textbox
      And I enter "<Password>" into "Password" textbox
      And I enter "<Password>" into "Confirm Password" textbox
      And I click on the "Save" button
      Then I see the toast message with title is "Success" and content is "Successfully Saved"
      Then I see "Personal Details" page is displayed
      When I logout
      Then I see the "Login" button is displayed
      When I enter "<Username>" into "Username" textbox
      And I enter "<Password>" into "Password" textbox
      And I click on the "Login" button
      Then Dashboard page is displayed

      Examples:
        |FirstName  |LastName|Username|Password|
        |Maverick     |Anderson   |Maverick88|12345678Abc@|