Feature: ThreadGetSaveThread

  Scenario: GET - Thread | Get List Data Thread Saved
    Given Get token from login | ThreadGetSaveThread
    When Set method GET at api endpoints | ThreadGetSaveThread
    And Send method GET HTTP request | ThreadGetSaveThread
    And Receive valid HTTP response code 200 | ThreadGetSaveThread
    Then Receive valid data thread succesfully | ThreadGetSaveThread