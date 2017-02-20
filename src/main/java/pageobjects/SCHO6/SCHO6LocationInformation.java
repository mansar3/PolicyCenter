package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6LocationInformation extends LocationInformation<SCHO6LocationInformation>
{
		public SCHO6LocationInformation(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCHO6SelectStandardizedAddress(sh,path);
	}
	public SCHO6Dwelling clickOk()
	{
		super.ok();
		return new SCHO6Dwelling(sh,path);
	}
	public SCHO6Dwelling clickCancel()
	{
		super.cancel();
		return new SCHO6Dwelling(sh,path);
	}
}
