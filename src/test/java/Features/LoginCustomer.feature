@SmokeTest
  Feature: Login Customer
    This feature deals with the admin page accessibility and navigations

    Scenario: Login customer user and navigate to all pages
      Given logged in as customer user
      And navigate to Customer Delivery Status page
      And navigate to View Delivery Receipt from the Delivery Status
      And navigate to Customer History page
      And navigate to Filter Dropdown from the Customer History page
      And navigate to Today Dropdown from the Customer History page
      #And navigate to View Details from the Customer history page
      And navigate to CDSS Profile page
      And navigate to Customer Settings page
      And navigate to Customer Notification page

      Then Customer Logout page