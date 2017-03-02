package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3Offerings extends Offerings<SCDP3Offerings>
{
		public SCDP3Offerings(CenterSeleniumHelper sh , Path path)
	{
		super(sh, path);
	}

	public SCDP3Offerings setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public SCDP3Offerings setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public SCDP3PolicyInfo next()
	{
		super.policyInfoNext();
		return new SCDP3PolicyInfo(sh,path);
	}
}
