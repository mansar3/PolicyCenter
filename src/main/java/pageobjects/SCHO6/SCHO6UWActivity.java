package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6UWActivity extends UWActivity<SCHO6UWActivity>
{
		public SCHO6UWActivity(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6RiskAnalysis sendRequest()
	{
		super.clickSendRequest();
		return new SCHO6RiskAnalysis(sh,path);
	}
}
