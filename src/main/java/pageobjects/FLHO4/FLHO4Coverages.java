package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;
import pageobjects.WizardPanelBase.Coverages;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4Coverages extends Coverages<FLHO4Coverages> {

    public FLHO4Coverages(CenterSeleniumHelper sh, CenterPanelBase.Path path)
    {
        super(sh, path);
    }

    public FLHO4RiskAnalysis next()
    {
        coveragesNext();
        return new FLHO4RiskAnalysis(sh, path);
    }
    public String getDwellingLimit()
    {
        return super.getDwellingLimit();
    }

    public FLHO4Quote coveragesQuote(){
        super.CoverageQuote();
        return new FLHO4Quote(sh, path );
    }

    public FLHO4PreQuoteIssues  coveragesquoteWithIssues()
    {
        super.CoverageQuote();
        return new FLHO4PreQuoteIssues(sh, path);
    }


    public FLHO4Coverages setDwellingLimit(String text)
    {
        return super.setDwellingLimit(text);
    }
    public String getPersonalPropertyLimit()
    {
        return super.getPersonalPropertyLimit();
    }

    public FLHO4Coverages setPersonalPropertyLimit(String text)
    {
        return super.setPersonalPropertyLimit(text);
    }
    public String getOtherStructuresPercentage()
    {
        return super.getOtherStructuresPercentage();
    }

    public FLHO4Coverages setOtherStructuresPercentage(String text)
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

    public FLHO4Coverages setPersonalPropertyExcluded(String flag)
    {
        return super.setPersonalPropertyExcluded(flag);

    }
    public FLHO4Coverages coveragesEnter(){return super.coveragesEnter();}

    public String coveragesErrorMessage(){return super.coveragesErrorMessage();}
    public String coveragesErrorMessage2(){return super.coveragesErrorMessage2();}
    public String coveragesErrorMessage3(){return super.coveragesErrorMessage3();}




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
    public FLHO4Coverages clickEditPolicyTransaction(){
        return super.editPolicyTransaction();
    }

    public FLHO4Coverages acceptYes()
    {
        return super.accept();
    }


    public FLHO4Coverages setPersonalPropertyValuationMethod(String text)
    {
        return super.setPersonalPropertyValuationMethod(text);
    }

    public FLHO4Coverages setLossOfUseSelection(String text)
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

    public String getHurricanePercentage()
    {
        return super.getHurricanePercentage();
    }

    public FLHO4Coverages setHurricane(String text)
    {
        return super.setHurricane(text);

    }
    public FLHO4Coverages back(){
        return super.dwellingConstructionBack();
    }


    public String getAllOtherPerils()
    {
        return super.getAllOtherPerils();
    }

    public FLHO4Coverages setAllOtherPerils(String text)
    {
        return super.setAllOtherPerils(text);

    }

    public FLHO4Coverages setWindExcluded(String flag)
    {
        return super.setWindExcluded(flag);

    }

    public String getPersonalLiabilityLimit()
    {
        return super.getPersonalLiabilityLimit();
    }

    public FLHO4Coverages setPersonalLiabilityLimit(String text)
    {
        return super.setPersonalLiabilityLimit(text);

    }
    public String getMedicalPaymentsLimit()
    {
        return super.getMedicalPaymentsLimit();
    }

    public FLHO4Coverages setMedicalPaymentsLimit(String text)
    {
        return super.setMedicalPaymentsLimit(text);

    }

    public FLHO4Coverages clickCoverages()
    {
        return super.clickCoverages();

    }
    public FLHO4Coverages setPermittedIncidentalOccupalimit(String text)
    {
        return super.PermittedIncidentalOccupalimit(text);
    }
    public String getWindDeductibleType()
    {
        return super.getWindDeductibleType();
    }

    public FLHO4Coverages setWindDeductibleType(String text)
    {
        return super.setWindDeductibleType(text);

    }
    public String getWindHail()
    {
        return super.getWindHail();
    }

    public FLHO4Coverages setWindHail(String text)
    {
        return super.setWindHail(text);

    }
    public String getNamedStorm()
    {
        return super.getNamedStorm();
    }

    public FLHO4Coverages setNamedStorm(String text)
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

    public FLHO4LiabilityEndorsements clickLiabilityEndorsements()
    {
        super.clickLiabilityEndorsementsTab();
        return new FLHO4LiabilityEndorsements(sh, path);
    }
    public FLHO4PropertyEndorsements clickPropertyEndorsements()
    {
        super.clickPropertyEndorsementsTab();
        return new FLHO4PropertyEndorsements(sh,path);
    }


    public class FLHO4PropertyEndorsements extends PropertyEndorsements<FLHO4PropertyEndorsements>
    {
        public FLHO4PropertyEndorsements(CenterSeleniumHelper sh ,Path path)
        {
            super(sh, path);
        }

        public String getWaterBackUpLimit()
        {
            return super.getWaterBackUpLimit();
        }
        public FLHO4PropertyEndorsements setDoesExteriorMasonryVeneerExclusionApply(String flag)
        {
            return super.setDoesExteriorMasonryVeneerExclusionApply(flag);
        }
        public FLHO4PropertyEndorsements clickpersonalPropertyRow(int itemNumber)
        {
            return super.chechPersonalPropertyrow(itemNumber);
        }
        public FLHO4PropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
        {
            return super.setPersonalPropertyArticleType(itemNumber, text);
        }
        public FLHO4PropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
        {
            return super.setPersonalPropertyDescription(itemNumber, text);
        }
        public FLHO4PropertyEndorsements clickAddScheduledPersonalProperty()
        {
            return super.clickAddScheduledPersonalProperty();

        }
        public FLHO4PropertyEndorsements clickRemoveScheduledPersonalProperty()
        {
            return super.clickRemoveScheduledPersonalProperty();
        }
        public FLHO4PropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
        {
            return super.setPersonalPropertyValue(itemNumber, text);
        }
        public FLHO4PropertyEndorsements setOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setOtherStructuresDescription(itemNumber, text);
        }
        public FLHO4PropertyEndorsements setOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setOtherStructuresLimit(itemNumber, text);
        }
        public FLHO4PropertyEndorsements setSpecificOtherStructuresDescription(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresDescription(itemNumber, text);
        }
        public FLHO4PropertyEndorsements setSpecificOtherStructuresLimit(int itemNumber, String text)
        {
            return super.setSpecificOtherStructuresLimit(itemNumber, text);
        }
        public FLHO4PropertyEndorsements setCreditCardFundTransferForgeryCounterfeitMoneyLimit(String text)
        {
            return super.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(text);
        }

        public String getCreditCardFundTransferForgeryCounterfeitMoneyLimit()
        {
            return super.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        }

        public FLHO4PropertyEndorsements checkSpecificOtherStructures()
        {
            return super.checkSpecificOtherStructures();
        }

        public FLHO4LiabilityEndorsements clickLiabilityEndorsements()
        {
            super.clickLiabilityEndorsementsTab();
            return new FLHO4LiabilityEndorsements(sh, path);
        }
        public FLHO4Coverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new FLHO4Coverages(sh, path);
        }

        public FLHO4PropertyEndorsements checkPermittedIncidentalOccupancy()
        {
            return super.checkPermittedIncidentalOccupancy();
        }

