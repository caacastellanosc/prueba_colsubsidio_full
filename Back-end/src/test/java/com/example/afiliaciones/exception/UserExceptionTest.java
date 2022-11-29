package com.example.afiliaciones.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserExceptionTest {

    @Test
    void instanceOfConsultOfferException() {
        assertThat(new UserException("")).isNotNull();
    }

}
