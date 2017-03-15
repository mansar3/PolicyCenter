package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3Coverages extends Coverages<NCHO3Coverages>
{
		public NCHO3Coverages(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3RiskAnalysis next()
	{
		coveragesNext();
		return new NCHO3RiskAnalysis(sh, path);
	}
	public String getDwellingLimit()
	{
		return super.getDwellingLimit();
	}

	public NCHO3Quote coveragesQuote(){
		super.CoverageQuote();
		return new NCHO3Quote(sh, path );
	}

	public NCHO3PreQuoteIssues  coveragesquoteWithIssues()
	{
		super.CoverageQuote();
		return new NCHO3PreQuoteIssues(sh, path);
	}
	public NCHO3Coverages setDwellingLimit(String text)
	{
		return super.setDwellingLimit(text);
	}
	public String getPersonalPropertyLimit()
	{
		return super.getPersonalPropertyLimit();
	}

	public NCHO3Coverages setPersonalPropertyLimit(String text)
	{
		return super.setPersonalPropertyLimit(text);
	}
	public String getOtherStructuresPercentage()
	{
		return super.getOtherStructuresPercentage();
	}
	public String getOtherStructurePercentageGreyedOut()
	{
		return super.getOtherStructuresLimitGreyedOut();
	}

	public NCHO3Coverages setOtherStructuresPercentage(String text)
	{
		return super.setOtherStructuresPercentage(text);
	}
	public String getOtherStructuresLimit()
	{
		return super.getOtherStructuresLimit();
	}

	public NCHO3Coverages setPersonalPropertyExcluded(String flag)
	{
		return super.setPersonalPropertyExcluded(flag);

	}
	public String getPersonalPropertyValuationMethod()
	{
		return super.getPersonalPropertyValuationMethod();
	}

	public NCHO3Coverages setPersonalPropertyValuationMethod(String text)
	{
		return super.setPersonalPropertyValuationMethod(text);
	}
	public NCHO3Coverages coveragesEnter(){return super.coveragesEnter();}
	public String coveragesErrorMessage(){return super.coveragesErrorMessage();}

	public NCHO3Coverages setLossOfUseSelection(String text)
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

	public NCHO3Coverages setHurricane(String text)
	{
		return super.setHurricane(text);

	}
	public String getAllOtherPerils()
	{
		return super.getAllOtherPerils();
	}

	public NCHO3Coverages setAllOtherPerils(String text)
	{
		return super.setAllOtherPerils(text);

	}

	public NCHO3Coverages setWindExcluded(String flag)
	{
		return super.setWindExcluded(flag);

	}

	public String getPersonalLiabilityLimit()
	{
		return super.getPersonalLiabilityLimit();
	}

	public NCHO3Coverages setPersonalLiabilityLimit(String text)
	{
		return super.setPersonalLiabilityLimit(text);

	}
	public NCHO3Coverages back(){
		return super.dwellingConstructionBack();
	}

	public String getMedicalPaymentsLimit()
	{
		return super.getMedicalPaymentsLimit();
	}

	public NCHO3Coverages setMedicalPaymentsLimit(String text)
	{
		return super.setMedicalPaymentsLimit(text);

	}

	public NCHO3Coverages clickCoverages()
	{
		return super.clickCoverages();

	}
	public String getWindDeductibleType()
	{
		return super.getWindDeductibleType();
	}

	public NCHO3Coverages setWindDeductibleType(String text)
	{
		return super.setWindDeductibleType(text);

	}
	public String getWindHail()
	{
		return super.getWindHail();
	}

	public NCHO3Coverages setWindHail(String text)
	{
		return super.setWindHail(text);

	}
	public String getNamedStorm()
	{
		return super.getNamedStorm();
	}

	public NCHO3Coverages setNamedStorm(String text)
	{
		return super.setNamedStorm(text);

	}
	public NCHO3LiabilityEndorsements clickLiabilityEndorsements()
	{
		super.clickLiabilityEndorsementsTab();
		return new NCHO3LiabilityEndorsements(sh, path);
	}
	public NCHO3PropertyEndorsements clickPropertyEndorsements()
	{
		super.clickPropertyEndorsementsTab();
		return new NCHO3PropertyEndorsements(sh,path);
	}


	public class NCHO3PropertyEndorsements extends PropertyEndorsements<NCHO3PropertyEndorsements>
	{
		public NCHO3PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
		{
			super(sh, path);
		}

		public String getWaterBackUpLimit()
		{
			return super.getWaterBackUpLimit();
		}
		public NCHO3PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
		{
			return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
		}
		public boolean isEarthQuakeLossAssessment()
		{
			return super.isEarthQuakeLossAssessmentChecked();
		}
		public NCHO3PropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
		{
			return super.setPersonalPropertyArticleType(itemNumber, text);
		}
		public NCHO3PropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
		{
			return super.setPersonalPropertyDescription(itemNumber, text);
		}
		public NCHO3PropertyEndorsements setWaterBackupLimit(String text)
		{
			return super.setWaterBackUpLimit(text);
		}
		public NCHO3PropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
		{
			return super.setPersonalPropertyValue(itemNumber, text);
		}
		public NCHO3PropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setOtherStructuresDescription(itemNumber, text);
		}
		public NCHO3PropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setOtherStructuresLimit(itemNumber, text);
		}
		public NCHO3PropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresDescription(itemNumber, text);
		}
		public NCHO3PropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
		{
			return super.setSpecificOtherStructuresLimit(itemNumber, text);
		}
		public NCHO3PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
		{
			return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
		}

		public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
		{
			return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
		}
		public NCHO3PropertyEndorsements coveragesPropertyEnter () {
			return super.coveragesPropertyEnter();
		}
		public NCHO3PropertyEndorsements checkEarthQuakeCoverage()
		{
			return super.checkEarthquakeCoverage();
		}
		public boolean isEarthquakeCoverageChecked()
		{
			return super.isEarthquakeCoverageChecked();
		}
		public NCHO3PropertyEndorsements checkSpecificOtherStructures()
		{
			return super.checkSpecificOtherStructures();
		}
		
		public NCHO3PropertyEndorsements checkEarthquakeLossAssessmentChecked()
		{
			return super.checkEarthquakeLossAssessment();
		}
		public NCHO3PropertyEndorsements setEarthquakeLossAssessmentLimit(String text)
		{
			return super.setEarthquakeLossAssessmentLimit(text);
		}

		public String getEarthquakeLossAssessmentLimit()
		{
			return super.getEarthquakeLossAssessmentLimit();
		}
		public NCHO3PropertyEndorsements setEarthquakeCoverageDeductiblePercentage(String text)
		{
			return super.setEarthquakeCoverageDeductiblePercentage(text);
		}

		public String getEarthquakeCoverageDeductiblePercentage()
		{
			return super.getEarthquakeCoverageDeductiblePercentage();
		}
		public NCHO3LiabilityEndorsements clickLiabilityEndorsements()
		{
			super.clickLiabilityEndorsementsTab();
			return new NCHO3LiabilityEndorsements(sh, path);
		}
		public NCHO3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new NCHO3Coverages(sh, path);
		}

		public NCHO3PropertyEndorsements checkPermittedIncidentalOccupancy()
		{
			return super.checkPermittedIncidentalOccupancy();
		}

		public NCHO3PropertyEndorsements checkGuardianEndorsements()
		{
			return super.checkGuardianEndorsements();
		}
		public NCHO3PropertyEndorsements setWhenSafeCreditPercentage(String text)
		{
			return super.setWhenSafeCreditPercentage(text);
		}

		public String getWhenSafeCreditPercentage()
		{
			return super.getWhenSafeCreditPercentage();
		}
		public NCHO3PropertyEndorsements addSpecificOtherStructures()
		{
			return super.addSpecificOtherStructures();
		}
		public NCHO3PropertyEndorsements removeSpecificOtherStructures()
		{
			return super.removeSpecificOtherStructures();
		}
		public NCHO3PropertyEndorsements addOtherStructures()
		{
			return super.clickAddOtherStructures();
		}
		public NCHO3PropertyEndorsements removeOtherStructures()
		{
			return super.clickRemoveOtherStructures();
		}
		public NCHO3PropertyEndorsements setOccurrenceAggregateLimit(String text)
		{
			return super.setOccurrenceAggregateLimit(text);
		}

		public String getOccurrenceAggregateLimit()
		{
			return super.getOccurrenceAggregateLimit();
		}
		public NCHO3PropertyEndorsements setLossAssessmentLimit(String text)
		{
			return super.setLossAssessmentLimit(text);
		}

		public String getLossAssessmentLimit()
		{
			return super.getLossAssessmentLimit();
		}
		public NCHO3PropertyEndorsements setOrdinanceOrLawLimit(String text)
		{
			return super.setOrdinanceOrLawLimit(text);
		}

		public String getOrdinanceOrLawLimit()
		{
			return super.getOrdinanceOrLawLimit();
		}
		public NCHO3PropertyEndorsements setPercentageOfAnnualIncrease(String text)
		{
			return super.setPercentageOfAnnualIncrease(text);
		}

		public String getPercentageOfAnnualIncrease()
		{
			return super.getPercentageOfAnnualIncrease();
		}
		public NCHO3PropertyEndorsements setSinkholeIndex(String text)
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

		public NCHO3Quote clickcoveragesPropertyEndorsementsQuote()
		{
			super.clickCoveragesPropertyEndorsementsQuote();
			return new NCHO3Quote(sh, path);

		}
		public NCHO3PropertyEndorsements setSinkholeClaimsIndex(String text)
		{
			return super.setSinkholeClaimsIndex(text);
		}

		public String getSinkholeClaimsIndex()
		{
			return super.getSinkholeClaimsIndex();
		}
		public NCHO3PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
		{
			return super.setScreenEnclosureHurricaneCoverageLimit(text);
		}

		public String getScreenEnclosureHurricaneCoverageLimit()
		{
			return super.getScreenEnclosureHurricaneCoverageLimit();
		}

		public NCHO3PropertyEndorsements checkWhenSafe()
		{
			return super.checkWhenSafe();
		}
		public boolean isWhenSafeChecked()
		{
			return super.isWhenSafeChecked();
		}
		public NCHO3PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
		{
			return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
		}

		public NCHO3PropertyEndorsements checkScheduledPersonalProperty()
		{
			return super.checkScheduledPersonalProperty();
		}

		public NCHO3PropertyEndorsements uncheckScheduledPersonalProperty()
		{
			return super.unCheckScheduledPersonalProperty();
		}


		public NCHO3PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
		}

		public NCHO3PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
		{
			return super.checkScreenEnclosureHurricaneCoverage();
		}
		public NCHO3PropertyEndorsements clickAddScheduledPersonalProperty()
		{
			return super.clickAddScheduledPersonalProperty();

		}
		public NCHO3PropertyEndorsements clickRemoveScheduledPersonalProperty()
		{
			return super.clickRemoveScheduledPersonalProperty();
		}

		public NCHO3PropertyEndorsements checkWaterBackUp()
		{
			return super.checkWaterBackUp();
		}

		public NCHO3PropertyEndorsements checkInflationGuard()
		{
			return super.checkInflationGuard();
		}

		public NCHO3PropertyEndorsements checkSinkholeLossCoverage()
		{
			return super.checkSinkholeLossCoverage();
		}
		public NCHO3RiskAnalysis next()
		{
			super.propertyEndorsementsNext();
			return new NCHO3RiskAnalysis(sh, path);
		}
		public boolean isWaterBackUpChecked()
		{
			return super.isWaterBackUpChecked();
		}
		public boolean isSpecificAdditionalAmountOfCoverageAChecked()
		{
			return super.isSpecificAdditionalAmountOfCoverageAChecked();
		}
		public NCHO3PropertyEndorsements checkSpecificAdditionalAmountOfCoverageA()
		{
			return super.checkSpecificAdditionalAmountOfCoverageA();
		}
	}


	public class NCHO3LiabilityEndorsements extends LiabilityEndorsements<NCHO3LiabilityEndorsements>
	{
		public NCHO3LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}

		public NCHO3PropertyEndorsements clickPropertyEndorsements()
		{
			super.clickPropertyEndorsementsTab();
			return new NCHO3PropertyEndorsements(sh, path);
		}
		public NCHO3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new NCHO3Coverages(sh, path);
		}
		public NCHO3LiabilityEndorsements setLocationName(String text)
		{
			return super.setLocationName(text);
		}

		public String getLocationName()
		{
			return super.getLocationName();
		}
		public NCHO3LiabilityEndorsements setNumberOfFamilies(String text)
		{
			return super.setNumberOfFamilies(text);
		}

		public String getNumberOfFamilies()
		{
			return super.getNumberOfFamilies();
		}
		public NCHO3LiabilityEndorsements setWatercraftType(String text)
		{
			return super.setWatercraftType(text);
		}

		public String getWatercraftType()
		{
			return super.getWatercraftType();
		}
		public NCHO3LiabilityEndorsements setBusinessActivity(String text)
		{
			return super.setBusinessActivity(text);
		}

		public String getBusinessActivity()
		{
			return super.getBusinessActivity();
		}

		public NCHO3LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
		{
			return super.checkPermittedIncidentalOccupancyLiability();
		}

		public NCHO3LocationInformation addNewLocation()
		{
			super.addNewResidentLocation();
			return new NCHO3LocationInformation(sh,path);
		}
		public NCHO3LiabilityEndorsements checkAnimalLiability()
		{
			return super.checkAnimalLiability();
		}

		public NCHO3LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
		{
			return super.checkAdditionalResidenceRentedToOthers();
		}

		public NCHO3LiabilityEndorsements checkBusinessPursuits()
		{
			return super.checkBusinessPursuits();
		}

		public NCHO3LiabilityEndorsements checkWatercraftLiability()
		{
			return super.checkWatercraftLiability();
		}
		public NCHO3RiskAnalysis next()
		{
			super.liabilityEndorsementsNext();
			return new NCHO3RiskAnalysis(sh, path);
		}














	}
	
}
