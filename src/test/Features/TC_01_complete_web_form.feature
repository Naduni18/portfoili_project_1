#Test Case ID: TC_01
#Summary: Complete Web Form
#Author: 18naduni@gmail.com

@TCIP-Automation
Feature: TC_01Complete Web Form
  Scenario: TC_001Complete Web Form

    Given user read data from excelsheet "TC_002"

  ##Login to LGIM User
    Given browser is open and load url
    When user click on "lnk_complete_web_form" in page
    When user enter "txt_first_name" into textfield
    When user enter "txt_last_name" into textfield
    Then user enter "txt_job_title" into textfield
    Then user click on "rbtn_high_school" in page
    Then user click on "chk_sex" in page
    When user select value in "drp_years_of_experience" dropdown in page
    Then user enter "date_picker_date" into textfield
    Then user click on "btn_submit" in page