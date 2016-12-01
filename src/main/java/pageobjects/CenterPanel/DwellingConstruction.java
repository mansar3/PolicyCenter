package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class DwellingConstruction extends CenterPanelBase
{
	private DwellingConstructionBy by;
	protected String dwellingConstructionBase, windMitigationBase;
	public DwellingConstruction(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Dwelling Construction";
		waitForTitle(sh);
		setID(path);
		by = new DwellingConstructionBy();
		System.out.println("Navigated to page: " + getTitle());
	}

	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				this.dwellingConstructionBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:";
				this.windMitigationBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
				break;
			case POLICYRENEWAL:
				this.dwellingConstructionBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:";
				this.windMitigationBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
				break;
			case POLICYCHANGE:
				this.dwellingConstructionBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:";
				this.windMitigationBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";

		}
	}

	public Coverages next()
	{
		sh.waitForNoMask(15);
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new Coverages(sh);
	}

	public DwellingConstruction setRoofYear(String roofYear)
	{
		sh.setText(by.roofYear, roofYear);
		return this;
	}
	public DwellingConstruction clickMitigation()
	{

		sh.clickElement(by.windMitigation);
		return this;
	}
	public DwellingConstruction setRoofShapeType(String roofType)
	{
		sh.setText(by.roofShapeType, roofType);
		sh.tab();
		return this;
	}
	public String getValuationType()
	{
		return sh.getValue(by.valuationType);
	}

	public DwellingConstruction setValuationType(String valuationType)
	{
		sh.setText(by.valuationType, valuationType);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getEstimatedReplacementCost()
	{
		return sh.getValue(by.estimatedReplacementCost);
	}
	
	public DwellingConstruction setEstimatedReplacementCost(String estimatedReplacementCost)
	{
		sh.setText(by.estimatedReplacementCost, estimatedReplacementCost);
		return this;
	}

	public String getConstructionType()
	{
		return sh.getValue(by.constructionType);
	}
	
	public DwellingConstruction setConstructionType(String constructionType)
	{
		sh.setText(by.constructionType, constructionType);
		sh.tab();
		return this;
	}
	
	public String getNumberOfUnits()
	{
		return sh.getValue(by.numberOfUnits);
	}
	
	public DwellingConstruction setNumberOfUnits(String numberOfUnits)
	{
		sh.setText(by.numberOfUnits, numberOfUnits);
		sh.tab();
		return this;
	}

	public String getUnitsInFireWall()
	{
		return sh.getValue(by.unitsInFireWall);
	}

	public DwellingConstruction setUnitsInFireWall(String unitsInFireWall)
	{
		sh.setText(by.unitsInFireWall, unitsInFireWall);
		sh.tab();
		return this;
	}

	public String getNumberOfStories()
	{
		return sh.getValue(by.numberOfStories);
	}

	public DwellingConstruction setNumberOfStories(String numberOfStories)
	{
		sh.setText(by.numberOfStories, numberOfStories);
		return this;
	}

	public String getSquareFootage()
	{
		return sh.getValue(by.squareFootage);
	}

	public DwellingConstruction setSquareFootage(String squareFootage)
	{
		sh.setText(by.squareFootage, squareFootage);
		return this;
	}

	public String getFoundationType()
	{
		return sh.getValue(by.foundationType);
	}

	public DwellingConstruction setFoundationType(String foundationType)
	{
		sh.setText(by.foundationType, foundationType);
		sh.tab();

		return this;
	}

	public String getPrimaryHeating()
	{
		return sh.getValue(by.primaryHeating);
	}

	public DwellingConstruction setPrimaryHeating(String primaryHeating)
	{
		sh.setText(by.primaryHeating, primaryHeating);
		sh.tab();
		return this;
	}

	public String getPlumbing()
	{
		return sh.getValue(by.plumbing);
	}

	public DwellingConstruction setPlumbing(String plumbing)
	{
		sh.setText(by.plumbing, plumbing);
		sh.tab();
		return this;
	}

	public String getPlumbingYear()
	{
		return sh.getValue(by.plumbingYear);
	}

	public DwellingConstruction setPlumbingYear(String plumbingYear)
	{
		sh.setText(by.plumbingYear, plumbingYear);
		return this;
	}

	public String getWaterHeaterYear()
	{
		return sh.getValue(by.waterHeaterYear);
	}

	public DwellingConstruction setWaterHeaterYear(String waterHeaterYear)
	{
		sh.setText(by.waterHeaterYear, waterHeaterYear);
		return this;
	}

	public String getWiring()
	{
		return sh.getValue(by.wiring);
	}

	public DwellingConstruction setWiring(String wiring)
	{
		sh.setText(by.wiring, wiring);
		sh.tab();
		return this;
	}

	public String getElectricalSystem()
	{
		return sh.getValue(by.electricalSystem);
	}

	public DwellingConstruction setElectricalSystem(String electricalSystem)
	{
		sh.setText(by.electricalSystem, electricalSystem);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public String getRoofType()
	{
		return sh.getValue(by.roofType);
	}

	public DwellingConstruction setRoofType(String roofType)
	{
		sh.setText(by.roofType, roofType);
		sh.tab();
		return this;
	}

	public String getConditionOfRoof()
	{
		return sh.getValue(by.conditionOfRoof);
	}

	public DwellingConstruction setConditionOfRoof(String conditionOfRoof)
	{
		sh.setText(by.conditionOfRoof, conditionOfRoof);
		sh.tab();
		return this;
	}

	public String getOpeningProtectionType()
	{
		return sh.getValue(by.openingProtectionType);
	}

	public DwellingConstruction setOpeningProtectionType(String openingProtectionType)
	{
		sh.setText(by.openingProtectionType, openingProtectionType);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public String getTerrain()
	{
		return sh.getValue(by.terrain);
	}

	public DwellingConstruction setTerrain(String terrain)
	{
		sh.setText(by.terrain, terrain);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public String getRoofCover()
	{
		return sh.getValue(by.roofCover);
	}

	public DwellingConstruction setRoofCover(String roofCover)
	{
		sh.setText(by.roofCover, roofCover);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public String getRoofDeckAttachment()
	{
		return sh.getValue(by.roofDeckAttachment);
	}

	public DwellingConstruction setRoofDeckAttachment(String roofDeckAttachment)
	{
		sh.setText(by.roofDeckAttachment, roofDeckAttachment);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public String getRoofWallConnection()
	{
		return sh.getValue(by.roofWallConnection);
	}

	public DwellingConstruction setRoofWallConnection(String roofWallConnection)
	{
		sh.setText(by.roofWallConnection, roofWallConnection);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}

	public class DwellingConstructionBy
	{

		final By			roofYear = By.id(dwellingConstructionBase + "RoofYear_fli-inputEl"),
								valuationType = By.id(dwellingConstructionBase + "MSBInputSet:ValuationType_fli-inputEl"),
								estimatedReplacementCost = By.id(dwellingConstructionBase + "ReplacementCost-inputEl"),
								constructionType = By.id(dwellingConstructionBase + "ConstructionType-inputEl"),
								numberOfUnits = By.id(dwellingConstructionBase + "UnitsNumber-inputEl"),
								unitsInFireWall = By.id(dwellingConstructionBase + "NumOfUnitsInFirewall_fli-inputEl"),
								numberOfStories = By.id(dwellingConstructionBase + "NumberOfStories_fli-inputEl"),
								squareFootage = By.id(dwellingConstructionBase + "ApproxSquareFootage-inputEl"),
								foundationType = By.id(dwellingConstructionBase + "Foundation-inputEl"),
								primaryHeating = By.id(dwellingConstructionBase + "PrimaryHeating-inputEl"),
								plumbing = By.id((dwellingConstructionBase + "PlumbingType-inputEl")),
								plumbingYear = By.id(dwellingConstructionBase + "PlumbingYear_fli-inputEl"),
								waterHeaterYear = By.id(dwellingConstructionBase + "WaterHeaterYear_fli-inputEl"),
								wiring = By.id(dwellingConstructionBase + "WiringType-inputEl"),
								electricalSystem = By.id(dwellingConstructionBase + "ElectricalType-inputEl"),
								roofType = By.id(dwellingConstructionBase +"RoofType-inputEl"),
								conditionOfRoof = By.id(dwellingConstructionBase + "RoofCondition_fli-inputEl"),
								windMitigation = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:WindMitTab-btnInnerEl"),

								// Wind Mitigation
								roofShapeType = By.id(windMitigationBase + "RoofShapeType_fli-inputEl"),
								openingProtectionType = By.id(windMitigationBase + "OpeningProtectionType_fli-inputEl"),
								terrain = By.id(windMitigationBase + "TerrainType_fli-inputEl"),
								roofCover = By.id(windMitigationBase + "RoofCoverType_fli-inputEl"),
								roofDeckAttachment = By.id(windMitigationBase + "RoofDeckAttachType_fli-inputEl"),
								roofWallConnection = By.id(windMitigationBase + "RoofWallConnectType_fli-inputEl");


	}
}