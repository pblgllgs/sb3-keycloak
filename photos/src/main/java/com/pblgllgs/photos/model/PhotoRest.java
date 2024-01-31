package com.pblgllgs.photos.model;
/*
 *
 * @author pblgl
 * Created on 31-01-2024
 *
 */

public class PhotoRest {

    private String albumId;
    private String photoId;
    private String userId;
    private String photoTitle;
    private String photoDescription;
    private String photoUrl;

    public PhotoRest() {
    }

    public PhotoRest(String albumId, String photoId, String userId, String photoTitle, String photoDescription, String photoUrl) {
        this.albumId = albumId;
        this.photoId = photoId;
        this.userId = userId;
        this.photoTitle = photoTitle;
        this.photoDescription = photoDescription;
        this.photoUrl = photoUrl;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
