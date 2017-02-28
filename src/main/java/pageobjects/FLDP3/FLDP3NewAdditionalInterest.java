package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3NewAdditionalInterest extends NewAdditionalInterest<FLDP3NewAdditionalInterest>
{
	public FLDP3NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLDP3SelectStandardizedAddress(sh,path);
	}
	public FLDP3Dwelling.FLDP3AdditionalInterests clickCancel()
	{
		super.cancel();
		return new FLDP3Dwelling(sh,path).new FLDP3AdditionalInterests(sh,path);
	}
	public FLDP3Dwelling.FLDP3AdditionalInterests clickOk()
	{
		super.ok();
		return new FLDP3Dwelling(sh,path).new FLDP3AdditionalInterests(sh,path);
	}
}
