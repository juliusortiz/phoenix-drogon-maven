@SmokeTest
Feature: Login Scheduler
  This feature deals with the Scheduler page accessibility and navigations

  Scenario: Login Scheduler user and navigate to all pages
    Given logged in as Scheduler user
    And navigate to Scheduler Notification page

    Then Scheduler Logout page