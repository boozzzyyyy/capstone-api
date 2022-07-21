Feature: ThreadUpvotes

  Scenario: POST - Thread | Up Votes Existing Thread Data
    Given Get token from login | ThreadUpvotes
    When Set method POST at api endpoints | ThreadUpvotes
    And Send method POST HTTP request | ThreadUpvotes
    And Receive valid HTTP response code 200 | ThreadUpvotes
    Then Receive valid message data thread succesfully up voted | ThreadUpvotes