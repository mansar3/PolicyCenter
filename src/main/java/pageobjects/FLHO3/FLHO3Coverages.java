package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3Coverages extends Coverages<FLHO3Coverages>
{
	public FLHO3Coverages(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3RiskAnalysis next()
	{
		coveragesNext();
		return new FLHO3RiskAnalysis(sh, path);
	}
	public String getDwellingLimit()
	{
		return super.getDwellingLimit();
	}

	public FLHO3Coverages setDwellingLimit(String text)
	{
		super.setDwellingLimit(text);
		return this;
	}
	public FLHO3PropertyEndorsements clickPropertyEndorsements()
	{
		super.clickPropertyEndorsementsTab();
		return new FLHO3PropertyEndorsements(sh,path);
	}

	public class FLHO3LiabilityEndorsements extends LiabilityEndorsements<FLHO3LiabilityEndorsements>
	{
		public FLHO3LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}

	}
	public class FLHO3PropertyEndorsements extends PropertyEndorsements<FLHO3PropertyEndorsements>
	{
		public FLHO3PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
		{
			super(sh, path);
		}
	}
}
