package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by aansari on 2/6/17.
 */
public class ALHO3UWActivity extends UWActivity<ALHO3UWActivity>
{
		public ALHO3UWActivity(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public ALHO3RiskAnalysis sendRequest()
	{
		super.clickSendRequest();
		return new ALHO3RiskAnalysis(sh,path);
	}
}
