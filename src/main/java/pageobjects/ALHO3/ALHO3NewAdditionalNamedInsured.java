package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.FLHO3.FLHO3PolicyInfo;
import pageobjects.FLHO3.FLHO3SelectStandardizedAddress;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3NewAdditionalNamedInsured extends NewAdditionalNameInsured<ALHO3NewAdditionalNamedInsured>
{
	public ALHO3NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
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
