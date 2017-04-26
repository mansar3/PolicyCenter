package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class FLHO6Payment extends Payment<FLHO6Payment>
{
	public FLHO6WestPanel westPanel;
	public FLHO6Payment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new FLHO6WestPanel(sh,path);
	}
}
