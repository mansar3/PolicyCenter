package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 11/30/16.
 */
public class Offerings extends CenterPanelBase
{
	private OfferingsBy by;
	public Offerings(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Offerings";
		waitForTitle(sh);
		by = new OfferingsBy();
		System.out.println("Navigated to page: " + getTitle());
	}
	public class OfferingsBy{
		final String offeringsBase = "RenewalWizard:OfferingScreen:";
		final  By policyType = By.id(offeringsBase + "PolicyTypeDV:HOPolicyType-inputEl"),
							offeringSelection = By.id(offeringsBase + "OfferingSelection-inputEl");
	}

	public String getOfferingSelection()
	{
		return sh.getValue(by.offeringSelection);
	}

	public Offerings setOfferingSelection(String offeringSelection)
	{
		sh.setText(by.offeringSelection, offeringSelection);
		return this;
	}
	public Offerings setPolicyType(String policyType)
	{
		sh.setText(by.policyType, policyType);
		sh.tab();
		sh.waitForNoMask(15);
		return this;
	}

	public String getPolicyType()
	{
		return sh.getValue(by.policyType);
	}

	public PolicyInfo next()
	{
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new PolicyInfo(sh,path);
	}

}
