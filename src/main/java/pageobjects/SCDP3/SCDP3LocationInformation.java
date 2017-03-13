package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3LocationInformation extends LocationInformation<SCDP3LocationInformation>
{
		public SCDP3LocationInformation(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCDP3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCDP3SelectStandardizedAddress(sh,path);
	}
	public SCDP3Dwelling clickOk()
	{
		super.ok();
		return new SCDP3Dwelling(sh,path);
	}
	public SCDP3Dwelling clickCancel()
	{
		super.cancel();
		return new SCDP3Dwelling(sh,path);
	}
	public SCDP3Coverages.SCDP3LiabilityEndorsements clickLiabilityOk()
	{
		super.ok();
		return new SCDP3Coverages(sh,path).new SCDP3LiabilityEndorsements(sh,path);
	}
	public SCDP3Dwelling clickLiabilityCancel()
	{
		super.cancel();
		return new SCDP3Dwelling(sh,path);
	}
}
