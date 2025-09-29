/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.post_test_4_pbo;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;
import service.AnimeService;

public class Main {
    public static void main(String[] args) {
        AnimeService service = new AnimeService();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU AnimeStream.ID ===");
            System.out.println("1. Tambah Anime");
            System.out.println("2. Lihat Daftar Anime");
            System.out.println("3. Ubah Data Anime");
            System.out.println("4. Hapus Anime");
            System.out.println("5. Cari Anime");
            System.out.println("6. Putar Anime");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            while (!input.hasNextInt()) { // validasi input angka
                System.out.print("Input harus angka, coba lagi: ");
                input.next();
            }
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> service.tambahAnime();
                case 2 -> service.lihatAnime();
                case 3 -> service.ubahAnime();
                case 4 -> service.hapusAnime();
                case 5 -> service.cariAnime();
                case 6 -> service.putarAnime();
                case 7 -> System.out.println("Keluar dari program. Terima kasih sudah menggunakan AnimeStream.ID!");
                default -> System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 7);

        input.close();
    }
}
