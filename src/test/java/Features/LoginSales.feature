@SmokeTest
Feature: Login Sales
  This feature deals with the Sales page accessibility and navigations

  Scenario: Login Sales user and navigate to all pages
    Given logged in as Sales user
    And navigate to Filter Dropdown from the dashboard
    And navigate to Today Dropdown from the dashboard
    And navigate to Sales History page
    And navigate to Sales Settings page
    And navigate to Sales Notification page

    Then Sales Logout

