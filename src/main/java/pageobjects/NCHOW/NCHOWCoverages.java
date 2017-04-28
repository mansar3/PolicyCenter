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

    public NCHOWQuote coveragesQuote(){
        super.CoverageQuote();
        return new NCHOWQuote(sh, path );
    }

    public NCHOWPreQuoteIssues  coveragesquoteWithIssues()
    {
        super.CoverageQuote();
        return new NCHOWPreQuoteIssues(sh, path);
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

    public String getOtherStructurePercentageGreyedOut()
    {
        return super.getOtherStructuresLimitGreyedOut();
    }

    public String getOtherStructuresLimit()
    {
        return super.getOtherStructuresLimit();
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

    public String getLossOfUseSelection()
    {
        return super.getLossOfUseSelection();
    }
    public String getLossOfUseLimit()
    {
        return super.getLossOfUseLimit();
    }

    public NCHOWCoverages back(){
        return super.dwellingConstructionBack();
    }

    public NCHOWCoverages clickCoverages()
    {
        return super.clickCoverages();

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
    public boolean isNamedStormDisplayed()
	{
		return super.isNamedStormDisplayed();
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

        public NCHOWPropertyEndorsements coveragesPropertyEnter () {
            return super.coveragesPropertyEnter();
        }

        public NCHOWPropertyEndorsements checkSpecificOtherStructures()
        {
            return super.checkSpecificOtherStructures();
        }
        public NCHOWPropertyEndorsements checkResidenceHeldInTrust()
        {
            return super.checkResidenceHeldInTrust();
        }

        public NCHOWCoverages clickCoverages()
        {
            super.clickCoveragesTab();
            return new NCHOWCoverages(sh, path);
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


        public NCHOWPropertyEndorsements checkScheduledPersonalProperty()
        {
            return super.checkScheduledPersonalProperty();
        }

        public NCHOWPropertyEndorsements uncheckScheduledPersonalProperty()
        {
            return super.unCheckScheduledPersonalProperty();
        }

        public NCHOWPropertyEndorsements clickAddScheduledPersonalProperty()
        {
            return super.clickAddScheduledPersonalProperty();

        }
        public NCHOWPropertyEndorsements clickRemoveScheduledPersonalProperty()
        {
            return super.clickRemoveScheduledPersonalProperty();
        }


        public NCHOWPropertyEndorsements setPersonalPropertyArticleType(int itemNumber, String text)
        {
            return super.setPersonalPropertyArticleType(itemNumber, text);
        }
        public NCHOWPropertyEndorsements setPersonalPropertyDescription(int itemNumber, String text)
        {
            return super.setPersonalPropertyDescription(itemNumber, text);
        }
        public NCHOWPropertyEndorsements setWaterBackupLimit(String text)
        {
            return super.setWaterBackUpLimit(text);
        }
        public NCHOWPropertyEndorsements setPersonalPropertyValue(int itemNumber, String text)
        {
            return super.setPersonalPropertyValue(itemNumber, text);
        }

        public NCHOWQuote clickcoveragesPropertyEndorsementsQuote()
        {
            super.clickCoveragesPropertyEndorsementsQuote();
            return new NCHOWQuote(sh, path);

        }
        
        
        
        
        
        
        public NCHOWPropertyEndorsements checkOtherStructuresIncreasedCoverageRentedToOthers()
        {
            return super.checkOtherStructuresIncreasedCoverageRentedToOthers();
        }

        public boolean isInflationGuardChecked()
		{
			return super.isInflationGuardChecked();
		}
        public NCHOWPropertyEndorsements checkInflationGuard()
        {
            return super.checkInflationGuard();
        }
		public NCHOWPropertyEndorsements unCheckInflationGuard()
        {
            return super.unCheckInflationGuard();
        }

        public NCHOWRiskAnalysis next()
        {
            super.propertyEndorsementsNext();
            return new NCHOWRiskAnalysis(sh, path);
        }

        public boolean isSpecificAdditionalAmountOfCoverageAChecked()
        {
            return super.isSpecificAdditionalAmountOfCoverageAChecked();
        }
        public NCHOWPropertyEndorsements checkSpecificAdditionalAmountOfCoverageA()
        {
            return super.checkSpecificAdditionalAmountOfCoverageA();
        }
		public NCHOWPropertyEndorsements unCheckSpecificAdditionalAmountOfCoverageA()
        {
            return super.unCheckSpecificAdditionalAmountOfCoverageA();
        }
    }



}
