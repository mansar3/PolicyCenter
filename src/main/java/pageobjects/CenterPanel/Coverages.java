package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class Coverages extends CenterPanelBase
{
	private CoveragesBy by;
	protected String coveragesBase;

	public Coverages(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
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
		return new RiskAnalysis(sh,this.path);
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
	public String getOtherStructuresPercentage()
	{
		return sh.getValue(by.otherStructuresPercentage);
	}

	public Coverages setOtherStructuresPercentage(String otherStructuresPercentage)
	{
		sh.setText(by.otherStructuresPercentage, otherStructuresPercentage);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getOtherStructuresLimit()
	{
		return sh.getValue(by.otherStructuresLimit);
	}

	public Coverages setPersonalPropertyExcluded(boolean flag)
	{
		if(flag)
			sh.clickElement(by.personalPropertyExcludedYes);
		else
			sh.clickElement(by.personalPropertyExcludedNo);
		sh.waitForNoMask();
		return this;
	}

	public String getPersonalPropertyValuationMethod()
	{
		return sh.getValue(by.personalPropertyValuationMethod);
	}

	public Coverages setPersonalPropertyValuationMethod(String personalPropertyValuationMethod)
	{
		sh.setText(by.personalPropertyValuationMethod, personalPropertyValuationMethod);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getLossOfUseSelection()
	{
		return sh.getValue(by.lossOfUseSelection);
	}

	public Coverages setLossOfUseSelection(String lossOfUseSelection)
	{
		sh.setText(by.lossOfUseSelection, lossOfUseSelection);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public String getLossOfUseLimit()
	{
		return sh.getValue(by.lossOfUseLimit);
	}

	public String getHurricane()
	{
		return sh.getValue(by.hurricane);
	}

	public Coverages setHurricane(String hurricane)
	{
		sh.setText(by.hurricane, hurricane);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getAllOtherPerils()
	{
		return sh.getValue(by.allOtherPerils);
	}

	public Coverages setAllOtherPerils(String allOtherPerils)
	{
		sh.setText(by.allOtherPerils, allOtherPerils);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public Coverages setWindExcluded(boolean flag)
	{
		if(flag)
			sh.clickElement(by.windExcludedYes);
		else
			sh.clickElement(by.windExcludedNo);
		sh.waitForNoMask();
		return this;
	}
	public String getPersonalLiabilityLimit()
	{
		return sh.getValue(by.personalLiabilityLimit);
	}

	public Coverages setPersonalLiabilityLimit(String personalLiabilityLimit)
	{
		sh.setText(by.personalLiabilityLimit, personalLiabilityLimit);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public String getMedicalPaymentsLimit()
	{
		return sh.getValue(by.medicalPaymentsLimit);
	}

	public Coverages setMedicalPaymentsLimit(String medicalPaymentsLimit)
	{
		sh.setText(by.medicalPaymentsLimit, medicalPaymentsLimit);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public Coverages setPropertyEndorsements(String propertyEndorsements)
	{
		sh.setText(by.propertyEndorsements, propertyEndorsements);
		sh.waitForNoMask();
		return this;
	}
	public Coverages clickCoverages()
	{
		sh.clickElement(by.coverages);
		return this;
	}
	public String getWindDeductibleType()
	{
		return sh.getValue(by.windDeductibleType);
	}
	
	public Coverages setWindDeductibleType(String windDeductibleType)
	{
		sh.setText(by.windDeductibleType, windDeductibleType);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public String getWindHail()
	{

		return sh.getValue(by.windHail);
	}

	public Coverages setWindHail(String windHail)
	{
		sh.setText(by.windHail, windHail);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getNamedStorm()
	{
		return sh.getValue(by.namedStorm);
	}

	public Coverages setNamedStorm(String namedStorm)
	{
		sh.setText(by.namedStorm, namedStorm);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	


	public class CoveragesBy
	{
		//final String coveragesBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:";
		public final By 		coverages = By.id(coveragesBase + "RequiredClausesCardTab-btnInnerEl"),
								dwellingLimit = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:DirectTermInput-inputEl"),
								//personalPropertyLimit = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:2:CovTermInputSet:DirectTermInput-inputEl"),
								personalPropertyLimit = By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='Limit']/../..//input"),
								otherStructuresPercentage = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl"),
								otherStructuresLimit = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:1:CovTermInputSet:DirectTermInput-inputEl"),
								personalPropertyExcludedNo = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_false-inputEl"),
								personalPropertyExcludedYes = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_true-inputEl"),
								personalPropertyValuationMethod = By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='Valuation Method']/../..//input"),
								lossOfUseLimit = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:3:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:1:CovTermInputSet:DirectTermInput-inputEl"),
								lossOfUseSelection = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:3:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl"),
								windExcludedNo = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:5:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_false-inputEl"),
								windExcludedYes = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:5:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_true-inputEl"),
								allOtherPerils = By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='All Other Perils']/../..//input"),
								hurricane =  By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='Hurricane']/../..//input"),
								personalLiabilityLimit = By.id(coveragesBase + "sectionIIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl"),
								medicalPaymentsLimit = By.id(coveragesBase + "sectionIIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl"),
								windDeductibleType = By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='Wind Deductible Type']/../..//input"),
								windHail =By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='Wind/Hail']/../..//input"),
								namedStorm = By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='Named Storm']/../..//input"),
								propertyEndorsements = By.id(coveragesBase + "OptionalPropertyCoveraqesCardTab-btnInnerEl"),
								guardianEndorsement = By.id(coveragesBase + "lineOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup:_checkbox"),
								whenSafe = By.id(coveragesBase + "lineOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:_checkbox"),
								creditPercentage = By.id(coveragesBase + "lineOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:1:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:OptionTermInput-inputEl");
								//creditValue = By.id("")



	}
}