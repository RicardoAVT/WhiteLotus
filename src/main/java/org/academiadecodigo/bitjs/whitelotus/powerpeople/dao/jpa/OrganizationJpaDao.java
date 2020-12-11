package org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.jpa;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.OrganizationDao;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Organization;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class OrganizationJpaDao extends GenericJpaDao<Organization> implements OrganizationDao {

    public OrganizationJpaDao() {
        super(Organization.class);
    }

    @Override
    public Integer authenticate(String email, String password) {
        TypedQuery<Organization> query = em.createQuery("SELECT organization.id FROM Organization organization " +
                "where organization.email=:email AND organization.password=:password", Organization.class);

        query.setParameter("email", email);
        query.setParameter("password", password);

        return query.getFirstResult();
    }

    @Override
    public String validate(String email) {
        TypedQuery<Organization> query = em.createQuery("SELECT organization.email " +
                "FROM Organization organization where organization.email=:email", Organization.class);

        query.setParameter("email", email);

        return query.getSingleResult().getEmail();
    }


}
