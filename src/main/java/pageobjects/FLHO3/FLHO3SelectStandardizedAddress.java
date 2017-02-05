package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3SelectStandardizedAddress extends SelectStandardizedAddress<FLHO3SelectStandardizedAddress>
{
	public FLHO3SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public FLHO3SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}
}
