@Smoketest1sige
Feature: Create User
  This feature deals with the admin page in creating a user or role

  Scenario: Login admin user and creating a dispatcher user
    Given logged in as admin user
    And navigate to Manage Users page
    And navigate to Create User page from Manage Users
    And create a dispatcher user from create user page
    Then Logout page

  Scenario: Login as a new dispatcher user
    Given logged in new as dispatcher user
    Then New Dispatcher user Logout

  Scenario: Login admin user and remove the new created dispatcher user
    Given logged in as admin user
    And Delete the new created dispatcher user
    Then Logout page


  Scenario: Login admin user and creating a scheduler user
    Given logged in as admin user
    And navigate to Manage Users page
    And navigate to Create User page from Manage Users
    And create a scheduler user from create user page
    Then Logout page

  Scenario: Login as a new scheduler user
    Given logged in new as scheduler user
    Then New Scheduler user Logout

  Scenario: Login admin user and remove the new created dispatcher user
    Given logged in as admin user
    And Delete the new created scheduler user
    Then Logout page


  Scenario: Login admin user and creating a invoicing clerk user
    Given logged in as admin user
    And navigate to Manage Users page
    And navigate to Create User page from Manage Users
    And create a invoicing clerk user from create user page
    Then Logout page

  Scenario: Login as a new invoicing clerk user
    Given logged in new as invoicing clerk user
    Then New Invoicing Clerk user Logout

  Scenario: Login admin user and remove the new created dispatcher user
    Given logged in as admin user
    And Delete the new created invoicing clerk user
    Then Logout page

