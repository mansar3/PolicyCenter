package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3LocationInformation extends LocationInformation<NCHO3LocationInformation>
{
		public NCHO3LocationInformation(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new NCHO3SelectStandardizedAddress(sh,path);
	}
	public NCHO3Dwelling clickOk()
	{
		super.ok();
		return new NCHO3Dwelling(sh,path);
	}
	public NCHO3Dwelling clickCancel()
	{
		super.cancel();
		return new NCHO3Dwelling(sh,path);
	}
}
