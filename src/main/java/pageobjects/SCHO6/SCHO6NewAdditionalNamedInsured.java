package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6NewAdditionalNamedInsured extends NewAdditionalNameInsured<SCHO6NewAdditionalNamedInsured>
{
	public SCHO6NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6PolicyInfo clickOk()
	{
		super.ok();
		return new SCHO6PolicyInfo(sh,path);
	}
	public SCHO6PolicyInfo clickCancel()
	{
		super.cancel();
		return new SCHO6PolicyInfo(sh,path);
	}
	public SCHO6SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCHO6SelectStandardizedAddress(sh,path);
	}
}
