package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3Coverages extends Coverages<SCHO3Coverages>
{
		public SCHO3Coverages(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3RiskAnalysis next()
	{
		coveragesNext();
		return new SCHO3RiskAnalysis(sh, path);
	}
	public String getDwellingLimit()
	{
		return super.getDwellingLimit();
	}

	public SCHO3Quote coveragesQuote(){
		super.CoverageQuote();
		return new SCHO3Quote(sh, path );
	}

	public SCHO3PreQuoteIssues  coveragesquoteWithIssues()
	{
		super.CoverageQuote();
		return new SCHO3PreQuoteIssues(sh, path);
	}

	public SCHO3Coverages setDwellingLimit(String text)
	{
		return super.setDwellingLimit(text);
	}
	public String getPersonalPropertyLimit()
	{
		return super.getPersonalPropertyLimit();
	}

	public SCHO3Coverages setPersonalPropertyLimit(String text)
	{
		return super.setPersonalPropertyLimit(text);
	}
	public String getOtherStructuresPercentage()
	{
		return super.getOtherStructuresPercentage();
	}

	public SCHO3Coverages setOtherStructuresPercentage(String text)
	{
		return super.setOtherStructuresPercentage(text);
	}
	public String getOtherStructuresLimit()
	{
		return super.getOtherStructuresLimit();
	}

	public SCHO3Coverages setPersonalPropertyExcluded(String flag)
	{
		return super.setPersonalPropertyExcluded(flag);

	}
	public String getPersonalPropertyValuationMethod()
	{
		return super.getPersonalPropertyValuationMethod();
	}

	public SCHO3Coverages setPersonalPropertyValuationMethod(String text)
	{
		return super.setPersonalPropertyValuationMethod(text);
	}
	public SCHO3Coverages coveragesEnter(){return super.coveragesEnter();}
	public String coveragesErrorMessage(){return super.coveragesErrorMessage();}

	public SCHO3Coverages setLossOfUseSelection(String text)
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

	public SCHO3Coverages setHurricane(String text)
	{
		return super.setHurricane(text);

	}
	public String getAllOtherPerils()
	{
		return super.getAllOtherPerils();
	}

	public SCHO3Coverages setAllOtherPerils(String text)
	{
		return super.setAllOtherPerils(text);

	}

	public SCHO3Coverages setWindExcluded(String flag)
	{
		return super.setWindExcluded(flag);

	}

	public String getPersonalLiabilityLimit()
	{
		return super.getPersonalLiabilityLimit();
	}

	public SCHO3Coverages setPersonalLiabilityLimit(String text)
	{
		return super.setPersonalLiabilityLimit(text);

	}
	public SCHO3Coverages back(){
		return super.dwellingConstructionBack();
	}

	public String getMedicalPaymentsLimit()
	{
		return super.getMedicalPaymentsLimit();
	}

	public SCHO3Coverages setMedicalPaymentsLimit(String text)
	{
		return super.setMedicalPaymentsLimit(text);

	}

	public SCHO3Coverages clickCoverages()
	{
		return super.clickCoverages();

	}
	public String getWindDeductibleType()
	{
		return super.getWindDeductibleType();
	}

	public SCHO3Coverages setWindDeductibleType(String text)
	{
		return super.setWindDeductibleType(text);

	}
	public String getWindHail()
	{
		return super.getWindHail();
	}

	public SCHO3Coverages setWindHail(String text)
	{
		return super.setWindHail(text);

	}
	public String getNamedStorm()
	{
		return super.getNamedStorm();
	}

	public SCHO3Coverages setNamedStorm(String text)
	{
		return super.setNamedStorm(text);

	}
	public SCHO3LiabilityEndorsements clickLiabilityEndorsements()
	{
		super.clickLiabilityEndorsementsTab();
		return new SCHO3LiabilityEndorsements(sh, path);
	}
	public SCHO3PropertyEndorsements clickPropertyEndorsements()
	{
		super.clickPropertyEndorsementsTab();
		return new SCHO3PropertyEndorsements(sh,path);
	}


	public class SCHO3PropertyEndorsements extends PropertyEndorsements<SCHO3PropertyEndorsements>
	{
		public SCHO3PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
		{
			super(sh, path);
		}

		public String getWaterBackUpLimit()
		{
			return super.getWaterBackUpLimit();
		}
		public SCHO3PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
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
		public SCHO3PropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
		{
			return super.setPersonalPropertyArticleType(itemNumber, text);
		}
		public SCHO3PropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
		{
			return super.setPersonalPropertyDescription(itemNumber, text);
		}
		public SCHO3PropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
		{
			return super.setPersonalPropertyValue(itemNumber, text);
		}
		public SCHO3PropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setOtherStructuresDescription(itemNumber, text);
		}
		public SCHO3PropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setOtherStructuresLimit(itemNumber, text);
		}
		public SCHO3PropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresDescription(itemNumber, text);
		}
		public SCHO3PropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresLimit(itemNumber, text);
		}
		public SCHO3PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
		{
			return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
		}

		public SCHO3PropertyEndorsements coveragesPropertyEnter () {
			return super.coveragesPropertyEnter();
		}

		public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
		{
			return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
		}
		public SCHO3PropertyEndorsements checkEarthQuakeCoverage()
		{
			return super.checkEarthquakeCoverage();
		}

		public SCHO3PropertyEndorsements checkSpecificOtherStructures()
		{
			return super.checkSpecificOtherStructures();
		}
		
		public SCHO3PropertyEndorsements checkEarthquakeLossAssessment()
		{
			return super.checkEarthquakeLossAssessment();
		}
		public SCHO3PropertyEndorsements setEarthquakeLossAssessmentLimit(String text)
		{
			return super.setEarthquakeLossAssessmentLimit(text);
		}

		public String getEarthquakeLossAssessmentLimit()
		{
			return super.getEarthquakeLossAssessmentLimit();
		}
		public SCHO3PropertyEndorsements setEarthquakeCoverageDeductiblePercentage(String text)
		{
			return super.setEarthquakeCoverageDeductiblePercentage(text);
		}

		public String getEarthquakeCoverageDeductiblePercentage()
		{
			return super.getEarthquakeCoverageDeductiblePercentage();
		}
		public SCHO3LiabilityEndorsements clickLiabilityEndorsements()
		{
			super.clickLiabilityEndorsementsTab();
			return new SCHO3LiabilityEndorsements(sh, path);
		}
		public SCHO3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new SCHO3Coverages(sh, path);
		}

		public SCHO3PropertyEndorsements checkPermittedIncidentalOccupancy()
		{
			return super.checkPermittedIncidentalOccupancy();
		}

		public SCHO3PropertyEndorsements checkGuardianEndorsements()
		{
			return super.checkGuardianEndorsements();
		}
		public SCHO3PropertyEndorsements setWhenSafeCreditPercentage(String text)
		{
			return super.setWhenSafeCreditPercentage(text);
		}

		public String getWhenSafeCreditPercentage()
		{
			return super.getWhenSafeCreditPercentage();
		}
		public SCHO3PropertyEndorsements addSpecificOtherStructures()
		{
			return super.addSpecificOtherStructures();
		}
		public SCHO3PropertyEndorsements removeSpecificOtherStructures()
		{
			return super.removeSpecificOtherStructures();
		}
		public SCHO3PropertyEndorsements addOtherStructures()
		{
			return super.clickAddOtherStructures();
		}
		public SCHO3PropertyEndorsements removeOtherStructures()
		{
			return super.clickRemoveOtherStructures();
		}
		public SCHO3PropertyEndorsements setOccurrenceAggregateLimit(String text)
		{
			return super.setOccurrenceAggregateLimit(text);
		}

		public String getOccurrenceAggregateLimit()
		{
			return super.getOccurrenceAggregateLimit();
		}
		public SCHO3PropertyEndorsements setLossAssessmentLimit(String text)
		{
			return super.setLossAssessmentLimit(text);
		}

		public String getLossAssessmentLimit()
		{
			return super.getLossAssessmentLimit();
		}
		public SCHO3PropertyEndorsements setOrdinanceOrLawLimit(String text)
		{
			return super.setOrdinanceOrLawLimit(text);
		}

		public String getOrdinanceOrLawLimit()
		{
			return super.getOrdinanceOrLawLimit();
		}
		public SCHO3PropertyEndorsements setPercentageOfAnnualIncrease(String text)
		{
			return super.setPercentageOfAnnualIncrease(text);
		}

		public String getPercentageOfAnnualIncrease()
		{
			return super.getPercentageOfAnnualIncrease();
		}
		public SCHO3PropertyEndorsements setSinkholeIndex(String text)
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

		public SCHO3PropertyEndorsements setSinkholeClaimsIndex(String text)
		{
			return super.setSinkholeClaimsIndex(text);
		}

		public SCHO3Quote clickcoveragesPropertyEndorsementsQuote()
		{
			super.clickCoveragesPropertyEndorsementsQuote();
			return new SCHO3Quote(sh, path);

		}
		public String getSinkholeClaimsIndex()
		{
			return super.getSinkholeClaimsIndex();
		}
		public SCHO3PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
		{
			return super.setScreenEnclosureHurricaneCoverageLimit(text);
		}

		public String getScreenEnclosureHurricaneCoverageLimit()
		{
			return super.getScreenEnclosureHurricaneCoverageLimit();
		}

		public SCHO3PropertyEndorsements checkWhenSafe()
		{
			return super.checkWhenSafe();
		}
		public SCHO3PropertyEndorsements unCheckWhenSafe()
		{
			return super.unCheckWhenSafe();
		}
		public boolean isWhenSafeChecked()
		{
			return super.isWhenSafeChecked();
		}
		public SCHO3PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
		{
			return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
		}

		public SCHO3PropertyEndorsements checkScheduledPersonalProperty()
		{
			return super.checkScheduledPersonalProperty();
		}
		public SCHO3PropertyEndorsements uncheckScheduledPersonalProperty()
		{
			return super.unCheckScheduledPersonalProperty();
		}



		public SCHO3PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
		}

		public SCHO3PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
		{
			return super.checkScreenEnclosureHurricaneCoverage();
		}
		public SCHO3PropertyEndorsements clickAddScheduledPersonalProperty()
		{
			return super.clickAddScheduledPersonalProperty();

		}
		public SCHO3PropertyEndorsements clickRemoveScheduledPersonalProperty()
		{
			return super.clickRemoveScheduledPersonalProperty();
		}

		public SCHO3PropertyEndorsements checkWaterBackUp()
		{
			return super.checkWaterBackUp();
		}
		public SCHO3PropertyEndorsements unCheckWaterBackUp()
		{
			return super.unCheckWaterBackUp();
		}
		public SCHO3PropertyEndorsements checkInflationGuard()
		{
			return super.checkInflationGuard();
		}

		public SCHO3PropertyEndorsements checkSinkholeLossCoverage()
		{
			return super.checkSinkholeLossCoverage();
		}
		public SCHO3RiskAnalysis next()
		{
			super.propertyEndorsementsNext();
			return new SCHO3RiskAnalysis(sh, path);
		}
		public boolean isWaterBackUpChecked()
		{
			return super.isWaterBackUpChecked();
		}
		public boolean isSpecificAdditionalAmountOfCoverageAChecked()
		{
			return super.isSpecificAdditionalAmountOfCoverageAChecked();
		}
		public SCHO3PropertyEndorsements checkSpecificAdditionalAmountOfCoverageA()
		{
			return super.checkSpecificAdditionalAmountOfCoverageA();
		}
		public SCHO3PropertyEndorsements unCheckSpecificAdditionalAmountOfCoverageA()
		{
			return super.unCheckSpecificAdditionalAmountOfCoverageA();
		}
	}


	public class SCHO3LiabilityEndorsements extends LiabilityEndorsements<SCHO3LiabilityEndorsements>
	{
		public SCHO3LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}

		public SCHO3PropertyEndorsements clickPropertyEndorsements()
		{
			super.clickPropertyEndorsementsTab();
			return new SCHO3PropertyEndorsements(sh, path);
		}
		public SCHO3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new SCHO3Coverages(sh, path);
		}
		public SCHO3LiabilityEndorsements setLocationName(String text)
		{
			return super.setLocationName(text);
		}

		public String getLocationName()
		{
			return super.getLocationName();
		}
		public SCHO3LiabilityEndorsements setNumberOfFamilies(String text)
		{
			return super.setNumberOfFamilies(text);
		}

		public String getNumberOfFamilies()
		{
			return super.getNumberOfFamilies();
		}
		public SCHO3LiabilityEndorsements setWatercraftType(String text)
		{
			return super.setWatercraftType(text);
		}

		public String getWatercraftType()
		{
			return super.getWatercraftType();
		}
		public SCHO3LiabilityEndorsements setBusinessActivity(String text)
		{
			return super.setBusinessActivity(text);
		}

		public String getBusinessActivity()
		{
			return super.getBusinessActivity();
		}

		public SCHO3LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
		{
			return super.checkPermittedIncidentalOccupancyLiability();
		}
		public SCHO3LocationInformation addNewLocation()
		{
			super.addNewResidentLocation();
			return new SCHO3LocationInformation(sh,path);
		}

		public SCHO3LiabilityEndorsements checkAnimalLiability()
		{
			return super.checkAnimalLiability();
		}
		public SCHO3LiabilityEndorsements unCheckAnimalLiability()
		{
			return super.unCheckAnimalLiability();
		}
		public SCHO3LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
		{
			return super.checkAdditionalResidenceRentedToOthers();
		}

		public SCHO3LiabilityEndorsements checkBusinessPursuits()
		{
			return super.checkBusinessPursuits();
		}

		public SCHO3LiabilityEndorsements checkWatercraftLiability()
		{
			return super.checkWatercraftLiability();
		}
		public SCHO3RiskAnalysis next()
		{
			super.liabilityEndorsementsNext();
			return new SCHO3RiskAnalysis(sh, path);
		}














	}
	
}
