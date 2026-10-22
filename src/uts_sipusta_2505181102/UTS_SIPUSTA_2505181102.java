
package uts_sipusta_2505181102;

import model.*;
import layanan.*;
import eksepsi.*;
import berkas.EksporKatalog;
import java.io.IOException;

public class UTS_SIPUSTA_2505181102 {

    public static void main(String[] args) {

        KatalogPerpustakaan katalog =
                new KatalogPerpustakaan();

        // Membuat data koleksi
        katalog.tambahKoleksi(new BukuCetak(
                "BK-001", "Java How to Program",
                2022, 620, "A-12", "1", false));

        katalog.tambahKoleksi(new BukuCetak(
                "BK-002", "Basis Data Relasional",
                2021, 410, "B-04", "1", true));

        katalog.tambahKoleksi(new Majalah(
                "MJ-001", "Info Teknologi Edisi 88",
                2026, 88, "Agustus", "C-01", "2", true));

        katalog.tambahKoleksi(new Majalah(
                "MJ-002", "Info Teknologi Edisi 87",
                2026, 87, "Juli", "C-02", "2", false));

        katalog.tambahKoleksi(new BerkasDigital(
                "BD-001", "Panduan Pemrograman Java",
                2024, 15, "unduh.polmed.ac.id/bd001"));

        katalog.tambahKoleksi(new BerkasDigital(
                "BD-002", "Jurnal Rekayasa Perangkat",
                2025, 8, "unduh.polmed.ac.id/bd002"));

        // Menampilkan status koleksi
        katalog.cetakStatus();

        // Mengurutkan koleksi
        System.out.println("\n=== SETELAH DIURUTKAN ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // Menguji peminjaman
        System.out.println("\n=== UJI PEMINJAMAN ===");

        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println("Gagal meminjam: "
                    + e.getMessage());
        }

        try {
            katalog.pinjam("BK-002");
        } catch (PustakaException e) {
            System.out.println("Gagal meminjam: "
                    + e.getMessage());
        }

        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println("Gagal meminjam: "
                    + e.getMessage());
        }

        // Mengekspor katalog ke file teks
        System.out.println("\n=== EKSPOR KATALOG ===");

        try {
            EksporKatalog ekspor = new EksporKatalog();

            ekspor.ekspor(
                    katalog.getDaftarKoleksi(),
                    "katalog.txt");

            System.out.println(
                    "Katalog berhasil disimpan ke katalog.txt");

        } catch (IOException e) {
            System.out.println(
                    "Gagal menyimpan katalog: "
                    + e.getMessage());
        }
    }
}
