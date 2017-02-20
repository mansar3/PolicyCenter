package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3NewAdditionalInterest extends NewAdditionalInterest<SCHO3NewAdditionalInterest>
{
		public SCHO3NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCHO3SelectStandardizedAddress(sh,path);
	}
	public SCHO3Dwelling.SCHO3AdditionalInterests clickCancel()
	{
		super.cancel();
		return new SCHO3Dwelling(sh,path).new SCHO3AdditionalInterests(sh,path);
	}
	public SCHO3Dwelling.SCHO3AdditionalInterests clickOk()
	{
		super.ok();
		return new SCHO3Dwelling(sh,path).new SCHO3AdditionalInterests(sh,path);
	}
}
