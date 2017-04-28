package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class FLMH3WestPanel extends CenterPanelBase.WestPanel<FLMH3WestPanel>
{
	public FLMH3WestPanel(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public FLMH3GoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new FLMH3GoPaperless(sh, path);
	}
	public FLMH3Quote viewQuote()
	{
		super.clickViewQuote();
		return new FLMH3Quote(sh,path);
	}
		public FLMH3Payment payment()
	{
		super.clickPayment();
		return new FLMH3Payment(sh,path);
	}
}
