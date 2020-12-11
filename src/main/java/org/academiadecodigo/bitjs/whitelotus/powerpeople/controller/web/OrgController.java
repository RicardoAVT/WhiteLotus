package org.academiadecodigo.bitjs.whitelotus.powerpeople.controller.web;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.organization.OrganizationDtoToOrg;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.organization.OrganizationToOrgDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Organization;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrgController {

    private OrganizationService organizationService;
    private OrganizationDtoToOrg organizationDtoToOrg;
    private OrganizationToOrgDto organizationToOrgDto;

    @Autowired
    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Autowired
    public void setOrganizationDtoToOrg(OrganizationDtoToOrg organizationDtoToOrg) {
        this.organizationDtoToOrg = organizationDtoToOrg;
    }

    @Autowired
    public void setOrganizationToOrgDto(OrganizationToOrgDto organizationToOrgDto) {
        this.organizationToOrgDto = organizationToOrgDto;
    }

    /*
    @RequestMapping(method = RequestMethod.GET, path = "")
    public String signUpOrg(@PathVariable Integer id, Model model){
        model.addAttribute("org", organizationToOrgDto.convert(organizationService.get(id)));
        return "org/signup";
    }
*/
    @RequestMapping(method = RequestMethod.GET, path = "")
    public String editOrgProfile(Integer id, Model model){
        model.addAttribute("org", organizationToOrgDto.convert(organizationService.get(id)));
        return "org/edit";
    }


    public String showOrgProfile(Integer id, Model model){
        Organization organization = organizationService.get(id);

        model.addAttribute("org", organizationToOrgDto.convert(organization));

        return "org/show";
    }
}
