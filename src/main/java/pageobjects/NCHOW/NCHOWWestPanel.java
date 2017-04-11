package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.NCHO3.NCHO3GoPaperless;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by aansari on 4/10/17.
 */
public class NCHOWWestPanel extends CenterPanelBase.WestPanel<NCHOWWestPanel>
{
	public NCHOWWestPanel(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public NCHOWGoPaperless goPaperless()
	{
		super.clickGoPaperless();
		return new NCHOWGoPaperless(sh, path);
	}
}
