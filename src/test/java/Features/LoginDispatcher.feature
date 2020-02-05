@SmokeTest
Feature: Login Dispatcher
  This feature deals with the admin page accessibility and navigations

  Scenario: Login dispatcher user and navigate to all pages
    Given logged in as dispatcher user
    And navigate to Problems Reported page
    And navigate to Dispatcher Settings page
    And navigate to Dispatcher Notification page

    Then Logout page
