
package model;

public abstract class Koleksi {
    private String kodeKoleksi;
    private String judul;
    private int tahunTerbit;
    private boolean sedangDipinjam;

    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    public abstract boolean layakDipinjam();

    public String deskripsi() {
        return String.format("%-6s | %-32s | %4d",
                kodeKoleksi, judul, tahunTerbit);
    }

    public String getKodeKoleksi() {
        return kodeKoleksi;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }
}
