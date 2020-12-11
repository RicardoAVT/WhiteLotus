package org.academiadecodigo.bitjs.whitelotus.powerpeople.controller.web;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.organization.OrganizationDtoToOrg;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.organization.OrganizationToOrgDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.OrganizationDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Organization;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    //needs a path
    @RequestMapping(method = RequestMethod.GET, path = "")
    public String editOrgProfile(Integer id, Model model){
        model.addAttribute("org", organizationToOrgDto.convert(organizationService.get(id)));
        return "org/edit";
    }

    //needs a path
    @RequestMapping(method = RequestMethod.GET, path = "")
    public String showOrgProfile(Integer id, Model model){
        Organization organization = organizationService.get(id);

        model.addAttribute("org", organizationToOrgDto.convert(organization));

        return "org/show";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveOrganization(OrganizationDto organizationDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "org/edit";
        }

        Organization savedOrg = organizationService.save(organizationDtoToOrg.convert(organizationDto));
        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedOrg.getName());

        //needs path
        return "redirect:/org/";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=cancel")
    public String cancelSaveOrganization(){
        return "redirect:/org/";
    }
}
