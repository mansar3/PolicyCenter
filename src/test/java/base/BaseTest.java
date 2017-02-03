package base;

import Helpers.SessionInfo;
import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
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
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class BaseTest
{
	protected static String screenShotDirectory =
			System.getenv("SCREENSHOTS_HOME") == null
					? "src/test/resources/ScreenShots/"
					: System.getenv("SCREENSHOTS_HOME"),
			accountNumber;
	private File screenShotFolder = new File(screenShotDirectory);
	protected SessionInfo sessionInfo;
	private Boolean local;
    protected String errorReportDirectory;
	public final Logger logger = LoggerFactory.getLogger(getClass());
	private String lastLoggedMessage;

	@Parameters({"environment", "local", "threads"})
	@BeforeSuite
	public void beforeSuite(XmlTest xml, @Optional("47") String environment, @Optional("false") Boolean local, @Optional("5") int threads)
	{
		xml.getSuite().setThreadCount(threads);
		FileUtils.deleteQuietly(screenShotFolder);
		screenShotFolder.mkdir();
		sessionInfo = new SessionInfo(environment, setCapabilities(), setGridHub());
		this.local = local;
		assert sessionInfo.capabilities != null;
		assert sessionInfo.gridHub != null;
		if(SystemUtils.IS_OS_MAC)
			errorReportDirectory =  "\\\\FLHIFS1\\General\\ConversionData\\FLHO3-20170119_114257\\Error Report\\";
		else
			errorReportDirectory = "/Volumes/General/ConversionData/FLHO3-20170119_114257/Error Report/";

	}

	protected URL setGridHub()
	{
		URL gridHub = null;
		try
		{
			// Dockers URL
			gridHub = new URL("http://10.50.50.150:4444/wd/hub");
			// VM URL
			//gridHub = new URL("http://172.16.31.94:4444/wd/hub");
			// ubuntu vm
			//gridHub = new URL("http://172.16.35.79:4444/wd/hub");
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
		capabilities = DesiredCapabilities.firefox();
//		capabilities = DesiredCapabilities.internetExplorer();
//		capabilities.setCapability("enablePersistentHover", false);
//		capabilities.setCapability("ie.ensureCleanSession", true);
//		capabilities.setCapability("ignoreProtectedModeSettings", true);
//		capabilities.setCapability("seleniumProtocol", "WebDriver");
//		capabilities.setCapability("requireWindowFocus", true);
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
		LocalDriverManager.setWebDriver(driver);
		return driver;
	}

	protected void failureBehavior(WebDriver driver, String directory, String methodName)
	{
		takeScreenshot(driver, directory, methodName);
	}

	public boolean keyContainsValue(LinkedHashMap<String,String> lhm, String key)
	{
		String value = null;
		try
		{
			value = lhm.get(key);
		}
		catch(Exception e)
		{
			System.out.println("key: " + key + " - does not exist in HashMap");
		}

		return value != null ? true : false;
	}
	public String getLastName(String[] names)
	{
		if(names.length == 1)
			return names[0];
		List<String> suffix = Arrays.asList("B.V.M.", "CFRE", "CLU", "CPA", "C.S.C.", "C.S.J.","D.C.",
		"D.D.", "D.D.S.", "D.M.D.", "D.O.", "D.V.M.", "Ed.D.", "Esq.", "II", "III", "IV", "Inc.",
		"J.D.", "Jr.", "LL.D.", "Ltd.", "M.D.", "O.D.", "O.S.B", "P.C.", "P.E.","Ph.D.", "Ret.", "R.G.S", "R.N.",
		"R.N.C.", "S.H.C.J.", "S.J.", "S.N.J.M.", "Sr.", "S.S.M.O.", "USA", "USAF", "USAFR", "USAR", "USCG", "USMC",
		"USMCR", "USN", "USNR");

		for(String suf:suffix)
			if(suf.toLowerCase().equals( names[names.length -1].toLowerCase() ))
				return getLastName(Arrays.copyOf(names,names.length-1));

		return names[names.length-1];
	}

	public void log(String message) {
		logger.info(message);
		lastLoggedMessage = message;
	}

	public String getLastLoggedMessage() {
		return lastLoggedMessage;
	}

	protected String takeScreenShot(WebDriver driver)
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

		return fileName.substring(fileName.lastIndexOf("/") + 1);
	}
	public boolean isInArray(String[] arr, String flag)
	{
		for(String a : arr)
		{
			if(a.equals(flag))
				return true;
		}
		return false;
	}

}