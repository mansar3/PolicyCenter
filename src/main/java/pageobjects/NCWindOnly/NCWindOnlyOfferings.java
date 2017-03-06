package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyOfferings extends Offerings<NCWindOnlyOfferings> {
    public NCWindOnlyOfferings(CenterSeleniumHelper sh , Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyOfferings setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public NCWindOnlyOfferings setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public NCWindOnlyPolicyInfo next()
    {
        super.policyInfoNext();
        return new NCWindOnlyPolicyInfo(sh,path);
    }
}

