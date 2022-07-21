Feature: ThreadCreate

  Scenario: POST - Thread | Create New Data
    Given Get token from login | ThreadCreate
    When Set method POST at api endpoints | ThreadCreate
    And Send method POST HTTP request | ThreadCreate
    And Receive valid HTTP response code 200 | ThreadCreate
    And Receive valid message data thread succesfully created | ThreadCreate
    Then Validate data thread created | ThreadCreate