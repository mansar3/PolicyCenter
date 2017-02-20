package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6NewAdditionalNamedInsured extends NewAdditionalNameInsured<FLHO6NewAdditionalNamedInsured>
{
	public FLHO6NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6PolicyInfo clickOk()
	{
		super.ok();
		return new FLHO6PolicyInfo(sh,path);
	}
	public FLHO6PolicyInfo clickCancel()
	{
		super.cancel();
		return new FLHO6PolicyInfo(sh,path);
	}
	public FLHO6SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLHO6SelectStandardizedAddress(sh,path);
	}
}
