package com.pblgllgs.resourceserver.controller;
/*
 *
 * @author pblgl
 * Created on 31-01-2024
 *
 */

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @GetMapping
    public Jwt getToken(@AuthenticationPrincipal Jwt jwt) {
        return jwt;
    }
}
