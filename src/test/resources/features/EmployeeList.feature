@EmployeeList
Feature: verify search functions at Employee page

  @SearchByJobTitle
  Scenario: Successful Login with single row in the datatable of step
    When I enter "automationfc" into "Username" textbox
    And I enter "orangehrm5@X" into "Password" textbox
    And I click on the "Login" button
    And I click on the "PIM" menu
    And I select "Job Title" dropdown menu by value is "Manual Tester"
    And I click on the "Search" button
    Then Verify search result in the Employee table:
      | Id   | First (& Middle) Name | Last Name | Job Title     | Employment Status | Sub Unit | Supervisor            |
      | 0018 | Alex                  | Dang      | Manual Tester | Active            | DC4      | Huyen Tran,Alex Smith |
      | 0012 | Alisa                 | Phan      | Manual Tester | Active            | DC2      | Alex Smith            |
      | 0079 | Anna                  | Thompson  | Manual Tester | Active            | DC3      | Christina Nguyen      |
