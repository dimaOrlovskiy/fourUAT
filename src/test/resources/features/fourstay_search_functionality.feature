Feature: FourStay Search functionality

Scenario: search accomodation by location, date and beds

Given the user on fourstay home page
When I type school name
And I choose move in date
And i choose move out date
And I choose beds
And I click on search
Then the results are displayed