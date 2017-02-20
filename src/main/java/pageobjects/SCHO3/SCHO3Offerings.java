package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3Offerings extends Offerings<SCHO3Offerings>
{
		public SCHO3Offerings(CenterSeleniumHelper sh , Path path)
	{
		super(sh, path);
	}

	public SCHO3Offerings setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public SCHO3Offerings setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public SCHO3PolicyInfo next()
	{
		super.policyInfoNext();
		return new SCHO3PolicyInfo(sh,path);
	}
}
