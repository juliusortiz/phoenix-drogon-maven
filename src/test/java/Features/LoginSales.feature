@SmokeTest1
Feature: Login Sales
  This feature deals with the Sales page accessibility and navigations

  Scenario: Login Sales user and navigate to all pages
    Given logged in as Sales user
    And navigate to Filter Dropdown from the dashboard
    And navigate to Today Dropdown from the dashboard
    And navigate to Products page from the dashboard
    And navigate to View Delivery Receipt from the dashboard
    And navigate to Sales History page
    And navigate to Filter Dropdown from the Sales history page
    And navigate to View Details from the Sales history page
    And navigate to Sales Manage Accounts page
    And navigate to Shippings from Sales Manage Accounts page
    And navigate to Sales Settings page
    And navigate to Sales Notification page

    Then Logout page

