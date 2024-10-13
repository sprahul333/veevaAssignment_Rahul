Feature: Automating Test cases for the warriors team

  Background:
    Given I am on the warriors site

  @RegressionSuite @WarriorsSite @Jackets
  Scenario: Capture the jacket details in the warriors site
    When I click on the jackets link
    Then I should see the jackets page
    And I should see the jackets details

  @RegressionSuite @WarriorsSite @VideoFeeds
  Scenario: Get the Video Feed Details greater than three days
    When I click on the video feed link
    Then I should see the video feed page