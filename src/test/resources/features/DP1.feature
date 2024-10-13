Feature: Automating Test cases for the warriors team

  @RegressionSuite @SixersSite @SlideNavigations
  Scenario: Count the Number of Slides in Philadelphia Site
    Given I am on the philadelphia sixers site
    When I navigate through the slides
    Then I should capture the total of slides along with the title

