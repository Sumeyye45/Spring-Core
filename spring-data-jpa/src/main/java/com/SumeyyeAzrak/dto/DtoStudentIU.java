package com.SumeyyeAzrak.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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

}
