package org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.organization;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.AbstractConverter;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.OrganizationDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationToOrgDto extends AbstractConverter<Organization, OrganizationDto> {

    @Override
    public OrganizationDto convert(Organization organization) {
        OrganizationDto orgDto = new OrganizationDto();

        orgDto.setId(organization.getId());
        orgDto.setName(organization.getName());
        orgDto.setEmail(organization.getEmail());
        orgDto.setPhone(organization.getPhone());

        return orgDto;
    }
}