//		public FLHO4PropertyEndorsements setPermittedIncidentalOccupalimit(String text)
//		{
//			return super.PermittedIncidentalOccupalimit(text);
//		}

        public FLHO4Quote clickcoveragesPropertyEndorsementsQuote()
        {
            super.clickCoveragesPropertyEndorsementsQuote();
            return new FLHO4Quote(sh, path);

        }
        public FLHO4PropertyEndorsements checkGuardianEndorsements()
        {
            return super.checkGuardianEndorsements();
        }
        public FLHO4PropertyEndorsements setWhenSafeCreditPercentage(String text)
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

        public FLHO4PropertyEndorsements addSpecificOtherStructures()
        {
            return super.addSpecificOtherStructures();
        }
        public FLHO4PropertyEndorsements removeSpecificOtherStructures()
        {
            return super.removeSpecificOtherStructures();
        }
        public FLHO4PropertyEndorsements addOtherStructures()
        {
            return super.clickAddOtherStructures();
        }
        public FLHO4PropertyEndorsements removeOtherStructures()
        {
            return super.clickRemoveOtherStructures();
        }
        public FLHO4PropertyEndorsements setOccurrenceAggregateLimit(String text)
        {
            return super.setOccurrenceAggregateLimit(text);
        }

        public String getOccurrenceAggregateLimit()
        {
            return super.getOccurrenceAggregateLimit();
        }
        public FLHO4PropertyEndorsements setLossAssessmentLimit(String text)
        {
            return super.setLossAssessmentLimit(text);
        }

        public String getLossAssessmentLimit()
        {
            return super.getLossAssessmentLimit();
        }
        public FLHO4PropertyEndorsements setOrdinanceOrLawLimit(String text)
        {
            return super.setOrdinanceOrLawLimit(text);
        }

        public String getOrdinanceOrLawLimit()
        {
            return super.getOrdinanceOrLawLimit();
        }
        public FLHO4PropertyEndorsements setPercentageOfAnnualIncrease(String text)
        {
            return super.setPercentageOfAnnualIncrease(text);
        }

        public String getPercentageOfAnnualIncrease()
        {
            return super.getPercentageOfAnnualIncrease();
        }
        public FLHO4PropertyEndorsements setSinkholeIndex(String text)
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

        public FLHO4PropertyEndorsements setSinkholeClaimsIndex(String text)
        {
            return super.setSinkholeClaimsIndex(text);
        }

        public String getSinkholeClaimsIndex()
        {
            return super.getSinkholeClaimsIndex();
        }
        public FLHO4PropertyEndorsements setScreenEnclosureHurricaneCoverageLimit(String text)
        {
            return super.setScreenEnclosureHurricaneCoverageLimit(text);
        }

        public String getScreenEnclosureHurricaneCoverageLimit()
        {
            return super.getScreenEnclosureHurricaneCoverageLimit();
        }

        public FLHO4PropertyEndorsements checkWhenSafe()
        {
            return super.checkWhenSafe();
        }

        public FLHO4PropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
        {
            return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
        }

        public boolean isOtherStructuresIncreasedCoverageChecked()
        {
            return super.isOtherStructuresIncreasedCoverageChecked();
        }

        public FLHO4PropertyEndorsements checkScheduledPersonalProperty()
        {
            return super.checkScheduledPersonalProperty();
        }

        public FLHO4PropertyEndorsements uncheckScheduledPersonalProperty()
        {
            return super.unCheckScheduledPersonalProperty();
        }
        public boolean isScheduledPersonalPropertyChecked()
        {
            return super.isScheduledPersonalPropertyChecked();
        }

        public FLHO4PropertyEndorsements checkCreditCardFundTransferForgeryCounterfeitMoney()
        {
            return super.checkCreditCardFundTransferForgeryCounterfeitMoney();
        }

        public boolean isCreditCardFundTransferForgeryCounterfeitChecked()
        {
            return super.isCreditCardFundTransferForgeryCounterfeitMoneyChecked();
        }

        public FLHO4PropertyEndorsements checkScreenEnclosureHurricaneCoverage()
        {
            return super.checkScreenEnclosureHurricaneCoverage();
        }

        public boolean isScreenEnclosureHurricaneCoverageChecked()
        {
            return super.isScreenEnclosureHurricaneCoverageChecked();
        }

        public FLHO4PropertyEndorsements checkWaterBackUp()
        {
            return super.checkWaterBackUp();
        }

        public FLHO4PropertyEndorsements checkInflationGuard()
        {
            return super.checkInflationGuard();
        }

        public FLHO4PropertyEndorsements checkSinkholeLossCoverage()
        {
            return super.checkSinkholeLossCoverage();
        }

        public boolean isSinkholeLossCoverageChecked()
        {
            return super.isSinkholeLossCoverageChecked();
        }

        public FLHO4RiskAnalysis next()
        {
            super.propertyEndorsementsNext();
            return new FLHO4RiskAnalysis(sh, path);
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


    public class FLHO4LiabilityEndorsements extends LiabilityEndorsements<FLHO4LiabilityEndorsements>
    {
        public FLHO4LiabilityEndorsements(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }

        public FLHO4PropertyEndorsements clickPropertyEndorsements()
        {
            super.clickPropertyEndorsementsTab();
            return new FLHO4PropertyEndorsements(sh, path);
        }
        public FLHO4Coverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new FLHO4Coverages(sh, path);
        }
        public FLHO4LiabilityEndorsements setLocationName(String text)
        {
            return super.setLocationName(text);
        }

        public String getLocationName()
        {
            return super.getLocationName();
        }
        public FLHO4LiabilityEndorsements setNumberOfFamilies(String text)
        {
            return super.setNumberOfFamilies(text);
        }

        public String getNumberOfFamilies()
        {
            return super.getNumberOfFamilies();
        }
        public FLHO4LiabilityEndorsements setWatercraftType(String text)
        {
            return super.setWatercraftType(text);
        }

        public String getWatercraftType()
        {
            return super.getWatercraftType();
        }
        public FLHO4LiabilityEndorsements setBusinessActivity(String text)
        {
            return super.setBusinessActivity(text);
        }

        public String getBusinessActivity()
        {
            return super.getBusinessActivity();
        }

        public FLHO4LiabilityEndorsements checkPermittedIncidentalOccupancyLiability()
        {
            return super.checkPermittedIncidentalOccupancyLiability();
        }

        public FLHO4LiabilityEndorsements unCheckPermittedIncidentalOccupancyLiability()
        {
            return super.unCheckPermittedIncidentalOccupancyLiability();
        }

        public FLHO4LiabilityEndorsements checkAnimalLiability()
        {
            return super.checkAnimalLiability();
        }

        public FLHO4LiabilityEndorsements checkAdditionalResidenceRentedToOthers()
        {
            return super.checkAdditionalResidenceRentedToOthers();
        }

        public FLHO4LiabilityEndorsements checkBusinessPursuits()
        {
            return super.checkBusinessPursuits();
        }

        public FLHO4LiabilityEndorsements checkWatercraftLiability()
        {
            return super.checkWatercraftLiability();
        }
        public FLHO4RiskAnalysis next()
        {
            super.liabilityEndorsementsNext();
            return new FLHO4RiskAnalysis(sh, path);
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
