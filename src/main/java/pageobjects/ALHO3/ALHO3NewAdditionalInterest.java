package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3NewAdditionalInterest extends NewAdditionalInterest<ALHO3NewAdditionalInterest>
{
	public ALHO3NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public ALHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new ALHO3SelectStandardizedAddress(sh,path);
	}
	public ALHO3Dwelling.ALHO3AdditionalInterests clickCancel()
	{
		super.cancel();
		return new ALHO3Dwelling(sh,path).new ALHO3AdditionalInterests(sh,path);
	}
	public ALHO3Dwelling.ALHO3AdditionalInterests clickOk()
	{
		super.ok();
		return new ALHO3Dwelling(sh,path).new ALHO3AdditionalInterests(sh,path);
	}
}
