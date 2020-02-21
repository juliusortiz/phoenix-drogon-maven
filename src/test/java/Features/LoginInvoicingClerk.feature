@SmokeTest
Feature: Login Invoicing Clerk
  This feature deals with the Invoicing Clerk page accessibility and navigations

  Scenario: Login Invoicing Clerk user and navigate to all pages
    Given logged in as Invoicing Clerk user
    And navigate to View Details page from the dashboard
    And navigate to Invoicing Clerk notification page
    And navigate to Invoicing Clerk Settings page

    Then Logout page