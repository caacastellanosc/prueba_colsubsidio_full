package com.example.afiliaciones.controller;


import com.example.afiliaciones.dto.UserDto;
import com.example.afiliaciones.entity.User;
import com.example.afiliaciones.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldSaveUser() throws Exception{

        ObjectMapper mapper = new ObjectMapper();

        User userFinal = mapper.readValue(this.readJsonURL("payload/user.json"), User.class);

        Mockito.when(userService.registerUser(Mockito.any())).thenReturn(userFinal);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/usuario/registro")
                .contentType(MediaType.APPLICATION_JSON).content(this.readJsonURL("payload/user-request.json")).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().json(this.readJsonURL("payload/user-response.json")));
    }

    private String readJsonURL(String url) throws IOException, URISyntaxException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        return Files.lines(Paths.get(Objects.requireNonNull(loader.getResource(url)).toURI())).parallel()
                .collect(Collectors.joining());
    }



}