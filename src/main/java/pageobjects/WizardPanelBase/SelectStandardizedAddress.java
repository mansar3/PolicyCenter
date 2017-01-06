package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class SelectStandardizedAddress<T extends CenterPanelBase> extends CenterPanelBase
{
	private SelectStandardizedAddressBy by;
	private String addressRows = "[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(2) td:nth-of-type(1) a";

	public  class SelectStandardizedAddressBy extends CenterPanelBy
	{
		final By 	matchedAddress = By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(2) td:nth-of-type(1) a"),
					unmatchedAddress = By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(1) td:nth-of-type(1) a");
	}
	public SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new SelectStandardizedAddressBy();
		expectedPanelTitle = "Select a Standardized Address";
		waitForTitle(sh);
	}
	public SelectStandardizedAddress(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		by = new SelectStandardizedAddressBy();
		expectedPanelTitle = "Select a Standardized Address";
		waitForTitle(sh);
	}

	public CreateAccount selectAddressForCreateAccount(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(" + row + ") td:nth-of-type(1) a"));
		return new CreateAccount(sh);
	}
	public CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		sh.waitForNoMask(5);

		if(sh.isDisplayed(by.matchedAddress))
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return new CreateAccount(sh);
	}
	public NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		sh.waitForNoMask(5);

		if(sh.isDisplayed(by.matchedAddress))
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return new NewAdditionalInterest(sh, path);
	}

	public NewAdditionalNameInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		sh.waitForNoMask(5);

		if(sh.isDisplayed(by.matchedAddress))
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return new NewAdditionalNameInsured(sh, path);
	}

	public NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(" + row + ") td:nth-of-type(1) a"));
		return new NewAdditionalInterest(sh,path);
	}
	public NewAdditionalNameInsured selectAddressForNewAdditionalNamedInsured(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(" + row + ") td:nth-of-type(1) a"));
		return new NewAdditionalNameInsured(sh,path);
	}
}