Feature: Login

  Scenario: Login Test
    Given Navigate to Login Page
    When Login Credentials Populated
    Then Product Category Page Loads

  Scenario: Login Validation Test
    Given Navigate to Login Page
    When Login Credentials Empty
    Then Login Validation Error

  Scenario: Explicitly Failing Test
    Given Navigate to Login Page
    When Login Credentials Empty
    Then Fail Test
