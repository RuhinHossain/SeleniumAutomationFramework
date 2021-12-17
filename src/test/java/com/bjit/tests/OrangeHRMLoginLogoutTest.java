package com.bjit.tests;

import java.util.*;

import com.bjit.annotations.FrameworkAnnotation;
import com.bjit.enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.bjit.pages.OrangeHRMLoginPage;

public final class OrangeHRMLoginLogoutTest extends BaseTest {
	private OrangeHRMLoginLogoutTest() {
	}

	@Test
	@FrameworkAnnotation(author = {"Ruhin","Rohan"}, category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
	public void loginLogoutTest(Map<String, String> data){
		String title = new OrangeHRMLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password"))
				.clickLoginbtn().clickWelcomeLink().clickLogoutLink().getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}

	@Test
	@FrameworkAnnotation(author = {"Ruhin","Rohan"}, category = {CategoryType.REGRESSION, CategoryType.MINIREGRESSION})
	public void newTest(Map<String, String> data) {

		String title = new OrangeHRMLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password"))
				.clickLoginbtn().clickWelcomeLink().clickLogoutLink().getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
	
}
