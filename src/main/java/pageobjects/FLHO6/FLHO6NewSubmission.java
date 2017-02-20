package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6NewSubmission extends NewSubmission<FLHO6NewSubmission>
{
	public FLHO6ProductSelectionTable productTable = new FLHO6ProductSelectionTable(sh);
	public FLHO6NewSubmission(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO6NewSubmission setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public class FLHO6ProductSelectionTable extends ProductSelectionTable<FLHO6ProductSelectionTable>
	{
		public FLHO6ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public FLHO6Qualification selectHomeowners()
		{
			super.clickHomeowners();
			return new FLHO6Qualification(sh,path);
		}
		public FLHO6ProductSelectionTable selectCommercialProperty()
		{
			super.clickCommercialProperty();
			return this;
		}
	}
}
