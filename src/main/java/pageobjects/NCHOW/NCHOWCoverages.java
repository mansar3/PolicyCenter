package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWCoverages extends Coverages<NCHOWCoverages> {

    public NCHOWCoverages(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWRiskAnalysis next()
    {
        coveragesNext();
        return new NCHOWRiskAnalysis(sh, path);
    }
    public String getDwellingLimit()
    {
        return super.getDwellingLimit();
    }

    public NCHOWCoverages setDwellingLimit(String text)
    {
        return super.setDwellingLimit(text);
    }
    public String getPersonalPropertyLimit()
    {
        return super.getPersonalPropertyLimit();
    }

    public NCHOWCoverages setPersonalPropertyLimit(String text)
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

    public NCHOWCoverages setOtherStructuresPercentage(String text)
    {
        return super.setOtherStructuresPercentage(text);
    }
    public String getOtherStructuresLimit()
    {
        return super.getOtherStructuresLimit();
    }

    public NCHOWCoverages setPersonalPropertyExcluded(String flag)
    {
        return super.setPersonalPropertyExcluded(flag);

    }
    public String getPersonalPropertyValuationMethod()
    {
        return super.getPersonalPropertyValuationMethod();
    }

    public NCHOWCoverages setPersonalPropertyValuationMethod(String text)
    {
        return super.setPersonalPropertyValuationMethod(text);
    }
    public NCHOWCoverages coveragesEnter(){return super.coveragesEnter();}
    public String coveragesErrorMessage(){return super.coveragesErrorMessage();}

    public NCHOWCoverages setLossOfUseSelection(String text)
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

    public NCHOWCoverages setHurricane(String text)
    {
        return super.setHurricane(text);

    }
    public String getAllOtherPerils()
    {
        return super.getAllOtherPerils();
    }

    public NCHOWCoverages setAllOtherPerils(String text)
    {
        return super.setAllOtherPerils(text);

    }

    public NCHOWCoverages setWindExcluded(String flag)
    {
        return super.setWindExcluded(flag);

    }

    public String getPersonalLiabilityLimit()
    {
        return super.getPersonalLiabilityLimit();
    }

    public NCHOWCoverages setPersonalLiabilityLimit(String text)
    {
        return super.setPersonalLiabilityLimit(text);

    }
    public NCHOWCoverages back(){
        return super.dwellingConstructionBack();
    }

    public String getMedicalPaymentsLimit()
    {
        return super.getMedicalPaymentsLimit();
    }

    public NCHOWCoverages setMedicalPaymentsLimit(String text)
    {
        return super.setMedicalPaymentsLimit(text);

    }

    public NCHOWCoverages clickCoverages()
    {
        return super.clickCoverages();

    }
    public String getWindDeductibleType()
    {
        return super.getWindDeductibleType();
    }

    public NCHOWCoverages setWindDeductibleType(String text)
    {
        return super.setWindDeductibleType(text);

    }
    public String getWindHail()
    {
        return super.getWindHail();
    }

    public NCHOWCoverages setWindHail(String text)
    {
        return super.setWindHail(text);

    }
    public String getNamedStorm()
    {
        return super.getNamedStorm();
    }

    public NCHOWCoverages setNamedStorm(String text)
    {
        return super.setNamedStorm(text);

    }
    public NCHOWLiabilityEndorsements clickLiabilityEndorsements()
    {
        super.clickLiabilityEndorsementsTab();
        return new NCHOWLiabilityEndorsements(sh, path);
    }
    public NCHOWPropertyEndorsements clickPropertyEndorsements()
    {
        super.clickPropertyEndorsementsTab();
        return new NCHOWPropertyEndorsements(sh,path);
    }


    public class NCHOWPropertyEndorsements extends PropertyEndorsements<NCHOWPropertyEndorsements>
    {
        public NCHOWPropertyEndorsements(CenterSeleniumHelper sh ,Path path)
        {
            super(sh, path);
        }

        public String getWaterBackUpLimit()
        {
            return super.getWaterBackUpLimit();
        }
        public NCHOWPropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
        {
            return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
        }
        public NCHOWPropertyEndorsements clickCoveragespropertyendorsementsQuote()
        {
            return super.clickCoveragespropertyendorsementsQuote();
        }

        public boolean isEarthQuakeLossAssessment()
        {
            return super.isEarthQuakeLossAssessmentChecked();
        }
        public NCHOWPropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
        {
            return super.setPersonalPropertyArticleType(itemNumber, text);
        }
        public NCHOWPropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
        {
            return super.setPersonalPropertyDescription(itemNumber, text);
        }
        public NCHOWPropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
        {
            return super.setPersonalPropertyValue(itemNumber, text);
        }
        public NCHOWPropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setOtherStructuresDescription(itemNumber, text);
        }
        public NCHOWPropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setOtherStructuresLimit(itemNumber, text);
        }
        public NCHOWPropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresDescription(itemNumber, text);
        }
        public NCHOWPropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresLimit(itemNumber, text);
        }
        public NCHOWPropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
        {
            return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
        }

        public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
        {
            return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        }
        public NCHOWPropertyEndorsements coveragesPropertyEnter () {
            return super.coveragesPropertyEnter();
        }
        public NCHOWPropertyEndorsements checkEarthQuakeCoverage()
        {
            return super.checkEarthquakeCoverage();
        }
        public boolean isEarthquakeCoverageChecked()
        {
            return super.isEarthquakeCoverageChecked();
        }
        public NCHOWPropertyEndorsements checkSpecificOtherStructures()
        {
            return super.checkSpecificOtherStructures();
        }
        public NCHOWPropertyEndorsements checkResidenceHeldinTrust()
        {
            return super.checkResidenceHeldinTrust();
        }
        public NCHOWPropertyEndorsements checkEarthquakeLossAssessmentChecked()
        {
            return super.checkEarthquakeLossAssessment();
        }
        public NCHOWPropertyEndorsements setEarthquakeLossAssessmentLimit(String text)
        {
            return super.setEarthquakeLossAssessmentLimit(text);
        }

        public String getEarthquakeLossAssessmentLimit()
        {
            return super.getEarthquakeLossAssessmentLimit();
        }
        public NCHOWPropertyEndorsements setEarthquakeCoverageDeductiblePercentage(String text)
        {
            return super.setEarthquakeCoverageDeductiblePercentage(text);
        }

        public String getEarthquakeCoverageDeductiblePercentage()
        {
            return super.getEarthquakeCoverageDeductiblePercentage();
        }
        public NCHOWLiabilityEndorsements clickLiabilityEndorsements()
        {
            super.clickLiabilityEndorsementsTab();
            return new NCHOWLiabilityEndorsements(sh, path);
        }
        public NCHOWCoverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new NCHOWCoverages(sh, path);
        }

        public NCHOWPropertyEndorsements checkPermittedIncidentalOccupancy()
        {
            return super.checkPermittedIncidentalOccupancy();
        }

        public NCHOWPropertyEndorsements checkGuardianEndorsements()
        {
            return super.checkGuardianEndorsements();
        }
        public NCHOWPropertyEndorsements setWhenSafeCreditPercentage(String text)
        {
            return super.setWhenSafeCreditPercentage(text);
        }

        public String getWhenSafeCreditPercentage()
        {
            return super.getWhenSafeCreditPercentage();
        }
        public NCHOWPropertyEndorsements addSpecificOtherStructures()
        {
            return super.addSpecificOtherStructures();
        }
        public NCHOWPropertyEndorsements removeSpecificOtherStructures()
        {
            return super.removeSpecificOtherStructures();
        }
        public NCHOWPropertyEndorsements addOtherStructures()
        {
            return super.clickAddOtherStructures();
        }
        public NCHOWPropertyEndorsements removeOtherStructures()
        {
            return super.clickRemoveOtherStructures();
        }
        public NCHOWPropertyEndorsements setOccurrenceAggregateLimit(String text)
        {
            return super.setOccurrenceAggregateLimit(text);
        }

        public String getOccurrenceAggregateLimit()
        {
            return super.getOccurrenceAggregateLimit();
        }
        public NCHOWPropertyEndorsements setLossAssessmentLimit(String text)
        {
            return super.setLossAssessmentLimit(text);
        }

        public String getLossAssessmentLimit()
        {
            return super.getLossAssessmentLimit();
        }
        public NCHOWPropertyEndorsements setOrdinanceOrLawLimit(String text)
        {
            return super.setOrdinanceOrLawLimit(text);
        }

        public String getOrdinanceOrLawLimit()
        {
            return super.getOrdinanceOrLawLimit();
        }
        public NCHOWPropertyEndorsements setPercentageOfAnnualIncrease(String text)
        {
            return super.setPercentageOfAnnualIncrease(text);
        }

        public String getPercentageOfAnnualIncrease()
        {
            return super.getPercentageOfAnnualIncrease();
        }
        public NCHOWPropertyEndorsements setSinkholeIndex(String text)
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

        public NCHOWPropertyEndorsements setSinkholeClaimsIndex(String text)
        {
            return super.setSinkholeClaimsIndex(text);
        }

        public String getSinkholeClaimsIndex()
        {
            return super.getSinkholeClaimsIndex();
        }
        public NCHOWPropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
        {
            return super.setScreenEnclosureHurricaneCoverageLimit(text);
        }

        public String getScreenEnclosureHurricaneCoverageLimit()
        {
            return super.getScreenEnclosureHurricaneCoverageLimit();
        }

        public NCHOWPropertyEndorsements checkWhenSafe()
        {
            return super.checkWhenSafe();
        }
        public boolean isWhenSafeChecked()
        {
            return super.isWhenSafeChecked();
        }
        public NCHOWPropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
        {
            return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
        }

        public NCHOWPropertyEndorsements checkScheduledPersonalProperty()
        {
            return super.checkScheduledPersonalProperty();
        }

        public NCHOWPropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
        {
            return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
        }

        public NCHOWPropertyEndorsements checkScreenEnclosureHurricaneCoverage()
        {
            return super.checkScreenEnclosureHurricaneCoverage();
        }
        public NCHOWPropertyEndorsements clickAddScheduledPersonalProperty()
        {
            return super.clickAddScheduledPersonalProperty();

        }
        public NCHOWPropertyEndorsements clickRemoveScheduledPersonalProperty()
        {
            return super.clickRemoveScheduledPersonalProperty();
        }

        public NCHOWPropertyEndorsements checkWaterBackUp()
        {
            return super.checkWaterBackUp();
        }

        public NCHOWPropertyEndorsements checkInflationGuard()
        {
            return super.checkInflationGuard();
        }

        public NCHOWPropertyEndorsements checkSinkholeLossCoverage()
        {
            return super.checkSinkholeLossCoverage();
        }
        public NCHOWRiskAnalysis next()
        {
            super.propertyEndorsementsNext();
            return new NCHOWRiskAnalysis(sh, path);
        }
        public boolean isWaterBackUpChecked()
        {
            return super.isWaterBackUpChecked();
        }
        public boolean isSpecificAdditionalAmountOfCoverageAChecked()
        {
            return super.isSpecificAdditionalAmountOfCoverageAChecked();
        }
        public NCHOWPropertyEndorsements checkSpecificAdditionalAmountOfCoverageA()
        {
            return super.checkSpecificAdditionalAmountOfCoverageA();
        }
    }


    public class NCHOWLiabilityEndorsements extends LiabilityEndorsements<NCHOWLiabilityEndorsements>
    {
        public NCHOWLiabilityEndorsements(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }

        public NCHOWPropertyEndorsements clickPropertyEndorsements()
        {
            super.clickPropertyEndorsementsTab();
            return new NCHOWPropertyEndorsements(sh, path);
        }
        public NCHOWCoverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new NCHOWCoverages(sh, path);
        }
        public NCHOWLiabilityEndorsements setLocationName(String text)
        {
            return super.setLocationName(text);
        }

        public String getLocationName()
        {
            return super.getLocationName();
        }
        public NCHOWLiabilityEndorsements setNumberOfFamilies(String text)
        {
            return super.setNumberOfFamilies(text);
        }

        public String getNumberOfFamilies()
        {
            return super.getNumberOfFamilies();
        }
        public NCHOWLiabilityEndorsements setWatercraftType(String text)
        {
            return super.setWatercraftType(text);
        }

        public String getWatercraftType()
        {
            return super.getWatercraftType();
        }
        public NCHOWLiabilityEndorsements setBusinessActivity(String text)
        {
            return super.setBusinessActivity(text);
        }

        public String getBusinessActivity()
        {
            return super.getBusinessActivity();
        }

        public NCHOWLiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
        {
            return super.checkPermittedIncidentalOccupancyLiability();
        }

        public NCHOWLiabilityEndorsements checkAnimalLiability()
        {
            return super.checkAnimalLiability();
        }

        public NCHOWLiabilityEndorsements checkAdditionalResidenceRentedToOthers()
        {
            return super.checkAdditionalResidenceRentedToOthers();
        }

        public NCHOWLiabilityEndorsements checkBusinessPursuits()
        {
            return super.checkBusinessPursuits();
        }

        public NCHOWLiabilityEndorsements checkWatercraftLiability()
        {
            return super.checkWatercraftLiability();
        }
        public NCHOWRiskAnalysis next()
        {
            super.liabilityEndorsementsNext();
            return new NCHOWRiskAnalysis(sh, path);
        }














    }
}
