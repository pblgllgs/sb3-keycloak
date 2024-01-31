package com.pblgllgs.photos.controller;

import com.pblgllgs.photos.model.PhotoRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
 *
 * @author pblgl
 * Created on 31-01-2024
 *
 */
@RestController
@RequestMapping("/photos")
public class PhotosController {

    @GetMapping
    public List<PhotoRest> getPhotos(){

        PhotoRest photoRest1 = new PhotoRest();
        photoRest1.setAlbumId("album id 1");
        photoRest1.setPhotoId("1");
        photoRest1.setUserId("1");
        photoRest1.setPhotoTitle("photo 1");
        photoRest1.setPhotoDescription("description photo 1");
        photoRest1.setPhotUrl("photo url 1");

        PhotoRest photoRest2 = new PhotoRest();
        photoRest2.setAlbumId("album id 2");
        photoRest2.setPhotoId("2");
        photoRest2.setUserId("2");
        photoRest2.setPhotoTitle("photo 2");
        photoRest2.setPhotoDescription("description photo 2");
        photoRest2.setPhotUrl("photo url 2");

        return Arrays.asList(photoRest1,photoRest2);
    }
}
