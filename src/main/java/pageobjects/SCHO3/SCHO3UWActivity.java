package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3UWActivity extends UWActivity<SCHO3UWActivity>
{
		public SCHO3UWActivity(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3RiskAnalysis sendRequest()
	{
		super.clickSendRequest();
		return new SCHO3RiskAnalysis(sh,path);
	}
	public SCHO3RiskAnalysis clickCancel()
	{
		super.clickcancel();
		return new SCHO3RiskAnalysis(sh,path);
	}
}
