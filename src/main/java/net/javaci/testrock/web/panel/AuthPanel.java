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
package net.javaci.testrock.web.panel;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

// show for authenticated users only
@AuthorizeAction(action=Action.RENDER, roles="is_user")
public class AuthPanel extends Panel {
	private static final long serialVersionUID = 1L;

	public AuthPanel(String id) {
		super(id);
		add(new Link<Void>("url_logout") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				getSession().invalidateNow();
				setResponsePage(getApplication().getHomePage());
			}
		});
	}
}
