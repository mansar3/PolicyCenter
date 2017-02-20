package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3Offerings extends Offerings<NCHO3Offerings>
{
		public NCHO3Offerings(CenterSeleniumHelper sh , Path path)
	{
		super(sh, path);
	}

	public NCHO3Offerings setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public NCHO3Offerings setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public NCHO3PolicyInfo next()
	{
		super.policyInfoNext();
		return new NCHO3PolicyInfo(sh,path);
	}
}
