package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;

import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3Coverages extends Coverages<FLHO3Coverages>
{
	public FLHO3Coverages(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3RiskAnalysis next()
	{
		coveragesNext();
		return new FLHO3RiskAnalysis(sh, path);
	}
	public String getDwellingLimit()
	{
		return super.getDwellingLimit();
	}

	public FLHO3Quote coveragesQuote(){
		super.CoverageQuote();
		return new FLHO3Quote(sh, path );
	}

	public FLHO3Quote coveragesQuotePolicyChange(){
		super.CoverageQuotePolicychange();
		return new FLHO3Quote(sh, path );
	}
	public FLHO3Quote coveragesQuoteRenewal(){
		super.CoverageQuoterenewal();
		return new FLHO3Quote(sh, path );
	}

	public FLHO3PreQuoteIssues  coveragesquoteWithIssues()
	{
		super.CoverageQuote();
		return new FLHO3PreQuoteIssues(sh, path);
	}

	public FLHO3Coverages setDwellingLimit(String text)
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

	public FLHO3Coverages setPersonalPropertyLimit(String text)
	{
		return super.setPersonalPropertyLimit(text);
	}
	public String getOtherStructuresPercentage()
	{
		return super.getOtherStructuresPercentage();
	}

	public FLHO3Coverages setOtherStructuresPercentage(String text)
	{
		return super.setOtherStructuresPercentage(text);
	}
	public String getOtherStructuresLimit()
	{
		return super.getOtherStructuresLimit();
	}

	public boolean isOtherStructuresLimitEditable()
	{
		return super.isOtherStructuresLimitEditable();
	}

	public String getFairRentalValuePercentage()
	{
		return super.getFairRentalValuePercentage();
	}

	public String getFairRentalValueLimit()
	{
		return super.getFairRentalValueLimit();
	}

	public FLHO3Coverages setPersonalPropertyExcluded(String flag)
	{
		return super.setPersonalPropertyExcluded(flag);

	}
	public FLHO3Coverages coveragesEnter(){return super.coveragesEnter();}
	public String coveragesErrorMessage(){return super.coveragesErrorMessage();}

	public boolean isPersonalPropertyExcluded()
	{
		return super.isPersonalPropertyExcluded();
	}

	public boolean isWindExcluded()
	{
		return super.isWindExcluded();
	}

	public String getPersonalPropertyValuationMethod()
	{
		return super.getPersonalPropertyValuationMethod();
	}

	public FLHO3Coverages setPersonalPropertyValuationMethod(String text)
	{
		return super.setPersonalPropertyValuationMethod(text);
	}

	public FLHO3Coverages setLossOfUseSelection(String text)
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

	public boolean isLossOfUseLimitEditable()
	{
		return super.isLossOfUseLimitEditable();
	}

	public String getHurricanePercentage()
	{
		return super.getHurricanePercentage();
	}

	public FLHO3Coverages setHurricane(String text)
	{
		return super.setHurricane(text);

	}

	public boolean isItemInAllOtherPerilsDropdown(String item)
	{
		return super.isItemInAllOtherPerilsDropdown(item);
	}

	public String getPremisesLiabilityLimit()
	{
		return super.getPremisesLiabilityLimit();
	}

	public FLHO3Coverages back(){
		return super.dwellingConstructionBack();
	}


	public String getAllOtherPerils()
	{
		return super.getAllOtherPerils();
	}

	public FLHO3Coverages setAllOtherPerils(String text)
	{
		return super.setAllOtherPerils(text);

	}

	public FLHO3Coverages setWindExcluded(String flag)
	{
		return super.setWindExcluded(flag);

	}

	public String getPersonalLiabilityLimit()
	{
		return super.getPersonalLiabilityLimit();
	}

	public FLHO3Coverages setPersonalLiabilityLimit(String text)
	{
		return super.setPersonalLiabilityLimit(text);

	}
	public String getMedicalPaymentsLimit()
	{
		return super.getMedicalPaymentsLimit();
	}

	public FLHO3Coverages setMedicalPaymentsLimit(String text)
	{
		return super.setMedicalPaymentsLimit(text);

	}

	public FLHO3Coverages clickCoverages()
	{
		return super.clickCoverages();

	}
	public FLHO3Coverages setPermittedIncidentalOccupalimit(String text)
	{
		return super.PermittedIncidentalOccupalimit(text);
	}
	public String getWindDeductibleType()
	{
		return super.getWindDeductibleType();
	}

	public FLHO3Coverages setWindDeductibleType(String text)
	{
		return super.setWindDeductibleType(text);

	}
	public String getWindHail()
	{
		return super.getWindHail();
	}

	public FLHO3Coverages setWindHail(String text)
	{
		return super.setWindHail(text);

	}
	public String getNamedStorm()
	{
		return super.getNamedStorm();
	}

	public FLHO3Coverages setNamedStorm(String text)
	{
		return super.setNamedStorm(text);
	}

	public String getAdditionalLivingExpensesPercent()
	{
		return super.getAdditionalLivingExpensesPercent();
	}

	public String getAdditionalLivingExpensesLimit()
	{
		return super.getAdditionalLivingExpensesLimit();
	}

	public String getOtherStructuresIncreasedCoverageLimit()
	{
		return super.getOtherStructuresIncreasedCoverageLimit();
	}
	public FLHO3Coverages clickOtherStructuresIncreasedCoverage()
	{
		return super.clickOtherStructuresIncreasedCoverage();
	}
	public boolean isOtherStructuresIncreasedCoverageChecked()
	{
		return super.isOtherStructruesIncreasedCoverageChecked();
	}

	public boolean isPremiseLiabilityPresent()
	{
		return super.isPremiseLiabilityPresent();
	}

	public boolean isPersonalLiabilityPresent()
	{
		return super.isPersonalLiabilityPresent();
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

	public FLHO3LiabilityEndorsements clickLiabilityEndorsements()
	{
		super.clickLiabilityEndorsementsTab();
		return new FLHO3LiabilityEndorsements(sh, path);
	}
	public FLHO3PropertyEndorsements clickPropertyEndorsements()
	{
		super.clickPropertyEndorsementsTab();
		return new FLHO3PropertyEndorsements(sh,path);
	}


	public class FLHO3PropertyEndorsements extends PropertyEndorsements<FLHO3PropertyEndorsements>
	{
		public FLHO3PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
		{
			super(sh, path);
		}

		public String getWaterBackUpLimit()
		{
			return super.getWaterBackUpLimit();
		}
		public FLHO3PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
		{
			return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
		}
		public FLHO3PropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
		{
			return super.setPersonalPropertyArticleType(itemNumber, text);
		}
		public FLHO3PropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
		{
			return super.setPersonalPropertyDescription(itemNumber, text);
		}
		public FLHO3PropertyEndorsements clickAddScheduledPersonalProperty()
		{
			return super.clickAddScheduledPersonalProperty();

		}
		public FLHO3PropertyEndorsements clickRemoveScheduledPersonalProperty()
		{
			return super.clickRemoveScheduledPersonalProperty();
		}
		public FLHO3PropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
		{
			return super.setPersonalPropertyValue(itemNumber, text);
		}
		public FLHO3PropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setOtherStructuresDescription(itemNumber, text);
		}
		public FLHO3PropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setOtherStructuresLimit(itemNumber, text);
		}
		public FLHO3PropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresDescription(itemNumber, text);
		}
		public FLHO3PropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresLimit(itemNumber, text);
		}
		public FLHO3PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
		{
			return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
		}

		public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
		{
			return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
		}

		public FLHO3PropertyEndorsements checkSpecificOtherStructures()
		{
			return super.checkSpecificOtherStructures();
		}

		public FLHO3LiabilityEndorsements clickLiabilityEndorsements()
		{
			super.clickLiabilityEndorsementsTab();
			return new FLHO3LiabilityEndorsements(sh, path);
		}
		public FLHO3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new FLHO3Coverages(sh, path);
		}

		public FLHO3PropertyEndorsements checkPermittedIncidentalOccupancy()
		{
			return super.checkPermittedIncidentalOccupancy();
		}
		public boolean isInflationGuardChecked()
		{
			return super.isInflationGuardChecked();
		}

