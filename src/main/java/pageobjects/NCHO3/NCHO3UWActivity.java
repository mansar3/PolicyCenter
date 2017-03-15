package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3UWActivity extends UWActivity<NCHO3UWActivity>
{
		public NCHO3UWActivity(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3RiskAnalysis sendRequest()
	{
		super.clickSendRequest();
		return new NCHO3RiskAnalysis(sh,path);
	}
	public NCHO3RiskAnalysis clickCancel()
	{
		super.clickcancel();
		return new NCHO3RiskAnalysis(sh,path);
	}
}
