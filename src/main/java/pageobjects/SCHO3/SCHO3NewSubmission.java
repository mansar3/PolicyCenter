package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3NewSubmission extends NewSubmission<SCHO3NewSubmission>
{
		public SCHO3ProductSelectionTable productTable = new SCHO3ProductSelectionTable(sh);
	public SCHO3NewSubmission(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO3NewSubmission setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public class SCHO3ProductSelectionTable extends ProductSelectionTable<SCHO3ProductSelectionTable>
	{
		public SCHO3ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public SCHO3Qualification selectHomeowners()
		{
			super.clickHomeowners();
			return new SCHO3Qualification(sh,path);
		}
		public SCHO3ProductSelectionTable selectCommercialProperty()
		{
			super.clickCommercialProperty();
			return this;
		}
	}
}