//		public FLHO3PropertyEndorsements setPermittedIncidentalOccupalimit(String text)
//		{
//			return super.PermittedIncidentalOccupalimit(text);
//		}

		public FLHO3PropertyEndorsements checkGuardianEndorsements()
		{
			return super.checkGuardianEndorsements();
		}

		public FLHO3Quote clickcoveragesPropertyEndorsementsQuote()
		{
			super.clickCoveragesPropertyEndorsementsQuote();
			return new FLHO3Quote(sh, path);

		}
		public FLHO3PropertyEndorsements setWhenSafeCreditPercentage(String text)
		{
			return super.setWhenSafeCreditPercentage(text);
		}
		public boolean isWhenSafeChecked()
		{
			return super.isWhenSafeChecked();
		}

		public String getWhenSafeCreditPercentage()
		{
			return super.getWhenSafeCreditPercentage();
		}

		public String getWhenSafeCreditValue()
		{
			return super.getWhenSafeCreditValue();
		}

		public String getCreditValue()
		{
			return super.getWhenSafeCreditValue();
		}

		public FLHO3PropertyEndorsements addSpecificOtherStructures()
		{
			return super.addSpecificOtherStructures();
		}
		public FLHO3PropertyEndorsements removeSpecificOtherStructures()
		{
			return super.removeSpecificOtherStructures();
		}
		public FLHO3PropertyEndorsements addOtherStructures()
		{
			return super.clickAddOtherStructures();
		}
		public FLHO3PropertyEndorsements removeOtherStructures()
		{
			return super.clickRemoveOtherStructures();
		}
		public FLHO3PropertyEndorsements setOccurrenceAggregateLimit(String text)
		{
			return super.setOccurrenceAggregateLimit(text);
		}

		public String getOccurrenceAggregateLimit()
		{
			return super.getOccurrenceAggregateLimit();
		}
		public FLHO3PropertyEndorsements setLossAssessmentLimit(String text)
		{
			return super.setLossAssessmentLimit(text);
		}

		public String getLossAssessmentLimit()
		{
			return super.getLossAssessmentLimit();
		}
		public FLHO3PropertyEndorsements setOrdinanceOrLawLimit(String text)
		{
			return super.setOrdinanceOrLawLimit(text);
		}

		public String getOrdinanceOrLawLimit()
		{
			return super.getOrdinanceOrLawLimit();
		}

		public boolean isOrdinanceOrLawLimitRequired()
		{
			return super.isOrdinanceOrLawLimitRequired();
		}

		public FLHO3PropertyEndorsements setPercentageOfAnnualIncrease(String text)
		{
			return super.setPercentageOfAnnualIncrease(text);
		}

		public String getPercentageOfAnnualIncrease()
		{
			return super.getPercentageOfAnnualIncrease();
		}
		public FLHO3PropertyEndorsements setSinkholeIndex(String text)
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

		public FLHO3PropertyEndorsements setSinkholeClaimsIndex(String text)
		{
			return super.setSinkholeClaimsIndex(text);
		}

		public String getSinkholeClaimsIndex()
		{
			return super.getSinkholeClaimsIndex();
		}
		public FLHO3PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
		{
			return super.setScreenEnclosureHurricaneCoverageLimit(text);
		}

		public String getScreenEnclosureHurricaneCoverageLimit()
		{
			return super.getScreenEnclosureHurricaneCoverageLimit();
		}

		public FLHO3PropertyEndorsements checkWhenSafe()
		{
			return super.checkWhenSafe();
		}
		public FLHO3PropertyEndorsements unCheckWhenSafe()
		{
			return super.unCheckWhenSafe();
		}
		public FLHO3PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
		{
			return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
		}

		public boolean isOtherStructuresIncreasedCoverageChecked()
		{
			return super.isOtherStructuresIncreasedCoverageChecked();
		}

		public FLHO3PropertyEndorsements checkScheduledPersonalProperty()
		{
			return super.checkScheduledPersonalProperty();
		}

		public boolean isScheduledPersonalPropertyChecked()
		{
			return super.isScheduledPersonalPropertyChecked();
		}

		public FLHO3PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
		}

		public boolean isCreditCardFundTransferForgeryCounterfeitChecked()
		{
			return super.isCreditCardFundTransferForgeryCounterfeitMoneyChecked();
		}

		public FLHO3PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
		{
			return super.checkScreenEnclosureHurricaneCoverage();
		}

		public boolean isScreenEnclosureHurricaneCoverageChecked()
		{
			return super.isScreenEnclosureHurricaneCoverageChecked();
		}

		public boolean isScreenEnclosureHurricaneCoverageRequired()
		{
			return super.isScreenEnclosureHurricaneCoverageRequired();
		}
		public FLHO3PropertyEndorsements setPermittedIncidentalOccupancyLimit(String text)
		{
			return super.setPermittedIncidentalOccupancyLimit(text);
		}

		public String getPermittedIncidentalOccupancyLimit()
		{
			return super.getPermittedIncidentalOccupancyLimit();
		}


		public FLHO3PropertyEndorsements checkWaterBackUp()
		{
			return super.checkWaterBackUp();
		}
		public FLHO3PropertyEndorsements unCheckWaterBackUp()
		{
			return super.unCheckWaterBackUp();
		}

		public FLHO3PropertyEndorsements checkInflationGuard()
		{
			return super.checkInflationGuard();
		}
		public FLHO3PropertyEndorsements unCheckInflationGuard()
		{
			return super.unCheckInflationGuard();
		}

		public FLHO3PropertyEndorsements checkSinkholeLossCoverage()
		{
			return super.checkSinkholeLossCoverage();
		}

		public boolean isSinkholeLossCoverageChecked()
		{
			return super.isSinkholeLossCoverageChecked();
		}

		public FLHO3RiskAnalysis next()
		{
			super.propertyEndorsementsNext();
			return new FLHO3RiskAnalysis(sh, path);
		}
		public boolean isWaterBackUpChecked()
		{
			return super.isWaterBackUpChecked();
		}

		public boolean isTheftCoverageChecked()
		{
			return super.isTheftCoverageChecked();
		}


		public String getTheftType()
		{
			return super.getTheftType();
		}

		public boolean isTheftCoveragePresent()
		{
			return super.isTheftCoveragePresent();
		}

		public FLHO3PropertyEndorsements clickTheftCoverage()
		{
			return super.clickTheftCoverage();
		}

		public boolean isGuardianEndorsementChecked()
		{
			return super.isGuardianEndorsementsChecked();
		}

		public boolean isGuardianEndorsementDisplayed()
		{
			return super.isGuardianEndorsementDisplayed();
		}

		public boolean isGuardianEndorsementRequired()
		{
			return super.isGuardianEndorsementRequired();
		}
	}


	public class FLHO3LiabilityEndorsements extends LiabilityEndorsements<FLHO3LiabilityEndorsements>
	{
		public FLHO3LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}

		public FLHO3PropertyEndorsements clickPropertyEndorsements()
		{
			super.clickPropertyEndorsementsTab();
			return new FLHO3PropertyEndorsements(sh, path);
		}
		public FLHO3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new FLHO3Coverages(sh, path);
		}
		public FLHO3LiabilityEndorsements setLocationName(String text)
		{
			return super.setLocationName(text);
		}

		public String getLocationName()
		{
			return super.getLocationName();
		}
		public FLHO3LiabilityEndorsements setNumberOfFamilies(String text)
		{
			return super.setNumberOfFamilies(text);
		}

		public String getNumberOfFamilies()
		{
			return super.getNumberOfFamilies();
		}
		public FLHO3LiabilityEndorsements setWatercraftType(String text)
		{
			return super.setWatercraftType(text);
		}

		public String getWatercraftType()
		{
			return super.getWatercraftType();
		}
		public FLHO3LiabilityEndorsements setBusinessActivity(String text)
		{
			return super.setBusinessActivity(text);
		}

		public String getBusinessActivity()
		{
			return super.getBusinessActivity();
		}

		public FLHO3LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
		{
			return super.checkPermittedIncidentalOccupancyLiability();
		}

		public FLHO3LiabilityEndorsements unCheckPermittedIncidentalOccupancyLiability()
		{
			return super.unCheckPermittedIncidentalOccupancyLiability();
		}

		public String getAnimalLiability()
        {
            return super.getAnimalLiability();
        }

		public FLHO3LiabilityEndorsements checkAnimalLiability()
		{
			return super.checkAnimalLiability();
		}

		public FLHO3LiabilityEndorsements unCheckAnimalLiability()
		{
			return super.unCheckAnimalLiability();
		}

		public FLHO3LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
		{
			return super.checkAdditionalResidenceRentedToOthers();
		}

		public FLHO3LocationInformation addNewLocation()
		{
			super.addNewResidentLocation();
			return new FLHO3LocationInformation(sh,path);
		}
		public FLHO3LiabilityEndorsements checkBusinessPursuits()
		{
			return super.checkBusinessPursuits();
		}

		public FLHO3LiabilityEndorsements checkWatercraftLiability()
		{
			return super.checkWatercraftLiability();
		}
		public FLHO3RiskAnalysis next()
		{
			super.liabilityEndorsementsNext();
			return new FLHO3RiskAnalysis(sh, path);
		}

		public boolean isPermittedIncidentalOccupancyLiabilityChecked()
		{
			return super.isPermittedIncidentalOccupancyLiabilityChecked();
		}

		public boolean isAnimalLiabilityChecked()
		{
			return super.isAnimalLiabilityChecked();
		}

		public boolean isAdditionalResidenceRentedToOthersChecked()
		{
			return super.isAdditionalResidenceRentedToOthersChecked();
		}

		public boolean isBusinessPursuitsChecked()
		{
			return super.isBusinessPursuitsChecked();
		}

		public boolean isWatercraftLiabilityChecked()
		{
			return super.isWatercraftLiabilityChecked();
		}
	}

}
