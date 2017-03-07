package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWNewSubmission extends NewSubmission<NCHOWNewSubmission> {
    public NCHOWProductSelectionTable productTable = new NCHOWProductSelectionTable(sh);
    public NCHOWNewSubmission(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCHOWNewSubmission setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public class NCHOWProductSelectionTable extends ProductSelectionTable<NCHOWProductSelectionTable>
    {
        public NCHOWProductSelectionTable(CenterSeleniumHelper sh)
        {
            super(sh);
        }
        public NCHOWQualification selectHomeowners()
        {
            super.clickHomeowners();
            return new NCHOWQualification(sh,path);
        }
        public NCHOWProductSelectionTable selectCommercialProperty()
        {
            super.clickCommercialProperty();
            return this;
        }
    }
}
