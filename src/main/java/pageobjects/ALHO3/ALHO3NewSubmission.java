package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3NewSubmission extends NewSubmission<ALHO3NewSubmission>
{
	public ALHO3NewSubmission(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public ALHO3ProductSelectionTable productTable = new ALHO3ProductSelectionTable(sh);

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public ALHO3NewSubmission setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public class ALHO3ProductSelectionTable extends ProductSelectionTable<ALHO3ProductSelectionTable>
	{
		public ALHO3ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public ALHO3Qualification selectHomeowners()
		{
			super.clickHomeowners();
			return new ALHO3Qualification(sh, path);
		}
		public ALHO3ProductSelectionTable selectCommercialProperty()
		{
			super.clickCommercialProperty();
			return this;
		}
	}
}
