package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3CreateAccount extends CreateAccount<FLMH3CreateAccount> {

    public FLMH3CreateAccount(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    //	public FLMH3CreateAccount setHomePhone(String text)
//	{
//		return super.setHomePhone(text);
//	}
//
//	public String getHomePhone()
//	{
//		return super.getHomePhone();
//	}
//	public FLMH3CreateAccount setPreferredLanguage(String text)
//	{
//		return super.setPreferredLanguage(text);
//	}
//
//	public String getPreferredLanguage()
//	{
//		return super.getPreferredLanguage();
//	}
//	public FLMH3CreateAccount setSsn(String text)
//	{
//		return super.setSsn(text);
//	}
//
//	public String getSsn()
//	{
//		return super.getSsn();
//	}
//	public FLMH3CreateAccount setDescription(String text)
//	{
//		return super.setDescription(text);
//	}
//
//	public String getDescription()
//	{
//		return super.getDescription();
//	}
//	public FLMH3CreateAccount setCounty(String text)
//	{
//		return super.setCounty(text);
//	}
//
//	public String getCounty()
//	{
//		return super.getCounty();
//	}
//	public FLMH3CreateAccount setPrimaryPhone(String text)
//	{
//		return super.setPrimaryPhone(text);
//	}
//
//	public String getPrimaryPhone()
//	{
//		return super.getPrimaryPhone();
//	}
//	public FLMH3CreateAccount setPrimaryEmail(String text)
//	{
//		return super.setPrimaryEmail(text);
//	}
//
//	public String getPrimaryEmail()
//	{
//		return super.getPrimaryEmail();
//	}
//	public FLMH3CreateAccount setSecondaryEmail(String text)
//	{
//		return super.setSecondaryEmail(text);
//	}
//
//	public String getSecondaryEmail()
//	{
//		return super.getSecondaryEmail();
//	}
//	public FLMH3CreateAccount setFaxPhone(String text)
//	{
//		return super.setFaxPhone(text);
//	}
//
//	public String getFaxPhone()
//	{
//		return super.getFaxPhone();
//	}
//	public FLMH3CreateAccount setMobilePhone(String text)
//	{
//		return super.setMobilePhone(text);
//	}
//
//	public String getMobilePhone()
//	{
//		return super.getMobilePhone();
//	}
//	public FLMH3CreateAccount setWorkPhone(String text)
//	{
//		return super.setWorkPhone(text);
//	}
//
//	public String getWorkPhone()
//	{
//		return super.getWorkPhone();
//	}
//	public FLMH3CreateAccount setCountry(String text)
//	{
//		return super.setCountry(text);
//	}
//
//	public String getCountry()
//	{
//		return super.getCountry();
//	}
//	public FLMH3CreateAccount setAddressLine2(String text)
//	{
//		return super.setAddressLine2(text);
//	}
//
//	public String getAddressLine2()
//	{
//		return super.getAddressLine2();
//	}
//	public FLMH3CreateAccount setAddressLine3(String text)
//	{
//		return super.setAddressLine3(text);
//	}
//
//	public String getAddressLine3()
//	{
//		return super.getAddressLine3();
//	}
//	public FLMH3CreateAccount setDateOfBirth(String text)
//	{
//		return super.setDateOfBirth(text);
//	}
//
//	public String getDateOfBirth()
//	{
//		return super.getDateOfBirth();
//	}
    public FLMH3AccountFileSummary clickUpdate()
    {
        super.update();
        return new FLMH3AccountFileSummary(sh);
    }
    //	public FLMH3CreateAccount setFirstName(String text)
//	{
//		return super.setFirstName(text);
//	}
//
//	public String getFirstName()
//	{
//		return super.getFirstName();
//	}
//	public FLMH3CreateAccount setLastName(String text)
//	{
//		return super.setLastName(text);
//	}
//
//	public String getLastName()
//	{
//		return super.getLastName();
//	}
//	public FLMH3CreateAccount setAddressLine1(String text)
//	{
//		return super.setAddressLine1(text);
//	}
//
//	public String getAddressLine1()
//	{
//		return super.getAddressLine1();
//	}
//	public FLMH3CreateAccount setCity(String text)
//	{
//		return super.setCity(text);
//	}
//
//	public String getCity()
//	{
//		return super.getCity();
//	}
//	public FLMH3CreateAccount setState(String text)
//	{
//		return super.setState(text);
//	}
//
//	public String getState()
//	{
//		return super.getState();
//	}
//	public FLMH3CreateAccount setZipCode(String text)
//	{
//		return super.setZipCode(text);
//	}
//
//	public String getZipCode()
//	{
//		return super.getZipCode();
//	}
    public FLMH3SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new FLMH3SelectStandardizedAddress(sh);
    }
    //	public FLMH3CreateAccount setAddressType(String text)
//	{
//		return super.setAddressType(text);
//	}
//
//	public String getAddressType()
//	{
//		return super.getAddressType();
//	}
//	public FLMH3CreateAccount setOrganization(String text)
//	{
//		return super.setOrganization(text);
//	}
//
//	public String getOrganization()
//	{
//		return super.getOrganization();
//	}
//
//	public FLMH3CreateAccount setProducerCode(String text)
//	{
//		return super.setProducerCode(text);
//	}
//
//	public String getProducerCode()
//	{
//		return super.getProducerCode();
//	}
//	public FLMH3CreateAccount clickProducerCode()
//	{
//		return super.clickProducerCode();
//	}
    public FLMH3Organizations clickOrganizationSearch()
    {
        super.organizationSearch();
        return new FLMH3Organizations(sh);
    }
//	public FLMH3CreateAccount clickProducerCodeDropdown()
//	{
//		return super.clickProducerCodeDropdown();
//	}

}
