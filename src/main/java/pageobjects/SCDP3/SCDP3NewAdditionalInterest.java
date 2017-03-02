package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3NewAdditionalInterest extends NewAdditionalInterest<SCDP3NewAdditionalInterest>
{
		public SCDP3NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCDP3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCDP3SelectStandardizedAddress(sh,path);
	}
	public SCDP3Dwelling.SCDP3AdditionalInterests clickCancel()
	{
		super.cancel();
		return new SCDP3Dwelling(sh,path).new SCDP3AdditionalInterests(sh,path);
	}
	public SCDP3Dwelling.SCDP3AdditionalInterests clickOk()
	{
		super.ok();
		return new SCDP3Dwelling(sh,path).new SCDP3AdditionalInterests(sh,path);
	}
}
