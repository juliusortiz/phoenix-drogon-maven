@SmokeTest3
Feature: Login IRT
  This feature deals with the IRT page accessibility and navigations

  Scenario: Login IRT user and navigate to all pages
    Given logged in as IRT user
    And navigate to In Transit Orders page
    And navigate to Accepted Orders page
    And navigate to Image Submitted page
    And navigate to IRT Settings Page
    And navigate to IRT Notification page

    Then IRT Logout