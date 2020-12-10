package org.academiadecodigo.bitjs.whitelotus.powerpeople.service;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Organization;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.User;

import java.util.List;

public interface OrganizationService {

    Organization get(Integer id);

    Organization save(Organization organization);

    void delete(Integer id);

    List<Organization> list();
}
