package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3DwellingConstruction extends DwellingConstruction<FLMH3DwellingConstruction> {

    public FLMH3DwellingConstruction(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3Coverages next()
    {
        super.coveragesNext();
        return new FLMH3Coverages(sh, path);
    }
    public FLMH3WindMitigation clickWindMitigation()
    {
        super.windMitigation();
        return new FLMH3WindMitigation(sh,path);
    }
    public FLMH3DwellingConstruction setRoofYear(String text)
    {
        return super.setRoofYear(text);
    }

    public String getRoofYear()
    {
        return super.getRoofYear();
    }
    public FLMH3DwellingConstruction setValuationType(String text)
    {
        return super.setValuationType(text);
    }

    public String getValuationType()
    {
        return super.getValuationType();
    }
    public FLMH3DwellingConstruction setEstimatedReplacementCost(String text)
    {
        return super.setEstimatedReplacementCost(text);
    }

    public String dwellingConstructionErrorMessage()
    {
        return super.dwellingConstructionErrorMessage();
    }

    public String getEstimatedReplacementCost()
    {
        return super.getEstimatedReplacementCost();
    }
    public FLMH3DwellingConstruction setConstructionType(String text)
    {
        return super.setConstructionType(text);
    }
    public FLMH3DwellingConstruction dwellingConstructionEnter(){return super.dwellingConstructionEnter();}

    public String getConstructionType()
    {
        return super.getConstructionType();
    }
    public FLMH3DwellingConstruction setNumberOfUnits(String text)
    {
        return super.setNumberOfUnits(text);
    }
    public String getNumberOfUnits()
    {
        return super.getNumberOfUnits();
    }
    public FLMH3DwellingConstruction setUnitsInFireWall(String text)
    {
        return super.setUnitsInFireWall(text);
    }

    public String getUnitsInFireWall()
    {
        return super.getUnitsInFireWall();
    }
    public FLMH3DwellingConstruction setNumberOfStories(String text)
    {
        return super.setNumberOfStories(text);
    }

    public String getNumberOfStories()
    {
        return super.getNumberOfStories();
    }
    public FLMH3DwellingConstruction setSquareFootage(String text)
    {
        return super.setSquareFootage(text);
    }

    public String getSquareFootage()
    {
        return super.getSquareFootage();
    }
    public FLMH3DwellingConstruction setFoundationType(String text)
    {
        return super.setFoundationType(text);
    }

    public String getFoundationType()
    {
        return super.getFoundationType();
    }
    public FLMH3DwellingConstruction setPrimaryHeating(String text)
    {
        return super.setPrimaryHeating(text);
    }

    public String getPrimaryHeating()
    {
        return super.getPrimaryHeating();
    }
    public FLMH3DwellingConstruction setPlumbing(String text)
    {
        return super.setPlumbing(text);
    }

    public String getPlumbing()
    {
        return super.getPlumbing();
    }
    public FLMH3DwellingConstruction setPlumbingYear(String text)
    {
        return super.setPlumbingYear(text);
    }

    public String getPlumbingYear()
    {
        return super.getPlumbingYear();
    }
    public FLMH3DwellingConstruction setWaterHeaterYear(String text)
    {
        return super.setWaterHeaterYear(text);
    }

    public String getWaterHeaterYear()
    {
        return super.getWaterHeaterYear();
    }
    public FLMH3DwellingConstruction setWiring(String text)
    {
        return super.setWiring(text);
    }

    public String getWiring()
    {
        return super.getWiring();
    }
    public FLMH3DwellingConstruction setElectricalSystem(String text)
    {
        return super.setElectricalSystem(text);
    }

    public String gettElectricalSystem()
    {
        return super.getElectricalSystem();
    }
    public FLMH3DwellingConstruction setRoofType(String text)
    {
        return super.setRoofType(text);
    }

    public String getRoofType()
    {
        return super.getRoofType();
    }
    public FLMH3DwellingConstruction setConditionOfRoof(String text)
    {
        return super.setConditionOfRoof(text);
    }

    public String getConditionOfRoof()
    {
        return super.getConditionOfRoof();
    }
    public FLMH3DwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
    {
        return super.setIsThereASecondaryHeatingSystem(flag);
    }
    public FLMH3DwellingConstruction setIsTheMobileHomeFullySkirted(String flag){
        return super.setIsTheMobileHomeFullySkirted(flag);
    }
    public FLMH3DwellingConstruction setMobileHomeWidth(String text){
        return super.setMobileHomeWidth(text);
    }
    public String getsetMobileHomeWidth(){return super.getMobileHomeWidth();}
    public FLMH3DwellingConstruction setElectricalSystemDescribeOther(String text)
    {
        return super.setElectricalSystemDescribeOther(text);
    }

    public FLMH3Dwelling back()
    {
        super.dwellingBack();
        return new FLMH3Dwelling(sh,path);
    }
    public String getElectricalSystemDescribeOther()
    {
        return super.getElectricalSystemDescribeOther();
    }
    public FLMH3DwellingConstruction setRoofTypeDescription(String text)
    {
        return super.setRoofTypeDescription(text);
    }

    public String getRoofTypeDescription()
    {
        return super.getRoofTypeDescription();
    }
    public FLMH3DwellingConstruction setPlumbingDescribeOther(String text)
    {
        return super.setPlumbingDescribeOther(text);
    }

    public String getPlumbingDescribeOther()
    {
        return super.getPlumbingDescribeOther();
    }
    public FLMH3DwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
    {
        return super.setPlumbingSystemHaveKnownLeaks(flag);
    }
    public FLMH3DwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakes(flag);
    }
    public FLMH3DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolations(flag);
    }
    public FLMH3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
    }
    public FLMH3DwellingConstruction setLeadPaintHazard(String flag)
    {
        return super.setLeadPaintHazard(flag);
    }
    public FLMH3DwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
    {
        return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
    }
    public FLMH3DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakesDescription(flag);
    }
    public FLMH3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
    }
    public FLMH3DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
    }
    public FLMH3DwellingConstruction setLeadPaintHazardDescription(String flag)
    {
        return super.setLeadPaintHazardDescription(flag);
    }
    public FLMH3DwellingConstruction setScreenEnclosureOnPremises(String flag)
    {
        return super.setScreenEnclosureOnPremises(flag);
    }

    public class FLMH3WindMitigation extends WindMitigation<FLMH3WindMitigation>
    {
        public FLMH3WindMitigation(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public FLMH3DwellingConstruction clickDetails()
        {
            super.clickDetailsTab();
            return new FLMH3DwellingConstruction(sh, path);
        }
        public FLMH3Coverages next()
        {
            super.coveragesNext();
            return new FLMH3Coverages(sh,path);
        }
        public FLMH3Coverages doubleClickNext()
        {
            super.doubleClickCoveragesNext();
            return new FLMH3Coverages(sh, path);
        }
        public FLMH3WindMitigation setRoofShapeType(String text)
        {
            return super.setRoofShapeType(text);
        }

        public String getRoofShapeType()
        {
            return super.getRoofShapeType();
        }
        public FLMH3WindMitigation setDiscountType(String text)
        {
            return super.setDiscountType(text);
        }

        public String getDiscountType()
        {
            return super.getDiscountType();
        }
        public FLMH3WindMitigation setFortifiedHomeType(String text)
        {
            return super.setFortifiedHomeType(text);
        }

        public String getFortifiedHomeType()
        {
            return super.getFortifiedHomeType();
        }
        public FLMH3WindMitigation setOpeningProtectionType(String text)
        {
            return super.setOpeningProtectionType(text);
        }

        public String getOpeningProtectionType()
        {
            return super.getOpeningProtectionType();
        }
        public FLMH3WindMitigation setTerrain(String text)
        {
            return super.setTerrain(text);
        }

        public String getTerrain()
        {
            return super.getTerrain();
        }
        public FLMH3WindMitigation setRoofCover(String text)
        {
            return super.setRoofCover(text);
        }

        public FLMH3Dwelling winddwellingback()
        {
            super.WinddwellingBack();
            return new FLMH3Dwelling(sh,path);
        }


        public String getRoofCover()
        {
            return super.getRoofCover();
        }
        public FLMH3WindMitigation setRoofDeckAttachment(String text)
        {
            return super.setRoofDeckAttachment(text);
        }

        public String getRoofDeckAttachment()
        {
            return super.getRoofDeckAttachment();
        }
        public FLMH3WindMitigation setRoofWallConnection(String text)
        {
            return super.setRoofWallConnection(text);
        }

        public String getRoofWallConnection()
        {
            return super.getRoofWallConnection();
        }
        public FLMH3WindMitigation setSecondaryWaterResistance(String flag)
        {
            return super.setSecondaryWaterResistance(flag);
        }
        public FLMH3WindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
        }
        public FLMH3WindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
        }
        public FLMH3WindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
        }
        public FLMH3WindMitigation setRoofDeck(String text)
        {
            return super.setRoofDeck(text);
        }

        public String getRoofDeck()
        {
            return super.getRoofDeck();
        }
        public FLMH3WindMitigation setFbcWindSpeed(String text)
        {
            return super.setFbcWindSpeed(text);
        }

        public String getFbcWindSpeed()
        {
            return super.getFbcWindSpeed();
        }
        public FLMH3WindMitigation setInternalPressure(String text)
        {
            return super.setInternalPressure(text);
        }

        public String getInternalPressure()
        {
            return super.getInternalPressure();
        }

        public FLMH3WindMitigation setWindBorneDebris(String flag)
        {
            return super.setWindBorneDebris(flag);
        }
















    }
}
