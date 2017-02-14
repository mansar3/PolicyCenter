package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by aansari on 2/14/17.
 */
public class ALHO3Offerings extends Offerings<ALHO3Offerings>
{
	public ALHO3Offerings(CenterSeleniumHelper sh , Path path)
	{
		super(sh, path);
	}

	public ALHO3Offerings setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public ALHO3Offerings setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public ALHO3PolicyInfo next()
	{
		super.policyInfoNext();
		return new ALHO3PolicyInfo(sh,path);
	}

}