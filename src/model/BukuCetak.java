
package model;

public class BukuCetak extends Koleksi implements Terarsip {
    private int jumlahHalaman;
    private String rak;
    private String lantai;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahun,
                     int jumlahHalaman, String rak,
                     String lantai, boolean sedangDiperbaiki) {
        super(kode, judul, tahun);
        this.jumlahHalaman = jumlahHalaman;
        this.rak = rak;
        this.lantai = lantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Buku: "
                + jumlahHalaman + " halaman | "
                + ringkasanArsip();
    }

    @Override
    public String nomorRak() {
        return rak;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai " + lantai;
    }
}
