package com.example.afiliaciones.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "READER")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    @Id
    private String id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "correo")
    @NotEmpty(message = "The email address is required.")
    private String email;

    @Column(name = "contraseña")
    private String password;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Phones> phones;

    @Column(name = "creado")
    private Date created;

    @Column(name = "modificado")
    private Date modified;

    @Column(name = "ultimo")
    private Date lastLogin;

    @Column(name = "token")
    private String token;

    @Column(name = "activo")
    private Boolean isActive;
}
