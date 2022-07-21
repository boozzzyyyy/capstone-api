Feature: ReportCategoryDetail

  Scenario: GET - Report Category | Get Detail Data
    Given Get token from login | ReportCategoryDetail
    When Set method GET at api endpoints | ReportCategoryDetail
    And Send method GET HTTP request | ReportCategoryDetail
    And Receive valid HTTP response code 200 | ReportCategoryDetail
    Then Receive valid detail data report category succesfully | ReportCategoryDetail