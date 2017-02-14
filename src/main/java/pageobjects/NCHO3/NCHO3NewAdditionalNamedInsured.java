package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3NewAdditionalNamedInsured extends NewAdditionalNameInsured<NCHO3NewAdditionalNamedInsured>
{
	public NCHO3NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3PolicyInfo clickOk()
	{
		super.ok();
		return new NCHO3PolicyInfo(sh,path);
	}
	public NCHO3PolicyInfo clickCancel()
	{
		super.cancel();
		return new NCHO3PolicyInfo(sh,path);
	}
	public NCHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new NCHO3SelectStandardizedAddress(sh,path);
	}
}
