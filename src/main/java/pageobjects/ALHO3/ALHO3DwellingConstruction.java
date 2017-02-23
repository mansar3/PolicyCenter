package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.FLHO3.FLHO3Dwelling;
import pageobjects.WizardPanelBase.DwellingConstruction;

import java.rmi.activation.ActivationGroup_Stub;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3DwellingConstruction extends DwellingConstruction<ALHO3DwellingConstruction>
{
	public ALHO3DwellingConstruction(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public ALHO3Coverages next()
	{
		super.coveragesNext();
		return new ALHO3Coverages(sh, path);
	}
	public ALHO3WindMitigation clickWindMitigation()
	{
		super.windMitigation();
		return new ALHO3WindMitigation(sh,path);
	}
	public ALHO3DwellingConstruction setRoofYear(String text)
	{
		return super.setRoofYear(text);
	}

	public String getRoofYear()
	{
		return super.getRoofYear();
	}
	public ALHO3DwellingConstruction setValuationType(String text)
	{
		return super.setValuationType(text);
	}

	public String getValuationType()
	{
		return super.getValuationType();
	}
	public ALHO3DwellingConstruction setEstimatedReplacementCost(String text)
	{
		return super.setEstimatedReplacementCost(text);
	}
	public ALHO3Dwelling back()
	{
		super.dwellingBack();
		return new ALHO3Dwelling(sh,path);
	}
	public String getEstimatedReplacementCost()
	{
		return super.getEstimatedReplacementCost();
	}
	public ALHO3DwellingConstruction setConstructionType(String text)
	{
		return super.setConstructionType(text);
	}

	public String getConstructionType()
	{
		return super.getConstructionType();
	}
	public ALHO3DwellingConstruction setNumberOfUnits(String text)
	{
		return super.setNumberOfUnits(text);
	}
	public String getNumberOfUnits()
	{
		return super.getNumberOfUnits();
	}
	public ALHO3DwellingConstruction setUnitsInFireWall(String text)
	{
		return super.setUnitsInFireWall(text);
	}

	public String getUnitsInFireWall()
	{
		return super.getUnitsInFireWall();
	}
	public ALHO3DwellingConstruction setNumberOfStories(String text)
	{
		return super.setNumberOfStories(text);
	}

	public String getNumberOfStories()
	{
		return super.getNumberOfStories();
	}
	public ALHO3DwellingConstruction setSquareFootage(String text)
	{
		return super.setSquareFootage(text);
	}

	public String getSquareFootage()
	{
		return super.getSquareFootage();
	}
	public ALHO3DwellingConstruction setFoundationType(String text)
	{
		return super.setFoundationType(text);
	}

	public String getFoundationType()
	{
		return super.getFoundationType();
	}
	public ALHO3DwellingConstruction setPrimaryHeating(String text)
	{
		return super.setPrimaryHeating(text);
	}

	public String getPrimaryHeating()
	{
		return super.getPrimaryHeating();
	}
	public ALHO3DwellingConstruction setPlumbing(String text)
	{
		return super.setPlumbing(text);
	}

	public String getPlumbing()
	{
		return super.getPlumbing();
	}
	public ALHO3DwellingConstruction setPlumbingYear(String text)
	{
		return super.setPlumbingYear(text);
	}

	public String getPlumbingYear()
	{
		return super.getPlumbingYear();
	}
	public ALHO3DwellingConstruction setWaterHeaterYear(String text)
	{
		return super.setWaterHeaterYear(text);
	}

	public String getWaterHeaterYear()
	{
		return super.getWaterHeaterYear();
	}
	public ALHO3DwellingConstruction setWiring(String text)
	{
		return super.setWiring(text);
	}

	public String getWiring()
	{
		return super.getWiring();
	}
	public ALHO3DwellingConstruction setElectricalSystem(String text)
	{
		return super.setElectricalSystem(text);
	}

	public String gettElectricalSystem()
	{
		return super.getElectricalSystem();
	}
	public ALHO3DwellingConstruction setRoofType(String text)
	{
		return super.setRoofType(text);
	}

	public String getRoofType()
	{
		return super.getRoofType();
	}
	public ALHO3DwellingConstruction setConditionOfRoof(String text)
	{
		return super.setConditionOfRoof(text);
	}

	public String getConditionOfRoof()
	{
		return super.getConditionOfRoof();
	}
	public ALHO3DwellingConstruction setIsThereASecondaryHeatingSystem(String flag)
	{
		return super.setIsThereASecondaryHeatingSystem(flag);
	}
	public ALHO3DwellingConstruction setElectricalSystemDescribeOther(String text)
	{
		return super.setElectricalSystemDescribeOther(text);
	}

	public String getElectricalSystemDescribeOther()
	{
		return super.getElectricalSystemDescribeOther();
	}
	public ALHO3DwellingConstruction setRoofTypeDescription(String text)
	{
		return super.setRoofTypeDescription(text);
	}

	public String getRoofTypeDescription()
	{
		return super.getRoofTypeDescription();
	}
	public ALHO3DwellingConstruction setPlumbingDescribeOther(String text)
	{
		return super.setPlumbingDescribeOther(text);
	}

	public String getPlumbingDescribeOther()
	{
		return super.getPlumbingDescribeOther();
	}
	public ALHO3DwellingConstruction setPlumbingSystemHaveKnownLeaks(String flag)
	{
		return super.setPlumbingSystemHaveKnownLeaks(flag);
	}
	public ALHO3DwellingConstruction setBuildingRetrofittedForEarthquakes(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakes(flag);
	}
	public ALHO3DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolations(flag);
	}
	public ALHO3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidence(flag);
	}
	public ALHO3DwellingConstruction setLeadPaintHazard(String flag)
	{
		return super.setLeadPaintHazard(flag);
	}
	public ALHO3DwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(String flag)
	{
		return super.setAnyPortionOfAnyStructureAtThisPropertyLocation(flag);
	}
	public ALHO3DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String flag)
	{
		return super.setBuildingRetrofittedForEarthquakesDescription(flag);
	}
	public ALHO3DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String flag)
	{
		return super.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(flag);
	}
	public ALHO3DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String flag)
	{
		return super.setUncorrectedFireOrBuildingCodeViolationsDescription(flag);
	}
	public ALHO3DwellingConstruction setLeadPaintHazardDescription(String flag)
	{
		return super.setLeadPaintHazardDescription(flag);
	}
	public ALHO3DwellingConstruction setScreenEnclosureOnPremises(String flag)
	{
		return super.setScreenEnclosureOnPremises(flag);
	}

	public class ALHO3WindMitigation extends WindMitigation<ALHO3WindMitigation>
	{
		public ALHO3WindMitigation(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public ALHO3DwellingConstruction clickDetails()
		{
			super.clickDetailsTab();
			return new ALHO3DwellingConstruction(sh, path);
		}
		public ALHO3Coverages next()
		{
			super.coveragesNext();
			return new ALHO3Coverages(sh,path);
		}
		public ALHO3Coverages doubleClickNext()
		{
			super.doubleClickCoveragesNext();
			return new ALHO3Coverages(sh, path);
		}
		public ALHO3WindMitigation setRoofShapeType(String text)
		{
			return super.setRoofShapeType(text);
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
