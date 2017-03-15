package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3Coverages extends Coverages<FLDP3Coverages>
{
	public FLDP3Coverages(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3RiskAnalysis next()
	{
		coveragesNext();
		return new FLDP3RiskAnalysis(sh, path);
	}
	public String getDwellingLimit()
	{
		return super.getDwellingLimit();
	}

	public FLDP3Coverages setDwellingLimit(String text)
	{
		return super.setDwellingLimit(text);
	}
	public String getPersonalPropertyLimit()
	{
		return super.getPersonalPropertyLimit();
	}

	public FLDP3Coverages setPersonalPropertyLimit(String text)
	{
		return super.setPersonalPropertyLimit(text);
	}
	public String getOtherStructuresPercentage()
	{
		return super.getOtherStructuresPercentage();
	}

	public FLDP3Coverages setOtherStructuresPercentage(String text)
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

	public FLDP3Coverages setPersonalPropertyExcluded(String flag)
	{
		return super.setPersonalPropertyExcluded(flag);
	}

	public boolean isPersonalPropertyExcluded()
	{
		return super.isPersonalPropertyExcluded();
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

	public FLDP3Coverages setPersonalPropertyValuationMethod(String text)
	{
		return super.setPersonalPropertyValuationMethod(text);
	}

	public FLDP3Coverages setLossOfUseSelection(String text)
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

	public FLDP3Coverages setHurricane(String text)
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

	public FLDP3Coverages setAllOtherPerils(String text)
	{
		return super.setAllOtherPerils(text);
	}

	public FLDP3Coverages setWindExcluded(String flag)
	{
		return super.setWindExcluded(flag);
	}

	public String getPersonalLiabilityLimit()
	{
		return super.getPersonalLiabilityLimit();
	}

	public FLDP3Coverages setPersonalLiabilityLimit(String text)
	{
		return super.setPersonalLiabilityLimit(text);

	}
	public String getMedicalPaymentsLimit()
	{
		return super.getMedicalPaymentsLimit();
	}

	public FLDP3Coverages setMedicalPaymentsLimit(String text)
	{
		return super.setMedicalPaymentsLimit(text);

	}

	public FLDP3Coverages clickCoverages()
	{
		return super.clickCoverages();

	}
	public FLDP3Coverages setPremisesLiabilityLimit(String text)
	{
		return super.setPremisesLiabilityLimit(text);
	}
	public FLDP3Coverages checkPremisesLiability()
	{
		return super.checkPremisesLiability();
	}
	public FLDP3Coverages checkPersonalLiability()
	{
		return super.checkPersonalLiability();
	}
	public String getWindDeductibleType()
	{
		return super.getWindDeductibleType();
	}

	public FLDP3Coverages setWindDeductibleType(String text)
	{
		return super.setWindDeductibleType(text);

	}
	public String getWindHail()
	{
		return super.getWindHail();
	}

	public FLDP3Coverages setWindHail(String text)
	{
		return super.setWindHail(text);

	}
	public String getNamedStorm()
	{
		return super.getNamedStorm();
	}

	public FLDP3Coverages setNamedStorm(String text)
	{
		return super.setNamedStorm(text);

	}

	public FLDP3PropertyEndorsements clickPropertyEndorsements()
	{
		super.clickPropertyEndorsementsTab();
		return new FLDP3PropertyEndorsements(sh,path);
	}

	public FLDP3Coverages setOtherStructuresIncreasedCoverageLimit(String text)
	{
		return super.setOtherStructuresIncreasedCoverageLimit(text);
	}

	public String getOtherStructuresIncreasedCoverageLimit()
	{
		return super.getOtherStructuresIncreasedCoverageLimit();
	}
	public FLDP3Coverages clickOtherStructuresIncreasedCoverage()
	{
		return super.clickOtherStructuresIncreasedCoverage();
	}
	public boolean isOtherStructuresIncreasedCoverageChecked()
	{
		return super.isOtherStructruesIncreasedCoverageChecked();
	}



	public class FLDP3PropertyEndorsements extends PropertyEndorsements<FLDP3PropertyEndorsements>
	{
		public FLDP3PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
		{
			super(sh, path);
		}

		public String getWaterBackUpLimit()
		{
			return super.getWaterBackUpLimit();
		}
		public FLDP3PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
		{
			return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
		}



		public FLDP3PropertyEndorsements clickRemoveScheduledPersonalProperty()
		{
			return super.clickRemoveScheduledPersonalProperty();
		}


		public FLDP3PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
		{
			return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
		}

		public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
		{
			return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
		}


		public FLDP3Coverages clickCoverages()
		{
			super.clickCoveragesTab();
			return new FLDP3Coverages(sh, path);
		}

		public FLDP3PropertyEndorsements checkPermittedIncidentalOccupancy()
		{
			return super.checkPermittedIncidentalOccupancy();
		}

		public FLDP3PropertyEndorsements setWhenSafeCreditPercentage(String text)
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

		public FLDP3PropertyEndorsements removeSpecificOtherStructures()
		{
			return super.removeSpecificOtherStructures();
		}

		public FLDP3PropertyEndorsements removeOtherStructures()
		{
			return super.clickRemoveOtherStructures();
		}
		public FLDP3PropertyEndorsements setOccurrenceAggregateLimit(String text)
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


		public String getOrdinanceOrLawLimit()
		{
			return super.getOrdinanceOrLawLimit();
		}
		public FLDP3PropertyEndorsements setPercentageOfAnnualIncrease(String text)
		{
			return super.setPercentageOfAnnualIncrease(text);
		}

		public String getPercentageOfAnnualIncrease()
		{
			return super.getPercentageOfAnnualIncrease();
		}
		public FLDP3PropertyEndorsements setSinkholeIndex(String text)
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

		public FLDP3PropertyEndorsements setSinkholeClaimsIndex(String text)
		{
			return super.setSinkholeClaimsIndex(text);
		}

		public String getSinkholeClaimsIndex()
		{
			return super.getSinkholeClaimsIndex();
		}
		public FLDP3PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
		{
			return super.setScreenEnclosureHurricaneCoverageLimit(text);
		}

		public String getScreenEnclosureHurricaneCoverageLimit()
		{
			return super.getScreenEnclosureHurricaneCoverageLimit();
		}

		public FLDP3PropertyEndorsements checkWhenSafe()
		{
			return super.checkWhenSafe();
		}

		public FLDP3PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
		{
			return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
		}

		public FLDP3PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
		{
			return super.checkScreenEnclosureHurricaneCoverage();
		}

        public boolean isScreenEnclosureHurricaneCoverageChecked()
        {
            return super.isScreenEnclosureHurricaneCoverageChecked();
        }

		public FLDP3PropertyEndorsements checkWaterBackUp()
		{
			return super.checkWaterBackUp();
		}

		public FLDP3PropertyEndorsements checkInflationGuard()
		{
			return super.checkInflationGuard();
		}

		public FLDP3PropertyEndorsements checkSinkholeLossCoverage()
		{
			return super.checkSinkholeLossCoverage();
		}

        public boolean isSinkholeLossCoverageChecked()
        {
            return super.isSinkholeLossCoverageChecked();
        }

		public FLDP3RiskAnalysis next()
		{
			super.propertyEndorsementsNext();
			return new FLDP3RiskAnalysis(sh, path);
		}
		public boolean isWaterBackUpChecked()
		{
			return super.isWaterBackUpChecked();
		}
		public FLDP3PropertyEndorsements clickTheftCoverage()
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
	}



}
