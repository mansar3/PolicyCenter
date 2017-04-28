package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class SCDP3Payment extends Payment<SCDP3Payment>
{
	public SCDP3WestPanel westPanel;
	public SCDP3Payment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new SCDP3WestPanel(sh,path);
	}
}
