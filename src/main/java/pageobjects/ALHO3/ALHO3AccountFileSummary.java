package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.Policy.Summary;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3AccountFileSummary extends AccountFileSummary<ALHO3AccountFileSummary>
{
	public ALHO3AccountFileSummary(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public String getAccountNumber()
	{
		return super.getAccountNumber();
	}

	public ALHO3Coverages clickCoveragesALHO3()
	{
		super.clickCoverages();
		return new ALHO3Coverages(sh, path);
	}

    public Summary clickInforcedAccountNumber()
	{
		sh.waitForNoMask();
    		super.clickInforceAccountNumber();
    		return new Summary(sh);

	}

	public Summary clickCancelledPolicyNumber()
	{
		sh.waitForNoMask();
		super.clickCanceledPolicyNumber();
		return new Summary(sh);

	}

	public Summary clickscheduledPolicyNumber()
	{
		sh.waitForNoMask();
		super.clickCanceledPolicyNumber();
		return new Summary(sh);

	}

	public ALHO3AccountFileSummary clickTransactionRenewalPending()
	{
		sh.waitForNoMask();
		return super.clickTransactionNumberRenewalPen();
	}
}
