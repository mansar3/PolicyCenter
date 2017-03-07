package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewSubmission;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueNewSubmission extends NewSubmission<ALHO3UWIssueNewSubmission> {

    public ALHO3UWIssueNewSubmission(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3UWIssueProductSelectionTable productTable = new ALHO3UWIssueProductSelectionTable(sh);

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public ALHO3UWIssueNewSubmission setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public class ALHO3UWIssueProductSelectionTable extends ProductSelectionTable<ALHO3UWIssueProductSelectionTable>
    {
        public ALHO3UWIssueProductSelectionTable(CenterSeleniumHelper sh)
        {
            super(sh);
        }
        public ALHO3UWIssueQualification selectHomeowners()
        {
            super.clickHomeowners();
            return new ALHO3UWIssueQualification(sh, path);
        }
        public ALHO3UWIssueProductSelectionTable selectCommercialProperty()
        {
            super.clickCommercialProperty();
            return this;
        }
    }
}
