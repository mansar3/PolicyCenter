package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 11/30/16.
 */
public abstract class Offerings<T extends Offerings> extends CenterPanelBase
{
	private OfferingsBy by;
	public Offerings(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Offerings";
		waitForTitle(sh);
		by = new OfferingsBy();
		log("Navigated to page: " + expectedPanelTitle);
	}
	public class OfferingsBy{
		final String offeringsBase = "RenewalWizard:OfferingScreen:";
		final  By policyType = By.id(offeringsBase + "PolicyTypeDV:HOPolicyType-inputEl"),
							offeringSelection = By.id(offeringsBase + "OfferingSelection-inputEl");
	}

	protected String getOfferingSelection()
	{
		return sh.getValue(by.offeringSelection);
	}

	protected T setOfferingSelection(String offeringSelection)
	{
		sh.setText(by.offeringSelection, offeringSelection);
		return (T)this;
	}
	protected T setPolicyType(String policyType)
	{
		sh.setText(by.policyType, policyType);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getPolicyType()
	{
		return sh.getValue(by.policyType);
	}

	protected T policyInfoNext()
	{
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		sh.waitForNoMask();
		return (T)this;
	}

}
