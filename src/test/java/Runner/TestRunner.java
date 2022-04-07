package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	
	@RunWith(Cucumber.class)
	
	//Where to find the Cucumber file
	
	@CucumberOptions (features= {"src\\test\\resources\\Login\\Login.feature"},
	glue = {"Definition"},
	dryRun = false
	)
	
	// For glue we give package name
	
	public class TestRunner {	

}