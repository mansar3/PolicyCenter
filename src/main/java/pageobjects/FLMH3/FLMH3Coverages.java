package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3Coverages extends Coverages<FLMH3Coverages> {

    public FLMH3Coverages(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3RiskAnalysis next()
    {
        coveragesNext();
        return new FLMH3RiskAnalysis(sh, path);
    }
    public String getDwellingLimit()
    {
        return super.getDwellingLimit();
    }

    public FLMH3Coverages setDwellingLimit(String text)
    {
        return super.setDwellingLimit(text);
    }
    public String getPersonalPropertyLimit()
    {
        return super.getPersonalPropertyLimit();
    }

    public FLMH3Coverages setPersonalPropertyLimit(String text)
    {
        return super.setPersonalPropertyLimit(text);
    }
    public String getOtherStructuresPercentage()
    {
        return super.getOtherStructuresPercentage();
    }

    public FLMH3Coverages setOtherStructuresPercentage(String text)
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

    public FLMH3Coverages setPersonalPropertyExcluded(String flag)
    {
        return super.setPersonalPropertyExcluded(flag);

    }
    public FLMH3Coverages coveragesEnter(){return super.coveragesEnter();}
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

    public FLMH3Coverages setPersonalPropertyValuationMethod(String text)
    {
        return super.setPersonalPropertyValuationMethod(text);
    }

    public FLMH3Coverages setLossOfUseSelection(String text)
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

    public String getHurricane()
    {
        return super.getHurricane();
    }

    public FLMH3Coverages setHurricane(String text)
    {
        return super.setHurricane(text);

    }
    public FLMH3Coverages back(){
        return super.dwellingConstructionBack();
    }


    public String getAllOtherPerils()
    {
        return super.getAllOtherPerils();
    }

    public FLMH3Coverages setAllOtherPerils(String text)
    {
        return super.setAllOtherPerils(text);

    }

    public String getSectionIDeductibles()
    {
        return super.getSectionIDeductibles();
    }

    public FLMH3Coverages setWindExcluded(String flag)
    {
        return super.setWindExcluded(flag);

    }

    public String getPersonalLiabilityLimit()
    {
        return super.getPersonalLiabilityLimit();
    }

    public FLMH3Coverages setPersonalLiabilityLimit(String text)
    {
        return super.setPersonalLiabilityLimit(text);

    }
    public String getMedicalPaymentsLimit()
    {
        return super.getMedicalPaymentsLimit();
    }

    public FLMH3Coverages setMedicalPaymentsLimit(String text)
    {
        return super.setMedicalPaymentsLimit(text);

    }

    public FLMH3Coverages clickCoverages()
    {
        return super.clickCoverages();

    }
    public FLMH3Coverages setPermittedIncidentalOccupalimit(String text)
    {
        return super.PermittedIncidentalOccupalimit(text);
    }
    public String getWindDeductibleType()
    {
        return super.getWindDeductibleType();
    }

    public FLMH3Coverages setWindDeductibleType(String text)
    {
        return super.setWindDeductibleType(text);

    }
    public String getWindHail()
    {
        return super.getWindHail();
    }

    public FLMH3Coverages setWindHail(String text)
    {
        return super.setWindHail(text);

    }
    public String getNamedStorm()
    {
        return super.getNamedStorm();
    }

    public FLMH3Coverages setNamedStorm(String text)
    {
        return super.setNamedStorm(text);
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

    public FLMH3LiabilityEndorsements clickLiabilityEndorsements()
    {
        super.clickLiabilityEndorsementsTab();
        return new FLMH3LiabilityEndorsements(sh, path);
    }
    public FLMH3PropertyEndorsements clickPropertyEndorsements()
    {
        super.clickPropertyEndorsementsTab();
        return new FLMH3PropertyEndorsements(sh,path);
    }


    public class FLMH3PropertyEndorsements extends PropertyEndorsements<FLMH3PropertyEndorsements>
    {
        public FLMH3PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
        {
            super(sh, path);
        }

        public String getWaterBackUpLimit()
        {
            return super.getWaterBackUpLimit();
        }
        public FLMH3PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
        {
            return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
        }
        public FLMH3PropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
        {
            return super.setPersonalPropertyArticleType(itemNumber, text);
        }
        public FLMH3PropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
        {
            return super.setPersonalPropertyDescription(itemNumber, text);
        }
        public FLMH3PropertyEndorsements clickAddScheduledPersonalProperty()
        {
            return super.clickAddScheduledPersonalProperty();

        }
        public FLMH3PropertyEndorsements coveragespropertyendorsementsEnter(){return super.coveragespropertyendorsementsEnter();}

        public FLMH3PropertyEndorsements clickRemoveScheduledPersonalProperty()
        {
            return super.clickRemoveScheduledPersonalProperty();
        }
        public FLMH3PropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
        {
            return super.setPersonalPropertyValue(itemNumber, text);
        }
        public FLMH3PropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setOtherStructuresDescription(itemNumber, text);
        }
        public FLMH3PropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setOtherStructuresLimit(itemNumber, text);
        }
        public FLMH3PropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresDescriptionMH3(itemNumber, text);
        }
        public FLMH3PropertyEndorsements setSpecificOtherStructuresAttachedDetached (int itemNumber, String text){
            return super.setSpecificOtherStructuresAttachedDetached(itemNumber, text);
        }
        public FLMH3PropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresLimitMH3(itemNumber, text);
        }

        public String getScheduledPersonalPropertyClassArticleType(int itemNumber)
        {
            return super.getScheduledPersonalPropertyClassArticleType(itemNumber);
        }

        public String getScheduledPersonalPropertyClassValue(int itemNumber)
        {
            return super.getScheduledPersonalPropertyClassValue(itemNumber);
        }

        public FLMH3PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
        {
            return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
        }

        public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
        {
            return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        }

        public FLMH3PropertyEndorsements checkSpecificOtherStructures()
        {
            return super.checkSpecificOtherStructures();
        }

        public FLMH3LiabilityEndorsements clickLiabilityEndorsements()
        {
            super.clickLiabilityEndorsementsTab();
            return new FLMH3LiabilityEndorsements(sh, path);
        }
        public FLMH3Coverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new FLMH3Coverages(sh, path);
        }

        public FLMH3PropertyEndorsements checkPermittedIncidentalOccupancy()
        {
            return super.checkPermittedIncidentalOccupancy();
        }

