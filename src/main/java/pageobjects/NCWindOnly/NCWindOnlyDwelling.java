package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyDwelling  extends Dwelling<NCWindOnlyDwelling> {
    public NCWindOnlyDwelling(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyDwellingConstruction next()
    {
        super.DwellingConstructionNext();
        return new NCWindOnlyDwellingConstruction(sh, path);
    }

    public String getdwellingErrorMessage()
    {
        return super.dwellingErrorMessage();
    }

    public NCWindOnlyDwelling setYearBuilt(String text)
    {
        return super.setYearBuilt(text);
    }
    public NCWindOnlyDwelling Enter(){
        return super.Enter();
    }
    public String getYearBuilt()
    {
        return super.getYearBuilt();
    }
    public NCWindOnlyDwelling setDistanceToFireHydrant(String text)
    {
        return super.setDistanceToFireHydrant(text);
    }

    public String getDistanceToFireHydrant()
    {
        return super.getDistanceToFireHydrant();
    }
    public NCWindOnlyDwelling setDistanceToFireStation(String text)
    {
        return super.setDistanceToFireStation(text);
    }

    public String getDistanceToFireStation()
    {
        return super.getDistanceToFireStation();
    }
    public NCWindOnlyDwelling setBCEG(String text)
    {
        return super.setBCEG(text);
    }

    public String getBCEG()
    {
        return super.getBCEG();
    }
    public NCWindOnlyDwelling setProtectionClassCode(String text)
    {
        return super.setProtectionClassCode(text);
    }

    public String getProtectionClassCode()
    {
        return super.getProtectionClassCode();
    }

    public NCWindOnlyDwelling waitForProtectionClassCode(String val)
    {
        super.waitForProtectionClassToUpdate(val);
        return new NCWindOnlyDwelling(sh, path);
    }

    public NCWindOnlyDwelling setTerritoryCode(String text)
    {
        return super.setTerritoryCode(text);
    }

    public String getTerritoryCode()
    {
        return super.getTerritoryCode();
    }
    public NCWindOnlyDwelling setLocationName(String text)
    {
        return super.setLocationName(text);
    }

    public String getLocationName()
    {
        return super.getLocationName();
    }
    public NCWindOnlyDwelling setLocalTaxJurisdiction(String text)
    {
        return super.setLocalTaxJurisdiction(text);
    }

    public String getLocalTaxJurisdiction()
    {
        return super.getLocalTaxJurisdiction();
    }
    public NCWindOnlyDwelling setLocationType(String text)
    {
        return super.setLocationType(text);
    }

    public String getLocationType()
    {
        return super.getLocationType();
    }
    public NCWindOnlyDwelling setDistanceToCoast(String text)
    {
        return super.setDistanceToCoast(text);
    }

    public String getDistanceToCoast()
    {
        return super.getDistanceToCoast();
    }
    public NCWindOnlyDwelling setPurchaseDate(String text)
    {
        return super.setPurchaseDate(text);
    }

    public String getPurchaseDate()
    {
        return super.getPurchaseDate();
    }
    public NCWindOnlyDwelling setPurchasePrice(String text)
    {
        return super.setPurchasePrice(text);
    }

    public String getPurchasePrice()
    {
        return super.getPurchasePrice();
    }
    public NCWindOnlyDwelling setMarketValue(String text)
    {
        return super.setMarketValue(text);
    }

    public String getMarketValue()
    {
        return super.getMarketValue();
    }
    public NCWindOnlyDwelling setResidenceType(String text)
    {
        return super.setResidenceType(text);
    }

    public String getResidenceType()
    {
        return super.getResidenceType();
    }
    public NCWindOnlyDwelling setDwellingUsage(String text)
    {
        return super.setDwellingUsage(text);
    }

    public String getDwellingUsage()
    {
        return super.getDwellingUsage();
    }
    public NCWindOnlyDwelling setDwellingOccupancy(String text)
    {
        return super.setDwellingOccupancy(text);
    }

    public String getDwellingOccupancy()
    {
        return super.getDwellingOccupancy();
    }
    public NCWindOnlyDwelling setHousekeepingCondition(String text)
    {
        return super.setHousekeepingCondition(text);
    }

    public String getHousekeepingCondition()
    {
        return super.getHousekeepingCondition();
    }
    public NCWindOnlyDwelling setInTheWindpool(String flag)
    {
        return super.setInTheWindpool(flag);
    }
    public NCWindOnlyDwelling setOwnedByOther(String flag)
    {
        return super.setOwnedByOther(flag);
    }
    public NCWindOnlyDwelling setOccupiedDaily(String flag)
    {
        return super.setOccupiedDaily(flag);
    }
    public NCWindOnlyDwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
    {
        return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
    }
    public NCWindOnlyProtectionDetails clickProtectionDetails()
    {
        super.clickProtectionDetailsTab();
        return new NCWindOnlyProtectionDetails(sh, path);
    }
    public NCWindOnlyAdditionalInterests clickAdditionalInterests()
    {
        super.clickAdditionalInterestsTab();
        return new NCWindOnlyAdditionalInterests(sh, path);
    }
    public NCWindOnlyDwelling setSwimmingPool(String flag)
    {
        return super.setSwimmingPool(flag);
    }
    public NCWindOnlyDwelling setTrampolineOnPremises(String flag)
    {
        return super.setTrampolineOnPremises(flag);
    }
    public NCWindOnlyDwelling setSkateboardBicycleRampOnPremises(String flag)
    {
        return super.setSkateboardBicycleRampOnPremises(flag);
    }
    public NCWindOnlyDwelling setAnimalsOrExoticPets(String flag)
    {
        return super.setAnimalsOrExoticPets(flag);
    }
    public NCWindOnlyDwelling setGolfCarts(String flag)
    {
        return super.setGolfCarts(flag);
    }
    public NCWindOnlyDwelling setRecreationalVehiclesOwned(String flag)
    {
        return super.setRecreationalVehiclesOwned(flag);
    }
    public NCWindOnlyDwelling setPoolFenced(String flag)
    {
        return super.setPoolFenced(flag);
    }
    public NCWindOnlyDwelling setDivingBoard(String flag)
    {
        return super.setDivingBoard(flag);
    }
    public NCWindOnlyDwelling setPoolSlide(String flag)
    {
        return super.setPoolSlide(flag);
    }
    public NCWindOnlyDwelling setPoolLocation(String text)
    {
        return super.setPoolLocation(text);
    }

    public String getPoolLocation()
    {
        return super.getPoolLocation();
    }
    public NCWindOnlyDwelling setFenceType(String text)
    {
        return super.setFenceType(text);
    }

    public String getFenceType()
    {
        return super.getFenceType();
    }
    public NCWindOnlyDwelling setWindpoolZone(String text)
    {
        return super.setWindpoolZone(text);
    }

    public String getWindpoolZone()
    {
        return super.getWindpoolZone();
    }
    public NCWindOnlyLocationInformation addNewLocation()
    {
        super.addNewDwellingLocation();
        return new NCWindOnlyLocationInformation(sh, path);
    }
    public NCWindOnlyLocationInformation editLocation()
    {
        super.editDwellingLocation();
        return new NCWindOnlyLocationInformation(sh, path);
    }

    public class NCWindOnlyProtectionDetails extends ProtectionDetails<NCWindOnlyProtectionDetails>
    {
        public NCWindOnlyProtectionDetails(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public NCWindOnlyAdditionalInterests clickAdditionalInterests()
        {
            super.clickAdditionalInterestsTab();
            return new NCWindOnlyAdditionalInterests(sh, path);

        }
        public NCWindOnlyDwelling clickDetails()
        {
            super.clickDetailsTab();
            return new NCWindOnlyDwelling(sh, path);
        }
        public NCWindOnlyDwellingConstruction next()
        {
            dwellingConstructionNext();
            return new NCWindOnlyDwellingConstruction(sh, path);
        }
        public NCWindOnlyProtectionDetails setBurglarAlarm(String flag)
        {
            return super.setBurglarAlarm(flag);
        }
        public NCWindOnlyProtectionDetails setLockedPrivacyFence(String flag)
        {
            return super.setLockedPrivacyFence(flag);
        }
        public NCWindOnlyProtectionDetails setBurglarBarsOnWindows(String flag)
        {
            return super.setBurglarBarsOnWindows(flag);
        }
        public NCWindOnlyProtectionDetails setCommunityGuarded(String flag)
        {
            return super.setCommunityGuarded(flag);
        }
        public NCWindOnlyProtectionDetails setGatedCommunity(String flag)
        {
            return super.setGatedCommunity(flag);
        }
        public NCWindOnlyProtectionDetails setFireAlarm(String flag)
        {
            return super.setFireAlarm(flag);
        }
        public NCWindOnlyProtectionDetails setSmokeAlarm(String flag)
        {
            return super.setSmokeAlarm(flag);
        }
        public NCWindOnlyProtectionDetails setFireExtinguishers(String flag)
        {
            return super.setFireExtinguishers(flag);
        }
        public NCWindOnlyProtectionDetails setSprinklerSystem(String flag)
        {
            return super.setSprinklerSystem(flag);
        }
        public NCWindOnlyProtectionDetails setDeadbolts(String flag)
        {
            return super.setDeadbolts(flag);
        }
        public NCWindOnlyProtectionDetails setResidenceVisibleToNeighbors(String flag)
        {
            return super.setResidenceVisibleToNeighbors(flag);
        }
        public NCWindOnlyProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}
        public NCWindOnlyProtectionDetails safetyLatchesPresent(String flag)
        {
            return super.safetyLatchesPresent(flag);
        }
        public NCWindOnlyProtectionDetails setBurglarAlarmType(String text)
        {
            return super.setBurglarAlarmType(text);
        }

        public String getBurglarAlarmType()
        {
            return super.getBurglarAlarmType();
        }
        public NCWindOnlyProtectionDetails setFireAlarmType(String text)
        {
            return super.setFireAlarmType(text);
        }

        public String getFireAlarmType()
        {
            return super.getFireAlarmType();
        }

        public NCWindOnlyProtectionDetails setSprinklerSystemType(String text)
        {
            return super.setSprinklerSystemType(text);
        }

        public String getSprinklerSystemType()
        {
            return super.getSprinklerSystemType();
        }

    }

    public class NCWindOnlyAdditionalInterests extends AdditionalInterests<NCWindOnlyAdditionalInterests>
    {
        public NCWindOnlyAdditionalInterests(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }


        public NCWindOnlyProtectionDetails clickProtectionDetails()
        {
            super.clickProtectionDetailsTab();
            return new NCWindOnlyProtectionDetails(sh, path);
        }

        public NCWindOnlyDwelling clickDetails()
        {
            super.clickDetailsTab();
            return new NCWindOnlyDwelling(sh, path);
        }
        public NCWindOnlyAdditionalInterests clickRemove()
        {
            super.clickRemove();
            return this;
        }
        public NCWindOnlyNewAdditionalInterest clickAddNewPerson()
        {
            addNewPerson();
            return new NCWindOnlyNewAdditionalInterest(sh,path);
        }
        public NCWindOnlyNewAdditionalInterest clickAddNewCompany()
        {
            addNewCompany();
            return new NCWindOnlyNewAdditionalInterest(sh,path);
        }
        public NCWindOnlySearchAddressBook clickFromAddressBook()
        {
            fromAddressBook();
            return new NCWindOnlySearchAddressBook(sh,path);
        }
        public NCWindOnlyAdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
        {
            return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
        }
        public NCWindOnlyAdditionalInterests selectRowInAdditionalInterestByName(String name)
        {
            return super.selectRowInAdditionalInterestByName(name);
        }
        public NCWindOnlyAdditionalInterests setType(int row, String type)
        {
            return super.setType(row,type);
        }
        public NCWindOnlyAdditionalInterests setEffectiveDate(int row, String effectiveDate)
        {
            return super.setEffectiveDate(row,effectiveDate);
        }
        public NCWindOnlyAdditionalInterests setLoanNumber(int row, String loanNumber)
        {
            return super.setLoanNumber(row,loanNumber);
        }
        public NCWindOnlyDwellingConstruction next()
        {
            super.dwellingConstructionNext();
            return new NCWindOnlyDwellingConstruction(sh, path);
        }
    }
}
