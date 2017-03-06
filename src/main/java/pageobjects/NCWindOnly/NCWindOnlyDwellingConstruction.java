package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyDwellingConstruction extends DwellingConstruction<NCWindOnlyDwellingConstruction> {
    public NCWindOnlyDwellingConstruction(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyCoverages next()
    {
        super.coveragesNext();
        return new NCWindOnlyCoverages(sh, path);
    }
    public NCWindOnlyWindMitigation clickWindMitigation()
    {
        super.windMitigation();
        return new NCWindOnlyWindMitigation(sh,path);
    }
    public NCWindOnlyDwellingConstruction setRoofYear(String text)
    {
        return super.setRoofYear(text);
    }

    public String getRoofYear()
    {
        return super.getRoofYear();
    }
    public NCWindOnlyDwellingConstruction setValuationType(String text)
    {
        return super.setValuationType(text);
    }

    public String getValuationType()
    {
        return super.getValuationType();
    }
    public NCWindOnlyDwellingConstruction setEstimatedReplacementCost(String text)
    {
        return super.setEstimatedReplacementCost(text);
    }
    public NCWindOnlyDwelling back()
    {
        super.dwellingBack();
        return new NCWindOnlyDwelling(sh,path);
    }

    public String dwellingConstructionErrorMessage()
    {
        return super.dwellingConstructionErrorMessage();
    }
    public NCWindOnlyDwellingConstruction dwellingConstructionEnter(){return super.dwellingConstructionEnter();}
    public String getEstimatedReplacementCost()
    {
        return super.getEstimatedReplacementCost();
    }
    public NCWindOnlyDwellingConstruction setConstructionType(String text)
    {
        return super.setConstructionType(text);
    }

    public String getConstructionType()
    {
        return super.getConstructionType();
    }
    public NCWindOnlyDwellingConstruction setNumberOfUnits(String text)
    {
        return super.setNumberOfUnits(text);
    }
    public String getNumberOfUnits()
    {
        return super.getNumberOfUnits();
    }
    public NCWindOnlyDwellingConstruction setUnitsInFireWall(String text)
    {
        return super.setUnitsInFireWall(text);
    }

    public String getUnitsInFireWall()
    {
        return super.getUnitsInFireWall();
    }
    public NCWindOnlyDwellingConstruction setNumberOfStories(String text)
    {
        return super.setNumberOfStories(text);
    }

    public String getNumberOfStories()
    {
        return super.getNumberOfStories();
    }
    public NCWindOnlyDwellingConstruction setSquareFootage(String text)
    {
        return super.setSquareFootage(text);
    }

    public String getSquareFootage()
    {
        return super.getSquareFootage();
    }
    public NCWindOnlyDwellingConstruction setFoundationType(String text)
    {
        return super.setFoundationType(text);
    }

    public String getFoundationType()
    {
        return super.getFoundationType();
    }
    public NCWindOnlyDwellingConstruction setPrimaryHeating(String text)
    {
        return super.setPrimaryHeating(text);
    }

    public String getPrimaryHeating()
    {
        return super.getPrimaryHeating();
    }
    public NCWindOnlyDwellingConstruction setPlumbing(String text)
    {
        return super.setPlumbing(text);
    }

    public String getPlumbing()
    {
        return super.getPlumbing();
    }
    public NCWindOnlyDwellingConstruction setPlumbingYear(String text)
    {
        return super.setPlumbingYear(text);
    }

    public String getPlumbingYear()
    {
        return super.getPlumbingYear();
    }
    public NCWindOnlyDwellingConstruction setWaterHeaterYear(String text)
    {
        return super.setWaterHeaterYear(text);
    }

    public String getWaterHeaterYear()
    {
        return super.getWaterHeaterYear();
    }
    public NCWindOnlyDwellingConstruction setWiring(String text)
    {
        return super.setWiring(text);
    }

    public String getWiring()
    {
        return super.getWiring();
    }
    public NCWindOnlyDwellingConstruction setElectricalSystem(String text)
    {
        return super.setElectricalSystem(text);
    }

    public String gettElectricalSystem()
    {
        return super.getElectricalSystem();
    }
    public NCWindOnlyDwellingConstruction setRoofType(String text)
    {
        return super.setRoofType(text);
    }

    public String getRoofType()
    {
        return super.getRoofType();
    }
    public NCWindOnlyDwellingConstruction setConditionOfRoof(String text)
    {
        return super.setConditionOfRoof(text);
    }

    public String getConditionOfRoof()
    {
        return super.getConditionOfRoof();
    }
    public NCWindOnlyDwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
    {
        return super.setIsThereASecondaryHeatingSystem(flag);
    }
    public NCWindOnlyDwellingConstruction setElectricalSystemDescribeOther(String text)
    {
        return super.setElectricalSystemDescribeOther(text);
    }

    public String getElectricalSystemDescribeOther()
    {
        return super.getElectricalSystemDescribeOther();
    }
    public NCWindOnlyDwellingConstruction setRoofTypeDescription(String text)
    {
        return super.setRoofTypeDescription(text);
    }

    public String getRoofTypeDescription()
    {
        return super.getRoofTypeDescription();
    }
    public NCWindOnlyDwellingConstruction setPlumbingDescribeOther(String text)
    {
        return super.setPlumbingDescribeOther(text);
    }

    public String getPlumbingDescribeOther()
    {
        return super.getPlumbingDescribeOther();
    }
    public NCWindOnlyDwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
    {
        return super.setPlumbingSystemHaveKnownLeaks(flag);
    }
    public NCWindOnlyDwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakes(flag);
    }
    public NCWindOnlyDwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolations(flag);
    }
    public NCWindOnlyDwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
    }
    public NCWindOnlyDwellingConstruction setLeadPaintHazard(String flag)
    {
        return super.setLeadPaintHazard(flag);
    }
    public NCWindOnlyDwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
    {
        return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
    }
    public NCWindOnlyDwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakesDescription(flag);
    }
    public NCWindOnlyDwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
    }
    public NCWindOnlyDwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
    }
    public NCWindOnlyDwellingConstruction setLeadPaintHazardDescription(String flag)
    {
        return super.setLeadPaintHazardDescription(flag);
    }
    public NCWindOnlyDwellingConstruction setScreenEnclosureOnPremises(String flag)
    {
        return super.setScreenEnclosureOnPremises(flag);
    }

    public class NCWindOnlyWindMitigation extends WindMitigation<NCWindOnlyWindMitigation>
    {
        public NCWindOnlyWindMitigation(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public NCWindOnlyDwellingConstruction clickDetails()
        {
            super.clickDetailsTab();
            return new NCWindOnlyDwellingConstruction(sh, path);
        }
        public NCWindOnlyCoverages next()
        {
            super.coveragesNext();
            return new NCWindOnlyCoverages(sh,path);
        }
        public NCWindOnlyCoverages doubleClickNext()
        {
            super.doubleClickCoveragesNext();
            return new NCWindOnlyCoverages(sh, path);
        }
        public NCWindOnlyWindMitigation setRoofShapeType(String text)
        {
            return super.setRoofShapeType(text);
        }

        public String getRoofShapeType()
        {
            return super.getRoofShapeType();
        }
        public NCWindOnlyWindMitigation setDiscountType(String text)
        {
            return super.setDiscountType(text);
        }

        public String getDiscountType()
        {
            return super.getDiscountType();
        }
        public NCWindOnlyWindMitigation setFortifiedHomeType(String text)
        {
            return super.setFortifiedHomeType(text);
        }

        public String getFortifiedHomeType()
        {
            return super.getFortifiedHomeType();
        }
        public NCWindOnlyWindMitigation setOpeningProtectionType(String text)
        {
            return super.setOpeningProtectionType(text);
        }

        public String getOpeningProtectionType()
        {
            return super.getOpeningProtectionType();
        }
        public NCWindOnlyWindMitigation setTerrain(String text)
        {
            return super.setTerrain(text);
        }

        public String getTerrain()
        {
            return super.getTerrain();
        }
        public NCWindOnlyWindMitigation setRoofCover(String text)
        {
            return super.setRoofCover(text);
        }

        public String getRoofCover()
        {
            return super.getRoofCover();
        }
        public NCWindOnlyWindMitigation setRoofDeckAttachment(String text)
        {
            return super.setRoofDeckAttachment(text);
        }

        public String getRoofDeckAttachment()
        {
            return super.getRoofDeckAttachment();
        }
        public NCWindOnlyWindMitigation setRoofWallConnection(String text)
        {
            return super.setRoofWallConnection(text);
        }

        public NCWindOnlyDwelling winddwellingback()
        {
            super.WinddwellingBack();
            return new NCWindOnlyDwelling(sh,path);
        }

        public String getRoofWallConnection()
        {
            return super.getRoofWallConnection();
        }
        public NCWindOnlyWindMitigation setSecondaryWaterResistance(String flag)
        {
            return super.setSecondaryWaterResistance(flag);
        }
        public NCWindOnlyWindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
        }
        public NCWindOnlyWindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
        }
        public NCWindOnlyWindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
        }
        public NCWindOnlyWindMitigation setRoofDeck(String text)
        {
            return super.setRoofDeck(text);
        }

        public String getRoofDeck()
        {
            return super.getRoofDeck();
        }
        public NCWindOnlyWindMitigation setFbcWindSpeed(String text)
        {
            return super.setFbcWindSpeed(text);
        }

        public String getFbcWindSpeed()
        {
            return super.getFbcWindSpeed();
        }
        public NCWindOnlyWindMitigation setInternalPressure(String text)
        {
            return super.setInternalPressure(text);
        }

        public String getInternalPressure()
        {
            return super.getInternalPressure();
        }

        public NCWindOnlyWindMitigation setWindBorneDebris(String flag)
        {
            return super.setWindBorneDebris(flag);
        }
















    }
}
