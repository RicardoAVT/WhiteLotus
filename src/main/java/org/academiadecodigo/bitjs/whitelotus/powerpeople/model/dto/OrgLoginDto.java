package org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrgLoginDto {

    @NotBlank(message = "Email is mandatory!")
    @NotNull(message = "Email is mandatory!")
    @Email
    private String email;

    @NotNull(message = "Password is mandatory!")
    @NotBlank(message = "Password is mandatory!")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
