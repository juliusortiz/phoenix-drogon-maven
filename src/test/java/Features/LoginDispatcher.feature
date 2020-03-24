@Dispatcher
Feature: Login Dispatcher
  This feature deals with the admin page accessibility and navigations

  Scenario: Login dispatcher user and navigate to all pages
    Given logged in as dispatcher user
    And navigate to Delivery Instructions from the dashboard page
    And navigate to Track Delivery page from the dashboard page
    And navigate to Deliveries History
    And navigate to Problems Reported page
    And navigate to Manage Reasons page
    And landed to Backload filter from the dropdown
    And navigate to Partially Accepted filter from the dropdown
    And navigate to Dispatcher Settings page
    And navigate to Dispatcher Notification page

    Then Logout page
