package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WizardPanelBase.PolicyInfo;

public class FLHO3PolicyInfo extends PolicyInfo<FLHO3PolicyInfo>
{
	public FLHO3PolicyInfo(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3NewAdditionalNamedInsured clickAddNewCompany()
	{
		super.clickAddNewCompany();
		return new FLHO3NewAdditionalNamedInsured(sh, path);
	}
}