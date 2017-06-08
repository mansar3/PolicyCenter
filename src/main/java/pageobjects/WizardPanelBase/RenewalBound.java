package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 2/14/17.
 */
public class RenewalBound<T extends RenewalBound> extends CenterPanelBase
{
	private RenewalBoundBy by;
	public RenewalBound(CenterSeleniumHelper sh, Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Renewal";
		waitForTitleToContain(sh);
		System.out.println("Navigated to page: " + expectedPanelTitle);
		by = new RenewalBoundBy();

	}
	public class RenewalBoundBy
	{
		String rbBase = "JobComplete:JobCompleteScreen:JobCompleteDV:";
		By	viewYourRenewal = By.id(rbBase + "ViewJob-inputEl"),
			viewYourPolicy = By.id(rbBase + "ViewPolicy-inputEl"),
			goToYourDesktop = By.id(rbBase + "ReturnToDesktop-inputEl");
	}
	public String getTitle()
	{
		By title = By.cssSelector("#centerPanel .g-title");
		return sh.driver.findElement(title).getText();
	}

	// In policy specific classes
	// Next page needs to be instantiated
	// Work in progress.
	public T viewYourPolicy()
	{
		sh.clickElement(by.viewYourPolicy);
		sh.waitForNoMask();
		return (T)this;
	}
	public T viewYourRenewal()
	{
		if(sh.isDisplayed(by.viewYourRenewal))
			sh.clickElement(by.viewYourRenewal);
		return (T)this;
	}
	public T goToYourDesktop()
	{
		sh.clickElement(by.goToYourDesktop);
		return (T)this;
	}



}
