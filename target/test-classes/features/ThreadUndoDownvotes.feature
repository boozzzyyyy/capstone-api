Feature: ThreadUndoDownvotes

  Scenario: DELETE - Thread | Undo Down Votes Existing Thread Data
    Given Get token from login | ThreadUndoDownvotes
    When Set method DELETE at api endpoints | ThreadUndoDownvotes
    And Send method DELETE HTTP request | ThreadUndoDownvotes
    And Receive valid HTTP response code 200 | ThreadUndoDownvotes
    Then Receive valid message data thread succesfully undo down voted | ThreadUndoDownvotes