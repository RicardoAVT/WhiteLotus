package org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.jpa;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.OrganizationDao;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Organization;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationsJpaDao extends GenericJpaDao<Organization> implements OrganizationDao {

    public OrganizationsJpaDao() {
        super(Organization.class);
    }
}
