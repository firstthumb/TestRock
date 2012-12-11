/*******************************************************************************
 * Copyright (c) 2012 Anton Bessonov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Creative Commons
 * Attribution 3.0 License which accompanies this distribution,
 * and is available at
 * http://creativecommons.org/licenses/by/3.0/
 * 
 * Contributors:
 *     Anton Bessonov - initial API and implementation
 ******************************************************************************/
package net.javaci.testrock;

import net.javaci.testrock.core.model.UserAnonymous;
import net.javaci.testrock.core.model.UserModel;
import net.javaci.testrock.security.ISecureApplication;
import net.javaci.testrock.security.UserRoleAuthorizationStrategy;
import net.javaci.testrock.security.UserRolesAuthorizer;
import net.javaci.testrock.security.UserSession;
import net.javaci.testrock.web.HomePage;
import net.javaci.testrock.web.LoginPage;
import net.javaci.testrock.web.RegisterPage;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;


public class WicketApplication extends WebApplication implements ISecureApplication {

	public WicketApplication() {}

	// start page
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	// page for auth
	@Override
	public Class<LoginPage> getLoginPage() {
		return LoginPage.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new UserSession<UserModel>(request, new UserAnonymous());
	}

	protected void initSpring() {
		// Initialize Spring Dependency Injection
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
	}

	@Override
	public void init() {
		initSpring();

		// don't throw exceptions for missing translations
		getResourceSettings().setThrowExceptionOnMissingResource(false);

		// enable ajax debug etc.
		getDebugSettings().setDevelopmentUtilitiesEnabled(true);

		// customized auth strategy
		getSecuritySettings().setAuthorizationStrategy(new UserRoleAuthorizationStrategy(new UserRolesAuthorizer()));

		// make markup friendly as in deployment-mode
		getMarkupSettings().setStripWicketTags(true);

		// page mounts / SEO
		mountPage("/login/", LoginPage.class);
		mountPage("/register/", RegisterPage.class);
    }
}
