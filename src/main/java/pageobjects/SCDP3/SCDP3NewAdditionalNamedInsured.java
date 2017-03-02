package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3NewAdditionalNamedInsured extends NewAdditionalNameInsured<SCDP3NewAdditionalNamedInsured>
{
	public SCDP3NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCDP3PolicyInfo clickOk()
	{
		super.ok();
		return new SCDP3PolicyInfo(sh,path);
	}
	public SCDP3PolicyInfo clickCancel()
	{
		super.cancel();
		return new SCDP3PolicyInfo(sh,path);
	}
	public SCDP3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCDP3SelectStandardizedAddress(sh,path);
	}
}
