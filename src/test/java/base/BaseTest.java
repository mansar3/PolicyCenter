package base;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import Helpers.SessionInfo;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class BaseTest
{
	protected static String screenShotDirectory = "src/test/resources/ScreenShots/";
	protected SessionInfo sessionInfo;
	private Boolean local;
	public final Logger logger = LoggerFactory.getLogger(getClass());
	private String lastLoggedMessage;

	@Parameters({"environment", "local"})
	@BeforeSuite
	public void beforeSuite(@Optional("18") String environment, @Optional("true") Boolean local)
	{
		FileUtils.deleteQuietly(new File("src/test/resources/screenshot"));
		sessionInfo = new SessionInfo(environment, setCapabilities(), setGridHub());
		this.local = local;
		assert sessionInfo.capabilities != null;
		assert sessionInfo.gridHub != null;
	}

	protected URL setGridHub()
	{
		URL gridHub = null;
		try
		{
//			gridHub = new URL("http://172.16.20.72:4444/wd/hub");
			gridHub = new URL("http://localhost:4444/wd/hub");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return gridHub;
	}

	protected void takeScreenshot(WebDriver driver, String directory, String methodName)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try
			{
				FileUtils.copyFile(scrFile, new File(directory + methodName + ".png"));
			}
			catch(java.io.IOException e)
			{
				e.printStackTrace();
			}
	}

	protected DesiredCapabilities setCapabilities()
	{
		DesiredCapabilities capabilities;
		capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("enablePersistentHover", false);
		capabilities.setCapability("ie.ensureCleanSession", true);
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		capabilities.setCapability("seleniumProtocol", "WebDriver");
		capabilities.setCapability("requireWindowFocus", true);
		return capabilities;
	}

	protected WebDriver setupDriver(URL gridHub, DesiredCapabilities capabilities)
	{
		WebDriver driver = null;
		if(!local)
		{
			driver = new RemoteWebDriver(gridHub, capabilities);
		}
		else{
			driver = new FirefoxDriver(capabilities);
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected void failureBehavior(WebDriver driver, String directory, String methodName)
	{
		takeScreenshot(driver, directory, methodName);
	}

	public void log(String message) {
		logger.info(message);
		lastLoggedMessage = message;
	}

	public String getLastLoggedMessage() {
		return lastLoggedMessage;
	}

	protected void takeScreenShot(WebDriver driver)
	{
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String fileName = screenShotDirectory +
				"TestScreenShot" +
				"_" + ((RemoteWebDriver) driver).getCapabilities().getBrowserName() +
				"_" + new DateTime().toString("k-mm-ss");

		try
		{
			FileUtils.moveFile(screenShot, new File(fileName + ".jpg"));
		}
		catch(FileExistsException e)
		{
			try
			{
				FileUtils.moveFile(screenShot, new File(fileName + new DateTime().toString("S") + ".jpg"));
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}