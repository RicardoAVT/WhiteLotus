package org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.jpa;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.UserDao;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserJpaDao extends GenericJpaDao<User> implements UserDao {

    public UserJpaDao() {
        super(User.class);
    }
}
