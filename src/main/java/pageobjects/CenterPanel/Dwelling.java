package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Dwelling extends CenterPanelBase
{
	private DwellingBy by;
	protected String dwellingBase;
	public Dwelling(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Dwelling";
		waitForTitle(sh);
		setID(path);
		by = new DwellingBy();
		System.out.println("Navigated to page: " + getTitle());
	}

	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				this.dwellingBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:";
				break;
			case POLICYRENEWAL:
				this.dwellingBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:";
				break;
			case POLICYCHANGE:
				this.dwellingBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:";
				break;

		}
	}

	public DwellingConstruction next()
	{
		sh.waitForNoMask(20);
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new DwellingConstruction(sh,path);
	}

	public Dwelling setYearBuilt(String yearBuilt)
	{
		sh.setText(by.yearBuilt, yearBuilt);
		sh.waitForNoMask();
		return this;
	}
	public String getYearBuilt()
	{
		return sh.getValue(by.yearBuilt);
	}

	public Dwelling setDistanceToFireHydrant(String distanceToFireHydrant)
	{
		sh.waitForNoMask();
		sh.setText(by.distanceToFireHydrant, distanceToFireHydrant);
		if(path != Path.POLICYRENEWAL)
			sh.waitForValue(by.territoryCode,10);

		return this;
	}

	public String getDistanceToFireHydrant()
	{
		return sh.getValue(by.distanceToFireHydrant);
	}


	public Dwelling setDistanceToFireStation(String distanceToFireStation)
	{
		sh.waitForNoMask(5);
		sh.setText(by.distanceToFireStation, distanceToFireStation);
		return this;
	}
	public String getDistanceToFireStation()
	{
		return sh.getValue(by.distanceToFireStation);
	}

	public Dwelling setBCEG(String bceg)
	{
		sh.setText(by.bceg,bceg);
		sh.tab();
		return this;
	}
	public String getBCEG()
	{
		return sh.getValue(by.bceg);
	}

	public Dwelling setProtectionClassCode(String pcc)
	{
		sh.setText(by.protectionClassCode, pcc);
		sh.tab();
		return this;
	}
	public String getProtectionClassCode()
	{
		return sh.getValue(by.protectionClassCode);
	}

	public Dwelling setTerritoryCode(String code)
	{
		sh.setText(by.territoryCode, code);
		if(path != Path.POLICYRENEWAL)
			sh.waitForValue(by.bceg,10);
		return this;
	}
	public String getTerritoryCode()
	{
		return sh.getValue(by.territoryCode);
	}


	public String getLocationName()
	{
		return sh.getValue(by.locationName);
	}

	public Dwelling setLocationName(String locationName)
	{
		sh.setText(by.locationName, locationName);
		sh.tab();
		return this;
	}

	public String getLocalTaxJurisdiction()
	{
		return sh.getValue(by.localTaxJurisdiction);
	}

	public Dwelling setLocalTaxJurisdiction(String localTaxJurisdiction)
	{
		sh.setText(by.localTaxJurisdiction, localTaxJurisdiction);
		return this;
	}

	public String getLocationType()
	{
		return sh.getValue(by.locationType);
	}

	public Dwelling setLocationType(String locationType)
	{
		sh.setText(by.locationType, locationType);
		sh.tab();
		return this;
	}

	public String getDistanceToCoast()
	{
		return sh.getValue(by.distanceToCoast);
	}

	public Dwelling setDistanceToCoast(String distanceToCoast)
	{
		sh.setText(by.distanceToCoast, distanceToCoast);
		return this;
	}

	public String getPurchaseDate()
	{
		return sh.getValue(by.purchaseDate);
	}

	public Dwelling setPurchaseDate(String purchaseDate)
	{
		sh.setText(by.purchaseDate, purchaseDate);
		sh.tab();
		return this;
	}

	public String getPurchasePrice()
	{
		return sh.getValue(by.purchasePrice);
	}

	public Dwelling setPurchasePrice(String purchasePrice)
	{
		sh.setText(by.purchasePrice, purchasePrice);
		return this;
	}

	public String getMarketValue()
	{
		return sh.getValue(by.marketValue);
	}

	public Dwelling setMarketValue(String marketValue)
	{
		sh.setText(by.marketValue, marketValue);
		return this;
	}

	public String getResidenceType()
	{
		return sh.getValue(by.residenceType);
	}

	public Dwelling setResidenceType(String residenceType)
	{
		sh.setText(by.residenceType, residenceType);
		sh.tab();
		return this;
	}

	public String getDwellingUsage()
	{
		return sh.getValue(by.dwellingUsage);
	}

	public Dwelling setDwellingUsage(String dwellingUsage)
	{
		sh.setText(by.dwellingUsage, dwellingUsage);
		sh.tab();
		return this;
	}

	public String getDwellingOccupancy()
	{
		return sh.getValue(by.dwellingOccupancy);
	}

	public Dwelling setDwellingOccupancy(String dwellingOccupancy)
	{
		sh.setText(by.dwellingOccupancy, dwellingOccupancy);
		sh.tab();
		return this;
	}

	public String getHousekeepingCondition()
	{
		return sh.getValue(by.housekeepingCondition);
	}

	public Dwelling setHousekeepingCondition(String housekeepingCondition)
	{
		sh.setText(by.housekeepingCondition, housekeepingCondition);
		sh.tab();
		return this;
	}

	public Dwelling inTheWindpool(boolean flag)
	{
		if(flag)
			sh.clickElement(By.id(dwellingBase + "IsInWindpool_fli_true-inputEl"));
		else
			sh.clickElement(By.id(dwellingBase + "IsInWindpool_fli_false-inputEl"));
		return this;
	}
	public Dwelling ownedByOther(boolean flag)
	{
		if(flag)
			sh.clickElement(By.id(dwellingBase + "IsRiskOwnedByLLC_fli_true-inputEl"));
		else
			sh.clickElement(By.id(dwellingBase + "IsRiskOwnedByLLC_fli_false-inputEl"));
		return this;
	}
	public Dwelling occupiedDaily(boolean flag)
	{
		if(flag)
			sh.clickElement(By.id(dwellingBase + "IsOccupiedDaily_fli_true-inputEl"));
		else
			sh.clickElement(By.id(dwellingBase + "IsOccupiedDaily_fli_false-inputEl"));
		return this;
	}
	public Dwelling selectYesForAllOptions()
	{
		List<WebElement> buttons = sh.driver.findElements(by.allCheckBoxesYes);
		for(WebElement box:buttons)
		{
			sh.waitForNoMask();
			sh.wait(5).until(ExpectedConditions.elementToBeClickable(box));
			box.click();
		}
		return this;
	}

	public Dwelling atInceptionOfPolicyisDeedOwnedByEntity(boolean flag)
	{
		if(flag)
			sh.clickElement(by.ownedByLLCYes);
		else
			sh.clickElement(by.ownedByLLCNo);
		sh.waitForNoMask();
		return this;
	}



	public class DwellingBy{
		//final static String dwellingBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:";


		final By			locationName = By.id(dwellingBase + "HODwellingLocationHOEInputSet:HODwellingLocationInput-inputEl"),
								yearBuilt = By.id(dwellingBase + "YearBuilt-inputEl"),
								distanceToFireHydrant = By.id(dwellingBase + "DistanceToFireHydrant-inputEl"),
								distanceToFireStation = By.id(dwellingBase + "DistanceToFireStation-inputEl"),
								territoryCode = By.id(dwellingBase + "TerritoryCodeInputSet:0:TerritoryCode-inputEl"),
								localTaxJurisdiction = By.id(dwellingBase + "LocalTaxJurisdictionId-inputEl"),
								bceg = By.id(dwellingBase + "BCEG_fli-inputEl"),
								protectionClassCode = By.id(dwellingBase + "HOProtectionClassCode_fli-inputEl"),
								locationType = By.id(dwellingBase + "DwellingLocation-inputEl"),
								distanceToCoast = By.id(dwellingBase + "DistanceToCoast_fli-inputEl"),
								purchaseDate = By.id(dwellingBase + "PurchaseDate_fli-inputEl"),
								purchasePrice = By.id(dwellingBase + "PurchasePrice_fli-inputEl"),
								marketValue = By.id(dwellingBase + "MarketValue_fli-inputEl"),
								residenceType = By.id(dwellingBase + "ResidenceType-inputEl"),
								dwellingUsage = By.id(dwellingBase + "DwellingUsage-inputEl"),
								dwellingOccupancy = By.id(dwellingBase + "Occupancy-inputEl"),
								housekeepingCondition = By.id(dwellingBase + "HousekeepingCondition_fli-inputEl"),
								ownedByLLCYes = By.id(dwellingBase + "IsRiskOwnedByLLC_fli_true-inputEl"),
								ownedByLLCNo = By.id(dwellingBase + "IsRiskOwnedByLLC_fli_false-inputEl"),
								allCheckBoxesYes = By.xpath(".//input[contains(@id, 'true')]");

	}

}