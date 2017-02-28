package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3DwellingConstruction extends DwellingConstruction<FLDP3DwellingConstruction>
{
	public FLDP3DwellingConstruction(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3Coverages next()
	{
		super.coveragesNext();
		return new FLDP3Coverages(sh, path);
	}
	public FLDP3WindMitigation clickWindMitigation()
	{
		super.windMitigation();
		return new FLDP3WindMitigation(sh,path);
	}
	public FLDP3DwellingConstruction setRoofYear(String text)
	{
		return super.setRoofYear(text);
	}

	public String getRoofYear()
	{
		return super.getRoofYear();
	}
	public FLDP3DwellingConstruction setValuationType(String text)
	{
		return super.setValuationType(text);
	}

	public String getValuationType()
	{
		return super.getValuationType();
	}
	public FLDP3DwellingConstruction setEstimatedReplacementCost(String text)
	{
		return super.setEstimatedReplacementCost(text);
	}

	public String getEstimatedReplacementCost()
	{
		return super.getEstimatedReplacementCost();
	}
	public FLDP3DwellingConstruction setConstructionType(String text)
	{
		return super.setConstructionType(text);
	}

	public String getConstructionType()
	{
		return super.getConstructionType();
	}
	public FLDP3DwellingConstruction setNumberOfUnits(String text)
	{
		return super.setNumberOfUnits(text);
	}
	public String getNumberOfUnits()
	{
		return super.getNumberOfUnits();
	}
	public FLDP3DwellingConstruction setUnitsInFireWall(String text)
	{
		return super.setUnitsInFireWall(text);
	}

	public String getUnitsInFireWall()
	{
		return super.getUnitsInFireWall();
	}
	public FLDP3DwellingConstruction setNumberOfStories(String text)
	{
		return super.setNumberOfStories(text);
	}

	public String getNumberOfStories()
	{
		return super.getNumberOfStories();
	}
	public FLDP3DwellingConstruction setSquareFootage(String text)
	{
		return super.setSquareFootage(text);
	}

	public String getSquareFootage()
	{
		return super.getSquareFootage();
	}
	public FLDP3DwellingConstruction setFoundationType(String text)
	{
		return super.setFoundationType(text);
	}

	public String getFoundationType()
	{
		return super.getFoundationType();
	}
	public FLDP3DwellingConstruction setPrimaryHeating(String text)
	{
		return super.setPrimaryHeating(text);
	}

	public String getPrimaryHeating()
	{
		return super.getPrimaryHeating();
	}
	public FLDP3DwellingConstruction setPlumbing(String text)
	{
		return super.setPlumbing(text);
	}

	public String getPlumbing()
	{
		return super.getPlumbing();
	}
	public FLDP3DwellingConstruction setPlumbingYear(String text)
	{
		return super.setPlumbingYear(text);
	}

	public String getPlumbingYear()
	{
		return super.getPlumbingYear();
	}
	public FLDP3DwellingConstruction setWaterHeaterYear(String text)
	{
		return super.setWaterHeaterYear(text);
	}

	public String getWaterHeaterYear()
	{
		return super.getWaterHeaterYear();
	}
	public FLDP3DwellingConstruction setWiring(String text)
	{
		return super.setWiring(text);
	}

	public String getWiring()
	{
		return super.getWiring();
	}
	public FLDP3DwellingConstruction setElectricalSystem(String text)
	{
		return super.setElectricalSystem(text);
	}

	public String gettElectricalSystem()
	{
		return super.getElectricalSystem();
	}
	public FLDP3DwellingConstruction setRoofType(String text)
	{
		return super.setRoofType(text);
	}

	public String getRoofType()
	{
		return super.getRoofType();
	}
	public FLDP3DwellingConstruction setConditionOfRoof(String text)
	{
		return super.setConditionOfRoof(text);
	}

	public String getConditionOfRoof()
	{
		return super.getConditionOfRoof();
	}
	public FLDP3DwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
	{
		return super.setIsThereASecondaryHeatingSystem(flag);
	}
	public FLDP3DwellingConstruction setElectricalSystemDescribeOther(String text)
	{
		return super.setElectricalSystemDescribeOther(text);
	}

	public FLDP3Dwelling back()
	{
		super.dwellingBack();
		return new FLDP3Dwelling(sh,path);
	}
	public String getElectricalSystemDescribeOther()
	{
		return super.getElectricalSystemDescribeOther();
	}
	public FLDP3DwellingConstruction setRoofTypeDescription(String text)
	{
		return super.setRoofTypeDescription(text);
	}

	public String getRoofTypeDescription()
	{
		return super.getRoofTypeDescription();
	}
	public FLDP3DwellingConstruction setPlumbingDescribeOther(String text)
	{
		return super.setPlumbingDescribeOther(text);
	}

	public String getPlumbingDescribeOther()
	{
		return super.getPlumbingDescribeOther();
	}
	public FLDP3DwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
	{
		return super.setPlumbingSystemHaveKnownLeaks(flag);
	}
	public FLDP3DwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakes(flag);
	}
	public FLDP3DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolations(flag);
	}
	public FLDP3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
	}
	public FLDP3DwellingConstruction setLeadPaintHazard(String flag)
	{
		return super.setLeadPaintHazard(flag);
	}
	public FLDP3DwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
	{
		return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
	}
	public FLDP3DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakesDescription(flag);
	}
	public FLDP3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
	}
	public FLDP3DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
	}
	public FLDP3DwellingConstruction setLeadPaintHazardDescription(String flag)
	{
		return super.setLeadPaintHazardDescription(flag);
	}
	public FLDP3DwellingConstruction setScreenEnclosureOnPremises(String flag)
	{
		return super.setScreenEnclosureOnPremises(flag);
	}

	public class FLDP3WindMitigation extends WindMitigation<FLDP3WindMitigation>
	{
		public FLDP3WindMitigation(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public FLDP3DwellingConstruction clickDetails()
		{
			super.clickDetailsTab();
			return new FLDP3DwellingConstruction(sh, path);
		}
		public FLDP3Coverages next()
		{
			super.coveragesNext();
			return new FLDP3Coverages(sh,path);
		}
		public FLDP3Coverages doubleClickNext()
		{
			super.doubleClickCoveragesNext();
			return new FLDP3Coverages(sh, path);
		}
		public FLDP3WindMitigation setRoofShapeType(String text)
		{
			return super.setRoofShapeType(text);
		}

		public String getRoofShapeType()
		{
			return super.getRoofShapeType();
		}
		public FLDP3WindMitigation setDiscountType(String text)
		{
			return super.setDiscountType(text);
		}

		public String getDiscountType()
		{
			return super.getDiscountType();
		}
		public FLDP3WindMitigation setFortifiedHomeType(String text)
		{
			return super.setFortifiedHomeType(text);
		}

		public String getFortifiedHomeType()
		{
			return super.getFortifiedHomeType();
		}
		public FLDP3WindMitigation setOpeningProtectionType(String text)
		{
			return super.setOpeningProtectionType(text);
		}

		public String getOpeningProtectionType()
		{
			return super.getOpeningProtectionType();
		}
		public FLDP3WindMitigation setTerrain(String text)
		{
			return super.setTerrain(text);
		}

		public String getTerrain()
		{
			return super.getTerrain();
		}
		public FLDP3WindMitigation setRoofCover(String text)
		{
			return super.setRoofCover(text);
		}

		public String getRoofCover()
		{
			return super.getRoofCover();
		}
		public FLDP3WindMitigation setRoofDeckAttachment(String text)
		{
			return super.setRoofDeckAttachment(text);
		}

		public String getRoofDeckAttachment()
		{
			return super.getRoofDeckAttachment();
		}
		public FLDP3WindMitigation setRoofWallConnection(String text)
		{
			return super.setRoofWallConnection(text);
		}

		public String getRoofWallConnection()
		{
			return super.getRoofWallConnection();
		}
		public FLDP3WindMitigation setSecondaryWaterResistance(String flag)
		{
			return super.setSecondaryWaterResistance(flag);
		}
		public FLDP3WindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
		}
		public FLDP3WindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
		}
		public FLDP3WindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
		}
		public FLDP3WindMitigation setRoofDeck(String text)
		{
			return super.setRoofDeck(text);
		}

		public String getRoofDeck()
		{
			return super.getRoofDeck();
		}
		public FLDP3WindMitigation setFbcWindSpeed(String text)
		{
			return super.setFbcWindSpeed(text);
		}

		public String getFbcWindSpeed()
		{
			return super.getFbcWindSpeed();
		}
		public FLDP3WindMitigation setInternalPressure(String text)
		{
			return super.setInternalPressure(text);
		}

		public String getInternalPressure()
		{
			return super.getInternalPressure();
		}

		public FLDP3WindMitigation setWindBorneDebris(String flag)
		{
			return super.setWindBorneDebris(flag);
		}
















	}

}
