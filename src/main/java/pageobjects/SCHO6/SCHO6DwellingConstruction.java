package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.FLHO3.FLHO3Dwelling;
import pageobjects.WizardPanelBase.DwellingConstruction;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6DwellingConstruction extends DwellingConstruction<SCHO6DwellingConstruction>
{
	public SCHO6DwellingConstruction(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6Coverages next()
	{
		super.coveragesNext();
		return new SCHO6Coverages(sh, path);
	}
	public SCHO6WindMitigation clickWindMitigation()
	{
		super.windMitigation();
		return new SCHO6WindMitigation(sh,path);
	}
	public SCHO6DwellingConstruction setRoofYear(String text)
	{
		return super.setRoofYear(text);
	}

	public String getRoofYear()
	{
		return super.getRoofYear();
	}

	public String getValuationType()
	{
		return super.getValuationType();
	}
	public SCHO6DwellingConstruction setEstimatedReplacementCost(String text)
	{
		return super.setEstimatedReplacementCost(text);
	}
	public SCHO6Dwelling back()
	{
		super.dwellingBack();
		return new SCHO6Dwelling(sh,path);
	}
	public String dwellingConstructionErrorMessage()
	{
		return super.dwellingConstructionErrorMessage();
	}
	public SCHO6DwellingConstruction dwellingConstructionEnter(){return super.dwellingConstructionEnter();}
	public String getEstimatedReplacementCost()
	{
		return super.getEstimatedReplacementCost();
	}
	public SCHO6DwellingConstruction setConstructionType(String text)
	{
		return super.setConstructionType(text);
	}

	public String getConstructionType()
	{
		return super.getConstructionType();
	}
	public SCHO6DwellingConstruction setNumberOfUnits(String text)
	{
		return super.setNumberOfUnits(text);
	}
	public String getNumberOfUnits()
	{
		return super.getNumberOfUnits();
	}
	public SCHO6DwellingConstruction setUnitsInFireWall(String text)
	{
		return super.setUnitsInFireWall(text);
	}

	public String getUnitsInFireWall()
	{
		return super.getUnitsInFireWall();
	}
	public SCHO6DwellingConstruction setNumberOfStories(String text)
	{
		return super.setNumberOfStories(text);
	}

	public String getNumberOfStories()
	{
		return super.getNumberOfStories();
	}
	public SCHO6DwellingConstruction setSquareFootage(String text)
	{
		return super.setSquareFootage(text);
	}

	public String getSquareFootage()
	{
		return super.getSquareFootage();
	}
	public SCHO6DwellingConstruction setFoundationType(String text)
	{
		return super.setFoundationType(text);
	}

	public String getFoundationType()
	{
		return super.getFoundationType();
	}
	public SCHO6DwellingConstruction setPrimaryHeating(String text)
	{
		return super.setPrimaryHeating(text);
	}

	public String getPrimaryHeating()
	{
		return super.getPrimaryHeating();
	}
	public SCHO6DwellingConstruction setPlumbing(String text)
	{
		return super.setPlumbing(text);
	}

	public String getPlumbing()
	{
		return super.getPlumbing();
	}
	public SCHO6DwellingConstruction setPlumbingYear(String text)
	{
		return super.setPlumbingYear(text);
	}

	public String getPlumbingYear()
	{
		return super.getPlumbingYear();
	}
	public SCHO6DwellingConstruction setWaterHeaterYear(String text)
	{
		return super.setWaterHeaterYear(text);
	}

	public String getWaterHeaterYear()
	{
		return super.getWaterHeaterYear();
	}
	public SCHO6DwellingConstruction setWiring(String text)
	{
		return super.setWiring(text);
	}

	public String getWiring()
	{
		return super.getWiring();
	}
	public SCHO6DwellingConstruction setElectricalSystem(String text)
	{
		return super.setElectricalSystem(text);
	}

	public String gettElectricalSystem()
	{
		return super.getElectricalSystem();
	}
	public SCHO6DwellingConstruction setRoofType(String text)
	{
		return super.setRoofType(text);
	}

	public String getRoofType()
	{
		return super.getRoofType();
	}
	public SCHO6DwellingConstruction setConditionOfRoof(String text)
	{
		return super.setConditionOfRoof(text);
	}

	public String getConditionOfRoof()
	{
		return super.getConditionOfRoof();
	}
	public SCHO6DwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
	{
		return super.setIsThereASecondaryHeatingSystem(flag);
	}
	public SCHO6DwellingConstruction setElectricalSystemDescribeOther(String text)
	{
		return super.setElectricalSystemDescribeOther(text);
	}

	public String getElectricalSystemDescribeOther()
	{
		return super.getElectricalSystemDescribeOther();
	}
	public SCHO6DwellingConstruction setRoofTypeDescription(String text)
	{
		return super.setRoofTypeDescription(text);
	}

	public String getRoofTypeDescription()
	{
		return super.getRoofTypeDescription();
	}
	public SCHO6DwellingConstruction setPlumbingDescribeOther(String text)
	{
		return super.setPlumbingDescribeOther(text);
	}

	public String getPlumbingDescribeOther()
	{
		return super.getPlumbingDescribeOther();
	}
	public SCHO6DwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
	{
		return super.setPlumbingSystemHaveKnownLeaks(flag);
	}
	public SCHO6DwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakes(flag);
	}
	public SCHO6DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolations(flag);
	}
	public SCHO6DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
	}
	public SCHO6DwellingConstruction setLeadPaintHazard(String flag)
	{
		return super.setLeadPaintHazard(flag);
	}
	public SCHO6DwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
	{
		return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
	}
	public SCHO6DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakesDescription(flag);
	}
	public SCHO6DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
	}
	public SCHO6DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
	}
	public SCHO6DwellingConstruction setLeadPaintHazardDescription(String flag)
	{
		return super.setLeadPaintHazardDescription(flag);
	}
	public SCHO6DwellingConstruction setScreenEnclosureOnPremises(String flag)
	{
		return super.setScreenEnclosureOnPremises(flag);
	}

	public class SCHO6WindMitigation extends WindMitigation<SCHO6WindMitigation>
	{
		public SCHO6WindMitigation(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public SCHO6DwellingConstruction clickDetails()
		{
			super.clickDetailsTab();
			return new SCHO6DwellingConstruction(sh, path);
		}
		public SCHO6Coverages next()
		{
			super.coveragesNext();
			return new SCHO6Coverages(sh,path);
		}
		public SCHO6Coverages doubleClickNext()
		{
			super.doubleClickCoveragesNext();
			return new SCHO6Coverages(sh, path);
		}
		public SCHO6WindMitigation setRoofShapeType(String text)
		{
			return super.setRoofShapeType(text);
		}

		public String getRoofShapeType()
		{
			return super.getRoofShapeType();
		}
		public SCHO6WindMitigation setDiscountType(String text)
		{
			return super.setDiscountType(text);
		}

		public String getDiscountType()
		{
			return super.getDiscountType();
		}
		public SCHO6WindMitigation setFortifiedHomeType(String text)
		{
			return super.setFortifiedHomeType(text);
		}

		public String getFortifiedHomeType()
		{
			return super.getFortifiedHomeType();
		}
		public SCHO6WindMitigation setOpeningProtectionType(String text)
		{
			return super.setOpeningProtectionType(text);
		}

		public String getOpeningProtectionType()
		{
			return super.getOpeningProtectionType();
		}
		public SCHO6WindMitigation setTerrain(String text)
		{
			return super.setTerrain(text);
		}

		public String getTerrain()
		{
			return super.getTerrain();
		}
		public SCHO6WindMitigation setRoofCover(String text)
		{
			return super.setRoofCover(text);
		}

		public String getRoofCover()
		{
			return super.getRoofCover();
		}
		public SCHO6WindMitigation setRoofDeckAttachment(String text)
		{
			return super.setRoofDeckAttachment(text);
		}

		public String getRoofDeckAttachment()
		{
			return super.getRoofDeckAttachment();
		}
		public SCHO6WindMitigation setRoofWallConnection(String text)
		{
			return super.setRoofWallConnection(text);
		}
		public SCHO6Dwelling winddwellingback()
		{
			super.WinddwellingBack();
			return new SCHO6Dwelling(sh,path);
		}
		public String getRoofWallConnection()
		{
			return super.getRoofWallConnection();
		}
		public SCHO6WindMitigation setSecondaryWaterResistance(String flag)
		{
			return super.setSecondaryWaterResistance(flag);
		}
		public SCHO6WindMitigation setIsTheRoofCoverConstructionBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofCoverConstructionBuildingCodeCompliant(flag);
		}
		public SCHO6WindMitigation setIsTheRoofDeckAttachmentBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofDeckAttachmentBuildingCodeCompliant(flag);
		}
		public SCHO6WindMitigation setIsTheRoofWallconnectionBuildingCodeCompliant(String flag)
		{
			return super.setIsTheRoofWallconnectionBuildingCodeCompliant(flag);
		}
		public SCHO6WindMitigation setRoofDeck(String text)
		{
			return super.setRoofDeck(text);
		}

		public String getRoofDeck()
		{
			return super.getRoofDeck();
		}
		public SCHO6WindMitigation setFbcWindSpeed(String text)
		{
			return super.setFbcWindSpeed(text);
		}

		public String getFbcWindSpeed()
		{
			return super.getFbcWindSpeed();
		}
		public SCHO6WindMitigation setInternalPressure(String text)
		{
			return super.setInternalPressure(text);
		}

		public String getInternalPressure()
		{
			return super.getInternalPressure();
		}

		public SCHO6WindMitigation setWindBorneDebris(String flag)
		{
			return super.setWindBorneDebris(flag);
		}
















	}
}
