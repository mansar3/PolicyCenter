package pageobjects;

import Helpers.CenterSeleniumHelper;
import Helpers.SessionInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Logon
{
	String loginURL;
	protected String user,pwd;
	CenterSeleniumHelper sh;

	private By	byUsername = By.cssSelector("[id*=username]>input"),
				byPassword = By.cssSelector("[id*=password]>input"),
				byRememberMe = By.cssSelector("[id*=remember] input"),
				bySubmit	 = By.id("Login:LoginScreen:nonSecuredEnvPanelSet:LoginDV:submit-btnEl");

	public Logon(CenterSeleniumHelper sh, SessionInfo sessionInfo)
	{
		this.sh = sh;

		loginURL = sessionInfo.environment.length() <= 3 ?  "http://10.50.50." + sessionInfo.environment + ":8180/pc/PolicyCenter.do"
		: sessionInfo.environment;

		// AWS URL
		System.out.println("LoginURL set to: " + loginURL);
	}

	public void load()
	{
		sh.getURL(loginURL);
		sh.wait(10).until(ExpectedConditions.visibilityOfElementLocated(byUsername));
	}

	public void isLoaded()
	{
		sh.waitForURLToContain(loginURL, 10);
	}

	public Logon setUsername(String username)
	{
		sh.setText(byUsername, username);
		return this;
	}

	public String getUsername()
	{
		return sh.getValue(byUsername);
	}

	public Logon setPassword(String password)
	{
		sh.setText(byPassword, password);
		return this;
	}

	public String getPassword()
	{
		return sh.getValue(byPassword);
	}

	public Logon clickRememberMe(Boolean expectedCheckedState)
	{
		assert getRememberMe() != expectedCheckedState;
		sh.clickElement(byRememberMe);
		return this;
	}

	public Boolean getRememberMe()
	{
		return sh.getValue(byRememberMe).equals("true");
	}

	public Logon clickLogin()
	{
		sh.clickElement(bySubmit);
		return this;
	}

	public void login(String username, String password)
	{
		user = username;
		pwd = password;
		setUsername(username)
		.setPassword(password)
		.clickLogin();
		// new NavigationBar(sh);
	}
}