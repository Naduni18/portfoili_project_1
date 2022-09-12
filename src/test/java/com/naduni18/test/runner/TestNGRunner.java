package com.naduni18.test.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.naduni18.core.SoftAssertion;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = "src\\test\\Features", monochrome = true, glue = { "com.naduni18.core",
        "com.naduni18.imple" }, plugin = {
        "pretty", "html:test-output",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json",
        "rerun:target/cucumber-reports/rerun.txt", })
public class TestNGRunner{
    private TestNGCucumberRunner testNGCucumberRunner;
    ExtentReports extent;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        extent = new ExtentReports();


    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        extent.createTest("Test")
                .log(Status.INFO, "Test started");
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Throwable {
        SoftAssertion.assertAll();
        extent.flush();
        testNGCucumberRunner.finish();

    }
}
