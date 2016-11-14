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

	public Coverages next()
	{
		sh.waitForNoMask(5);
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


	public static class DwellingConstructionBy{
		public static final By	roofYear = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:HODwellingConstruction_fliPanelSet:HODwellingConstructionDetailsHOEDV:RoofYear_fli-inputEl"),
								windMitigation = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:WindMitTab-btnInnerEl"),
								roofShapeType = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:RoofShapeType_fli-inputEl");
	}
}