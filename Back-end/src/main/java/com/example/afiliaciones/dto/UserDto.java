package com.example.afiliaciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    @NotEmpty(message = "The email address is required.")
    @Email(message = "Email no cumple con un formato valido",flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;

    @JsonProperty("password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message="Contraseña no cumple con un formato valido")
    private String password;

    @JsonProperty("phones")
    private List<PhonesDto> phones;

}
