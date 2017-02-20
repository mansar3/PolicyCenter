package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6CreateAccount extends CreateAccount<FLHO6CreateAccount>
{
	public FLHO6CreateAccount(CenterSeleniumHelper sh)
	{
		super(sh);
	}

//	public FLHO6CreateAccount setHomePhone(String text)
//	{
//		return super.setHomePhone(text);
//	}
//
//	public String getHomePhone()
//	{
//		return super.getHomePhone();
//	}
//	public FLHO6CreateAccount setPreferredLanguage(String text)
//	{
//		return super.setPreferredLanguage(text);
//	}
//
//	public String getPreferredLanguage()
//	{
//		return super.getPreferredLanguage();
//	}
//	public FLHO6CreateAccount setSsn(String text)
//	{
//		return super.setSsn(text);
//	}
//
//	public String getSsn()
//	{
//		return super.getSsn();
//	}
//	public FLHO6CreateAccount setDescription(String text)
//	{
//		return super.setDescription(text);
//	}
//
//	public String getDescription()
//	{
//		return super.getDescription();
//	}
//	public FLHO6CreateAccount setCounty(String text)
//	{
//		return super.setCounty(text);
//	}
//
//	public String getCounty()
//	{
//		return super.getCounty();
//	}
//	public FLHO6CreateAccount setPrimaryPhone(String text)
//	{
//		return super.setPrimaryPhone(text);
//	}
//
//	public String getPrimaryPhone()
//	{
//		return super.getPrimaryPhone();
//	}
//	public FLHO6CreateAccount setPrimaryEmail(String text)
//	{
//		return super.setPrimaryEmail(text);
//	}
//
//	public String getPrimaryEmail()
//	{
//		return super.getPrimaryEmail();
//	}
//	public FLHO6CreateAccount setSecondaryEmail(String text)
//	{
//		return super.setSecondaryEmail(text);
//	}
//
//	public String getSecondaryEmail()
//	{
//		return super.getSecondaryEmail();
//	}
//	public FLHO6CreateAccount setFaxPhone(String text)
//	{
//		return super.setFaxPhone(text);
//	}
//
//	public String getFaxPhone()
//	{
//		return super.getFaxPhone();
//	}
//	public FLHO6CreateAccount setMobilePhone(String text)
//	{
//		return super.setMobilePhone(text);
//	}
//
//	public String getMobilePhone()
//	{
//		return super.getMobilePhone();
//	}
//	public FLHO6CreateAccount setWorkPhone(String text)
//	{
//		return super.setWorkPhone(text);
//	}
//
//	public String getWorkPhone()
//	{
//		return super.getWorkPhone();
//	}
//	public FLHO6CreateAccount setCountry(String text)
//	{
//		return super.setCountry(text);
//	}
//
//	public String getCountry()
//	{
//		return super.getCountry();
//	}
//	public FLHO6CreateAccount setAddressLine2(String text)
//	{
//		return super.setAddressLine2(text);
//	}
//
//	public String getAddressLine2()
//	{
//		return super.getAddressLine2();
//	}
//	public FLHO6CreateAccount setAddressLine3(String text)
//	{
//		return super.setAddressLine3(text);
//	}
//
//	public String getAddressLine3()
//	{
//		return super.getAddressLine3();
//	}
//	public FLHO6CreateAccount setDateOfBirth(String text)
//	{
//		return super.setDateOfBirth(text);
//	}
//
//	public String getDateOfBirth()
//	{
//		return super.getDateOfBirth();
//	}
	public FLHO6AccountFileSummary clickUpdate()
	{
		super.update();
		return new FLHO6AccountFileSummary(sh);
	}
//	public FLHO6CreateAccount setFirstName(String text)
//	{
//		return super.setFirstName(text);
//	}
//
//	public String getFirstName()
//	{
//		return super.getFirstName();
//	}
//	public FLHO6CreateAccount setLastName(String text)
//	{
//		return super.setLastName(text);
//	}
//
//	public String getLastName()
//	{
//		return super.getLastName();
//	}
//	public FLHO6CreateAccount setAddressLine1(String text)
//	{
//		return super.setAddressLine1(text);
//	}
//
//	public String getAddressLine1()
//	{
//		return super.getAddressLine1();
//	}
//	public FLHO6CreateAccount setCity(String text)
//	{
//		return super.setCity(text);
//	}
//
//	public String getCity()
//	{
//		return super.getCity();
//	}
//	public FLHO6CreateAccount setState(String text)
//	{
//		return super.setState(text);
//	}
//
//	public String getState()
//	{
//		return super.getState();
//	}
//	public FLHO6CreateAccount setZipCode(String text)
//	{
//		return super.setZipCode(text);
//	}
//
//	public String getZipCode()
//	{
//		return super.getZipCode();
//	}
	public FLHO6SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLHO6SelectStandardizedAddress(sh);
	}
//	public FLHO6CreateAccount setAddressType(String text)
//	{
//		return super.setAddressType(text);
//	}
//
//	public String getAddressType()
//	{
//		return super.getAddressType();
//	}
//	public FLHO6CreateAccount setOrganization(String text)
//	{
//		return super.setOrganization(text);
//	}
//
//	public String getOrganization()
//	{
//		return super.getOrganization();
//	}
//
//	public FLHO6CreateAccount setProducerCode(String text)
//	{
//		return super.setProducerCode(text);
//	}
//
//	public String getProducerCode()
//	{
//		return super.getProducerCode();
//	}
//	public FLHO6CreateAccount clickProducerCode()
//	{
//		return super.clickProducerCode();
//	}
	public FLHO6Organizations clickOrganizationSearch()
	{
		super.organizationSearch();
		return new FLHO6Organizations(sh);
	}
//	public FLHO6CreateAccount clickProducerCodeDropdown()
//	{
//		return super.clickProducerCodeDropdown();
//	}







}
