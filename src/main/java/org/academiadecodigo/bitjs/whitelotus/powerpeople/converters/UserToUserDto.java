package org.academiadecodigo.bitjs.whitelotus.powerpeople.converters;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.UserDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto extends AbstractConverter<User, UserDto> {

    @Override
    public UserDto convert(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(userDto.getLastName());
        userDto.setEmail(userDto.getEmail());
        userDto.setPhone(userDto.getPhone());

        return userDto;
    }
}
