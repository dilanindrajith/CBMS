package com.cbms.testing;

import org.junit.Test;

import com.cbms.web.login.LoginBean;

import junit.framework.TestCase;

public class LoginBeanTest extends TestCase {

	@Test
	public void testDoLogin() {
		LoginBean login = new LoginBean();
		assertEquals("/login.xhtml?faces-redirect=true",login.doHome());
	}

	@Test
	public void testDoLogout() {
		LoginBean login = new LoginBean();
		
	}

	@Test
	public void testDoHome() {
		fail("Not yet implemented");
	}

}
