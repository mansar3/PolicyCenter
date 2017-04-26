package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Payment;

/**
 * Created by aansari on 4/20/17.
 */
public class NCHOWPayment extends Payment<NCHOWPayment>
{
	public NCHOWWestPanel westPanel;
	public NCHOWPayment(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new NCHOWWestPanel(sh,path);
	}
}
