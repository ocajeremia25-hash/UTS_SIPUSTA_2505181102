
package berkas;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import model.Koleksi;

public class EksporKatalog {

    public void ekspor(List<Koleksi> daftar,
                       String namaBerkas) throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(
                Path.of(namaBerkas),
                StandardCharsets.UTF_8)) {

            writer.write(String.format(
                    "%-8s | %-35s | %-6s | %-20s",
                    "KODE", "JUDUL", "TAHUN", "STATUS"));
            writer.newLine();

            writer.write(
                    "--------------------------------------------------------------------------");
            writer.newLine();

            for (Koleksi koleksi : daftar) {
                String status = koleksi.layakDipinjam()
                        ? "LAYAK DIPINJAM"
                        : "TIDAK LAYAK";

                writer.write(String.format(
                        "%-8s | %-35s | %-6d | %-20s",
                        koleksi.getKodeKoleksi(),
                        koleksi.getJudul(),
                        koleksi.getTahunTerbit(),
                        status));

                writer.newLine();
            }
        }
    }
}
