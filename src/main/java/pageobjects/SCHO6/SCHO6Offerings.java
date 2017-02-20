package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6Offerings extends Offerings<SCHO6Offerings>
{
		public SCHO6Offerings(CenterSeleniumHelper sh , Path path)
	{
		super(sh, path);
	}

	public SCHO6Offerings setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public SCHO6Offerings setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public SCHO6PolicyInfo next()
	{
		super.policyInfoNext();
		return new SCHO6PolicyInfo(sh,path);
	}
}
