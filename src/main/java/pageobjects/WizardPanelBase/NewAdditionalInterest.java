package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 12/7/16.
 */
public class NewAdditionalInterest extends CenterPanelBase
{
	private NewAdditionalInterestBy by;

	public NewAdditionalInterest(CenterSeleniumHelper sh,Path path)
	{
		this.sh= sh;
		this.path = path;
		expectedPanelTitle = "New Additional Interest";
		//waitForTitle(sh);
		by = new NewAdditionalInterestBy();
		System.out.println("Navigated to page: " + getTitle());
	}
	
	public NewAdditionalInterest clickCertificateRequired(String flag)
	{
		sh.clickElement(By.id(by.aiBase + "CertRequired_" + flag .toLowerCase()+ "-inputEl"));

		return this;
	}

	public String getType()
	{
		return sh.getValue(by.type);
	}

	public NewAdditionalInterest setType(String type)
	{
		sh.setText(by.type, type);
		sh.tab();

		return this;
	}
	
	public String getLoanNumber()
	{
		return sh.getValue(by.loanNumber);
	}
	
	public NewAdditionalInterest setLoanNumber(String loanNumber)
	{
		sh.setText(by.loanNumber, loanNumber);
		sh.tab();

		return this;
	}

	public String getFirstName()
	{
		return sh.getValue(by.firstName);
	}
	
	public NewAdditionalInterest setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		sh.tab();

