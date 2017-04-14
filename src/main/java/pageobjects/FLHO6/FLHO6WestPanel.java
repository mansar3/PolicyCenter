package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class FLHO6WestPanel extends CenterPanelBase.WestPanel<FLHO6WestPanel>
{
	public FLHO6WestPanel(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public FLHO6GoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new FLHO6GoPaperless(sh, path);
	}
	public FLHO6Quote viewQuote()
	{
		super.clickViewQuote();
		return new FLHO6Quote(sh,path);
	}
}
