package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3NewAdditionalInterest extends NewAdditionalInterest<NCHO3NewAdditionalInterest>
{
		public NCHO3NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new NCHO3SelectStandardizedAddress(sh,path);
	}
	public NCHO3Dwelling.NCHO3AdditionalInterests clickCancel()
	{
		super.cancel();
		return new NCHO3Dwelling(sh,path).new NCHO3AdditionalInterests(sh,path);
	}
	public NCHO3Dwelling.NCHO3AdditionalInterests clickOk()
	{
		super.ok();
		return new NCHO3Dwelling(sh,path).new NCHO3AdditionalInterests(sh,path);
	}
}
