package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3Coverages extends Coverages<SCDP3Coverages>
{
		public SCDP3Coverages(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCDP3RiskAnalysis next()
	{
		coveragesNext();
		return new SCDP3RiskAnalysis(sh, path);
	}
	public String getDwellingLimit()
	{
		return super.getDwellingLimit();
	}

	public SCDP3Coverages setDwellingLimit(String text)
	{
		return super.setDwellingLimit(text);
	}
	public String getPersonalPropertyLimit()
	{
		return super.getPersonalPropertyLimit();
	}

	public SCDP3Coverages setPersonalPropertyLimit(String text)
	{
		return super.setPersonalPropertyLimit(text);
	}
	public String getOtherStructuresPercentage()
	{
		return super.getOtherStructuresPercentage();
	}

	public SCDP3Coverages setOtherStructuresPercentage(String text)
	{
		return super.setOtherStructuresPercentage(text);
	}
	public String getOtherStructuresLimit()
	{
		return super.getOtherStructuresLimit();
	}

	public SCDP3Coverages setPersonalPropertyExcluded(String flag)
	{
		return super.setPersonalPropertyExcluded(flag);

	}
	public String getPersonalPropertyValuationMethod()
	{
		return super.getPersonalPropertyValuationMethod();
	}

	public SCDP3Coverages setPersonalPropertyValuationMethod(String text)
	{
		return super.setPersonalPropertyValuationMethod(text);
	}
	public SCDP3Coverages coveragesEnter(){return super.coveragesEnter();}
	public String coveragesErrorMessage(){return super.coveragesErrorMessage();}
	public SCDP3Coverages setLossOfUseSelection(String text)
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

	public SCDP3Coverages setHurricane(String text)
	{
		return super.setHurricane(text);

	}
	public String getAllOtherPerils()
	{
		return super.getAllOtherPerils();
	}

	public SCDP3Coverages setAllOtherPerils(String text)
	{
		return super.setAllOtherPerils(text);

	}

	public boolean isOtherStructuresIncreasedCoverageChecked()
	{
		return super.isOtherStructruesIncreasedCoverageChecked();
	}
	public SCDP3Coverages clickOtherStructuresIncreasedCoverage()
	{
		return super.clickOtherStructuresIncreasedCoverage();
	}
	public SCDP3Coverages setWindExcluded(String flag)
	{
		return super.setWindExcluded(flag);

	}


	public SCDP3Coverages setPersonalLiabilityLimit(String text)
	{
		return super.setPersonalLiabilityLimit(text);

	}
	public SCDP3Coverages back(){
		return super.dwellingConstructionBack();
	}
	public String getPersonalLiabilityLimit()
	{
		return super.getPersonalLiabilityLimit();
	}



	public String getMedicalPaymentsLimit()
	{
		return super.getMedicalPaymentsLimit();
	}

	public SCDP3Coverages setMedicalPaymentsLimit(String text)
	{
		return super.setMedicalPaymentsLimit(text);

	}
	public SCDP3Coverages setOtherStructuresIncreasedCoverageLimit(String text)
	{
		return super.setOtherStructuresIncreasedCoverageLimit(text);
	}

	public String getOtherStructuresIncreasedCoverageLimit()
	{
		return super.getOtherStructuresIncreasedCoverageLimit();
	}

	public SCDP3Coverages clickCoverages()
	{
		return super.clickCoverages();

	}

	public SCDP3Coverages setPremisesLiabilityLimit(String text)
	{
		return super.setPremisesLiabilityLimit(text);
	}
	public SCDP3Coverages checkPremisesLiability()
	{
		return super.checkPremisesLiability();
	}
	public SCDP3Coverages unCheckPremisesLiability()
	{
		return super.unCheckPremisesLiability();
	}
	public SCDP3Coverages checkPersonalLiability()
	{
		return super.checkPersonalLiability();
	}
	public SCDP3Coverages unCheckPersonalLiability()
	{
		return super.unCheckPersonalLiability();
	}

	public String getPremisesLiabilityLimit()
	{
		return super.getPremisesLiabilityLimit();
	}

	public String getWindDeductibleType()
	{
		return super.getWindDeductibleType();
	}

	public SCDP3Coverages setWindDeductibleType(String text)
	{
		return super.setWindDeductibleType(text);

	}
	public String getWindHail()
	{
		return super.getWindHail();
	}

	public SCDP3Coverages setWindHail(String text)
	{
		return super.setWindHail(text);

	}
	public String getNamedStorm()
	{
		return super.getNamedStorm();
	}

	public SCDP3Coverages setNamedStorm(String text)
	{
		return super.setNamedStorm(text);

	}
	public SCDP3LiabilityEndorsements clickLiabilityEndorsements()
	{
		super.clickLiabilityEndorsementsTab();
		return new SCDP3LiabilityEndorsements(sh, path);
	}
	public SCDP3PropertyEndorsements clickPropertyEndorsements()
	{
		super.clickPropertyEndorsementsTab();
		return new SCDP3PropertyEndorsements(sh,path);
	}


	public class SCDP3PropertyEndorsements extends PropertyEndorsements<SCDP3PropertyEndorsements>
	{
		public SCDP3PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
		{
			super(sh, path);
		}

		public String getWaterBackUpLimit()
		{
			return super.getWaterBackUpLimit();
		}
		public SCDP3PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
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

		public SCDP3PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
		{
			return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
		}

		public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
		{
			return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
		}
		public SCDP3PropertyEndorsements checkEarthQuakeCoverage()
		{
			return super.checkEarthquakeCoverage();
		}

		public SCDP3PropertyEndorsements clickTheftCoverage()
		{
			return super.clickTheftCoverage();
		}
		public boolean isTheftCoverageChecked()
		{
			return super.isTheftCoverageChecked();
		}
		public String getTheftType()
		{
			return super.getTheftType();
		}
		
		public SCDP3PropertyEndorsements checkEarthquakeLossAssessment()
		{
			return super.checkEarthquakeLossAssessment();
		}
		public SCDP3PropertyEndorsements setEarthquakeLossAssessmentLimit(String text)
		{
			return super.setEarthquakeLossAssessmentLimit(text);
		}

		public String getEarthquakeLossAssessmentLimit()
		{
			return super.getEarthquakeLossAssessmentLimit();
		}
		public SCDP3PropertyEndorsements setEarthquakeCoverageDeductiblePercentage(String text)
		{
			return super.setEarthquakeCoverageDeductiblePercentage(text);
		}

		public String getEarthquakeCoverageDeductiblePercentage()
		{
			return super.getEarthquakeCoverageDeductiblePercentage();
		}
		public SCDP3LiabilityEndorsements clickLiabilityEndorsements()
		{
			super.clickLiabilityEndorsementsTab();
			return new SCDP3LiabilityEndorsements(sh, path);
		}
		public SCDP3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new SCDP3Coverages(sh, path);
		}

		public SCDP3PropertyEndorsements checkPermittedIncidentalOccupancy()
		{
			return super.checkPermittedIncidentalOccupancy();
		}


		public SCDP3PropertyEndorsements setWhenSafeCreditPercentage(String text)
		{
			return super.setWhenSafeCreditPercentage(text);
		}

		public String getWhenSafeCreditPercentage()
		{
			return super.getWhenSafeCreditPercentage();
		}

		public SCDP3PropertyEndorsements removeSpecificOtherStructures()
		{
			return super.removeSpecificOtherStructures();
		}

		public SCDP3PropertyEndorsements removeOtherStructures()
		{
			return super.clickRemoveOtherStructures();
		}
		public SCDP3PropertyEndorsements setOccurrenceAggregateLimit(String text)
		{
			return super.setOccurrenceAggregateLimit(text);
		}

		public String getOccurrenceAggregateLimit()
		{
			return super.getOccurrenceAggregateLimit();
		}

		public String getLossAssessmentLimit()
		{
			return super.getLossAssessmentLimit();
		}
		public SCDP3PropertyEndorsements setOrdinanceOrLawLimit(String text)
		{
			return super.setOrdinanceOrLawLimit(text);
		}

		public String getOrdinanceOrLawLimit()
		{
			return super.getOrdinanceOrLawLimit();
		}
		public SCDP3PropertyEndorsements setPercentageOfAnnualIncrease(String text)
		{
			return super.setPercentageOfAnnualIncrease(text);
		}

		public String getPercentageOfAnnualIncrease()
		{
			return super.getPercentageOfAnnualIncrease();
		}
		public SCDP3PropertyEndorsements setSinkholeIndex(String text)
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

		public SCDP3PropertyEndorsements setSinkholeClaimsIndex(String text)
		{
			return super.setSinkholeClaimsIndex(text);
		}

		public String getSinkholeClaimsIndex()
		{
			return super.getSinkholeClaimsIndex();
		}
		public SCDP3PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
		{
			return super.setScreenEnclosureHurricaneCoverageLimit(text);
		}

		public String getScreenEnclosureHurricaneCoverageLimit()
		{
			return super.getScreenEnclosureHurricaneCoverageLimit();
		}

		public SCDP3PropertyEndorsements checkWhenSafe()
		{
			return super.checkWhenSafe();
		}
		public SCDP3PropertyEndorsements unCheckWhenSafe()
		{
			return super.unCheckWhenSafe();
		}
		public boolean isWhenSafeChecked()
		{
			return super.isWhenSafeChecked();
		}



		public SCDP3PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
		}

		public SCDP3PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
		{
			return super.checkScreenEnclosureHurricaneCoverage();
		}

		public SCDP3PropertyEndorsements clickRemoveScheduledPersonalProperty()
		{
			return super.clickRemoveScheduledPersonalProperty();
		}

		public SCDP3PropertyEndorsements checkWaterBackUp()
		{
			return super.checkWaterBackUp();
		}
		public SCDP3PropertyEndorsements unCheckWaterBackUp()
		{
			return super.unCheckWaterBackUp();
		}
		public SCDP3PropertyEndorsements checkInflationGuard()
		{
			return super.checkInflationGuard();
		}

		public SCDP3PropertyEndorsements checkSinkholeLossCoverage()
		{
			return super.checkSinkholeLossCoverage();
		}
		public SCDP3RiskAnalysis next()
		{
			super.propertyEndorsementsNext();
			return new SCDP3RiskAnalysis(sh, path);
		}
		public boolean isWaterBackUpChecked()
		{
			return super.isWaterBackUpChecked();
		}
		public boolean isSpecificAdditionalAmountOfCoverageAChecked()
		{
			return super.isSpecificAdditionalAmountOfCoverageAChecked();
		}
		public SCDP3PropertyEndorsements checkSpecificAdditionalAmountOfCoverageA()
		{
			return super.checkSpecificAdditionalAmountOfCoverageA();
		}
	}


	public class SCDP3LiabilityEndorsements extends LiabilityEndorsements<SCDP3LiabilityEndorsements>
	{
		public SCDP3LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}

		public SCDP3PropertyEndorsements clickPropertyEndorsements()
		{
			super.clickPropertyEndorsementsTab();
			return new SCDP3PropertyEndorsements(sh, path);
		}
		public SCDP3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new SCDP3Coverages(sh, path);
		}
		public SCDP3LiabilityEndorsements setLocationName(String text)
		{
			return super.setLocationName(text);
		}

		public String getLocationName()
		{
			return super.getLocationName();
		}
		public SCDP3LiabilityEndorsements setNumberOfFamilies(String text)
		{
			return super.setNumberOfFamilies(text);
		}

		public String getNumberOfFamilies()
		{
			return super.getNumberOfFamilies();
		}
		public SCDP3LiabilityEndorsements setWatercraftType(String text)
		{
			return super.setWatercraftType(text);
		}

		public String getWatercraftType()
		{
			return super.getWatercraftType();
		}
		public SCDP3LiabilityEndorsements setBusinessActivity(String text)
		{
			return super.setBusinessActivity(text);
		}

		public String getBusinessActivity()
		{
			return super.getBusinessActivity();
		}

		public SCDP3LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
		{
			return super.checkPermittedIncidentalOccupancyLiability();
		}

		public SCDP3LiabilityEndorsements checkAnimalLiability()
		{
			return super.checkAnimalLiability();
		}

		public SCDP3LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
		{
			return super.checkAdditionalResidenceRentedToOthers();
		}
		public SCDP3LocationInformation addNewLocation()
		{
			super.addNewResidentLocation();
			return new SCDP3LocationInformation(sh,path);
		}

		public SCDP3LiabilityEndorsements checkBusinessPursuits()
		{
			return super.checkBusinessPursuits();
		}

		public SCDP3LiabilityEndorsements checkWatercraftLiability()
		{
			return super.checkWatercraftLiability();
		}
		public SCDP3RiskAnalysis next()
		{
			super.liabilityEndorsementsNext();
			return new SCDP3RiskAnalysis(sh, path);
		}














	}
	
}
