package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3UWActivity extends UWActivity<FLDP3UWActivity>
{
	public FLDP3UWActivity(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3RiskAnalysis sendRequest()
	{
		super.clickSendRequest();
		return new FLDP3RiskAnalysis(sh,path);
	}
}
