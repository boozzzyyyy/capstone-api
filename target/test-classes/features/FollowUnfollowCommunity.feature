Feature: FollowUnfollowCommunity

  Scenario: POST - Follow | Unfollow community
    Given Get token from login | FollowUnfollowCommunity
    When Set method POST at api endpoints | FollowUnfollowCommunity
    And Send method POST HTTP request | FollowUnfollowCommunity
    And Receive valid HTTP response code 200 | FollowUnfollowCommunity
    Then Receive valid message community succesfully unfollowed | FollowUnfollowCommunity