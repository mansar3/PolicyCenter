package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3LocationInformation extends LocationInformation<FLHO3LocationInformation>
{
	public FLHO3LocationInformation(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new FLHO3SelectStandardizedAddress(sh,path);
	}
	public FLHO3Dwelling clickOk()
	{
		super.ok();
		return new FLHO3Dwelling(sh,path);
	}
	public FLHO3Dwelling clickCancel()
	{
		super.cancel();
		return new FLHO3Dwelling(sh,path);
	}
	public FLHO3Coverages.FLHO3LiabilityEndorsements clickLiabilityOk()
	{
		super.ok();
		return new FLHO3Coverages(sh,path).new FLHO3LiabilityEndorsements(sh,path);
	}
	public FLHO3Dwelling clickLiabilityCancel()
	{
		super.cancel();
		return new FLHO3Dwelling(sh,path);
	}
}
