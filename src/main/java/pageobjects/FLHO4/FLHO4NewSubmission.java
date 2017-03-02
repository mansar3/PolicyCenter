package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4NewSubmission extends NewSubmission<FLHO4NewSubmission> {
    public FLHO4ProductSelectionTable productTable = new FLHO4ProductSelectionTable(sh);
    public FLHO4NewSubmission(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLHO4NewSubmission setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public class FLHO4ProductSelectionTable extends ProductSelectionTable<FLHO4ProductSelectionTable>
    {
        public FLHO4ProductSelectionTable(CenterSeleniumHelper sh)
        {
            super(sh);
        }
        public FLHO4Qualification selectHomeowners()
        {
            super.clickHomeowners();
            return new FLHO4Qualification(sh,path);
        }
        public FLHO4ProductSelectionTable selectCommercialProperty()
        {
            super.clickCommercialProperty();
            return this;
        }
    }
}
