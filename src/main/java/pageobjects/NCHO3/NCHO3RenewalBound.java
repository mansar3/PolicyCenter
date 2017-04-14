package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RenewalBound;

/**
 * Created by aansari on 2/14/17.
 */
public class NCHO3RenewalBound extends RenewalBound<NCHO3RenewalBound>
{
	public NCHO3WestPanel westPanel;
	public NCHO3RenewalBound(CenterSeleniumHelper sh, Path path)
	{
		super(sh,path);
		westPanel = new NCHO3WestPanel(sh, path);
	}
		// Must create methods for proper return types ( WORK IN PROGRESS )
}