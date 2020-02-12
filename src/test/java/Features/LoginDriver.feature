@Driver
Feature: Login and navigate driver
  This feature deals with the driver login and page navigations

  Scenario: login driver user and navigate to the pages
    Given logged in as driver user
    And navigate to My Deliveries
    And navigate to My Status
    And Navigate to Report a Problem

    Then logout driver