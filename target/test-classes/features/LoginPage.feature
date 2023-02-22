Feature: Login to HRM

  @ValidCredentials
  Scenario: Login with valid credentials

    Given User is on Home page
    When User enters username as "Admin"
    And User enters password as "admin123"
    Then User should be able to login successfully


  @InValidCredentials
  Scenario: Login with invalid credentials

    Given User is on Home page
    When User enters username as "Admin1"
    And User enters password as "Admin123"
    Then User should be able to see error message "Invalid credentials"

  @BlankUsername
  Scenario: Login with blank username

    Given User is on Home page
    When User enters username as ""
    And User enters password as "Admin123"
    Then User should be able to see error message "Required" below username

