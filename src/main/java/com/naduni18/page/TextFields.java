package com.naduni18.page;

import com.naduni18.core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static com.naduni18.core.ExcelDataProvider.locatormap;
import static com.naduni18.core.ExcelDataProvider.valuemap;

public class TextFields extends Base {
    //user eneter text in to text field
    public static void user_enter_text_into_textfield(String string) throws IOException {
        try{
        String locator_ = locatormap.get(string);
        String value_ = valuemap.get(string);

        WebElement text_box = (new WebDriverWait(driver, Duration.ofSeconds(120)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator_)));

        text_box.clear();
        text_box.sendKeys("");
        text_box.sendKeys(value_);
        }catch (Exception e){
            log.error(e);

            getScreenShotPath(driver);
            throw new AssertionError(e.getMessage());
        }
    }
}
