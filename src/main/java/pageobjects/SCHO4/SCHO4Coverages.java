package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4Coverages extends Coverages<SCHO4Coverages> {

    public SCHO4Coverages(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4RiskAnalysis next()
    {
        coveragesNext();
        return new SCHO4RiskAnalysis(sh, path);
    }
    public String getDwellingLimit()
    {
        return super.getDwellingLimit();
    }

    public SCHO4Coverages setDwellingLimit(String text)
    {
        return super.setDwellingLimit(text);
    }
    public String getPersonalPropertyLimit()
    {
        return super.getPersonalPropertyLimit();
    }

    public SCHO4Coverages setPersonalPropertyLimit(String text)
    {
        return super.setPersonalPropertyLimit(text);
    }
    public String getOtherStructuresPercentage()
    {
        return super.getOtherStructuresPercentage();
    }

    public SCHO4Coverages setOtherStructuresPercentage(String text)
    {
        return super.setOtherStructuresPercentage(text);
    }
    public String getOtherStructuresLimit()
    {
        return super.getOtherStructuresLimit();
    }

    public SCHO4Coverages setPersonalPropertyExcluded(String flag)
    {
        return super.setPersonalPropertyExcluded(flag);

    }
    public String getPersonalPropertyValuationMethod()
    {
        return super.getPersonalPropertyValuationMethod();
    }

    public SCHO4Coverages setPersonalPropertyValuationMethod(String text)
    {
        return super.setPersonalPropertyValuationMethod(text);
    }
    public SCHO4Coverages coveragesEnter(){return super.coveragesEnter();}
    public String coveragesErrorMessage(){return super.coveragesErrorMessage();}

    public SCHO4Coverages setLossOfUseSelection(String text)
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

    public SCHO4Coverages setHurricane(String text)
    {
        return super.setHurricane(text);

    }
    public String getAllOtherPerils()
    {
        return super.getAllOtherPerils();
    }

    public SCHO4Coverages setAllOtherPerils(String text)
    {
        return super.setAllOtherPerils(text);

    }

    public SCHO4Coverages setWindExcluded(String flag)
    {
        return super.setWindExcluded(flag);

    }

    public String getPersonalLiabilityLimit()
    {
        return super.getPersonalLiabilityLimit();
    }

    public SCHO4Coverages setPersonalLiabilityLimit(String text)
    {
        return super.setPersonalLiabilityLimit(text);

    }
    public SCHO4Coverages back(){
        return super.dwellingConstructionBack();
    }

    public String getMedicalPaymentsLimit()
    {
        return super.getMedicalPaymentsLimit();
    }

    public SCHO4Coverages setMedicalPaymentsLimit(String text)
    {
        return super.setMedicalPaymentsLimit(text);

    }

    public SCHO4Coverages clickCoverages()
    {
        return super.clickCoverages();

    }
    public String getWindDeductibleType()
    {
        return super.getWindDeductibleType();
    }

    public SCHO4Coverages setWindDeductibleType(String text)
    {
        return super.setWindDeductibleType(text);

    }
    public String getWindHail()
    {
        return super.getWindHail();
    }

    public SCHO4Coverages setWindHail(String text)
    {
        return super.setWindHail(text);

    }
    public String getNamedStorm()
    {
        return super.getNamedStorm();
    }

    public SCHO4Coverages setNamedStorm(String text)
    {
        return super.setNamedStorm(text);

    }
    public SCHO4LiabilityEndorsements clickLiabilityEndorsements()
    {
        super.clickLiabilityEndorsementsTab();
        return new SCHO4LiabilityEndorsements(sh, path);
    }
    public SCHO4PropertyEndorsements clickPropertyEndorsements()
    {
        super.clickPropertyEndorsementsTab();
        return new SCHO4PropertyEndorsements(sh,path);
    }


    public class SCHO4PropertyEndorsements extends PropertyEndorsements<SCHO4PropertyEndorsements>
    {
        public SCHO4PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
        {
            super(sh, path);
        }

        public String getWaterBackUpLimit()
        {
            return super.getWaterBackUpLimit();
        }
        public SCHO4PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
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
        public SCHO4PropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
        {
            return super.setPersonalPropertyArticleType(itemNumber, text);
        }
        public SCHO4PropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
        {
            return super.setPersonalPropertyDescription(itemNumber, text);
        }
        public SCHO4PropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
        {
            return super.setPersonalPropertyValue(itemNumber, text);
        }
        public SCHO4PropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setOtherStructuresDescription(itemNumber, text);
        }
        public SCHO4PropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setOtherStructuresLimit(itemNumber, text);
        }
        public SCHO4PropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresDescription(itemNumber, text);
        }
        public SCHO4PropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresLimit(itemNumber, text);
        }
        public SCHO4PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
        {
            return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
        }

        public SCHO4PropertyEndorsements coveragesPropertyEnter () {
            return super.coveragesPropertyEnter();
        }

        public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
        {
            return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        }
        public SCHO4PropertyEndorsements checkEarthQuakeCoverage()
        {
            return super.checkEarthquakeCoverage();
        }

        public SCHO4PropertyEndorsements checkSpecificOtherStructures()
        {
            return super.checkSpecificOtherStructures();
        }

        public SCHO4PropertyEndorsements checkEarthquakeLossAssessment()
        {
            return super.checkEarthquakeLossAssessment();
        }
        public SCHO4PropertyEndorsements setEarthquakeLossAssessmentLimit(String text)
        {
            return super.setEarthquakeLossAssessmentLimit(text);
        }

        public String getEarthquakeLossAssessmentLimit()
        {
            return super.getEarthquakeLossAssessmentLimit();
        }
        public SCHO4PropertyEndorsements setEarthquakeCoverageDeductiblePercentage(String text)
        {
            return super.setEarthquakeCoverageDeductiblePercentage(text);
        }

        public String getEarthquakeCoverageDeductiblePercentage()
        {
            return super.getEarthquakeCoverageDeductiblePercentage();
        }
        public SCHO4LiabilityEndorsements clickLiabilityEndorsements()
        {
            super.clickLiabilityEndorsementsTab();
            return new SCHO4LiabilityEndorsements(sh, path);
        }
        public SCHO4Coverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new SCHO4Coverages(sh, path);
        }

        public SCHO4PropertyEndorsements checkPermittedIncidentalOccupancy()
        {
            return super.checkPermittedIncidentalOccupancy();
        }

        public SCHO4PropertyEndorsements checkGuardianEndorsements()
        {
            return super.checkGuardianEndorsements();
        }
        public SCHO4PropertyEndorsements setWhenSafeCreditPercentage(String text)
        {
            return super.setWhenSafeCreditPercentage(text);
        }

        public String getWhenSafeCreditPercentage()
        {
            return super.getWhenSafeCreditPercentage();
        }
        public SCHO4PropertyEndorsements addSpecificOtherStructures()
        {
            return super.addSpecificOtherStructures();
        }
        public SCHO4PropertyEndorsements removeSpecificOtherStructures()
        {
            return super.removeSpecificOtherStructures();
        }
        public SCHO4PropertyEndorsements addOtherStructures()
        {
            return super.clickAddOtherStructures();
        }
        public SCHO4PropertyEndorsements removeOtherStructures()
        {
            return super.clickRemoveOtherStructures();
        }
        public SCHO4PropertyEndorsements setOccurrenceAggregateLimit(String text)
        {
            return super.setOccurrenceAggregateLimit(text);
        }

        public String getOccurrenceAggregateLimit()
        {
            return super.getOccurrenceAggregateLimit();
        }
        public SCHO4PropertyEndorsements setLossAssessmentLimit(String text)
        {
            return super.setLossAssessmentLimit(text);
        }

        public String getLossAssessmentLimit()
        {
            return super.getLossAssessmentLimit();
        }
        public SCHO4PropertyEndorsements setOrdinanceOrLawLimit(String text)
        {
            return super.setOrdinanceOrLawLimit(text);
        }

        public String getOrdinanceOrLawLimit()
        {
            return super.getOrdinanceOrLawLimit();
        }
        public SCHO4PropertyEndorsements setPercentageOfAnnualIncrease(String text)
        {
            return super.setPercentageOfAnnualIncrease(text);
        }

        public String getPercentageOfAnnualIncrease()
        {
            return super.getPercentageOfAnnualIncrease();
        }
        public SCHO4PropertyEndorsements setSinkholeIndex(String text)
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

        public SCHO4PropertyEndorsements setSinkholeClaimsIndex(String text)
        {
            return super.setSinkholeClaimsIndex(text);
        }

        public String getSinkholeClaimsIndex()
        {
            return super.getSinkholeClaimsIndex();
        }
        public SCHO4PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
        {
            return super.setScreenEnclosureHurricaneCoverageLimit(text);
        }

        public String getScreenEnclosureHurricaneCoverageLimit()
        {
            return super.getScreenEnclosureHurricaneCoverageLimit();
        }

        public SCHO4PropertyEndorsements checkWhenSafe()
        {
            return super.checkWhenSafe();
        }
        public boolean isWhenSafeChecked()
        {
            return super.isWhenSafeChecked();
        }
        public SCHO4PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
        {
            return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
        }

        public SCHO4PropertyEndorsements checkScheduledPersonalProperty()
        {
            return super.checkScheduledPersonalProperty();
        }

        public SCHO4PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
        {
            return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
        }

        public SCHO4PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
        {
            return super.checkScreenEnclosureHurricaneCoverage();
        }
        public SCHO4PropertyEndorsements clickAddScheduledPersonalProperty()
        {
            return super.clickAddScheduledPersonalProperty();

        }
        public SCHO4PropertyEndorsements clickRemoveScheduledPersonalProperty()
        {
            return super.clickRemoveScheduledPersonalProperty();
        }

        public SCHO4PropertyEndorsements checkWaterBackUp()
        {
            return super.checkWaterBackUp();
        }

        public SCHO4PropertyEndorsements checkInflationGuard()
        {
            return super.checkInflationGuard();
        }

        public SCHO4PropertyEndorsements checkSinkholeLossCoverage()
        {
            return super.checkSinkholeLossCoverage();
        }
        public SCHO4RiskAnalysis next()
        {
            super.propertyEndorsementsNext();
            return new SCHO4RiskAnalysis(sh, path);
        }
        public boolean isWaterBackUpChecked()
        {
            return super.isWaterBackUpChecked();
        }
        public boolean isSpecificAdditionalAmountOfCoverageAChecked()
        {
            return super.isSpecificAdditionalAmountOfCoverageAChecked();
        }
        public SCHO4PropertyEndorsements checkSpecificAdditionalAmountOfCoverageA()
        {
            return super.checkSpecificAdditionalAmountOfCoverageA();
        }
    }


    public class SCHO4LiabilityEndorsements extends LiabilityEndorsements<SCHO4LiabilityEndorsements>
    {
        public SCHO4LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }

        public SCHO4PropertyEndorsements clickPropertyEndorsements()
        {
            super.clickPropertyEndorsementsTab();
            return new SCHO4PropertyEndorsements(sh, path);
        }
        public SCHO4Coverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new SCHO4Coverages(sh, path);
        }
        public SCHO4LiabilityEndorsements setLocationName(String text)
        {
            return super.setLocationName(text);
        }

        public String getLocationName()
        {
            return super.getLocationName();
        }
        public SCHO4LiabilityEndorsements setNumberOfFamilies(String text)
        {
            return super.setNumberOfFamilies(text);
        }

        public String getNumberOfFamilies()
        {
            return super.getNumberOfFamilies();
        }
        public SCHO4LiabilityEndorsements setWatercraftType(String text)
        {
            return super.setWatercraftType(text);
        }

        public String getWatercraftType()
        {
            return super.getWatercraftType();
        }
        public SCHO4LiabilityEndorsements setBusinessActivity(String text)
        {
            return super.setBusinessActivity(text);
        }

        public String getBusinessActivity()
        {
            return super.getBusinessActivity();
        }

        public SCHO4LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
        {
            return super.checkPermittedIncidentalOccupancyLiability();
        }

        public SCHO4LiabilityEndorsements checkAnimalLiability()
        {
            return super.checkAnimalLiability();
        }

        public SCHO4LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
        {
            return super.checkAdditionalResidenceRentedToOthers();
        }

        public SCHO4LiabilityEndorsements checkBusinessPursuits()
        {
            return super.checkBusinessPursuits();
        }

        public SCHO4LiabilityEndorsements checkWatercraftLiability()
        {
            return super.checkWatercraftLiability();
        }
        public SCHO4RiskAnalysis next()
        {
            super.liabilityEndorsementsNext();
            return new SCHO4RiskAnalysis(sh, path);
        }
    }

}