		return this;
	}
	
	public String getLastName()
	{
		return sh.getValue(by.lastName);
	}
	
	public NewAdditionalInterest setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		sh.tab();

		return this;
	}
	
	public String getDateOfBirth()
	{
		return sh.getValue(by.dateOfBirth);
	}
	
	public NewAdditionalInterest setDateOfBirth(String dateOfBirth)
	{
		sh.setText(by.dateOfBirth, dateOfBirth);
		sh.tab();

		return this;
	}
	
	public String getMaritalStatus()
	{
		return sh.getValue(by.maritalStatus);
	}
	
	public NewAdditionalInterest setMaritalStatus(String maritalStatus)
	{
		sh.setText(by.maritalStatus, maritalStatus);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getPrimaryPhone()
	{
		return sh.getValue(by.primaryPhone);
	}
	
	public NewAdditionalInterest setPrimaryPhone(String primaryPhone)
	{
		sh.setText(by.primaryPhone, primaryPhone);
		sh.tab();
		return this;
	}
	
	public String getHomePhone()
	{
		return sh.getValue(by.homePhone);
	}
	
	public NewAdditionalInterest setHomePhone(String homePhone)
	{
		sh.setText(by.homePhone, homePhone);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getWorkPhone()
	{
		return sh.getValue(by.workPhone);
	}
	
	public NewAdditionalInterest setWorkPhone(String workPhone)
	{
		sh.setText(by.workPhone, workPhone);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getMobilePhone()
	{
		return sh.getValue(by.mobilePhone);
	}
	
	public NewAdditionalInterest setMobilePhone(String mobilePhone)
	{
		sh.setText(by.mobilePhone, mobilePhone);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getFaxPhone()
	{
		return sh.getValue(by.faxPhone);
	}
	
	public NewAdditionalInterest setFaxPhone(String faxPhone)
	{
		sh.setText(by.faxPhone, faxPhone);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getPrimaryEmail()
	{
		return sh.getValue(by.primaryEmail);
	}
	
	public NewAdditionalInterest setPrimaryEmail(String primaryEmail)
	{
		sh.setText(by.primaryEmail, primaryEmail);
		sh.tab();

		return this;
	}
	
	public String getSecondaryEmail()
	{
		return sh.getValue(by.secondaryEmail);
	}
	
	public NewAdditionalInterest setSecondaryEmail(String secondaryEmail)
	{
		sh.setText(by.secondaryEmail, secondaryEmail);
		sh.tab();

		return this;
	}
	
	public String getCountry()
	{
		return sh.getValue(by.country);
	}
	
	public NewAdditionalInterest setCountry(String country)
	{
		sh.setText(by.country, country);
		sh.tab();

		return this;
	}
	
	public String getAddress1()
	{
		return sh.getValue(by.address1);
	}
	
	public NewAdditionalInterest setAddress1(String address1)
	{
		sh.setText(by.address1, address1);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getAddress2()
	{
		return sh.getValue(by.address2);
	}
	
	public NewAdditionalInterest setAddress2(String address2)
	{
		sh.setText(by.address2, address2);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getAddress3()
	{
		return sh.getValue(by.address3);
	}
	
	public NewAdditionalInterest setAddress3(String address3)
	{
		sh.setText(by.address3, address3);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getCity()
	{
		return sh.getValue(by.city);
	}
	
	public NewAdditionalInterest setCity(String city)
	{
		sh.setText(by.city, city);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getCounty()
	{
		return sh.getValue(by.county);
	}
	
	public NewAdditionalInterest setCounty(String county)
	{
		sh.setText(by.county, county);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getState()
	{
		return sh.getValue(by.state);
	}
	
	public NewAdditionalInterest setState(String state)
	{
		sh.setText(by.state, state);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getZipCode()
	{
		return sh.getValue(by.zipCode);
	}
	
	public NewAdditionalInterest setZipCode(String zipCode)
	{
		sh.setText(by.zipCode, zipCode);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getAddressType()
	{
		return sh.getValue(by.addressType);
	}
	
	public NewAdditionalInterest setAddressType(String addressType)
	{
		sh.setText(by.addressType, addressType);
		sh.tab();

		return this;
	}
	
	public String getAddressDescription()
	{
		return sh.getValue(by.addressDescription);
	}
	
	public NewAdditionalInterest setAddressDescription(String addressDescription)
	{
		sh.setText(by.addressDescription, addressDescription);
		sh.tab();

		return this;
	}
	
	public String getLicenseNumber()
	{
		return sh.getValue(by.licenseNumber);
	}
	
	public NewAdditionalInterest setLicenseNumber(String licenseNumber)
	{
		sh.setText(by.licenseNumber, licenseNumber);
		sh.tab();

		return this;
	}
	
	public String getLicenseState()
	{
		return sh.getValue(by.licenseState);
	}
	
	public NewAdditionalInterest setLicenseState(String licenseState)
	{
		sh.setText(by.licenseState, licenseState);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getSsn()
	{
		return sh.getValue(by.officialID);
	}
	
	public NewAdditionalInterest setSsn(String ssn)
	{
		sh.setText(by.officialID, ssn);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public SelectStandardizedAddress clickVerifyAddress()
	{
		sh.clickElement(by.verifyAddress);
		sh.waitForNoMask();
		return new SelectStandardizedAddress(sh,path);
	}

	
	public Dwelling.AdditionalInterests clickOk()
	{
		sh.clickElement(by.ok);
		return new Dwelling(sh,path).new AdditionalInterests(sh, path);
	}
	public String getCompanyName()
	{
		return sh.getValue(by.companyName);
	}
	
	public NewAdditionalInterest setCompanyName(String companyName)
	{
		sh.setText(by.companyName, companyName);
		sh.tab();

		return this;
	}
	public String getOfficePhone()
	{
		return sh.getValue(by.officePhone);
	}
	
	public NewAdditionalInterest setOfficePhone(String officePhone)
	{
		sh.setText(by.officePhone, officePhone);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public Dwelling clickCancel()
	{
		sh.clickElement(by.cancel);
		return new Dwelling(sh,path);
	}
	public NewAdditionalInterest clickCheckForDuplicates()
	{
		sh.clickElement(by.checkForDuplicates);
		return this;
	}
	public String getFEIN()
	{
		return sh.getValue(by.officialID);
	}

	public NewAdditionalInterest setFEIN(String officialID)
	{
		sh.setText(by.officialID, officialID);
		sh.tab();
		sh.waitForNoMask();
		return this;
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

					// Tabs
					ok = By.id(tabBase+ "ForceDupCheckUpdate-btnInnerEl"),
					cancel = By.id(tabBase + "Cancel-btnInnerEl"),
					checkForDuplicates = By.id(tabBase + "CheckForDuplicates-btnInnerEl");




					
	}
}
