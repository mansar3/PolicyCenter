package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class Dwelling extends CenterPanelBase
{
	private DwellingBy by;
	public Dwelling(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Dwelling";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + getTitle());
	}

	public DwellingConstruction next()
	{
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new DwellingConstruction(sh);
	}

	public Dwelling setYearBuilt(String yearBuilt)
	{
		sh.setText(by.yearBuilt, yearBuilt);
		return this;
	}

	public Dwelling setDistanceToFireHydrant(String distanceToFireHydrant)
	{
		sh.setText(by.distanceToFireHydrant, distanceToFireHydrant);
		return this;
	}

	public Dwelling setDistanceToFireStation(String distanceToFireStation)
	{
		sh.setText(by.distanceToFireStation, distanceToFireStation);
		return this;
	}

	public static class DwellingBy{
		public static final By	yearBuilt = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:YearBuilt-inputEl"),
								distanceToFireHydrant = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:DistanceToFireHydrant-inputEl"),
								distanceToFireStation = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:DistanceToFireStation-inputEl");
	}
}