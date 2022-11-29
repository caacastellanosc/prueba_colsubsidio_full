package com.example.afiliaciones.service;

import com.example.afiliaciones.dto.UserDto;
import com.example.afiliaciones.entity.User;
import com.example.afiliaciones.exception.UserException;
import com.example.afiliaciones.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private TokenService tokenServiceImpl;

    @Autowired
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
     void shouldSaveUser() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        UserDto user = mapper.readValue(this.readJsonURL("payload/user-request.json"), UserDto.class);

        User userFinal = mapper.readValue(this.readJsonURL("payload/user.json"), User.class);

        Mockito.when(userRepository.findByEmail(Mockito.any())).thenReturn(null);
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(userFinal);
        Assertions.assertEquals( userService.registerUser(user),userFinal);
    }

    @Test
     void shouldSaveUserCreatedEx() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        UserDto user = mapper.readValue(this.readJsonURL("payload/user-request.json"), UserDto.class);
        User userFinal = mapper.readValue(this.readJsonURL("payload/user.json"), User.class);

        Mockito.when(userRepository.findByEmail(Mockito.any())).thenReturn(userFinal);
        Assertions.assertThrows(UserException.class,() -> userService.registerUser(user));
    }

    private String readJsonURL(String url) throws IOException, URISyntaxException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        return Files.lines(Paths.get(Objects.requireNonNull(loader.getResource(url)).toURI())).parallel()
                .collect(Collectors.joining());
    }
}