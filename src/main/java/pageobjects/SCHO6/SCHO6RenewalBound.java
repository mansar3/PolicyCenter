package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RenewalBound;

/**
 * Created by aansari on 2/14/17.
 */
public class SCHO6RenewalBound extends RenewalBound<SCHO6RenewalBound>
{
	public SCHO6WestPanel westPanel;
	public SCHO6RenewalBound(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new SCHO6WestPanel(sh, path);
	}
	// Must create methods for proper return types ( WORK IN PROGRESS )
}