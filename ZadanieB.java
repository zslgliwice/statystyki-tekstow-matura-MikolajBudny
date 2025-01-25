import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZadanieB {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String plik = "tekst.txt";
        Map<Character, Integer> mapa = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            String linia;
            while ((linia = br.readLine()) != null ) {
                for (char c : linia.replaceAll(" ", "").toCharArray()) {
                    mapa.put(c, mapa.getOrDefault(c, 0) + 1);
                }
            }
        }

        final int wszystkieLitery = mapa.values().stream().mapToInt(Integer::intValue).sum();

        mapa.keySet().stream().sorted().forEach(litera -> {
            int licznik = mapa.get(litera);
            double procent = (licznik * 100.0) / wszystkieLitery;
            System.out.printf("%c: %d (%.2f%%)%n", litera, licznik, procent);
        });
    }
}