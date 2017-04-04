package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by aansari on 2/6/17.
 */
public class ALHO3Coverages extends Coverages<ALHO3Coverages>
{
		public ALHO3Coverages(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public ALHO3RiskAnalysis next()
	{
		coveragesNext();
		return new ALHO3RiskAnalysis(sh, path);
	}
	public String getDwellingLimit()
	{
		return super.getDwellingLimit();
	}

	public ALHO3Quote coveragesQuote(){
		super.CoverageQuote();
		return new ALHO3Quote(sh, path );
	}

	public ALHO3PreQuoteIssues  coveragesquoteWithIssues()
	{
		super.CoverageQuote();
		return new ALHO3PreQuoteIssues(sh, path);
	}

	public ALHO3Coverages setDwellingLimit(String text)
	{
		return super.setDwellingLimit(text);
	}
	public String getPersonalPropertyLimit()
	{
		return super.getPersonalPropertyLimit();
	}

	public String getPersonalPropertyLimitDiv()
	{
		return super.getPersonalPropertyLimitDiv();
	}

	public ALHO3Coverages setPersonalPropertyLimit(String text)
	{
		return super.setPersonalPropertyLimit(text);
	}
	public String getOtherStructuresPercentage()
	{
		return super.getOtherStructuresPercentage();
	}

	public ALHO3Coverages setOtherStructuresPercentage(String text)
	{
		return super.setOtherStructuresPercentage(text);
	}
	public String getOtherStructuresLimit()
	{
		return super.getOtherStructuresLimit();
	}

	public ALHO3Coverages setPersonalPropertyExcluded(String flag)
	{
		return super.setPersonalPropertyExcluded(flag);

	}
	public String getPersonalPropertyValuationMethod()
	{
		return super.getPersonalPropertyValuationMethod();
	}

	public String coveragesErrorMessage(){return super.coveragesErrorMessage();}

	public boolean isPersonalPropertyExcluded()
	{
		return super.isPersonalPropertyExcluded();
	}

	public boolean isPersonalPropertyExcludedPresent()
	{
		return super.isPersonalPropertyExcludedPresent();
	}

	public ALHO3Coverages setPersonalPropertyValuationMethod(String text)
	{
		return super.setPersonalPropertyValuationMethod(text);
	}
	public ALHO3Coverages back(){
		return super.dwellingConstructionBack();
	}

	public ALHO3Coverages coveragesEnter(){return super.coveragesEnter();}
	public ALHO3Coverages setLossOfUseSelection(String text)
	{
		return super.setLossOfUseSelection(text);
	}

	public String getLossOfUseSelection()
	{
		return super.getLossOfUseSelection();
	}
	public String getLossOfUseLimit()
	{
		return super.getLossOfUseLimit();
	}
	public String getHurricane()
	{
		return super.getHurricane();
	}

	public ALHO3Coverages setHurricane(String text)
	{
		return super.setHurricane(text);

	}
	public String getAllOtherPerils()
	{
		return super.getAllOtherPerils();
	}

	public ALHO3Coverages setAllOtherPerils(String text)
	{
		return super.setAllOtherPerils(text);

	}

	public ALHO3Coverages setWindExcluded(String flag)
	{
		return super.setWindExcluded(flag);

	}

	public String getPersonalLiabilityLimit()
	{
		return super.getPersonalLiabilityLimit();
	}

	public String getPersonalLiabilityLimitDiv()
	{
		return super.getPersonalLiabilityLimitDiv();
	}


	public ALHO3Coverages setPersonalLiabilityLimit(String text)
	{
		return super.setPersonalLiabilityLimit(text);

	}
	public String getMedicalPaymentsLimit()
	{
		return super.getMedicalPaymentsLimit();
	}

	public ALHO3Coverages setMedicalPaymentsLimit(String text)
	{
		return super.setMedicalPaymentsLimit(text);

	}

	public ALHO3Coverages clickCoverages()
	{
		return super.clickCoverages();

	}
	public String getWindDeductibleType()
	{
		return super.getWindDeductibleType();
	}

	public ALHO3Coverages setWindDeductibleType(String text)
	{
		return super.setWindDeductibleType(text);

	}
	public String getWindHail()
	{
		return super.getWindHail();
	}

	public ALHO3Coverages setWindHail(String text)
	{
		return super.setWindHail(text);

	}
	public String getNamedStorm()
	{
		return super.getNamedStorm();
	}

	public ALHO3Coverages setNamedStorm(String text)
	{
		return super.setNamedStorm(text);

	}

	public boolean isPersonalPropertyExcludedRequired()
	{
		return super.isPersonalPropertyExcludedRequired();
	}

	public boolean isPersonalLiabilityLimitRequired()
	{
		return super.isPersonalLiabilityLabelRequired();
	}

	public boolean isPersonalPropertyLimitRequired()
	{
		return super.isPersonalPropertyLabelRequired();
	}

	public boolean isLossOfUseSelectionRequired()
	{
		return super.isLossOfUseSelectionRequired();
	}

	public boolean isLossOfUseSelectionEnabled()
	{
		return super.isLossOfUseSelectionEnabled();
	}

	public boolean isAllOtherPerilsRequired()
	{
		return super.isAllOtherPerilsRequired();
	}

	public boolean isAllOtherPerilsEditable()
	{
		return super.isAllOtherPerilsEditable();
	}

	public boolean isWindHailRequired()
	{
		return super.isWindHailRequired();
	}

	public boolean isWindHailEnabled()
	{
		return super.isWindHailEnabled();
	}

	public String getWindHailDeductible()
	{
		return super.getWindHailDeductible();
	}

	public boolean isPersonalPropertyLimitEnabled()
	{
		return super.isPersonalPropertyLimitEnabled();
	}

	public boolean isPersonalLiabilityLimitEnabled()
	{
		return super.isPersonalLiabilityDropdownEnabled();
	}

	public boolean isPersonalPropertyValuationMethodRequired()
	{
		return super.isPersonalPropertyValuationMethodRequired();
	}

	public boolean isPersonalPropertyValuationMethodEnabled()
	{
		return super.isPersonalPropertyValuationMethodEnabled();
	}

	public boolean isMedicalPaymentsLimitEditable()
	{
		return super.isMedicalPaymentsLimitEditable();
	}

	public ALHO3LiabilityEndorsements clickLiabilityEndorsements()
	{
		super.clickLiabilityEndorsementsTab();
		return new ALHO3LiabilityEndorsements(sh, path);
	}
	public ALHO3PropertyEndorsements clickPropertyEndorsements()
	{
		super.clickPropertyEndorsementsTab();
		return new ALHO3PropertyEndorsements(sh,path);
	}

	public ALHO3Coverages clickSaveDraftCoverages()
	{
		super.clickSaveDraft();
		return new ALHO3Coverages(sh, path);
	}


	public class ALHO3PropertyEndorsements extends PropertyEndorsements<ALHO3PropertyEndorsements>
	{
		public ALHO3PropertyEndorsements(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public String getWaterBackUpLimit()
		{
			return super.getWaterBackUpLimit();
		}
		public ALHO3PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
		{
			return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
		}
		public boolean isEarthQuakeLossAssessment()
		{
			return super.isEarthQuakeLossAssessmentChecked();
		}
		public ALHO3PropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
		{
			return super.setPersonalPropertyArticleType(itemNumber, text);
		}
		public ALHO3PropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
		{
			return super.setPersonalPropertyDescription(itemNumber, text);
		}

		public ALHO3PropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
		{
			return super.setPersonalPropertyValue(itemNumber, text);
		}
		public ALHO3PropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setOtherStructuresDescription(itemNumber, text);
		}


		public ALHO3PropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setOtherStructuresLimit(itemNumber, text);
		}

		public ALHO3PropertyEndorsements unCheckOrdinanceOrLaw()
		{
			return super.unCheckOrdinanceOrLaw();
		}
		public ALHO3PropertyEndorsements isOrdinanceOrLawChecked()
		{
			return super.isOrdinanceLawChecked();
		}

		public ALHO3PropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresDescription(itemNumber, text);
		}

