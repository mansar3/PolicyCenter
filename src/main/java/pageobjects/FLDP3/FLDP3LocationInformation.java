package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3LocationInformation extends LocationInformation<FLDP3LocationInformation>
{
	public FLDP3LocationInformation(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLDP3SelectStandardizedAddress(sh,path);
	}
	public FLDP3Dwelling clickOk()
	{
		super.ok();
		return new FLDP3Dwelling(sh,path);
	}
	public FLDP3Dwelling clickCancel()
	{
		super.cancel();
		return new FLDP3Dwelling(sh,path);
	}
}
