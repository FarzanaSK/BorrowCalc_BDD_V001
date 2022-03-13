package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions ( features = {"src/test/java/features/BorrowCalc.feature"},
glue = "steps",
dryRun = false,
monochrome = true,
plugin= {"pretty","html:reports"}
)

public class BrowserCalcRunner extends AbstractTestNGCucumberTests {

}
 