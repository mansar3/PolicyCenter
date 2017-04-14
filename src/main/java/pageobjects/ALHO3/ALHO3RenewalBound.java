package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RenewalBound;

/**
 * Created by aansari on 2/14/17.
 */
public class ALHO3RenewalBound extends RenewalBound<ALHO3RenewalBound>
{
	public ALHO3WestPanel westPanel;
	public ALHO3RenewalBound(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new ALHO3WestPanel(sh,path);
	}
		// Must create methods for proper return types ( WORK IN PROGRESS )
}