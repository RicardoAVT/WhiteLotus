package org.academiadecodigo.bitjs.whitelotus.powerpeople.controller.web;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.OrgLoginDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/login")
public class LoginController {

    private OrganizationService organizationService;

    @Autowired
    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String checkCredentials(HttpSession session, @Valid OrgLoginDto orgLoginDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            //send same page to show errors
            return "";
        }

        Integer orgId = organizationService.authenticate(orgLoginDto.getEmail(),/*adicionar hashCode aqui*/ orgLoginDto.getPassword());

        if (orgId == null) {
            //adicionar erro ao binding result
            ObjectError objectError = new ObjectError("invalid", "Email and/or password incorrect!");
            bindingResult.addError(objectError);
            return "";
        }

        //adicionar o orgId a session
        session.setAttribute("orgId", orgId);

        return "";
    }
}
