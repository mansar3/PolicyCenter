package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3NewSubmission extends NewSubmission<SCDP3NewSubmission>
{
		public SCDP3ProductSelectionTable productTable = new SCDP3ProductSelectionTable(sh);
	public SCDP3NewSubmission(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCDP3NewSubmission setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public class SCDP3ProductSelectionTable extends ProductSelectionTable<SCDP3ProductSelectionTable>
	{
		public SCDP3ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public SCDP3Qualification selectHomeowners()
		{
			super.clickHomeowners();
			return new SCDP3Qualification(sh,path);
		}
		public SCDP3ProductSelectionTable selectCommercialProperty()
		{
			super.clickCommercialProperty();
			return this;
		}
	}
}
