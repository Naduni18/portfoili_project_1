package com.naduni18.core;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Base {
    static String currentDirectory = System.getProperty("user.dir");
    public static WebDriver driver;
    public static Logger log;

    public WebDriver initializeDriver() {
        log = LogManager.getLogger(Base.class.getName());
        System.setProperty("webdriver.chrome.driver", currentDirectory + "\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        options.addArguments("disable-extensions");

        driver = new ChromeDriver(options);


        return driver;
    }

    public static String getScreenShotPath( WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-a");
        String filename = sdf.format(date);
        String destinationfile = currentDirectory + "\\src\\test\\ScreenShots\\" + filename + ".png";
        FileUtils.copyFile(source, new File(destinationfile));
        return destinationfile;
    }
}
