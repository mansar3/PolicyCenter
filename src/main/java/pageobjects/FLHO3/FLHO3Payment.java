package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class FLHO3Payment extends Payment<FLHO3Payment>
{
	public FLHO3WestPanel westPanel;
	public FLHO3Payment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new FLHO3WestPanel(sh,path);
	}
}
