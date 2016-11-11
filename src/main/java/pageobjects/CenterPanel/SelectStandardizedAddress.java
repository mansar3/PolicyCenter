package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectStandardizedAddress extends CenterPanelBase
{
	private SelectStandardizedAddressBy by;
	private String addressRows = "[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(2) td:nth-of-type(1) a";

	public static class SelectStandardizedAddressBy extends CenterPanelBy
	{

	}
	public SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new SelectStandardizedAddressBy();
		expectedPanelTitle = "Select a Standardized Address";
		waitForTitle(sh);
	}

	public CreateAccount selectAddress(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(" + row + ") td:nth-of-type(1) a"));
		return new CreateAccount(sh);
	}
}