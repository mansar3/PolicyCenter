package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import Helpers.TableBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

public class NewSubmission extends CenterPanelBase
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
		System.out.println("Navigated to page: " + expectedPanelTitle);
		productTable = new ProductSelectionTable(sh);
	}

	public static class NewSubmissionBy{
		final static By	newOrganization = By.id("NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:Producer-inputEl"),
						productSelectionTable = By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV");
	}


	public class ProductSelectionTable extends TableBase
	{
		private ProductSelectionTable(CenterSeleniumHelper sh)
		{
			super(by.productSelectionTable, sh);
		}

		public Qualification selectHomeowners()
		{
			for(int i = 1; i < sh.driver.findElements(new ByChained(by.productSelectionTable, By.cssSelector("table tr"))).size() + 1; i++)
			{
				if(getTextTableElement(i, 2).contains("Homeowners"))
					clickTableElement(i, 1);
			}
			return new Qualification(sh,path);
		}
		public Qualification selectCommercialProperty()
		{
			for(int i = 1; i < sh.driver.findElements(new ByChained(by.productSelectionTable, By.cssSelector("table tr"))).size() + 1; i++)
			{
				if(getTextTableElement(i, 2).contains("Commercial Property"))
					clickTableElement(i, 1);
			}
			return new Qualification(sh,path);
		}
	}
}