package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3Dwelling extends Dwelling<SCDP3Dwelling> {
    public SCDP3Dwelling(CenterSeleniumHelper sh, Path path) {
        super(sh, path);
    }

    public SCDP3DwellingConstruction next() {
        super.DwellingConstructionNext();
        return new SCDP3DwellingConstruction(sh, path);
    }

    public SCDP3Dwelling setYearBuilt(String text) {
        return super.setYearBuilt(text);
    }

    public SCDP3Dwelling Enter() {
        return super.Enter();
    }

    public String getdwellingErrorMessage() {
        return super.dwellingErrorMessage();
    }

    public String getYearBuilt() {
        return super.getYearBuilt();
    }

    public SCDP3Dwelling setDistanceToFireHydrant(String text) {
        return super.setDistanceToFireHydrant(text);
    }

    public String getDistanceToFireHydrant() {
        return super.getDistanceToFireHydrant();
    }

    public SCDP3Dwelling setDistanceToFireStation(String text) {
        return super.setDistanceToFireStation(text);
    }

    public String getDistanceToFireStation() {
        return super.getDistanceToFireStation();
    }

    public SCDP3Dwelling setBCEG(String text) {
        return super.setBCEG(text);
    }

    public String getBCEG() {
        return super.getBCEG();
    }

    public SCDP3Dwelling setProtectionClassCode(String text) {
        return super.setProtectionClassCode(text);
    }

    public String getProtectionClassCode() {
        return super.getProtectionClassCode();
    }

    public SCDP3Dwelling setTerritoryCode(String text) {
        return super.setTerritoryCode(text);
    }

    public String getTerritoryCode() {
        return super.getTerritoryCode();
    }

    public SCDP3Dwelling setLocationName(String text) {
        return super.setLocationName(text);
    }

    public String getLocationName() {
        return super.getLocationName();
    }

    public SCDP3Dwelling setLocalTaxJurisdiction(String text) {
        return super.setLocalTaxJurisdiction(text);
    }

    public String getLocalTaxJurisdiction() {
        return super.getLocalTaxJurisdiction();
    }

    public SCDP3Dwelling setLocationType(String text) {
        return super.setLocationType(text);
    }

    public String getLocationType() {
        return super.getLocationType();
    }

    public SCDP3Dwelling setDistanceToCoast(String text) {
        return super.setDistanceToCoast(text);
    }

    public String getDistanceToCoast() {
        return super.getDistanceToCoast();
    }

    public SCDP3Dwelling setPurchaseDate(String text) {
        return super.setPurchaseDate(text);
    }

    public String getPurchaseDate() {
        return super.getPurchaseDate();
    }

    public SCDP3Dwelling setPurchasePrice(String text) {
        return super.setPurchasePrice(text);
    }

    public String getPurchasePrice() {
        return super.getPurchasePrice();
    }

    public SCDP3Dwelling setMarketValue(String text) {
        return super.setMarketValue(text);
    }

    public String getMarketValue() {
        return super.getMarketValue();
    }

    public SCDP3Dwelling setResidenceType(String text) {
        return super.setResidenceType(text);
    }

    public String getResidenceType() {
        return super.getResidenceType();
    }

    public SCDP3Dwelling setDwellingUsage(String text) {
        return super.setDwellingUsage(text);
    }

    public String getDwellingUsage() {
        return super.getDwellingUsage();
    }

    public SCDP3Dwelling setDwellingOccupancy(String text) {
        return super.setDwellingOccupancy(text);
    }

    public String getDwellingOccupancy() {
        return super.getDwellingOccupancy();
    }

    public SCDP3Dwelling setHousekeepingCondition(String text) {
        return super.setHousekeepingCondition(text);
    }

    public String getHousekeepingCondition() {
        return super.getHousekeepingCondition();
    }

    public SCDP3Dwelling setInTheWindpool(String flag) {
        return super.setInTheWindpool(flag);
    }

    public SCDP3Dwelling setOwnedByOther(String flag) {
        return super.setOwnedByOther(flag);
    }

    public SCDP3Dwelling setOccupiedDaily(String flag) {
        return super.setOccupiedDaily(flag);
    }

    public SCDP3Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag) {
        return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
    }

    public SCDP3ProtectionDetails clickProtectionDetails() {
        super.clickProtectionDetailsTab();
        return new SCDP3ProtectionDetails(sh, path);
    }

    public SCDP3AdditionalInterests clickAdditionalInterests() {
        super.clickAdditionalInterestsTab();
        return new SCDP3AdditionalInterests(sh, path);
    }

    public SCDP3Dwelling setSwimmingPool(String flag) {
        return super.setSwimmingPool(flag);
    }

    public SCDP3Dwelling setTrampolineOnPremises(String flag) {
        return super.setTrampolineOnPremises(flag);
    }

    public SCDP3Dwelling setSkateboardBicycleRampOnPremises(String flag) {
        return super.setSkateboardBicycleRampOnPremises(flag);
    }

    public SCDP3Dwelling setAnimalsOrExoticPets(String flag) {
        return super.setAnimalsOrExoticPets(flag);
    }

    public SCDP3Dwelling setGolfCarts(String flag) {
        return super.setGolfCarts(flag);
    }

    public SCDP3Dwelling setRecreationalVehiclesOwned(String flag) {
        return super.setRecreationalVehiclesOwned(flag);
    }

    public SCDP3Dwelling setPoolFenced(String flag) {
        return super.setPoolFenced(flag);
    }

    public SCDP3Dwelling setDivingBoard(String flag) {
        return super.setDivingBoard(flag);
    }

    public SCDP3Dwelling setPoolSlide(String flag) {
        return super.setPoolSlide(flag);
    }

    public SCDP3Dwelling setPoolLocation(String text) {
        return super.setPoolLocation(text);
    }

    public String getPoolLocation() {
        return super.getPoolLocation();
    }

    public SCDP3Dwelling setFenceType(String text) {
        return super.setFenceType(text);
    }

    public String getFenceType() {
        return super.getFenceType();
    }

    public SCDP3Dwelling setWindpoolZone(String text) {
        return super.setWindpoolZone(text);
    }

    public String getWindpoolZone() {
        return super.getWindpoolZone();
    }

    public SCDP3LocationInformation addNewLocation() {
        super.addNewDwellingLocation();
        return new SCDP3LocationInformation(sh, path);
    }

    public SCDP3LocationInformation editLocation() {
        super.editDwellingLocation();
        return new SCDP3LocationInformation(sh, path);
    }

    public class SCDP3ProtectionDetails extends ProtectionDetails<SCDP3ProtectionDetails> {
        public SCDP3ProtectionDetails(CenterSeleniumHelper sh, Path path) {
            super(sh, path);
        }

        public SCDP3AdditionalInterests clickAdditionalInterests() {
            super.clickAdditionalInterestsTab();
            return new SCDP3AdditionalInterests(sh, path);

        }

        public SCDP3Dwelling clickDetails() {
            super.clickDetailsTab();
            return new SCDP3Dwelling(sh, path);
        }

        public SCDP3DwellingConstruction next() {
            dwellingConstructionNext();
            return new SCDP3DwellingConstruction(sh, path);
        }

        public SCDP3ProtectionDetails setBurglarAlarm(String flag) {
            return super.setBurglarAlarm(flag);
        }

        public SCDP3ProtectionDetails setLockedPrivacyFence(String flag) {
            return super.setLockedPrivacyFence(flag);
        }

        public SCDP3ProtectionDetails setBurglarBarsOnWindows(String flag) {
            return super.setBurglarBarsOnWindows(flag);
        }

        public SCDP3ProtectionDetails setCommunityGuarded(String flag) {
            return super.setCommunityGuarded(flag);
        }

        public SCDP3ProtectionDetails setGatedCommunity(String flag) {
            return super.setGatedCommunity(flag);
        }

        public SCDP3ProtectionDetails setFireAlarm(String flag) {
            return super.setFireAlarm(flag);
        }

        public SCDP3ProtectionDetails setSmokeAlarm(String flag) {
            return super.setSmokeAlarm(flag);
        }

        public SCDP3ProtectionDetails setFireExtinguishers(String flag) {
            return super.setFireExtinguishers(flag);
        }

        public SCDP3ProtectionDetails setSprinklerSystem(String flag) {
            return super.setSprinklerSystem(flag);
        }

        public SCDP3ProtectionDetails setDeadbolts(String flag) {
            return super.setDeadbolts(flag);
        }

        public SCDP3ProtectionDetails setResidenceVisibleToNeighbors(String flag) {
            return super.setResidenceVisibleToNeighbors(flag);
        }

        public SCDP3ProtectionDetails safetyLatchesPresent(String flag) {
            return super.safetyLatchesPresent(flag);
        }

        public SCDP3ProtectionDetails setBurglarAlarmType(String text) {
            return super.setBurglarAlarmType(text);
        }

        public String getBurglarAlarmType() {
            return super.getBurglarAlarmType();
        }

        public SCDP3ProtectionDetails setFireAlarmType(String text) {
            return super.setFireAlarmType(text);
        }

        public String getFireAlarmType() {
            return super.getFireAlarmType();
        }

        public SCDP3ProtectionDetails setSprinklerSystemType(String text) {
            return super.setSprinklerSystemType(text);
        }
        public SCDP3ProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}

        public String getSprinklerSystemType() {
            return super.getSprinklerSystemType();
        }

    }

    public class SCDP3AdditionalInterests extends AdditionalInterests<SCDP3AdditionalInterests> {
        public SCDP3AdditionalInterests(CenterSeleniumHelper sh, Path path) {
            super(sh, path);
        }


        public SCDP3ProtectionDetails clickProtectionDetails() {
            super.clickProtectionDetailsTab();
            return new SCDP3ProtectionDetails(sh, path);
        }

        public SCDP3Dwelling clickDetails() {
            super.clickDetailsTab();
            return new SCDP3Dwelling(sh, path);
        }

        public SCDP3AdditionalInterests clickRemove() {
            super.clickRemove();
            return this;
        }

        public SCDP3NewAdditionalInterest clickAddNewPerson() {
            addNewPerson();
            return new SCDP3NewAdditionalInterest(sh, path);
        }

        public SCDP3NewAdditionalInterest clickAddNewCompany() {
            addNewCompany();
            return new SCDP3NewAdditionalInterest(sh, path);
        }

        public SCDP3SearchAddressBook clickFromAddressBook() {
            fromAddressBook();
            return new SCDP3SearchAddressBook(sh, path);
        }

        public SCDP3AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber) {
            return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
        }

        public SCDP3AdditionalInterests selectRowInAdditionalInterestByName(String name) {
            return super.selectRowInAdditionalInterestByName(name);
        }

        public SCDP3AdditionalInterests setType(int row, String type) {
            return super.setType(row, type);
        }

        public SCDP3AdditionalInterests setEffectiveDate(int row, String effectiveDate) {
            return super.setEffectiveDate(row, effectiveDate);
        }

        public SCDP3AdditionalInterests setLoanNumber(int row, String loanNumber) {
            return super.setLoanNumber(row, loanNumber);
        }

        public SCDP3DwellingConstruction next() {
            super.dwellingConstructionNext();
            return new SCDP3DwellingConstruction(sh, path);
        }


    }

}
