/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.Scanner;
import model.Anime;
import model.MovieAnime;
import model.Playable;
import model.SeriesAnime;

public class AnimeService {
    private ArrayList<Anime> animeList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Create
    public void tambahAnime() {
    System.out.print("Pilih jenis anime (1. Movie / 2. Series): ");
    int jenis = input.nextInt();
    input.nextLine();

    System.out.print("Masukkan judul anime: ");
    String judul = input.nextLine().trim();
    if (judul.isEmpty()) {
        System.out.println("Judul tidak boleh kosong!");
        return;
    }

    System.out.print("Masukkan genre anime: ");
    String genre = input.nextLine().trim();
    if (genre.isEmpty()) {
        System.out.println("Genre tidak boleh kosong!");
        return;
    }

    System.out.print("Masukkan status (On-going/Completed): ");
    String status = input.nextLine().trim();
    if (!(status.equalsIgnoreCase("On-going") || status.equalsIgnoreCase("Completed"))) {
        System.out.println("Status harus 'On-going' atau 'Completed'!");
        return;
    }

    if (jenis == 1) {
        System.out.print("Masukkan durasi movie (menit): ");
        int duration = input.nextInt();
        input.nextLine();
        animeList.add(new MovieAnime(judul, genre, status, duration));
    } else if (jenis == 2) {
        System.out.print("Masukkan jumlah episode: ");
        int episode = input.nextInt();
        input.nextLine();
        animeList.add(new SeriesAnime(judul, genre, status, episode));
    } else {
        System.out.println("Pilihan jenis tidak valid!");
        return;
    }

    System.out.println("Anime berhasil ditambahkan!");
}
    
    // Read
    public void lihatAnime() {
        if (animeList.isEmpty()) {
            System.out.println("Belum ada anime dalam daftar.");
        } else {
            System.out.println("=== Daftar Anime ===");
            for (int i = 0; i < animeList.size(); i++) {
                System.out.println((i + 1) + ". " + animeList.get(i));
            }
        }
    }

    // Update
    public void ubahAnime() {
        lihatAnime();
        if (animeList.isEmpty()) return;

        System.out.print("Masukkan nomor anime yang ingin diubah: ");
        int idx = input.nextInt();
        input.nextLine();
        if (idx < 1 || idx > animeList.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        Anime anime = animeList.get(idx - 1);

        System.out.print("Judul baru (kosongkan jika tidak diubah): ");
        String judul = input.nextLine();
        if (!judul.isEmpty()) anime.setJudul(judul);

        System.out.print("Genre baru (kosongkan jika tidak diubah): ");
        String genre = input.nextLine();
        if (!genre.isEmpty()) anime.setGenre(genre);

        System.out.print("Status baru (kosongkan jika tidak diubah): ");
        String status = input.nextLine();
        if (!status.isEmpty()) anime.setStatus(status);

        System.out.println("Data anime berhasil diubah!");
    }

    // Delete
    public void hapusAnime() {
        lihatAnime();
        if (animeList.isEmpty()) return;

        System.out.print("Masukkan nomor anime yang ingin dihapus: ");
        int idx = input.nextInt();
        input.nextLine();
        if (idx < 1 || idx > animeList.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        animeList.remove(idx - 1);
        System.out.println("Anime berhasil dihapus!");
    }

    // Search
    public void cariAnime() {
        System.out.print("Masukkan judul anime yang dicari: ");
        String keyword = input.nextLine().toLowerCase();
        boolean ditemukan = false;

        for (Anime anime : animeList) {
            if (anime.getJudul().toLowerCase().contains(keyword)) {
                System.out.println(anime);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Anime tidak ditemukan.");
        }
    }
    
    public void putarAnime() {
    Scanner scanner = new Scanner(System.in);

    if (animeList.isEmpty()) {
        System.out.println("Daftar anime kosong!");
        return;
    }

    lihatAnime();
    System.out.print("Pilih nomor anime yang ingin diputar: ");
    int index = scanner.nextInt() - 1;
    scanner.nextLine();

    if (index >= 0 && index < animeList.size()) {
        Anime anime = animeList.get(index);

        if (anime instanceof Playable) {
            ((Playable) anime).play();
        } else {
            System.out.println("Anime ini tidak bisa diputar.");
        }
    } else {
        System.out.println("Nomor anime tidak valid!");
    }
    
    }
}