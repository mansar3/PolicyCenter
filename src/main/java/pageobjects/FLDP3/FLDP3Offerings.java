package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3Offerings extends Offerings<FLDP3Offerings>
{
	public FLDP3Offerings(CenterSeleniumHelper sh , Path path)
	{
		super(sh, path);
	}

	public FLDP3Offerings setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public FLDP3Offerings setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public FLDP3PolicyInfo next()
	{
		super.policyInfoNext();
		return new FLDP3PolicyInfo(sh,path);
	}

}
