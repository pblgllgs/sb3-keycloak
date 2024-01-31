package com.pblgllgs.albums.controller;
/*
 *
 * @author pblgl
 * Created on 31-01-2024
 *
 */

import com.pblgllgs.albums.model.AlbumRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    @GetMapping
    public List<AlbumRest> getAlbums(){

        AlbumRest albumRest1 = new AlbumRest();
        albumRest1.setAlbumId("album id 1");
        albumRest1.setUserId("1");
        albumRest1.setAlbumTitle("album title 1");
        albumRest1.setAlbumDescription("album description 1");
        albumRest1.setAlbumUrl("album url 1");

        AlbumRest albumRest2 = new AlbumRest();
        albumRest2.setAlbumId("album id 2");
        albumRest2.setUserId("2");
        albumRest2.setAlbumTitle("album title 2");
        albumRest2.setAlbumDescription("album description 2");
        albumRest2.setAlbumUrl("album url 2");

        return Arrays.asList(albumRest1, albumRest2);

    }
}
