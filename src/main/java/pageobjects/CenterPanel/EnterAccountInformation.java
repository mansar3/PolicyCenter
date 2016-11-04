package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class EnterAccountInformation extends CenterPanelBase
{
	CenterSeleniumHelper sh;
	EnterAccountInformationBy by;

	public static class EnterAccountInformationBy extends CenterPanelBase.CenterPanelBy{
		private String base_id = "NewAccount:NewAccountScreen:NewAccountSearchDV:";
		final public By companyName = By.id(base_id + "GlobalContactNameInputSet:Name-inputEl"),
						firstName = By.id(base_id + "GlobalPersonNameInputSet:FirstName-inputEl"),
						lastName = By.id(base_id + "GlobalPersonNameInputSet:LastName-inputEl"),
						searchBtn = By.id(base_id + "SearchAndResetInputSet:SearchLinksInputSet:Search"),
						createNewAcctBtn = By.id("NewAccount:NewAccountScreen:NewAccountButton");
	}
	public EnterAccountInformation(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new EnterAccountInformationBy();
		expectedPanelTitle = "Enter Account Information";
		waitForTitle(sh);
	}

	public EnterAccountInformation setCompanyName(String companyName)
	{
		sh.setText(by.companyName, companyName);
		return this;
	}

	public EnterAccountInformation setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		return this;
	}

	public EnterAccountInformation setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		return this;
	}

	public EnterAccountInformation clickSearch()
	{
		sh.clickElement(by.searchBtn);
		return this;
	}

	public EnterAccountInformation clickCreateNewAccount()
	{
		sh.clickElement(by.createNewAcctBtn);
		return this;
	}

	private CreateAccount createNewAccount(String accountType)
	{
		clickCreateNewAccount();
		sh.clickElement(By.id("NewAccount:NewAccountScreen:NewAccountButton:NewAccount_"+accountType+"-itemEl"));
		return new CreateAccount(sh);
	}

	public CreateAccount CreateCompanyAccount()
	{
		return createNewAccount("Company");
	}

	public CreateAccount CreatePersonAccount()
	{
		return createNewAccount("Person");
	}

	public CreateAccount CreateFromAddressBookAccount()
	{
		return createNewAccount("FromAB");
	}
}