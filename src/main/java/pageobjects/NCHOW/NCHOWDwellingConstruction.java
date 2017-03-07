package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWDwellingConstruction extends DwellingConstruction<NCHOWDwellingConstruction> {
    public NCHOWDwellingConstruction(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWCoverages next()
    {
        super.coveragesNext();
        return new NCHOWCoverages(sh, path);
    }
    public NCHOWWindMitigation clickWindMitigation()
    {
        super.windMitigation();
        return new NCHOWWindMitigation(sh,path);
    }
    public NCHOWDwellingConstruction setRoofYear(String text)
    {
        return super.setRoofYear(text);
    }

    public String getRoofYear()
    {
        return super.getRoofYear();
    }
    public NCHOWDwellingConstruction setValuationType(String text)
    {
        return super.setValuationType(text);
    }

    public String getValuationType()
    {
        return super.getValuationType();
    }
    public NCHOWDwellingConstruction setEstimatedReplacementCost(String text)
    {
        return super.setEstimatedReplacementCost(text);
    }
    public NCHOWDwelling back()
    {
        super.dwellingBack();
        return new NCHOWDwelling(sh,path);
    }

    public String dwellingConstructionErrorMessage()
    {
        return super.dwellingConstructionErrorMessage();
    }
    public NCHOWDwellingConstruction dwellingConstructionEnter(){return super.dwellingConstructionEnter();}
    public String getEstimatedReplacementCost()
    {
        return super.getEstimatedReplacementCost();
    }
    public NCHOWDwellingConstruction setConstructionType(String text)
    {
        return super.setConstructionType(text);
    }

    public String getConstructionType()
    {
        return super.getConstructionType();
    }
    public NCHOWDwellingConstruction setNumberOfUnits(String text)
    {
        return super.setNumberOfUnits(text);
    }
    public String getNumberOfUnits()
    {
        return super.getNumberOfUnits();
    }
    public NCHOWDwellingConstruction setUnitsInFireWall(String text)
    {
        return super.setUnitsInFireWall(text);
    }

    public String getUnitsInFireWall()
    {
        return super.getUnitsInFireWall();
    }
    public NCHOWDwellingConstruction setNumberOfStories(String text)
    {
        return super.setNumberOfStories(text);
    }

    public String getNumberOfStories()
    {
        return super.getNumberOfStories();
    }
    public NCHOWDwellingConstruction setSquareFootage(String text)
    {
        return super.setSquareFootage(text);
    }

    public String getSquareFootage()
    {
        return super.getSquareFootage();
    }
    public NCHOWDwellingConstruction setFoundationType(String text)
    {
        return super.setFoundationType(text);
    }

    public String getFoundationType()
    {
        return super.getFoundationType();
    }
    public NCHOWDwellingConstruction setPrimaryHeating(String text)
    {
        return super.setPrimaryHeating(text);
    }

    public String getPrimaryHeating()
    {
        return super.getPrimaryHeating();
    }
    public NCHOWDwellingConstruction setPlumbing(String text)
    {
        return super.setPlumbing(text);
    }

    public String getPlumbing()
    {
        return super.getPlumbing();
    }
    public NCHOWDwellingConstruction setPlumbingYear(String text)
    {
        return super.setPlumbingYear(text);
    }

    public String getPlumbingYear()
    {
        return super.getPlumbingYear();
    }
    public NCHOWDwellingConstruction setWaterHeaterYear(String text)
    {
        return super.setWaterHeaterYear(text);
    }

    public String getWaterHeaterYear()
    {
        return super.getWaterHeaterYear();
    }
    public NCHOWDwellingConstruction setWiring(String text)
    {
        return super.setWiring(text);
    }

    public String getWiring()
    {
        return super.getWiring();
    }
    public NCHOWDwellingConstruction setElectricalSystem(String text)
    {
        return super.setElectricalSystem(text);
    }

    public String gettElectricalSystem()
    {
        return super.getElectricalSystem();
    }
    public NCHOWDwellingConstruction setRoofType(String text)
    {
        return super.setRoofType(text);
    }

    public String getRoofType()
    {
        return super.getRoofType();
    }
    public NCHOWDwellingConstruction setConditionOfRoof(String text)
    {
        return super.setConditionOfRoof(text);
    }

    public String getConditionOfRoof()
    {
        return super.getConditionOfRoof();
    }
    public NCHOWDwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
    {
        return super.setIsThereASecondaryHeatingSystem(flag);
    }
    public NCHOWDwellingConstruction setElectricalSystemDescribeOther(String text)
    {
        return super.setElectricalSystemDescribeOther(text);
    }

    public String getElectricalSystemDescribeOther()
    {
        return super.getElectricalSystemDescribeOther();
    }
    public NCHOWDwellingConstruction setRoofTypeDescription(String text)
    {
        return super.setRoofTypeDescription(text);
    }

    public String getRoofTypeDescription()
    {
        return super.getRoofTypeDescription();
    }
    public NCHOWDwellingConstruction setPlumbingDescribeOther(String text)
    {
        return super.setPlumbingDescribeOther(text);
    }

    public String getPlumbingDescribeOther()
    {
        return super.getPlumbingDescribeOther();
    }
    public NCHOWDwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
    {
        return super.setPlumbingSystemHaveKnownLeaks(flag);
    }
    public NCHOWDwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakes(flag);
    }
    public NCHOWDwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolations(flag);
    }
    public NCHOWDwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
    }
    public NCHOWDwellingConstruction setLeadPaintHazard(String flag)
    {
        return super.setLeadPaintHazard(flag);
    }
    public NCHOWDwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
    {
        return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
    }
    public NCHOWDwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakesDescription(flag);
    }
    public NCHOWDwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
    }
    public NCHOWDwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
    }
    public NCHOWDwellingConstruction setLeadPaintHazardDescription(String flag)
    {
        return super.setLeadPaintHazardDescription(flag);
    }
    public NCHOWDwellingConstruction setScreenEnclosureOnPremises(String flag)
    {
        return super.setScreenEnclosureOnPremises(flag);
    }

    public class NCHOWWindMitigation extends WindMitigation<NCHOWWindMitigation>
    {
        public NCHOWWindMitigation(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public NCHOWDwellingConstruction clickDetails()
        {
            super.clickDetailsTab();
            return new NCHOWDwellingConstruction(sh, path);
        }
        public NCHOWCoverages next()
        {
            super.coveragesNext();
            return new NCHOWCoverages(sh,path);
        }
        public NCHOWCoverages doubleClickNext()
        {
            super.doubleClickCoveragesNext();
            return new NCHOWCoverages(sh, path);
        }
        public NCHOWWindMitigation setRoofShapeType(String text)
        {
            return super.setRoofShapeType(text);
        }

        public String getRoofShapeType()
        {
            return super.getRoofShapeType();
        }
        public NCHOWWindMitigation setDiscountType(String text)
        {
            return super.setDiscountType(text);
        }

        public String getDiscountType()
        {
            return super.getDiscountType();
        }
        public NCHOWWindMitigation setFortifiedHomeType(String text)
        {
            return super.setFortifiedHomeType(text);
        }

        public String getFortifiedHomeType()
        {
            return super.getFortifiedHomeType();
        }
        public NCHOWWindMitigation setOpeningProtectionType(String text)
        {
            return super.setOpeningProtectionType(text);
        }

        public String getOpeningProtectionType()
        {
            return super.getOpeningProtectionType();
        }
        public NCHOWWindMitigation setTerrain(String text)
        {
            return super.setTerrain(text);
        }

        public String getTerrain()
        {
            return super.getTerrain();
        }
        public NCHOWWindMitigation setRoofCover(String text)
        {
            return super.setRoofCover(text);
        }

        public String getRoofCover()
        {
            return super.getRoofCover();
        }
        public NCHOWWindMitigation setRoofDeckAttachment(String text)
        {
            return super.setRoofDeckAttachment(text);
        }

        public String getRoofDeckAttachment()
        {
            return super.getRoofDeckAttachment();
        }
        public NCHOWWindMitigation setRoofWallConnection(String text)
        {
            return super.setRoofWallConnection(text);
        }

        public NCHOWDwelling winddwellingback()
        {
            super.WinddwellingBack();
            return new NCHOWDwelling(sh,path);
        }

        public String getRoofWallConnection()
        {
            return super.getRoofWallConnection();
        }
        public NCHOWWindMitigation setSecondaryWaterResistance(String flag)
        {
            return super.setSecondaryWaterResistance(flag);
        }
        public NCHOWWindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
        }
        public NCHOWWindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
        }
        public NCHOWWindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
        }
        public NCHOWWindMitigation setRoofDeck(String text)
        {
            return super.setRoofDeck(text);
        }

        public String getRoofDeck()
        {
            return super.getRoofDeck();
        }
        public NCHOWWindMitigation setFbcWindSpeed(String text)
        {
            return super.setFbcWindSpeed(text);
        }

        public String getFbcWindSpeed()
        {
            return super.getFbcWindSpeed();
        }
        public NCHOWWindMitigation setInternalPressure(String text)
        {
            return super.setInternalPressure(text);
        }

        public String getInternalPressure()
        {
            return super.getInternalPressure();
        }

        public NCHOWWindMitigation setWindBorneDebris(String flag)
        {
            return super.setWindBorneDebris(flag);
        }
















    }
}
