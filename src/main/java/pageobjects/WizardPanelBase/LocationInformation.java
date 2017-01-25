package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 1/24/17.
 */
public class LocationInformation extends CenterPanelBase
{
	private LocationInformationBy by;
	public LocationInformation(CenterSeleniumHelper sh, Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Location Information";
		waitForTitle(sh);
		by = new LocationInformationBy();
		System.out.println("Navigated to page: " + expectedPanelTitle);

	}
	public class LocationInformationBy
	{
		String liBase = "LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LocationDetailInputSet:TargetedAddressInputSet:globalAddressContainer:GlobalAddressInputSet:";
		By	country = By.id(liBase + "Country-inputEl"),
			address1 = By.id(liBase + "AddressLine1-inputEl"),
			address2 = By.id(liBase + "AddressLine2-inputEl"),
			address3 = By.id(liBase + "AddressLine3-inputEl"),
			city = By.id(liBase + "City-inputEl"),
			county = By.id(liBase + "County-inputEl"),
			zipCode = By.id(liBase + "PostalCode-inputEl"),
			verifyAddress = By.id(liBase + "VerifyAddressPickerButton"),

			phone = By.id("LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LocationDetailInputSet:Phone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),

			ok = By.id("LocationPopup:LocationScreen:Update-btnInnerEl"),
			cancel = By.id("LocationPopup:LocationScreen:Cancel-btnInnerEl");
	}

	public String getCountry()
	{
		return sh.getValue(by.country);
	}

	public LocationInformation setCountry(String country)
	{
		sh.setText(by.country, country);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getAddress1()
	{
		return sh.getValue(by.address1);
	}
	
	public LocationInformation setAddress1(String address1)
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
	
	public LocationInformation setAddress2(String address2)
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
	
	public LocationInformation setAddress3(String address3)
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
	
	public LocationInformation setCity(String city)
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
	
	public LocationInformation setCounty(String county)
	{
		sh.setText(by.county, county);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getZipCode()
	{
		return sh.getValue(by.zipCode);
	}
	
	public LocationInformation setZipCode(String zipCode)
	{
		sh.setText(by.zipCode, zipCode);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getPhone()
	{
		return sh.getValue(by.phone);
	}
	
	public LocationInformation setPhone(String phone)
	{
		sh.setText(by.phone, phone);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public SelectStandardizedAddress clickVerifyAddress()
	{
		sh.clickElement(by.verifyAddress);
		return new SelectStandardizedAddress(sh, path);
	}
	public Dwelling clickOk()
	{
		sh.clickElement(by.ok);
		return new Dwelling(sh, path);
	}
	public Dwelling clickCancel()
	{
		sh.clickElement(by.cancel);
		return new Dwelling(sh, path);
	}

	
	
}
