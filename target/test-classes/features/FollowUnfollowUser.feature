Feature: FollowUnfollowUser

  Scenario: POST - Follow | Unfollow user
    Given Get token from login | FollowUnfollowUser
    When Set method POST at api endpoints | FollowUnfollowUser
    And Send method POST HTTP request | FollowUnfollowUser
    And Receive valid HTTP response code 200 | FollowUnfollowUser
    Then Receive valid message user succesfully unfollowed | FollowUnfollowUser