Feature: FollowFollowCommunity

  Scenario: POST - Follow | Follow community
    Given Get token from login | FollowFollowCommunity
    When Set method POST at api endpoints | FollowFollowCommunity
    And Send method POST HTTP request | FollowFollowCommunity
    And Receive valid HTTP response code 200 | FollowFollowCommunity
    Then Receive valid message community succesfully followed | FollowFollowCommunity