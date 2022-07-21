Feature: ThreadDetail

  Scenario: GET - Thread | Get Detail Data
    Given Get token from login | ThreadDetail
    When Set method GET at api endpoints | ThreadDetail
    And Send method GET HTTP request | ThreadDetail
    And Receive valid HTTP response code 200 | ThreadDetail
    Then Receive valid detail data thread succesfully | ThreadDetail