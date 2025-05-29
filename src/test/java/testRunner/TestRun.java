
package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
					features="src/test/resources/FeaturesFiles/ClassPageFeatures/TC401_ClassPageValidation",
					glue={"stepDefinitions","hooks"},
					//tags="@login and @home and @program",
					monochrome=true,
					//dryRun=false,
					plugin= {"pretty","html:target/cucumber-Report.html",}
		
		)


public class TestRun extends AbstractTestNGCucumberTests{

	
/*	@Override
    
	/*@Override
>>>>>>> 2eddbd7f7b39f0fa73eb825d9528c41456ac7435
	@DataProvider(parallel=true)

	public Object[][] scenarios(){
		
		return super.scenarios();

	
}*/
}