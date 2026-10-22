
package layanan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Koleksi;
import eksepsi.PustakaException;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;

public class KatalogPerpustakaan {

    private List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public void cetakStatus() {
        System.out.println("\n=== STATUS KATALOG PERPUSTAKAAN ===");

        for (Koleksi koleksi : daftarKoleksi) {
            System.out.println(koleksi.deskripsi());

            if (koleksi.layakDipinjam()) {
                System.out.println("Status: Layak dipinjam");
            } else {
                System.out.println("Status: Tidak layak dipinjam");
            }

            System.out.println("----------------------------------------");
        }
    }

    public void urut(Comparator<Koleksi> aturan) {
        daftarKoleksi.sort(aturan);
    }

    public void pinjam(String kode)
            throws PustakaException {

        Koleksi ditemukan = null;

        for (Koleksi koleksi : daftarKoleksi) {
            if (koleksi.getKodeKoleksi().equals(kode)) {
                ditemukan = koleksi;
                break;
            }
        }

        if (ditemukan == null) {
            throw new PustakaException(
                    "Koleksi dengan kode " + kode + " tidak ditemukan.");
        }

        if (ditemukan.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(
                    "Koleksi sedang dipinjam orang lain.");
        }

        if (!ditemukan.layakDipinjam()) {
            throw new KoleksiTidakLayakException(
                    "Koleksi belum layak dipinjam saat ini.");
        }

        ditemukan.setSedangDipinjam(true);

        System.out.println(
                "Peminjaman berhasil: " + ditemukan.getJudul());
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }
}
