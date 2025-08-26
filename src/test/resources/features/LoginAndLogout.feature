@Login
Feature: verify OrangeHRM Login page

  @VerifyLoginUI
  Scenario: Verify Login page
    Given I see the "Username" textbox is displayed
    Then I see the "Password" textbox is displayed
    Then I see the "Login" button is displayed

  @LoginSuccess
  Scenario: Successful Login with Valid Credentials
    Given I enter "Admin" into "Username" textbox
    When I enter "admin123" into "Password" textbox
    And I click on the "Login" button
    Then Dashboard page is displayed
    When I logout


  @LoginFail
  Scenario Outline: Login fail with outline datable
    Given I enter "<Username>" into "Username" textbox
    When I enter "<Password>" into "Password" textbox
    And I click on the "Login" button
    Then I see the "Login" button is displayed
    When I refresh the current page
    Examples:
      | Username     | Password     |
      |              |              |
      | admin        |              |
      |              | admin123     |
      | abc          | 1bc123       |
