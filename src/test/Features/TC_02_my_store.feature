#Test Case ID: TC_02
#Summary: my store
#Author: 18naduni@gmail.com

@TCIP-Automation
Feature: TC_02my store
  Scenario: TC_02my store

    Given user read data from excelsheet "TC_02"

  ##Fill web form
    Given browser is open and load url for "base_url_my_store"
    When  user enter "txt_search_box" into textfield
    When  user click on "btn_search" in page
    Then user wait for "5" seconds
    When user click on "btn_product_name" in page
    Then user wait for "10" seconds
    When user click on "icon_plus" in page
    When user click on "icon_plus" in page
    When user click on "btn_color" in page
    When user click on "btn_submit" in page
    Then user wait for "10" seconds
    When user click on "btn_proceed_to_checkout" in page
    Then user wait for "5" seconds
    When user click on "btn_checkout" in page
    Then user wait for "5" seconds
    When user enter "txt_email" into textfield
    When user enter "txt_password" into textfield
    When user click on "btn_login" in page
    Then user wait for "5" seconds
    When user click on "btn_checkout2" in page
    Then user wait for "5" seconds
    When user click on "chk_agree" in page
    When user click on "btn_checkout3" in page
    Then user wait for "5" seconds
    When user click on "btn_shipping" in page
    Then user wait for "5" seconds
    When user click on "btn_confirm" in page
    Then user check element text in "txt_confirm" in page
    Then close browser
