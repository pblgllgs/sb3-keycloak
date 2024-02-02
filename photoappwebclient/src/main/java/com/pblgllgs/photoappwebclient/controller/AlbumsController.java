package com.pblgllgs.photoappwebclient.controller;

import com.pblgllgs.photoappwebclient.response.AlbumRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

/*
 *
 * @author pblgl
 * Created on 02-02-2024
 *
 */
@Controller
@Slf4j
public class AlbumsController {

    @Autowired
    OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    @Autowired
    WebClient webClient;

    @GetMapping("/albums")
    public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {

        log.info("Principal: " + principal);

        String url = "http://localhost:8082/albums";


        List<AlbumRest> albums = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<AlbumRest>>() {
                })
                .block();

        model.addAttribute("albums", albums);
        return "albums";
    }

}
