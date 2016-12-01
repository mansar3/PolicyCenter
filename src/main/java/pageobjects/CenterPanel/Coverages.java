package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class Coverages extends CenterPanelBase
{
	private CoveragesBy by;
	protected String coveragesBase;

	public Coverages(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Coverages";
		waitForTitle(sh);
		setID(path);
		by = new CoveragesBy();
		System.out.println("Navigated to page: " + getTitle());
	}

	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				this.coveragesBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:";
				break;
			case POLICYRENEWAL:
				this.coveragesBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:";
				break;
			case POLICYCHANGE:
				this.coveragesBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:";
				break;

		}
	}


	public RiskAnalysis next()
	{
		clickNext();
		return new RiskAnalysis(sh);
	}

	public Coverages setDwellingLimit(String limit)
	{

		sh.setText(by.dwellingLimit, limit);
		sh.tab();
		sh.waitForValue(by.personalPropertyLimit,15);
		return this;
	}

	public Coverages setPersonalPropertyLimit(String limit)
	{
		sh.setText(by.personalPropertyLimit, limit);
		return this;

	}

	public class CoveragesBy
	{
		//final String coveragesBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:";

		public final By 	coverages = By.id(coveragesBase + "RequiredClausesCardTab-btnInnerEl"),
								dwellingLimit = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:DirectTermInput-inputEl"),
								personalPropertyLimit = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:2:CovTermInputSet:DirectTermInput-inputEl"),
								otherStructuresPercentage = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl"),
								otherStructuresLimit = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:1:CovTermInputSet:DirectTermInput-inputEl"),
								personalPropertyExcludedNo = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_false-inputEl"),
								personalPropertyExcludedYes = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_true-inputEl"),
								personalPropertyValuationMethod = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:4:CovTermInputSet:OptionTermInput-inputEl"),
								lossOfUseLimit = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:1:CovTermInputSet:DirectTermInput-inputEl"),
								lossOfUseSelection = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl"),
								windExcludedNo = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:5:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_false-inputEl"),
								windExcludedYes = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:5:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_true-inputEl"),
								allOtherPerils = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:5:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:1:CovTermInputSet:OptionTermInput-inputEl"),
								hurricane = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:5:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:3:CovTermInputSet:OptionTermInput-inputEl"),
								personalLiabilityLimit = By.id(coveragesBase + "sectionIIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl"),
								medicalPaymentsLimit = By.id(coveragesBase + "sectionIIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl"),

								propertyEndorsements = By.id(coveragesBase + "OptionalPropertyCoveraqesCardTab-btnInnerEl"),
								guardianEndorsement = By.id(coveragesBase + "lineOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup:_checkbox"),
								whenSafe = By.id(coveragesBase + "lineOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:_checkbox"),
								creditPercentage = By.id(coveragesBase + "lineOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl");
								//creditValue = By.id("")



	}
}