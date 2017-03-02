package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4Dwelling extends Dwelling<SCHO4Dwelling> {

    public SCHO4Dwelling(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4DwellingConstruction next()
    {
        super.DwellingConstructionNext();
        return new SCHO4DwellingConstruction(sh, path);
    }
    public SCHO4Dwelling setYearBuilt(String text)
    {
        return super.setYearBuilt(text);
    }
    public SCHO4Dwelling Enter(){
        return super.Enter();
    }
    public String getdwellingErrorMessage()
    {
        return super.dwellingErrorMessage();
    }

    public String getYearBuilt()
    {
        return super.getYearBuilt();
    }
    public SCHO4Dwelling setDistanceToFireHydrant(String text)
    {
        return super.setDistanceToFireHydrant(text);
    }

    public String getDistanceToFireHydrant()
    {
        return super.getDistanceToFireHydrant();
    }
    public SCHO4Dwelling setDistanceToFireStation(String text)
    {
        return super.setDistanceToFireStation(text);
    }

    public String getDistanceToFireStation()
    {
        return super.getDistanceToFireStation();
    }
    public SCHO4Dwelling setBCEG(String text)
    {
        return super.setBCEG(text);
    }

    public String getBCEG()
    {
        return super.getBCEG();
    }
    public SCHO4Dwelling setProtectionClassCode(String text)
    {
        return super.setProtectionClassCode(text);
    }

    public String getProtectionClassCode()
    {
        return super.getProtectionClassCode();
    }
    public SCHO4Dwelling setTerritoryCode(String text)
    {
        return super.setTerritoryCode(text);
    }

    public String getTerritoryCode()
    {
        return super.getTerritoryCode();
    }
    public SCHO4Dwelling setLocationName(String text)
    {
        return super.setLocationName(text);
    }

    public String getLocationName()
    {
        return super.getLocationName();
    }
    public SCHO4Dwelling setLocalTaxJurisdiction(String text)
    {
        return super.setLocalTaxJurisdiction(text);
    }

    public String getLocalTaxJurisdiction()
    {
        return super.getLocalTaxJurisdiction();
    }
    public SCHO4Dwelling setLocationType(String text)
    {
        return super.setLocationType(text);
    }

    public String getLocationType()
    {
        return super.getLocationType();
    }
    public SCHO4Dwelling setDistanceToCoast(String text)
    {
        return super.setDistanceToCoast(text);
    }

    public String getDistanceToCoast()
    {
        return super.getDistanceToCoast();
    }
    public SCHO4Dwelling setPurchaseDate(String text)
    {
        return super.setPurchaseDate(text);
    }

    public String getPurchaseDate()
    {
        return super.getPurchaseDate();
    }
    public SCHO4Dwelling setPurchasePrice(String text)
    {
        return super.setPurchasePrice(text);
    }

    public String getPurchasePrice()
    {
        return super.getPurchasePrice();
    }
    public SCHO4Dwelling setMarketValue(String text)
    {
        return super.setMarketValue(text);
    }

    public String getMarketValue()
    {
        return super.getMarketValue();
    }
    public SCHO4Dwelling setResidenceType(String text)
    {
        return super.setResidenceType(text);
    }

    public String getResidenceType()
    {
        return super.getResidenceType();
    }
    public SCHO4Dwelling setDwellingUsage(String text)
    {
        return super.setDwellingUsage(text);
    }

    public String getDwellingUsage()
    {
        return super.getDwellingUsage();
    }
    public SCHO4Dwelling setDwellingOccupancy(String text)
    {
        return super.setDwellingOccupancy(text);
    }

    public String getDwellingOccupancy()
    {
        return super.getDwellingOccupancy();
    }
    public SCHO4Dwelling setHousekeepingCondition(String text)
    {
        return super.setHousekeepingCondition(text);
    }

    public String getHousekeepingCondition()
    {
        return super.getHousekeepingCondition();
    }
    public SCHO4Dwelling setInTheWindpool(String flag)
    {
        return super.setInTheWindpool(flag);
    }
    public SCHO4Dwelling setOwnedByOther(String flag)
    {
        return super.setOwnedByOther(flag);
    }
    public SCHO4Dwelling setOccupiedDaily(String flag)
    {
        return super.setOccupiedDaily(flag);
    }
    public SCHO4Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
    {
        return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
    }
    public SCHO4ProtectionDetails clickProtectionDetails()
    {
        super.clickProtectionDetailsTab();
        return new SCHO4ProtectionDetails(sh, path);
    }
    public SCHO4AdditionalInterests clickAdditionalInterests()
    {
        super.clickAdditionalInterestsTab();
        return new SCHO4AdditionalInterests(sh, path);
    }
    public SCHO4Dwelling setSwimmingPool(String flag)
    {
        return super.setSwimmingPool(flag);
    }
    public SCHO4Dwelling setTrampolineOnPremises(String flag)
    {
        return super.setTrampolineOnPremises(flag);
    }
    public SCHO4Dwelling setSkateboardBicycleRampOnPremises(String flag)
    {
        return super.setSkateboardBicycleRampOnPremises(flag);
    }
    public SCHO4Dwelling setAnimalsOrExoticPets(String flag)
    {
        return super.setAnimalsOrExoticPets(flag);
    }
    public SCHO4Dwelling setGolfCarts(String flag)
    {
        return super.setGolfCarts(flag);
    }
    public SCHO4Dwelling setRecreationalVehiclesOwned(String flag)
    {
        return super.setRecreationalVehiclesOwned(flag);
    }
    public SCHO4Dwelling setPoolFenced(String flag)
    {
        return super.setPoolFenced(flag);
    }
    public SCHO4Dwelling setDivingBoard(String flag)
    {
        return super.setDivingBoard(flag);
    }
    public SCHO4Dwelling setPoolSlide(String flag)
    {
        return super.setPoolSlide(flag);
    }
    public SCHO4Dwelling setPoolLocation(String text)
    {
        return super.setPoolLocation(text);
    }

    public String getPoolLocation()
    {
        return super.getPoolLocation();
    }
    public SCHO4Dwelling setFenceType(String text)
    {
        return super.setFenceType(text);
    }

    public String getFenceType()
    {
        return super.getFenceType();
    }
    public SCHO4Dwelling setWindpoolZone(String text)
    {
        return super.setWindpoolZone(text);
    }

    public String getWindpoolZone()
    {
        return super.getWindpoolZone();
    }
    public SCHO4LocationInformation addNewLocation()
    {
        super.addNewDwellingLocation();
        return new SCHO4LocationInformation(sh, path);
    }
    public SCHO4LocationInformation editLocation()
    {
        super.editDwellingLocation();
        return new SCHO4LocationInformation(sh, path);
    }

    public class SCHO4ProtectionDetails extends ProtectionDetails<SCHO4ProtectionDetails>
    {
        public SCHO4ProtectionDetails(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public SCHO4AdditionalInterests clickAdditionalInterests()
        {
            super.clickAdditionalInterestsTab();
            return new SCHO4AdditionalInterests(sh, path);

        }
        public SCHO4Dwelling clickDetails()
        {
            super.clickDetailsTab();
            return new SCHO4Dwelling(sh, path);
        }
        public SCHO4DwellingConstruction next()
        {
            dwellingConstructionNext();
            return new SCHO4DwellingConstruction(sh, path);
        }
        public SCHO4ProtectionDetails setBurglarAlarm(String flag)
        {
            return super.setBurglarAlarm(flag);
        }
        public SCHO4ProtectionDetails setLockedPrivacyFence(String flag)
        {
            return super.setLockedPrivacyFence(flag);
        }
        public SCHO4ProtectionDetails setBurglarBarsOnWindows(String flag)
        {
            return super.setBurglarBarsOnWindows(flag);
        }
        public SCHO4ProtectionDetails setCommunityGuarded(String flag)
        {
            return super.setCommunityGuarded(flag);
        }
        public SCHO4ProtectionDetails setGatedCommunity(String flag)
        {
            return super.setGatedCommunity(flag);
        }
        public SCHO4ProtectionDetails setFireAlarm(String flag)
        {
            return super.setFireAlarm(flag);
        }
        public SCHO4ProtectionDetails setSmokeAlarm(String flag)
        {
            return super.setSmokeAlarm(flag);
        }
        public SCHO4ProtectionDetails setFireExtinguishers(String flag)
        {
            return super.setFireExtinguishers(flag);
        }
        public SCHO4ProtectionDetails setSprinklerSystem(String flag)
        {
            return super.setSprinklerSystem(flag);
        }
        public SCHO4ProtectionDetails setDeadbolts(String flag)
        {
            return super.setDeadbolts(flag);
        }
        public SCHO4ProtectionDetails setResidenceVisibleToNeighbors(String flag)
        {
            return super.setResidenceVisibleToNeighbors(flag);
        }
        public SCHO4ProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}

        public SCHO4ProtectionDetails safetyLatchesPresent(String flag)
        {
            return super.safetyLatchesPresent(flag);
        }
        public SCHO4ProtectionDetails setBurglarAlarmType(String text)
        {
            return super.setBurglarAlarmType(text);
        }

        public String getBurglarAlarmType()
        {
            return super.getBurglarAlarmType();
        }
        public SCHO4ProtectionDetails setFireAlarmType(String text)
        {
            return super.setFireAlarmType(text);
        }

        public String getFireAlarmType()
        {
            return super.getFireAlarmType();
        }

        public SCHO4ProtectionDetails setSprinklerSystemType(String text)
        {
            return super.setSprinklerSystemType(text);
        }

        public String getSprinklerSystemType()
        {
            return super.getSprinklerSystemType();
        }

    }

    public class SCHO4AdditionalInterests extends AdditionalInterests<SCHO4AdditionalInterests>
    {
        public SCHO4AdditionalInterests(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }


        public SCHO4ProtectionDetails clickProtectionDetails()
        {
            super.clickProtectionDetailsTab();
            return new SCHO4ProtectionDetails(sh, path);
        }

        public SCHO4Dwelling clickDetails()
        {
            super.clickDetailsTab();
            return new SCHO4Dwelling(sh, path);
        }
        public SCHO4AdditionalInterests clickRemove()
        {
            super.clickRemove();
            return this;
        }
        public SCHO4NewAdditionalInterest clickAddNewPerson()
        {
            addNewPerson();
            return new SCHO4NewAdditionalInterest(sh,path);
        }
        public SCHO4NewAdditionalInterest clickAddNewCompany()
        {
            addNewCompany();
            return new SCHO4NewAdditionalInterest(sh,path);
        }
        public SCHO4SearchAddressBook clickFromAddressBook()
        {
            fromAddressBook();
            return new SCHO4SearchAddressBook(sh,path);
        }
        public SCHO4AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
        {
            return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
        }
        public SCHO4AdditionalInterests selectRowInAdditionalInterestByName(String name)
        {
            return super.selectRowInAdditionalInterestByName(name);
        }
        public SCHO4AdditionalInterests setType(int row, String type)
        {
            return super.setType(row,type);
        }
        public SCHO4AdditionalInterests setEffectiveDate(int row, String effectiveDate)
        {
            return super.setEffectiveDate(row,effectiveDate);
        }
        public SCHO4AdditionalInterests setLoanNumber(int row, String loanNumber)
        {
            return super.setLoanNumber(row,loanNumber);
        }
        public SCHO4DwellingConstruction next()
        {
            super.dwellingConstructionNext();
            return new SCHO4DwellingConstruction(sh, path);
        }






    }
}
