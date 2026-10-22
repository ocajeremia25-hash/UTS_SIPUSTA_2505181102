
package model;

public class BerkasDigital extends Koleksi {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahun,
                         double ukuranMB, String tautanUnduh) {
        super(kode, judul, tahun);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean layakDipinjam() {
        return true;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Digital: "
                + ukuranMB + " MB | " + tautanUnduh;
    }
}
