package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6Offerings extends Offerings<FLHO6Offerings>
{
	public FLHO6Offerings(CenterSeleniumHelper sh , Path path)
	{
		super(sh, path);
	}

	public FLHO6Offerings setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public FLHO6Offerings setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public FLHO6PolicyInfo next()
	{
		super.policyInfoNext();
		return new FLHO6PolicyInfo(sh,path);
	}

}
