package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3SelectStandardizedAddress extends SelectStandardizedAddress<ALHO3SelectStandardizedAddress>
{
	public ALHO3SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public ALHO3SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public ALHO3CreateAccount selectVerifiedAddressForCreateAccount(int row)
	{
		super.clickVerifiedAddressForCreateAccount(row);
		return new ALHO3CreateAccount(sh);
	}
}
