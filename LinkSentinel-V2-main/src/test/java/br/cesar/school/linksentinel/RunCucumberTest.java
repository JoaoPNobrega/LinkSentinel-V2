package br.cesar.school.linksentinel;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

// Certifique-se que estes imports estão corretos
import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("br.cesar.school.linksentinel.steps") // Onde o JUnit Platform procura testes (e o Cucumber seus steps)
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.cesar.school.linksentinel.steps") // Onde o Cucumber procura os Step Definitions
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features") // Onde o Cucumber procura os .feature files
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/cucumber-reports/Cucumber.json, junit:target/cucumber-reports/Cucumber.xml, html:target/cucumber-reports/cucumber-pretty.html")
public class RunCucumberTest {
    // Esta classe permanece vazia
}