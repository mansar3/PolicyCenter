package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class FLDP3WestPanel extends CenterPanelBase.WestPanel<FLDP3WestPanel>
{
	public FLDP3WestPanel(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public FLDP3GoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new FLDP3GoPaperless(sh, path);
	}
	public FLDP3Quote viewQuote()
	{
		super.clickViewQuote();
		return new FLDP3Quote(sh, path);
	}
		public FLDP3Payment payment()
	{
		super.clickPayment();
		return new FLDP3Payment(sh,path);
	}
}
