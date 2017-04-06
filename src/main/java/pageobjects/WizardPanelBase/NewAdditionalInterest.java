package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 12/7/16.
 */
public abstract class NewAdditionalInterest<T extends NewAdditionalInterest> extends CenterPanelBase
{
	private NewAdditionalInterestBy by;

	public NewAdditionalInterest(CenterSeleniumHelper sh,Path path)
	{
		this.sh= sh;
		this.path = path;
		expectedPanelTitle = "New Additional Interest";
		waitForTitleToContain(sh);
		by = new NewAdditionalInterestBy();
		System.out.println("Navigated to page: " + expectedPanelTitle);
	}
	
	public T clickCertificateRequired(String flag)
	{
		sh.clickElement(By.id(by.aiBase + "CertRequired_" + flag .toLowerCase()+ "-inputEl"));

		return (T)this;
	}

	public String getType()
	{
		return sh.getValue(by.type);
	}

	public T setType(String type)
	{
		sh.setText(by.type, type);
		sh.tab();

		return (T)this;
	}
	
	public String getLoanNumber()
	{
		return sh.getValue(by.loanNumber);
	}
	
	public T setLoanNumber(String loanNumber)
	{
		sh.setText(by.loanNumber, loanNumber);
		sh.tab();

		return (T)this;
	}

	public String getFirstName()
	{
		return sh.getValue(by.firstName);
	}
	
	public T setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		sh.tab();

