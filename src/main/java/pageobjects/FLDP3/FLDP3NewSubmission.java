package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3NewSubmission extends NewSubmission<FLDP3NewSubmission>
{
	public FLDP3ProductSelectionTable productTable = new FLDP3ProductSelectionTable(sh);
	public FLDP3NewSubmission(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLDP3NewSubmission setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public class FLDP3ProductSelectionTable extends ProductSelectionTable<FLDP3ProductSelectionTable>
	{
		public FLDP3ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public FLDP3Qualification selectHomeowners()
		{
			super.clickHomeowners();
			return new FLDP3Qualification(sh,path);
		}
		public FLDP3ProductSelectionTable selectCommercialProperty()
		{
			super.clickCommercialProperty();
			return this;
		}
	}
}
