package com.SumeyyeAzrak.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "First name alanı boş bırakılamaz.")
    @NotNull(message = "FirstName alanı  null olamaz.")
    @Min(value = 3, message = "firstname min 3 karakter olamlıdır.")
    @Max(value = 10)
    private String firstName;

    @Size(min = 3, max = 20)
    private String lastName;

    private Date birthOfDate;
    @Email(message = "Email formatında değer girin.")
    private String email;

    @Size(min = 11, max = 11, message = "tckn alanı 11 karakter olmalıdır. ")
    @NotEmpty(message = "tckn alanı boş geçilemez.")
    private String tckn;



    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }
}
