package com.example.afiliaciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhonesDto {

    @JsonProperty("number")
    private long  number;

    @JsonProperty("citycode")
    private int cityCode;

    @JsonProperty("contrycode")
    private int contryCode;


}
