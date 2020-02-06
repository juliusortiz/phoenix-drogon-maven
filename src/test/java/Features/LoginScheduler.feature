@SmokeTest1
Feature: Login Scheduler
  This feature deals with the Scheduler page accessibility and navigations

  Scenario: Login Scheduler user and navigate to all pages
    Given logged in as Scheduler user
    And navigate to Bulk Shipment Type dropdown from the dashboard
    And navigate to Vehicle Code dropdown from the dashboard
    And navigate to TTP dropdown from the dashboard
    And navigate to Dispatcher page
    And navigate to Track Delivery page from the Dispatcher page
    And navigate to Problems Reported Page
    And navigate to Scheduler Settings page
    And navigate to Scheduler notification page


    Then Logout page