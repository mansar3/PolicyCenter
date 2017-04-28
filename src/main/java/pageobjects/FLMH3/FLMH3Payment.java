package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class FLMH3Payment extends Payment<FLMH3Payment>
{
	public FLMH3WestPanel westPanel;
	public FLMH3Payment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new FLMH3WestPanel(sh,path);
	}
}
