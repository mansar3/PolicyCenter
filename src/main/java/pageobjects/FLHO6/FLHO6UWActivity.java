package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6UWActivity extends UWActivity<FLHO6UWActivity>
{
	public FLHO6UWActivity(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6RiskAnalysis sendRequest()
	{
		super.clickSendRequest();
		return new FLHO6RiskAnalysis(sh,path);
	}
	public FLHO6RiskAnalysis clickCancel()
	{
		super.clickcancel();
		return new FLHO6RiskAnalysis(sh,path);
	}
}
