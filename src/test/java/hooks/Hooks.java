package hooks;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.*;

public class Hooks {

	WebDriver driver;
	Properties p;

	@Before
	public void setUp() throws IOException, URISyntaxException {
		try {
		p = BaseClass.getProperties();
		driver = BaseClass.initilizeBrowser();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		}catch(Exception e)
		{
			System.err.println("Page load timeout occurred: " + e.getMessage());
		}
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts =(TakesScreenshot) driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
		}
	}

}
