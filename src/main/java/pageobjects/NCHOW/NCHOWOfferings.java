package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWOfferings extends Offerings<NCHOWOfferings> {
    public NCHOWOfferings(CenterSeleniumHelper sh , Path path)
    {
        super(sh, path);
    }

    public NCHOWOfferings setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public NCHOWOfferings setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public NCHOWPolicyInfo next()
    {
        super.policyInfoNext();
        return new NCHOWPolicyInfo(sh,path);
    }
}

