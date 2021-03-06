package org.osiam.addons.administration.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.osiam.addons.administration.controller.AdminController;
import org.osiam.addons.administration.elements.General;

public class SecurityIT extends Integrationtest {

	@Test
	public void no_access_without_valid_access_token() {
		browser.gotoPage(AdminController.CONTROLLER_PATH);

		assertTrue(browser.isLoginPage());
	}

	@Test
	public void access_with_valid_access_token() {
		login();
		browser.gotoPage(AdminController.CONTROLLER_PATH);

		assertFalse(browser.isAccessDenied());
	}

	@Test
	public void logout_current_user(){
		login();
		browser.click(General.LOGOUT_BUTTON);

		assertTrue(browser.getCurrentUrl().contains("/osiam-auth-server/login"));
	}

	private void login() {
		browser.doOauthLogin(ADMIN_USERNAME, ADMIN_PASSWORD);
	}
}
