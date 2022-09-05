package com.naduni18.imple;

import com.naduni18.page.TextFields;
import io.cucumber.java.en.When;

import java.io.IOException;

public class TextFieldDef {

    @When("user enter {string} into textfield")
    public void user_enter_into_textfield(String string) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        TextFields.user_enter_text_into_textfield(string);
    }

}
