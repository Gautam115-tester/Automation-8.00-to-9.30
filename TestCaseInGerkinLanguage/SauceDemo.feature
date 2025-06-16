Feature: Login

@saucedemo
  Scenario: Verify the functionality of login
    Given user launch edge browser.
    And user navigate to saucedemo site.
    When user enter "standard_user" in username field.
    And user enter "secret_sauce" in password field.
    And user click on login button.
    Then validate user login by checking url.
    And close edge browser.
    
    # Given --> pre condition
    # when --> test condition
    # then --> validation and post condition.
    # scenario --> ek functionality with only one data.
    # scenario outline --> ek functionality with multi data.
