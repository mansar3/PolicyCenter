package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WizardPanelBase.PolicyInfo;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3Qualification extends Qualification<FLHO3Qualification>
{
	public FLHO3Qualification(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3PolicyInfo next()
	{
		super.next();
		return new FLHO3PolicyInfo(sh, path);
	}
}
