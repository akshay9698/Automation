package hooks;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.*;

public class Hooks {

	WebDriver driver;
	Properties p;

	@Before
	public void setUp() throws IOException, URISyntaxException {
		p = BaseClass.getProperties();
		driver = BaseClass.initilizeBrowser();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.close();
	}

}
