package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4Offerings extends Offerings<SCHO4Offerings> {

    public SCHO4Offerings(CenterSeleniumHelper sh , Path path)
    {
        super(sh, path);
    }

    public SCHO4Offerings setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public SCHO4Offerings setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public SCHO4PolicyInfo next()
    {
        super.policyInfoNext();
        return new SCHO4PolicyInfo(sh,path);
    }
}
