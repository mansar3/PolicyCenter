package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3NewSubmission extends NewSubmission<NCHO3NewSubmission>
{
		public NCHO3ProductSelectionTable productTable = new NCHO3ProductSelectionTable(sh);
	public NCHO3NewSubmission(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public NCHO3NewSubmission setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public class NCHO3ProductSelectionTable extends ProductSelectionTable<NCHO3ProductSelectionTable>
	{
		public NCHO3ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public NCHO3Qualification selectHomeowners()
		{
			super.clickHomeowners();
			return new NCHO3Qualification(sh,path);
		}
		public NCHO3ProductSelectionTable selectCommercialProperty()
		{
			super.clickCommercialProperty();
			return this;
		}
	}
}
