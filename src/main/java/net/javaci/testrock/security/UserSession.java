
package net.javaci.testrock.security;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public final class UserSession<T extends IAuthModel> extends WebSession implements IUserSession<T> {

	private static final long serialVersionUID = 1L;

	// default user, ex. AnonymousUser
	final protected T defaultUser;
	// current user
	protected T user;

    public UserSession(Request request, T defaultUser) {
        super(request);

        if (defaultUser == null) {
			throw new IllegalArgumentException("Default user cannot be null");
		}

        this.defaultUser = defaultUser;
        setUser(defaultUser);
    }

    @Override
	public T getUser() {
        return user;
    }

    @Override
	public void setUser(T user) {
    	this.user = user;
    }

    @Override
    public void invalidate() {
    	super.invalidate();
    	setUser(defaultUser);
    }
}
