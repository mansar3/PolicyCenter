package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class SCHO3WestPanel extends CenterPanelBase.WestPanel<SCHO3WestPanel>
{
	public SCHO3WestPanel(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public SCHO3GoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new SCHO3GoPaperless(sh, path);
	}
	public SCHO3Quote viewQuote()
	{
		super.clickViewQuote();
		return new SCHO3Quote(sh,path);
	}
	public SCHO3Payment payment()
	{
		super.clickPayment();
		return new SCHO3Payment(sh,path);
	}
}
