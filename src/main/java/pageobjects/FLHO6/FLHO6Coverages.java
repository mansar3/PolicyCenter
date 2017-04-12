package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6Coverages extends Coverages<FLHO6Coverages>
{
	public FLHO6Coverages(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6RiskAnalysis next()
	{
		coveragesNext();
		return new FLHO6RiskAnalysis(sh, path);
	}
	public String getDwellingLimit()
	{
		return super.getDwellingLimit();
	}

	public FLHO6Coverages setDwellingLimit(String text)
	{
		return super.setDwellingLimit(text);
	}
	public String getPersonalPropertyLimit()
	{
		return super.getPersonalPropertyLimit();
	}

	public FLHO6Coverages setPersonalPropertyLimit(String text)
	{
		return super.setPersonalPropertyLimit(text);
	}
	public String getOtherStructuresPercentage()
	{
		return super.getOtherStructuresPercentage();
	}

	public FLHO6Coverages setOtherStructuresPercentage(String text)
	{
		return super.setOtherStructuresPercentage(text);
	}
	public String getOtherStructuresLimit()
	{
		return super.getOtherStructuresLimit();
	}

	public String getFairRentalValuePercentage()
	{
		return super.getFairRentalValuePercentage();
	}

	public String getFairRentalValueLimit()
	{
		return super.getFairRentalValueLimit();
	}

	public FLHO6Coverages setPersonalPropertyExcluded(String flag)
	{
		return super.setPersonalPropertyExcluded(flag);
	}

	public boolean isPersonalPropertyExcluded(Integer flag)
	{
		return super.isPersonalPropertyExcluded(flag);
	}

	public boolean isWindExcluded()
	{
		return super.isWindExcluded();
	}

	public String getPersonalPropertyValuationMethod()
	{
		return super.getPersonalPropertyValuationMethod();
	}

	public FLHO6Coverages setPersonalPropertyValuationMethod(String text)
	{
		return super.setPersonalPropertyValuationMethod(text);
	}

	public FLHO6Coverages coveragesEnter(){return super.coveragesEnter();}
	public String coveragesErrorMessage(){return super.coveragesErrorMessage();}
	public String coveragesErrorMessage2(){return super.coveragesErrorMessage2();}
	public String coveragesErrorMessage3(){return super.coveragesErrorMessage3();}


	public FLHO6Coverages setLossOfUseSelection(String text)
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
	public String getHurricanePercentage()
	{
		return super.getHurricanePercentage();
	}

	public boolean isHurricanePresent()
	{
		return super.isHurricanePresent();
	}

	public FLHO6Coverages setHurricane(String text)
	{
		return super.setHurricane(text);

	}

	public String getPremisesLiabilityLimit()
	{
		return super.getPremisesLiabilityLimit();
	}
	public String getAllOtherPerils()
	{
		return super.getAllOtherPerils();
	}

	public FLHO6Coverages setAllOtherPerils(String text)
	{
		return super.setAllOtherPerils(text);

	}

	public FLHO6Coverages setWindExcluded(String flag)
	{
		return super.setWindExcluded(flag);

	}

	public String getPersonalLiabilityLimit()
	{
		return super.getPersonalLiabilityLimit();
	}

	public FLHO6Coverages setPersonalLiabilityLimit(String text)
	{
		return super.setPersonalLiabilityLimit(text);

	}

	public FLHO6Coverages back(){
		return super.dwellingConstructionBack();
	}

	public String getMedicalPaymentsLimit()
	{
		return super.getMedicalPaymentsLimit();
	}

	public FLHO6Coverages setMedicalPaymentsLimit(String text)
	{
		return super.setMedicalPaymentsLimit(text);

	}

	public FLHO6Coverages clickCoverages()
	{
		return super.clickCoverages();

	}
	public String getWindDeductibleType()
	{
		return super.getWindDeductibleType();
	}

	public FLHO6Coverages setWindDeductibleType(String text)
	{
		return super.setWindDeductibleType(text);

	}
	public String getWindHail()
	{
		return super.getWindHail();
	}

	public FLHO6Coverages setWindHail(String text)
	{
		return super.setWindHail(text);

	}
	public String getNamedStorm()
	{
		return super.getNamedStorm();
	}

	public FLHO6Coverages setNamedStorm(String text)
	{
		return super.setNamedStorm(text);

	}
	public FLHO6LiabilityEndorsements clickLiabilityEndorsements()
	{
		super.clickLiabilityEndorsementsTab();
		return new FLHO6LiabilityEndorsements(sh, path);
	}
	public FLHO6PropertyEndorsements clickPropertyEndorsements()
	{
		super.clickPropertyEndorsementsTab();
		return new FLHO6PropertyEndorsements(sh,path);
	}


	public class FLHO6PropertyEndorsements extends PropertyEndorsements<FLHO6PropertyEndorsements>
	{
		public FLHO6PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
		{
			super(sh, path);
		}

		public String getWaterBackUpLimit()
		{
			return super.getWaterBackUpLimit();
		}

		public boolean isOccurrenceAggregateLimitEditable()
		{
			return super.isOccurrenceAggregateLimitEditable();
		}
		public boolean isOccurrenceAggregateAnInput()
		{
			return super.isOccurrenceAggregateAnInput();
		}
		public FLHO6PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
		{
			return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
		}
		public FLHO6PropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
		{
			return super.setPersonalPropertyArticleType(itemNumber, text);
		}
		public FLHO6PropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
		{
			return super.setPersonalPropertyDescription(itemNumber, text);
		}
		public FLHO6PropertyEndorsements clickAddScheduledPersonalProperty()
		{
			return super.clickAddScheduledPersonalProperty();

		}
		public FLHO6PropertyEndorsements clickRemoveScheduledPersonalProperty()
		{
			return super.clickRemoveScheduledPersonalProperty();
		}
		public FLHO6PropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
		{
			return super.setPersonalPropertyValue(itemNumber, text);
		}
		public FLHO6PropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setOtherStructuresDescription(itemNumber, text);
		}
		public FLHO6PropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setOtherStructuresLimit(itemNumber, text);
		}
		public FLHO6PropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresDescription(itemNumber, text);
		}
		public FLHO6PropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresLimit(itemNumber, text);
		}
		public FLHO6PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
		{
			return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
		}

		public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
		{
			return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
		}

		public FLHO6PropertyEndorsements checkSpecificOtherStructures()
		{
			return super.checkSpecificOtherStructures();
		}

		public boolean isSpecificOtherStructuresChecked()
		{
			return super.isSpecificOtherStructuresChecked();
		}

		public boolean isScheduledPersonalPropertyChecked()
		{
			return super.isScheduledPersonalPropertyChecked();
		}

		public FLHO6LiabilityEndorsements clickLiabilityEndorsements()
		{
			super.clickLiabilityEndorsementsTab();
			return new FLHO6LiabilityEndorsements(sh, path);
		}
		public FLHO6Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new FLHO6Coverages(sh, path);
		}

		public FLHO6PropertyEndorsements checkPermittedIncidentalOccupancy()
		{
			return super.checkPermittedIncidentalOccupancy();
		}
		public FLHO6PropertyEndorsements setPermittedIncidentalOccupancyLimit(String text)
		{
			return super.setPermittedIncidentalOccupancyLimit(text);
		}

		public FLHO6PropertyEndorsements checkGuardianEndorsements()
		{
			return super.checkGuardianEndorsements();
		}
		public FLHO6PropertyEndorsements setWhenSafeCreditPercentage(String text)
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

		public FLHO6PropertyEndorsements addSpecificOtherStructures()
		{
			return super.addSpecificOtherStructures();
		}
		public FLHO6PropertyEndorsements removeSpecificOtherStructures()
		{
			return super.removeSpecificOtherStructures();
		}
		public FLHO6PropertyEndorsements addOtherStructures()
		{
			return super.clickAddOtherStructures();
		}
		public FLHO6PropertyEndorsements removeOtherStructures()
		{
			return super.clickRemoveOtherStructures();
		}
		public FLHO6PropertyEndorsements setOccurrenceAggregateLimit(String text)
		{
			return super.setOccurrenceAggregateLimit(text);
		}

		public String getOccurrenceAggregateLimit()
		{
			return super.getOccurrenceAggregateLimit();
		}
		public FLHO6PropertyEndorsements setLossAssessmentLimit(String text)
		{
			return super.setLossAssessmentLimit(text);
		}

		public String getLossAssessmentLimit()
		{
			return super.getLossAssessmentLimit();
		}
		public FLHO6PropertyEndorsements setOrdinanceOrLawLimit(String text)
		{
			return super.setOrdinanceOrLawLimit(text);
		}

		public String getOrdinanceOrLawLimit()
		{
			return super.getOrdinanceOrLawLimit();
		}
		public FLHO6PropertyEndorsements setPercentageOfAnnualIncrease(String text)
		{
			return super.setPercentageOfAnnualIncrease(text);
		}

		public FLHO6Quote clickcoveragesPropertyEndorsementsQuote()
		{
			super.clickCoveragesPropertyEndorsementsQuote();
			return new FLHO6Quote(sh, path);

		}
		public String getPercentageOfAnnualIncrease()
		{
			return super.getPercentageOfAnnualIncrease();
		}
		public FLHO6PropertyEndorsements setSinkholeIndex(String text)
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

		public FLHO6PropertyEndorsements setSinkholeClaimsIndex(String text)
		{
			return super.setSinkholeClaimsIndex(text);
		}

		public String getSinkholeClaimsIndex()
		{
			return super.getSinkholeClaimsIndex();
		}
		public FLHO6PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
		{
			return super.setScreenEnclosureHurricaneCoverageLimit(text);
		}

		public String getScreenEnclosureHurricaneCoverageLimit()
		{
			return super.getScreenEnclosureHurricaneCoverageLimit();
		}

		public FLHO6PropertyEndorsements checkWhenSafe()
		{
			return super.checkWhenSafe();
		}

		public FLHO6PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
		{
			return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
		}

		public FLHO6PropertyEndorsements checkScheduledPersonalProperty()
		{
			return super.checkScheduledPersonalProperty();
		}
		public FLHO6PropertyEndorsements uncheckScheduledPersonalProperty()
		{
			return super.unCheckScheduledPersonalProperty();
		}

		public FLHO6PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
		}

		public FLHO6PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
		{
			return super.checkScreenEnclosureHurricaneCoverage();
		}

		public boolean isScreenEnclosureHurricaneCoverageChecked()
		{
			return super.isScreenEnclosureHurricaneCoverageChecked();
		}

		public FLHO6PropertyEndorsements checkWaterBackUp()
		{
			return super.checkWaterBackUp();
		}
		public FLHO6PropertyEndorsements unCheckWaterBackUp()
		{
			return super.unCheckWaterBackUp();
		}

		public FLHO6PropertyEndorsements checkInflationGuard()
		{
			return super.checkInflationGuard();
		}

		public FLHO6PropertyEndorsements checkSinkholeLossCoverage()
		{
			return super.checkSinkholeLossCoverage();
		}

		public FLHO6PropertyEndorsements checkUnitOwnersCoverageASpecialCoverage()
		{
			return super.checkUnitOwnersCoverageASpecialCoverage();
		}

		public boolean isUnitOwnersCoverageASpecialCoverage()
		{
			return super.isUnitOwnersCoverageASpecialCoverage();
		}

		public boolean isUnitOwnersRentedToOthers()
		{
			return super.isUnitOwnersRentedToOthers();
		}

		public FLHO6PropertyEndorsements checkUnitOwnersRentedToOthers()
		{
			return super.checkUnitOwnersRentedToOthers();
		}

		public FLHO6RiskAnalysis next()
		{
			super.propertyEndorsementsNext();
			return new FLHO6RiskAnalysis(sh, path);
		}
		public boolean isWaterBackUpChecked()
		{
			return super.isWaterBackUpChecked();
		}

		public boolean isTheftCoverageChecked()
		{
			return super.isTheftCoverageChecked();
		}

		public boolean isSinkholeLossCoverageChecked()
		{
			return super.isSinkholeLossCoverageChecked();
		}
	}


	public class FLHO6LiabilityEndorsements extends LiabilityEndorsements<FLHO6LiabilityEndorsements>
	{
		public FLHO6LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}

		public FLHO6PropertyEndorsements clickPropertyEndorsements()
		{
			super.clickPropertyEndorsementsTab();
			return new FLHO6PropertyEndorsements(sh, path);
		}
		public FLHO6Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new FLHO6Coverages(sh, path);
		}

		public FLHO6LiabilityEndorsements setLocationName(String text)
		{
			return super.setLocationName(text);
		}

		public String getLocationName()
		{
			return super.getLocationName();
		}
		public FLHO6LiabilityEndorsements setNumberOfFamilies(String text)
		{
			return super.setNumberOfFamilies(text);
		}

		public String getNumberOfFamilies()
		{
			return super.getNumberOfFamilies();
		}
		public FLHO6LiabilityEndorsements setWatercraftType(String text)
		{
			return super.setWatercraftType(text);
		}

		public String getWatercraftType()
		{
			return super.getWatercraftType();
		}
		public FLHO6LiabilityEndorsements setBusinessActivity(String text)
		{
			return super.setBusinessActivity(text);
		}

		public String getBusinessActivity()
		{
			return super.getBusinessActivity();
		}

		public FLHO6LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
		{
			return super.checkPermittedIncidentalOccupancyLiability();
		}

		public boolean isPermittedIncidentalOccupancyLiabilityChecked()
		{
			return super.isPermittedIncidentalOccupancyLiabilityChecked();
		}

		public boolean isAdditionalResidenceRentedToOthersChecked()
		{
			return super.isAdditionalResidenceRentedToOthersChecked();
		}
		public FLHO6LocationInformation addNewLocation()
		{
			super.addNewResidentLocation();
			return new FLHO6LocationInformation(sh,path);
		}

		public boolean isBusinessPursuitsChecked()
		{
			return super.isBusinessPursuitsChecked();
		}

		public boolean isWatercraftLiabilityChecked()
		{
			return super.isWatercraftLiabilityChecked();
		}

		public FLHO6LiabilityEndorsements checkAnimalLiability()
		{
			return super.checkAnimalLiability();
		}

		public FLHO6LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
		{
			return super.checkAdditionalResidenceRentedToOthers();
		}

		public FLHO6LiabilityEndorsements checkBusinessPursuits()
		{
			return super.checkBusinessPursuits();
		}

		public FLHO6LiabilityEndorsements checkWatercraftLiability()
		{
			return super.checkWatercraftLiability();
		}
		public FLHO6RiskAnalysis next()
		{
			super.liabilityEndorsementsNext();
			return new FLHO6RiskAnalysis(sh, path);
		}
	}
}
