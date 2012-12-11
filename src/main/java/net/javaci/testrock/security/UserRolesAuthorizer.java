
package net.javaci.testrock.security;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;

public class UserRolesAuthorizer implements IRoleCheckingStrategy {
	@Override
	public boolean hasAnyRole(Roles roles) {
		IUserSession<?> authSession = (IUserSession<?>)Session.get();
		IAuthModel user = authSession.getUser();
		return user.hasAnyRole(roles);
	}

}
