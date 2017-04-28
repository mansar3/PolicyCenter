package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class FLHO3WestPanel extends CenterPanelBase.WestPanel<FLHO3WestPanel>
{
	public FLHO3WestPanel(CenterSeleniumHelper sh,Path path)
	{
		super(sh, path);
	}
	public FLHO3GoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new FLHO3GoPaperless(sh, path);
	}
	public FLHO3Quote viewQuote()
	{
		super.clickViewQuote();
		return new FLHO3Quote(sh,path);
	}
	public FLHO3Payment payment()
	{
		super.clickPayment();
		return new FLHO3Payment(sh,path);
	}
}
