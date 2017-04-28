package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class SCHO3Payment extends Payment<SCHO3Payment>
{
	public SCHO3WestPanel westPanel;
	public SCHO3Payment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new SCHO3WestPanel(sh,path);
	}
}
