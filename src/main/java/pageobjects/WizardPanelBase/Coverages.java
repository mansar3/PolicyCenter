package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public abstract class Coverages<T  extends Coverages> extends CenterPanelBase
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
		System.out.println("Navigated to page: " + expectedPanelTitle);
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


	protected T coveragesNext()
	{
		clickNext();
		return (T)this;
	}
	protected String getDwellingLimit()
	{
		return sh.getValue(by.dwellingLimit);

	}


	protected T setDwellingLimit(String limit)
	{

		sh.setText(by.dwellingLimit, limit);
		sh.tab();
		// Used to prevent Stale Element Exception
		sh.waitForNoMask();
		// In place in case mask disappears but value still isn't loaded
		sh.waitForValue(by.personalPropertyLimit,15);
		return (T)this;
	}

	protected T setPersonalPropertyLimit(String limit)
	{
		sh.setText(by.personalPropertyLimit, limit);
		return (T)this;

	}
	public String getPersonalPropertyLimit()
	{
		return sh.getValue(by.personalPropertyLimit);
	}

	protected String getOtherStructuresPercentage()
	{
		return sh.getValue(by.otherStructuresPercentage);
	}

	protected T setOtherStructuresPercentage(String otherStructuresPercentage)
	{
		sh.setText(by.otherStructuresPercentage, otherStructuresPercentage);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getOtherStructuresLimit()
	{
		sh.waitForElementToAppear(by.otherStructuresLimit);
		return sh.getText(by.otherStructuresLimit); // getValue is always returning null since this element is now a div with innerHTML instead of textbox
	}           									 // you can change this function if you have a better idea */

	/*
	protected String getUpdatedOtherStructuresLimit()
	{
		sh.waitForElementToAppear(by.otherStructuresLimit);
		sh.waitForValueToBeNotEmpty(by.otherStructuresLimit);
		return sh.getText(by.otherStructuresLimit);
	}
	*/
	protected T setPersonalPropertyExcluded(String flag)
	{
		sh.clickElement(By.xpath("//*[@id = '" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Personal Property']/../..//span[text() = 'Excluded?']/../..//label[contains(@id, '"
		+ flag.toLowerCase() + "')]/..//input"));
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getPersonalPropertyValuationMethod()
	{
		sh.waitForNoMask();
		return sh.getValue(by.personalPropertyValuationMethod);
	}

	protected T setPersonalPropertyValuationMethod(String personalPropertyValuationMethod)
	{
		sh.waitForNoMask();
		sh.waitForPageLoad();
		sh.setText(by.personalPropertyValuationMethod, personalPropertyValuationMethod);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getLossOfUseSelection()
	{
		return sh.getValue(by.lossOfUseSelection);
	}

	protected T setLossOfUseSelection(String lossOfUseSelection)
	{
		sh.waitForNoMask();
		sh.setText(by.lossOfUseSelection, lossOfUseSelection);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getLossOfUseLimit()
	{
		return sh.getValue(by.lossOfUseLimit);
	}

	protected String getHurricane()
	{
		return sh.getValue(by.hurricane);
	}

	protected T setHurricane(String hurricane)
	{
		sh.setText(by.hurricane, hurricane);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getAllOtherPerils()
	{
		return sh.getValue(by.allOtherPerils);
	}

	protected T setAllOtherPerils(String allOtherPerils)
	{
		sh.setText(by.allOtherPerils, allOtherPerils);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setWindExcluded(String flag)
	{
		sh.clickElement(By.xpath("//*[@id = '" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Section I Deductibles']/../..//span[text() = 'Wind Excluded?']/../..//label[contains(@id, '"
		+ flag.toLowerCase() + "')]/..//input"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getPersonalLiabilityLimit()
	{
		return sh.getValue(by.personalLiabilityLimit);
	}

	protected T setPersonalLiabilityLimit(String personalLiabilityLimit)
	{
		sh.setText(by.personalLiabilityLimit, personalLiabilityLimit);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getMedicalPaymentsLimit()
	{
		return sh.getValue(by.medicalPaymentsLimit);
	}

	protected T setMedicalPaymentsLimit(String medicalPaymentsLimit)
	{
		sh.setText(by.medicalPaymentsLimit, medicalPaymentsLimit);
		sh.tab();

		return (T)this;
	}

	protected T clickPropertyEndorsementsTab()
	{
		sh.clickElement(by.propertyEndorsements);
		sh.waitForNoMask();
		return (T)this;
	}

	protected T clickCoverages()
	{
		sh.clickElement(by.coverages);
		return (T)this;
	}
	protected String getWindDeductibleType()
	{
		return sh.getValue(by.windDeductibleType);
	}
	
	protected T setWindDeductibleType(String windDeductibleType)
	{
		sh.setText(by.windDeductibleType, windDeductibleType);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getWindHail()
	{

		return sh.getValue(by.windHail);
	}

	protected T setWindHail(String windHail)
	{
		sh.setText(by.windHail, windHail);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getNamedStorm()
	{
		return sh.getValue(by.namedStorm);
	}

	protected T setNamedStorm(String namedStorm)
	{
		sh.setText(by.namedStorm, namedStorm);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected T clickLiabilityEndorsementsTab()
	{
		sh.clickElement(by.liabilityEndorsements);
		sh.waitForNoMask();
		return (T)this;
	}




	public class CoveragesBy
	{
		//final String coveragesBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:";
		public final By 		coverages = By.id(coveragesBase + "RequiredClausesCardTab-btnInnerEl"),
								dwellingLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Dwelling']/../..//span[text() = 'Limit']/../..//input"),
								personalPropertyLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Personal Property']/../..//span[text() = 'Limit']/../..//input"),
								otherStructuresIncreasedCoverage = By.id(coveragesBase + "sectionIRequiredClauses:ClausesInCategories_fliPanelSet:coveragesDV:2:Coverage_fliInputSet:CovPatternInputGroup:_checkbox"),
								otherStructuresPercentage = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Other Structures']/../..//span[text() = 'Percentage']/../..//input"),
								otherStructuresLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Other Structures']/../..//span[text() = 'Limit']/../..//div[@role='textbox']"),
								personalPropertyValuationMethod = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Personal Property']/../..//span[text() = 'Valuation Method']/../..//input"),
								lossOfUseLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Loss Of Use']/../..//span[text() = 'Limit']/../..//div"),
								lossOfUseSelection = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Loss Of Use']/../..//span[text() = 'Selection']/../..//input"),
								allOtherPerils = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Section I Deductibles']/../..//span[text() = 'All Other Perils']/../..//input"),
								hurricane =  By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Section I Deductibles']/../..//span[text() = 'Hurricane']/../..//input"),
								personalLiabilityLimit = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Personal Liability']/../..//span[text() = 'Limit']/../..//input"),
								medicalPaymentsLimit =  By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Medical Payments']/../..//span[text() = 'Limit']/../..//input"),
								windDeductibleType = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Section I Deductibles']/../..//span[text() = 'Wind Deductible Type']/../..//input"),
								windHail =By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Section I Deductibles']/../..//span[text() = 'Wind/Hail']/../..//input"),
								namedStorm = By.xpath(".//*[@id='" + coveragesBase + "RequiredClausesCardTab:panelId']//div[text() = 'Section I Deductibles']/../..//span[text() = 'Named Storm']/../..//input"),
								personalLiabilityLabel = By.id("ext-element-1300"),
								propertyEndorsements = By.id(coveragesBase + "OptionalPropertyCoveraqesCardTab-btnInnerEl"),
								liabilityEndorsements = By.id(coveragesBase + "OptionaLiabilityCoveraqesCardTab-btnInnerEl"),
								creditPercentage = By.xpath(".//*[@id='" + coveragesBase + "lineOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup']//label[text() = 'Credit Percentage']/../..//input"),
								occurrenceAggregateLimit = By.xpath(".//*[@id'" + coveragesBase + "dwellingOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup-innerCt']//label[text() = 'Occurrence/Aggregate Limit']/../..//input");

								//creditValue = By.id("")



	}

	protected boolean isPersonalLiabilityLabelRequired()
	{
		return sh.isFieldMarkedRequired(by.personalLiabilityLimit);
	}

	protected boolean isPersonalLiabilityDropdownEnabled()
	{
		return sh.isElementEnabled(by.personalLiabilityLimit);
	}

	public class PropertyEndorsements<T extends PropertyEndorsements> extends CenterPanelBase
	{
		private PropertyEndorsementsBy by;
		protected String coveragesBase;

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
			public final By coverages = By.id(coveragesBase + "RequiredClausesCardTab-btnInnerEl"),
			liabilityEndorsements = By.id(coveragesBase + "OptionaLiabilityCoveraqesCardTab-btnInnerEl"),


			guardianEndorsements = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Guardian Endorsement']/..//input"),


			whenSafe = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'WhenSafe']/..//input"),
			creditPercentage = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'WhenSafe']/../../div//span[text() = 'Credit Percentage']/../..//input"),
			creditValue = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'WhenSafe']/../../div//span[text() = 'Credit Value']/../..//div"),

			specificOtherStructures = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Specific Other Structures']/..//input"),
			addSpecificStructures = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Specific Other Structures']/../../../..//span[text() = 'Add']"),
			removeSpecificStructures = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Specific Other Structures']/../../../..//span[text() = 'Remove']"),

			otherStructuresIncreasedCoverageRentedToOthers = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Other Structures Increased Coverage - Rented to Others']/..//input"),
			addOtherStructures = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Other Structures Increased Coverage - Rented to Others']/../../../..//span[text() = 'Add']"),
			removeOtherStructures = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Other Structures Increased Coverage - Rented to Others']/../../div//span[text() = 'Remove']"),


			scheduledPersonalProperty = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Scheduled Personal Property']/..//input"),
			addScheduledPersonalProperty = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Scheduled Personal Property']/../../div//span[text() = 'A']"),
			removeScheduledPersonalProperty = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Scheduled Personal Property']/../../div//span[text() = 'R']"),

			permittedIncidentalOccupancy = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Permitted Incidental Occupancy - Property']/..//input"),

			creditCardFundTransferForgeryCounterfeitMoney = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Credit Card, Fund Transfer Card, Forgery and Counterfeit Money']/..//input"),
			creditCardFundTransferForgeryCounterfeitMoneyLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Credit Card, Fund Transfer Card, Forgery and Counterfeit Money']/../../div//span[text() = 'Limit']/../..//input"),

			screenEnclosureHurricaneCoverage = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Screen Enclosure Hurricane Coverage']/..//input"),
			screenEnclosureHurricaneCoverageLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Screen Enclosure Hurricane Coverage']/../../div//span[text() = 'Limit']/../..//input"),

			earthquakeCoverage = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Earthquake Coverage']/..//input"),
			earthquakeCoverageDeductiblePercentage = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Earthquake Coverage']/../../div//span[text() = 'Deductible Percentage']/../..//input"),

			specificAdditionalAmountOfCoverageA = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Specified Additional Amount of Coverage A']/..//input"),
			specificAdditionalAmountOfCoverageALimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Specified Additional Amount of Coverage A']/../../div//span[text() = 'Limit']/../..//div/div"),

			earthquakeLossAssessment = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Earthquake Loss Assessment']/..//input"),
			earthquakeLossAssessmentLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Earthquake Loss Assessment']/../../div//span[text() = 'Limit']/../..//input"),

			waterBackUp = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Water Back Up']/..//input"),
			waterBackUpLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Water Back Up']/../../div//span[text() = 'Limit']/../..//div/div"),

			inflationGuard = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Inflation Guard']/..//input"),
			percentageOfAnnualIncrease = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Inflation Guard']/../../div//span[text() = 'Percentage Of Annual Increase']/../../div/div"),


			sinkholeLossCoverage = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Sinkhole Loss Coverage']/..//input"),
			sinkholeIndex = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Sinkhole Loss Coverage']/../../div//span[text() = 'Sinkhole Index']/../..//input"),
			sinkholeClaimsIndex = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Sinkhole Loss Coverage']/../../div//span[text() = 'Sinkhole Claims Index']/../..//input"),

			occurrenceAggregateLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Limited Fungi, Wet or Dry Rot, or Bacteria']/../../div//span[text() = 'Occurrence/Aggregate Limit']/../..//input"),

			lossAssessmentLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Loss Assessment']/../../div//span[text() = 'Limit']/../..//input"),

			ordinanceOrLawLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Ordinance Or Law']/../../div//span[text() = 'Limit']/../..//input");


		}
		protected T checkSpecificAdditionalAmountOfCoverageA()
		{
			sh.clickElement(by.specificAdditionalAmountOfCoverageA);
			sh.waitForNoMask();
			return (T)this;
		}
		protected boolean isSpecificAdditionalAmountOfCoverageAChecked()
		{
			return sh.isDisplayed(by.specificAdditionalAmountOfCoverageALimit);
		}

		protected String getWaterBackUpLimit()
		{
			return sh.getText(by.waterBackUpLimit);
		}


		protected T setDoesExteriorMasonryVeneerExclusionApply(String flag)
		{
			sh.clickElement(By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Earthquake Coverage']" + "/../../div//span[text() = 'Does Exterior Masonry Veneer Exclusion Apply?']/../..//input[contains(@id,'" + flag.toLowerCase() + "')]"));
			sh.waitForNoMask();
			return (T)this;
		}
		protected boolean isEarthQuakeLossAssessmentChecked()
		{
			return sh.isDisplayed(by.earthquakeLossAssessmentLimit);
		}
		protected T setPersonalPropertyArticleType(int itemNumber, String articleType)
		{
			sh.clickElement(By.xpath("//*[@id = '" + coveragesBase + "OptionalPropertyCoveraqesCardTab:panelId']" + "//div[text() = 'Scheduled Personal Property']/../../../..//div[text() = '" + String.valueOf(itemNumber) + "']/../following-sibling::td[1]//div"));

			sh.waitForElementToAppear(By.name("c2"));
			// Input text here
			sh.setText(By.name("c2"), articleType);

			sh.waitForNoMask();
			return (T)this;
		}

		protected T setPersonalPropertyDescription(int itemNumber, String description)
		{
			sh.clickElement(By.xpath("//*[@id = '" + coveragesBase + "OptionalPropertyCoveraqesCardTab:panelId']" + "//div[text() = 'Scheduled Personal Property']/../../../..//div[text() = '" + String.valueOf(itemNumber) + "']/../following-sibling::td[2]//div"));

			sh.waitForElementToAppear(By.name("c3"));
			// Input text here
			sh.setText(By.name("c3"), description);

			return (T)this;
		}

		protected T setPersonalPropertyValue(int itemNumber, String value)
		{
			sh.clickElement(By.xpath("//*[@id = '" + coveragesBase + "OptionalPropertyCoveraqesCardTab:panelId']" + "//div[text() = 'Scheduled Personal Property']/../../../..//div[text() = '" + String.valueOf(itemNumber) + "']/../following-sibling::td[3]//div"));

			sh.waitForElementToAppear(By.name("c4"));
			// Input text here
			sh.setText(By.name("c4"), value);

			sh.waitForNoMask();
			return (T)this;
		}

		protected T setOtherStructuresDescription(int itemNumber, String description)
		{
			sh.clickElement(By.xpath("//*[@id = '" + coveragesBase + "OptionalPropertyCoveraqesCardTab:panelId']" + "//div[text() = 'Other Structures Increased Coverage - Rented to Others']/../../../..//div[text() = '" + String.valueOf(itemNumber) + "']/../following-sibling::td[1]//div"));

			sh.waitForElementToAppear(By.name("c2"));
			// Input text here
			sh.setText(By.name("c2"), description);

			return (T)this;
		}

		protected T setOtherStructuresLimit(int itemNumber, String description)
		{
			sh.clickElement(By.xpath("//*[@id = '" + coveragesBase + "OptionalPropertyCoveraqesCardTab:panelId']" + "//div[text() = 'Other Structures Increased Coverage - Rented to Others']/../../../..//div[text() = '" + String.valueOf(itemNumber) + "']/../following-sibling::td[2]//div"));

			sh.waitForElementToAppear(By.name("c3"));
			// Input text here
			sh.setText(By.name("c3"), description);

			return (T)this;
		}

		protected T setSpecificOtherStructuresDescription(int itemNumber, String description)
		{
			sh.clickElement(By.xpath("//*[@id = '" + coveragesBase + "OptionalPropertyCoveraqesCardTab:panelId']" + "//div[text() = 'Specific Other Structures']/../../../..//div[text() = '" + String.valueOf(itemNumber) + "']/../following-sibling::td[1]//div"));

			sh.waitForElementToAppear(By.name("c2"));
			// Input text here
			sh.setText(By.name("c2"), description);

			return (T)this;
		}

		protected T setSpecificOtherStructuresLimit(int itemNumber, String description)
		{
			sh.clickElement(By.xpath("//*[@id = '" + coveragesBase + "OptionalPropertyCoveraqesCardTab:panelId']" + "//div[text() = 'Specific Other Structures']/../../../..//div[text() = '" + String.valueOf(itemNumber) + "']/../following-sibling::td[2]//div"));

			sh.waitForElementToAppear(By.name("c3"));
			// Input text here
			sh.setText(By.name("c3"), description);

			return (T)this;
		}

		protected String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
		{
			return sh.getValue(by.creditCardFundTransferForgeryCounterfeitMoneyLimit);
		}

		protected T checkEarthquakeCoverage()
		{
			sh.clickElement(by.earthquakeCoverage);
			sh.waitForNoMask();
			return (T)this;
		}
		protected boolean isEarthquakeCoverageChecked()
		{
			return sh.isDisplayed(by.earthquakeCoverageDeductiblePercentage);
		}

		protected T checkSpecificOtherStructures()
		{
			sh.waitForNoMask();
			sh.clickElement(by.specificOtherStructures);
			return (T)this;
		}

		protected T checkEarthquakeLossAssessment()
		{
			sh.clickElement(by.earthquakeLossAssessment);
			sh.waitForNoMask();
			return (T)this;
		}

		protected String getEarthquakeLossAssessmentLimit()
		{
			return sh.getValue(by.earthquakeLossAssessmentLimit);
		}

		protected T setEarthquakeLossAssessmentLimit(String earthquakeLossAssessmentLimit)
		{
			sh.setText(by.earthquakeLossAssessmentLimit, earthquakeLossAssessmentLimit);
			sh.tab();
			sh.waitForNoMask();
			return (T)this;
		}

		protected String getEarthquakeCoverageDeductiblePercentage()
		{
			return sh.getValue(by.earthquakeCoverageDeductiblePercentage);
		}

		protected T setEarthquakeCoverageDeductiblePercentage(String earthquakeCoverageDeductiblePercentage)
		{
			sh.setText(by.earthquakeCoverageDeductiblePercentage, earthquakeCoverageDeductiblePercentage);
			sh.tab();
			sh.waitForNoMask();

			return (T)this;
		}


		protected T setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String creditCardFundTransferForgeryCounterfeitMoneyLimit)
		{
			sh.setText(by.creditCardFundTransferForgeryCounterfeitMoneyLimit, creditCardFundTransferForgeryCounterfeitMoneyLimit);
			sh.tab();

			return (T)this;
		}

		protected T clickLiabilityEndorsementsTab()
		{
			sh.clickElement(by.liabilityEndorsements);
			sh.waitForNoMask();
			return (T)this;
		}

		protected T clickCoveragesTab()
		{
			sh.clickElement(by.coverages);
			return (T)this;
		}

		protected boolean isPermittedIncidentalOccupancyChecked()
		{
			return sh.checkboxHelper.isChecked(by.permittedIncidentalOccupancy);
		}

		protected T checkPermittedIncidentalOccupancy()
		{
			sh.checkboxHelper.checkElement(by.permittedIncidentalOccupancy);
			return (T)this;
		}

		protected T unCheckPermittedIncidentalOccupancy()
		{
			sh.checkboxHelper.unCheckElement(by.permittedIncidentalOccupancy);
			return (T)this;
		}


		protected boolean isGuardianEndorsementsChecked()
		{
			return sh.checkboxHelper.isChecked(by.guardianEndorsements);
		}

		protected T checkGuardianEndorsements()
		{
			sh.checkboxHelper.checkElement(by.guardianEndorsements);
			sh.waitForNoMask();
			return (T)this;
		}

		protected T unCheckGuardianEndorsements()
		{
			sh.checkboxHelper.unCheckElement(by.guardianEndorsements);
			return (T)this;
		}

		protected String getWhenSafeCreditPercentage()
		{
			return sh.getValue(by.creditPercentage);
		}

		protected T setWhenSafeCreditPercentage(String creditPercantage)
		{
			sh.setText(by.creditPercentage, creditPercantage);
			sh.tab();
			sh.waitForNoMask();
			return (T)this;
		}

		protected T addSpecificOtherStructures()
		{
			if(sh.isDisplayed(by.addSpecificStructures))
				sh.clickElement(by.addSpecificStructures);
			else
				sh.clickElement(By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Specific Other Structures']/../../../..//span[text() = 'A']"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T removeSpecificOtherStructures()
		{
			if(sh.isDisplayed(by.removeSpecificStructures))
				sh.clickElement(by.removeSpecificStructures);
			else
				sh.clickElement(By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Specific Other Structures']/../../../..//span[text() = 'R']"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T clickAddOtherStructures()
		{
			if(sh.isDisplayed(by.addOtherStructures))
				sh.clickElement(by.addOtherStructures);
			else
				sh.clickElement(By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Other Structures Increased Coverage - Rented to Others']/../../../..//span[text() = 'A']"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T clickRemoveOtherStructures()
		{
			if(sh.isDisplayed(by.removeOtherStructures))
				sh.clickElement(by.removeOtherStructures);
			else
				By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Other Structures Increased Coverage - Rented to Others']/../../div//span[text() = 'R']");
			sh.waitForNoMask();
			return (T)this;
		}

		protected T clickAddScheduledPersonalProperty()
		{
			if(sh.isDisplayed(by.addScheduledPersonalProperty))
				sh.clickElement(by.addScheduledPersonalProperty);
			else
				sh.clickElement(By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Scheduled Personal Property']/../../div//span[text() = 'Add']"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T clickRemoveScheduledPersonalProperty()
		{
			if(sh.isDisplayed(by.removeScheduledPersonalProperty))
				sh.clickElement(by.removeScheduledPersonalProperty);
			else
				sh.clickElement(By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Scheduled Personal Property']/../../div//span[text() = 'Remove']"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected String getOccurrenceAggregateLimit()
		{
			return sh.getValue(by.occurrenceAggregateLimit);
		}

		protected T setOccurrenceAggregateLimit(String occurenceAggregateLimit)
		{
			sh.setText(by.occurrenceAggregateLimit, occurenceAggregateLimit);
			sh.tab();

			return (T)this;
		}

		protected String getLossAssessmentLimit()
		{
			return sh.getValue(by.lossAssessmentLimit);
		}

		protected T setLossAssessmentLimit(String lossAssessmentLimit)
		{
			sh.setText(by.lossAssessmentLimit, lossAssessmentLimit);
			sh.tab();

			return (T)this;
		}

		protected String getOrdinanceOrLawLimit()
		{
			return sh.getValue(by.ordinanceOrLawLimit);
		}

		protected T setOrdinanceOrLawLimit(String ordinanceOrLawLimit)
		{
			sh.setText(by.ordinanceOrLawLimit, ordinanceOrLawLimit);
			sh.tab();

			return (T)this;
		}

		protected String getPercentageOfAnnualIncrease()
		{
			return sh.getValue(by.percentageOfAnnualIncrease);
		}

		protected T setPercentageOfAnnualIncrease(String percentageOfAnnualIncrease)
		{
			sh.setText(by.percentageOfAnnualIncrease, percentageOfAnnualIncrease);
			sh.tab();

			return (T)this;
		}

		protected String getSinkholeIndex()
		{
			return sh.getValue(by.sinkholeIndex);
		}

		protected T setSinkholeIndex(String sinkholeIndex)
		{
			sh.setText(by.sinkholeIndex, sinkholeIndex);
			sh.tab();

			return (T)this;
		}

		protected boolean isCreditCardCheckBoxAvailable()
		{
			if(sh.isDisplayed(by.creditCardFundTransferForgeryCounterfeitMoney))
				return true;
			return false;
		}
		
		protected String getSinkholeClaimsIndex()
		{
			return sh.getValue(by.sinkholeClaimsIndex);
		}
		
		protected T setSinkholeClaimsIndex(String sinkholeClaimsIndex)
		{
			sh.setText(by.sinkholeClaimsIndex, sinkholeClaimsIndex);
			sh.tab();
			sh.waitForNoMask();
			return (T)this;
		}
		protected String getScreenEnclosureHurricaneCoverageLimit()
		{
			return sh.getValue(by.screenEnclosureHurricaneCoverageLimit);
		}
		
		protected T setScreenEnclosureHurricaneCoverageLimit(String screenEnclosureHurricaneCoverageLimit)
		{
			sh.setText(by.screenEnclosureHurricaneCoverageLimit, screenEnclosureHurricaneCoverageLimit);
			sh.tab();
			sh.waitForNoMask();
			return (T)this;
		}
		
		protected boolean isWhenSafeChecked()
		{
			return sh.isDisplayed(by.creditPercentage);
		}
		
		protected T checkWhenSafe()
		{
			sh.checkboxHelper.checkElement(by.whenSafe);
			return (T)this;
		}
		
		protected T unCheckWhenSafe()
		{
			sh.checkboxHelper.unCheckElement(by.whenSafe);
			return (T)this;
		}
		
		protected boolean isOtherStructuresIncreasedCoverageRentedToOthersChecked()
		{
			return sh.checkboxHelper.isChecked(by.otherStructuresIncreasedCoverageRentedToOthers);
		}
		
		protected T checkOtherStructuresIncreasedCoverageRentedToOthers()
		{
			sh.checkboxHelper.checkElement(by.otherStructuresIncreasedCoverageRentedToOthers);
			return (T)this;
		}
		
		protected T unCheckOtherStructuresIncreasedCoverageRentedToOthers()
		{
			sh.checkboxHelper.unCheckElement(by.otherStructuresIncreasedCoverageRentedToOthers);
			return (T)this;
		}
		
		protected boolean isScheduledPersonalPropertyChecked()
		{
			return sh.checkboxHelper.isChecked(by.scheduledPersonalProperty);
		}
		
		protected T checkScheduledPersonalProperty()
		{
			sh.waitForNoMask();
//			for(int i=0;i < 5;i++)
//			{
//				sh.checkboxHelper.checkElement(by.scheduledPersonalProperty);
//				sh.waitForNoMask();
//				if(sh.isDisplayed(By.xpath("//*[@id = '" + coveragesBase + "OptionalPropertyCoveraqesCardTab:panelId']" + "//div[text() = 'Scheduled Personal Property']/../../../..//div[text() = '" + String.valueOf("1") + "']/../following-sibling::td[1]//div")))
//					break;
//			}
			sh.checkboxHelper.checkElement(by.scheduledPersonalProperty);
			sh.waitForNoMask();
			// Sometimes the checkbox will show up as not clicked.
			if(sh.isDisplayed(By.xpath("//*[@id = '" + coveragesBase + "OptionalPropertyCoveraqesCardTab:panelId']" + "//div[text() = 'Scheduled Personal Property']/../../../..//div[text() = '" + String.valueOf("1") + "']/../following-sibling::td[1]//div")))
				sh.checkboxHelper.checkElement(by.scheduledPersonalProperty);
			// Added because mask would appear,disappear, then reappear and it would throw error on next method.
			try
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			sh.waitForNoMask();
			return (T)this;
		}
		
		protected T unCheckScheduledPersonalProperty()
		{
			sh.checkboxHelper.unCheckElement(by.scheduledPersonalProperty);
			return (T)this;
		}
		
		protected boolean isCreditCardFundTransferForgeryCounterfeitMoneyChecked()
		{
			return sh.checkboxHelper.isChecked(by.creditCardFundTransferForgeryCounterfeitMoney);
		}
		
		protected T checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			sh.checkboxHelper.checkElement(by.creditCardFundTransferForgeryCounterfeitMoney);
			return (T)this;
		}
		
		protected T unCheckCreditCardFundTransferForgeryCounterfeitMoney()
		{
			sh.checkboxHelper.unCheckElement(by.creditCardFundTransferForgeryCounterfeitMoney);
			return (T)this;
		}
		
		protected boolean isScreenEnclosureHurricaneCoverageChecked()
		{
			return sh.checkboxHelper.isChecked(by.screenEnclosureHurricaneCoverage);
		}
		
		protected T checkScreenEnclosureHurricaneCoverage()
		{
			sh.checkboxHelper.checkElement(by.screenEnclosureHurricaneCoverage);
			sh.waitForNoMask();
			return (T)this;
		}
		
		protected T unCheckScreenEnclosureHurricaneCoverage()
		{
			sh.checkboxHelper.unCheckElement(by.screenEnclosureHurricaneCoverage);
			return (T)this;
		}
		
		protected boolean isWaterBackUpChecked()
		{
			return sh.isDisplayed(by.waterBackUpLimit);
		}

		
		protected T checkWaterBackUp()
		{
			sh.checkboxHelper.checkElement(by.waterBackUp);
			return (T)this;
		}
		
		protected T unCheckWaterBackUp()
		{
			sh.checkboxHelper.unCheckElement(by.waterBackUp);
			return (T)this;
		}
		
		protected boolean isInflationGuardChecked()
		{
			return sh.isDisplayed(by.percentageOfAnnualIncrease);
		}
		
		protected T checkInflationGuard()
		{
			sh.checkboxHelper.checkElement(by.inflationGuard);
			return (T)this;
		}
		
		protected T unCheckInflationGuard()
		{
			sh.checkboxHelper.unCheckElement(by.inflationGuard);
			return (T)this;
		}
		
		protected boolean isSinkholeLossCoverageChecked()
		{
			return sh.checkboxHelper.isChecked(by.sinkholeLossCoverage);
		}
		
		protected T checkSinkholeLossCoverage()
		{
			sh.checkboxHelper.checkElement(by.sinkholeLossCoverage);
			return (T)this;
		}
		
		protected T unCheckSinkholeLossCoverage()
		{
			sh.checkboxHelper.unCheckElement(by.sinkholeLossCoverage);
			return (T)this;
		}
		protected T propertyEndorsementsNext()
		{
			sh.waitForNoMask(15);
			sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
			return (T)this;
		}



	}



	public class LiabilityEndorsements<T extends LiabilityEndorsements> extends CenterPanelBase
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
			final By 	coverages = By.id(coveragesBase + "RequiredClausesCardTab-btnInnerEl"),
						propertyEndorsements = By.id(coveragesBase + "OptionalPropertyCoveraqesCardTab-btnInnerEl"),


						permittedIncidentalOccupancyLiability = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Permitted Incidental Occupancy - Liability']/..//input"),


						animalLiability = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Animal Liability']/..//input"),
						animalLiabilityLimit = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Animal Liability']/../../div//span[text() = 'Limit']/../..//div"),


						additionalResidenceRentedToOthers = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Additional Residence Rented to Others']/..//input"),
						locationName = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Additional Residence Rented to Others']/../../div//span[text() = 'Location Name']/../..//input"),
						numberOfFamilies = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Additional Residence Rented to Others']/../../div//span[text() = 'Number of Families']/../..//input"),



						businessPursuits = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Business Pursuits']/..//input"),
						businessActivity = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Business Pursuits']/../../div//span[text() = 'Business Activity']/../..//input"),


						watercraftLiability = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Watercraft Liability']/..//input"),
						watercraftType = By.xpath("//*[@id='" + coveragesBase + "0']//div[text() = 'Watercraft Liability']/../../div//span[text() = 'Watercraft Type']/../..//input");

		}

		protected T clickPropertyEndorsementsTab()
		{
			sh.clickElement(by.propertyEndorsements);
			return (T)this;
		}
		protected T clickCoveragesTab()
		{
			sh.clickElement(by.coverages);
			return (T)this;
		}


		protected String getLocationName()
		{
			return sh.getValue(by.locationName);
		}
		
		protected T setLocationName(String locationName)
		{
			sh.setText(by.locationName, locationName);
			sh.tab();

			return (T)this;
		}
		protected String getNumberOfFamilies()
		{
			return sh.getValue(by.numberOfFamilies);
		}
		
		protected T setNumberOfFamilies(String numberOfFamilies)
		{
			sh.setText(by.numberOfFamilies, numberOfFamilies);
			sh.tab();

			return (T)this;
		}
		protected String getWatercraftType()
		{
			return sh.getValue(by.watercraftType);
		}
		
		protected T setWatercraftType(String watercraftType)
		{
			sh.setText(by.watercraftType, watercraftType);
			sh.tab();

			return (T)this;
		}
		
		protected String getBusinessActivity()
		{
			return sh.getValue(by.businessActivity);
		}
		
		protected T setBusinessActivity(String businessActivity)
		{
			sh.setText(by.businessActivity, businessActivity);
			sh.tab();

			return (T)this;
		}
		protected boolean isPermittedIncidentalOccupancyLiabilityChecked()
		{
			return sh.checkboxHelper.isChecked(by.permittedIncidentalOccupancyLiability);
		}
		
		protected T checkPermittedIncidentalOccupancyLiability()
		{
			sh.checkboxHelper.checkElement(by.permittedIncidentalOccupancyLiability);
			sh.waitForNoMask();
			return (T)this;
		}
		
		protected T unCheckPermittedIncidentalOccupancyLiability()
		{
			sh.checkboxHelper.unCheckElement(by.permittedIncidentalOccupancyLiability);
			return (T)this;
		}
		
		protected boolean isAnimalLiabilityChecked()
		{
			return sh.checkboxHelper.isChecked(by.animalLiability);
		}
		
		protected T checkAnimalLiability()
		{
			sh.checkboxHelper.checkElement(by.animalLiability);
			return (T)this;
		}
		
		protected T unCheckAnimalLiability()
		{
			sh.checkboxHelper.unCheckElement(by.animalLiability);
			return (T)this;
		}
		
		protected boolean isAdditionalResidenceRentedToOthersChecked()
		{
			return sh.checkboxHelper.isChecked(by.additionalResidenceRentedToOthers);
		}
		
		protected T checkAdditionalResidenceRentedToOthers()
		{
			sh.checkboxHelper.checkElement(by.additionalResidenceRentedToOthers);
			return (T)this;
		}
		
		protected T unCheckAdditionalResidenceRentedToOthers()
		{
			sh.checkboxHelper.unCheckElement(by.additionalResidenceRentedToOthers);
			return (T)this;
		}
		
		protected boolean isBusinessPursuitsChecked()
		{
			return sh.checkboxHelper.isChecked(by.businessPursuits);
		}
		
		protected T checkBusinessPursuits()
		{
			sh.checkboxHelper.checkElement(by.businessPursuits);
			return (T)this;
		}
		
		protected T unCheckBusinessPursuits()
		{
			sh.checkboxHelper.unCheckElement(by.businessPursuits);
			return (T)this;
		}
		protected boolean isWatercraftLiabilityChecked()
		{
			return sh.checkboxHelper.isChecked(by.watercraftLiability);
		}
		
		protected T checkWatercraftLiability()
		{
			sh.checkboxHelper.checkElement(by.watercraftLiability);
			return (T)this;
		}
		
		protected T unCheckWatercraftLiability()
		{
			sh.checkboxHelper.unCheckElement(by.watercraftLiability);
			return (T)this;
		}
		protected T liabilityEndorsementsNext()
		{
			sh.waitForNoMask(15);
			sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
			return (T)this;
		}
		
		
		

	}
}