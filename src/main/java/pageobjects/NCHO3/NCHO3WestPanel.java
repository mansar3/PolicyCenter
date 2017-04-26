package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class NCHO3WestPanel extends CenterPanelBase.WestPanel<NCHO3WestPanel>
{
	public NCHO3WestPanel(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public NCHO3GoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new NCHO3GoPaperless(sh, path);
	}
	public NCHO3Quote viewQuote()
	{
		super.clickViewQuote();
		return new NCHO3Quote(sh,path);
	}
	public NCHO3Payment payment()
	{
		super.clickPayment();
		return new NCHO3Payment(sh,path);
	}
}
