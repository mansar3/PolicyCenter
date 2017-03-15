package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.FLMH3.FLMH3Dwelling;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3Dwelling extends Dwelling<FLMH3Dwelling> {

    public FLMH3Dwelling(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3DwellingConstruction next()
    {
        super.DwellingConstructionNext();
        return new FLMH3DwellingConstruction(sh, path);
    }
    public FLMH3Dwelling setYearBuilt(String text)
    {
        return super.setYearBuilt(text);
    }
    public FLMH3Dwelling Enter(){
        return super.Enter();
    }

    public String getdwellingErrorMessage()
    {
        return super.dwellingErrorMessage();
    }
    public FLMH3Quote clickDwellingquote()
    {
        super.DwellingQuote();
        return new FLMH3Quote(sh, path);
    }

    public FLMH3PreQuoteIssues clickDwellingquoteissue()
    {
        super.DwellingQuote();
        return new FLMH3PreQuoteIssues(sh, path);
    }


    public String getYearBuilt()
    {
        return super.getYearBuilt();
    }
    public FLMH3Dwelling setDistanceToFireHydrant(String text)
    {
        return super.setDistanceToFireHydrant(text);
    }

    public String getDistanceToFireHydrant()
    {
        return super.getDistanceToFireHydrant();
    }
    public FLMH3Dwelling setDistanceToFireStation(String text)
    {
        return super.setDistanceToFireStation(text);
    }

    public String getDistanceToFireStation()
    {
        return super.getDistanceToFireStation();
    }
    public FLMH3Dwelling setBCEG(String text)
    {
        return super.setBCEG(text);
    }

    public String getBCEG()
    {
        return super.getBCEG();
    }
    public FLMH3Dwelling setProtectionClassCode(String text)
    {
        return super.setProtectionClassCode(text);
    }

    public String getProtectionClassCode()
    {
        return super.getProtectionClassCode();
    }

    public FLMH3Dwelling waitForProtectionClassCode(String val)
    {
        super.waitForProtectionClassToUpdate(val);
        return new FLMH3Dwelling(sh, path);
    }

    public FLMH3Dwelling setTerritoryCode(String text)
    {
        return super.setTerritoryCode(text);
    }

    public String getTerritoryCode()
    {
        return super.getTerritoryCode();
    }
    public FLMH3Dwelling setLocationName(String text)
    {
        return super.setLocationName(text);
    }

    public String getLocationName()
    {
        return super.getLocationName();
    }
    public FLMH3Dwelling setLocalTaxJurisdiction(String text)
    {
        return super.setLocalTaxJurisdiction(text);
    }

    public String getLocalTaxJurisdiction()
    {
        return super.getLocalTaxJurisdiction();
    }
    public FLMH3Dwelling setLocationType(String text)
    {
        return super.setLocationType(text);
    }

    public String getLocationType()
    {
        return super.getLocationType();
    }
    public FLMH3Dwelling setDistanceToCoast(String text)
    {
        return super.setDistanceToCoast(text);
    }

    public String getDistanceToCoast()
    {
        return super.getDistanceToCoast();
    }
    public FLMH3Dwelling setPurchaseDate(String text)
    {
        return super.setPurchaseDate(text);
    }

    public String getPurchaseDate()
    {
        return super.getPurchaseDate();
    }
    public FLMH3Dwelling setPurchasePrice(String text)
    {
        return super.setPurchasePrice(text);
    }

    public String getPurchasePrice()
    {
        return super.getPurchasePrice();
    }
    public FLMH3Dwelling setMarketValue(String text)
    {
        return super.setMarketValue(text);
    }

    public String getMarketValue()
    {
        return super.getMarketValue();
    }
    public FLMH3Dwelling setResidenceType(String text)
    {
        return super.setResidenceType(text);
    }

    public String getResidenceType()
    {
        return super.getResidenceType();
    }
    public FLMH3Dwelling setDwellingUsage(String text)
    {
        return super.setDwellingUsage(text);
    }

    public String getDwellingUsage()
    {
        return super.getDwellingUsage();
    }
    public FLMH3Dwelling setDwellingOccupancy(String text)
    {
        return super.setDwellingOccupancy(text);
    }

    public String getDwellingOccupancy()
    {
        return super.getDwellingOccupancy();
    }
    public FLMH3Dwelling setHousekeepingCondition(String text)
    {
        return super.setHousekeepingCondition(text);
    }

    public FLMH3Dwelling setMobileHomePark(String text) {return super.setMobileHomePark(text);}

    public String getMobileHomePark() {return super.getMobileHomePark();}
    public String getHousekeepingCondition()
    {
        return super.getHousekeepingCondition();
    }
    public FLMH3Dwelling setInTheWindpool(String flag)
    {
        return super.setInTheWindpool(flag);
    }
    public FLMH3Dwelling setOwnedByOther(String flag)
    {
        return super.setOwnedByOther(flag);
    }
    public FLMH3Dwelling setOccupiedDaily(String flag)
    {
        return super.setOccupiedDaily(flag);
    }
    public FLMH3Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
    {
        return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
    }
    public FLMH3ProtectionDetails clickProtectionDetails()
    {
        super.clickProtectionDetailsTab();
        return new FLMH3ProtectionDetails(sh, path);
    }
    public FLMH3AdditionalInterests clickAdditionalInterests()
    {
        super.clickAdditionalInterestsTab();
        return new FLMH3AdditionalInterests(sh, path);
    }

    public FLMH3Dwelling setSwimmingPool(String flag)
    {
        return super.setSwimmingPool(flag);
    }
    public FLMH3Dwelling setTrampolineOnPremises(String flag)
    {
        return super.setTrampolineOnPremises(flag);
    }
    public FLMH3Dwelling setSkateboardBicycleRampOnPremises(String flag)
    {
        return super.setSkateboardBicycleRampOnPremises(flag);
    }
    public FLMH3Dwelling setAnimalsOrExoticPets(String flag)
    {
        return super.setAnimalsOrExoticPets(flag);
    }
    public FLMH3Dwelling addexocticAnimal(){return super.addExoticAnimal();}
    public FLMH3Dwelling removeexoticAnimal(){return super.removeExoticAnimal();}
    public FLMH3Dwelling checkexoticAnimalRow(int rowNumber){return super.checkExoticAnimalRow(rowNumber);}
    public FLMH3Dwelling setexoticAnimalType(int rowNumber, String type ){return super.setExoticAnimalType(rowNumber, type);}
    public FLMH3Dwelling setexoticAnimalBreed(int rowNumber, String breed ){return super.setExoticAnimalBreed(rowNumber, breed);}
    public FLMH3Dwelling setexoticAnimalDescription(int rowNumber, String description ){return super.setExoticAnimalDescription(rowNumber, description);}
    public FLMH3Dwelling setexoticAnimalBiteHistory(int rowNumber, String flag ){return super.setExoticAnimalBiteHistory(rowNumber, flag);}
    public FLMH3Dwelling setGolfCarts(String flag)
    {
        return super.setGolfCarts(flag);
    }
    public FLMH3Dwelling setRecreationalVehiclesOwned(String flag)
    {
        return super.setRecreationalVehiclesOwned(flag);
    }
    public FLMH3Dwelling setPoolFenced(String flag)
    {
        return super.setPoolFenced(flag);
    }
    public FLMH3Dwelling setDivingBoard(String flag)
    {
        return super.setDivingBoard(flag);
    }
    public FLMH3Dwelling setPoolSlide(String flag)
    {
        return super.setPoolSlide(flag);
    }
    public FLMH3Dwelling setPoolLocation(String text)
    {
        return super.setPoolLocation(text);
    }

    public String getPoolLocation()
    {
        return super.getPoolLocation();
    }
    public FLMH3Dwelling setFenceType(String text)
    {
        return super.setFenceType(text);
    }

    public String getFenceType()
    {
        return super.getFenceType();
    }
    public FLMH3Dwelling setWindpoolZone(String text)
    {
        return super.setWindpoolZone(text);
    }

    public String getWindpoolZone()
    {
        return super.getWindpoolZone();
    }
    public FLMH3LocationInformation addNewLocation()
    {
        super.addNewDwellingLocation();
        return new FLMH3LocationInformation(sh, path);
    }
    public FLMH3LocationInformation editLocation()
    {
        super.editDwellingLocation();
        return new FLMH3LocationInformation(sh, path);
    }

    public class FLMH3ProtectionDetails extends ProtectionDetails<FLMH3ProtectionDetails>
    {
        public FLMH3ProtectionDetails(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public FLMH3AdditionalInterests clickAdditionalInterests()
        {
            super.clickAdditionalInterestsTab();
            return new FLMH3AdditionalInterests(sh, path);

        }
        public FLMH3Dwelling clickDetails()
        {
            super.clickDetailsTab();
            return new FLMH3Dwelling(sh, path);
        }
        public FLMH3DwellingConstruction next()
        {
            dwellingConstructionNext();
            return new FLMH3DwellingConstruction(sh, path);
        }
        public FLMH3ProtectionDetails setBurglarAlarm(String flag)
        {
            return super.setBurglarAlarm(flag);
        }
        public FLMH3ProtectionDetails setLockedPrivacyFence(String flag)
        {
            return super.setLockedPrivacyFence(flag);
        }
        public FLMH3ProtectionDetails setBurglarBarsOnWindows(String flag)
        {
            return super.setBurglarBarsOnWindows(flag);
        }
        public FLMH3ProtectionDetails setCommunityGuarded(String flag)
        {
            return super.setCommunityGuarded(flag);
        }
        public FLMH3ProtectionDetails setGatedCommunity(String flag)
        {
            return super.setGatedCommunity(flag);
        }
        public FLMH3ProtectionDetails setFireAlarm(String flag)
        {
            return super.setFireAlarm(flag);
        }
        public FLMH3ProtectionDetails setSmokeAlarm(String flag)
        {
            return super.setSmokeAlarm(flag);
        }
        public FLMH3ProtectionDetails setFireExtinguishers(String flag)
        {
            return super.setFireExtinguishers(flag);
        }
        public FLMH3ProtectionDetails setSprinklerSystem(String flag)
        {
            return super.setSprinklerSystem(flag);
        }
        public FLMH3ProtectionDetails setDeadbolts(String flag)
        {
            return super.setDeadbolts(flag);
        }
        public FLMH3ProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}

        public FLMH3ProtectionDetails setResidenceVisibleToNeighbors(String flag)
        {
            return super.setResidenceVisibleToNeighbors(flag);
        }
        public FLMH3ProtectionDetails safetyLatchesPresent(String flag)
        {
            return super.safetyLatchesPresent(flag);
        }
        public FLMH3ProtectionDetails setBurglarAlarmType(String text)
        {
            return super.setBurglarAlarmType(text);
        }

        public String getBurglarAlarmType()
        {
            return super.getBurglarAlarmType();
        }
        public FLMH3ProtectionDetails setFireAlarmType(String text)
        {
            return super.setFireAlarmType(text);
        }

        public String getFireAlarmType()
        {
            return super.getFireAlarmType();
        }

        public FLMH3ProtectionDetails setSprinklerSystemType(String text)
        {
            return super.setSprinklerSystemType(text);
        }

        public String getSprinklerSystemType()
        {
            return super.getSprinklerSystemType();
        }

    }

    public class FLMH3AdditionalInterests extends AdditionalInterests<FLMH3AdditionalInterests>
    {
        public FLMH3AdditionalInterests(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }


        public FLMH3ProtectionDetails clickProtectionDetails()
        {
            super.clickProtectionDetailsTab();
            return new FLMH3ProtectionDetails(sh, path);
        }

        public FLMH3Dwelling clickDetails()
        {
            super.clickDetailsTab();
            return new FLMH3Dwelling(sh, path);
        }
        public FLMH3AdditionalInterests clickRemove()
        {
            super.clickRemove();
            return this;
        }
        public FLMH3NewAdditionalInterest clickAddNewPerson()
        {
            addNewPerson();
            return new FLMH3NewAdditionalInterest(sh,path);
        }
        public FLMH3NewAdditionalInterest clickAddNewCompany()
        {
            addNewCompany();
            return new FLMH3NewAdditionalInterest(sh,path);
        }
        public FLMH3SearchAddressBook clickFromAddressBook()
        {
            fromAddressBook();
            return new FLMH3SearchAddressBook(sh,path);
        }
        public FLMH3AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
        {
            return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
        }
        public FLMH3AdditionalInterests selectRowInAdditionalInterestByName(String name)
        {
            return super.selectRowInAdditionalInterestByName(name);
        }
        public FLMH3AdditionalInterests setType(int row, String type)
        {
            return super.setType(row,type);
        }
        public FLMH3AdditionalInterests setEffectiveDate(int row, String effectiveDate)
        {
            return super.setEffectiveDate(row,effectiveDate);
        }
        public FLMH3AdditionalInterests setLoanNumber(int row, String loanNumber)
        {
            return super.setLoanNumber(row,loanNumber);
        }
        public FLMH3DwellingConstruction next()
        {
            super.dwellingConstructionNext();
            return new FLMH3DwellingConstruction(sh, path);
        }
    }
}
