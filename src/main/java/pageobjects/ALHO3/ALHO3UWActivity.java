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

	public String getAssignTo( ){ return super.getAssignTo();}

	public String getDescription() {return super.getDescription();}

	public ALHO3RiskAnalysis sendRequest()
	{
		super.clickSendRequest();
		return new ALHO3RiskAnalysis(sh,path);
	}
	public ALHO3UWActivity clickCancel()
	{
		super.clickCancel();
		return new ALHO3UWActivity(sh,path);
	}
	
}
