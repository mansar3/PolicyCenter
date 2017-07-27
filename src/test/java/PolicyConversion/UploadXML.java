package PolicyConversion;

import Helpers.CenterSeleniumHelper;
import Helpers.FTPConnector;
import Helpers.MountUtil;
import base.BaseTest;
import base.LocalDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Administration.ImportLegacyRenewalData;
import pageobjects.NorthPanel;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by aansari on 5/23/17.
 */
public class UploadXML extends BaseTest
{
	// POC test to see if xml upload is possible
	@Test(priority = 1, groups = "XML Upload")
	public void uploadXML()
	{
			RemoteWebDriver driver = LocalDriverManager.getRemoteDriver();
			CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

			// Get Driver and Instantiate Helper
			if(xmls == null)
				Assert.fail("No Files found.");
			else
				System.out.println("Xmls in folder are: " + String.valueOf(xmls.length));

			for(File file : xmls)
			{
				if(!file.getAbsolutePath().contains(".xml"))
					continue;

				ImportLegacyRenewalData imr = new NorthPanel(sh).administration.clickImportLegacyRenewalData();
				//imr.uploadFile(xmlFilepath)
				imr
				.uploadFile(file.getPath())
				.clickFinish();

			}


			System.out.println("~~~~~~~XML File Uploaded Successfully~~~~~~~~");
	}

	@Test (dependsOnMethods = "uploadXML")
	public void moveFile()
	{
		MountUtil.moveXML(xmlDirectory, oldXML);
	}

	@Test(groups = "ftp",priority = 0)
	public void ftpFile()
	{
		File file = new File(xmlFilepath);
		System.out.println("File path is: " + xmlFilepath);
		if(!file.exists())
			Assert.fail("XML File does not exist here, please check the path.");
		System.out.println("Beginning FTP file transfer");
		FTPConnector ftpc = new FTPConnector();
		ftpc.connector(xmlFilepath,super.file);
	}

	@Test
	public void pwdTest() throws Exception
	{
		String cmd = "pwd";
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(cmd);
		pr.waitFor();
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while ((line=buf.readLine())!=null) {
		System.out.println(line);
		}
	}

}
