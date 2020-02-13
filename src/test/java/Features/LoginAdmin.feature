@SmokeTest
  Feature: Login Admin
    This feature deals with the admin page accessibility and navigations

  Scenario: Login admin user and navigate to all pages
    Given logged in as admin user
    And navigate to status page from the dashboard
    And navigate to customer page from the dashboard
    And navigate to Manage Users page
    And navigate to Create User page from Manage Users
    And navigate to Manage Status page
    And navigate to Manage Customer page
    And navigate to Delivery Receipts page
    And navigate to Problems Reported and Backloads Page
    And navigate to Settings Page
    And navigate to Notification Page

    Then Logout page


