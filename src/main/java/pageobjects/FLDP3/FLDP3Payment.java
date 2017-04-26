package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class FLDP3Payment extends Payment<FLDP3Payment>
{
	public FLDP3WestPanel westPanel;
	public FLDP3Payment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new FLDP3WestPanel(sh,path);
	}
}
