package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3LocationInformation extends LocationInformation<SCHO3LocationInformation>
{
		public SCHO3LocationInformation(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCHO3SelectStandardizedAddress(sh,path);
	}
	public SCHO3Dwelling clickOk()
	{
		super.ok();
		return new SCHO3Dwelling(sh,path);
	}
	public SCHO3Dwelling clickCancel()
	{
		super.cancel();
		return new SCHO3Dwelling(sh,path);
	}
}
