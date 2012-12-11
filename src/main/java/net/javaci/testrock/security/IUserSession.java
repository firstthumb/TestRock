
package net.javaci.testrock.security;

public interface IUserSession<T extends IAuthModel> {

	T getUser();

	void setUser(T user);
}
