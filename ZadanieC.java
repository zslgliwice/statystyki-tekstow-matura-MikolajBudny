import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ZadanieC {
    public static int znajdz(String slowo, String samogloski) {
        int maksymalnaDlugosc = 0;
        int aktualnaDlugosc = 0;

        for (char c : slowo.toCharArray()) {
            if (!samogloski.contains(String.valueOf(c))) {
                aktualnaDlugosc++;
                maksymalnaDlugosc = Math.max(maksymalnaDlugosc, aktualnaDlugosc);
            } else {
                aktualnaDlugosc = 0;
            }
        }

        return maksymalnaDlugosc;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String plik = "tekst.txt";
        String samogloski = "AEIOUY";
        int maksymalnaDlugosc = 0;
        int licznik = 0;
        String pierwszeSlowo = null;

        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] slowa = linia.split(" ");
                for (String slowo : slowa) {
                    int aktualnaDlugosc = znajdz(slowo, samogloski);
                    if (aktualnaDlugosc > maksymalnaDlugosc) {
                        maksymalnaDlugosc = aktualnaDlugosc;
                        licznik = 1;
                        pierwszeSlowo = slowo;
                    } else if (aktualnaDlugosc == maksymalnaDlugosc && aktualnaDlugosc > 0) {
                        licznik++;
                        if (pierwszeSlowo == null) {
                            pierwszeSlowo = slowo;
                        }
                    }
                }
            }
        }

        System.out.println("Najdluzszy ciag spolglosek: " + maksymalnaDlugosc);
        System.out.println("Znalezono slow: " + licznik);
        System.out.println("Pierwsze z nich: " + pierwszeSlowo);
    }
}