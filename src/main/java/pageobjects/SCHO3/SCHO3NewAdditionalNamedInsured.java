package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3NewAdditionalNamedInsured extends NewAdditionalNameInsured<SCHO3NewAdditionalNamedInsured>
{
	public SCHO3NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3PolicyInfo clickOk()
	{
		super.ok();
		return new SCHO3PolicyInfo(sh,path);
	}
	public SCHO3PolicyInfo clickCancel()
	{
		super.cancel();
		return new SCHO3PolicyInfo(sh,path);
	}
	public SCHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCHO3SelectStandardizedAddress(sh,path);
	}
}
