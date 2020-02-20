@SmokeTest
  Feature: Login Customer
    This feature deals with the admin page accessibility and navigations

    Scenario: Login customer user and navigate to all pages
      Given logged in as customer user
      And navigate to Delivery Status page

      And navigate to History page
      And navigate to CDSS Profile page
      And navigate to Customer Settings page
      And navigate to Customer Notification page

      Then Customer Logout page