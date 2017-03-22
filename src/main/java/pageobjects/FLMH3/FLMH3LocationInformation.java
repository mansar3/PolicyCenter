package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3LocationInformation  extends LocationInformation<FLMH3LocationInformation> {

    public FLMH3LocationInformation(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new FLMH3SelectStandardizedAddress(sh,path);
    }
    public FLMH3Dwelling clickOk()
    {
        super.ok();
        return new FLMH3Dwelling(sh,path);
    }
    public FLMH3Dwelling clickCancel()
    {
        super.cancel();
        return new FLMH3Dwelling(sh,path);
    }
	public FLMH3Coverages.FLMH3LiabilityEndorsements clickLiabilityOk()
	{
		super.ok();
		return new FLMH3Coverages(sh,path).new FLMH3LiabilityEndorsements(sh,path);
	}
	public FLMH3Dwelling clickLiabilityCancel()
	{
		super.cancel();
		return new FLMH3Dwelling(sh,path);
	}
}
