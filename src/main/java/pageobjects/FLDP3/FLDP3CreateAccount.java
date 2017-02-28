package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3CreateAccount extends CreateAccount<FLDP3CreateAccount>
{
	public FLDP3CreateAccount(CenterSeleniumHelper sh)
	{
		super(sh);
	}

//	public FLDP3CreateAccount setHomePhone(String text)
//	{
//		return super.setHomePhone(text);
//	}
//
//	public String getHomePhone()
//	{
//		return super.getHomePhone();
//	}
//	public FLDP3CreateAccount setPreferredLanguage(String text)
//	{
//		return super.setPreferredLanguage(text);
//	}
//
//	public String getPreferredLanguage()
//	{
//		return super.getPreferredLanguage();
//	}
//	public FLDP3CreateAccount setSsn(String text)
//	{
//		return super.setSsn(text);
//	}
//
//	public String getSsn()
//	{
//		return super.getSsn();
//	}
//	public FLDP3CreateAccount setDescription(String text)
//	{
//		return super.setDescription(text);
//	}
//
//	public String getDescription()
//	{
//		return super.getDescription();
//	}
//	public FLDP3CreateAccount setCounty(String text)
//	{
//		return super.setCounty(text);
//	}
//
//	public String getCounty()
//	{
//		return super.getCounty();
//	}
//	public FLDP3CreateAccount setPrimaryPhone(String text)
//	{
//		return super.setPrimaryPhone(text);
//	}
//
//	public String getPrimaryPhone()
//	{
//		return super.getPrimaryPhone();
//	}
//	public FLDP3CreateAccount setPrimaryEmail(String text)
//	{
//		return super.setPrimaryEmail(text);
//	}
//
//	public String getPrimaryEmail()
//	{
//		return super.getPrimaryEmail();
//	}
//	public FLDP3CreateAccount setSecondaryEmail(String text)
//	{
//		return super.setSecondaryEmail(text);
//	}
//
//	public String getSecondaryEmail()
//	{
//		return super.getSecondaryEmail();
//	}
//	public FLDP3CreateAccount setFaxPhone(String text)
//	{
//		return super.setFaxPhone(text);
//	}
//
//	public String getFaxPhone()
//	{
//		return super.getFaxPhone();
//	}
//	public FLDP3CreateAccount setMobilePhone(String text)
//	{
//		return super.setMobilePhone(text);
//	}
//
//	public String getMobilePhone()
//	{
//		return super.getMobilePhone();
//	}
//	public FLDP3CreateAccount setWorkPhone(String text)
//	{
//		return super.setWorkPhone(text);
//	}
//
//	public String getWorkPhone()
//	{
//		return super.getWorkPhone();
//	}
//	public FLDP3CreateAccount setCountry(String text)
//	{
//		return super.setCountry(text);
//	}
//
//	public String getCountry()
//	{
//		return super.getCountry();
//	}
//	public FLDP3CreateAccount setAddressLine2(String text)
//	{
//		return super.setAddressLine2(text);
//	}
//
//	public String getAddressLine2()
//	{
//		return super.getAddressLine2();
//	}
//	public FLDP3CreateAccount setAddressLine3(String text)
//	{
//		return super.setAddressLine3(text);
//	}
//
//	public String getAddressLine3()
//	{
//		return super.getAddressLine3();
//	}
//	public FLDP3CreateAccount setDateOfBirth(String text)
//	{
//		return super.setDateOfBirth(text);
//	}
//
//	public String getDateOfBirth()
//	{
//		return super.getDateOfBirth();
//	}
	public FLDP3AccountFileSummary clickUpdate()
	{
		super.update();
		return new FLDP3AccountFileSummary(sh);
	}
//	public FLDP3CreateAccount setFirstName(String text)
//	{
//		return super.setFirstName(text);
//	}
//
//	public String getFirstName()
//	{
//		return super.getFirstName();
//	}
//	public FLDP3CreateAccount setLastName(String text)
//	{
//		return super.setLastName(text);
//	}
//
//	public String getLastName()
//	{
//		return super.getLastName();
//	}
//	public FLDP3CreateAccount setAddressLine1(String text)
//	{
//		return super.setAddressLine1(text);
//	}
//
//	public String getAddressLine1()
//	{
//		return super.getAddressLine1();
//	}
//	public FLDP3CreateAccount setCity(String text)
//	{
//		return super.setCity(text);
//	}
//
//	public String getCity()
//	{
//		return super.getCity();
//	}
//	public FLDP3CreateAccount setState(String text)
//	{
//		return super.setState(text);
//	}
//
//	public String getState()
//	{
//		return super.getState();
//	}
//	public FLDP3CreateAccount setZipCode(String text)
//	{
//		return super.setZipCode(text);
//	}
//
//	public String getZipCode()
//	{
//		return super.getZipCode();
//	}
	public FLDP3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLDP3SelectStandardizedAddress(sh);
	}
//	public FLDP3CreateAccount setAddressType(String text)
//	{
//		return super.setAddressType(text);
//	}
//
//	public String getAddressType()
//	{
//		return super.getAddressType();
//	}
//	public FLDP3CreateAccount setOrganization(String text)
//	{
//		return super.setOrganization(text);
//	}
//
//	public String getOrganization()
//	{
//		return super.getOrganization();
//	}
//
//	public FLDP3CreateAccount setProducerCode(String text)
//	{
//		return super.setProducerCode(text);
//	}
//
//	public String getProducerCode()
//	{
//		return super.getProducerCode();
//	}
//	public FLDP3CreateAccount clickProducerCode()
//	{
//		return super.clickProducerCode();
//	}
	public FLDP3Organizations clickOrganizationSearch()
	{
		super.organizationSearch();
		return new FLDP3Organizations(sh);
	}
//	public FLDP3CreateAccount clickProducerCodeDropdown()
//	{
//		return super.clickProducerCodeDropdown();
//	}







}
