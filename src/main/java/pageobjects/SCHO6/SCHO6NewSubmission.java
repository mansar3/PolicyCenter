package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6NewSubmission extends NewSubmission<SCHO6NewSubmission>
{
		public SCHO6ProductSelectionTable productTable = new SCHO6ProductSelectionTable(sh);
	public SCHO6NewSubmission(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO6NewSubmission setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public class SCHO6ProductSelectionTable extends ProductSelectionTable<SCHO6ProductSelectionTable>
	{
		public SCHO6ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public SCHO6Qualification selectHomeowners()
		{
			super.clickHomeowners();
			return new SCHO6Qualification(sh,path);
		}
		public SCHO6ProductSelectionTable selectCommercialProperty()
		{
			super.clickCommercialProperty();
			return this;
		}
	}
}
