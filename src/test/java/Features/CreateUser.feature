@Smoketest1
Feature: Create User
  This feature deals with the admin page in creating a user or role

  Scenario: Login admin user and creating a dispatcher user
    Given logged in as Admin user
    And navigate to Manage users page
    And navigate to Create user page from Manage Users
    And create a dispatcher user from create user page
    Then admin logout page