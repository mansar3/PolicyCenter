package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.Policy.StartPolicyChange;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by ssai on 3/20/2017.
 */
public class ALHO3StartPolicyChange extends StartPolicyChange<ALHO3StartPolicyChange> {

    public ALHO3StartPolicyChange(CenterSeleniumHelper sh, CenterPanelBase.Path path)
    {
        super(sh);
    }

    public ALHO3PolicyInfo clickYes()
    {
        super.accept();
        return new ALHO3PolicyInfo(sh, path);
    }
}
