package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3NewSubmission extends NewSubmission<FLMH3NewSubmission> {

    public FLMH3ProductSelectionTable productTable = new FLMH3ProductSelectionTable(sh);
    public FLMH3NewSubmission(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLMH3NewSubmission setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public class FLMH3ProductSelectionTable extends ProductSelectionTable<FLMH3ProductSelectionTable>
    {
        public FLMH3ProductSelectionTable(CenterSeleniumHelper sh)
        {
            super(sh);
        }
        public FLMH3Qualification selectHomeowners()
        {
            super.clickHomeowners();
            return new FLMH3Qualification(sh,path);
        }
        public FLMH3ProductSelectionTable selectCommercialProperty()
        {
            super.clickCommercialProperty();
            return this;
        }
    }
}
