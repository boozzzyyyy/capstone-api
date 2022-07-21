Feature: FollowFollowUser

  Scenario: POST - Follow | Follow user
    Given Get token from login | FollowFollowUser
    When Set method POST at api endpoints | FollowFollowUser
    And Send method POST HTTP request | FollowFollowUser
    And Receive valid HTTP response code 200 | FollowFollowUser
    Then Receive valid message user succesfully followed | FollowFollowUser