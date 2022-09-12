package com.naduni18.page;

import com.naduni18.core.Base;
import com.naduni18.core.ConfigFileReader;
import com.naduni18.core.ExcelDataProvider;
import com.naduni18.core.SoftAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

import static com.naduni18.core.ExcelDataProvider.locatormap;
import static com.naduni18.core.ExcelDataProvider.valuemap;

public class Other extends Base {

    //user read all data from excel sheet and store them in a hashmap
    public static void user_read_all_data_from_excelSheet(String sheetname){
        try{
        ExcelDataProvider ep = new ExcelDataProvider();
        ep.getSheetLocatorData(sheetname);
        ep.getSheetValueData(sheetname);
        }catch (Exception e){
            log.error(e);
            throw new AssertionError(e.getMessage());
        }
    }

    //user open given url
    public static void browser_is_open_and_load_the_url(String string) throws IOException {
      try {
          ConfigFileReader configFileReader = new ConfigFileReader();
          Base base = new Base();
          base.initializeDriver();
          driver.get(configFileReader.readProperty(string));
          log.info("browaer is open and load url");
      }catch (Exception e){
          log.error(e);

          getScreenShotPath(driver);
          throw new AssertionError(e.getMessage());
      }
    }
    //user wait for given number of seconds
    public static void user_wait_for_seconds(String string) throws IOException {
        try {
        Integer intval = Integer.parseInt(string)*1000;
        Thread.sleep(intval);
        log.info("user wait for "+string+" seconds");
        }catch (Exception e){
            log.error(e);

            getScreenShotPath(driver);
            throw new AssertionError(e.getMessage());
        }
    }

    //user hover over an element
    public static void user_hover_into_page(String element) throws IOException {
        try{
        String locator_ = locatormap.get(element);
        WebElement ele = (new WebDriverWait(driver, Duration.ofSeconds(120)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator_)));
        //Creating object of an Actions class
        Actions action = new Actions(driver);

//Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
        log.info("user hover on element "+element);
        }catch (Exception e){
            log.error(e);

            getScreenShotPath(driver);
            throw new AssertionError(e.getMessage());
        }
    }
//user verify text on page
    public static void user_check_for_element_text_in_page(String string) throws IOException {
        try {
        String locator_ = locatormap.get(string);
        String value_ = valuemap.get(string);
        WebElement ptag = driver.findElement(By.xpath(locator_));
        SoftAssert softassert = SoftAssertion.get();
        softassert.assertEquals(value_,ptag.getText());
        log.info("user verify element "+string+"for text "+value_);
        }catch (Exception e){
            log.error(e);

            getScreenShotPath(driver);
            throw new AssertionError(e.getMessage());
        }

    }
//close the browser and quit webdriver
    public static void close_browser() throws IOException {
        try{
        driver.close();
        driver.quit();
        log.info("browser closed");
        }catch (Exception e){
            log.error(e);

            getScreenShotPath(driver);
            throw new AssertionError(e.getMessage());
        }
    }
}
