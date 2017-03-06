package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyNewSubmission extends NewSubmission<NCWindOnlyNewSubmission> {
    public NCWindOnlyProductSelectionTable productTable = new NCWindOnlyProductSelectionTable(sh);
    public NCWindOnlyNewSubmission(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCWindOnlyNewSubmission setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public class NCWindOnlyProductSelectionTable extends ProductSelectionTable<NCWindOnlyProductSelectionTable>
    {
        public NCWindOnlyProductSelectionTable(CenterSeleniumHelper sh)
        {
            super(sh);
        }
        public NCWindOnlyQualification selectHomeowners()
        {
            super.clickHomeowners();
            return new NCWindOnlyQualification(sh,path);
        }
        public NCWindOnlyProductSelectionTable selectCommercialProperty()
        {
            super.clickCommercialProperty();
            return this;
        }
    }
}
