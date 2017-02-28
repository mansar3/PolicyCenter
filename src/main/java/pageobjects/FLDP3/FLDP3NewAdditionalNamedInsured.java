package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3NewAdditionalNamedInsured extends NewAdditionalNameInsured<FLDP3NewAdditionalNamedInsured>
{
	public FLDP3NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3PolicyInfo clickOk()
	{
		super.ok();
		return new FLDP3PolicyInfo(sh,path);
	}
	public FLDP3PolicyInfo clickCancel()
	{
		super.cancel();
		return new FLDP3PolicyInfo(sh,path);
	}
	public FLDP3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLDP3SelectStandardizedAddress(sh,path);
	}
}
