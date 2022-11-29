package com.example.afiliaciones.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PHONES")
@Getter
@Setter
@NoArgsConstructor
public class Phones {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "numero")
    private long  number;

    @Column(name = "codigo_ciudad")
    private int cityCode;

    @Column(name = "codigo_pais")
    private int contryCode;


}
