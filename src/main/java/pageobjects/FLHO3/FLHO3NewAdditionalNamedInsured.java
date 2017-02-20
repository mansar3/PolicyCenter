package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3NewAdditionalNamedInsured extends NewAdditionalNameInsured<FLHO3NewAdditionalNamedInsured>
{
	public FLHO3NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3PolicyInfo clickOk()
	{
		super.ok();
		return new FLHO3PolicyInfo(sh,path);
	}
	public FLHO3PolicyInfo clickCancel()
	{
		super.cancel();
		return new FLHO3PolicyInfo(sh,path);
	}
	public FLHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLHO3SelectStandardizedAddress(sh,path);
	}
}
