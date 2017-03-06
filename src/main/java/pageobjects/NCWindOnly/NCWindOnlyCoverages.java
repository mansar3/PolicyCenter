package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyCoverages extends Coverages<NCWindOnlyCoverages> {

    public NCWindOnlyCoverages(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyRiskAnalysis next()
    {
        coveragesNext();
        return new NCWindOnlyRiskAnalysis(sh, path);
    }
    public String getDwellingLimit()
    {
        return super.getDwellingLimit();
    }

    public NCWindOnlyCoverages setDwellingLimit(String text)
    {
        return super.setDwellingLimit(text);
    }
    public String getPersonalPropertyLimit()
    {
        return super.getPersonalPropertyLimit();
    }

    public NCWindOnlyCoverages setPersonalPropertyLimit(String text)
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

    public NCWindOnlyCoverages setOtherStructuresPercentage(String text)
    {
        return super.setOtherStructuresPercentage(text);
    }
    public String getOtherStructuresLimit()
    {
        return super.getOtherStructuresLimit();
    }

    public NCWindOnlyCoverages setPersonalPropertyExcluded(String flag)
    {
        return super.setPersonalPropertyExcluded(flag);

    }
    public String getPersonalPropertyValuationMethod()
    {
        return super.getPersonalPropertyValuationMethod();
    }

    public NCWindOnlyCoverages setPersonalPropertyValuationMethod(String text)
    {
        return super.setPersonalPropertyValuationMethod(text);
    }
    public NCWindOnlyCoverages coveragesEnter(){return super.coveragesEnter();}
    public String coveragesErrorMessage(){return super.coveragesErrorMessage();}

    public NCWindOnlyCoverages setLossOfUseSelection(String text)
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

    public NCWindOnlyCoverages setHurricane(String text)
    {
        return super.setHurricane(text);

    }
    public String getAllOtherPerils()
    {
        return super.getAllOtherPerils();
    }

    public NCWindOnlyCoverages setAllOtherPerils(String text)
    {
        return super.setAllOtherPerils(text);

    }

    public NCWindOnlyCoverages setWindExcluded(String flag)
    {
        return super.setWindExcluded(flag);

    }

    public String getPersonalLiabilityLimit()
    {
        return super.getPersonalLiabilityLimit();
    }

    public NCWindOnlyCoverages setPersonalLiabilityLimit(String text)
    {
        return super.setPersonalLiabilityLimit(text);

    }
    public NCWindOnlyCoverages back(){
        return super.dwellingConstructionBack();
    }

    public String getMedicalPaymentsLimit()
    {
        return super.getMedicalPaymentsLimit();
    }

    public NCWindOnlyCoverages setMedicalPaymentsLimit(String text)
    {
        return super.setMedicalPaymentsLimit(text);

    }

    public NCWindOnlyCoverages clickCoverages()
    {
        return super.clickCoverages();

    }
    public String getWindDeductibleType()
    {
        return super.getWindDeductibleType();
    }

    public NCWindOnlyCoverages setWindDeductibleType(String text)
    {
        return super.setWindDeductibleType(text);

    }
    public String getWindHail()
    {
        return super.getWindHail();
    }

    public NCWindOnlyCoverages setWindHail(String text)
    {
        return super.setWindHail(text);

    }
    public String getNamedStorm()
    {
        return super.getNamedStorm();
    }

    public NCWindOnlyCoverages setNamedStorm(String text)
    {
        return super.setNamedStorm(text);

    }
    public NCWindOnlyLiabilityEndorsements clickLiabilityEndorsements()
    {
        super.clickLiabilityEndorsementsTab();
        return new NCWindOnlyLiabilityEndorsements(sh, path);
    }
    public NCWindOnlyPropertyEndorsements clickPropertyEndorsements()
    {
        super.clickPropertyEndorsementsTab();
        return new NCWindOnlyPropertyEndorsements(sh,path);
    }


    public class NCWindOnlyPropertyEndorsements extends PropertyEndorsements<NCWindOnlyPropertyEndorsements>
    {
        public NCWindOnlyPropertyEndorsements(CenterSeleniumHelper sh ,Path path)
        {
            super(sh, path);
        }

        public String getWaterBackUpLimit()
        {
            return super.getWaterBackUpLimit();
        }
        public NCWindOnlyPropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
        {
            return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
        }
        public NCWindOnlyPropertyEndorsements clickCoveragespropertyendorsementsQuote()
        {
            return super.clickCoveragespropertyendorsementsQuote();
        }

        public boolean isEarthQuakeLossAssessment()
        {
            return super.isEarthQuakeLossAssessmentChecked();
        }
        public NCWindOnlyPropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
        {
            return super.setPersonalPropertyArticleType(itemNumber, text);
        }
        public NCWindOnlyPropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
        {
            return super.setPersonalPropertyDescription(itemNumber, text);
        }
        public NCWindOnlyPropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
        {
            return super.setPersonalPropertyValue(itemNumber, text);
        }
        public NCWindOnlyPropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setOtherStructuresDescription(itemNumber, text);
        }
        public NCWindOnlyPropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setOtherStructuresLimit(itemNumber, text);
        }
        public NCWindOnlyPropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresDescription(itemNumber, text);
        }
        public NCWindOnlyPropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresLimit(itemNumber, text);
        }
        public NCWindOnlyPropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
        {
            return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
        }

        public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
        {
            return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        }
        public NCWindOnlyPropertyEndorsements coveragesPropertyEnter () {
            return super.coveragesPropertyEnter();
        }
        public NCWindOnlyPropertyEndorsements checkEarthQuakeCoverage()
        {
            return super.checkEarthquakeCoverage();
        }
        public boolean isEarthquakeCoverageChecked()
        {
            return super.isEarthquakeCoverageChecked();
        }
        public NCWindOnlyPropertyEndorsements checkSpecificOtherStructures()
        {
            return super.checkSpecificOtherStructures();
        }
        public NCWindOnlyPropertyEndorsements checkResidenceHeldinTrust()
        {
            return super.checkResidenceHeldinTrust();
        }
        public NCWindOnlyPropertyEndorsements checkEarthquakeLossAssessmentChecked()
        {
            return super.checkEarthquakeLossAssessment();
        }
        public NCWindOnlyPropertyEndorsements setEarthquakeLossAssessmentLimit(String text)
        {
            return super.setEarthquakeLossAssessmentLimit(text);
        }

        public String getEarthquakeLossAssessmentLimit()
        {
            return super.getEarthquakeLossAssessmentLimit();
        }
        public NCWindOnlyPropertyEndorsements setEarthquakeCoverageDeductiblePercentage(String text)
        {
            return super.setEarthquakeCoverageDeductiblePercentage(text);
        }

        public String getEarthquakeCoverageDeductiblePercentage()
        {
            return super.getEarthquakeCoverageDeductiblePercentage();
        }
        public NCWindOnlyLiabilityEndorsements clickLiabilityEndorsements()
        {
            super.clickLiabilityEndorsementsTab();
            return new NCWindOnlyLiabilityEndorsements(sh, path);
        }
        public NCWindOnlyCoverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new NCWindOnlyCoverages(sh, path);
        }

        public NCWindOnlyPropertyEndorsements checkPermittedIncidentalOccupancy()
        {
            return super.checkPermittedIncidentalOccupancy();
        }

        public NCWindOnlyPropertyEndorsements checkGuardianEndorsements()
        {
            return super.checkGuardianEndorsements();
        }
        public NCWindOnlyPropertyEndorsements setWhenSafeCreditPercentage(String text)
        {
            return super.setWhenSafeCreditPercentage(text);
        }

        public String getWhenSafeCreditPercentage()
        {
            return super.getWhenSafeCreditPercentage();
        }
        public NCWindOnlyPropertyEndorsements addSpecificOtherStructures()
        {
            return super.addSpecificOtherStructures();
        }
        public NCWindOnlyPropertyEndorsements removeSpecificOtherStructures()
        {
            return super.removeSpecificOtherStructures();
        }
        public NCWindOnlyPropertyEndorsements addOtherStructures()
        {
            return super.clickAddOtherStructures();
        }
        public NCWindOnlyPropertyEndorsements removeOtherStructures()
        {
            return super.clickRemoveOtherStructures();
        }
        public NCWindOnlyPropertyEndorsements setOccurrenceAggregateLimit(String text)
        {
            return super.setOccurrenceAggregateLimit(text);
        }

        public String getOccurrenceAggregateLimit()
        {
            return super.getOccurrenceAggregateLimit();
        }
        public NCWindOnlyPropertyEndorsements setLossAssessmentLimit(String text)
        {
            return super.setLossAssessmentLimit(text);
        }

        public String getLossAssessmentLimit()
        {
            return super.getLossAssessmentLimit();
        }
        public NCWindOnlyPropertyEndorsements setOrdinanceOrLawLimit(String text)
        {
            return super.setOrdinanceOrLawLimit(text);
        }

        public String getOrdinanceOrLawLimit()
        {
            return super.getOrdinanceOrLawLimit();
        }
        public NCWindOnlyPropertyEndorsements setPercentageOfAnnualIncrease(String text)
        {
            return super.setPercentageOfAnnualIncrease(text);
        }

        public String getPercentageOfAnnualIncrease()
        {
            return super.getPercentageOfAnnualIncrease();
        }
        public NCWindOnlyPropertyEndorsements setSinkholeIndex(String text)
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

        public NCWindOnlyPropertyEndorsements setSinkholeClaimsIndex(String text)
        {
            return super.setSinkholeClaimsIndex(text);
        }

        public String getSinkholeClaimsIndex()
        {
            return super.getSinkholeClaimsIndex();
        }
        public NCWindOnlyPropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
        {
            return super.setScreenEnclosureHurricaneCoverageLimit(text);
        }

        public String getScreenEnclosureHurricaneCoverageLimit()
        {
            return super.getScreenEnclosureHurricaneCoverageLimit();
        }

        public NCWindOnlyPropertyEndorsements checkWhenSafe()
        {
            return super.checkWhenSafe();
        }
        public boolean isWhenSafeChecked()
        {
            return super.isWhenSafeChecked();
        }
        public NCWindOnlyPropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
        {
            return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
        }

        public NCWindOnlyPropertyEndorsements checkScheduledPersonalProperty()
        {
            return super.checkScheduledPersonalProperty();
        }

        public NCWindOnlyPropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
        {
            return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
        }

        public NCWindOnlyPropertyEndorsements checkScreenEnclosureHurricaneCoverage()
        {
            return super.checkScreenEnclosureHurricaneCoverage();
        }
        public NCWindOnlyPropertyEndorsements clickAddScheduledPersonalProperty()
        {
            return super.clickAddScheduledPersonalProperty();

        }
        public NCWindOnlyPropertyEndorsements clickRemoveScheduledPersonalProperty()
        {
            return super.clickRemoveScheduledPersonalProperty();
        }

        public NCWindOnlyPropertyEndorsements checkWaterBackUp()
        {
            return super.checkWaterBackUp();
        }

        public NCWindOnlyPropertyEndorsements checkInflationGuard()
        {
            return super.checkInflationGuard();
        }

        public NCWindOnlyPropertyEndorsements checkSinkholeLossCoverage()
        {
            return super.checkSinkholeLossCoverage();
        }
        public NCWindOnlyRiskAnalysis next()
        {
            super.propertyEndorsementsNext();
            return new NCWindOnlyRiskAnalysis(sh, path);
        }
        public boolean isWaterBackUpChecked()
        {
            return super.isWaterBackUpChecked();
        }
        public boolean isSpecificAdditionalAmountOfCoverageAChecked()
        {
            return super.isSpecificAdditionalAmountOfCoverageAChecked();
        }
        public NCWindOnlyPropertyEndorsements checkSpecificAdditionalAmountOfCoverageA()
        {
            return super.checkSpecificAdditionalAmountOfCoverageA();
        }
    }


    public class NCWindOnlyLiabilityEndorsements extends LiabilityEndorsements<NCWindOnlyLiabilityEndorsements>
    {
        public NCWindOnlyLiabilityEndorsements(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }

        public NCWindOnlyPropertyEndorsements clickPropertyEndorsements()
        {
            super.clickPropertyEndorsementsTab();
            return new NCWindOnlyPropertyEndorsements(sh, path);
        }
        public NCWindOnlyCoverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new NCWindOnlyCoverages(sh, path);
        }
        public NCWindOnlyLiabilityEndorsements setLocationName(String text)
        {
            return super.setLocationName(text);
        }

        public String getLocationName()
        {
            return super.getLocationName();
        }
        public NCWindOnlyLiabilityEndorsements setNumberOfFamilies(String text)
        {
            return super.setNumberOfFamilies(text);
        }

        public String getNumberOfFamilies()
        {
            return super.getNumberOfFamilies();
        }
        public NCWindOnlyLiabilityEndorsements setWatercraftType(String text)
        {
            return super.setWatercraftType(text);
        }

        public String getWatercraftType()
        {
            return super.getWatercraftType();
        }
        public NCWindOnlyLiabilityEndorsements setBusinessActivity(String text)
        {
            return super.setBusinessActivity(text);
        }

        public String getBusinessActivity()
        {
            return super.getBusinessActivity();
        }

        public NCWindOnlyLiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
        {
            return super.checkPermittedIncidentalOccupancyLiability();
        }

        public NCWindOnlyLiabilityEndorsements checkAnimalLiability()
        {
            return super.checkAnimalLiability();
        }

        public NCWindOnlyLiabilityEndorsements checkAdditionalResidenceRentedToOthers()
        {
            return super.checkAdditionalResidenceRentedToOthers();
        }

        public NCWindOnlyLiabilityEndorsements checkBusinessPursuits()
        {
            return super.checkBusinessPursuits();
        }

        public NCWindOnlyLiabilityEndorsements checkWatercraftLiability()
        {
            return super.checkWatercraftLiability();
        }
        public NCWindOnlyRiskAnalysis next()
        {
            super.liabilityEndorsementsNext();
            return new NCWindOnlyRiskAnalysis(sh, path);
        }














    }
}
