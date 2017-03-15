package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWDwelling extends Dwelling<NCHOWDwelling> {
    public NCHOWDwelling(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWDwellingConstruction next()
    {
        super.DwellingConstructionNext();
        return new NCHOWDwellingConstruction(sh, path);
    }
    public NCHOWQuote clickDwellingquote()
    {
        super.DwellingQuote();
        return new NCHOWQuote(sh, path);
    }

    public NCHOWPreQuoteIssues clickDwellingquoteissue()
    {
        super.DwellingQuote();
        return new NCHOWPreQuoteIssues(sh, path);
    }

    public String getdwellingErrorMessage()
    {
        return super.dwellingErrorMessage();
    }

    public NCHOWDwelling setYearBuilt(String text)
    {
        return super.setYearBuilt(text);
    }
    public NCHOWDwelling Enter(){
        return super.Enter();
    }
    public String getYearBuilt()
    {
        return super.getYearBuilt();
    }


    public NCHOWDwelling waitForProtectionClassCode(String val)
    {
        super.waitForProtectionClassToUpdate(val);
        return new NCHOWDwelling(sh, path);
    }

    public NCHOWDwelling setTerritoryCode(String text)
    {
        return super.setTerritoryCode(text);
    }

    public NCHOWDwelling setDistanceToFireHydrant(String text)
    {
        return super.setDistanceToFireHydrant(text);
    }

    public String getTerritoryCode()
    {
        return super.getTerritoryCode();
    }
    public NCHOWDwelling setLocationName(String text)
    {
        return super.setLocationName(text);
    }

    public String getLocationName()
    {
        return super.getLocationName();
    }
    public NCHOWDwelling setLocalTaxJurisdiction(String text)
    {
        return super.setLocalTaxJurisdiction(text);
    }

    public String getLocalTaxJurisdiction()
    {
        return super.getLocalTaxJurisdiction();
    }

    public NCHOWDwelling setDistanceToCoast(String text)
    {
        return super.setDistanceToCoast(text);
    }

    public String getDistanceToCoast()
    {
        return super.getDistanceToCoast();
    }

    public NCHOWDwelling setAnimalsOrExoticPets(String flag)
    {
        return super.setAnimalsOrExoticPets(flag);
    }
    public NCHOWDwelling setGolfCarts(String flag)
    {
        return super.setGolfCarts(flag);
    }
    public NCHOWDwelling setRecreationalVehiclesOwned(String flag)
    {
        return super.setRecreationalVehiclesOwned(flag);
    }
    public NCHOWDwelling setPoolFenced(String flag)
    {
        return super.setPoolFenced(flag);
    }
    public NCHOWDwelling setDivingBoard(String flag)
    {
        return super.setDivingBoard(flag);
    }
    public NCHOWDwelling setPoolSlide(String flag)
    {
        return super.setPoolSlide(flag);
    }
    public NCHOWDwelling setPoolLocation(String text)
    {
        return super.setPoolLocation(text);
    }
    public NCHOWDwelling addexocticAnimal(){return super.addExoticAnimal();}
    public NCHOWDwelling removeexoticAnimal(){return super.removeExoticAnimal();}
    public NCHOWDwelling checkexoticAnimalRow(int rowNumber){return super.checkExoticAnimalRow(rowNumber);}
    public NCHOWDwelling setexoticAnimalType(int rowNumber, String type ){return super.setExoticAnimalType(rowNumber, type);}
    public NCHOWDwelling setexoticAnimalBreed(int rowNumber, String breed ){return super.setExoticAnimalBreed(rowNumber, breed);}
    public NCHOWDwelling setexoticAnimalDescription(int rowNumber, String description ){return super.setExoticAnimalDescription(rowNumber, description);}
    public NCHOWDwelling setexoticAnimalBiteHistory(int rowNumber, String flag ){return super.setExoticAnimalBiteHistory(rowNumber, flag);}






    public NCHOWProtectionDetails clickProtectionDetails()
    {
        super.clickProtectionDetailsTab();
        return new NCHOWProtectionDetails(sh, path);
    }
    public NCHOWAdditionalInterests clickAdditionalInterests()
    {
        super.clickAdditionalInterestsTab();
        return new NCHOWAdditionalInterests(sh, path);
    }

    public NCHOWLocationInformation addNewLocation()
    {
        super.addNewDwellingLocation();
        return new NCHOWLocationInformation(sh, path);
    }
    public NCHOWLocationInformation editLocation()
    {
        super.editDwellingLocation();
        return new NCHOWLocationInformation(sh, path);
    }

    public class NCHOWProtectionDetails extends ProtectionDetails<NCHOWProtectionDetails>
    {
        public NCHOWProtectionDetails(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public NCHOWAdditionalInterests clickAdditionalInterests()
        {
            super.clickAdditionalInterestsTab();
            return new NCHOWAdditionalInterests(sh, path);

        }
        public NCHOWDwelling clickDetails()
        {
            super.clickDetailsTab();
            return new NCHOWDwelling(sh, path);
        }
        public NCHOWDwellingConstruction next()
        {
            dwellingConstructionNext();
            return new NCHOWDwellingConstruction(sh, path);
        }

        public NCHOWProtectionDetails setLockedPrivacyFence(String flag)
        {
            return super.setLockedPrivacyFence(flag);
        }

        public NCHOWProtectionDetails setCommunityGuarded(String flag)
        {
            return super.setCommunityGuarded(flag);
        }


      	public NCHOWProtectionDetails setGatedCommunity(String flag)
		{
			return super.setGatedCommunity(flag);
		}




        public NCHOWProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}

        public NCHOWProtectionDetails setFireAlarmType(String text)
        {
            return super.setFireAlarmType(text);
        }

        public String getFireAlarmType()
        {
            return super.getFireAlarmType();
        }



    }

    public class NCHOWAdditionalInterests extends AdditionalInterests<NCHOWAdditionalInterests>
    {
        public NCHOWAdditionalInterests(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }


        public NCHOWProtectionDetails clickProtectionDetails()
        {
            super.clickProtectionDetailsTab();
            return new NCHOWProtectionDetails(sh, path);
        }

        public NCHOWDwelling clickDetails()
        {
            super.clickDetailsTab();
            return new NCHOWDwelling(sh, path);
        }
        public NCHOWAdditionalInterests clickRemove()
        {
            super.clickRemove();
            return this;
        }
        public NCHOWNewAdditionalInterest clickAddNewPerson()
        {
            addNewPerson();
            return new NCHOWNewAdditionalInterest(sh,path);
        }
        public NCHOWNewAdditionalInterest clickAddNewCompany()
        {
            addNewCompany();
            return new NCHOWNewAdditionalInterest(sh,path);
        }
        public NCHOWSearchAddressBook clickFromAddressBook()
        {
            fromAddressBook();
            return new NCHOWSearchAddressBook(sh,path);
        }
        public NCHOWAdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
        {
            return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
        }
        public NCHOWAdditionalInterests selectRowInAdditionalInterestByName(String name)
        {
            return super.selectRowInAdditionalInterestByName(name);
        }
        public NCHOWAdditionalInterests setType(int row, String type)
        {
            return super.setType(row,type);
        }
        public NCHOWAdditionalInterests setEffectiveDate(int row, String effectiveDate)
        {
            return super.setEffectiveDate(row,effectiveDate);
        }
        public NCHOWAdditionalInterests setLoanNumber(int row, String loanNumber)
        {
            return super.setLoanNumber(row,loanNumber);
        }
        public NCHOWDwellingConstruction next()
        {
            super.dwellingConstructionNext();
            return new NCHOWDwellingConstruction(sh, path);
        }
    }
}
