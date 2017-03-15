package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3DwellingConstruction extends DwellingConstruction<SCDP3DwellingConstruction> {
    public SCDP3DwellingConstruction(CenterSeleniumHelper sh, Path path) {
        super(sh, path);
    }

    public SCDP3Coverages next() {
        super.coveragesNext();
        return new SCDP3Coverages(sh, path);
    }

    public SCDP3WindMitigation clickWindMitigation() {
        super.windMitigation();
        return new SCDP3WindMitigation(sh, path);
    }

    public SCDP3DwellingConstruction setRoofYear(String text) {
        return super.setRoofYear(text);
    }

    public String getRoofYear() {
        return super.getRoofYear();
    }

    public SCDP3DwellingConstruction clickeditpolicytransaction(){
        return super.editPolicyTransaction();
    }

    public SCDP3DwellingConstruction acceptYes(){
        return super.accept();
    }
    public SCDP3DwellingConstruction setValuationType(String text) {
        return super.setValuationType(text);
    }

    public String getValuationType() {
        return super.getValuationType();
    }

    public SCDP3DwellingConstruction setEstimatedReplacementCost(String text) {
        return super.setEstimatedReplacementCost(text);
    }

    public SCDP3Dwelling back() {
        super.dwellingBack();
        return new SCDP3Dwelling(sh, path);
    }
    public String dwellingConstructionErrorMessage()
    {
        return super.dwellingConstructionErrorMessage();
    }
    public SCDP3DwellingConstruction dwellingConstructionEnter(){return super.dwellingConstructionEnter();}


    public String getEstimatedReplacementCost() {
        return super.getEstimatedReplacementCost();
    }

    public SCDP3DwellingConstruction setConstructionType(String text) {
        return super.setConstructionType(text);
    }

    public String getConstructionType() {
        return super.getConstructionType();
    }

    public SCDP3DwellingConstruction setNumberOfUnits(String text) {
        return super.setNumberOfUnits(text);
    }

    public String getNumberOfUnits() {
        return super.getNumberOfUnits();
    }

    public SCDP3DwellingConstruction setUnitsInFireWall(String text) {
        return super.setUnitsInFireWall(text);
    }

    public String getUnitsInFireWall() {
        return super.getUnitsInFireWall();
    }

    public SCDP3DwellingConstruction setNumberOfStories(String text) {
        return super.setNumberOfStories(text);
    }

    public String getNumberOfStories() {
        return super.getNumberOfStories();
    }

    public SCDP3DwellingConstruction setSquareFootage(String text) {
        return super.setSquareFootage(text);
    }

    public String getSquareFootage() {
        return super.getSquareFootage();
    }

    public SCDP3DwellingConstruction setFoundationType(String text) {
        return super.setFoundationType(text);
    }

    public String getFoundationType() {
        return super.getFoundationType();
    }

    public SCDP3DwellingConstruction setPrimaryHeating(String text) {
        return super.setPrimaryHeating(text);
    }

    public String getPrimaryHeating() {
        return super.getPrimaryHeating();
    }

    public SCDP3DwellingConstruction setPlumbing(String text) {
        return super.setPlumbing(text);
    }

    public String getPlumbing() {
        return super.getPlumbing();
    }

    public SCDP3DwellingConstruction setPlumbingYear(String text) {
        return super.setPlumbingYear(text);
    }

    public String getPlumbingYear() {
        return super.getPlumbingYear();
    }

    public SCDP3DwellingConstruction setWaterHeaterYear(String text) {
        return super.setWaterHeaterYear(text);
    }

    public String getWaterHeaterYear() {
        return super.getWaterHeaterYear();
    }

    public SCDP3DwellingConstruction setWiring(String text) {
        return super.setWiring(text);
    }

    public String getWiring() {
        return super.getWiring();
    }

    public SCDP3DwellingConstruction setElectricalSystem(String text) {
        return super.setElectricalSystem(text);
    }

    public String gettElectricalSystem() {
        return super.getElectricalSystem();
    }

    public SCDP3DwellingConstruction setRoofType(String text) {
        return super.setRoofType(text);
    }

    public String getRoofType() {
        return super.getRoofType();
    }

    public SCDP3DwellingConstruction setConditionOfRoof(String text) {
        return super.setConditionOfRoof(text);
    }

    public String getConditionOfRoof() {
        return super.getConditionOfRoof();
    }

    public SCDP3DwellingConstruction setIsThereASecondaryHeatingSystem(String flag) {
        return super.setIsThereASecondaryHeatingSystem(flag);
    }

    public SCDP3DwellingConstruction setElectricalSystemDescribeOther(String text) {
        return super.setElectricalSystemDescribeOther(text);
    }

    public String getElectricalSystemDescribeOther() {
        return super.getElectricalSystemDescribeOther();
    }

    public SCDP3DwellingConstruction setRoofTypeDescription(String text) {
        return super.setRoofTypeDescription(text);
    }

    public String getRoofTypeDescription() {
        return super.getRoofTypeDescription();
    }

    public SCDP3DwellingConstruction setPlumbingDescribeOther(String text) {
        return super.setPlumbingDescribeOther(text);
    }

    public String getPlumbingDescribeOther() {
        return super.getPlumbingDescribeOther();
    }

    public SCDP3DwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag) {
        return super.setPlumbingSystemHaveKnownLeaks(flag);
    }
    public SCDP3Quote clickDwellingconstructionQuote(){
        super.DwellingconstructionQuote();
        return new SCDP3Quote(sh,path);
    }

    public SCDP3DwellingConstruction setBuildingRetrofittedForEarthquakes(String flag) {
        return super.setBuildingRetrofittedForEarthquakes(flag);
    }

    public SCDP3DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag) {
        return super.setUncorrectedFireOrBuildingCodeViolations(flag);
    }

    public SCDP3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag) {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
    }

    public SCDP3DwellingConstruction setLeadPaintHazard(String flag) {
        return super.setLeadPaintHazard(flag);
    }

    public SCDP3DwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag) {
        return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
    }

    public SCDP3DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag) {
        return super.setBuildingRetrofittedForEarthquakesDescription(flag);
    }

    public SCDP3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag) {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
    }

    public SCDP3DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag) {
        return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
    }

    public SCDP3DwellingConstruction setLeadPaintHazardDescription(String flag) {
        return super.setLeadPaintHazardDescription(flag);
    }

    public SCDP3DwellingConstruction setScreenEnclosureOnPremises(String flag) {
        return super.setScreenEnclosureOnPremises(flag);
    }

    public class SCDP3WindMitigation extends WindMitigation<SCDP3WindMitigation> {
        public SCDP3WindMitigation(CenterSeleniumHelper sh, Path path) {
            super(sh, path);
        }

        public SCDP3DwellingConstruction clickDetails() {
            super.clickDetailsTab();
            return new SCDP3DwellingConstruction(sh, path);
        }

        public SCDP3Coverages next() {
            super.coveragesNext();
            return new SCDP3Coverages(sh, path);
        }

        public SCDP3Coverages doubleClickNext() {
            super.doubleClickCoveragesNext();
            return new SCDP3Coverages(sh, path);
        }

        public SCDP3WindMitigation setRoofShapeType(String text) {
            return super.setRoofShapeType(text);
        }

        public String getRoofShapeType() {
            return super.getRoofShapeType();
        }

        public SCDP3WindMitigation setDiscountType(String text) {
            return super.setDiscountType(text);
        }

        public String getDiscountType() {
            return super.getDiscountType();
        }

        public SCDP3WindMitigation setFortifiedHomeType(String text) {
            return super.setFortifiedHomeType(text);
        }

        public String getFortifiedHomeType() {
            return super.getFortifiedHomeType();
        }

        public SCDP3WindMitigation setOpeningProtectionType(String text) {
            return super.setOpeningProtectionType(text);
        }

        public String getOpeningProtectionType() {
            return super.getOpeningProtectionType();
        }

        public SCDP3WindMitigation setTerrain(String text) {
            return super.setTerrain(text);
        }

        public String getTerrain() {
            return super.getTerrain();
        }

        public SCDP3Quote clickdwellingconstructionwindmitiQuote(){
            super.DwellingConstructionWindMitiQuote();
            return new SCDP3Quote(sh,path);
        }
        public SCDP3WindMitigation setRoofCover(String text) {
            return super.setRoofCover(text);
        }

        public String getRoofCover() {
            return super.getRoofCover();
        }

        public SCDP3WindMitigation setRoofDeckAttachment(String text) {
            return super.setRoofDeckAttachment(text);
        }

        public String getRoofDeckAttachment() {
            return super.getRoofDeckAttachment();
        }

        public SCDP3WindMitigation setRoofWallConnection(String text) {
            return super.setRoofWallConnection(text);
        }

        public SCDP3Dwelling winddwellingback() {
            super.WinddwellingBack();
            return new SCDP3Dwelling(sh, path);
        }

        public String getRoofWallConnection() {
            return super.getRoofWallConnection();
        }

        public SCDP3WindMitigation setSecondaryWaterResistance(String flag) {
            return super.setSecondaryWaterResistance(flag);
        }

        public SCDP3WindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag) {
            return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
        }

        public SCDP3WindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag) {
            return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
        }

        public SCDP3WindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag) {
            return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
        }

        public SCDP3WindMitigation setRoofDeck(String text) {
            return super.setRoofDeck(text);
        }

        public String getRoofDeck() {
            return super.getRoofDeck();
        }

        public SCDP3WindMitigation setFbcWindSpeed(String text) {
            return super.setFbcWindSpeed(text);
        }

        public String getFbcWindSpeed() {
            return super.getFbcWindSpeed();
        }

        public SCDP3WindMitigation setInternalPressure(String text) {
            return super.setInternalPressure(text);
        }

        public String getInternalPressure() {
            return super.getInternalPressure();
        }

        public SCDP3WindMitigation setWindBorneDebris(String flag) {
            return super.setWindBorneDebris(flag);
        }


    }
}
