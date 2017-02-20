package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6NewAdditionalInterest extends NewAdditionalInterest<SCHO6NewAdditionalInterest>
{
		public SCHO6NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCHO6SelectStandardizedAddress(sh,path);
	}
	public SCHO6Dwelling.SCHO6AdditionalInterests clickCancel()
	{
		super.cancel();
		return new SCHO6Dwelling(sh,path).new SCHO6AdditionalInterests(sh,path);
	}
	public SCHO6Dwelling.SCHO6AdditionalInterests clickOk()
	{
		super.ok();
		return new SCHO6Dwelling(sh,path).new SCHO6AdditionalInterests(sh,path);
	}
}
