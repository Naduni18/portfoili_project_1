package com.naduni18.core;

import org.testng.asserts.SoftAssert;
public class SoftAssertion {

    public static final SoftAssert softAssert = new SoftAssert();

    public static SoftAssert get() {
        return softAssert;
    }
    public static void assertAll() {
        softAssert.assertAll();
    }
}
