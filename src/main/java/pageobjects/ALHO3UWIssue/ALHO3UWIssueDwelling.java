package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueDwelling extends Dwelling<ALHO3UWIssueDwelling> {

    public ALHO3UWIssueDwelling(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssueDwellingConstruction next()
    {
        super.DwellingConstructionNext();
        return new ALHO3UWIssueDwellingConstruction(sh, path);
    }
    public ALHO3UWIssueDwelling setYearBuilt(String text)
    {
        return super.setYearBuilt(text);
    }

    public ALHO3UWIssueDwelling Enter(){
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
    public ALHO3UWIssueDwelling setDistanceToFireHydrant(String text)
    {
        return super.setDistanceToFireHydrant(text);
    }

    public String getDistanceToFireHydrant()
    {
        return super.getDistanceToFireHydrant();
    }
    public ALHO3UWIssueDwelling setDistanceToFireStation(String text)
    {
        return super.setDistanceToFireStation(text);
    }

    public String getDistanceToFireStation()
    {
        return super.getDistanceToFireStation();
    }
    public ALHO3UWIssueDwelling setBCEG(String text)
    {
        return super.setBCEG(text);
    }

    public String getBCEG()
    {
        return super.getBCEG();
    }
    public ALHO3UWIssueDwelling setProtectionClassCode(String text)
    {
        return super.setProtectionClassCode(text);
    }

    public String getProtectionClassCode()
    {
        return super.getProtectionClassCode();
    }

    public ALHO3UWIssueDwelling waitForProtectionClassCode(String val)
    {
        super.waitForProtectionClassToUpdate(val);
        return new ALHO3UWIssueDwelling(sh, path);
    }

    public ALHO3UWIssueDwelling setTerritoryCode(String text)
    {
        return super.setTerritoryCode(text);
    }


    public String getTerritoryCode()
    {
        return super.getTerritoryCode();
    }
    public ALHO3UWIssueDwelling setLocationName(String text)
    {
        return super.setLocationName(text);
    }

    public String getLocationName()
    {
        return super.getLocationName();
    }
    public ALHO3UWIssueDwelling setLocalTaxJurisdiction(String text)
    {
        return super.setLocalTaxJurisdiction(text);
    }

    public String getLocalTaxJurisdiction()
    {
        return super.getLocalTaxJurisdiction();
    }
    public ALHO3UWIssueDwelling setLocationType(String text)
    {
        return super.setLocationType(text);
    }

    public String getLocationType()
    {
        return super.getLocationType();
    }
    public ALHO3UWIssueDwelling setDistanceToCoast(String text)
    {
        return super.setDistanceToCoast(text);
    }

    public String getDistanceToCoast()
    {
        return super.getDistanceToCoast();
    }
    public ALHO3UWIssueDwelling setPurchaseDate(String text)
    {
        return super.setPurchaseDate(text);
    }

    public String getPurchaseDate()
    {
        return super.getPurchaseDate();
    }
    public ALHO3UWIssueDwelling setPurchasePrice(String text)
    {
        return super.setPurchasePrice(text);
    }

    public String getPurchasePrice()
    {
        return super.getPurchasePrice();
    }
    public ALHO3UWIssueDwelling setMarketValue(String text)
    {
        return super.setMarketValue(text);
    }

    public String getMarketValue()
    {
        return super.getMarketValue();
    }
    public ALHO3UWIssueDwelling setResidenceType(String text)
    {
        return super.setResidenceType(text);
    }

    public String getResidenceType()
    {
        return super.getResidenceType();
    }
    public ALHO3UWIssueDwelling setDwellingUsage(String text)
    {
        return super.setDwellingUsage(text);
    }

    public ALHO3UWIssueDwelling clickDwellingLeftMenu()
    {
        super.clickDwellingLeft();
        return new ALHO3UWIssueDwelling(sh, path);
    }

    public ALHO3UWIssueDwelling clickDwellingBack()
    {
        super.clickDwellingLeft();
        return new ALHO3UWIssueDwelling(sh, path);
    }

    public String getDwellingUsage()
    {
        return super.getDwellingUsage();
    }
    public ALHO3UWIssueDwelling setDwellingOccupancy(String text)
    {
        return super.setDwellingOccupancy(text);
    }

    public String getDwellingOccupancy()
    {
        return super.getDwellingOccupancy();
    }
    public ALHO3UWIssueDwelling setHousekeepingCondition(String text)
    {
        return super.setHousekeepingCondition(text);
    }

    public String getHousekeepingCondition()
    {
        return super.getHousekeepingCondition();
    }
    public ALHO3UWIssueDwelling setInTheWindpool(String flag)
    {
        return super.setInTheWindpool(flag);
    }
    public ALHO3UWIssueDwelling setOwnedByOther(String flag)
    {
        return super.setOwnedByOther(flag);
    }
    public ALHO3UWIssueDwelling setOccupiedDaily(String flag)
    {
        return super.setOccupiedDaily(flag);
    }
    public ALHO3UWIssueDwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
    {
        return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
    }
    public ALHO3ProtectionDetails clickProtectionDetails()
    {
        super.clickProtectionDetailsTab();
        return new ALHO3ProtectionDetails(sh, path);
    }
    public ALHO3UWIssueAdditionalInterests clickAdditionalInterests()
    {
        super.clickAdditionalInterestsTab();
        return new ALHO3UWIssueAdditionalInterests(sh, path);
    }
    public ALHO3UWIssueDwelling setMinimumRentalIncrement(String text)
    {
        return super.setMinimumRentalIncrement(text);
    }

    public String getMinimumRentalIncrement()
    {
        return super.getMinimumRentalIncrement();
    }
    public ALHO3UWIssueDwelling underContractWithRentalManagementCompany(String flag)
    {
        return super.underContractWithRentalManagementCompany(flag);
    }
    public ALHO3UWIssueDwelling setWeeksRentedAnnually(String text)
    {
        return super.setWeeksRentedAnnually(text);
    }

    public String getWeeksRentedAnnually()
    {
        return super.getWeeksRentedAnnually();
    }

    public ALHO3UWIssueDwelling setSwimmingPool(String flag)
    {
        return super.setSwimmingPool(flag);
    }
    public ALHO3UWIssueDwelling setTrampolineOnPremises(String flag)
    {
        return super.setTrampolineOnPremises(flag);
    }
    public ALHO3UWIssueDwelling setSkateboardBicycleRampOnPremises(String flag)
    {
        return super.setSkateboardBicycleRampOnPremises(flag);
    }
    public ALHO3UWIssueDwelling setAnimalsOrExoticPets(String flag)
    {
        return super.setAnimalsOrExoticPets(flag);
    }
    public ALHO3UWIssueDwelling setGolfCarts(String flag)
    {
        return super.setGolfCarts(flag);
    }
    public ALHO3UWIssueDwelling setRecreationalVehiclesOwned(String flag)
    {
        return super.setRecreationalVehiclesOwned(flag);
    }
    public ALHO3UWIssueDwelling setPoolFenced(String flag)
    {
        return super.setPoolFenced(flag);
    }
    public ALHO3UWIssueDwelling setDivingBoard(String flag)
    {
        return super.setDivingBoard(flag);
    }
    public ALHO3UWIssueDwelling setPoolSlide(String flag)
    {
        return super.setPoolSlide(flag);
    }
    public ALHO3UWIssueDwelling setPoolLocation(String text)
    {
        return super.setPoolLocation(text);
    }

    public String getPoolLocation()
    {
        return super.getPoolLocation();
    }
    public ALHO3UWIssueDwelling setFenceType(String text)
    {
        return super.setFenceType(text);
    }

    public String getFenceType()
    {
        return super.getFenceType();
    }
    public ALHO3UWIssueDwelling setWindpoolZone(String text)
    {
        return super.setWindpoolZone(text);
    }

    public String getWindpoolZone()
    {
        return super.getWindpoolZone();
    }
    public ALHO3UWIssueLocationInformation addNewLocation()
    {
        super.addNewDwellingLocation();
        return new ALHO3UWIssueLocationInformation(sh, path);
    }
    public ALHO3UWIssueLocationInformation editLocation()
    {
        super.editDwellingLocation();
        return new ALHO3UWIssueLocationInformation(sh, path);
    }

    public class ALHO3ProtectionDetails extends ProtectionDetails<ALHO3ProtectionDetails>
    {
        public ALHO3ProtectionDetails(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public ALHO3UWIssueAdditionalInterests clickAdditionalInterests()
        {
            super.clickAdditionalInterestsTab();
            return new ALHO3UWIssueAdditionalInterests(sh, path);

        }
        public ALHO3UWIssueDwelling clickDetails()
        {
            super.clickDetailsTab();
            return new ALHO3UWIssueDwelling(sh, path);
        }
        public ALHO3UWIssueDwellingConstruction next()
        {
            dwellingConstructionNext();
            return new ALHO3UWIssueDwellingConstruction(sh, path);
        }

        public String getProtectiondwellingErrorMessage()
        {
            return  super.dwellingProtectionErrorMessage();
        }
        public ALHO3ProtectionDetails setBurglarAlarm(String flag)
        {
            return super.setBurglarAlarm(flag);
        }
        public ALHO3ProtectionDetails setLockedPrivacyFence(String flag)
        {
            return super.setLockedPrivacyFence(flag);
        }
        public ALHO3ProtectionDetails setBurglarBarsOnWindows(String flag)
        {
            return super.setBurglarBarsOnWindows(flag);
        }
        public ALHO3ProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}
        public ALHO3ProtectionDetails setCommunityGuarded(String flag)
        {
            return super.setCommunityGuarded(flag);
        }
        public ALHO3ProtectionDetails setGatedCommunity(String flag)
        {
            return super.setGatedCommunity(flag);
        }
        public ALHO3ProtectionDetails setFireAlarm(String flag)
        {
            return super.setFireAlarm(flag);
        }
        public ALHO3ProtectionDetails setSmokeAlarm(String flag)
        {
            return super.setSmokeAlarm(flag);
        }
        public ALHO3ProtectionDetails setFireExtinguishers(String flag)
        {
            return super.setFireExtinguishers(flag);
        }
        public ALHO3ProtectionDetails setSprinklerSystem(String flag)
        {
            return super.setSprinklerSystem(flag);
        }
        public ALHO3ProtectionDetails setDeadbolts(String flag)
        {
            return super.setDeadbolts(flag);
        }
        public ALHO3ProtectionDetails setResidenceVisibleToNeighbors(String flag)
        {
            return super.setResidenceVisibleToNeighbors(flag);
        }
        public ALHO3ProtectionDetails safetyLatchesPresent(String flag)
        {
            return super.safetyLatchesPresent(flag);
        }
        public ALHO3ProtectionDetails setBurglarAlarmType(String text)
        {
            return super.setBurglarAlarmType(text);
        }

        public String getBurglarAlarmType()
        {
            return super.getBurglarAlarmType();
        }
        public ALHO3ProtectionDetails setFireAlarmType(String text)
        {
            return super.setFireAlarmType(text);
        }

        public String getFireAlarmType()
        {
            return super.getFireAlarmType();
        }

        public ALHO3ProtectionDetails setSprinklerSystemType(String text)
        {
            return super.setSprinklerSystemType(text);
        }

        public String getSprinklerSystemType()
        {
            return super.getSprinklerSystemType();
        }

    }

    public class ALHO3UWIssueAdditionalInterests extends AdditionalInterests<ALHO3UWIssueAdditionalInterests>
    {
        public ALHO3UWIssueAdditionalInterests(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }


        public ALHO3ProtectionDetails clickProtectionDetails()
        {
            super.clickProtectionDetailsTab();
            return new ALHO3ProtectionDetails(sh, path);
        }

        public ALHO3UWIssueDwelling clickDetails()
        {
            super.clickDetailsTab();
            return new ALHO3UWIssueDwelling(sh, path);
        }
        public ALHO3UWIssueAdditionalInterests clickRemove()
        {
            super.clickRemove();
            return this;
        }
        public ALHO3UWIssueNewAdditionalInterest clickAddNewPerson()
        {
            addNewPerson();
            return new ALHO3UWIssueNewAdditionalInterest(sh,path);
        }
        public ALHO3UWIssueNewAdditionalInterest clickAddNewCompany()
        {
            addNewCompany();
            return new ALHO3UWIssueNewAdditionalInterest(sh,path);
        }
        public ALHO3UWIssueSearchAddressBook clickFromAddressBook()
        {
            fromAddressBook();
            return new ALHO3UWIssueSearchAddressBook(sh,path);
        }
        public ALHO3UWIssueAdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
        {
            return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
        }
        public ALHO3UWIssueAdditionalInterests selectRowInAdditionalInterestByName(String name)
        {
            return super.selectRowInAdditionalInterestByName(name);
        }
        public ALHO3UWIssueAdditionalInterests setType(int row, String type)
        {
            return super.setType(row,type);
        }
        public ALHO3UWIssueAdditionalInterests setEffectiveDate(int row, String effectiveDate)
        {
            return super.setEffectiveDate(row,effectiveDate);
        }
        public ALHO3UWIssueAdditionalInterests setLoanNumber(int row, String loanNumber)
        {
            return super.setLoanNumber(row,loanNumber);
        }
        public ALHO3UWIssueDwellingConstruction next()
        {
            super.dwellingConstructionNext();
            return new ALHO3UWIssueDwellingConstruction(sh, path);
        }






    }
}