//		public FLMH3PropertyEndorsements setPermittedIncidentalOccupalimit(String text)
//		{
//			return super.PermittedIncidentalOccupalimit(text);
//		}

        public FLMH3PropertyEndorsements checkGuardianEndorsements()
        {
            return super.checkGuardianEndorsements();
        }
        public FLMH3PropertyEndorsements setWhenSafeCreditPercentage(String text)
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

        public String getCreditValue()
        {
            return super.getWhenSafeCreditValue();
        }

        public FLMH3PropertyEndorsements addSpecificOtherStructures()
        {
            return super.addSpecificOtherStructures();
        }
        public FLMH3PropertyEndorsements removeSpecificOtherStructures()
        {
            return super.removeSpecificOtherStructures();
        }
        public FLMH3PropertyEndorsements addOtherStructures()
        {
            return super.clickAddOtherStructures();
        }
        public FLMH3PropertyEndorsements removeOtherStructures()
        {
            return super.clickRemoveOtherStructures();
        }
        public FLMH3PropertyEndorsements setOccurrenceAggregateLimit(String text)
        {
            return super.setOccurrenceAggregateLimit(text);
        }

        public String getOccurrenceAggregateLimit()
        {
            return super.getOccurrenceAggregateLimit();
        }
        public FLMH3PropertyEndorsements setLossAssessmentLimit(String text)
        {
            return super.setLossAssessmentLimit(text);
        }

        public String getLossAssessmentLimit()
        {
            return super.getLossAssessmentLimit();
        }
        public FLMH3PropertyEndorsements setOrdinanceOrLawLimit(String text)
        {
            return super.setOrdinanceOrLawLimit(text);
        }

        public String getOrdinanceOrLawLimit()
        {
            return super.getOrdinanceOrLawLimit();
        }
        public FLMH3PropertyEndorsements setPercentageOfAnnualIncrease(String text)
        {
            return super.setPercentageOfAnnualIncrease(text);
        }

        public String getPercentageOfAnnualIncrease()
        {
            return super.getPercentageOfAnnualIncrease();
        }
        public FLMH3PropertyEndorsements setSinkholeIndex(String text)
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

        public FLMH3PropertyEndorsements setSinkholeClaimsIndex(String text)
        {
            return super.setSinkholeClaimsIndex(text);
        }

        public String getSinkholeClaimsIndex()
        {
            return super.getSinkholeClaimsIndex();
        }
        public FLMH3PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
        {
            return super.setScreenEnclosureHurricaneCoverageLimit(text);
        }

        public String getScreenEnclosureHurricaneCoverageLimit()
        {
            return super.getScreenEnclosureHurricaneCoverageLimit();
        }

        public FLMH3PropertyEndorsements checkWhenSafe()
        {
            return super.checkWhenSafe();
        }

        public FLMH3PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
        {
            return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
        }

        public boolean isOtherStructuresIncreasedCoverageChecked()
        {
            return super.isOtherStructuresIncreasedCoverageChecked();
        }

        public FLMH3PropertyEndorsements checkScheduledPersonalProperty()
        {
            return super.checkScheduledPersonalProperty();
        }

        public boolean isScheduledPersonalPropertyChecked()
        {
            return super.isScheduledPersonalPropertyChecked();
        }

        public FLMH3PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
        {
            return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
        }

        public FLMH3PropertyEndorsements checkGolfCartCoverage()
        {
            return super.checkGolfCartCoverage();
        }

        public String getGolfCartCoveragePropertyLimit()
        {
            return super.getGolfCartCoveragePropertyLimit();
        }

        public String getGolfCartCoverageMedPayLimit()
        {
            return super.getGolfCartCoverageMedPayLimit();
        }

        public String getGolfCartCoverageLiabilityLimit()
        {
            return super.getGolfCartCoverageLiabilityLimit();
        }

        public FLMH3PropertyEndorsements checkJewelryTheftIncreasedLimit()
        {
            return super.checkJewelryTheftIncreasedLimit();
        }

        public String getJewelryTheftIncreasedLimit()
        {
            return super.getJewelryTheftIncreasedLimit();
        }

        public boolean isCreditCardFundTransferForgeryCounterfeitChecked()
        {
            return super.isCreditCardFundTransferForgeryCounterfeitMoneyChecked();
        }

        public FLMH3PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
        {
            return super.checkScreenEnclosureHurricaneCoverage();
        }

        public boolean isScreenEnclosureHurricaneCoverageChecked()
        {
            return super.isScreenEnclosureHurricaneCoverageChecked();
        }

        public FLMH3PropertyEndorsements checkWaterBackUp()
        {
            return super.checkWaterBackUp();
        }

        public FLMH3PropertyEndorsements checkInflationGuard()
        {
            return super.checkInflationGuard();
        }

        public FLMH3PropertyEndorsements checkSinkholeLossCoverage()
        {
            return super.checkSinkholeLossCoverage();
        }

        public boolean isSinkholeLossCoverageChecked()
        {
            return super.isSinkholeLossCoverageChecked();
        }

        @Override
        public void clickSaveDraft() {
            super.clickSaveDraft();
        }

        public FLMH3RiskAnalysis next()
        {
            super.propertyEndorsementsNext();
            return new FLMH3RiskAnalysis(sh, path);
        }
        public boolean isWaterBackUpChecked()
        {
            return super.isWaterBackUpChecked();
        }

        public boolean isGuardianEndorsementChecked()
        {
            return super.isGuardianEndorsementsChecked();
        }
    }


    public class FLMH3LiabilityEndorsements extends LiabilityEndorsements<FLMH3LiabilityEndorsements>
    {
        public FLMH3LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }

        public FLMH3PropertyEndorsements clickPropertyEndorsements()
        {
            super.clickPropertyEndorsementsTab();
            return new FLMH3PropertyEndorsements(sh, path);
        }
        public FLMH3Coverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new FLMH3Coverages(sh, path);
        }
        public FLMH3LiabilityEndorsements setLocationName(String text)
        {
            return super.setLocationName(text);
        }

        public String getLocationName()
        {
            return super.getLocationName();
        }
        public FLMH3LiabilityEndorsements setNumberOfFamilies(String text)
        {
            return super.setNumberOfFamilies(text);
        }

        public String getNumberOfFamilies()
        {
            return super.getNumberOfFamilies();
        }
        public FLMH3LiabilityEndorsements setWatercraftType(String text)
        {
            return super.setWatercraftType(text);
        }

        public String getWatercraftType()
        {
            return super.getWatercraftType();
        }
        public FLMH3LiabilityEndorsements setBusinessActivity(String text)
        {
            return super.setBusinessActivity(text);
        }

        public String getBusinessActivity()
        {
            return super.getBusinessActivity();
        }

        public FLMH3LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
        {
            return super.checkPermittedIncidentalOccupancyLiability();
        }

        public FLMH3LiabilityEndorsements unCheckPermittedIncidentalOccupancyLiability()
        {
            return super.unCheckPermittedIncidentalOccupancyLiability();
        }

        public FLMH3LiabilityEndorsements checkAnimalLiability()
        {
            return super.checkAnimalLiability();
        }

        public FLMH3LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
        {
            return super.checkAdditionalResidenceRentedToOthers();
        }

        public FLMH3LiabilityEndorsements checkBusinessPursuits()
        {
            return super.checkBusinessPursuits();
        }

        public FLMH3LiabilityEndorsements checkWatercraftLiability()
        {
            return super.checkWatercraftLiability();
        }
        public FLMH3RiskAnalysis next()
        {
            super.liabilityEndorsementsNext();
            return new FLMH3RiskAnalysis(sh, path);
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
