package org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto;

import org.hibernate.validator.constraints.URL;

import javax.servlet.annotation.WebFilter;
import javax.validation.constraints.*;

public class OrganizationDto {

    private Integer id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String name;

    @NotNull(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Min(9)
    private String password;

    @Email
    @NotNull(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number contains invalid characters")
    @Size(min = 9, max = 16)
    private String phone;

    @URL
    private String website;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "OrganizationForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
