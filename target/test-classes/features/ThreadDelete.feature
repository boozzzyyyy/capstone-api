Feature: ThreadDelete

  Scenario: DELETE - Thread | Delete Existing Data
    Given Get token from login | ThreadDelete
    When Set method DELETE at api endpoints | ThreadDelete
    And Send method DELETE HTTP request | ThreadDelete
    And Receive valid HTTP response code 200 | ThreadDelete
    Then Receive valid message data thread succesfully deleted | ThreadDelete