
package net.javaci.testrock.security;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;


public interface IAuthModel {
	public Roles getRoles();
	public boolean hasAnyRole(Roles roles);
	public boolean hasRole(String role);
}
