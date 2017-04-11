package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.SCHO6.SCHO6GoPaperless;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class SCHO6WestPanel extends CenterPanelBase.WestPanel<SCHO6WestPanel>
{
	public SCHO6WestPanel(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public SCHO6GoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new SCHO6GoPaperless(sh, path);
	}
}
