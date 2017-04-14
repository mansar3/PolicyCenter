package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RenewalBound;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWRenewalBound extends RenewalBound<NCHOWRenewalBound> {
	public NCHOWWestPanel westPanel;
    public NCHOWRenewalBound(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
		westPanel = new NCHOWWestPanel(sh, path);
	}
    // Must create methods for proper return types ( WORK IN PROGRESS )
}
