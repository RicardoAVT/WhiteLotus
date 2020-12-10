package org.academiadecodigo.bitjs.whitelotus.powerpeople.service;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.User;

import java.util.List;

public interface UserService {

    User get(Integer id);

    User save(User user);

    void delete(Integer id);

    List<User> list();
}
