package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src//test//resources//Demo SkillRary Site//Testing Login.feature"},
glue = {"Definition"},
dryRun = false,
plugin = {"html:testout/Lakshay.html", "json:testout/Lakshay.json", "junit:testout/Lakshay.xml"}
)
//dryrun will not execute the code but will check all the methods


public class DemoSkillRary {

}