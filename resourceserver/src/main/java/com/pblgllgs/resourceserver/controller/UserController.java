package com.pblgllgs.resourceserver.controller;
/*
 *
 * @author pblgl
 * Created on 31-01-2024
 *
 */

import com.pblgllgs.resourceserver.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @GetMapping("/status/check")
    public String scope() {
        return "Working on port: " + env.getProperty("local.server.port");
    }

    @PreAuthorize("hasRole('developer') or #id == #jwt.subject")
//    @Secured("ROLE_developer")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Deleted user with id: " + id + " and Jwt subject " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping("/{id}")
    public UserRest createUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return new UserRest("pbl", "gllgs", "f9026f93-b95f-4927-9bc2-529546723d23");
    }
}
