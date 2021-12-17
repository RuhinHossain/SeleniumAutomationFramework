package com.bjit.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bjit.pages.ERPLoginPage;

public final class ERPLoginLogoutTest extends BaseTest {
	private ERPLoginLogoutTest() {
	}

	@Test
	public void loginLogoutTest(String username, String password) {
		String title = new ERPLoginPage().enterUserName(username).enterPassword(password)
				.clickLoginbtn().cliclDailyReportLink().clickcreateBtn().clickAddItem().inputText("Rakuten - Test1").clickAddItem().inputText("Rakuten-test2").getCreatePageTitle();

		Assertions.assertThat(title).isEqualTo("BJIT Ltd.");
	}

	//@Test
	public void newTest(String username, String password) {

		String title = new ERPLoginPage().enterUserName(username).enterPassword(password)
				.clickLoginbtn().cliclDailyReportLink().clickRuhinDropdownLink().clickLogoutLink().getTitle();

		Assertions.assertThat(title).isEqualTo("BJIT Ltd.");
	}
	
	@DataProvider(name="LoginTestDataProvider", parallel=true)
	public Object[][] getData(){
		return new Object[][]{
			{"ruhin.hossain@bjitgroup.com", "mypapaismylife!123"}
		};
	}
}
