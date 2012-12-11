package net.javaci.testrock.core.dao;

import net.javaci.testrock.core.model.UserModel;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: ekocaman
 * Date: 12/11/12
 */
public interface UserDao extends Dao<UserModel> {

    @Transactional(readOnly = true)
    UserModel findByEmail(String email);
}