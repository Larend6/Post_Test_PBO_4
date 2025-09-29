/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class MovieAnime extends Anime implements Playable {
    private int duration;

    public MovieAnime(String judul, String genre, String status, int duration) {
        super(judul, genre, status);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

     // Overriding abstract method
    @Override
    public String getInfo() {
        return "Movie Anime: " + getJudul() + " | Genre: " + getGenre() + " | Durasi: " + getDuration() + " Menit" + " | Status: " + getStatus();
}

    // Implementasi interface
    @Override
    public void play() {
        System.out.println("Now playing movie: " + getJudul() + " (" + duration + " mins)");
    }
    
    @Override
    public String toString() {
        return getInfo();
    }
}