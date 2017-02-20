package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 1/24/17.
 */
public abstract class LocationInformation<T extends LocationInformation> extends CenterPanelBase
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

	public T setCountry(String country)
	{
		sh.setText(by.country, country);
		sh.tab();
		sh.waitForNoMask();
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
	public String getPhone()
	{
		return sh.getValue(by.phone);
	}
	
	public T setPhone(String phone)
	{
		sh.setText(by.phone, phone);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	public T verifyAddress()
	{
		// Added because mask would disappear and reappear
		for(int i= 0;i<5;i++)
		{
			sh.waitForNoMask();
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			if(!sh.isMaskPresent())
				break;
		}
		sh.clickElement(by.verifyAddress);
		return (T)this;
	}
	public T ok()
	{
		sh.clickElement(by.ok);
		return (T)this;
	}
	public T cancel()
	{
		sh.clickElement(by.cancel);
		return (T)this;
	}

	
	
}
