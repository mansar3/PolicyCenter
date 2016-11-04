package Helpers;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class SessionInfo
{
	public final String environment;
	public final DesiredCapabilities capabilities;
	public final URL gridHub;
	public SessionInfo(String environment, DesiredCapabilities capabilities, URL gridHub)
	{
		this.environment = environment;
		this.capabilities = capabilities;
		this.gridHub = gridHub;
	}
}