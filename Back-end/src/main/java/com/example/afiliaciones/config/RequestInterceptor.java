package com.example.afiliaciones.config;

import com.example.afiliaciones.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * Clase encargada del interceptor de las peticiones
 */
@Slf4j
@Component
public class RequestInterceptor implements HandlerInterceptor {

    /**
     * tokenService
     */
    private final TokenService tokenService;

    /**
     * Constructor de UserServiceImpl
     *
     * @param tokenService
     */
    public RequestInterceptor(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    /**
     * Método encargado de establecer url no manejadas
     */
    private final List<String> notHandler = Arrays.asList(
            "swagger-ui",
            "registro"
    );

    /**
     * Método encargado de establecer url de swagger para la versión 1
     */
    private final List<String> requiredContainsHandler = Collections.singletonList(
            "/api/usuario"
    );
    /**
     * @see HandlerInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
            String authorization = request.getHeader("Authorization");
            String met = request.getMethod();
            if(met.equals("OPTIONS"))
                return true;

            if (!tokenService.checkToken(authorization==null?"":authorization)
                    && requiredContainsHandler.stream().anyMatch(requestURI::contains)
                    && notHandler.stream().noneMatch(requestURI::contains)) {
                response.getWriter().write("unauthorization");
                response.setStatus(400);
                return false;
            }

        return true;
    }

    /**
     * @see HandlerInterceptor#postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}