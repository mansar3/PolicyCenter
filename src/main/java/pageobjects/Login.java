package pageobjects;

import Helpers.CenterSeleniumHelper;
import Helpers.SessionInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.WizardPanelBase.NavigationBar;

public class Login
{
	String loginURL;
	protected String user,pwd;
	CenterSeleniumHelper sh;

	private By	byUsername = By.id("Login:LoginScreen:nonSecuredEnvPanelSet:LoginDV:username-inputEl"),
				byPassword = By.cssSelector("[id*=password]>input"),
				byRememberMe = By.cssSelector("[id*=remember] input"),
				bySubmit	 = By.id("Login:LoginScreen:nonSecuredEnvPanelSet:LoginDV:submit-btnEl");

	public Login(CenterSeleniumHelper sh, SessionInfo sessionInfo)
	{
		this.sh = sh;
		loginURL = "http://10.50.50." + sessionInfo.environment + ":8180/pc/PolicyCenter.do";
		// AWS URL
//		loginURL = "http://10.0.4." + sessionInfo.environment + ":8180/pc/PolicyCenter.do";
		System.out.println("LoginURL set to: " + loginURL);
	}

	public void load()
	{
		sh.getURL(loginURL);
		sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(byUsername));
	}

	public void isLoaded()
	{
		sh.waitForURLToContain(loginURL, 5);
	}

	public Login setUsername(String username)
	{
		sh.setText(byUsername, username);
		return this;
	}

	public String getUsername()
	{
		return sh.getValue(byUsername);
	}

	public Login setPassword(String password)
	{
		sh.setText(byPassword, password);
		return this;
	}

	public String getPassword()
	{
		return sh.getValue(byPassword);
	}

	public Login clickRememberMe(Boolean expectedCheckedState)
	{
		assert getRememberMe() != expectedCheckedState;
		sh.clickElement(byRememberMe);
		return this;
	}

	public Boolean getRememberMe()
	{
		return sh.getValue(byRememberMe).equals("true");
	}

	public Login clickLogin()
	{
		sh.clickElement(bySubmit);
		return this;
	}

	public NavigationBar login(String username, String password)
	{
		user = username;
		pwd = password;
		setUsername(username)
		.setPassword(password)
		.clickLogin();
		return new NavigationBar(sh);
	}
}