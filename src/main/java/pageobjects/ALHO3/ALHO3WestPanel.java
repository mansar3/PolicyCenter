package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class ALHO3WestPanel extends CenterPanelBase.WestPanel<ALHO3WestPanel>
{
	public ALHO3WestPanel(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public ALHO3GoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new ALHO3GoPaperless(sh, path);
	}
	public ALHO3Quote viewQuote()
	{
		super.clickViewQuote();
		return new ALHO3Quote(sh,path);
	}
}