		public boolean isSpecificOtherStructuresEnabled()
		{
			return super.isSpecificOtherStructuresEnabled();
		}

		public boolean isScheduledPersonalPropertyChecked()
		{
			return super.isScheduledPersonalPropertyChecked();
		}

		public ALHO3PropertyEndorsements coveragespropertyendorsementsEnter(){return super.coveragespropertyendorsementsEnter();}

		public String coveragesPropertyEndorsnmentsErrorMessage()
		{
			return super.coveragesPropertyEndorsnmentsErrorMessage();
		}

		public ALHO3PropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresLimit(itemNumber, text);
		}
		public ALHO3PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
		{
			return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
		}

		public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
		{
			return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
		}
		public String getCreditCardFundTransferForgeryCounterfeitMoneyLimitDiv()
		{
			return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimitDiv();
		}
		public ALHO3PropertyEndorsements checkEarthQuakeCoverage()
		{
			return super.checkEarthquakeCoverage();
		}
		public boolean isEarthquakeCoverageChecked()
		{
			return super.isEarthquakeCoverageChecked();
		}
		public ALHO3PropertyEndorsements checkSpecificOtherStructures()
		{
			return super.checkSpecificOtherStructures();
		}
		
		public ALHO3PropertyEndorsements checkEarthquakeLossAssessmentChecked()
		{
			return super.checkEarthquakeLossAssessment();
		}
		public ALHO3PropertyEndorsements setEarthquakeLossAssessmentLimit(String text)
		{
			return super.setEarthquakeLossAssessmentLimit(text);
		}

		public String getEarthquakeLossAssessmentLimit()
		{
			return super.getEarthquakeLossAssessmentLimit();
		}
		public ALHO3PropertyEndorsements setEarthquakeCoverageDeductiblePercentage(String text)
		{
			return super.setEarthquakeCoverageDeductiblePercentage(text);
		}

		public String getEarthquakeCoverageDeductiblePercentage()
		{
			return super.getEarthquakeCoverageDeductiblePercentage();
		}
		public ALHO3LiabilityEndorsements clickLiabilityEndorsements()
		{
			super.clickLiabilityEndorsementsTab();
			return new ALHO3LiabilityEndorsements(sh, path);
		}
		public ALHO3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new ALHO3Coverages(sh, path);
		}

		public ALHO3Quote clickcoveragesPropertyEndorsementsQuote()
		{
			super.clickCoveragesPropertyEndorsementsQuote();
			return new ALHO3Quote(sh, path);
			
		}
		public ALHO3PropertyEndorsements checkPermittedIncidentalOccupancy()
		{
			return super.checkPermittedIncidentalOccupancy();
		}

		public ALHO3PropertyEndorsements checkGuardianEndorsements()
		{
			return super.checkGuardianEndorsements();
		}

		public boolean isGuardianEndorsementsDisplayed()
		{
			return super.isGuardianEndorsementsDisplayed();
		}

		public ALHO3PropertyEndorsements setWhenSafeCreditPercentage(String text)
		{
			return super.setWhenSafeCreditPercentage(text);
		}

		public String getWhenSafeCreditPercentage()
		{
			return super.getWhenSafeCreditPercentage();
		}
		public ALHO3PropertyEndorsements addSpecificOtherStructures()
		{
			return super.addSpecificOtherStructures();
		}
		public ALHO3PropertyEndorsements removeSpecificOtherStructures()
		{
			return super.removeSpecificOtherStructures();
		}
		public ALHO3PropertyEndorsements addOtherStructures()
		{
			return super.clickAddOtherStructures();
		}
		public ALHO3PropertyEndorsements removeOtherStructures()
		{
			return super.clickRemoveOtherStructures();
		}
		public ALHO3PropertyEndorsements setOccurrenceAggregateLimit(String text)
		{
			return super.setOccurrenceAggregateLimit(text);
		}

		public String getOccurrenceAggregateLimit()
		{
			return super.getOccurrenceAggregateLimit();
		}

		public boolean isOccurrenceAggregateLimitRequired()
		{
			return super.isOccurrenceAggregateLimitRequired();
		}

		public boolean isOccurrenceAggregateLimitEditable()
		{
			return super.isOccurrenceAggregateLimitEditable();
		}

		public boolean isOrdinanceOrLawLimitEditable()
		{
			return super.isOrdinanceOrLawEditable();
		}

		public boolean isWaterBackUpLimitEditable()
		{
			return super.isWaterBackUpLimitEditable();
		}

		public ALHO3PropertyEndorsements setLossAssessmentLimit(String text)
		{
			return super.setLossAssessmentLimit(text);
		}

		public boolean isLossAssessmentLimitRequired()
		{
			return super.isLossAssessmentLimitRequired();
		}

		public boolean isOrdinanceOrLawLimitChecked()
		{
			return super.isOrdinanceOrLawLimitChecked();
		}

		public ALHO3PropertyEndorsements checkOrdinanceOrLaw()
		{
			return super.checkOrdinanceOrLaw();
		}

		public boolean isLossAssessmentLimitEditable()
		{
			return super.isLossAssessmentLimitEditable();
		}

		public String getLossAssessmentLimit()
		{
			return super.getLossAssessmentLimit();
		}
		public ALHO3PropertyEndorsements setOrdinanceOrLawLimit(String text)
		{
			return super.setOrdinanceOrLawLimit(text);
		}

		public String getOrdinanceOrLawLimit()
		{
			return super.getOrdinanceOrLawLimit();
		}
		public ALHO3PropertyEndorsements setPercentageOfAnnualIncrease(String text)
		{
			return super.setPercentageOfAnnualIncrease(text);
		}

		public String getPercentageOfAnnualIncrease()
		{
			return super.getPercentageOfAnnualIncrease();
		}
		public ALHO3PropertyEndorsements setSinkholeIndex(String text)
		{
			return super.setSinkholeIndex(text);
		}

		public String getSinkholeIndex()
		{
			return super.getSinkholeIndex();
		}
		public boolean isCreditCardCheckBoxAvailable()
		{
			return super.isCreditCardCheckBoxAvailable();
		}

		public ALHO3PropertyEndorsements setSinkholeClaimsIndex(String text)
		{
			return super.setSinkholeClaimsIndex(text);
		}

		public String getSinkholeClaimsIndex()
		{
			return super.getSinkholeClaimsIndex();
		}
		public ALHO3PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
		{
			return super.setScreenEnclosureHurricaneCoverageLimit(text);
		}

		public String getScreenEnclosureHurricaneCoverageLimit()
		{
			return super.getScreenEnclosureHurricaneCoverageLimit();
		}

		public ALHO3PropertyEndorsements checkWhenSafe()
		{
			return super.checkWhenSafe();
		}
		public boolean isWhenSafeChecked()
		{
			return super.isWhenSafeChecked();
		}
		public ALHO3PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
		{
			return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
		}

		public ALHO3PropertyEndorsements checkScheduledPersonalProperty()
		{
			return super.checkScheduledPersonalProperty();
		}

		public ALHO3PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
		}

		public ALHO3PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
		{
			return super.checkScreenEnclosureHurricaneCoverage();
		}
		public ALHO3PropertyEndorsements clickAddScheduledPersonalProperty()
		{
			return super.clickAddScheduledPersonalProperty();

		}

		public ALHO3PropertyEndorsements clickRemoveScheduledPersonalProperty()
		{
			return super.clickRemoveScheduledPersonalProperty();
		}

		public String getScheduledPersonalPropertyClassArticleType(int itemNumber)
		{
			return super.getScheduledPersonalPropertyClassArticleType(itemNumber);
		}

		public String getScheduledPersonalPropertyClassValue(int itemNumber)
		{
			return super.getScheduledPersonalPropertyClassValue(itemNumber);
		}

		public boolean isCreditCardFundTransferForgeryCounterfeitMoneyChecked()
		{
			return super.isCreditCardFundTransferForgeryCounterfeitMoneyChecked();
		}

		public boolean isCreditCardFundTransferForgeryCounterfeitMoneyLimitRequired()
		{
			return super.isCreditCardFundTransferForgeryCounterfeitMoneyLimitRequired();
		}

		public ALHO3PropertyEndorsements checkWaterBackUp()
		{
			return super.checkWaterBackUp();
		}
		public ALHO3PropertyEndorsements unCheckWaterBackUp()
		{
			return super.unCheckWaterBackUp();
		}
		public boolean isInflationGuardChecked()
		{
			return super.isInflationGuardChecked();
		}
		public ALHO3PropertyEndorsements checkInflationGuard()
		{
			return super.checkInflationGuard();
		}
		public ALHO3PropertyEndorsements unCheckInflationGuard()
		{
			return super.unCheckInflationGuard();
		}

		public ALHO3PropertyEndorsements checkSinkholeLossCoverage()
		{
			return super.checkSinkholeLossCoverage();
		}
		public ALHO3RiskAnalysis next()
		{
			super.propertyEndorsementsNext();
			return new ALHO3RiskAnalysis(sh, path);
		}
		public boolean isWaterBackUpChecked()
		{
			return super.isWaterBackUpChecked();
		}
		public boolean isSpecificAdditionalAmountOfCoverageAChecked()
		{
			return super.isSpecificAdditionalAmountOfCoverageAChecked();
		}
		public ALHO3PropertyEndorsements checkSpecificAdditionalAmountOfCoverageA()
		{
			return super.checkSpecificAdditionalAmountOfCoverageA();
		}
	}


	public class ALHO3LiabilityEndorsements extends LiabilityEndorsements<ALHO3LiabilityEndorsements>
	{
		public ALHO3LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}

		public ALHO3PropertyEndorsements clickPropertyEndorsements()
		{
			super.clickPropertyEndorsementsTab();
			return new ALHO3PropertyEndorsements(sh, path);
		}
		public ALHO3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new ALHO3Coverages(sh, path);
		}
		public ALHO3LiabilityEndorsements setLocationName(String text)
		{
			return super.setLocationName(text);
		}

		public String getLocationName()
		{
			return super.getLocationName();
		}
		public ALHO3LiabilityEndorsements setNumberOfFamilies(String text)
		{
			return super.setNumberOfFamilies(text);
		}

		public String getNumberOfFamilies()
		{
			return super.getNumberOfFamilies();
		}
		public ALHO3LiabilityEndorsements setWatercraftType(String text)
		{
			return super.setWatercraftType(text);
		}

		public String getWatercraftType()
		{
			return super.getWatercraftType();
		}
		public ALHO3LiabilityEndorsements setBusinessActivity(String text)
		{
			return super.setBusinessActivity(text);
		}

		public String getBusinessActivity()
		{
			return super.getBusinessActivity();
		}

		public ALHO3LocationInformation addNewLocation()
		{
			super.addNewResidentLocation();
			return new ALHO3LocationInformation(sh,path);
		}
		public ALHO3LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
		{
			return super.checkPermittedIncidentalOccupancyLiability();
		}

		public ALHO3LiabilityEndorsements checkAnimalLiability()
		{
			return super.checkAnimalLiability();
		}

		public ALHO3LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
		{
			return super.checkAdditionalResidenceRentedToOthers();
		}

		public boolean isPermittedIncidentalOccupancyLiabilityChecked()
		{
			return super.isPermittedIncidentalOccupancyLiabilityChecked();
		}

		public ALHO3LiabilityEndorsements checkBusinessPursuits()
		{
			return super.checkBusinessPursuits();
		}

		public boolean isAdditionalResidenceRentedToOthersChecked()
		{
			return super.isAdditionalResidenceRentedToOthersChecked();
		}

		public ALHO3LiabilityEndorsements checkWatercraftLiability()
		{
			return super.checkWatercraftLiability();
		}
		public ALHO3RiskAnalysis next()
		{
			super.liabilityEndorsementsNext();
			return new ALHO3RiskAnalysis(sh, path);
		}
	}
	
}
