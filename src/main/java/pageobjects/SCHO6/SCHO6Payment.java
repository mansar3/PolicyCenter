package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class SCHO6Payment extends Payment<SCHO6Payment>
{
	public SCHO6WestPanel westPanel;
	public SCHO6Payment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new SCHO6WestPanel(sh,path);
	}
}
