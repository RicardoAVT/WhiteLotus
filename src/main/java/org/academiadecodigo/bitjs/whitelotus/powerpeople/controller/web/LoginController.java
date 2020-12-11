package org.academiadecodigo.bitjs.whitelotus.powerpeople.controller.web;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.OrgLoginDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.OrganizationDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String showLogin(Model model) {
        model.addAttribute("orgDto", new OrgLoginDto());

        return "login";
    }

    @RequestMapping(path = {"/", ""}, method = RequestMethod.POST)
    public String checkCredentials(HttpSession session, @Valid OrgLoginDto orgLoginDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            //send same page to show errors
            return "login";
        }

        Integer orgId = organizationService.authenticate(orgLoginDto.getEmail(),/*adicionar hashCode aqui*/ orgLoginDto.getPassword());

        if (orgId == null) {
            //adicionar erro ao binding result
            return "login";
        }

        //adicionar o orgId a session
        session.setAttribute("orgId", orgId);

        return "redirect:/user";
    }
}
