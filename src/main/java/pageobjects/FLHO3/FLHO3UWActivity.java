package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3UWActivity extends UWActivity<FLHO3UWActivity>
{
	public FLHO3UWActivity(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3RiskAnalysis sendRequest()
	{
		super.clickSendRequest();
		return new FLHO3RiskAnalysis(sh,path);
	}
	public FLHO3RiskAnalysis clickCancel()
	{
		super.clickcancel();
		return new FLHO3RiskAnalysis(sh,path);
	}
}
