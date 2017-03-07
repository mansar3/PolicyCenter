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
    public NCHOWDwelling setDistanceToFireHydrant(String text)
    {
        return super.setDistanceToFireHydrant(text);
    }

    public String getDistanceToFireHydrant()
    {
        return super.getDistanceToFireHydrant();
    }
    public NCHOWDwelling setDistanceToFireStation(String text)
    {
        return super.setDistanceToFireStation(text);
    }

    public String getDistanceToFireStation()
    {
        return super.getDistanceToFireStation();
    }
    public NCHOWDwelling setBCEG(String text)
    {
        return super.setBCEG(text);
    }

    public String getBCEG()
    {
        return super.getBCEG();
    }
    public NCHOWDwelling setProtectionClassCode(String text)
    {
        return super.setProtectionClassCode(text);
    }

    public String getProtectionClassCode()
    {
        return super.getProtectionClassCode();
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
    public NCHOWDwelling setLocationType(String text)
    {
        return super.setLocationType(text);
    }

    public String getLocationType()
    {
        return super.getLocationType();
    }
    public NCHOWDwelling setDistanceToCoast(String text)
    {
        return super.setDistanceToCoast(text);
    }

    public String getDistanceToCoast()
    {
        return super.getDistanceToCoast();
    }
    public NCHOWDwelling setPurchaseDate(String text)
    {
        return super.setPurchaseDate(text);
    }

    public String getPurchaseDate()
    {
        return super.getPurchaseDate();
    }
    public NCHOWDwelling setPurchasePrice(String text)
    {
        return super.setPurchasePrice(text);
    }

    public String getPurchasePrice()
    {
        return super.getPurchasePrice();
    }
    public NCHOWDwelling setMarketValue(String text)
    {
        return super.setMarketValue(text);
    }

    public String getMarketValue()
    {
        return super.getMarketValue();
    }
    public NCHOWDwelling setResidenceType(String text)
    {
        return super.setResidenceType(text);
    }

    public String getResidenceType()
    {
        return super.getResidenceType();
    }
    public NCHOWDwelling setDwellingUsage(String text)
    {
        return super.setDwellingUsage(text);
    }

    public String getDwellingUsage()
    {
        return super.getDwellingUsage();
    }
    public NCHOWDwelling setDwellingOccupancy(String text)
    {
        return super.setDwellingOccupancy(text);
    }

    public String getDwellingOccupancy()
    {
        return super.getDwellingOccupancy();
    }
    public NCHOWDwelling setHousekeepingCondition(String text)
    {
        return super.setHousekeepingCondition(text);
    }

    public String getHousekeepingCondition()
    {
        return super.getHousekeepingCondition();
    }
    public NCHOWDwelling setInTheWindpool(String flag)
    {
        return super.setInTheWindpool(flag);
    }
    public NCHOWDwelling setOwnedByOther(String flag)
    {
        return super.setOwnedByOther(flag);
    }
    public NCHOWDwelling setOccupiedDaily(String flag)
    {
        return super.setOccupiedDaily(flag);
    }
    public NCHOWDwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
    {
        return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
    }
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
    public NCHOWDwelling setSwimmingPool(String flag)
    {
        return super.setSwimmingPool(flag);
    }
    public NCHOWDwelling setTrampolineOnPremises(String flag)
    {
        return super.setTrampolineOnPremises(flag);
    }
    public NCHOWDwelling setSkateboardBicycleRampOnPremises(String flag)
    {
        return super.setSkateboardBicycleRampOnPremises(flag);
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

    public String getPoolLocation()
    {
        return super.getPoolLocation();
    }
    public NCHOWDwelling setFenceType(String text)
    {
        return super.setFenceType(text);
    }

    public String getFenceType()
    {
        return super.getFenceType();
    }
    public NCHOWDwelling setWindpoolZone(String text)
    {
        return super.setWindpoolZone(text);
    }

    public String getWindpoolZone()
    {
        return super.getWindpoolZone();
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
        public NCHOWProtectionDetails setBurglarAlarm(String flag)
        {
            return super.setBurglarAlarm(flag);
        }
        public NCHOWProtectionDetails setLockedPrivacyFence(String flag)
        {
            return super.setLockedPrivacyFence(flag);
        }
        public NCHOWProtectionDetails setBurglarBarsOnWindows(String flag)
        {
            return super.setBurglarBarsOnWindows(flag);
        }
        public NCHOWProtectionDetails setCommunityGuarded(String flag)
        {
            return super.setCommunityGuarded(flag);
        }
        public NCHOWProtectionDetails setGatedCommunity(String flag)
        {
            return super.setGatedCommunity(flag);
        }
        public NCHOWProtectionDetails setFireAlarm(String flag)
        {
            return super.setFireAlarm(flag);
        }
        public NCHOWProtectionDetails setSmokeAlarm(String flag)
        {
            return super.setSmokeAlarm(flag);
        }
        public NCHOWProtectionDetails setFireExtinguishers(String flag)
        {
            return super.setFireExtinguishers(flag);
        }
        public NCHOWProtectionDetails setSprinklerSystem(String flag)
        {
            return super.setSprinklerSystem(flag);
        }
        public NCHOWProtectionDetails setDeadbolts(String flag)
        {
            return super.setDeadbolts(flag);
        }
        public NCHOWProtectionDetails setResidenceVisibleToNeighbors(String flag)
        {
            return super.setResidenceVisibleToNeighbors(flag);
        }
        public NCHOWProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}
        public NCHOWProtectionDetails safetyLatchesPresent(String flag)
        {
            return super.safetyLatchesPresent(flag);
        }
        public NCHOWProtectionDetails setBurglarAlarmType(String text)
        {
            return super.setBurglarAlarmType(text);
        }

        public String getBurglarAlarmType()
        {
            return super.getBurglarAlarmType();
        }
        public NCHOWProtectionDetails setFireAlarmType(String text)
        {
            return super.setFireAlarmType(text);
        }

        public String getFireAlarmType()
        {
            return super.getFireAlarmType();
        }

        public NCHOWProtectionDetails setSprinklerSystemType(String text)
        {
            return super.setSprinklerSystemType(text);
        }

        public String getSprinklerSystemType()
        {
            return super.getSprinklerSystemType();
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
