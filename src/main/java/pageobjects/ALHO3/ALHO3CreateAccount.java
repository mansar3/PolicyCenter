package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

public class ALHO3CreateAccount extends CreateAccount<ALHO3CreateAccount>
{
	public ALHO3CreateAccount(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public ALHO3CreateAccount setHomePhone(String text)
	{
		return super.setHomePhone(text);
	}

	public String getHomePhone()
	{
		return super.getHomePhone();
	}
	public ALHO3CreateAccount setPreferredLanguage(String text)
	{
		return super.setPreferredLanguage(text);
	}

	public String getPreferredLanguage()
	{
		return super.getPreferredLanguage();
	}
	public ALHO3CreateAccount setSsn(String text)
	{
		return super.setSsn(text);
	}

	public ALHO3CreateAccount setSsnUmasked(String text)
	{
		return super.setSsnUmasked(text);
	}
	public String getSsn()
	{
		return super.getSsn();
	}
	public ALHO3CreateAccount setDescription(String text)
	{
		return super.setDescription(text);
	}

	public String getDescription()
	{
		return super.getDescription();
	}
	public ALHO3CreateAccount setCounty(String text)
	{
		return super.setCounty(text);
	}

	public String getCounty()
	{
		return super.getCounty();
	}
	public ALHO3CreateAccount setPrimaryPhone(String text)
	{
		return super.setPrimaryPhone(text);
	}

	public String getPrimaryPhone()
	{
		return super.getPrimaryPhone();
	}
	public ALHO3CreateAccount setPrimaryEmail(String text)
	{
		return super.setPrimaryEmail(text);
	}

	public String getPrimaryEmail()
	{
		return super.getPrimaryEmail();
	}
	public ALHO3CreateAccount setSecondaryEmail(String text)
	{
		return super.setSecondaryEmail(text);
	}

	public String getSecondaryEmail()
	{
		return super.getSecondaryEmail();
	}
	public ALHO3CreateAccount setFaxPhone(String text)
	{
		return super.setFaxPhone(text);
	}

	public String getFaxPhone()
	{
		return super.getFaxPhone();
	}
	public ALHO3CreateAccount setMobilePhone(String text)
	{
		return super.setMobilePhone(text);
	}

	public String getMobilePhone()
	{
		return super.getMobilePhone();
	}
	public ALHO3CreateAccount setWorkPhone(String text)
	{
		return super.setWorkPhone(text);
	}

	public String getWorkPhone()
	{
		return super.getWorkPhone();
	}
	public ALHO3CreateAccount setCountry(String text)
	{
		return super.setCountry(text);
	}

	public String getCountry()
	{
		return super.getCountry();
	}
	public ALHO3CreateAccount setAddressLine2(String text)
	{
		return super.setAddressLine2(text);
	}

	public String getAddressLine2()
	{
		return super.getAddressLine2();
	}
	public ALHO3CreateAccount setAddressLine3(String text)
	{
		return super.setAddressLine3(text);
	}

	public String getAddressLine3()
	{
		return super.getAddressLine3();
	}
	public ALHO3CreateAccount setDateOfBirth(String text)
	{
		return super.setDateOfBirth(text);
	}

	public String getDateOfBirth()
	{
		return super.getDateOfBirth();
	}

	public ALHO3AccountFileSummary clickUpdate()
	{
		super.update();
		return new ALHO3AccountFileSummary(sh);
	}

	public ALHO3CreateAccount setFirstName(String text)
	{
		return super.setFirstName(text);
	}

	public String getFirstName()
	{
		return super.getFirstName();
	}
	public ALHO3CreateAccount setLastName(String text)
	{
		return super.setLastName(text);
	}

	public String getLastName()
	{
		return super.getLastName();
	}
	public ALHO3CreateAccount setAddressLine1(String text)
	{
		return super.setAddressLine1(text);
	}

	public String getAddressLine1()
	{
		return super.getAddressLine1();
	}
	public ALHO3CreateAccount setCity(String text)
	{
		return super.setCity(text);
	}

	public String getCity()
	{
		return super.getCity();
	}
	public ALHO3CreateAccount setState(String text)
	{
		return super.setState(text);
	}

	public String getState()
	{
		return super.getState();
	}
	public ALHO3CreateAccount setZipCode(String text)
	{
		return super.setZipCode(text);
	}

	public String getZipCode()
	{
		return super.getZipCode();
	}

	public ALHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new ALHO3SelectStandardizedAddress(sh);
	}

	public ALHO3CreateAccount setAddressType(String text)
	{
		return super.setAddressType(text);
	}

	public String getAddressType()
	{
		return super.getAddressType();
	}
	public ALHO3CreateAccount setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}

	public ALHO3CreateAccount setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public ALHO3CreateAccount clickProducerCode()
	{
		return super.clickProducerCode();
	}
	public ALHO3Organizations clickOrganizationSearch()
	{
		super.organizationSearch();
		return new ALHO3Organizations(sh);
	}
	public ALHO3CreateAccount clickProducerCodeDropdown()
	{
		return super.clickProducerCodeDropdown();
	}
}
