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
    }



}
