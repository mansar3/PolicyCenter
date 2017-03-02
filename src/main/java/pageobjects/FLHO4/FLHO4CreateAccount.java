package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4CreateAccount extends CreateAccount<FLHO4CreateAccount> {

    public FLHO4CreateAccount(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    //	public FLHO4CreateAccount setHomePhone(String text)
//	{
//		return super.setHomePhone(text);
//	}
//
//	public String getHomePhone()
//	{
//		return super.getHomePhone();
//	}
//	public FLHO4CreateAccount setPreferredLanguage(String text)
//	{
//		return super.setPreferredLanguage(text);
//	}
//
//	public String getPreferredLanguage()
//	{
//		return super.getPreferredLanguage();
//	}
//	public FLHO4CreateAccount setSsn(String text)
//	{
//		return super.setSsn(text);
//	}
//
//	public String getSsn()
//	{
//		return super.getSsn();
//	}
//	public FLHO4CreateAccount setDescription(String text)
//	{
//		return super.setDescription(text);
//	}
//
//	public String getDescription()
//	{
//		return super.getDescription();
//	}
//	public FLHO4CreateAccount setCounty(String text)
//	{
//		return super.setCounty(text);
//	}
//
//	public String getCounty()
//	{
//		return super.getCounty();
//	}
//	public FLHO4CreateAccount setPrimaryPhone(String text)
//	{
//		return super.setPrimaryPhone(text);
//	}
//
//	public String getPrimaryPhone()
//	{
//		return super.getPrimaryPhone();
//	}
//	public FLHO4CreateAccount setPrimaryEmail(String text)
//	{
//		return super.setPrimaryEmail(text);
//	}
//
//	public String getPrimaryEmail()
//	{
//		return super.getPrimaryEmail();
//	}
//	public FLHO4CreateAccount setSecondaryEmail(String text)
//	{
//		return super.setSecondaryEmail(text);
//	}
//
//	public String getSecondaryEmail()
//	{
//		return super.getSecondaryEmail();
//	}
//	public FLHO4CreateAccount setFaxPhone(String text)
//	{
//		return super.setFaxPhone(text);
//	}
//
//	public String getFaxPhone()
//	{
//		return super.getFaxPhone();
//	}
//	public FLHO4CreateAccount setMobilePhone(String text)
//	{
//		return super.setMobilePhone(text);
//	}
//
//	public String getMobilePhone()
//	{
//		return super.getMobilePhone();
//	}
//	public FLHO4CreateAccount setWorkPhone(String text)
//	{
//		return super.setWorkPhone(text);
//	}
//
//	public String getWorkPhone()
//	{
//		return super.getWorkPhone();
//	}
//	public FLHO4CreateAccount setCountry(String text)
//	{
//		return super.setCountry(text);
//	}
//
//	public String getCountry()
//	{
//		return super.getCountry();
//	}
//	public FLHO4CreateAccount setAddressLine2(String text)
//	{
//		return super.setAddressLine2(text);
//	}
//
//	public String getAddressLine2()
//	{
//		return super.getAddressLine2();
//	}
//	public FLHO4CreateAccount setAddressLine3(String text)
//	{
//		return super.setAddressLine3(text);
//	}
//
//	public String getAddressLine3()
//	{
//		return super.getAddressLine3();
//	}
//	public FLHO4CreateAccount setDateOfBirth(String text)
//	{
//		return super.setDateOfBirth(text);
//	}
//
//	public String getDateOfBirth()
//	{
//		return super.getDateOfBirth();
//	}
    public FLHO4AccountFileSummary clickUpdate()
    {
        super.update();
        return new FLHO4AccountFileSummary(sh);
    }
    //	public FLHO4CreateAccount setFirstName(String text)
//	{
//		return super.setFirstName(text);
//	}
//
//	public String getFirstName()
//	{
//		return super.getFirstName();
//	}
//	public FLHO4CreateAccount setLastName(String text)
//	{
//		return super.setLastName(text);
//	}
//
//	public String getLastName()
//	{
//		return super.getLastName();
//	}
//	public FLHO4CreateAccount setAddressLine1(String text)
//	{
//		return super.setAddressLine1(text);
//	}
//
//	public String getAddressLine1()
//	{
//		return super.getAddressLine1();
//	}
//	public FLHO4CreateAccount setCity(String text)
//	{
//		return super.setCity(text);
//	}
//
//	public String getCity()
//	{
//		return super.getCity();
//	}
//	public FLHO4CreateAccount setState(String text)
//	{
//		return super.setState(text);
//	}
//
//	public String getState()
//	{
//		return super.getState();
//	}
//	public FLHO4CreateAccount setZipCode(String text)
//	{
//		return super.setZipCode(text);
//	}
//
//	public String getZipCode()
//	{
//		return super.getZipCode();
//	}
    public FLHO4SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new FLHO4SelectStandardizedAddress(sh);
    }
    //	public FLHO4CreateAccount setAddressType(String text)
//	{
//		return super.setAddressType(text);
//	}
//
//	public String getAddressType()
//	{
//		return super.getAddressType();
//	}
//	public FLHO4CreateAccount setOrganization(String text)
//	{
//		return super.setOrganization(text);
//	}
//
//	public String getOrganization()
//	{
//		return super.getOrganization();
//	}
//
//	public FLHO4CreateAccount setProducerCode(String text)
//	{
//		return super.setProducerCode(text);
//	}
//
//	public String getProducerCode()
//	{
//		return super.getProducerCode();
//	}
//	public FLHO4CreateAccount clickProducerCode()
//	{
//		return super.clickProducerCode();
//	}
    public FLHO4Organizations clickOrganizationSearch()
    {
        super.organizationSearch();
        return new FLHO4Organizations(sh);
    }
//	public FLHO4CreateAccount clickProducerCodeDropdown()
//	{
//		return super.clickProducerCodeDropdown();
//	}




}
