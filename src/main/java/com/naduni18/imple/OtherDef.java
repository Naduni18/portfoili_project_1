package com.naduni18.imple;

import com.naduni18.page.Other;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OtherDef {
    @Given("user read data from excelsheet {string}")
    public void user_read_data_from_excelsheet(String string) {
        // Write code here that turns the phrase above into concrete actions
        Other.user_read_all_data_from_excelSheet();
    }
    @Given("browser is open and load url")
    public void browser_is_open_and_load_url() {
        // Write code here that turns the phrase above into concrete actions
        Other.browser_is_open_and_load_the_url();
    }



}
