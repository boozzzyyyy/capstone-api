Feature: ReportCategoryCreate

  Scenario: POST - Report Category | Create New Data
    Given Get token from login | ReportCategoryCreate
    When Set method POST at api endpoints | ReportCategoryCreate
    And Send method POST HTTP request | ReportCategoryCreate
    And Receive valid HTTP response code 200 | ReportCategoryCreate
    And Receive valid message data report category succesfully created | ReportCategoryCreate
    Then Validate data report category created | ReportCategoryCreate