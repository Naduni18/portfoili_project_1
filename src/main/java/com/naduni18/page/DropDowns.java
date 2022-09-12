package com.naduni18.page;

import com.naduni18.core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static com.naduni18.core.ExcelDataProvider.locatormap;
import static com.naduni18.core.ExcelDataProvider.valuemap;

public class DropDowns extends Base {
    //user selects value from static dropdown
    public static void user_select_value_in_dropfown(String string) throws IOException {

        try{
        String locator_ = locatormap.get(string);
        String value_ = valuemap.get(string);

        WebElement selectbox = (new WebDriverWait(driver, Duration.ofSeconds(120)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator_)));
        Select dropdown = new Select(selectbox);
        dropdown.selectByVisibleText(value_);
        }catch (Exception e){
            log.error(e);

            getScreenShotPath(driver);
            throw new AssertionError(e.getMessage());
        }
    }
}
