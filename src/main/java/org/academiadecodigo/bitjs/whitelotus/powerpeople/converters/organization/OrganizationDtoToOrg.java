package org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.organization;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.OrganizationDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Organization;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class OrganizationDtoToOrg implements Converter<OrganizationDto, Organization> {

    private OrganizationService organizationService;

    @Autowired
    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    public Organization convert(OrganizationDto orgDto) {
        Organization org = orgDto.getId() != null ? organizationService.get(orgDto.getId()) : new Organization();

        org.setId(orgDto.getId());
        org.setName(orgDto.getName());
        org.setEmail(orgDto.getEmail());
        org.setPhone(orgDto.getPhone());

        return org;
    }
}
