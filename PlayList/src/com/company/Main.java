package com.company;

import java.util.*;

public class Main {
    private static final ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("All about Rammstein","Rammstein");
        album.addSong("Du hast",4.04);
        album.addSong("Amerika",3.45);
        album.addSong("Mein herz brennt",5.10);
        album.addSong("Benzin",4.38);
        albums.add(album);

        album = new Album("All about Queen","Queen");
        album.addSong("Bohemian Rhapsody",5.53);
        album.addSong("Somebody to love",5.11);
        album.addSong("The show must go on",4.21);
        album.addSong("We will rock you",3.15);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("Du hast",playlist);
        albums.get(0).addToPlaylist("Benzin",playlist);
        albums.get(0).addToPlaylist(5,playlist); //wrong
        albums.get(1).addToPlaylist("Bohemian Rhapsody",playlist);
        albums.get(1).addToPlaylist("We will rock you",playlist);
        albums.get(1).addToPlaylist(3,playlist);

        play(playlist);
    }

    public static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        
        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next());
        }

        while (!quit) {
            System.out.println("\n Choose:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Playlist has ended");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else {
                        System.out.println("We are at the end!");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start!");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("We are at the finish");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("We are at the beginning");
                        }
                    }
                    break;
                case 4:
                    if (playlist.size() > 0) {
                        listIterator.remove();
                    } else {
                        System.out.println("No more songs!");
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    }
                    break;
                case 5:
                    printPlaylist(playlist);
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n Choose one: \n" +
                        "0 - quit playlist \n" +
                        "1 - next song \n" +
                        "2 - previous song \n" +
                        "3 - replay a song \n" +
                        "4 - delete a song \n" +
                        "5 - Show playlist \n" +
                        "6 - Show menu list\n" );
    }

    public static void printPlaylist(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println(" =============== ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(" =============== ");
    }
}
