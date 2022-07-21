Feature: ThreadDownvotes

  Scenario: POST - Thread | Down Votes Existing Thread Data
    Given Get token from login | ThreadDownvotes
    When Set method POST at api endpoints | ThreadDownvotes
    And Send method POST HTTP request | ThreadDownvotes
    And Receive valid HTTP response code 200 | ThreadDownvotes
    Then Receive valid message data thread succesfully down voted | ThreadDownvotes