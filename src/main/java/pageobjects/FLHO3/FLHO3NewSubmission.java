package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3NewSubmission extends NewSubmission<FLHO3NewSubmission>
{
	public FLHO3NewSubmission(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO3NewSubmission setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public class FLHO3ProductSelectionTable extends ProductSelectionTable<FLHO3ProductSelectionTable>
	{
		public FLHO3ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public FLHO3ProductSelectionTable selectHomeowners()
		{
			super.selectHomeowners();
			return this;
		}
		public FLHO3ProductSelectionTable selectCommercialProperty()
		{
			super.selectCommercialProperty();
			return this;
		}
	}
}
