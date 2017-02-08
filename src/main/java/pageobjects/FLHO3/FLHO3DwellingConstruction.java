package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3DwellingConstruction extends DwellingConstruction<FLHO3DwellingConstruction>
{
	public FLHO3DwellingConstruction(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3Coverages next()
	{
		super.coveragesNext();
		return new FLHO3Coverages(sh, path);
	}
	public FLHO3WindMitigation clickWindMitigation()
	{
		super.windMitigation();
		return new FLHO3WindMitigation(sh,path);
	}
	public FLHO3DwellingConstruction setRoofYear(String text)
	{
		return super.setRoofYear(text);
	}

	public String getRoofYear()
	{
		return super.getRoofYear();
	}
	public FLHO3DwellingConstruction setValuationType(String text)
	{
		return super.setValuationType(text);
	}

	public String getValuationType()
	{
		return super.getValuationType();
	}
	public FLHO3DwellingConstruction setEstimatedReplacementCost(String text)
	{
		return super.setEstimatedReplacementCost(text);
	}

	public String getEstimatedReplacementCost()
	{
		return super.getEstimatedReplacementCost();
	}
	public FLHO3DwellingConstruction setConstructionType(String text)
	{
		return super.setConstructionType(text);
	}

	public String getConstructionType()
	{
		return super.getConstructionType();
	}
	public FLHO3DwellingConstruction setNumberOfUnits(String text)
	{
		return super.setNumberOfUnits(text);
	}
	public String getNumberOfUnits()
	{
		return super.getNumberOfUnits();
	}
	public FLHO3DwellingConstruction setUnitsInFireWall(String text)
	{
		return super.setUnitsInFireWall(text);
	}

	public String getUnitsInFireWall()
	{
		return super.getUnitsInFireWall();
	}
	public FLHO3DwellingConstruction setNumberOfStories(String text)
	{
		return super.setNumberOfStories(text);
	}

	public String getNumberOfStories()
	{
		return super.getNumberOfStories();
	}
	public FLHO3DwellingConstruction setSquareFootage(String text)
	{
		return super.setSquareFootage(text);
	}

	public String getSquareFootage()
	{
		return super.getSquareFootage();
	}
	public FLHO3DwellingConstruction setFoundationType(String text)
	{
		return super.setFoundationType(text);
	}

	public String getFoundationType()
	{
		return super.getFoundationType();
	}
	public FLHO3DwellingConstruction setPrimaryHeating(String text)
	{
		return super.setPrimaryHeating(text);
	}

	public String getPrimaryHeating()
	{
		return super.getPrimaryHeating();
	}
	public FLHO3DwellingConstruction setPlumbing(String text)
	{
		return super.setPlumbing(text);
	}

	public String getPlumbing()
	{
		return super.getPlumbing();
	}
	public FLHO3DwellingConstruction setPlumbingYear(String text)
	{
		return super.setPlumbingYear(text);
	}

	public String getPlumbingYear()
	{
		return super.getPlumbingYear();
	}
	public FLHO3DwellingConstruction setWaterHeaterYear(String text)
	{
		return super.setWaterHeaterYear(text);
	}

	public String getWaterHeaterYear()
	{
		return super.getWaterHeaterYear();
	}
	public FLHO3DwellingConstruction setWiring(String text)
	{
		return super.setWiring(text);
	}

	public String getWiring()
	{
		return super.getWiring();
	}
	public FLHO3DwellingConstruction setElectricalSystem(String text)
	{
		return super.setElectricalSystem(text);
	}

	public String gettElectricalSystem()
	{
		return super.getElectricalSystem();
	}
	public FLHO3DwellingConstruction setRoofType(String text)
	{
		return super.setRoofType(text);
	}

	public String getRoofType()
	{
		return super.getRoofType();
	}
	public FLHO3DwellingConstruction setConditionOfRoof(String text)
	{
		return super.setConditionOfRoof(text);
	}

	public String getConditionOfRoof()
	{
		return super.getConditionOfRoof();
	}
	public FLHO3DwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
	{
		return super.setIsThereASecondaryHeatingSystem(flag);
	}
	public FLHO3DwellingConstruction setElectricalSystemDescribeOther(String text)
	{
		return super.setElectricalSystemDescribeOther(text);
	}

	public String getElectricalSystemDescribeOther()
	{
		return super.getElectricalSystemDescribeOther();
	}
	public FLHO3DwellingConstruction setRoofTypeDescription(String text)
	{
		return super.setRoofTypeDescription(text);
	}

	public String getRoofTypeDescription()
	{
		return super.getRoofTypeDescription();
	}
	public FLHO3DwellingConstruction setPlumbingDescribeOther(String text)
	{
		return super.setPlumbingDescribeOther(text);
	}

	public String getPlumbingDescribeOther()
	{
		return super.getPlumbingDescribeOther();
	}
	public FLHO3DwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
	{
		return super.setPlumbingSystemHaveKnownLeaks(flag);
	}
	public FLHO3DwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakes(flag);
	}
	public FLHO3DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolations(flag);
	}
	public FLHO3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
	}
	public FLHO3DwellingConstruction setLeadPaintHazard(String flag)
	{
		return super.setLeadPaintHazard(flag);
	}
	public FLHO3DwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
	{
		return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
	}
	public FLHO3DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakesDescription(flag);
	}
	public FLHO3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
	}
	public FLHO3DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
	}
	public FLHO3DwellingConstruction setLeadPaintHazardDescription(String flag)
	{
		return super.setLeadPaintHazardDescription(flag);
	}
	public FLHO3DwellingConstruction setScreenEnclosureOnPremises(String flag)
	{
		return super.setScreenEnclosureOnPremises(flag);
	}

	public class FLHO3WindMitigation extends WindMitigation<FLHO3WindMitigation>
	{
		public FLHO3WindMitigation(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public FLHO3DwellingConstruction clickDetails()
		{
			super.clickDetailsTab();
			return new FLHO3DwellingConstruction(sh, path);
		}
		public FLHO3Coverages next()
		{
			super.coveragesNext();
			return new FLHO3Coverages(sh,path);
		}
		public FLHO3Coverages doubleClickNext()
		{
			super.doubleClickCoveragesNext();
			return new FLHO3Coverages(sh, path);
		}
		public FLHO3WindMitigation setRoofShapeType(String text)
		{
			return super.setRoofShapeType(text);
		}

		public String getRoofShapeType()
		{
			return super.getRoofShapeType();
		}
		public FLHO3WindMitigation setDiscountType(String text)
		{
			return super.setDiscountType(text);
		}

		public String getDiscountType()
		{
			return super.getDiscountType();
		}
		public FLHO3WindMitigation setFortifiedHomeType(String text)
		{
			return super.setFortifiedHomeType(text);
		}

		public String getFortifiedHomeType()
		{
			return super.getFortifiedHomeType();
		}
		public FLHO3WindMitigation setOpeningProtectionType(String text)
		{
			return super.setOpeningProtectionType(text);
		}

		public String getOpeningProtectionType()
		{
			return super.getOpeningProtectionType();
		}
		public FLHO3WindMitigation setTerrain(String text)
		{
			return super.setTerrain(text);
		}

		public String getTerrain()
		{
			return super.getTerrain();
		}
		public FLHO3WindMitigation setRoofCover(String text)
		{
			return super.setRoofCover(text);
		}

		public String getRoofCover()
		{
			return super.getRoofCover();
		}
		public FLHO3WindMitigation setRoofDeckAttachment(String text)
		{
			return super.setRoofDeckAttachment(text);
		}

		public String getRoofDeckAttachment()
		{
			return super.getRoofDeckAttachment();
		}
		public FLHO3WindMitigation setRoofWallConnection(String text)
		{
			return super.setRoofWallConnection(text);
		}

		public String getRoofWallConnection()
		{
			return super.getRoofWallConnection();
		}
		public FLHO3WindMitigation setSecondaryWaterResistance(String flag)
		{
			return super.setSecondaryWaterResistance(flag);
		}
		public FLHO3WindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
		}
		public FLHO3WindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
		}
		public FLHO3WindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
		}
		public FLHO3WindMitigation setRoofDeck(String text)
		{
			return super.setRoofDeck(text);
		}

		public String getRoofDeck()
		{
			return super.getRoofDeck();
		}
		public FLHO3WindMitigation setFbcWindSpeed(String text)
		{
			return super.setFbcWindSpeed(text);
		}

		public String getFbcWindSpeed()
		{
			return super.getFbcWindSpeed();
		}
		public FLHO3WindMitigation setInternalPressure(String text)
		{
			return super.setInternalPressure(text);
		}

		public String getInternalPressure()
		{
			return super.getInternalPressure();
		}

		public FLHO3WindMitigation setWindBorneDebris(String flag)
		{
			return super.setWindBorneDebris(flag);
		}
















	}

}
