package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class DwellingConstruction extends CenterPanelBase
{
	private DwellingConstructionBy by;
	private CenterSeleniumHelper sh;

	public DwellingConstruction(CenterSeleniumHelper sh)
	{
		this.sh = sh;
	}

	public Dwelling next()
	{
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new Dwelling(sh);
	}

	public DwellingConstruction setRoofYear(String roofYear)
	{
		sh.setText(by.roofYear, roofYear);
		return this;
	}

	public static class DwellingConstructionBy{
		public static final By	roofYear = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:RoofYear_fli-inputEl");
	}
}