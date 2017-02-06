package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3NewAdditionalInterest extends NewAdditionalInterest<FLHO3NewAdditionalInterest>
{
	public FLHO3NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLHO3SelectStandardizedAddress(sh,path);
	}
	public FLHO3Dwelling.FLHO3AdditionalInterests clickCancel()
	{
		super.cancel();
		return new FLHO3Dwelling(sh,path).new FLHO3AdditionalInterests(sh,path);
	}
	public FLHO3Dwelling.FLHO3AdditionalInterests clickOk()
	{
		super.ok();
		return new FLHO3Dwelling(sh,path).new FLHO3AdditionalInterests(sh,path);
	}
}
