package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class SCDP3WestPanel extends CenterPanelBase.WestPanel<SCDP3WestPanel>
{
	public SCDP3WestPanel(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public SCDP3GoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new SCDP3GoPaperless(sh, path);
	}
		public SCDP3Quote viewQuote()
	{
		super.clickViewQuote();
		return new SCDP3Quote(sh,path);
	}
}
