package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class ALHO3Payment extends Payment<ALHO3Payment>
{
	public ALHO3WestPanel westPanel;
	public ALHO3Payment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new ALHO3WestPanel(sh,path);
	}
}
