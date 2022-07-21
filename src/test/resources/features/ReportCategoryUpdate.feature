Feature: ReportCategoryUpdate

  Scenario: PUT - Report Category | Update Existing Data
    Given Get token from login | ReportCategoryUpdate
    When Set method PUT at api endpoints | ReportCategoryUpdate
    And Send method PUT HTTP request | ReportCategoryUpdate
    And Receive valid HTTP response code 200 | ReportCategoryUpdate
    And Receive valid message data report category succesfully updated | ReportCategoryUpdate
    Then Validate data report category updated | ReportCategoryUpdate