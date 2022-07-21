Feature: ThreadUpdate

  Scenario: POST - Thread | Update Existing Data
    Given Get token from login | ThreadUpdate
    When Set method POST at api endpoints | ThreadUpdate
    And Send method POST HTTP request | ThreadUpdate
    And Receive valid HTTP response code 200 | ThreadUpdate
    And Receive valid message data thread succesfully updated | ThreadUpdate
    Then Validate data thread updated | ThreadUpdate