package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RenewalBound;

/**
 * Created by aansari on 2/14/17.
 */
public class FLDP3RenewalBound extends RenewalBound<FLDP3RenewalBound>
{
	public FLDP3WestPanel westPanel;
	public FLDP3RenewalBound(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new FLDP3WestPanel(sh, path);
	}
}
