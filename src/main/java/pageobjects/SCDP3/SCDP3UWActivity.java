package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3UWActivity extends UWActivity<SCDP3UWActivity>
{
		public SCDP3UWActivity(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCDP3RiskAnalysis sendRequest()
	{
		super.clickSendRequest();
		return new SCDP3RiskAnalysis(sh,path);
	}
}
