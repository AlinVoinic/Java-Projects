package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private final String name;
    private final String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Song findSong(String name) {
        for (Song checkSong : this.songs) {
            if (checkSong.getTitle().equals(name)) {
                return checkSong;
            }
        }
        return null;
    }

    public void addSong(String name, double duration) {
        if (findSong(name) == null) {
            this.songs.add(new Song(name, duration));
        }
    }

    public void addToPlaylist(int track, LinkedList<Song> playlist) {
        int index = track - 1;
        if (index >= 0 && index < this.songs.size()) {
            playlist.add(this.songs.get(index));
            return;
        }
        System.out.println("Album does not have a track " + track);
    }

    public void addToPlaylist(String name, LinkedList<Song> playlist) {
        Song song = findSong(name);
        if (song != null) {
            playlist.add(song);
            return;
        }
        System.out.println("Song " + name + " could not be added.");
    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public Song findSong(String name) {
            for (Song checkSong : this.songs) {
                if (checkSong.getTitle().equals(name)) {
                    return checkSong;
                }
            }
            return null;
        }

        public Song findSong(int track) {
            int index = track - 1;
            if (index >= 0 && index < this.songs.size()) {
                return this.songs.get(index);
            }
            return null;
        }

        public boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            return this.songs.add(song);
        }
    }
}
