package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6LocationInformation extends LocationInformation<FLHO6LocationInformation>
{
	public FLHO6LocationInformation(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLHO6SelectStandardizedAddress(sh,path);
	}
	public FLHO6Dwelling clickOk()
	{
		super.ok();
		return new FLHO6Dwelling(sh,path);
	}
	public FLHO6Dwelling clickCancel()
	{
		super.cancel();
		return new FLHO6Dwelling(sh,path);
	}
}
