@SmokeTest
  Feature: Login Admin
    This feature deals with the admin page accessibility and navigations

  Scenario: Login admin user and navigate to all pages
    Given logged in as admin user
    And navigate to status page from the dashboard
    And navigate to customer page from the dashboard
    And navigate to truck driver page from the dashboard
    And navigate to Manage Users page

    Then Logout


