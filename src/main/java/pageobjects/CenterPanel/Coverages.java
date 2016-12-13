package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class Coverages extends CenterPanelBase
{
	private CoveragesBy by;
	public PropertyEndorsements pe;
	public LiabilityEndorsements le;
	protected String coveragesBase;

	public Coverages(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Coverages";
		waitForTitle(sh);
		setID(path);
		by = new CoveragesBy();
		pe = new PropertyEndorsements(sh, path);
		le = new LiabilityEndorsements(sh, path);
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

	public PropertyEndorsements clickPropertyEndorsements()
	{
		sh.clickElement(by.propertyEndorsements);
		sh.waitForNoMask();
		return new PropertyEndorsements(sh, path);
	}

	public Coverages clickCoverages()
	{
		sh.clickElement(by.coverages);
		return new Coverages(sh, path);
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
	public LiabilityEndorsements clickLiabilityEndorsements()
	{
		sh.clickElement(by.liabilityEndorsements);
		sh.waitForNoMask();
		return new LiabilityEndorsements(sh,path);
	}




	public class CoveragesBy
	{
		//final String coveragesBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:";
		public final By 		coverages = By.id(coveragesBase + "RequiredClausesCardTab-btnInnerEl"),
								dwellingLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Dwelling']/../../../..//label[text() = 'Limit']/../..//input"),
								personalPropertyLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Personal Property']/../../../..//label[text() = 'Limit']/../..//input"),
								otherStructuresIncreasedCoverage = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:_checkbox"),
								otherStructuresPercentage = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Other Structures']/../../../..//label[text() = 'Percentage']/../..//input"),
								otherStructuresLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Other Structures']/../../../..//label[text() = 'Limit']/../..//div"),
								personalPropertyExcludedNo = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_false-inputEl"),
								personalPropertyExcludedYes = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_true-inputEl"),
								personalPropertyValuationMethod = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Personal Property']/../../../..//label[text() = 'Valuation Method']/../..//input"),
								lossOfUseLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Loss Of Use']/../../../..//label[text() = 'Limit']/../..//div"),
								lossOfUseSelection = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Loss Of Use']/../../../..//label[text() = 'Selection']/../..//input"),
								windExcludedNo = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:5:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_false-inputEl"),
								windExcludedYes = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:5:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:BooleanTermInput_true-inputEl"),
								allOtherPerils = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Section I Deductibles']/../../../..//label[text() = 'All Other Perils']/../..//input"),
								hurricane =  By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Section I Deductibles']/../../../..//label[text() = 'Hurricane']/../..//input"),
								personalLiabilityLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Personal Liability']/../../../..//label[text() = 'Limit']/../..//input"),
								medicalPaymentsLimit =  By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Medical Payments']/../../../..//label[text() = 'Limit']/../..//input"),
								windDeductibleType = By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='Wind Deductible Type']/../..//input"),
								windHail =By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='Wind/Hail']/../..//input"),
								namedStorm = By.xpath(".//*[@id='" + coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:4:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() ='Named Storm']/../..//input"),



								propertyEndorsements = By.id(coveragesBase + "OptionalPropertyCoveraqesCardTab-btnInnerEl"),
								liabilityEndorsements = By.id(coveragesBase + "OptionaLiabilityCoveraqesCardTab-btnInnerEl"),
								creditPercentage = By.xpath(".//*[@id='" + coveragesBase + "lineOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup']//label[text() = 'Credit Percentage']/../..//input"),
								occurrenceAggregateLimit = By.xpath(".//*[@id'" + coveragesBase + "dwellingOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() = 'Occurrence/Aggregate Limit']/../..//input");

								//creditValue = By.id("")



	}

	public class PropertyEndorsements extends CenterPanelBase
	{
		private PropertyEndorsementsBy by;
		protected  String coveragesBase;

		public PropertyEndorsements(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by = new PropertyEndorsementsBy();
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

		public class PropertyEndorsementsBy
		{
							// Check Boxes at top of each section
			public final By	guardianEndorsements = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Guardian Endorsement']/..//input"),


							whenSafe = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Guardian Endorsement']/..//input"),
							creditPercentage = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'WhenSafe']/../../../../div//label[text() = 'Credit Percentage']/../..//input"),
							creditValue = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'WhenSafe']/../../../../div//label[text() = 'Credit Value']/../..//div"),


							otherStructuresIncreasedCoverageRentedToOthers = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Other Structures Increased Coverage - Rented to Others']/..//input"),
							addOtherStructures = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'WhenSafe']//div[text() = 'Other Structures Increased Coverage - Rented to Others']/../../../../div//span[text() = 'Add']"),
							removeOtherStructures = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'WhenSafe']//div[text() = 'Other Structures Increased Coverage - Rented to Others']/../../../../div//span[text() = 'Remove']"),


							scheduledPersonalProperty = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Scheduled Personal Property']/..//input"),
							addScheduledPersonalProperty = By.xpath("//*[@id='" + coveragesBase + "0']///div[text() = 'Scheduled Personal Property']/../../../../div//span[text() = 'A']"),
							removeScheduledPersonalPropery = By.xpath("//*[@id='" + coveragesBase + "0']///div[text() = 'Scheduled Personal Property']/../../../../div//span[text() = 'R']"),

							creditCardFundTransferForgeryCounterfeitMoney = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Credit Card, Fund Transfer Card, Forgery and Counterfeit Money']/..//input"),
							creditCardFundTransferForgeryCounterfeitMoneyLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Credit Card, Fund Transfer Card, Forgery and Counterfeit Money']/../../../../div//label[text() = 'Limit']/../..//div"),

							screenEnclosureHurricaneCoverage = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Screen Enclosure Hurricane Coverage']/..//input"),
							screenEnclosureHurricaneCoverageLimit =By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Screen Enclosure Hurricane Coverage']/../../../../div//label[text() = 'Limit']/../..//input"),

							waterBackUp = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Water Back Up']/..//input"),
							waterBackUpLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Water Back Up']/../../../../div//label[text() = 'Limit']/../..//div"),

							inflationGuard = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Inflation Guard']/..//input"),
							percentageOfAnnualIncrease = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Inflation Guard']/../../../../div//label[text() = 'Percentage Of Annual Increase']/../..//input"),


							sinkholeLossCoverage = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Sinkhole Loss Coverage']/..//input"),
							sinkholeIndex = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Sinkhole Loss Coverage']/../../../../div//label[text() = 'Sinkhole Index']/../..//input"),
							sinkholeClaimsIndex	 = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Sinkhole Loss Coverage']/../../../../div//label[text() = 'Sinkhole Claims Index']/../..//input"),

							occurrenceAggregateLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Limited Fungi, Wet or Dry Rot, or Bacteria']/../../../../div//label[text() = 'Occurrence/Aggregate Limit']/../..//input"),

							lossAssessmentLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Loss Assessment']/../../../../div//label[text() = 'Limit']/../..//input"),

							ordinanceOrLawLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Ordinance Or Law']/../../../../div//label[text() = 'Limit']/../..//input");
			


		}
		
		public boolean isGuardianEndorsementsChecked()
		{
			return sh.checkboxHelper.isChecked(by.guardianEndorsements);
		}
		
		public PropertyEndorsements checkGuardianEndorsements()
		{
			sh.checkboxHelper.checkElement(by.guardianEndorsements);
			return this;
		}
		
		public PropertyEndorsements unCheckGuardianEndorsements()
		{
			sh.checkboxHelper.unCheckElement(by.guardianEndorsements);
			return this;
		}
		
		public String getCreditPercentage()
		{
			return sh.getValue(by.creditPercentage);
		}
		
		public PropertyEndorsements setCreditPercentage(String creditPercantage)
		{
			sh.setText(by.creditPercentage, creditPercantage);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public PropertyEndorsements clickAddOtherStructures()
		{
			sh.clickElement(by.addOtherStructures);
			sh.waitForNoMask();
			return this;
		}
		public PropertyEndorsements clickRemoveOtherStructures()
		{
			sh.clickElement(by.removeOtherStructures);
			sh.waitForNoMask();
			return this;
		}
		
		public PropertyEndorsements clickAddScheduledPersonalProperty()
		{
			sh.clickElement(by.addScheduledPersonalProperty);
			sh.waitForNoMask();
			return this;
		}

		public PropertyEndorsements clickRemoveScheduledPersonalPropery()
		{
			sh.clickElement(by.removeScheduledPersonalPropery);
			sh.waitForNoMask();
			return this;
		}
		public String getOccurrenceAggregateLimit()
		{
			return sh.getValue(by.occurrenceAggregateLimit);
		}
		
		public PropertyEndorsements setOccurrenceAggregateLimit(String occurenceAggregateLimit)
		{
			sh.setText(by.occurrenceAggregateLimit, occurenceAggregateLimit);
			sh.tab();

			return this;
		}
		public String getLossAssessmentLimit()
		{
			return sh.getValue(by.lossAssessmentLimit);
		}
		
		public PropertyEndorsements setLossAssessmentLimit(String lossAssessmentLimit)
		{
			sh.setText(by.lossAssessmentLimit, lossAssessmentLimit);
			sh.tab();

			return this;
		}
		public String getOrdinanceOrLawLimit()
		{
			return sh.getValue(by.ordinanceOrLawLimit);
		}
		
		public PropertyEndorsements setOrdinanceOrLawLimit(String ordinanceOrLawLimit)
		{
			sh.setText(by.ordinanceOrLawLimit, ordinanceOrLawLimit);
			sh.tab();

			return this;
		}
		public String getPercentageOfAnnualIncrease()
		{
			return sh.getValue(by.percentageOfAnnualIncrease);
		}
		
		public PropertyEndorsements setPercentageOfAnnualIncrease(String percentageOfAnnualIncrease)
		{
			sh.setText(by.percentageOfAnnualIncrease, percentageOfAnnualIncrease);
			sh.tab();

			return this;
		}
		
		public String getSinkholeIndex()
		{
			return sh.getValue(by.sinkholeIndex);
		}
		
		public PropertyEndorsements setSinkholeIndex(String sinkholeIndex)
		{
			sh.setText(by.sinkholeIndex, sinkholeIndex);
			sh.tab();

			return this;
		}
		
		public String getSinkholeClaimsIndex()
		{
			return sh.getValue(by.sinkholeClaimsIndex);
		}
		
		public PropertyEndorsements setSinkholeClaimsIndex(String sinkholeClaimsIndex)
		{
			sh.setText(by.sinkholeClaimsIndex, sinkholeClaimsIndex);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public String getScreenEnclosureHurricaneCoverageLimit()
		{
			return sh.getValue(by.screenEnclosureHurricaneCoverageLimit);
		}
		
		public PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String screenEnclosureHurricaneCoverageLimit)
		{
			sh.setText(by.screenEnclosureHurricaneCoverageLimit, screenEnclosureHurricaneCoverageLimit);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		
		public boolean isWhenSafeChecked()
		{
			return sh.checkboxHelper.isChecked(by.whenSafe);
		}
		
		public PropertyEndorsements checkWhenSafe()
		{
			sh.checkboxHelper.checkElement(by.whenSafe);
			return this;
		}
		
		public PropertyEndorsements unCheckWhenSafe()
		{
			sh.checkboxHelper.unCheckElement(by.whenSafe);
			return this;
		}
		
		public boolean isOtherStructuresIncreasedCoverageRentedToOthersChecked()
		{
			return sh.checkboxHelper.isChecked(by.otherStructuresIncreasedCoverageRentedToOthers);
		}
		
		public PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
		{
			sh.checkboxHelper.checkElement(by.otherStructuresIncreasedCoverageRentedToOthers);
			return this;
		}
		
		public PropertyEndorsements unCheckOtherStructuresIncreasedCoverageRentedToOthers()
		{
			sh.checkboxHelper.unCheckElement(by.otherStructuresIncreasedCoverageRentedToOthers);
			return this;
		}
		
		public boolean isScheduledPersonalPropertyChecked()
		{
			return sh.checkboxHelper.isChecked(by.scheduledPersonalProperty);
		}
		
		public PropertyEndorsements checkScheduledPersonalProperty()
		{
			sh.checkboxHelper.checkElement(by.scheduledPersonalProperty);
			return this;
		}
		
		public PropertyEndorsements unCheckScheduledPersonalProperty()
		{
			sh.checkboxHelper.unCheckElement(by.scheduledPersonalProperty);
			return this;
		}
		
		public boolean isCreditCardFundTransferForgeryCounterfeitMoneyChecked()
		{
			return sh.checkboxHelper.isChecked(by.creditCardFundTransferForgeryCounterfeitMoney);
		}
		
		public PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			sh.checkboxHelper.checkElement(by.creditCardFundTransferForgeryCounterfeitMoney);
			return this;
		}
		
		public PropertyEndorsements unCheckCreditCardFundTransferForgeryCounterfeitMoney()
		{
			sh.checkboxHelper.unCheckElement(by.creditCardFundTransferForgeryCounterfeitMoney);
			return this;
		}
		
		public boolean isScreenEnclosureHurricaneCoverageChecked()
		{
			return sh.checkboxHelper.isChecked(by.screenEnclosureHurricaneCoverage);
		}
		
		public PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
		{
			sh.checkboxHelper.checkElement(by.screenEnclosureHurricaneCoverage);
			return this;
		}
		
		public PropertyEndorsements unCheckScreenEnclosureHurricaneCoverage()
		{
			sh.checkboxHelper.unCheckElement(by.screenEnclosureHurricaneCoverage);
			return this;
		}
		
		public boolean isWaterBackUpChecked()
		{
			return sh.checkboxHelper.isChecked(by.waterBackUp);
		}
		
		public PropertyEndorsements checkWaterBackUp()
		{
			sh.checkboxHelper.checkElement(by.waterBackUp);
			return this;
		}
		
		public PropertyEndorsements unCheckWaterBackUp()
		{
			sh.checkboxHelper.unCheckElement(by.waterBackUp);
			return this;
		}
		
		public boolean isInflationGuardChecked()
		{
			return sh.checkboxHelper.isChecked(by.inflationGuard);
		}
		
		public PropertyEndorsements checkInflationGuard()
		{
			sh.checkboxHelper.checkElement(by.inflationGuard);
			return this;
		}
		
		public PropertyEndorsements unCheckInflationGuard()
		{
			sh.checkboxHelper.unCheckElement(by.inflationGuard);
			return this;
		}
		
		public boolean isSinkholeLossCoverageChecked()
		{
			return sh.checkboxHelper.isChecked(by.sinkholeLossCoverage);
		}
		
		public PropertyEndorsements checkSinkholeLossCoverage()
		{
			sh.checkboxHelper.checkElement(by.sinkholeLossCoverage);
			return this;
		}
		
		public PropertyEndorsements unCheckSinkholeLossCoverage()
		{
			sh.checkboxHelper.unCheckElement(by.sinkholeLossCoverage);
			return this;
		}
		public RiskAnalysis next()
		{
			sh.waitForNoMask(15);
			sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
			return new RiskAnalysis(sh,path);
		}
		

	}



	public class LiabilityEndorsements extends CenterPanelBase
	{

		private LiabilityEndorsementsBy by;
		protected  String coveragesBase;
		public LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by = new LiabilityEndorsementsBy();

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
		public class LiabilityEndorsementsBy
		{
			final By 	permittedIncidentalOccupancyLiability = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Permitted Incidental Occupancy - Liability']/..//input"),


						animalLiability = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Animal Liability']/..//input"),
						animalLiabilityLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Animal Liability']/../../../../div//label[text() = 'Limit']/../..//div"),


						additionalResidenceRentedToOthers = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Additional Residence Rented to Others']/..//input"),
						locationName = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Additional Residence Rented to Others']/../../../../div//label[text() = 'Location Name']/../..//input"),
						numberOfFamilies = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Additional Residence Rented to Others']/../../../../div//label[text() = 'Number of Families']/../..//input"),



						businessPursuits = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Business Pursuits']/..//input"),
						businessActivity = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Business Pursuits']/../../../../div//label[text() = 'Business Activity']/../..//input"),


						watercraftLiability = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Watercraft Liability']/..//input"),
						watercraftType = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Watercraft Liability']/../../../../div//label[text() = 'Watercraft Type']/../..//input");

		}
		public String getLocationName()
		{
			return sh.getValue(by.locationName);
		}
		
		public LiabilityEndorsements setLocationName(String locationName)
		{
			sh.setText(by.locationName, locationName);
			sh.tab();

			return this;
		}
		public String getNumberOfFamilies()
		{
			return sh.getValue(by.numberOfFamilies);
		}
		
		public LiabilityEndorsements setNumberOfFamilies(String numberOfFamilies)
		{
			sh.setText(by.numberOfFamilies, numberOfFamilies);
			sh.tab();

			return this;
		}
		public String getWatercraftType()
		{
			return sh.getValue(by.watercraftType);
		}
		
		public LiabilityEndorsements setWatercraftType(String watercraftType)
		{
			sh.setText(by.watercraftType, watercraftType);
			sh.tab();

			return this;
		}
		
		public String getBusinessActivity()
		{
			return sh.getValue(by.businessActivity);
		}
		
		public LiabilityEndorsements setBusinessActivity(String businessActivity)
		{
			sh.setText(by.businessActivity, businessActivity);
			sh.tab();

			return this;
		}
		public boolean isPermittedIncidentalOccupancyLiabilityChecked()
		{
			return sh.checkboxHelper.isChecked(by.permittedIncidentalOccupancyLiability);
		}
		
		public LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
		{
			sh.checkboxHelper.checkElement(by.permittedIncidentalOccupancyLiability);
			return this;
		}
		
		public LiabilityEndorsements unCheckPermittedIncidentalOccupancyLiability()
		{
			sh.checkboxHelper.unCheckElement(by.permittedIncidentalOccupancyLiability);
			return this;
		}
		
		public boolean isAnimalLiabilityChecked()
		{
			return sh.checkboxHelper.isChecked(by.animalLiability);
		}
		
		public LiabilityEndorsements checkAnimalLiability()
		{
			sh.checkboxHelper.checkElement(by.animalLiability);
			return this;
		}
		
		public LiabilityEndorsements unCheckAnimalLiability()
		{
			sh.checkboxHelper.unCheckElement(by.animalLiability);
			return this;
		}
		
		public boolean isAdditionalResidenceRentedToOthersChecked()
		{
			return sh.checkboxHelper.isChecked(by.additionalResidenceRentedToOthers);
		}
		
		public LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
		{
			sh.checkboxHelper.checkElement(by.additionalResidenceRentedToOthers);
			return this;
		}
		
		public LiabilityEndorsements unCheckAdditionalResidenceRentedToOthers()
		{
			sh.checkboxHelper.unCheckElement(by.additionalResidenceRentedToOthers);
			return this;
		}
		
		public boolean isBusinessPursuitsChecked()
		{
			return sh.checkboxHelper.isChecked(by.businessPursuits);
		}
		
		public LiabilityEndorsements checkBusinessPursuits()
		{
			sh.checkboxHelper.checkElement(by.businessPursuits);
			return this;
		}
		
		public LiabilityEndorsements unCheckBusinessPursuits()
		{
			sh.checkboxHelper.unCheckElement(by.businessPursuits);
			return this;
		}
		public boolean isWatercraftLiabilityChecked()
		{
			return sh.checkboxHelper.isChecked(by.watercraftLiability);
		}
		
		public LiabilityEndorsements checkWatercraftLiability()
		{
			sh.checkboxHelper.checkElement(by.watercraftLiability);
			return this;
		}
		
		public LiabilityEndorsements unCheckWatercraftLiability()
		{
			sh.checkboxHelper.unCheckElement(by.watercraftLiability);
			return this;
		}
		
		
		

	}
}