package org.academiadecodigo.bitjs.whitelotus.powerpeople.converters;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.UserDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.User;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToUser implements Converter<UserDto, User> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserDto userDto) {

        User user = (userDto.getId() != null ? userService.get(userDto.getId()) : new User());

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());

        return user;
    }

}