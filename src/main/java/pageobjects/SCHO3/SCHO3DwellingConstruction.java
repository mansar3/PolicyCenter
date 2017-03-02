package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3DwellingConstruction extends DwellingConstruction<SCHO3DwellingConstruction>
{
	public SCHO3DwellingConstruction(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3Coverages next()
	{
		super.coveragesNext();
		return new SCHO3Coverages(sh, path);
	}
	public SCHO3WindMitigation clickWindMitigation()
	{
		super.windMitigation();
		return new SCHO3WindMitigation(sh,path);
	}
	public SCHO3DwellingConstruction setRoofYear(String text)
	{
		return super.setRoofYear(text);
	}

	public String getRoofYear()
	{
		return super.getRoofYear();
	}
	public SCHO3DwellingConstruction setValuationType(String text)
	{
		return super.setValuationType(text);
	}

	public String getValuationType()
	{
		return super.getValuationType();
	}
	public SCHO3DwellingConstruction setEstimatedReplacementCost(String text)
	{
		return super.setEstimatedReplacementCost(text);
	}
	public SCHO3Dwelling back()
	{
		super.dwellingBack();
		return new SCHO3Dwelling(sh,path);
	}
	public String dwellingConstructionErrorMessage()
	{
		return super.dwellingConstructionErrorMessage();
	}

	public String getEstimatedReplacementCost()
	{
		return super.getEstimatedReplacementCost();
	}
	public SCHO3DwellingConstruction setConstructionType(String text)
	{
		return super.setConstructionType(text);
	}

	public String getConstructionType()
	{
		return super.getConstructionType();
	}
	public SCHO3DwellingConstruction dwellingConstructionEnter(){return super.dwellingConstructionEnter();}

	public SCHO3DwellingConstruction setNumberOfUnits(String text)
	{
		return super.setNumberOfUnits(text);
	}
	public String getNumberOfUnits()
	{
		return super.getNumberOfUnits();
	}
	public SCHO3DwellingConstruction setUnitsInFireWall(String text)
	{
		return super.setUnitsInFireWall(text);
	}

	public String getUnitsInFireWall()
	{
		return super.getUnitsInFireWall();
	}
	public SCHO3DwellingConstruction setNumberOfStories(String text)
	{
		return super.setNumberOfStories(text);
	}

	public String getNumberOfStories()
	{
		return super.getNumberOfStories();
	}
	public SCHO3DwellingConstruction setSquareFootage(String text)
	{
		return super.setSquareFootage(text);
	}

	public String getSquareFootage()
	{
		return super.getSquareFootage();
	}
	public SCHO3DwellingConstruction setFoundationType(String text)
	{
		return super.setFoundationType(text);
	}

	public String getFoundationType()
	{
		return super.getFoundationType();
	}
	public SCHO3DwellingConstruction setPrimaryHeating(String text)
	{
		return super.setPrimaryHeating(text);
	}

	public String getPrimaryHeating()
	{
		return super.getPrimaryHeating();
	}
	public SCHO3DwellingConstruction setPlumbing(String text)
	{
		return super.setPlumbing(text);
	}

	public String getPlumbing()
	{
		return super.getPlumbing();
	}
	public SCHO3DwellingConstruction setPlumbingYear(String text)
	{
		return super.setPlumbingYear(text);
	}

	public String getPlumbingYear()
	{
		return super.getPlumbingYear();
	}
	public SCHO3DwellingConstruction setWaterHeaterYear(String text)
	{
		return super.setWaterHeaterYear(text);
	}

	public String getWaterHeaterYear()
	{
		return super.getWaterHeaterYear();
	}
	public SCHO3DwellingConstruction setWiring(String text)
	{
		return super.setWiring(text);
	}

	public String getWiring()
	{
		return super.getWiring();
	}
	public SCHO3DwellingConstruction setElectricalSystem(String text)
	{
		return super.setElectricalSystem(text);
	}

	public String gettElectricalSystem()
	{
		return super.getElectricalSystem();
	}
	public SCHO3DwellingConstruction setRoofType(String text)
	{
		return super.setRoofType(text);
	}

	public String getRoofType()
	{
		return super.getRoofType();
	}
	public SCHO3DwellingConstruction setConditionOfRoof(String text)
	{
		return super.setConditionOfRoof(text);
	}

	public String getConditionOfRoof()
	{
		return super.getConditionOfRoof();
	}
	public SCHO3DwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
	{
		return super.setIsThereASecondaryHeatingSystem(flag);
	}
	public SCHO3DwellingConstruction setElectricalSystemDescribeOther(String text)
	{
		return super.setElectricalSystemDescribeOther(text);
	}

	public String getElectricalSystemDescribeOther()
	{
		return super.getElectricalSystemDescribeOther();
	}
	public SCHO3DwellingConstruction setRoofTypeDescription(String text)
	{
		return super.setRoofTypeDescription(text);
	}

	public String getRoofTypeDescription()
	{
		return super.getRoofTypeDescription();
	}
	public SCHO3DwellingConstruction setPlumbingDescribeOther(String text)
	{
		return super.setPlumbingDescribeOther(text);
	}

	public String getPlumbingDescribeOther()
	{
		return super.getPlumbingDescribeOther();
	}
	public SCHO3DwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
	{
		return super.setPlumbingSystemHaveKnownLeaks(flag);
	}
	public SCHO3DwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakes(flag);
	}
	public SCHO3DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolations(flag);
	}
	public SCHO3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
	}
	public SCHO3DwellingConstruction setLeadPaintHazard(String flag)
	{
		return super.setLeadPaintHazard(flag);
	}
	public SCHO3DwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
	{
		return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
	}
	public SCHO3DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakesDescription(flag);
	}
	public SCHO3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
	}
	public SCHO3DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
	}
	public SCHO3DwellingConstruction setLeadPaintHazardDescription(String flag)
	{
		return super.setLeadPaintHazardDescription(flag);
	}
	public SCHO3DwellingConstruction setScreenEnclosureOnPremises(String flag)
	{
		return super.setScreenEnclosureOnPremises(flag);
	}

	public class SCHO3WindMitigation extends WindMitigation<SCHO3WindMitigation>
	{
		public SCHO3WindMitigation(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public SCHO3DwellingConstruction clickDetails()
		{
			super.clickDetailsTab();
			return new SCHO3DwellingConstruction(sh, path);
		}
		public SCHO3Coverages next()
		{
			super.coveragesNext();
			return new SCHO3Coverages(sh,path);
		}
		public SCHO3Coverages doubleClickNext()
		{
			super.doubleClickCoveragesNext();
			return new SCHO3Coverages(sh, path);
		}
		public SCHO3WindMitigation setRoofShapeType(String text)
		{
			return super.setRoofShapeType(text);
		}

		public String getRoofShapeType()
		{
			return super.getRoofShapeType();
		}
		public SCHO3WindMitigation setDiscountType(String text)
		{
			return super.setDiscountType(text);
		}

		public String getDiscountType()
		{
			return super.getDiscountType();
		}
		public SCHO3WindMitigation setFortifiedHomeType(String text)
		{
			return super.setFortifiedHomeType(text);
		}

		public String getFortifiedHomeType()
		{
			return super.getFortifiedHomeType();
		}
		public SCHO3WindMitigation setOpeningProtectionType(String text)
		{
			return super.setOpeningProtectionType(text);
		}

		public String getOpeningProtectionType()
		{
			return super.getOpeningProtectionType();
		}
		public SCHO3WindMitigation setTerrain(String text)
		{
			return super.setTerrain(text);
		}

		public String getTerrain()
		{
			return super.getTerrain();
		}
		public SCHO3WindMitigation setRoofCover(String text)
		{
			return super.setRoofCover(text);
		}

		public String getRoofCover()
		{
			return super.getRoofCover();
		}
		public SCHO3WindMitigation setRoofDeckAttachment(String text)
		{
			return super.setRoofDeckAttachment(text);
		}

		public SCHO3Dwelling winddwellingback()
		{
			super.WinddwellingBack();
			return new SCHO3Dwelling(sh,path);
		}

		public String getRoofDeckAttachment()
		{
			return super.getRoofDeckAttachment();
		}
		public SCHO3WindMitigation setRoofWallConnection(String text)
		{
			return super.setRoofWallConnection(text);
		}

		public String getRoofWallConnection()
		{
			return super.getRoofWallConnection();
		}
		public SCHO3WindMitigation setSecondaryWaterResistance(String flag)
		{
			return super.setSecondaryWaterResistance(flag);
		}
		public SCHO3WindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
		}
		public SCHO3WindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
		}
		public SCHO3WindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
		}
		public SCHO3WindMitigation setRoofDeck(String text)
		{
			return super.setRoofDeck(text);
		}

		public String getRoofDeck()
		{
			return super.getRoofDeck();
		}
		public SCHO3WindMitigation setFbcWindSpeed(String text)
		{
			return super.setFbcWindSpeed(text);
		}

		public String getFbcWindSpeed()
		{
			return super.getFbcWindSpeed();
		}
		public SCHO3WindMitigation setInternalPressure(String text)
		{
			return super.setInternalPressure(text);
		}

		public String getInternalPressure()
		{
			return super.getInternalPressure();
		}

		public SCHO3WindMitigation setWindBorneDebris(String flag)
		{
			return super.setWindBorneDebris(flag);
		}
















	}
}
