package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4NewSubmission extends NewSubmission<SCHO4NewSubmission> {

    public SCHO4ProductSelectionTable productTable = new SCHO4ProductSelectionTable(sh);
    public SCHO4NewSubmission(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO4NewSubmission setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public class SCHO4ProductSelectionTable extends ProductSelectionTable<SCHO4ProductSelectionTable>
    {
        public SCHO4ProductSelectionTable(CenterSeleniumHelper sh)
        {
            super(sh);
        }
        public SCHO4Qualification selectHomeowners()
        {
            super.clickHomeowners();
            return new SCHO4Qualification(sh,path);
        }
        public SCHO4ProductSelectionTable selectCommercialProperty()
        {
            super.clickCommercialProperty();
            return this;
        }
    }
}
