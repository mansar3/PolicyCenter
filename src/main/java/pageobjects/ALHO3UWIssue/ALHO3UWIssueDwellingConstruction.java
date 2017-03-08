package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueDwellingConstruction extends DwellingConstruction<ALHO3UWIssueDwellingConstruction> {

    public ALHO3UWIssueDwellingConstruction(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssueCoverages next()
    {
        super.coveragesNext();
        return new ALHO3UWIssueCoverages(sh, path);
    }
    public ALHO3WindMitigation clickWindMitigation()
    {
        super.windMitigation();
        return new ALHO3WindMitigation(sh,path);
    }
    public ALHO3UWIssueDwellingConstruction setRoofYear(String text)
    {
        return super.setRoofYear(text);
    }

    public String getRoofYear()
    {
        return super.getRoofYear();
    }
    public ALHO3UWIssueDwellingConstruction setValuationType(String text)
    {
        return super.setValuationType(text);
    }

    public String getValuationType()
    {
        return super.getValuationType();
    }
    public ALHO3UWIssueDwellingConstruction setEstimatedReplacementCost(String text)
    {
        return super.setEstimatedReplacementCost(text);
    }
    public ALHO3UWIssueDwelling back()
    {
        super.dwellingBack();
        return new ALHO3UWIssueDwelling(sh,path);
    }



    public String dwellingConstructionErrorMessage()
    {
        return super.dwellingConstructionErrorMessage();
    }

    public ALHO3UWIssueDwellingConstruction dwellingConstructionEnter(){return super.dwellingConstructionEnter();}

    public String getEstimatedReplacementCost()
    {
        return super.getEstimatedReplacementCost();
    }
    public ALHO3UWIssueDwellingConstruction setConstructionType(String text)
    {
        return super.setConstructionType(text);
    }

    public String getConstructionType()
    {
        return super.getConstructionType();
    }
    public ALHO3UWIssueDwellingConstruction setNumberOfUnits(String text)
    {
        return super.setNumberOfUnits(text);
    }
    public String getNumberOfUnits()
    {
        return super.getNumberOfUnits();
    }
    public ALHO3UWIssueDwellingConstruction setUnitsInFireWall(String text)
    {
        return super.setUnitsInFireWall(text);
    }

    public String getUnitsInFireWall()
    {
        return super.getUnitsInFireWall();
    }
    public ALHO3UWIssueDwellingConstruction setNumberOfStories(String text)
    {
        return super.setNumberOfStories(text);
    }

    public String getNumberOfStories()
    {
        return super.getNumberOfStories();
    }
    public ALHO3UWIssueDwellingConstruction setSquareFootage(String text)
    {
        return super.setSquareFootage(text);
    }

    public String getSquareFootage()
    {
        return super.getSquareFootage();
    }
    public ALHO3UWIssueDwellingConstruction setFoundationType(String text)
    {
        return super.setFoundationType(text);
    }

    public String getFoundationType()
    {
        return super.getFoundationType();
    }
    public ALHO3UWIssueDwellingConstruction setPrimaryHeating(String text)
    {
        return super.setPrimaryHeating(text);
    }

    public String getPrimaryHeating()
    {
        return super.getPrimaryHeating();
    }
    public ALHO3UWIssueDwellingConstruction setPlumbing(String text)
    {
        return super.setPlumbing(text);
    }

    public String getPlumbing()
    {
        return super.getPlumbing();
    }
    public ALHO3UWIssueDwellingConstruction setPlumbingYear(String text)
    {
        return super.setPlumbingYear(text);
    }

    public String getPlumbingYear()
    {
        return super.getPlumbingYear();
    }
    public ALHO3UWIssueDwellingConstruction setWaterHeaterYear(String text)
    {
        return super.setWaterHeaterYear(text);
    }

    public String getWaterHeaterYear()
    {
        return super.getWaterHeaterYear();
    }
    public ALHO3UWIssueDwellingConstruction setWiring(String text)
    {
        return super.setWiring(text);
    }

    public String getWiring()
    {
        return super.getWiring();
    }
    public ALHO3UWIssueDwellingConstruction setElectricalSystem(String text)
    {
        return super.setElectricalSystem(text);
    }

    public String gettElectricalSystem()
    {
        return super.getElectricalSystem();
    }
    public ALHO3UWIssueDwellingConstruction setRoofType(String text)
    {
        return super.setRoofType(text);
    }

    public String getRoofType()
    {
        return super.getRoofType();
    }
    public ALHO3UWIssueDwellingConstruction setConditionOfRoof(String text)
    {
        return super.setConditionOfRoof(text);
    }

    public String getConditionOfRoof()
    {
        return super.getConditionOfRoof();
    }
    public ALHO3UWIssueDwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
    {
        return super.setIsThereASecondaryHeatingSystem(flag);
    }
    public ALHO3UWIssueDwellingConstruction setElectricalSystemDescribeOther(String text)
    {
        return super.setElectricalSystemDescribeOther(text);
    }

    public String getElectricalSystemDescribeOther()
    {
        return super.getElectricalSystemDescribeOther();
    }
    public ALHO3UWIssueDwellingConstruction setRoofTypeDescription(String text)
    {
        return super.setRoofTypeDescription(text);
    }

    public String getRoofTypeDescription()
    {
        return super.getRoofTypeDescription();
    }
    public ALHO3UWIssueDwellingConstruction setPlumbingDescribeOther(String text)
    {
        return super.setPlumbingDescribeOther(text);
    }

    public String getPlumbingDescribeOther()
    {
        return super.getPlumbingDescribeOther();
    }
    public ALHO3UWIssueDwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
    {
        return super.setPlumbingSystemHaveKnownLeaks(flag);
    }
    public ALHO3UWIssueDwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakes(flag);
    }
    public ALHO3UWIssueDwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolations(flag);
    }
    public ALHO3UWIssueDwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
    }
    public ALHO3UWIssueDwellingConstruction setLeadPaintHazard(String flag)
    {
        return super.setLeadPaintHazard(flag);
    }
    public ALHO3UWIssueDwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
    {
        return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
    }
    public ALHO3UWIssueDwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
    {
        return super.setBuildingRetrofittedForEarthquakesDescription(flag);
    }
    public ALHO3UWIssueDwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
    {
        return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
    }
    public ALHO3UWIssueDwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
    {
        return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
    }
    public ALHO3UWIssueDwellingConstruction setLeadPaintHazardDescription(String flag)
    {
        return super.setLeadPaintHazardDescription(flag);
    }
    public ALHO3UWIssueDwellingConstruction setScreenEnclosureOnPremises(String flag)
    {
        return super.setScreenEnclosureOnPremises(flag);
    }

    public class ALHO3WindMitigation extends WindMitigation<ALHO3WindMitigation>
    {
        public ALHO3WindMitigation(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public ALHO3UWIssueDwellingConstruction clickDetails()
        {
            super.clickDetailsTab();
            return new ALHO3UWIssueDwellingConstruction(sh, path);
        }
        public ALHO3UWIssueCoverages next()
        {
            super.coveragesNext();
            return new ALHO3UWIssueCoverages(sh,path);
        }
        public ALHO3UWIssueCoverages doubleClickNext()
        {
            super.doubleClickCoveragesNext();
            return new ALHO3UWIssueCoverages(sh, path);
        }
        public ALHO3WindMitigation setRoofShapeType(String text)
        {
            return super.setRoofShapeType(text);
        }

        public String dwellingConstructionWindMitigationErrorMessage()
        {
            return super.dwellingConstructionWingMitigationErrorMessage();
        }

        public String getRoofShapeType()
        {
            return super.getRoofShapeType();
        }
        public ALHO3WindMitigation setDiscountType(String text)
        {
            return super.setDiscountType(text);
        }

        public String getDiscountType()
        {
            return super.getDiscountType();
        }
        public ALHO3WindMitigation setFortifiedHomeType(String text)
        {
            return super.setFortifiedHomeType(text);
        }

        public String getFortifiedHomeType()
        {
            return super.getFortifiedHomeType();
        }
        public ALHO3WindMitigation setOpeningProtectionType(String text)
        {
            return super.setOpeningProtectionType(text);
        }

        public String getOpeningProtectionType()
        {
            return super.getOpeningProtectionType();
        }
        public ALHO3WindMitigation setTerrain(String text)
        {
            return super.setTerrain(text);
        }

        public String getTerrain()
        {
            return super.getTerrain();
        }
        public ALHO3WindMitigation setRoofCover(String text)
        {
            return super.setRoofCover(text);
        }

        public String getRoofCover()
        {
            return super.getRoofCover();
        }
        public ALHO3WindMitigation setRoofDeckAttachment(String text)
        {
            return super.setRoofDeckAttachment(text);
        }

        public String getRoofDeckAttachment()
        {
            return super.getRoofDeckAttachment();
        }
        public ALHO3WindMitigation setRoofWallConnection(String text)
        {
            return super.setRoofWallConnection(text);
        }

        public String getRoofWallConnection()
        {
            return super.getRoofWallConnection();
        }
        public ALHO3WindMitigation setSecondaryWaterResistance(String flag)
        {
            return super.setSecondaryWaterResistance(flag);
        }
        public ALHO3WindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
        }
        public ALHO3WindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
        }
        public ALHO3WindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag)
        {
            return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
        }
        public ALHO3WindMitigation setRoofDeck(String text)
        {
            return super.setRoofDeck(text);
        }

        public String getRoofDeck()
        {
            return super.getRoofDeck();
        }
        public ALHO3WindMitigation setFbcWindSpeed(String text)
        {
            return super.setFbcWindSpeed(text);
        }

        public String getFbcWindSpeed()
        {
            return super.getFbcWindSpeed();
        }
        public ALHO3WindMitigation setInternalPressure(String text)
        {
            return super.setInternalPressure(text);
        }

        public String getInternalPressure()
        {
            return super.getInternalPressure();
        }

        public ALHO3WindMitigation setWindBorneDebris(String flag)
        {
            return super.setWindBorneDebris(flag);
        }
















    }
}
