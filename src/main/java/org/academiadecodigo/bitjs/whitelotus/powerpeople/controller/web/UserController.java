package org.academiadecodigo.bitjs.whitelotus.powerpeople.controller.web;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"", "/"})
    public String index() {
        return "index";
    }

}
