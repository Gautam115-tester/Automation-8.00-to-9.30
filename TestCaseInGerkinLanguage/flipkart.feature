Feature: search
  @flipkart
  Scenario Outline: verify functionality of search by search data.
    Given user launch firefox browser.
    And user navigate to flipkart site.
    When user search "<searchdata>" in search field.
    Then I verify the title of "<title>" of the page
    And Close firefox browser.

    Examples: 
      | searchdata  | title       |
      | Mobile      | Mobile      |
      | AC          | AC          |
      | Smart Watch | Smart Watch |