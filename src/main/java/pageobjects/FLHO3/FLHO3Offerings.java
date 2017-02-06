package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3Offerings extends Offerings<FLHO3Offerings>
{
	public FLHO3Offerings(CenterSeleniumHelper sh , Path path)
	{
		super(sh, path);
	}

	public FLHO3Offerings setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public FLHO3Offerings setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public FLHO3PolicyInfo next()
	{
		super.policyInfoNext();
		return new FLHO3PolicyInfo(sh,path);
	}

}
