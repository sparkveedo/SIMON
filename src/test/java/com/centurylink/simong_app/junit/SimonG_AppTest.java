package com.centurylink.simong_app.junit;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="src/test/resources/features/app_features",//path to the features
        glue = "com.centurylink.simong_app.stepdef",
        strict = false,
        dryRun=false,
        plugin={"json:reports/unitTest/junit/SimonG_AppTest.json", "html:reports/unitTest/html/SimonG_AppTest"},
        tags = {"@newCustomerSearchServiceAddress"})//what tags to include(@)/exclude(~@)
public class SimonG_AppTest {

	
}
