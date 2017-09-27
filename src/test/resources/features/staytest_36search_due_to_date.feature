Feature: Displaying prices
Scenario: verify pricing of the stay on the result page
Given I am on the fourstay login page
And I enter email "testscooper@test.mail.com"
And I enter password "password"
And I click on the login button
And Input school name "Georgetown university";
Then the results should contain prices