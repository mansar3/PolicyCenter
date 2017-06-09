package base;

import Helpers.CenterSeleniumHelper;
import Helpers.DBUtil;
import Helpers.MountUtil;
import Helpers.SessionInfo;
import com.opencsv.CSVWriter;
import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.xml.XmlTest;
import pageobjects.Logon;
import pageobjects.WizardPanelBase.CenterPanelBase;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class BaseTest
{
	protected static String screenShotDirectory = "target/ScreenShots/",
			accountNumber,
			userName,
			passWord;
	private File screenShotFolder = new File(screenShotDirectory);
	protected static SessionInfo sessionInfo;
	protected String dateString;
	private static Boolean local;
	protected static Boolean db;
	private static Boolean sendEmail;
    protected String errorReportDirectory;
	protected WebDriver driver;
	public final Logger logger = LoggerFactory.getLogger(getClass());
	private String lastLoggedMessage;
	public String 	//filePathBase = "\\\\FLHIFS1\\General\\ConversionData\\Error Report\\",
			filePathBase = FileSystemView.getFileSystemView().getHomeDirectory().toString() + "/Desktop/", //+"/Desktop/",
			timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());;
	public String filePath= filePathBase + "TestResult" + timeStamp + ".csv";
	public static String policyFolder, lastPage,
	policyDirectory = "ConversionPolicies-20170607_1",
	xmlFilepath,file;

	@Parameters({"environment", "local", "threads","userName","passWord","sendEmail", "sharedFolder", "database"})
	@BeforeSuite
	public void beforeSuite(XmlTest xml, @Optional("151") String environment, @Optional("true") Boolean local, @Optional("20") int threads,
							@Optional("su") String userName, @Optional("su") String passWord, @Optional("false") Boolean sendEmail,
							@Optional("false")Boolean sharedFolder, @Optional("false")Boolean database)
	{
		xml.getSuite().setThreadCount(threads);
		db = database;
		FileUtils.deleteQuietly(screenShotFolder);
		screenShotFolder.mkdir();
		sessionInfo = new SessionInfo(environment, setCapabilities(), setGridHub());
		this.local = local;
		this.userName = userName;
		this.passWord = passWord;
		this.sendEmail = sendEmail;
		assert sessionInfo.capabilities != null;
		assert sessionInfo.gridHub != null;
		if(new File(filePath).exists())
			new File(filePath).delete();
		if(SystemUtils.IS_OS_MAC)
			errorReportDirectory =  "\\\\FLHIFS1\\General\\ConversionData\\FLHO3-20170119_114257\\Error Report\\";
		else
			errorReportDirectory = "/Volumes/General/ConversionData/FLHO3-20170119_114257/Error Report/";

		if (sharedFolder)
		{
			policyFolder = MountUtil.mountSharedFolder();
		}
		else
		{
			policyFolder = FileSystemView.getFileSystemView().getHomeDirectory().toString()
					+ "/Downloads/" +
					policyDirectory;
		}
		file ="RENW GW - Control File_" +  new SimpleDateFormat("yyyy_MM_dd").format(new Date()) + ".xml";
		 xmlFilepath= policyFolder + "//" + file + "//";
		//new UploadXML().uploadXML();

	}

	@BeforeMethod
	public void beforeMethod()
	{
		DateTime date = new DateTime();
		dateString = date.toString("MMddhhmmss");

		System.out.println(new DateTime().toString());
		// users: conversion2,mcoad
		String user = userName, pwd = passWord;
		WebDriver driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
		Logon logon = new Logon(new CenterSeleniumHelper(driver), sessionInfo);
		logon.load();
		logon.isLoaded();
		logon.login(user, pwd);
		log("Logged in as: " + user + "\nPassword: " + pwd);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult testResult, Object[] parameters)
	{
		if(parameters.length == 0)
			return;
		LinkedHashMap<String, String> eai = (LinkedHashMap<String,String>) parameters[0];
		String[] headers = {"Result", "Account Number", "Legacy Policy Number", "Effective Date", "Policy Type", "Base State","Premium Variation", "Year Built", "Construction Type", "Dwelling Limit",
				"Territory Code", "AOP Deductible", "WhenSafe Percentage", "Last Page Visited","Total Annualized Premium", "ScreenShot","Submitted for Approval", "GW Warnings"};
		String[] dbHeaders = {"Result", "Account Number", "Legacy Policy Number", "Effective Date", "Policy Type", "Base State", "Annualized Total Cost", "Year Built", "Construction Type", "Dwelling Limit",
				"Territory Code", "Section I Deductibles - AOP", "WhenSafe - %", "Last Page Visited", "Annualized Total Cost", "Submitted for Approval", "DataSet", "MachineName"};
		WebDriver driver = LocalDriverManager.getDriver();
//		driver = LocalDriverManager.getDriver();

		if (testResult.getStatus() != ITestResult.SUCCESS) {

			String screenshotName = takeScreenShot(driver);
			String[] csvInput =  errorReportingInfo(eai,false).clone();
			Map<String, String> dbInput = errorReportingInfoDb(eai, dbHeaders, false);
			csvInput[15] = screenshotName;

			CSVWriter writer;
			try
            {
                if (!new File(filePath).exists())
                {
					writer = new CSVWriter(new FileWriter(filePath));
					writer.writeNext(headers);
				} else
					writer = new CSVWriter(new FileWriter(filePath, true));
			}
			catch (IOException e)
            {
				writer = null;
				e.printStackTrace();
			}
			writer.writeNext(csvInput);
			if (db)
			{
				dbInput.put("ScreenShot", screenshotName);
				dbInput.put("StackTrace", testResult.getThrowable().getMessage());
				dbInput.put("MethodName", testResult.getMethod().getMethodName());
				DBUtil.insertIntoResultsTable(dbInput);
			}
			try {
				writer.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			System.out.println("\n'" + testResult.getMethod().getMethodName() + "' Failed.\n");
		}
		else if (testResult.getStatus() == ITestResult.SUCCESS)
		{
			String[] csvInput = errorReportingInfo(eai, true).clone();
			Map<String, String> dbInput = errorReportingInfoDb(eai, dbHeaders, true);

			CSVWriter writer;
			try
			{
				if(!new File(filePath).exists())
				{
					writer = new CSVWriter(new FileWriter(filePath));
					writer.writeNext(headers);
				}

				else
					writer = new CSVWriter(new FileWriter(filePath,true));
			}
			catch(IOException e)
			{
				writer = null;
				e.printStackTrace();
			}
			writer.writeNext(csvInput);
			if (db)
			{
				DBUtil.insertIntoResultsTable(dbInput);
			}
			try
            {
				writer.close();
			}
			catch (IOException e)
            {
				e.printStackTrace();
			}
		}
		if (driver != null)
			driver.quit();
	}

	protected URL setGridHub()
	{
		URL gridHub = null;
		try
		{
			// New Dockers URL
			//gridHub = new URL("http://10.0.10.141:4444/wd/hub");
			// Old Dockers URL
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
		WebDriver driver;
		if(!local)
		{
			driver = new RemoteWebDriver(gridHub, capabilities);
		}
		else{
			driver = new FirefoxDriver(capabilities);
		}
		driver.manage().window().setSize(new Dimension(2048, 3072));
		//driver.manage().window().maximize();
		LocalDriverManager.setWebDriver(driver);
		return LocalDriverManager.getDriver();
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
		//return Arrays.stream(arr).anyMatch(t->t.equals(flag));
		for(String a : arr)
		{

			if(a.equals(flag))
				return true;
		}
		return false;
	}
	public String[] errorReportingInfo(Map<String, String> eai, boolean result)
	{
		CenterSeleniumHelper sh = new CenterSeleniumHelper(LocalDriverManager.getDriver());
		String[] info;
		if(sh.isDisplayed(By.className("error_icon")))
			info = new String[20 + sh.getElements(By.className("error_icon")).size()];
		else
			info = new String[21];
		//String[] info = new String[25]; //logs = baos.toString().split("\n");
		if(result)
			info[0] = "PASS";
		else
			info[0] = "FAIL";
		if(eai.get("Account Number") != null)
			info[1] = eai.get("Account Number");
		info[2] = eai.get("Legacy Policy Number");
		info[3] = eai.get("Effective Date");
		info[4] = eai.get("Policy Type");
		info[5] = eai.get("Base State");
		if(eai.get("Annualized Total Cost") != null)
			info[6] = String.valueOf(Math.abs(Double.parseDouble(eai.getOrDefault("Total Cost","0")) - Double.parseDouble(eai.get("Annualized Total Cost").replaceAll("[^0-9?!\\.]",""))));
		info[7] = eai.get("Year Built");
		info[8] = eai.get("Construction Type");
		info[9] = eai.get("Dwelling Limit");
		info[10] = eai.get("Territory Code");
		info[11] = eai.get("Section I Deductibles - AOP");
		if(eai.get("Whensafe - %") != null)
			info[12] = eai.get("Whensafe - %");
		else
			info[12] = "NULL";
		if(!result)
			try
			{
				info[13] = sh.getText(CenterPanelBase.CenterPanelBy.title);
			}
			catch(Exception e)
			{
				info[13] = "Last page cannot be obtained";
			}
			finally
			{
				lastPage = info[13];
			}

		if(eai.get("Annualized Total Cost") != null)
			info[14] = eai.get("Annualized Total Cost").replaceAll("[^0-9?!\\.]","");

		if(eai.get("Submitted for Approval") != null)
			info[16] = eai.get("Submitted for Approval");
		if(sh.isDisplayed(By.className("error_icon")))
		{
			String[] warnings = getBannerErrors(sh);
			for(int i = 0; i < warnings.length ; i++)
				info[17 + i] = warnings[i];
		}
		return info;
	}

	public Map<String, String> errorReportingInfoDb(Map<String, String> eai, String[] headers, boolean result)
	{
		CenterSeleniumHelper sh = new CenterSeleniumHelper(LocalDriverManager.getDriver());
		Map<String, String> info = new LinkedHashMap<>();
		int i = 0;
		info.put("Result", (result) ? "PASS" : "FAIL");

		for (String header : headers)
		{
			if (header.equals("Annualized Total Cost") && eai.get("Annualized Total Cost") != null)
			{
				info.put("PremiumVariation", String.valueOf(Math.abs(Double.parseDouble(eai.getOrDefault("Total Cost","0")) -
						Double.parseDouble(eai.get("Annualized Total Cost")
								.replaceAll("[^0-9?!\\.]","")))));
				info.put("TotalAnnualizedPremium", eai.get("Annualized Total Cost").replaceAll("[^\\d?!\\.]",""));
			}
			else if (eai.get(header) != null)
				if (header.equals("Section I Deductibles - AOP"))
				{
					info.put(("AOPDeductible"), eai.get("Section I Deductibles - AOP"));
				}
				else
					info.put(header.replace(" ", ""), eai.get(header));
		}
		try
		{
			String[] warnings = getBannerErrors(sh);
			StringJoiner warningMessages = new StringJoiner(" | ");
			for (String warning : warnings)
			{
				warningMessages.add(warning);
			}
			info.put("GWWarnings", warningMessages.toString().replaceAll("\"", "'"));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		info.put("DataSet", policyFolder);
		info.put("MachineName", System.getenv("USER"));

		if (!result)
		{
			try
			{
				lastPage = sh.getText(CenterPanelBase.CenterPanelBy.title);
			}
			catch(Exception e)
			{
				lastPage = "Last page cannot be obtained";
			}
			info.put("LastPageVisited", lastPage);
		}
		return info;
	}

	public String[] getBannerErrors(CenterSeleniumHelper sh)
	{
		List<WebElement> errors = sh.getElements(By.className("message"));
		String[] bannerText = new String[errors.size()];

		for(int i = 0; i < errors.size(); i++)
		{
			bannerText[i] = errors.get(i).getText();
		}
		return bannerText;

	}

	//AfterSuite to send Email
	@AfterSuite(alwaysRun = true)
	public void emailTestResults() {
		// Only will send if it is parallel and if SendEmail is true
		if (sendEmail) {
			EmailResults.sendEmail(filePath, timeStamp);
		}
		MountUtil.unMountSharedFolder();
	}
}