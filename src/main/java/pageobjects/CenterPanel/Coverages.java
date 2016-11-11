package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class Coverages extends CenterPanelBase
{
	CoveragesBy by;
	public Coverages(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Coverages";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + getTitle());
	}

	public void next()
	{
		clickNext();
	}

	public Coverages setDwellingLimit(String limit)
	{
		sh.setText(by.dwellingLimit, limit);
		return this;
	}

	public Coverages setPersonalPropertyLimit(String limit)
	{
		sh.setText(by.personalPropertyLimit, limit);
		return this;
	}

	public static class CoveragesBy{
		public static final By dwellingLimit = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:DirectTermInput-inputEl"),
								personalPropertyLimit = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:2:CovTermInputSet:DirectTermInput-inputEl");
	}
}