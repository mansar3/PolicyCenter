package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3Offerings extends Offerings<FLMH3Offerings> {

    public FLMH3Offerings(CenterSeleniumHelper sh , Path path)
    {
        super(sh, path);
    }

    public FLMH3Offerings setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public FLMH3Offerings setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public FLMH3PolicyInfo next()
    {
        super.policyInfoNext();
        return new FLMH3PolicyInfo(sh,path);
    }

}
