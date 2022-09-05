package com.naduni18.imple;

import com.naduni18.page.DropDowns;
import io.cucumber.java.en.When;

import java.io.IOException;

public class DropDownDef {

    @When("user select value in {string} dropdown in page")
    public void userSelectValueInDropdownInPage(String string) throws IOException {
        DropDowns.user_select_value_in_dropfown(string);
    }

}
