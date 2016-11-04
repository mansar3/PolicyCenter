package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

public class TableBase
{
	protected By tableId;
	protected CenterSeleniumHelper sh;
	public TableBase(By tableId, CenterSeleniumHelper sh){
		this.tableId = tableId;
		this.sh = sh;
	}

	protected By getTableBy(int row, int column)
	{
		return new ByChained(tableId, By.cssSelector("tbody tr:nth-of-type(" +row+ ") td:nth-of-type(" +column+ ")"));
	}

	protected void clickTableElement(int row, int column)
	{
		sh.clickElement(getTableBy(row, column));
	}

	protected String getTextTableElement(int row, int column)
	{
		return sh.getText(getTableBy(row, column));
	}
}