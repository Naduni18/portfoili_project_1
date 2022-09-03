package com.naduni18.imple;

import com.naduni18.page.Buttons;
import io.cucumber.java.en.When;

public class ButtonDef {
    @When("user click on {string} in page")
    public void user_click_on_in_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        Buttons.user_click_on_button_in_page(string);
    }
}
