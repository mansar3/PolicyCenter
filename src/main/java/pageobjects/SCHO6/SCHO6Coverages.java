package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6Coverages extends Coverages<SCHO6Coverages>
{
		public SCHO6Coverages(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6RiskAnalysis next()
	{
		coveragesNext();
		return new SCHO6RiskAnalysis(sh, path);
	}
	public String getDwellingLimit()
	{
		return super.getDwellingLimit();
	}

	public SCHO6Coverages setDwellingLimit(String text)
	{
		return super.setDwellingLimit(text);
	}
	public String getPersonalPropertyLimit()
	{
		return super.getPersonalPropertyLimit();
	}

	public SCHO6Coverages setPersonalPropertyLimit(String text)
	{
		return super.setPersonalPropertyLimit(text);
	}
	public String getOtherStructuresPercentage()
	{
		return super.getOtherStructuresPercentage();
	}

	public SCHO6Coverages setOtherStructuresPercentage(String text)
	{
		return super.setOtherStructuresPercentage(text);
	}
	public String getOtherStructuresLimit()
	{
		return super.getOtherStructuresLimit();
	}

	public SCHO6Coverages setPersonalPropertyExcluded(String flag)
	{
		return super.setPersonalPropertyExcluded(flag);

	}

	public boolean isWindExcluded()
	{
		return super.isWindExcluded();
	}

	public String getPersonalPropertyValuationMethod()
	{
		return super.getPersonalPropertyValuationMethod();
	}

	public SCHO6Coverages setPersonalPropertyValuationMethod(String text)
	{
		return super.setPersonalPropertyValuationMethod(text);
	}
	public SCHO6Coverages coveragesEnter(){return super.coveragesEnter();}

	public String coveragesErrorMessage(){return super.coveragesErrorMessage();}
	public String coveragesErrorMessage2(){return super.coveragesErrorMessage2();}
	public String coveragesErrorMessage3(){return super.coveragesErrorMessage3();}

	public SCHO6Coverages setLossOfUseSelection(String text)
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

	public String getLossOfUseLimit(Integer flag)
	{
		return super.getLossOfUseLimit(flag);
	}

	public String getHurricane()
	{
		return super.getHurricane();
	}

	public SCHO6Coverages setHurricane(String text)
	{
		return super.setHurricane(text);

	}
	public String getAllOtherPerils()
	{
		return super.getAllOtherPerils();
	}

	public SCHO6Coverages setAllOtherPerils(String text)
	{
		return super.setAllOtherPerils(text);

	}

	public SCHO6Coverages setWindExcluded(String flag)
	{
		return super.setWindExcluded(flag);

	}

	public String getPersonalLiabilityLimit()
	{
		return super.getPersonalLiabilityLimit();
	}

	public SCHO6Coverages setPersonalLiabilityLimit(String text)
	{
		return super.setPersonalLiabilityLimit(text);

	}
	public String getMedicalPaymentsLimit()
	{
		return super.getMedicalPaymentsLimit();
	}

	public SCHO6Coverages setMedicalPaymentsLimit(String text)
	{
		return super.setMedicalPaymentsLimit(text);

	}
	public SCHO6Coverages back(){
		return super.dwellingConstructionBack();
	}

	public SCHO6Coverages clickCoverages()
	{
		return super.clickCoverages();

	}
	public String getWindDeductibleType()
	{
		return super.getWindDeductibleType();
	}

	public SCHO6Coverages setWindDeductibleType(String text)
	{
		return super.setWindDeductibleType(text);

	}
	public String getWindHail()
	{
		return super.getWindHail();
	}

	public SCHO6Coverages setWindHail(String text)
	{
		return super.setWindHail(text);

	}
	public String getNamedStorm()
	{
		return super.getNamedStorm();
	}

	public SCHO6Coverages setNamedStorm(String text)
	{
		return super.setNamedStorm(text);

	}
	public SCHO6LiabilityEndorsements clickLiabilityEndorsements()
	{
		super.clickLiabilityEndorsementsTab();
		return new SCHO6LiabilityEndorsements(sh, path);
	}
	public SCHO6PropertyEndorsements clickPropertyEndorsements()
	{
		super.clickPropertyEndorsementsTab();
		return new SCHO6PropertyEndorsements(sh,path);
	}


	public class SCHO6PropertyEndorsements extends PropertyEndorsements<SCHO6PropertyEndorsements>
	{
		public SCHO6PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
		{
			super(sh, path);
		}

		public String getWaterBackUpLimit()
		{
			return super.getWaterBackUpLimit();
		}
		public SCHO6PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
		{
			return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
		}
		public boolean isEarthQuakeLossAssessmentChecked()
		{
			return super.isEarthQuakeLossAssessmentChecked();
		}
		public boolean isEarthquakeCoverageChecked()
		{
			return super.isEarthquakeCoverageChecked();
		}
		public SCHO6PropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
		{
			return super.setPersonalPropertyArticleType(itemNumber, text);
		}
		public SCHO6PropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
		{
			return super.setPersonalPropertyDescription(itemNumber, text);
		}
		public SCHO6PropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
		{
			return super.setPersonalPropertyValue(itemNumber, text);
		}
		public SCHO6PropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setOtherStructuresDescription(itemNumber, text);
		}
		public SCHO6PropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setOtherStructuresLimit(itemNumber, text);
		}
		public SCHO6PropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresDescription(itemNumber, text);
		}
		public SCHO6PropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresLimit(itemNumber, text);
		}
		public SCHO6PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
		{
			return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
		}

		public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
		{
			return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
		}
		public SCHO6PropertyEndorsements checkEarthQuakeCoverage()
		{
			return super.checkEarthquakeCoverage();
		}

		public SCHO6PropertyEndorsements checkSpecificOtherStructures()
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

		public SCHO6PropertyEndorsements checkEarthquakeLossAssessment()
		{
			return super.checkEarthquakeLossAssessment();
		}
		public SCHO6PropertyEndorsements setEarthquakeLossAssessmentLimit(String text)
		{
			return super.setEarthquakeLossAssessmentLimit(text);
		}

		public String getEarthquakeLossAssessmentLimit()
		{
			return super.getEarthquakeLossAssessmentLimit();
		}
		public SCHO6PropertyEndorsements setEarthquakeCoverageDeductiblePercentage(String text)
		{
			return super.setEarthquakeCoverageDeductiblePercentage(text);
		}

		public String getEarthquakeCoverageDeductiblePercentage()
		{
			return super.getEarthquakeCoverageDeductiblePercentage();
		}
		public SCHO6LiabilityEndorsements clickLiabilityEndorsements()
		{
			super.clickLiabilityEndorsementsTab();
			return new SCHO6LiabilityEndorsements(sh, path);
		}
		public SCHO6Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new SCHO6Coverages(sh, path);
		}

		public SCHO6PropertyEndorsements checkPermittedIncidentalOccupancy()
		{
			return super.checkPermittedIncidentalOccupancy();
		}

		public SCHO6PropertyEndorsements checkGuardianEndorsements()
		{
			return super.checkGuardianEndorsements();
		}
		public SCHO6PropertyEndorsements setWhenSafeCreditPercentage(String text)
		{
			return super.setWhenSafeCreditPercentage(text);
		}

		public String getWhenSafeCreditPercentage()
		{
			return super.getWhenSafeCreditPercentage();
		}
		public SCHO6PropertyEndorsements addSpecificOtherStructures()
		{
			return super.addSpecificOtherStructures();
		}
		public SCHO6PropertyEndorsements removeSpecificOtherStructures()
		{
			return super.removeSpecificOtherStructures();
		}
		public SCHO6PropertyEndorsements addOtherStructures()
		{
			return super.clickAddOtherStructures();
		}
		public SCHO6PropertyEndorsements removeOtherStructures()
		{
			return super.clickRemoveOtherStructures();
		}
		public SCHO6PropertyEndorsements setOccurrenceAggregateLimit(String text)
		{
			return super.setOccurrenceAggregateLimit(text);
		}

		public String getOccurrenceAggregateLimit()
		{
			return super.getOccurrenceAggregateLimit();
		}
		public SCHO6PropertyEndorsements setLossAssessmentLimit(String text)
		{
			return super.setLossAssessmentLimit(text);
		}

		public String getLossAssessmentLimit()
		{
			return super.getLossAssessmentLimit();
		}
		public SCHO6PropertyEndorsements setOrdinanceOrLawLimit(String text)
		{
			return super.setOrdinanceOrLawLimit(text);
		}

		public String getOrdinanceOrLawLimit()
		{
			return super.getOrdinanceOrLawLimit();
		}
		public SCHO6PropertyEndorsements setPercentageOfAnnualIncrease(String text)
		{
			return super.setPercentageOfAnnualIncrease(text);
		}

		public String getPercentageOfAnnualIncrease()
		{
			return super.getPercentageOfAnnualIncrease();
		}
		public SCHO6PropertyEndorsements setSinkholeIndex(String text)
		{
			return super.setSinkholeIndex(text);
		}
		public SCHO6Quote clickcoveragesPropertyEndorsementsQuote()
		{
			super.clickCoveragesPropertyEndorsementsQuote();
			return new SCHO6Quote(sh, path);

		}

		public String getSinkholeIndex()
		{
			return super.getSinkholeIndex();
		}
		public boolean isCreditCardCheckBoxAvailable()
		{
			return super.isCreditCardCheckBoxAvailable();
		}

		public SCHO6PropertyEndorsements setSinkholeClaimsIndex(String text)
		{
			return super.setSinkholeClaimsIndex(text);
		}

		public String getSinkholeClaimsIndex()
		{
			return super.getSinkholeClaimsIndex();
		}
		public SCHO6PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
		{
			return super.setScreenEnclosureHurricaneCoverageLimit(text);
		}

		public String getScreenEnclosureHurricaneCoverageLimit()
		{
			return super.getScreenEnclosureHurricaneCoverageLimit();
		}

		public SCHO6PropertyEndorsements checkWhenSafe()
		{
			return super.checkWhenSafe();
		}
		public boolean isWhenSafeChecked()
		{
			return super.isWhenSafeChecked();
		}
		public SCHO6PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
		{
			return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
		}

		public SCHO6PropertyEndorsements checkScheduledPersonalProperty()
		{
			return super.checkScheduledPersonalProperty();
		}

		public SCHO6PropertyEndorsements uncheckScheduledPersonalProperty()
		{
			return super.unCheckScheduledPersonalProperty();
		}


		public SCHO6PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
		}

		public SCHO6PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
		{
			return super.checkScreenEnclosureHurricaneCoverage();
		}
		public SCHO6PropertyEndorsements clickAddScheduledPersonalProperty()
		{
			return super.clickAddScheduledPersonalProperty();

		}
		public SCHO6PropertyEndorsements clickRemoveScheduledPersonalProperty()
		{
			return super.clickRemoveScheduledPersonalProperty();
		}

		public boolean isScreenEnclosureHurricaneCoverageChecked()
		{
			return super.isScreenEnclosureHurricaneCoverageChecked();
		}

		public SCHO6PropertyEndorsements checkWaterBackUp()
		{
			return super.checkWaterBackUp();
		}

		public SCHO6PropertyEndorsements checkInflationGuard()
		{
			return super.checkInflationGuard();
		}

		public SCHO6PropertyEndorsements checkSinkholeLossCoverage()
		{
			return super.checkSinkholeLossCoverage();
		}
		public SCHO6RiskAnalysis next()
		{
			super.propertyEndorsementsNext();
			return new SCHO6RiskAnalysis(sh, path);
		}
		public boolean isWaterBackUpChecked()
		{
			return super.isWaterBackUpChecked();
		}
		public boolean isSpecificAdditionalAmountOfCoverageAChecked()
		{
			return super.isSpecificAdditionalAmountOfCoverageAChecked();
		}
		public SCHO6PropertyEndorsements checkSpecificAdditionalAmountOfCoverageA()
		{
			return super.checkSpecificAdditionalAmountOfCoverageA();
		}
		public SCHO6PropertyEndorsements checkUnitOwnersRentedToOthers()
		{
			return super.checkUnitOwnersRentedToOthers();
		}
		public SCHO6PropertyEndorsements checkUnitOwnersCoverageASpecialCoverage()
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
	}



	public class SCHO6LiabilityEndorsements extends LiabilityEndorsements<SCHO6LiabilityEndorsements>
	{
		public SCHO6LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}

		public SCHO6PropertyEndorsements clickPropertyEndorsements()
		{
			super.clickPropertyEndorsementsTab();
			return new SCHO6PropertyEndorsements(sh, path);
		}
		public SCHO6Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new SCHO6Coverages(sh, path);
		}
		public SCHO6LiabilityEndorsements setLocationName(String text)
		{
			return super.setLocationName(text);
		}

		public String getLocationName()
		{
			return super.getLocationName();
		}
		public SCHO6LiabilityEndorsements setNumberOfFamilies(String text)
		{
			return super.setNumberOfFamilies(text);
		}

		public String getNumberOfFamilies()
		{
			return super.getNumberOfFamilies();
		}
		public SCHO6LiabilityEndorsements setWatercraftType(String text)
		{
			return super.setWatercraftType(text);
		}

		public String getWatercraftType()
		{
			return super.getWatercraftType();
		}
		public SCHO6LiabilityEndorsements setBusinessActivity(String text)
		{
			return super.setBusinessActivity(text);
		}

		public String getBusinessActivity()
		{
			return super.getBusinessActivity();
		}

		public SCHO6LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
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

		public boolean isBusinessPursuitsChecked()
		{
			return super.isBusinessPursuitsChecked();
		}

		public boolean isWatercraftLiabilityChecked()
		{
			return super.isWatercraftLiabilityChecked();
		}

		public SCHO6LiabilityEndorsements checkAnimalLiability()
		{
			return super.checkAnimalLiability();
		}

		public SCHO6LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
		{
			return super.checkAdditionalResidenceRentedToOthers();
		}
		public SCHO6LocationInformation addNewLocation()
		{
			super.addNewResidentLocation();
			return new SCHO6LocationInformation(sh,path);
		}

		public SCHO6LiabilityEndorsements checkBusinessPursuits()
		{
			return super.checkBusinessPursuits();
		}

		public SCHO6LiabilityEndorsements checkWatercraftLiability()
		{
			return super.checkWatercraftLiability();
		}
		public SCHO6RiskAnalysis next()
		{
			super.liabilityEndorsementsNext();
			return new SCHO6RiskAnalysis(sh, path);
		}
	}
	
}
