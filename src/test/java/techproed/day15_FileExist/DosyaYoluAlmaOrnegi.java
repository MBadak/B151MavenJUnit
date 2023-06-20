package techproed.day15_FileExist;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class DosyaYoluAlmaOrnegi {

    public static void main(String[] args) {
        String klasorYolu = "C:\\Users\\M\\Desktop/GitProjects";

        try {
            Stream<Path> dosyaYollari = Files.walk(Paths.get(klasorYolu));

            dosyaYollari.forEach(dosyaYolu -> {
                System.out.println(dosyaYolu.toString());
            });

            dosyaYollari.close();
        } catch (IOException e) {
            System.out.println("Dosya yolu alma hatası: " + e.getMessage());
        }
    }
}