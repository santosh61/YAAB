package com.architjn.audiobook.bean;

import java.util.ArrayList;

/**
 * Created by HP on 23-07-2017.
 */

public class AudioBook {
    private final String albumId;
    private final String albumKey;
    private final String albumName;
    private final String artistName;
    private final String albumArt;
    private int status;
    private final long duration;
    private ArrayList<BookChapter> chapters;

    public AudioBook(String albumId, String albumKey, String albumName, String artistName,
                     String albumArt, int status, long duration) {
        this.albumId = albumId;
        this.albumKey = albumKey;
        this.albumName = albumName;
        this.artistName = artistName;
        this.albumArt = albumArt;
        this.status = status;
        this.duration = duration;
    }

    public String getAlbumKey() {
        return albumKey;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public long getDuration() {
        return duration;
    }

    public void setChapters(ArrayList<BookChapter> chapters) {
        this.chapters = chapters;
    }

    public ArrayList<BookChapter> getChapters() {
        return chapters;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
