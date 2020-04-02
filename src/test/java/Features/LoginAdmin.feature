@Admin
    Feature: Login Admin
    This feature deals with the admin page accessibility and navigations

    Scenario: Login Admin user and navigate to all pages
      Given logged in as Admin user
      And navigate to Users page from the dashboard
      And navigate to Delivery Status page from the dashboard
      And navigate to Manage Users page
      And navigate to Create User page from Manage Users
      And navigate to Statuses page
      And navigate to My Accounts page
      And navigate to Shippings from Manage Accounts page
      And navigate to Delivery Status page
      And navigate to Products from Delivery Status page
      And navigate to Admin Manage Reasons Page
      And navigate to Settings Page
      And navigate to Notification Page

      Then Logout page

