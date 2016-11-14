package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class CreateAccount extends CenterPanelBase
{
	private CreateAccountBy by;
	public static class CreateAccountBy extends CenterPanelBase.CenterPanelBy{
		private String	base_id = "CreateAccount:CreateAccountScreen:",
						createAccountDiv = base_id + "CreateAccountDV:",
						baseContactInputSet = createAccountDiv + "CreateAccountContactInputSet:GlobalPersonNameInputSet:",
						baseAddressId = createAccountDiv + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:",
						baseProducerId = createAccountDiv + "ProducerSelectionInputSet:";
		final public By	updateBtn = By.id(base_id + "ForceDupCheckUpdate-btnInnerEl"),
						firstName = By.id(baseContactInputSet + "FirstName-inputEl"),
						lastName = By.id(baseContactInputSet + "LastName-inputEl"),
						address1 = By.id(baseAddressId + "AddressLine1-inputEl"),
						city = By.id(baseAddressId + "City-inputEl"),
						state = By.id(baseAddressId + "State-inputEl"),
						zip = By.id(baseAddressId + "PostalCode-inputEl"),
						verifyAddress = By.id(baseAddressId + "VerifyAddressPickerButton"),
						addressType = By.id(createAccountDiv + "AddressType-inputEl"),
						organization = By.id(baseProducerId + "Producer-inputEl"),
						producerCode = By.id(baseProducerId + "ProducerCode-inputEl");
	}

	public CreateAccount(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new CreateAccountBy();
		expectedPanelTitle = "Create account";
		waitForTitle(sh);
	}

	public AccountFileSummary clickUpdate()
	{
		sh.clickElement(by.updateBtn);
		return new AccountFileSummary(sh);
	}

	//region Contact Input Set

	public CreateAccount setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		return this;
	}

	public CreateAccount setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		return this;
	}

	//endregion

	public CreateAccount setAddressLine1(String address)
	{
		sh.setText(by.address1, address);
//		sh.tab();
		return this;
	}

	public CreateAccount setCity(String city)
	{
		sh.setText(by.city, city);
//		sh.tab();
		return this;
	}

	public CreateAccount setState(String state)
	{
		sh.setText(by.state, state);
		sh.tab();
		return this;
	}

	public CreateAccount setZipCode(String zip)
	{
		sh.setText(by.zip, zip);
//		sh.tab();
		return this;
	}

	public SelectStandardizedAddress clickVerifyAddress()
	{
		sh.waitForNoMask(5);
		sh.clickElement(by.verifyAddress);
		return new SelectStandardizedAddress(sh);
	}

	public CreateAccount setAddressType(String addressType)
	{
		sh.setText(by.addressType, addressType);
		sh.tab();
		return this;
	}

	public CreateAccount setOrganization(String organization)
	{
		sh.setText(by.organization, organization);
		sh.tab();
		return this;
	}

	public CreateAccount setProducerCode(String producerCode)
	{
		sh.setText(by.producerCode, producerCode);
		sh.tab();
		return this;
	}
}