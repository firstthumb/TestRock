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
package net.javaci.testrock.web;

import net.javaci.testrock.core.model.UserModel;

public class LoginPage extends AuthBasePage {
	private static final long serialVersionUID = 1L;

	public LoginPage() {
		UserModel userModel = new UserModel();
		add(new LoginPanel("loginPanel", userModel));
	}	
}
