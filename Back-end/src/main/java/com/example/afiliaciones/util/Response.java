package com.example.afiliaciones.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> implements Serializable {

    public static final long serialVersionUID = 167L;

    private boolean failure;

    private int code;

    private String message;

    private transient T body;

    private String timestamp;
}