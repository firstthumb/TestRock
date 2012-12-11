
package net.javaci.testrock.core.dao;

import net.javaci.testrock.core.model.UserModel;
import org.hibernate.criterion.Restrictions;


public class UserDaoImpl
		extends AbstractHibernateDaoImpl<UserModel>
		implements UserDao {

	public UserDaoImpl() {
		super(UserModel.class);
	}

	@Override
	public UserModel findByEmail(String email) {
		return getCriteriaUnique(Restrictions.eq(UserModel.EMAIL, email));
	}
}
