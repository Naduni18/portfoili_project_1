package com.naduni18.page;

import com.naduni18.core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static com.naduni18.core.ExcelDataProvider.locatormap;
import static com.naduni18.core.ExcelDataProvider.valuemap;

public class Buttons extends Base {
    //user click on static button,link,radio button or checkbox
    public static void user_click_on_button_in_page(String string) throws IOException {
        try {
            String locator_ = locatormap.get(string);

            WebElement button = (new WebDriverWait(driver, Duration.ofSeconds(120)))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(locator_)));
            button.click();
        }catch (Exception e){
            log.error(e);

            getScreenShotPath(driver);
            throw new AssertionError(e.getMessage());
        }

    }
    //user click on dynamic button,link,radio button or checkbox
    public static void user_click_on_dynamic_button_in_page(String string) throws IOException {
        try{
        String locator_ = locatormap.get(string);
        String value_ = valuemap.get(string);

        String locator_with_attribute = locator_.replace("attribute_val",value_);

        WebElement button = (new WebDriverWait(driver, Duration.ofSeconds(120)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator_with_attribute)));

        button.click();

        }catch (Exception e){
            log.error(e);

            getScreenShotPath(driver);
            throw new AssertionError(e.getMessage());
        }
    }

    //user click on javascript element
    public static void user_click_on_js_element_in_page(String string) throws IOException {
        try {
        String locator_ = locatormap.get(string);

        WebElement button = driver.findElement(By.xpath(locator_));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", button);
        }catch (Exception e){
            log.error(e);

            getScreenShotPath(driver);
            throw new AssertionError(e.getMessage());
        }
    }
}
