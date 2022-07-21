Feature: ThreadGet

  Scenario: GET - Thread | Get List Data
    Given Get token from login | ThreadGet
    When Set method GET at api endpoints | ThreadGet
    And Send method GET HTTP request | ThreadGet
    And Receive valid HTTP response code 200 | ThreadGet
    Then Receive valid data thread succesfully | ThreadGet