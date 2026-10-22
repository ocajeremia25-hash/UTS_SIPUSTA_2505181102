
package model;

public class Majalah extends Koleksi implements Terarsip {
    private int edisi;
    private String bulanTerbit;
    private String rak;
    private String lantai;
    private boolean edisiTerbaru;

    public Majalah(String kode, String judul, int tahun,
                   int edisi, String bulanTerbit,
                   String rak, String lantai,
                   boolean edisiTerbaru) {
        super(kode, judul, tahun);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.rak = rak;
        this.lantai = lantai;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Majalah edisi "
                + edisi + ", " + bulanTerbit
                + " | " + ringkasanArsip();
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
