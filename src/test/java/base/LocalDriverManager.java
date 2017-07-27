package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LocalDriverManager
{
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver()
	{
		return webDriver.get();
	}

	public static RemoteWebDriver getRemoteDriver()
	{
		return (RemoteWebDriver) webDriver.get();
	}

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}