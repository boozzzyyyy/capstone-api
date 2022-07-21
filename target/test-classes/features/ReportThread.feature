Feature: ReportThread

  Scenario: GET - Thread | Get List Reported Thread
    Given Get token from login | ReportThread
    When Set method GET at api endpoints | ReportThread
    And Send method GET HTTP request | ReportThread
    And Receive valid HTTP response code 200 | ReportThread
    Then Receive valid message data thread reported | ReportThread