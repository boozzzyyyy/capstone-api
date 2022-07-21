Feature: ReportCategoryGet

  Scenario: GET - Report Category | Get List Data
    Given Get token from login | ReportCategoryGet
    When Set method GET at api endpoints | ReportCategoryGet
    And Send method GET HTTP request | ReportCategoryGet
    And Receive valid HTTP response code 200 | ReportCategoryGet
    Then Receive valid data report category succesfully | ReportCategoryGet