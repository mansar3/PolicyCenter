package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4DwellingConstruction  extends DwellingConstruction<FLHO4DwellingConstruction>{
    public FLHO4DwellingConstruction(CenterSeleniumHelper sh, CenterPanelBase.Path path)
    {
        super(sh, path);
    }

    public FLHO4Coverages next()
    {
        super.coveragesNext();
        return new FLHO4Coverages(sh, path);
    }
    public FLHO4WindMitigation clickWindMitigation()
    {
        super.windMitigation();
        return new FLHO4WindMitigation(sh,path);
    }
    public FLHO4DwellingConstruction setRoofYear(String text)
    {
        return super.setRoofYear(text);
    }

    public String getRoofYear()
    {
        return super.getRoofYear();
    }
    public FLHO4DwellingConstruction setValuationType(String text)
    {
        return super.setValuationType(text);
    }

    public String getValuationType()
    {
        return super.getValuationType();
    }
    public FLHO4DwellingConstruction setEstimatedReplacementCost(String text)
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
    public FLHO4DwellingConstruction setConstructionType(String text)
    {
        return super.setConstructionType(text);
    }
    public FLHO4DwellingConstruction dwellingConstructionEnter(){return super.dwellingConstructionEnter();}

    public String getConstructionType()
    {
        return super.getConstructionType();
    }
    public FLHO4DwellingConstruction setNumberOfUnits(String text)
    {
        return super.setNumberOfUnits(text);
    }
    public String getNumberOfUnits()
    {
        return super.getNumberOfUnits();
    }
    public FLHO4DwellingConstruction setUnitsInFireWall(String text)
    {
        return super.setUnitsInFireWall(text);
    }

    public String getUnitsInFireWall()
    {
        return super.getUnitsInFireWall();
    }
    public FLHO4DwellingConstruction setNumberOfStories(String text)
    {
        return super.setNumberOfStories(text);
    }

    public String getNumberOfStories()
    {
        return super.getNumberOfStories();
    }
    public FLHO4DwellingConstruction setSquareFootage(String text)
    {
        return super.setSquareFootage(text);
    }

    public String getSquareFootage()
    {
        return super.getSquareFootage();
    }
    public FLHO4DwellingConstruction setFoundationType(String text)
    {
        return super.setFoundationType(text);
    }

    public String getFoundationType()
    {
        return super.getFoundationType();
    }
    public FLHO4DwellingConstruction setPrimaryHeating(String text)
    {
        return super.setPrimaryHeating(text);
    }

    public String getPrimaryHeating()
    {
        return super.getPrimaryHeating();
    }
    public FLHO4DwellingConstruction setPlumbing(String text)
    {
        return super.setPlumbing(text);
    }

    public String getPlumbing()
    {
        return super.getPlumbing();
    }
    public FLHO4DwellingConstruction setPlumbingYear(String text)
    {
        return super.setPlumbingYear(text);
    }

    public String getPlumbingYear()
    {
        return super.getPlumbingYear();
    }
    public FLHO4DwellingConstruction setWaterHeaterYear(String text)
    {
        return super.setWaterHeaterYear(text);
    }

    public String getWaterHeaterYear()
    {
        return super.getWaterHeaterYear();
    }
    public FLHO4DwellingConstruction setWiring(String text)
    {
        return super.setWiring(text);
    }

    public String getWiring()
    {
        return super.getWiring();
    }
    public FLHO4DwellingConstruction setElectricalSystem(String text)
    {
        return super.setElectricalSystem(text);
    }

    public String gettElectricalSystem()
    {
        return super.getElectricalSystem();
    }
    public FLHO4DwellingConstruction setRoofType(String text)
    {
        return super.setRoofType(text);
    }

    public String getRoofType()
    {
        return super.getRoofType();
    }
    public FLHO4DwellingConstruction setConditionOfRoof(String text)
    {
        return super.setConditionOfRoof(text);
    }

    public String getConditionOfRoof()
    {
        return super.getConditionOfRoof();
    }
    public FLHO4DwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
    {
        return super.setIsThereASecondaryHeatingSystem(flag);
    }
    public FLHO4DwellingConstruction setElectricalSystemDescribeOther(String text)
    {
        return super.setElectricalSystemDescribeOther(text);
    }

    public FLHO4Dwelling back()
    {
        super.dwellingBack();
        return new FLHO4Dwelling(sh,path);
    }
    public String getElectricalSystemDescribeOther()
    {
        return super.getElectricalSystemDescribeOther();
    }
    public FLHO4DwellingConstruction setRoofTypeDescription(String text)
    {
        return super.setRoofTypeDescription(text);
    }

    public String getRoofTypeDescription()
    {
        return super.getRoofTypeDescription();
    }
    public FLHO4Quote clickDwellingconstructionQuote(){
        super.DwellingconstructionQuote();
        return new FLHO4Quote(sh,path);
    }
    public FLHO4DwellingConstruction setPlumbingDescribeOther(String text)
    {
        return super.setPlumbingDescribeOther(text);
    }

    public String getPlumbingDescribeOther()
    {
        return super.getPlumbingDescribeOther();
    }
    public FLHO4DwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
    {
        return super.setPlumbingSystemHaveKnownLeaks(flag);
    }
    public FLHO4DwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakes(flag);
    }
    public FLHO4DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolations(flag);
    }
    public FLHO4DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
    }
    public FLHO4DwellingConstruction setLeadPaintHazard(String flag)
    {
        return super.setLeadPaintHazard(flag);
    }
    public FLHO4DwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
    {
        return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
    }
    public FLHO4DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakesDescription(flag);
    }
    public FLHO4DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
    }
    public FLHO4DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
    }
    public FLHO4DwellingConstruction setLeadPaintHazardDescription(String flag)
    {
        return super.setLeadPaintHazardDescription(flag);
    }
    public FLHO4DwellingConstruction setScreenEnclosureOnPremises(String flag)
    {
        return super.setScreenEnclosureOnPremises(flag);
    }

    public class FLHO4WindMitigation extends WindMitigation<FLHO4WindMitigation>
    {
        public FLHO4WindMitigation(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public FLHO4DwellingConstruction clickDetails()
        {
            super.clickDetailsTab();
            return new FLHO4DwellingConstruction(sh, path);
        }
        public FLHO4Coverages next()
        {
            super.coveragesNext();
            return new FLHO4Coverages(sh,path);
        }
        public FLHO4Coverages doubleClickNext()
        {
            super.doubleClickCoveragesNext();
            return new FLHO4Coverages(sh, path);
        }
        public FLHO4WindMitigation setRoofShapeType(String text)
        {
            return super.setRoofShapeType(text);
        }

        public String getRoofShapeType()
        {
            return super.getRoofShapeType();
        }
        public FLHO4WindMitigation setDiscountType(String text)
        {
            return super.setDiscountType(text);
        }

        public String getDiscountType()
        {
            return super.getDiscountType();
        }
        public FLHO4WindMitigation setFortifiedHomeType(String text)
        {
            return super.setFortifiedHomeType(text);
        }

        public FLHO4WindMitigation clickwindmitigationsaveDraft(){return super.clickWindMitigationSaveDraft();}
        public String getFortifiedHomeType()
        {
            return super.getFortifiedHomeType();
        }
        public FLHO4WindMitigation setOpeningProtectionType(String text)
        {
            return super.setOpeningProtectionType(text);
        }

        public String getOpeningProtectionType()
        {
            return super.getOpeningProtectionType();
        }
        public FLHO4WindMitigation setTerrain(String text)
        {
            return super.setTerrain(text);
        }

        public String getTerrain()
        {
            return super.getTerrain();
        }
        public FLHO4WindMitigation setRoofCover(String text)
        {
            return super.setRoofCover(text);
        }

        public FLHO4Dwelling winddwellingback()
        {
            super.WinddwellingBack();
            return new FLHO4Dwelling(sh,path);
        }


        public String getRoofCover()
        {
            return super.getRoofCover();
        }
        public FLHO4WindMitigation setRoofDeckAttachment(String text)
        {
            return super.setRoofDeckAttachment(text);
        }

        public String getRoofDeckAttachment()
        {
            return super.getRoofDeckAttachment();
        }
        public FLHO4WindMitigation setRoofWallConnection(String text)
        {
            return super.setRoofWallConnection(text);
        }

        public String getRoofWallConnection()
        {
            return super.getRoofWallConnection();
        }
        public FLHO4WindMitigation setSecondaryWaterResistance(String flag)
        {
            return super.setSecondaryWaterResistance(flag);
        }
        public FLHO4WindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
        }
        public FLHO4WindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
        }
        public FLHO4WindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
        }
        public FLHO4WindMitigation setRoofDeck(String text)
        {
            return super.setRoofDeck(text);
        }

        public String getRoofDeck()
        {
            return super.getRoofDeck();
        }
        public FLHO4WindMitigation setFbcWindSpeed(String text)
        {
            return super.setFbcWindSpeed(text);
        }

        public String getFbcWindSpeed()
        {
            return super.getFbcWindSpeed();
        }
        public FLHO4WindMitigation setInternalPressure(String text)
        {
            return super.setInternalPressure(text);
        }

        public String getInternalPressure()
        {
            return super.getInternalPressure();
        }

        public FLHO4WindMitigation setWindBorneDebris(String flag)
        {
            return super.setWindBorneDebris(flag);
        }
















    }
}
