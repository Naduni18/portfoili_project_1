package com.naduni18.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Base {
    String currentDirectory = System.getProperty("user.dir");
    WebDriver driver;

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", currentDirectory + "\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        options.addArguments("disable-extensions");

        driver = new ChromeDriver(options);

        return driver;
    }
}
