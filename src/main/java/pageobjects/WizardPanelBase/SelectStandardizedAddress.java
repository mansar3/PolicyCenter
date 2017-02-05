package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public abstract class SelectStandardizedAddress<T extends SelectStandardizedAddress> extends CenterPanelBase
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

	public T selectAddressForCreateAccount(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(" + row + ") td:nth-of-type(1) a"));
		return (T)this;
	}

	/**
	 * @param row number among verified addresses
	 * @return a CreateAccount page object
	 */
	public T selectVerifiedAddressForCreateAccount(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("a[id='FP_VerifiedAddressSelectionPopup:" + row + ":_Select']"));
		return (T)this;
	}

	public T selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		sh.waitForNoMask(5);

		if(sh.isDisplayed(by.matchedAddress) && sh.getText(By.xpath(".//*[@id='FP_VerifiedAddressSelectionPopup:0-body']//div[text() = 'Successful Verification']/../following-sibling::td[2]")).length() > 1)
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return (T)this;
	}
	public T selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		sh.waitForNoMask(5);

		if(sh.isDisplayed(by.matchedAddress) && sh.getText(By.xpath(".//*[@id='FP_VerifiedAddressSelectionPopup:0-body']//div[text() = 'Successful Verification']/../following-sibling::td[2]")).length() > 1)
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return (T)this;
	}
	public T selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		sh.waitForNoMask();

		if(sh.isDisplayed(by.matchedAddress) && sh.getText(By.xpath(".//*[@id='FP_VerifiedAddressSelectionPopup:0-body']//div[text() = 'Successful Verification']/../following-sibling::td[2]")).length() > 1)
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return (T)this;
	}

	public T selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		sh.waitForNoMask(5);

		if(sh.isDisplayed(by.matchedAddress))
			sh.clickElement(by.matchedAddress);
		else
			sh.clickElement(by.unmatchedAddress);
		return (T)this;
	}

	public T selectAddressForNewAdditionalInterests(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(" + row + ") td:nth-of-type(1) a"));
		return (T)this;
	}
	public T selectAddressForNewAdditionalNamedInsured(int row)
	{
		sh.waitForNoMask(5);
		sh.clickElement(By.cssSelector("[id='FP_VerifiedAddressSelectionPopup:0-body'] tbody>tr:nth-of-type(" + row + ") td:nth-of-type(1) a"));
		return (T)this;
	}
}