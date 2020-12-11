package org.academiadecodigo.bitjs.whitelotus.powerpeople.controller.web;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.user.UserDtoToUser;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.UserDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserDtoToUser dtoToUser;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setDtoToUser(UserDtoToUser dtoToUser) {
        this.dtoToUser = dtoToUser;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"", "/"})
    public String index(Model model) {
        model.addAttribute("userDto", new UserDto());

        return "index";
    }

    @RequestMapping(path = "/charity/volunteer", method = RequestMethod.POST)
    public String insertVolunteer(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("lastAction", "Sorry, something went wrong. Try again!");
            return "index";
        }

        userService.save(dtoToUser.convert(userDto));
        redirectAttributes.addFlashAttribute("lastAction", "Volunteered succesfully! Thank you for your support!");

        return "redirect:/user";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/charity")
    public String charity() {
        return "category";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/charity/food")
    public String charityFood() {
        return "food-category";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/charity/clothes")
    public String charityClothes() {
        return "clothes-category";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/charity/toys")
    public String charityToys() {
        return "toys-category";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String about() {
        return "about-us";
    }
}
