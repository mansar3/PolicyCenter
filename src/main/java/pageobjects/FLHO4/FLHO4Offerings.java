package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4Offerings extends Offerings<FLHO4Offerings> {

    public FLHO4Offerings(CenterSeleniumHelper sh , Path path)
    {
        super(sh, path);
    }

    public FLHO4Offerings setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public FLHO4Offerings setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public FLHO4PolicyInfo next()
    {
        super.policyInfoNext();
        return new FLHO4PolicyInfo(sh,path);
    }
}
