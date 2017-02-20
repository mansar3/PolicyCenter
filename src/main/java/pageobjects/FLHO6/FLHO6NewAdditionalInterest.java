package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6NewAdditionalInterest extends NewAdditionalInterest<FLHO6NewAdditionalInterest>
{
	public FLHO6NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLHO6SelectStandardizedAddress(sh,path);
	}
	public FLHO6Dwelling.FLHO6AdditionalInterests clickCancel()
	{
		super.cancel();
		return new FLHO6Dwelling(sh,path).new FLHO6AdditionalInterests(sh,path);
	}
	public FLHO6Dwelling.FLHO6AdditionalInterests clickOk()
	{
		super.ok();
		return new FLHO6Dwelling(sh,path).new FLHO6AdditionalInterests(sh,path);
	}
}
