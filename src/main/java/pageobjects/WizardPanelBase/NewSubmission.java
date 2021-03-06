package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import Helpers.TableBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

public abstract class NewSubmission<T extends NewSubmission> extends CenterPanelBase
{
	public NewSubmissionBy by;
	public ProductSelectionTable productTable;
	public NewSubmission(CenterSeleniumHelper sh)
	{
		//super();
		this.sh = sh;
		expectedPanelTitle = "New Submissions";
		waitForTitle(sh);
		path = Path.SUBMISSION;
		log("Navigated to page: " + expectedPanelTitle);
		productTable = new ProductSelectionTable(sh);
	}

	public static class NewSubmissionBy{
		final static By	newOrganization = By.id("NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:Producer-inputEl"),
						productSelectionTable = By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV"),
						baseState = By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:StateSelection_fliInputSet:DefaultBaseState-inputEl"),
						selectHomeowners = By.xpath(".//*[@id='NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV-body']//div[text() = 'Homeowners']/../..//a");


	}
	protected String getBaseState()
	{
		return sh.getValue(by.baseState);
	}

	protected T setBaseState(String baseState)
	{
		sh.setText(by.baseState, baseState);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	public class ProductSelectionTable<T extends ProductSelectionTable> extends TableBase
	{
		public ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(by.productSelectionTable, sh);
		}

		protected T clickHomeowners()
		{
//			for(int i = 1; i < sh.driver.findElements(new ByChained(by.productSelectionTable, By.cssSelector("table tr"))).size() + 1; i++)
//			{
//				if(getTextTableElement(i, 2).contains("Homeowners"))
//					clickTableElement(i, 1);
//			}
			sh.clickElement(by.selectHomeowners);
			return (T)this;
		}
		protected T clickCommercialProperty()
		{
			for(int i = 1; i < sh.driver.findElements(new ByChained(by.productSelectionTable, By.cssSelector("table tr"))).size() + 1; i++)
			{
				if(getTextTableElement(i, 2).contains("Commercial Property"))
					clickTableElement(i, 1);
			}
			return (T)this;
		}
	}
}