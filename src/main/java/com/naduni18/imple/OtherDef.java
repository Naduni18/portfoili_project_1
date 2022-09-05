package com.naduni18.imple;

import com.naduni18.page.Other;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.naduni18.core.Base.driver;

public class OtherDef {
    @Given("user read data from excelsheet {string}")
    public void user_read_data_from_excelsheet(String string) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Other.user_read_all_data_from_excelSheet(string);
    }
    @Given("browser is open and load url")
    public void browser_is_open_and_load_url() {
        // Write code here that turns the phrase above into concrete actions
        Other.browser_is_open_and_load_the_url();
    }


    @Then("user wait for {string} seconds")
    public void userWaitForSeconds(String string) throws InterruptedException {
        Other.user_wait_for_seconds(string);
    }

    @Then("user hover into {string} in page")
    public void userHoverIntoInPage(String element) {
        Other.user_hover_into_page(element);
    }

    @Then("user check for {string} in page")
    public void userCheckForInPage(String string) {
        Other.user_check_for_element_in_page(string);

    }

    @Then("close browser")
    public void closeBrowser() {
        Other.close_browser();
    }
}
