Feature: ThreadUndoUpvotes

  Scenario: DELETE - Thread | Undo Up Votes Existing Thread Data
    Given Get token from login | ThreadUndoUpvotes
    When Set method DELETE at api endpoints | ThreadUndoUpvotes
    And Send method DELETE HTTP request | ThreadUndoUpvotes
    And Receive valid HTTP response code 200 | ThreadUndoUpvotes
    Then Receive valid message data thread succesfully undo up voted | ThreadUndoUpvotes