		return (T)this;
	}
	
	public String getLastName()
	{
		return sh.getValue(by.lastName);
	}
	
	public T setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		sh.tab();

		return (T)this;
	}
	
	public String getDateOfBirth()
	{
		return sh.getValue(by.dateOfBirth);
	}
	
	public T setDateOfBirth(String dateOfBirth)
	{
		sh.setText(by.dateOfBirth, dateOfBirth);
		sh.tab();

		return (T)this;
	}
	
	public String getMaritalStatus()
	{
		return sh.getValue(by.maritalStatus);
	}
	
	public T setMaritalStatus(String maritalStatus)
	{
		sh.setText(by.maritalStatus, maritalStatus);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getPrimaryPhone()
	{
		return sh.getValue(by.primaryPhone);
	}
	
	public T setPrimaryPhone(String primaryPhone)
	{
		sh.setText(by.primaryPhone, primaryPhone);
		sh.tab();
		return (T)this;
	}
	
	public String getHomePhone()
	{
		return sh.getValue(by.homePhone);
	}
	
	public T setHomePhone(String homePhone)
	{
		sh.setText(by.homePhone, homePhone);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getWorkPhone()
	{
		return sh.getValue(by.workPhone);
	}
	
	public T setWorkPhone(String workPhone)
	{
		sh.setText(by.workPhone, workPhone);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getMobilePhone()
	{
		return sh.getValue(by.mobilePhone);
	}
	
	public T setMobilePhone(String mobilePhone)
	{
		sh.setText(by.mobilePhone, mobilePhone);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getFaxPhone()
	{
		return sh.getValue(by.faxPhone);
	}
	
	public T setFaxPhone(String faxPhone)
	{
		sh.setText(by.faxPhone, faxPhone);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getPrimaryEmail()
	{
		return sh.getValue(by.primaryEmail);
	}
	
	public T setPrimaryEmail(String primaryEmail)
	{
		sh.setText(by.primaryEmail, primaryEmail);
		sh.tab();

		return (T)this;
	}
	
	public String getSecondaryEmail()
	{
		return sh.getValue(by.secondaryEmail);
	}
	
	public T setSecondaryEmail(String secondaryEmail)
	{
		sh.setText(by.secondaryEmail, secondaryEmail);
		sh.tab();

		return (T)this;
	}
	
	public String getCountry()
	{
		return sh.getValue(by.country);
	}
	
	public T setCountry(String country)
	{
		sh.setText(by.country, country);
		sh.tab();

		return (T)this;
	}
	
	public String getAddress1()
	{
		return sh.getValue(by.address1);
	}
	
	public T setAddress1(String address1)
	{
		sh.setText(by.address1, address1);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	public String getAddress2()
	{
		return sh.getValue(by.address2);
	}
	
	public T setAddress2(String address2)
	{
		sh.setText(by.address2, address2);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	public String getAddress3()
	{
		return sh.getValue(by.address3);
	}
	
	public T setAddress3(String address3)
	{
		sh.setText(by.address3, address3);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getCity()
	{
		return sh.getValue(by.city);
	}
	
	public T setCity(String city)
	{
		sh.setText(by.city, city);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getCounty()
	{
		return sh.getValue(by.county);
	}
	
	public T setCounty(String county)
	{
		sh.setText(by.county, county);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getState()
	{
		return sh.getValue(by.state);
	}
	
	public T setState(String state)
	{
		sh.setText(by.state, state);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getZipCode()
	{
		return sh.getValue(by.zipCode);
	}
	
	public T setZipCode(String zipCode)
	{
		sh.setText(by.zipCode, zipCode);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getAddressType()
	{
		return sh.getValue(by.addressType);
	}
	
	public T setAddressType(String addressType)
	{
		sh.setText(by.addressType, addressType);
		sh.tab();

		return (T)this;
	}
	
	public String getAddressDescription()
	{
		return sh.getValue(by.addressDescription);
	}
	
	public T setAddressDescription(String addressDescription)
	{
		sh.setText(by.addressDescription, addressDescription);
		sh.tab();

		return (T)this;
	}
	
	public String getLicenseNumber()
	{
		return sh.getValue(by.licenseNumber);
	}
	
	public T setLicenseNumber(String licenseNumber)
	{
		sh.setText(by.licenseNumber, licenseNumber);
		sh.tab();

		return (T)this;
	}
	
	public String getLicenseState()
	{
		return sh.getValue(by.licenseState);
	}
	
	public T setLicenseState(String licenseState)
	{
		sh.setText(by.licenseState, licenseState);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public String getSsn()
	{
		return sh.getValue(by.officialID);
	}
	
	public T setSsn(String ssn)
	{
		sh.setText(by.officialID, ssn);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	public T verifyAddress()
	{
		sh.waitForNoMask();
		sh.clickElement(by.verifyAddress);
		sh.waitForNoMask();
		return (T)this;
	}

	
	public T ok()
	{
		sh.clickElement(by.ok);
		return (T)this;
	}
	public T checkForDuplicatesAndReturn()
	{
		sh.clickElement(by.checkForDuplicates);
		sh.waitForNoMask();
		if(sh.isDisplayed(by.returnToNewAdditionalInterest))
			sh.clickElement(by.returnToNewAdditionalInterest);
		sh.waitForNoMask();
		return(T)this;

	}
	public String getCompanyName()
	{
		return sh.getValue(by.companyName);
	}
	
	public T setCompanyName(String companyName)
	{
		sh.setText(by.companyName, companyName);
		sh.tab();

		return (T)this;
	}
	public String getOfficePhone()
	{
		return sh.getValue(by.officePhone);
	}
	
	public T setOfficePhone(String officePhone)
	{
		sh.setText(by.officePhone, officePhone);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	public T cancel()
	{
		sh.clickElement(by.cancel);
		return (T)this;
	}
	public T clickCheckForDuplicates()
	{
		sh.clickElement(by.checkForDuplicates);
		return (T)this;
	}
	public String getFEIN()
	{
		return sh.getValue(by.officialID);
	}

	public T setFEIN(String officialID)
	{
		sh.setText(by.officialID, officialID);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	public T clickSameAddressAsPrimaryNamedInsured()
	{
		sh.clickElement(by.sameAddressAs);
		sh.clickElement(By.id(by.contactDetailsBase + "LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"));
		sh.clickElement(By.id(by.contactDetailsBase + "LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress-textEl"));
		sh.waitForNoMask();

		return (T)this;
	}
	
	
	final class NewAdditionalInterestBy
	{
		final String 	aiBase = "NewAdditionalInterestPopup:ContactDetailScreen:AdditionalInterestInfoDV:",
						contactDetailsBase = "NewAdditionalInterestPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:",
						tabBase = "NewAdditionalInterestPopup:ContactDetailScreen:" ;

		final By	type = By.id(aiBase + "Type-inputEl"),
					loanNumber = By.id(aiBase + "ContractNumber-inputEl"),
					firstName = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"),
					lastName = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"),
					companyName = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:GlobalContactNameInputSet:Name-inputEl"),
					dateOfBirth = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:DateOfBirth-inputEl"),
					maritalStatus = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:MaritalStatus-inputEl"),
					primaryPhone = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:PrimaryPhone-inputEl"),
					officePhone = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:WorkPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),
					homePhone = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:HomePhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),
					workPhone = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:WorkPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),
					mobilePhone =  By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:CellPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),
					faxPhone = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),
					primaryEmail = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:EmailAddress1-inputEl"),
					secondaryEmail = By.id(contactDetailsBase + "PolicyContactRoleNameInputSet:EmailAddress2-inputEl"),
					country = By.id(contactDetailsBase + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"),
					address1 = By.id(contactDetailsBase + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"),
					address2 = By.id(contactDetailsBase + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine2-inputEl"),
					address3 = By.id(contactDetailsBase + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine3-inputEl"),
					city = By.id(contactDetailsBase + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"),
					county = By.id(contactDetailsBase + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl"),
					state = By.id(contactDetailsBase + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"),
					zipCode = By.id(contactDetailsBase + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"),
					addressType = By.id(contactDetailsBase + "AddressType-inputEl"),
					addressDescription = By.id(contactDetailsBase + "AddressDescription-inputEl"),
					licenseNumber = By.id(contactDetailsBase + "LicenseInputSet:LicenseNumber-inputEl"),
					licenseState = By.id(contactDetailsBase  + "LicenseInputSet:LicenseState-inputEl"),
					officialID = By.id(contactDetailsBase + "OfficialIDInputSet:OfficialIDDV_Input-inputEl"),

					verifyAddress = By.id(contactDetailsBase + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:VerifyAddressPickerButton"),
					sameAddressAs = By.id(contactDetailsBase + "LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"),
					// Tabs
					ok = By.id(tabBase+ "ForceDupCheckUpdate-btnInnerEl"),
					cancel = By.id(tabBase + "Cancel-btnInnerEl"),
					checkForDuplicates = By.id(tabBase + "CheckForDuplicates-btnInnerEl"),

					// Matching Contacts
					returnToNewAdditionalInterest = By.id("DuplicateContactsPopup:__crumb__");



					
	}
}
