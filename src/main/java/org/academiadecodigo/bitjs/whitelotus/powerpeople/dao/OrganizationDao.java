package org.academiadecodigo.bitjs.whitelotus.powerpeople.dao;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.Dao;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Organization;

public interface OrganizationDao extends Dao<Organization> {

    Integer authenticate(String email, String password);

    String validate(String email);
}
