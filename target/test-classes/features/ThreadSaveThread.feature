Feature: ThreadSaveThread

  Scenario: POST - Thread | Report Existing Thread Data
    Given Get token from login | ThreadSaveThread
    When Set method POST at api endpoints | ThreadSaveThread
    And Send method POST HTTP request | ThreadSaveThread
    And Receive valid HTTP response code 200 | ThreadSaveThread
    Then Receive valid message data thread succesfully saved | ThreadSaveThread