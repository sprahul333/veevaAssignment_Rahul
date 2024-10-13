Feature: Automating Test cases for the warriors team

  @RegressionSuite @BullsSite @FooterLinks
  Scenario: Count the Number of Links in Chicago Site
    Given I am on the chicago bulls site
    Then Capture all the hyperlinks in the footer section and store it in a CSV File

