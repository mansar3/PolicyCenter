package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class SelectStandardizedAddress<T extends CenterPanelBase> extends CenterPanelBase
{
	private SelectStandardizedAddressBy by;
	private String addressRows = "[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(2) td:nth-of-type(1) a";

	public  class SelectStandardizedAddressBy extends CenterPanelBy
	{
		final By 	unmatchedAddress = By.xpath(".//*[@id='FP_VerifiedAddressSelectionPopup:0-body']//div[text() = 'User Override']/../preceding-sibling::td//a"),
					matchedAddress =By.xpath(".//*[@id='FP_VerifiedAddressSelectionPopup:0-body']//div[text() = 'Successful Verification']/../preceding-sibling::td//a");
	}
	public SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new SelectStandardizedAddressBy();
		expectedPanelTitle = "Select a Standardized Address";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + expectedPanelTitle);
	}
	public SelectStandardizedAddress(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		by = new SelectStandardizedAddressBy();
		expectedPanelTitle = "Select a Standardized Address";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + expectedPanelTitle);
	}

	public CreateAccount selectAddressForCreateAccount(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(" + row + ") td:nth-of-type(1) a"));
		return new CreateAccount(sh);
	}

	/**
	 * @param row number among verified addresses
	 * @return a CreateAccount page object
	 */
	public CreateAccount selectVerifiedAddressForCreateAccount(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("a[id='FP_VerifiedAddressSelectionPopup:" + row + ":_Select']"));
		return new CreateAccount(sh);
	}

	public CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		sh.waitForNoMask(5);

		if(sh.isDisplayed(by.matchedAddress) && sh.getText(By.xpath(".//*[@id='FP_VerifiedAddressSelectionPopup:0-body']//div[text() = 'Successful Verification']/../following-sibling::td[2]")).length() > 1)
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return new CreateAccount(sh);
	}
	public NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		sh.waitForNoMask(5);

		if(sh.isDisplayed(by.matchedAddress) && sh.getText(By.xpath(".//*[@id='FP_VerifiedAddressSelectionPopup:0-body']//div[text() = 'Successful Verification']/../following-sibling::td[2]")).length() > 1)
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return new NewAdditionalInterest(sh, path);
	}
	public LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		sh.waitForNoMask(5);

		if(sh.isDisplayed(by.matchedAddress) && sh.getText(By.xpath(".//*[@id='FP_VerifiedAddressSelectionPopup:0-body']//div[text() = 'Successful Verification']/../following-sibling::td[2]")).length() > 1)
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return new LocationInformation(sh, path);
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