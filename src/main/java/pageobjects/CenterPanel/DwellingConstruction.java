package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class DwellingConstruction extends CenterPanelBase
{
	private DwellingConstructionBy by;
	protected String dwellingConstructionBase, windMitigationBase,tabBase;
	public WindMitigation wm;
	public DwellingConstruction(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Dwelling Construction";
		waitForTitle(sh);
		setID(path);
		by = new DwellingConstructionBy();
		wm = new WindMitigation(sh, path);
		System.out.println("Navigated to page: " + getTitle());
	}

	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				dwellingConstructionBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:";
				windMitigationBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
				tabBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
				break;
			case POLICYRENEWAL:
				dwellingConstructionBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:";
				windMitigationBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
				tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
				break;
			case POLICYCHANGE:
				dwellingConstructionBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:";
				windMitigationBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
				tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
				break;
		}
	}

	public Coverages next()
	{
		sh.waitForNoMask(15);
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new Coverages(sh,path);
	}

	public DwellingConstruction setRoofYear(String roofYear)
	{
		sh.setText(by.roofYear, roofYear);
		return this;
	}
	public WindMitigation clickWindMitigation()
	{

		sh.clickElement(by.windMitigation);
		return new WindMitigation(sh, path);
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

	
	public DwellingConstruction setPlumbingSystemHaveKnownLeaks(boolean flag)
	{
		sh.clickElement(
		By.xpath(".//*[text() = 'Does the plumbing system have known leaks?']/../..//input[@inputvalue = '" +
		String.valueOf(flag) + "']"));
		sh.waitForNoMask();
		return this;
	}
	public DwellingConstruction setBuildingRetrofittedForEarthquakes(boolean flag)
	{
		sh.clickElement(
		By.xpath(".//*[text() = 'Is the building retrofitted for earthquakes?']/../..//input[@inputvalue = '" +
		String.valueOf(flag) + "']"));
		sh.waitForNoMask();
		return this;
	}
	public DwellingConstruction setUncorrectedFireOrBuildingCodeViolations(boolean flag)
	{
		sh.clickElement(
		By.xpath(".//*[text() = 'Any uncorrected fire or building code violations?']/../..//input[@inputvalue = '" +
		String.valueOf(flag) + "']"));
		sh.waitForNoMask();
		return this;
	}

	public DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidence(boolean flag)
	{
		sh.clickElement(
		By.xpath(".//*[text() = 'Was the structure originally built for other than a private residence and then converted?']/../..//input[@inputvalue = '" +
		String.valueOf(flag) + "']"));
		sh.waitForNoMask();
		return this;
	}


	public DwellingConstruction setLeadPaintHazard(boolean flag)
	{
		sh.clickElement(
		By.xpath(".//*[text() = 'Any lead paint hazard?']/../..//input[@inputvalue = '" +
		String.valueOf(flag) + "']"));
		sh.waitForNoMask();
		return this;
	}

	public DwellingConstruction setAnyPortionOfAnyStructureAtThisPropertyLocation(boolean flag)
	{
		sh.clickElement(
		By.xpath(".//*[text() = 'Any lead paint hazard?']/../..//input[@inputvalue = '" +
		String.valueOf(flag) + "']"));
		sh.waitForNoMask();
		return this;
	}

	public DwellingConstruction setBuildingRetrofittedForEarthquakesDescription(String text)
	{
		sh.clickElement(By.xpath("//*[text() = 'Is the building retrofitted for earthquakes?']/../../following-sibling::tr[1]/td[3]/div"));
		sh.waitForElementToAppear(By.name("c2"));
		sh.setText(By.name("c2"),text);

		return this;
	}

	public DwellingConstruction setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription(String text)
	{
		sh.clickElement(By.xpath("//*[text() = 'Was the structure originally built for other than a private residence and then converted?']/../../following-sibling::tr[1]/td[3]/div"));

		sh.waitForElementToAppear(By.name("c2"));
		sh.setText(By.name("c2"),text);

		return this;
	}

	public DwellingConstruction setUncorrectedFireOrBuildingCodeViolationsDescription(String text)
	{
		sh.clickElement(
		By.xpath(".//*[text() = 'Any uncorrected fire or building code violations?']/../../following-sibling::tr[1]/td[3]/div"));
		sh.waitForElementToAppear(By.name("c2"));
		sh.setText(By.name("c2"),text);
		return this;
	}

	public DwellingConstruction setLeadPaintHazardDescription(String text)
	{
		sh.clickElement(
		By.xpath("//*[text() = 'Any lead paint hazard?']/../../following-sibling::tr[1]/td[3]/div"));
		sh.waitForElementToAppear(By.name("c2"));
		sh.setText(By.name("c2"),text);
		return this;
	}
	public DwellingConstruction setScreenEnclosureOnPremises(boolean flag)
	{
		sh.clickElement(By.id(dwellingConstructionBase + "HasScreenedEnclosure_fli_" +  flag + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}

	private void setTextToDescription(String text)
	{
		sh.waitForElementToAppear(By.name("c2"));
		sh.setText(By.name("c2"),text);
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


								// Wind Mitigation
								windMitigation = By.id(tabBase + "WindMitTab-btnInnerEl");




	}


	public class WindMitigation extends CenterPanelBase
	{
		private WindMitigationBy by;
		public WindMitigation(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by = new WindMitigationBy();
		}
		public void setID(Path path)
		{
			switch(path)
			{
				case SUBMISSION:
					windMitigationBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
					tabBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
					break;
				case POLICYRENEWAL:
					windMitigationBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
					tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
					break;
				case POLICYCHANGE:
					windMitigationBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstructionWindMit_fliDV:";
					tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:";
					break;
			}
		}

		public class WindMitigationBy
		{
			final By			discountType = By.id(windMitigationBase + "WindMitDiscountType_fli-inputEl"),
								fortifiedHomeType = By.id(windMitigationBase + "FortifiedHomeType_fli-inputEl"),
								roofShapeType = By.id(windMitigationBase + "RoofShapeType_fli-inputEl"),
								openingProtectionType = By.id(windMitigationBase + "OpeningProtectionType_fli-inputEl"),
								terrain = By.id(windMitigationBase + "TerrainType_fli-inputEl"),
								roofCover = By.id(windMitigationBase + "RoofCoverType_fli-inputEl"),
								roofDeckAttachment = By.id(windMitigationBase + "RoofDeckAttachType_fli-inputEl"),
								roofWallConnection = By.id(windMitigationBase + "RoofWallConnectType_fli-inputEl"),
								secondaryWaterResistanceYes = By.id(windMitigationBase + "IsSecondaryWaterResistance_true-inputEl"),
								secondaryWaterResistanceNo = By.id(windMitigationBase + "IsSecondaryWaterResistance_false-inputEl"),
								roofDeck = By.id(windMitigationBase + "RoofDeckType_fli-inputEl"),
								fbcWindSpeed = By.id(windMitigationBase + "FBCWindSpeedType_fli-inputEl"),
								internalPressure = By.id(windMitigationBase + "InternalPressureType_fli-inputEl"),
								windBorneDebrisYes = By.id(windMitigationBase + "IsWindBorneDebrisRegion_true-inputEl"),
								windBorneDebrisNo = By.id(windMitigationBase + "IsWindBorneDebrisRegion_false-inputEl"),

								dwelling = By.id(tabBase + "DetailsTab-btnInnerEl");
		}
		public Dwelling clickDwelling()
		{
			sh.clickElement(by.dwelling);
			return new Dwelling(sh, path);
		}

		public Coverages next()
		{
			sh.waitForNoMask(15);
			sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
			return new Coverages(sh,path);
		}

		public String getRoofShapeType()
		{
			return sh.getValue(by.roofShapeType);
		}

		public WindMitigation setRoofShapeType(String roofShapeType)
		{
			sh.setText(by.roofShapeType, roofShapeType);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public String getDiscountType()
		{
			return sh.getValue(by.discountType);
		}

		public WindMitigation setDiscountType(String discountType)
		{
			sh.setText(by.discountType, discountType);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public String getFortifiedHomeType()
		{
			return sh.getValue(by.fortifiedHomeType);
		}

		public WindMitigation setFortifiedHomeType(String fortifiedHomeType)
		{
			sh.setText(by.fortifiedHomeType, fortifiedHomeType);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public String getOpeningProtectionType()
		{
			return sh.getValue(by.openingProtectionType);
		}

		public WindMitigation setOpeningProtectionType(String openingProtectionType)
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

		public WindMitigation setTerrain(String terrain)
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

		public WindMitigation setRoofCover(String roofCover)
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

		public WindMitigation setRoofDeckAttachment(String roofDeckAttachment)
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

		public WindMitigation setRoofWallConnection(String roofWallConnection)
		{
			sh.setText(by.roofWallConnection, roofWallConnection);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public WindMitigation clickSecondaryWaterResistance(boolean flag)
		{
			if(flag)
				sh.clickElement(by.secondaryWaterResistanceYes);
			else
				sh.clickElement(by.secondaryWaterResistanceNo);
			sh.waitForNoMask();
			return this;
		}
		public String getRoofDeck()
		{
			return sh.getValue(by.roofDeck);
		}

		public WindMitigation setRoofDeck(String roofDeck)
		{
			sh.setText(by.roofDeck, roofDeck);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public String getFbcWindSpeed()
		{
			return sh.getValue(by.fbcWindSpeed);
		}

		public WindMitigation setFbcWindSpeed(String fbcWindSpeed)
		{
			sh.setText(by.fbcWindSpeed, fbcWindSpeed);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public String getInternalPressure()
		{
			return sh.getValue(by.internalPressure);
		}

		public WindMitigation setInternalPressure(String internalPressure)
		{
			sh.setText(by.internalPressure, internalPressure);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public WindMitigation setWindBorneDebris(boolean flag)
		{
			if(flag)
				sh.clickElement(by.windBorneDebrisYes);
			else
				sh.clickElement(by.windBorneDebrisNo);

			sh.waitForNoMask();
			return this;
		}



	}


}