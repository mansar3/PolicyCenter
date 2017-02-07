package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3NewSubmission extends NewSubmission<FLHO3NewSubmission>
{
	public FLHO3ProductSelectionTable productTable = new FLHO3ProductSelectionTable(sh);
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
		public FLHO3Qualification selectHomeowners()
		{
			super.clickHomeowners();
			return new FLHO3Qualification(sh,path);
		}
		public FLHO3ProductSelectionTable selectCommercialProperty()
		{
			super.clickCommercialProperty();
			return this;
		}
	}
}
