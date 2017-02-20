package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3LocationInformation extends LocationInformation<ALHO3LocationInformation>
{
	public ALHO3LocationInformation(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public ALHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new ALHO3SelectStandardizedAddress(sh,path);
	}

	public ALHO3LocationInformation setCounty(String county)
	{
		super.setCounty(county);
		return this;
	}

	public ALHO3Dwelling clickOk()
	{
		super.ok();
		return new ALHO3Dwelling(sh,path);
	}
	public ALHO3Dwelling clickCancel()
	{
		super.cancel();
		return new ALHO3Dwelling(sh,path);
	}
}
