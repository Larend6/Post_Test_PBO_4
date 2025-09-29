<img width="1200" height="230" alt="AnimeStream ID" src="https://github.com/user-attachments/assets/a1f86df5-3cd9-46a0-b436-4c1c27d446d1" />

# Post Test PBO 4

Narendra Augusta Srianandha | 2409116010 | SI A'24  

## 📌 Deskripsi Program  

**AnimeStream.ID** adalah aplikasi Java berbasis **Command Line Interface (CLI)** untuk mengelola data anime  
Program ini menerapkan konsep **Object-Oriented Programming (OOP)** meliputi:  

- **Inheritance**  
- **Polymorphism**  
- **Encapsulation**  
- **Interface**  

Pengguna dapat menambahkan anime dengan format **Movie** maupun **Series**, lalu menampilkannya dalam daftar  

---

## 🗂️ Struktur Project 
<img width="407" height="300" alt="image" src="https://github.com/user-attachments/assets/4e46de0b-2b98-4abb-9056-e64980c106b4" />

* **Main.java** → Entry point aplikasi, menampilkan menu utama
* **Anime.java** → Superclass, berisi atribut umum (judul, genre, status)
* **MovieAnime.java** → Subclass Anime, menambahkan atribut durasi
* **SeriesAnime.java** → Subclass Anime, menambahkan atribut episode
* **Playable.java** → Interface untuk fitur "play"
* **AnimeService.java** → Service class untuk menyimpan, mengubah, mencari, dan menghapus anime

---

## 🔄 Alur Program  

1. **Menu Utama**  
   Setelah program dijalankan, pengguna akan melihat menu utama dengan pilihan: Tambah, Lihat, Ubah, Hapus, Cari, Putar, dan Keluar
   <img width="1378" height="227" alt="image" src="https://github.com/user-attachments/assets/ab31b094-5aef-4a97-9d1b-8e4524eba012" />

---

2. **Tambah Anime**  
   - Pilih jenis anime (Movie/Series)
   - Masukkan judul, genre, status, dan atribut tambahan (durasi/episode)
   - Data disimpan ke dalam `ArrayList`
   - Output:
   <img width="1351" height="384" alt="Screenshot 2025-09-29 013828" src="https://github.com/user-attachments/assets/8f0a17e6-67ed-4e59-9d6d-15e11ec1a292" />

---

3. **Lihat Daftar Anime**  
   - Menampilkan semua anime yang tersimpan  
   - Jika kosong, tampil pesan khusus
   - Output:
   <img width="1352" height="341" alt="Screenshot 2025-09-29 013845" src="https://github.com/user-attachments/assets/d76779f4-9274-43e8-b7fa-55eb8f6c1284" />

---

4. **Ubah Data Anime**  
   - Pilih anime berdasarkan nomor urut  
   - Ubah judul, genre, status, atau atribut tambahan
   - Output:
   <img width="1361" height="468" alt="Screenshot 2025-09-29 013858" src="https://github.com/user-attachments/assets/b08b1c8e-e4bc-4869-b445-bc9d2ad50b1d" />
   
   <img width="1352" height="351" alt="Screenshot 2025-09-29 013911" src="https://github.com/user-attachments/assets/c758aa11-cb75-43c2-ab1a-8bbdca10ba6f" />

---

5. **Hapus Data Anime**  
   - Pilih anime berdasarkan nomor urut  
   - Data akan dihapus dari daftar
   - Output:
   <img width="1364" height="413" alt="Screenshot 2025-09-29 013924" src="https://github.com/user-attachments/assets/1367aec7-fc15-44e7-806f-5e876494f327" />

   <img width="1360" height="337" alt="Screenshot 2025-09-29 013934" src="https://github.com/user-attachments/assets/3858ebee-4104-4543-9a7e-057b87cd93d0" />

---

6. **Cari Anime**  
   - Masukkan kata kunci.  
   - Menampilkan anime yang cocok dengan pencarian judul.
   - Output:
   <img width="1366" height="648" alt="Screenshot 2025-09-29 013946" src="https://github.com/user-attachments/assets/46504e0e-bae0-4049-a8e5-00695e5985dc" />

---

7. **Putar Anime**  
   - Memanggil method dari `Playable` untuk menampilkan simulasi memutar anime
   - Output:
   <img width="1357" height="389" alt="Screenshot 2025-09-29 013956" src="https://github.com/user-attachments/assets/e8c3658d-4d20-4ca3-ad09-817067ddcfff" />

---

8. **Keluar Program**  
   - Menampilkan pesan perpisahan dan menghentikan program
   - Output:
   <img width="1365" height="253" alt="Screenshot 2025-09-29 014008" src="https://github.com/user-attachments/assets/25b5e29f-1b0e-4a71-9cd0-e2e640bd1e8e" />

---

## 💡 Konsep OOP yang Digunakan  

- **Inheritance**  
  `MovieAnime` dan `SeriesAnime` mewarisi class `Anime`  
  Kode MovieAnime:
  ```java
  public class MovieAnime extends Anime
  ```
  Kode SeriesAnime:
  ```java
  public class SeriesAnime extends Anime
  ```
  
- **Encapsulation**  
  Atribut di `Anime` diset `private` dengan akses melalui getter & setter
  Contoh kode:
  ```java
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
  ```  

- **Abstraction**  
  - Menggunakan **interface `Playable`** → mendefinisikan method abstrak `play()` tanpa implementasi  
  - Subclass (`MovieAnime` dan `SeriesAnime`) wajib mengimplementasikan `play()` sesuai kebutuhan masing-masing  
  - Hal ini membuat program fleksibel karena semua anime bisa diperlakukan sama (bisa "diputar"), meskipun implementasinya berbeda  

- **Polymorphism**  
  - **Overriding** →  
    * Method `toString()` dioverride di `MovieAnime` dan `SeriesAnime` untuk menampilkan detail sesuai subclass  
    * Method `play()` dari interface `Playable` juga dioverride di tiap subclass dengan perilaku berbeda
    * Kode Overriding
    ```java
    @Override
    public String getInfo() {
        return "Movie Anime: " + getJudul() + " | Genre: " + getGenre() + " | Durasi: " + getDuration() + " Menit" + " | Status: " + getStatus();
    }
    ```
     
  - **Overloading** (jika ada di `AnimeService`) →  
    * Misalnya terdapat lebih dari satu versi method `tambahAnime()` dengan parameter berbeda (contoh: `tambahAnime(MovieAnime anime)` dan `tambahAnime(SeriesAnime anime)`)  
    * Dengan ini, nama method sama tetapi bisa menerima input berbeda  

- **Service Class**  
  `AnimeService` bertugas mengelola daftar anime agar lebih terstruktur (tambah, lihat, ubah, hapus, cari, putar)
  

---

