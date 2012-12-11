
package net.javaci.testrock.security;

import org.apache.wicket.Page;

public interface ISecureApplication {
	Class<? extends Page> getLoginPage();
}
