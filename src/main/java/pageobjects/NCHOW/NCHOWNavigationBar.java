package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWNavigationBar extends NavigationBar<NCHOWNavigationBar> {

    public NCHOWNavigationBar(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCHOWSearchAccounts clickSearchAccount()
    {
        super.clickSearchAccountNavBar();
        return new NCHOWSearchAccounts(sh);
    }

    public NCHOWNavigationBar clickInternalToolTab()
    {
      return   super.clickInternalToolTab();
    }
    public NCHOWNavigationBar clickTestingTimeClock()
    {
        return super.clickTestingTimeClock();
    }

    public NCHOWNavigationBar clickSettings(){return  super.clickSettings();}
    public NCHOWNavigationBar clickReturntoPolicyCenter() {return  super.clickReturntoPolicyCenter();}
}
