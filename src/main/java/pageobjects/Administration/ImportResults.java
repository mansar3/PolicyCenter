package pageobjects.Administration;

import Helpers.CenterSeleniumHelper;

/**
 * Created by aansari on 5/25/17.
 */
public class ImportResults
{
	private CenterSeleniumHelper sh;
	public ImportResults(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		sh.waitForTitle("Import Results");
	}
}
