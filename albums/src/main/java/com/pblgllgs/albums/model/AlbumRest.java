package com.pblgllgs.albums.model;
/*
 *
 * @author pblgl
 * Created on 31-01-2024
 *
 */

public class AlbumRest {

    private String albumId;
    private String userId;
    private String albumTitle;
    private String albumDescription;
    private String albumUrl;

    public AlbumRest(String albumId, String userId, String albumTitle, String albumDescription, String albumUrl) {
        this.albumId = albumId;
        this.userId = userId;
        this.albumTitle = albumTitle;
        this.albumDescription = albumDescription;
        this.albumUrl = albumUrl;
    }

    public AlbumRest() {
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }
}
