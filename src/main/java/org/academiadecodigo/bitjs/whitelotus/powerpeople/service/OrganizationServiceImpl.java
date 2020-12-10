package org.academiadecodigo.bitjs.whitelotus.powerpeople.service;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.OrganizationDao;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Organization;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationDao organizationDao;

    @Autowired
    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    public Organization get(Integer id) {
        return organizationDao.findById(id);
    }

    @Override
    @Transactional
    public Organization save(Organization organization) {
        return organizationDao.saveOrUpdate(organization);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //excepçoes para ver se essa organização existe

        organizationDao.delete(id);
    }

    @Override
    public List<Organization> list() {
        return organizationDao.findAll();
    }

    @Override
    @Transactional
    public Integer authenticate(String email, String password) {
        return organizationDao.authenticate(email, password);
    }
}
