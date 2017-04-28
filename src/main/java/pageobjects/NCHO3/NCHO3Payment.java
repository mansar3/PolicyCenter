package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class NCHO3Payment extends Payment<NCHO3Payment>
{
	public NCHO3WestPanel westPanel;
	public NCHO3Payment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new NCHO3WestPanel(sh,path);
	}
}
