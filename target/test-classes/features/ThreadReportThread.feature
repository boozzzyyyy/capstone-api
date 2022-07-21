Feature: ThreadReportThread

  Scenario: POST - Thread | Report Existing Thread Data
    Given Get token from login | ThreadReportThread
    When Set method POST at api endpoints | ThreadReportThread
    And Send method POST HTTP request | ThreadReportThread
    And Receive valid HTTP response code 200 | ThreadReportThread
    Then Receive valid message data thread succesfully reported | ThreadReportThread